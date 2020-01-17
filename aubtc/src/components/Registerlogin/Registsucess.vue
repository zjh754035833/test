<template>
	<div>
		<div class="success">
			<img src="../../../static/sucess.png" />
			<div>Account activated</div>
			<div>Congratulations!, the activation email has been sent to your registration email, please login your email and complete the registration by the activation
					email.</div>
			<div @click="forlogin" class="shou">Log ln</div>
		</div>
		<div style="height: 88px;"></div>
	</div>
</template>
<script>
export default {
	components: {
	},
	data() {
		return {};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods:{
		forlogin(){
			this.$router.push({ path: '/login' });
		}
	}
};
</script>
<style scoped="scoped">
.success {
	width: 1169px;
	height: 599px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 48px;
	margin-left: 142px;
	display: flex;
	flex-direction: column;
	align-items: center;
	
}
.success>img{
	width:266px;
	height:209px;
	margin-top: 76px;
}
.success>div:nth-of-type(1){
	font-size:30px;
	font-weight:600;
	color:rgba(51,51,51,1);
	margin-top: 40px;
}
.success>div:nth-of-type(2){
	font-size:18px;
	width: 800px;
	font-weight:600;
	display: flex;
	color:rgba(153,153,153,1);
	margin-top: 9px;
}
.success>div:nth-of-type(3){
	width:534px;
	height:58px;
	background:rgba(41,47,136,1);
	border-radius:1px;
	font-size:22px;
	color:rgba(255,255,255,1);
	line-height:58px;
	text-align: center;
	margin-top: 37px;
}
</style>
