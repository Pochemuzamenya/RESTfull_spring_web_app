var productApi = Vue.resource('/products{/id}')

Vue.component('product_row', {
  props: ['product'],
  template: '<div><i>({{product.id}})</i> {{product.title}}</div>'
})

Vue.component('product_list', {
  props: ['products'],
  template: '<div><product_row v-for="product in products" :key = "product.id" :product = "product"/></div>',
  created: function(){
    productApi.get().then(result =>
      result.json().then(data =>
        data._embedded.productList.forEach(product => this.products.push(product))
    ))
  }
})

var app = new Vue({
  el: '#app',
  template: '<product_list :products = "products" />',
  data: {
    products: []
  }
})