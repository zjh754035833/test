import Vue from 'vue'
import App from './App.vue'
import  'amfe-flexible';
import router from '@/router/index.js'
import Element from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import echarts from 'echarts'
import infiniteScroll from 'vue-infinite-scroll'
import scroll from 'vue-seamless-scroll'
Vue.use(scroll)
Vue.use(infiniteScroll)
Vue.use(Element)
Vue.prototype.$echarts = echarts
Vue.config.productionTip = false
new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
 