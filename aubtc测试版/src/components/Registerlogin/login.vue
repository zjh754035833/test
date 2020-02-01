<template>
	<div>
		<div class="area">
			<v-sell></v-sell>
			<el-dialog title="" :visible.sync="dialogTableVisible" width="30%" top="0" :before-close="handleClose1">
			<div style="margin-top: 20px;">
				The account is not activated. Please log in your email to activate the account before logging in
			</div>
			<div style="display: flex;justify-content: center;"><el-button type="primary" class="anniu" @click="dialogTableVisible=false">OK</el-button>
			</div>
			<div style="width: 70%;margin-left: 15%;margin-top: 10px;">If do not receive the activation email
			<br/>-><span class="sendactivation" @click="forsendactive">Resend activation email</span> </div>
			</el-dialog>
			<div class="halfareall">
				<div class="halfarea">
					<img src="../../../static/auseelogo.png" />
					<input class="half2" placeholder="Email" @input="useemail" />
					<input class="half3" placeholder="password" type="password" @input="usepassword" />
					<div class="half5 shou" @click="forgetpassword">Forgot password?</div>
					<div class="forgetpassword" v-if="chongzhi==true">
						<input class="half2" style="margin-top: 0px;" placeholder="Enter the email address for the reset password" @input="fornewemail"  />
						<div class="sendemail shou" @click="sendemail">Send Email</div>
					</div>
					<div @click="formyaccount" :class="[iswrite ? 'half6blue shou' : 'half6 shou']">Log in</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import sell from '../../assembly/sell/sell.vue';
import https from '../../https.js';
export default {
	components: {
		'v-sell': sell
	},
	data() {
		return {
			clientHeight: '',
			emailval: '',
			passwordval: '',
			iswrite: false,
			chongzhi:false,
			newemailval:'',
			dialogTableVisible:false
		};
	},
	mounted() {
		if ((localStorage.getItem('token') != '') & (localStorage.getItem('token') != null)) {
		this.$router.push({ path: '/Comming' });
		}
	},
	methods: {
		forsendactive(){
			let params = { email: this.emailval };
			https
				.fetchPost('/account/sendVerifyEmail', params)
				.then(data => {
					window.console.log(data.data.msg);
					if(data.data.msg=="SUCCESS"){
						this.$alert('Send successfully', {
							confirmButtonText: 'OK'
						});
					}else if(data.data.errorCode=="1003"){
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
		sendemail(){
			let params = { email: this.newemailval };
			https
				.fetchPost('/account/sendPwdRstEmail', params)
				.then(data => {
					window.console.log(data);
					if(data.data.msg=="SUCCESS"){
						this.$alert("Reset password email has been sent to your e-mail", {
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
		forgetpassword(){
			this.chongzhi=!this.chongzhi
		},
		useemail(e) {
			this.emailval = e.target.value;
			if ((this.emailval != '') & (this.passwordval != '')) {
				this.iswrite = true;
			} else {
				this.iswrite = false;
			}
		},
		fornewemail(e){
			this.newemailval = e.target.value;
			
		},
		usepassword(e) {
			this.passwordval = e.target.value;
			if ((this.emailval != '') & (this.passwordval != '')) {
				this.iswrite = true;
			} else {
				this.iswrite = false;
			}
		},
		hrefsignup() {
			this.$router.push({ path: '/signup' });
		},
		formyaccount() {
			if(this.iswrite==false){
				return false
			}
			/* 	let regEnUp = /[A-Z]+/; //大写字母
			let regNum = /[0-9]+/; //数字 */
			
			let params = { username: this.emailval, password: this.passwordval };
			https
				.fetchPost('/account/signIn', params)
				.then(data => {
					window.console.log(data);
					if ((data.data.token != '') & (data.data.token != null)) {
						localStorage.removeItem('clicksell');
						localStorage.setItem('token', data.data.token);
						location.reload();
					} else if(data.data.errorCode=="1003"){
						this.dialogTableVisible=true
					}else {
						this.$alert(data.data.msg, {
							confirmButtonText: 'OK'
						});
					}
				})
				.catch(err => {
					window.console.log(err);
				});
			/* 	localStorage.removeItem('clicksell')
			localStorage.setItem('loginstate',1); */
			//	this.$router.push({ path: '/Myaccount' });
		}
	}
};
</script>

<style src="./login.css" scoped>
	
</style>
