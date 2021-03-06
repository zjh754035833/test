import Vue from 'vue'
import App from './App.vue'
import 'amfe-flexible';
import router from '@/router/index.js'
import echarts from 'echarts'
import lang from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale'

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
	DropdownItem,
	MessageBox,
	Carousel,
	Switch,
	CarouselItem,
	Slider,
	Upload,
	Tooltip,
	Badge,
	Button,
	Input,
	Step,
	Steps,
	Loading,
	Autocomplete
} from 'element-ui';
locale.use(lang)
Vue.prototype.$loading = Loading.service;
Vue.prototype.$alert = MessageBox.alert;
Vue.use(Badge);
Vue.use(Autocomplete);
Vue.use(Button);
Vue.use(Input);
Vue.use(Step);
Vue.use(Switch);
Vue.use(Steps);
Vue.use(Upload);
Vue.use(Dropdown);
Vue.use(Tooltip);
Vue.use(Slider);
Vue.use(DropdownMenu);
Vue.use(Carousel);
Vue.use(CarouselItem);
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
Vue.prototype.$confirm = MessageBox.confirm;
Vue.config.productionTip = false
new Vue({
	router,
	render: h => h(App)
}).$mount('#app')
