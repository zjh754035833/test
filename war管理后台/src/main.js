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
	Dialog,
	DatePicker,
	Menu,
	Submenu,
	MenuItem,
	MenuItemGroup,
	Table,
	TableColumn,
	Button,
	ButtonGroup,
	Loading

} from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

//Vue.use(Element)
Vue.use(Loading.directive);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Menu);
Vue.use(Submenu);
Vue.use(MenuItem);
Vue.use(MenuItemGroup);
Vue.use(DatePicker)
Vue.use(Pagination)
Vue.use(Upload);
Vue.use(Input);
Vue.use(Radio);
Vue.use(Dialog);
Vue.use(Button);
Vue.use(ButtonGroup);
Vue.prototype.$loading = Loading.service;
Vue.prototype.$alert = MessageBox.alert;
Vue.prototype.$confirm = MessageBox.confirm;
Vue.prototype.$prompt = MessageBox.prompt;

Vue.config.productionTip = false
new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
