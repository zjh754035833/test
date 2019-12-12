import Vue from 'vue'
import App from './App.vue'
import 'amfe-flexible';
import router from '@/router/index.js'
import echarts from 'echarts'
import {
	Radio,
	Select,
	Option,
	Popover,
	Table,
	TableColumn,
	Dialog,
	Progress,
	Pagination,
	checkbox,
	Dropdown,
	DropdownMenu,
	DropdownItem
	

} from 'element-ui';
Vue.use(Dropdown);
Vue.use(DropdownMenu);
Vue.use(DropdownItem);
Vue.use(echarts);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Radio);
Vue.use(Select);
Vue.use(Option);
Vue.use(Popover);
Vue.use(Dialog);
Vue.use(Progress);
Vue.use(Pagination);
Vue.use(checkbox);
import 'element-ui/lib/theme-chalk/index.css'
import infiniteScroll from 'vue-infinite-scroll'
import scroll from 'vue-seamless-scroll'
Vue.use(scroll)
Vue.use(infiniteScroll)
Vue.config.productionTip = false
new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
