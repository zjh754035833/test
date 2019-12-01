<template>
	<div>
		<v-sell @pagetype="showsellpagetype"></v-sell>
		<div v-if="pagetype == 1"><v-index @pagetype="showindexpagetype"></v-index></div>
		<div v-if="pagetype == 2"><v-placeabid></v-placeabid></div>
		<div v-if="pagetype == 3"><v-Anctiondetail></v-Anctiondetail></div>
		<v-footer></v-footer>
	</div>
</template>

<script>
/* import storage from '../plugins/localstorage.js'; */
import sell from '../../build/sell/sell.vue';
import footer from '../../build/foot/foot.vue';
import Anctionindex from '../../build/newAnction/Anctionindex.vue';
import placeabid from '../../build/newAnction/placeabid.vue';
import Anctiondetail from '../../build/newAnction/Anctiondetail.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer,
		'v-index': Anctionindex,
		'v-placeabid': placeabid,
		'v-Anctiondetail': Anctiondetail
	},
	data() {
		return {
			pagetype: '1'
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
