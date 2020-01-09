import Vue from 'vue'
import App from './App.vue'
import 'amfe-flexible';
import router from '@/router/index.js'

/* import Element from 'element-ui' */
import {
	Input,
	
	
} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

Vue.use(Input);
Vue.config.productionTip = false
new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
