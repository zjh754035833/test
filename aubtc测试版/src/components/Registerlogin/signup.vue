<template>
	<div>
		<el-dialog title="" :visible.sync="dialogTableVisible" width="70%" top="0" :before-close="handleClose1">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
				<span>Terms of Use</span>
			</div>
			<div class="tanchu2">
				<div>
					<img src="../../../static/tiaokuan.jpg"  class="tiaokuan"/>
				</div>
			</div>
			<div class="tanchu3">
				<input type="checkbox" class="half4-1" @change="agreekuan"  />
				<span>I agree to Aussiebit's Terms of Use</span>
			</div>
			<div style="display: flex;justify-content: center;margin-top: 70px;"><div class="agree shou" @click="foragree">Agree</div></div>
		</el-dialog>
		<div class="area">
			<v-sell></v-sell>
			<div class="halfareall">
				<div class="halfarea">
					<div class="half1"><img src="../../../static/auseelogo.png" /></div>
					<input class="half2" placeholder="email" @input="useemail" @blur="ysemailval" />
					<div class="half3" v-if="tishi1 == true">Incorrect email format</div>
					<input class="half2" placeholder="password(8 characters,UPPER CASE letters and numbers)" type="password" @input="usepassword" @blur="yspasswordval" />
					<div class="half3" v-if="tishi2 == true">At least 8 characters, must include UPPER CASE letters and numbers,Special characters can only contain'@#^*!?&%$-_'</div>
					<input class="half2" placeholder="Verify password" type="password" @input="qeusepassword" @blur="ysconfipasswordval" />
					<div class="half3" v-if="tishi3 == true">The two passwords are inconsistent</div>
					<input class="half2" style="font-size: 14px;" placeholder="Referral ID（optional）" @input="usephone" />
					<div class="half3"></div>
					<div class="half4">
						<input type="checkbox" class="half4-1" @change="agreeall" :checked="cheakval" />
						<span>I am over 18 years old, and I agree to Terms of Use</span>
					</div>
					<div class="half6 shou" @click="forcreate">Create account</div>
					<div class="half7">
						<span>Already registered?</span>
						<span style="color: rgba(69, 141, 254, 1);" class="shou" @click="hreflogin">Log In</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>
