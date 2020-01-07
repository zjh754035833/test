<template>
	<div class="loginmain">
		<v-head></v-head>
	<div class="login1">
		<div  class="login1-1">
		<img src="../../static/login1.png" class="img1"/>
		<div class="login2">
			<div style="margin-left: 58px;">
			<div class="login3">Login</div>
			<input class="login4" placeholder="Email" />
			<input class="login5" placeholder="Password" />
			<div class="login6"><span>Sign up</span><span>Forget password</span></div>
			<div class="login7">
				<div>Login</div>
				<div>Or login with</div>
			</div>
			</div>
		</div>
		</div>
	</div>
	</div>
</template>

<script>
import head from '../assembly/head/head.vue';
export default {
	components: {
		'v-head': head,
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
	.login7{
		width: 100%;
		display: flex;
		height: 48px;
		align-items: center;
		margin-top: 15%;
	}
	.login7>div:nth-of-type(2){
	font-size:16px;
	font-weight:400;
	color:rgba(153,153,153,1);
	margin-left: 20%;
	}
	.login7>div:nth-of-type(1){
		width:127px;
		height:48px;
		background:rgba(38,0,120,1);
		font-size:19px;
		font-weight:400;
		text-align: center;
		line-height: 48px;
		color:rgba(255,255,255,1);
	}
	.login6>span:nth-of-type(1){
		font-size:17px;
		font-weight:400;
		color:rgba(38,0,120,1);
		text-decoration: underline;
	}
	.login6>span:nth-of-type(2){
	font-size:16px;
	font-weight:400;
	color:rgba(102,102,102,1);
	}
	.login6{
		margin-top: 10%;
		}
	.login4{
		border: none;
		border-bottom: #c0c0c0 1px solid;
		outline: none;
		font-size:15px;
		height: 17px;
		margin-top: 15%;
		color: rgba(51, 51, 51, 1);
		width:421px;
	}
	.login5{
		border: none;
			margin-top: 20%;
		border-bottom: #c0c0c0 1px solid;
		outline: none;
		font-size:15px;
		height: 17px;
		color: rgba(51, 51, 51, 1);
		width:421px;
	}
	.login3{
		margin-top: 10%;
		width:83px;
		height:38px;
		font-size:32px;
		font-family:SFUIDisplay-Bold,SFUIDisplay;
		font-weight:bold;
		color:rgba(51,51,51,1);
		line-height:38px;
	}
	.login1{
	
	}
	.login1-1{
	display: flex;
		align-items: center;
		justify-content: center;
	left: 0px;
	right: 0px;
	top: 20%;
	bottom: 0px;
	position: absolute;
	height: 75%;
	width: 62.5%;
		margin: 0 auto;
	}
	.img1{
	width: 40%;
	height:100%;
	}
	.login2{
			width: 60%;
			height: 100%;
		background:rgba(255,255,255,1);
	}
	.loginmain{
		width:100%;
		height:100vh;
		background:rgba(69,70,82,1);
	}
</style>
