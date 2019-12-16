import Vue from 'vue'
import App from './App.vue'
import 'amfe-flexible';
import router from '@/router/index.js'

/* import Element from 'element-ui' */
import {
	Input,
	Pagination,
	MessageBox,
	Upload,
	Radio,
	Dialog
	
} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

//Vue.use(Element)
Vue.use(Pagination)
Vue.use(Upload);
Vue.use(Input);
Vue.use(Radio);
Vue.use(Dialog);
Vue.prototype.$alert = MessageBox.alert;
Vue.prototype.$confirm = MessageBox.confirm;
Vue.prototype.$prompt = MessageBox.prompt;
Vue.config.productionTip = false
new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
