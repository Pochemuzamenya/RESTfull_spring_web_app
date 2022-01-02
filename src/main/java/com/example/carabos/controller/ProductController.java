package com.example.carabos.controller;

import com.example.carabos.entity.Product;
import com.example.carabos.exceptions.ProductNotFoundException;
import com.example.carabos.repository.ProductRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProductController {

    private final ProductRepository repository;

    private final ProductModelAssembler assembler;

    public ProductController(ProductRepository repository, ProductModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/products")
    CollectionModel<EntityModel<Product>> all() {

        List<EntityModel<Product>> products = repository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return assembler.toCollectionModel(products);
    }

    @PostMapping("/products")
    ResponseEntity<?> newProduct(@RequestBody Product newProduct) {

        EntityModel<Product> productEntityModel = assembler.toModel(repository.save(newProduct));

        return ResponseEntity
                .created(productEntityModel
                        .getRequiredLink(IanaLinkRelations.SELF)
                        .toUri()
        )
                .body(productEntityModel);
    }

    @GetMapping("/products/{id}")
    EntityModel<Product> one(@PathVariable Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));

        return assembler.toModel(product);
    }

    @PutMapping("/products/{id}")
    ResponseEntity<?> replaceProduct(@PathVariable Product newProduct,
                                     @PathVariable Long id) {

        Product updateProduct = repository.findById(id)
                .map(product -> {
                    product.setPrice(newProduct.getPrice());
                    product.setTitle(newProduct.getTitle());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });

        EntityModel<Product> productEntityModel = assembler.toModel(updateProduct);

        return ResponseEntity
                .created(productEntityModel
                        .getRequiredLink(IanaLinkRelations.SELF)
                        .toUri())
                .body(productEntityModel);
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity<?> deleteProduct(@PathVariable Long id) {

        repository.deleteById(id);
        return ResponseEntity
                .noContent().build();
    }
}
