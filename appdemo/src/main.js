import Vue from 'vue'
import App from './App.vue'
import 'amfe-flexible';
import router from '@/router/index.js'

/* import Element from 'element-ui' */
import {
	Carousel,
	CarouselItem,
	Dialog,
	Radio,
	RadioGroup,
	RadioButton,
	Select,
	Table,
	TableColumn,
	Input,
	MessageBox,
	Button
} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(Carousel)
Vue.prototype.$alert = MessageBox.alert;
Vue.prototype.$confirm = MessageBox.confirm;
Vue.use(CarouselItem)
Vue.use(Dialog)
Vue.use(Radio)
Vue.use(Button)
Vue.use(Input)
Vue.use(RadioGroup)
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Select);
Vue.use(RadioButton)
Vue.config.productionTip = false
new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
