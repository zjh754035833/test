<template>
	<div class="loginmain">
		<v-head></v-head>
		<el-dialog title="" :visible.sync="dialogTableVisible" width="30%" top="0" >
		<div style="margin-top: 20px;">
			Account is not activated, please ensure that your account has been activated in the registered email
		</div>
		<div style="display: flex;justify-content: center;"><el-button type="primary" class="anniu" @click="okis()">OK</el-button>
		</div>
		<div style="width: 70%;margin-left: 15%;margin-top: 10px;">If you cannot receive the activation email, you can try to send it again
		<br/>-><span class="sendactivation" @click="fornewemail()">Resend again</span> </div>
		</el-dialog>
		<div class="login1">
			
			<div class="login1-1">
				<img src="../../static/login1.png" class="img1" />
				<div class="login2">
					<div style="margin-left: 58px;">
						<div class="login3 ">Login</div>
						<div class="login4"><el-input placeholder="Email" v-model="usernameval"></el-input></div>
						<div class="login5"><el-input placeholder="password" v-model="passwordwal" show-password></el-input></div>

						<div class="login6"><span @click="forsign" class="shou">Sign up</span></div>
						<div class="login6" style="	margin-left: 60px;"><span @click="forgetPassword" class="shou">forget Password?</span></div>
							<div style="display: flex;margin-top: 5%;" v-if="sendsty==true">
								<el-input placeholder="Email" v-model="newemailval" class="newemail">
								</el-input>
								<el-button type="primary shou newbutton" @click="forsend">SendEmail</el-button>
							</div>

						<div class="login7"><div @click="forlogin" class="shou">Login</div></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import https from '../https.js';
import head from '../assembly/head/head.vue';
export default {
	components: {
		'v-head': head
	},
	data() {
		return {
			usernameval: '',
			passwordwal: '',
			sendsty:false,
			newemailval:'',
			dialogTableVisible:false
		};
	},
	computed: {},
	mounted() {
		if ((localStorage.getItem('token') != '') & (localStorage.getItem('token') != null)) {
			this.$router.push({ path: '/' });
		}
	},
	methods: {
		fornewemail(){
			let params = { email: this.usernameval };
			https
				.fetchGet('/Message/rendEmail', params)
				.then(data => {
					window.console.log(data.data);
					if(data.data=="ok"){
						this.$alert('Successful activation', {
							confirmButtonText: 'OK'
						});
					}else if(data.data=="exceed"){
						this.$alert("The number of triggering emails received within 24 hours has exceeded the limit", {
							confirmButtonText: 'OK'
						});
					}
					else{
						this.$alert('fail in send', {
							confirmButtonText: 'OK'
						});
					}
				})
				.catch(err => {
					window.console.log(err);
				});
		},
		okis(){
			this.dialogTableVisible=false
		},
		forgetPassword(){
			this.sendsty=!this.sendsty
		},
		forsend(){
			let params = { email: this.newemailval };
			https
				.fetchGet('/Message/changePwdEmail', params)
				.then(data => {
					window.console.log(data.data);
					if(data.data=="ok"){
						this.$alert('Reset password email has been sent to your e-mail', {
							confirmButtonText: 'OK'
						});
					}else{
						this.$alert("Please enter the correct email to resend", {
							confirmButtonText: 'OK'
						});
					}
				})
				.catch(err => {
					window.console.log(err);
				});
		},
		forsign() {
			this.$router.push({ path: '/Sigin' });
		},
		forlogin() {	
			let params = { username: this.usernameval, password: this.passwordwal };
			https
				.fetchPost('account/signIn', JSON.stringify(params))
				.then(data => {
					window.console.log(data.data.msg);
					if ((data.data.token != '') & (data.data.token != null)) {
						localStorage.setItem('token', data.data.token);
						location.reload();
					}else if(data.data.msg=="not"){
						this.dialogTableVisible=true
					}
					else {
						this.$alert(data.data.msg, {
							confirmButtonText: 'OK'
						});
						return false;
					}
				})
				.catch(err => {
					window.console.log(err);
				});
			/* localStorage.setItem('token',"1"); 
			this.$router.push({ path: '/' }) */
		}
	},
	created() {}
};
</script>

<style scoped="scoped">
	.sendactivation{
		color: #0000FF;
		text-decoration: underline;
		cursor: pointer;
	}
	.anniu {
		width: 120px;
		height: 40px;
		font-size: 16px;
		margin-top: 30px;
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
	
	.newbutton{
		display: inline-block;
	}
/deep/.el-input__inner {
	border: none;
	border-bottom: #c0c0c0 1.5px solid;
	outline: none;
	font-size: 15px;
	border-radius: 0px;
	color: rgba(51, 51, 51, 1);
}
/deep/.el-input--suffix .el-input__inner {
	border: none;
	border-bottom: #c0c0c0 1.5px solid;
	outline: none;
	font-size: 15px;
	border-radius: 0px;
	color: rgba(51, 51, 51, 1);
}
.login7 {
	width: 100%;
	display: flex;
	height: 48px;
	align-items: center;
	margin-top: 15%;
}

.login7 > div:nth-of-type(2) {
	font-size: 16px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	margin-left: 20%;
}
.login7 > div:nth-of-type(1) {
	width: 127px;
	height: 48px;
	background: rgba(38, 0, 120, 1);
	font-size: 19px;
	font-weight: 400;
	text-align: center;
	line-height: 48px;
	color: rgba(255, 255, 255, 1);
}
.login6 > span:nth-of-type(1) {
	font-size: 17px;
	font-weight: 400;
	color: rgba(38, 0, 120, 1);
	text-decoration: underline;
}
.login6 > span:nth-of-type(2) {
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.login6 {
	display: inline-block;
	margin-top: 10%;
}
.sendemail {
	width: 100px;
	height: 50px;
	text-align: center;
	line-height: 50px;
}
.newemail {
	
	border: none;
	display: inline-block;
	border-bottom: #c0c0c0 1.5px solid;
	outline: none;
	font-size: 15px;
	height: 17px;
	color: rgba(51, 51, 51, 1);
	width: 300px;
}
.login4 {
	border: none;
	border-bottom: #c0c0c0 1.5px solid;
	outline: none;
	font-size: 15px;
	height: 17px;
	margin-top: 10%;
	color: rgba(51, 51, 51, 1);
	width: 421.5px;
}
.login5 {
	border: none;
	outline: none;
	border-bottom: #c0c0c0 1.5px solid;
	margin-top: 15%;
	font-size: 15px;
	height: 17px;
	color: rgba(51, 51, 51, 1);
	width: 421.5px;
}
.login3 {
	margin-top: 10%;
	font-size: 32px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	line-height: 38px;
}
.login1 {
	z-index: -10;
}
.login1-1 {
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
.img1 {
	width: 40%;
	height: 100%;
}
.login2 {
	width: 60%;
	height: 100%;
	background: rgba(255, 255, 255, 1);
}
.loginmain {
	width: 100%;
	height: 100vh;
	background: rgba(69, 70, 82, 1);
}
</style>
