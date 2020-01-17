<template>
	<div>
		<div><v-index></v-index></div>
		<div style="height: 60px;"></div>
	</div>
</template>

<script>
/* import storage from '../plugins/localstorage.js'; */
import Anctionindex from '../../assembly/newAnction/Anctionindex.vue';
export default {
	components: {
		'v-index': Anctionindex,
	},
	data() {
		return {
		};
	},
	methods: {
		showindexpagetype(data) {
			window.console.log(data);
			this.pagetype = data;
		},
		showsellpagetype(data) {
			this.pagetype = data;
		}
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	/* watch: {

	} */
};
</script>

<style></style>
