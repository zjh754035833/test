<template>
	<div class="ourall">
		<div class="our2">
			<img src="../../static/xy1.png" />
			<a  href="https://austatichost.oss-ap-southeast-2.aliyuncs.com/accmail/Anti-Money%20Laundering%20and%20Counter-Terrorism%20Financing%20.pdf">Anti-Money Laundering and
			Counter-Terrorism Financing Act 2006</a>
			</div>

		<div class="our2">
			
			<img  src="../../static/xy2.png" />
			<a  href="https://austatichost.oss-ap-southeast-2.aliyuncs.com/accmail/US%20Cryptocurrency.pdf">
			Regulations of the Sperintendent of Financial Services..
			</a>
			</div>
		<div class="our2">
			<img src="../../static/xy3.png" />
			<a  href="https://austatichost.oss-ap-southeast-2.aliyuncs.com/accmail/Singapore%20Financing-Recruitment-for-Terrorism.pdf">Monetary Authority of Singapore</a></div>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {};
	},
	computed: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
	},
	created() {}
};
</script>

<style scoped="scoped">
.our1 {
	width: 80%;
	background-image: url('../../static/user1.png');
	background-size: 100%;
}
.ourall{
	display: flex;
	flex-direction: column;
	align-items: center;
}
.our2 {
	display: flex;
	align-items: center;
	width: 80%;
	margin-top: 65px;
	margin-bottom: 60px;
	font-size: 18px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
}
.our2>img:nth-of-type(1){
	margin-right: 100px;
	width: 200px;
	height: 100px;
}
.our2>img:nth-of-type(2){
	margin-right: 100px;
	width: 190px;
	height: 100px;
}
.our2>img:nth-of-type(3){
	margin-right: 100px;
	width: 150px;
	height: 100px;
}
.our3 {
	margin-bottom: 30px;
	width: 862px;
	margin-left: 308px;
	margin-top: 17px;
	font-size: 18px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	line-height: 25px;
}
</style>
