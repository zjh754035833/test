<template>
	<div>
		<v-head></v-head>
		<img src="../../static/memblist1.png" class="topimg"/>
		<div class="memlist1" style="margin-top: 0px;">
			<div style="margin-top: 38px;position: absolute;">
			<div class="memlist1-1">Blockchain Australia Members</div>
			<div class="memlist1-2"></div>
			<div class="memlist1-3">DIGITAL CURRENCY</div>
			</div>
		</div>
		<div class="memlist1">
			<div style="margin-top: 37px;position: absolute;">
			<div class="memlist1-2" style="margin-top: 0px;"></div>
			<div class="memlist1-3">BLOCKCHAIN SCALE-UP</div>
			</div>
		</div>
		<div class="memlist1">
			<div style="margin-top: 37px;position: absolute;">
			<div class="memlist1-2" style="margin-top: 0px;"></div>
			<div class="memlist1-3">CORPORATE AND ADVISORY</div>
			</div>
		</div>
		<v-foot></v-foot>
		</div>
</template>

<script>
	import head from '../assembly/head/head.vue';
	import foot from '../assembly/foot/foot.vue';
	export default {
		components: {
			'v-head': head,
			'v-foot': foot
		},
		data() {
			return {};
		},
		computed: {},
		mounted() {
			document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
		},
		methods: {},
		created() {}
	};
</script>

<style scoped="scoped">
	.memlist1-1{
		font-size:25px;
		font-weight:500;
		color:rgba(51,51,51,1);
		margin-left: 181px;
	}
	.memlist1-2{
		width:62px;
		height:5px;
		background:rgba(235,235,235,1);
			margin-left: 181px;
			margin-top: 67px;
	}
	.memlist1-3{
		font-size:19px;
		margin-left: 181px;
		font-weight:600;
		color:rgba(153,153,153,1);
		margin-top: 11px;
	}
	.topimg{
		width: 100%;
		}
		.memlist1{
			width: 100%;
			height:520px;
			background:rgba(255,255,255,1);
			border-radius:1px;
			margin-top: 10px;
		}
</style>
