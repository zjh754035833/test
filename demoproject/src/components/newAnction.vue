<template>
	<div>
		<v-sell></v-sell>
		<div><v-index></v-index></div>
		<v-footer style="margin-top: 60px;"></v-footer>
	</div>
</template>

<script>
/* import storage from '../plugins/localstorage.js'; */
import sell from '../assembly/sell/sell.vue';
import footer from '../assembly/foot/foot.vue';
import Anctionindex from '../assembly/newAnction/Anctionindex.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer,
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
