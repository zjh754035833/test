import Vue from 'vue'
import App from './App.vue'
import  'amfe-flexible';
import router from '@/router/index.js'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import echarts from 'echarts'
import $ from 'jquery'
 
Vue.use(Element)
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
 