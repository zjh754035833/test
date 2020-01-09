<template>
	<div>
		<v-head></v-head>
		<div class="all">
			<el-input v-model="input" placeholder="Please enter your email to be activated" class="xuanze"></el-input>
			<el-button type="primary" @click="queren" style="margin-top: 20px;">activation</el-button>
		</div>
	</div>
</template>

<script>
import head from '../assembly/head/head.vue';
export default {
	components: {
		'v-head': head
	},
	data() {
		return {
			input: ''
		};
	},
	computed: {},
	mounted() {
		let text = this.$route.params.text;
		window.console.log(text)
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		queren() {}
	},
	created() {}
};
</script>

<style scoped="scoped">
.all {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 100px;
}
.xuanze {
	width: 60%;
}
</style>
