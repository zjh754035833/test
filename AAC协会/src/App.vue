<template>
	<div id="app">
		<v-head v-if="($route.path !== '/login') & ($route.path !== '/Sigin')"></v-head>
		<router-view></router-view>
		<v-foot v-if="($route.path !== '/login') & ($route.path !== '/Sigin')"></v-foot>
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
</style>
<script>
import head from './assembly/head/head.vue';
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
	updated() {
		window.scroll(0, 0);
	},
	methods: {
		
	}
};
</script>
