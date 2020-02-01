<template>
	<div class="loginmain">
			<v-head></v-head>
		<el-dialog title="" :visible.sync="dixdiag1" width="60%" top="0">
			<div class="diag2">
				<img src="../../static/sucess.png" style="width: 133px;height:104.5px ;" />
				<div class="diag2-1">
					<!-- Registration successful --><!-- , the activation email has been sent to your registration email, please login your email and complete the registration by the activation
					email. -->
				</div>
				<div class="diag2-2 shou" @click="closeit">Confirm</div>
			</div>
		</el-dialog>
		<div class="login1">
			<div class="login1-1">
				<img src="../../static/login1.png" class="img1" />
				<div class="login2">
					<div style="margin-left: 58px;">
						<div class="login3">Sign up</div>
						<input class="login6" placeholder="username(must contain letters)" maxlength="15" v-model="usernameval" @blur="yzusernameval" @input="inputusernameval" />
						<div class="tishi" v-if="tishi1 == true">User name cannot be empty and must contain letters</div>
						<input class="login4" placeholder="Email" v-model="emailval" maxlength="40" @blur="ysemailval" @input="inputemailval" />
						<div class="tishi" v-if="tishi2 == true">Incorrect email format</div>
						<input class="login5" placeholder="Password(8 digits,numeric and alphabetic  )" type="password" v-model="passwordval" maxlength="50" @blur="yspasswordval" @input="inputpasswordval" />
						<div class="tishi" v-if="tishi3 == true">Password must be numeric and alphabetic and must be greater than 8 digits;Special characters can only contain'@#^*!?&%$-_'</div>
						<input
							class="login6"
							placeholder="Confirm password"
							type="password"
							v-model="confimpasswordval"
							maxlength="50"
							@blur="ysconfipasswordval"
							@input="inputconfimpasswordval"
						/>
						<div class="tishi" v-if="tishi4 == true">The two passwords are inconsistent</div>
						<div class="login7 "><div @click="forsignup" class="shou">Sign up</div></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
var regemal = /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/;
var reg = new RegExp(/[A-Za-z].*[0-9]|[0-9].*[A-Za-z]/);
import head from '../assembly/head/head.vue';
import https from '../https.js';
export default {
	components: {
		'v-head': head,
	},
	data() {
		return {
			usernameval: '',
			emailval: '',
			passwordval: '',
			confimpasswordval: '',
			dixdiag1: false,
			tishi1: false,
			tishi2: false,
			tishi3: false,
			tishi4: false
		};
	},
	computed: {},
	mounted() {},
	methods: {
		closeit() {
			this.dixdiag1 = false;
		},
		inputusernameval() {
			if (this.usernameval == null || this.usernameval == '') {
				this.tishi1 = true;
			} else {
				for (var i in this.usernameval) {
					var asc = this.usernameval.charCodeAt(i);
					if ((asc >= 65 && asc <= 90) || (asc >= 97 && asc <= 122)) {
						this.tishi1 = false;
					}else{
						this.tishi1 = true;
					}
				}
			}
		},
		inputemailval() {
			if (!regemal.test(this.emailval)) {
				this.tishi2 = true;
			} else {
				this.tishi2 = false;
			}
		},
		inputpasswordval() {
			if (!reg.test(this.passwordval) || this.passwordval.length < 8) {
				this.tishi3 = true;
			} else {
				this.tishi3 = false;
			}
		},
		inputconfimpasswordval() {
			if (this.passwordval != this.confimpasswordval) {
				this.tishi4 = true;
			} else {
				this.tishi4 = false;
			}
		},
		yzusernameval() {
			if (this.usernameval == null || this.usernameval == '') {
				this.tishi1 = true;
			} else {
				for (var i in this.usernameval) {
					var asc = this.usernameval.charCodeAt(i);
					if ((asc >= 65 && asc <= 90) || (asc >= 97 && asc <= 122)) {
						this.tishi1 = false;
					}else{
						this.tishi1 = true;
					}
				}
			}
		},
		ysemailval() {
			if (!regemal.test(this.emailval)) {
				this.tishi2 = true;
			} else {
				this.tishi2 = false;
			}
		},
		yspasswordval() {
			if (!reg.test(this.passwordval) || this.passwordval.length < 8) {
				this.tishi3 = true;
			} else {
				this.tishi3 = false;
			}
		},
		ysconfipasswordval() {
			if ((this.passwordval != this.confimpasswordval) ) {
				this.tishi4 = true;
			} else {
				this.tishi4 = false;
			}
		},
		forsignup() {
			
			if ((this.usernameval == null || this.usernameval == '')&this.tishi1==false) {
				this.$alert('Incomplete information', {
					confirmButtonText: 'OK'
				});
				return false;
			} else if (!regemal.test(this.emailval)) {
				this.$alert('Incomplete information', {
					confirmButtonText: 'OK'
				});
				return false;
			} else if (!reg.test(this.passwordval) || this.passwordval.length < 8) {
				this.$alert('Incomplete information', {
					confirmButtonText: 'OK'
				});
				return false;
			} else if (this.passwordval != this.confimpasswordval) {
				this.$alert('Incomplete information', {
					confirmButtonText: 'OK'
				});
				return false;
			} else {
				
				let params = { username: this.emailval, password: this.passwordval, name: this.usernameval };
				https
					.fetchPost('/account/signUp', JSON.stringify(params))
					.then(data => {
						window.console.log(data);
						if (data.data.msg == 'SUCCESS') {
							this.dixdiag1 = true;
						} else {
							this.$alert(data.data.msg, {
								confirmButtonText: 'OK'
							});
							return false;
						}
					})
					.catch(err => {
						window.console.log(err);
					});
			}
		}
	},
	created() {}
};
</script>

<style scoped="scoped">
.tishi {
	font-size: 14px;
	color: red;
}
.diag2-2 {
	width: 278px;
	height: 46px;
	background: rgba(38, 0, 120, 1);
	border-radius: 1.5px;
	text-align: center;
	line-height: 46px;
	margin-top: 46px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
}
.diag2 {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 100px;
	flex-flow: column;
}
.diag2-1 {
	width: 459px;
	height: 81.5px;
	font-size: 17px;
	font-weight: 400;
	margin-top: 50px;
	color: rgba(102, 102, 102, 1);
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
.login7 {
	width: 100%;
	display: flex;
	height: 48px;
	align-items: center;
	margin-top: 10%;
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
	border: none;
	margin-top: 8%;
	border-bottom: #c0c0c0 1.5px solid;
	outline: none;
	font-size: 15px;
	height: 17px;
	color: rgba(51, 51, 51, 1);
	width: 421.5px;
}
.login4 {
	border: none;
	border-bottom: #c0c0c0 1.5px solid;
	outline: none;
	font-size: 15px;
	height: 17px;
	margin-top: 8%;
	color: rgba(51, 51, 51, 1);
	width: 421.5px;
}
.login5 {
	border: none;
	margin-top: 8%;
	border-bottom: #c0c0c0 1.5px solid;
	outline: none;
	font-size: 15px;
	height: 17px;
	color: rgba(51, 51, 51, 1);
	width: 421.5px;
}
.login3 {
	margin-top: 8%;
	font-size: 32px;
	font-family: SFUIDisplay-Bold, SFUIDisplay;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	line-height: 38px;
}
.login1 {
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