<!-- //Only by agreeing to the terms can you register -->
<script>
import sell from '../../assembly/sell/sell.vue';
var reg = /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/;
var regpassword = /^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\d)[a-zA-Z\d!#@*&.]*$/; //大写字母
import https from '../../https.js';
export default {
	data() {
		return {
			emailval: '',
			passwordval: '',
			queepasswordval: '',
			phoneval: '',
			cheakval: '',
			tishi1: false,
			tishi2: false,
			tishi3: false,
			dialogTableVisible: false,
			agreekuanval: false
		};
	},
	components: {
		'v-sell': sell
	},
mounted() {
/* 	let params = {email:"yu.xiaolu@outlook.com" };
	https
		.fetchPost('/account/sendVerifyEmail', params)
		.then(data => {
			window.console.log(data);
			
		})
		.catch(err => {
			window.console.log(err);
		}); */
},
	methods: {
		handleClose1(){
		if(this.agreekuanval==false){
			this.cheakval=false	
		}
		this.dialogTableVisible=false
		},
		foragree() {
			if (this.agreekuanval != true) {
				this.$alert('Please agree to this clause', {
					confirmButtonText: 'OK'
				});
			} else {
				this.dialogTableVisible = false;
			}
		},
		agreekuan(e) {
			this.agreekuanval = e.target.checked;
		},
		agreeall(e) {
			window.console.log(e.target.checked);
			this.cheakval = e.target.checked;
			if (this.cheakval == true) {
				this.dialogTableVisible = true;
			}
		},
		hreflogin() {
			this.$router.push({ path: '/login' });
		},
		ysemailval() {
			if (!reg.test(this.emailval)) {
				this.tishi1 = true;
			} else {
				this.tishi1 = false;
			}
		},
		yspasswordval() {
			if (!regpassword.test(this.passwordval) || this.passwordval.length < 8 ) {
				this.tishi2 = true;
			} else {
				this.tishi2 = false;
			}
		},
		ysconfipasswordval() {
			if (this.passwordval != this.queepasswordval) {
				this.tishi3 = true;
			} else {
				this.tishi3 = false;
			}
		},
		useemail(e) {
			this.emailval = e.target.value;
			if (!reg.test(this.emailval)) {
				this.tishi1 = true;
			} else {
				this.tishi1 = false;
			}
		},
		usepassword(e) {
			this.passwordval = e.target.value;
			if (!regpassword.test(this.passwordval) || this.passwordval.length < 8 ) {
				this.tishi2 = true;
			} else {
				this.tishi2 = false;
			}
		},
		qeusepassword(e) {
			this.queepasswordval = e.target.value;
			if (this.passwordval != this.queepasswordval) {
				this.tishi3 = true;
			} else {
				this.tishi3 = false;
			}
		},
		usephone(e) {
			this.phoneval = e.target.value;
		},
		forcreate() {
			if (this.tishi1 || this.tishi2 || this.tishi3 || this.emailval == '' || this.passwordval == '' || this.queepasswordval == '') {
				this.$alert('Incomplete information', {
					confirmButtonText: 'OK'
				});
				return false;
			} else if (this.cheakval != true) {
				this.$alert('Please confirm that you are 18 years old and agree to the terms of use', {
					confirmButtonText: 'OK'
				});
			}
			
			let params = { baseInfo: { email: this.emailval, password: this.passwordval, phone: this.phoneval } };
			https
				.fetchPost('/account/signUp', params)
				.then(data => {
					window.console.log(data);
					if (data.data.msg == 'SUCCESS') {
						this.$router.push({ path: '/Registsucess' });
					} else {
						this.$alert(data.data.msg, {
							confirmButtonText: 'OK'
						});
					}
				})
				.catch(err => {
					window.console.log(err);
				});
		}
	}
};
</script>

<style scoped>
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
.agree {
	font-size: 22px;
	text-align: center;
	color: rgba(255, 255, 255, 1);
	line-height: 58px;
	width: 534px;
	height: 58px;
	background: rgba(41, 47, 136, 1);
	border-radius: 1px;
}
.tanchu3 {
	display: flex;
	font-size: 20px;
	color: rgba(102, 102, 102, 1);
	margin-top: 77px;
	margin-left: 51px;
}
.tiaokuan{
	width: 860px;
}
.tanchu2 {
	height: 300px;
	overflow-y: scroll;
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	margin-top: 30px;
	line-height: 35px;
	margin-left: 40px;
	margin-right: 40px;
}
.tanchu {
	height: 40px;
	align-items: center;
	display: flex;
}
.tanchu > img {
	width: 4px;
	height: 17px;
	margin-left: 30px;
}
.tanchu > span {
	font-size: 17px;
	margin-left: 5px;
}
.half4-1 {
	width: 20px;
	height: 20px;
}
.half1 > img {
	width: 189px;
	height: 25px;
	margin-top: 30px;
}
.box5 {
	cursor: pointer;
	position: absolute;
	margin-top: 46px;
	width: 95px;
	height: 31.5px;
	background: RGBA(134, 220, 248, 1);
	border-radius: 2px;
	margin-left: 1240px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
	line-height: 31.5px;
	text-align: center;
}
::-webkit-input-placeholder {
	/*Chrome/Safari*/
	font-size: 14px;
	color: rgba(153, 153, 153, 1);
}
::-moz-placeholder {
	/*Firefox*/
	font-size: 14px;
	color: rgba(153, 153, 153, 1);
}
::-ms-input-placeholder {
	/*IE*/
	font-size: 14px;
	color: rgba(153, 153, 153, 1);
}
.half7 {
	width: 540px;
	text-align: center;
	margin-top: 5px;
	margin-bottom: 20px;
}
.half7 > span:nth-of-type(1) {
	font-size: 17px;
	color: rgba(102, 102, 102, 1);
}
.half7 > span:nth-of-type(2) {
	font-size: 17px;
	color: #458dfe;
}
.half4 > span {
	margin-left: 10px;
}
.half6 {
	width: 432px;
	height: 46px;
	background: rgba(41,47,136,1);
	border-radius: 1.5px;
	margin-top: 32px;
	color: rgba(255, 255, 255, 1);
	font-size: 18px;
	line-height: 46px;
	text-align: center;
}
.half5 {
	width: 437px;
	font-size: 13px;
	color: rgba(69, 141, 254, 1);
	margin-top: 5px;
	text-decoration: underline;
	cursor: pointer;
}
.half5:hover {
	color: red;
}
.half4 {
	width: 437px;
	margin-top: 24px;
	font-size: 13px;
	color: rgba(102, 102, 102, 1);
}
.half3 {
	width: 437px;
	font-size: 12px;
	color: red;
}
.area {
	background-image: url('../../../static/Cover.png');
	background-position: center 0;
	background-size: cover;
	min-height: 100vh;
	overflow: hidden;
}
.half2 {
	margin-top: 42px;
	padding-bottom: 10px;
	width: 437px;
	font-size: 20px;
	height: 17px;
	border: none;
	border-bottom: #c0c0c0 1.5px solid;
	outline: none;
	color: rgba(51, 51, 51, 1);
}
.half1 {
	margin-top: 20px;
	font-size: 24px;
	color: rgba(51, 51, 51, 1);
	text-align: center;
}
.halfarea {
	width: 534px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 18px 0px rgba(0, 0, 0, 0.09);
	margin-right: 117px;
	display: flex;

	align-items: center;
	flex-direction: column;
	float: right;
}
.halfareall {
	width: 100%;
	height: 90vh;
	display: flex;
	align-items: center;
	flex-direction: row-reverse;
}
</style>
