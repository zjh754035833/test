<template>
	<div id="app">
		<v-head v-if="$route.path!=='Generation'&$route.path!=='/login'&$route.path!=='/signup'"></v-head>
		<router-view></router-view>
		<v-foot v-if="$route.path!=='Generation'&$route.path!=='/login'&$route.path!=='/signup'" ></v-foot>
		</div>
</template>

<style>
body {
	margin: 0;
	padding: 0;
	font-size: 20px;
}
.shou {
	cursor: pointer;
}
.toolstyle {
	font-size: 14px;
	font-weight: 600;
	background-color: white !important;
	color:rgba(0,227,170,1) !important;
}
.el-tooltip__popper[x-placement^=top] .popper__arrow:after {
    border-top-color: rgba(0,227,170,1) !important;
}
.el-tooltip__popper[x-placement^=top] .popper__arrow {
    border-top-color: rgba(0,227,170,1) !important;
}
</style>
<script>
	import head from './assembly/sell/sell.vue';
	import foot from './assembly/foot/foot.vue';
	export default {
		data() {
			return {
				login: 'false'
			};
		},
		name: 'app',
		components: {
			'v-head': head,
			'v-foot': foot
		},
		methods: {}
	};
/* export default {
		data(){},
        mounted() {
			window.console.log('init!')
		}
	}; */
</script>
