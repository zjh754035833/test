<template>
	<div>
		<v-head></v-head>
		<div class="our1">
		</div>
		<div class="our2">Our mission</div>
		<div class="our3">
			Association of Australian Cryptocurrency is the industry body that represents Australian businesses and business professionals participating in the digital economy
			through blockchain technology. 
			<br /><br />
			Association of Australian Cryptocurrency aims to encourage the responsible adoption of blockchain technology by industry and governments
			across Australia as a means to drive innovation in service delivery across all sectors of the economy.
		</div>
		<div class="our2">Our mission</div>
		<div class="our3">
			Association of Australian Cryptocurrency is the industry body that represents Australian businesses and business professionals participating in the digital economy
			through blockchain technology. 
			<br /><br />
			Association of Australian Cryptocurrency aims to encourage the responsible adoption of blockchain technology by industry and governments
			across Australia as a means to drive innovation in service delivery across all sectors of the economy.
		</div>
		<v-foot style="margin-top: 90px;"></v-foot>
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
	mounted() {},
	methods: {},
	created() {}
};
</script>

<style scoped="scoped">
.our1 {
	width: 100%;
	height: 68px;
	background-image: url("../../static/memblist1.png");
	background-size: 100%;
}
.our2{
	margin-top: 45px;
	margin-left: 308px;
	font-size:25px;
	font-weight:600;
	color:rgba(51,51,51,1);
}
.our3{
	width:862px;
	height:167px;
	margin-left: 308px;
	margin-top: 17px;
	font-size:18px;
	font-weight:400;
	color:rgba(153,153,153,1);
	line-height:25px;
}
</style>
