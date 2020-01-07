import Vue from 'vue'
import App from './App.vue'
import 'amfe-flexible';
import router from '@/router/index.js'

/* import Element from 'element-ui' */
import {
 Carousel,
  CarouselItem,
} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(Carousel)
Vue.use(CarouselItem)
Vue.config.productionTip = false
new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
