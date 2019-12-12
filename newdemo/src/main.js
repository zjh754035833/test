import Vue from 'vue'
import App from './App.vue'
import 'amfe-flexible';
import router from '@/router/index.js'
/* import Element from 'element-ui' */
import {
	Checkbox,
	CheckboxGroup,
	Input,
	Pagination
} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

//Vue.use(Element)
Vue.use(Pagination)
Vue.use(Checkbox)
Vue.use(CheckboxGroup)
Vue.use(Input);
Vue.config.productionTip = false
new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
