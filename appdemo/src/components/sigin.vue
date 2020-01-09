<template>
	<div class="loginmain">
		<v-head></v-head>
		<el-dialog title="" :visible.sync="dixdiag1" width="60%" top="0" >
			<div class="diag2">
				<div class="diag2-1">Registration is successful, the activation email has been sent to your registration email, please login your email and complete the registration by the activation email.</div>
				<div class="diag2-2 shou" @click="closeit">Confirm</div>
			</div>
		</el-dialog>
	<div class="login1">
		<div  class="login1-1">
		<img src="../../static/login1.png" class="img1"/>
		<div class="login2">
			<div style="margin-left: 58px;">
			<div class="login3">Sign up</div>
			<input class="login6" placeholder="username" maxlength="15" v-model="usernameval"  />
			<input class="login4" placeholder="Email" v-model="emailval" maxlength="40"/>
			<input class="login5" placeholder="Password" type="password" v-model="passwordval" maxlength="50" />
			<input class="login6" placeholder="Confirm password" type="password"  v-model="confimpasswordval" maxlength="50"/>
			<div class="login7 ">
				<div @click="forsignup" class="shou" >Sign up</div>
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
		return {
			usernameval:"",
			emailval:"",
			passwordval:"",
			confimpasswordval:"",
			dixdiag1:false
		};
	},
	computed: {},
	mounted() {},
	methods: {
		closeit(){
			this.dixdiag1=false
		},
		forsignup(){
			let regemal= /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
			var reg=new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
		if(!regemal.test(this.emailval)){
			this.$alert('Incorrect mailbox format', {
				confirmButtonText: 'Determine'
			});
			return false;
		}
		else if (!reg.test(this.passwordval)) {
			this.$alert('The password must consist of numbers and English', {
				confirmButtonText: 'Determine'
			});
			return false;
		}else if(this.passwordval != this.confimpasswordval){
			this.$alert('The two passwords are inconsistent', {
				confirmButtonText: 'Determine'
			});
			return false;
		}
		}
	},
	created() {}
};
</script>

<style scoped="scoped">
	.diag2-2{
		width:278px;
		height:46px;
		background:rgba(38,0,120,1);
		border-radius:1px;
		text-align: center;
		line-height:46px ;
		margin-top: 46px;
		font-size:18px;
		color:rgba(255,255,255,1);
	}
	.diag2{
		display: flex;
		justify-content: center;
		align-items: center;
		margin-top: 100px;
		flex-flow: column;
	}
	.diag2-1{
		width:459px;
		height:81px;
		font-size:17px;
		font-weight:400;
		color:rgba(102,102,102,1);
	}
	/deep/ .el-dialog__header {
		padding: 0;
	}
	
	/deep/.el-dialog__wrapper {
		display: flex;
		align-items: center;
		width: 100%;
		height: 100%;
		position: fixed;
		top: 0;
		right: 0;
		bottom: 0;
		left: 0;
		overflow: auto;
		margin: 0;
	}
	/deep/.el-dialog {
		margin: 0 auto;
	}
	.login7{
		width: 100%;
		display: flex;
		height: 48px;
		align-items: center;
		margin-top: 10%;
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
		border: none;
			margin-top: 10%;
		border-bottom: #c0c0c0 1px solid;
		outline: none;
		font-size:15px;
		height: 17px;
		color: rgba(51, 51, 51, 1);
		width:421px;
		}
	.login4{
		border: none;
		border-bottom: #c0c0c0 1px solid;
		outline: none;
		font-size:15px;
		height: 17px;
		margin-top: 10%;
		color: rgba(51, 51, 51, 1);
		width:421px;
	}
	.login5{
		border: none;
			margin-top: 10%;
		border-bottom: #c0c0c0 1px solid;
		outline: none;
		font-size:15px;
		height: 17px;
		color: rgba(51, 51, 51, 1);
		width:421px;
	}
	.login3{
		margin-top: 10%;
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
