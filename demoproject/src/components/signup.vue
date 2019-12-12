<template>
	<div>
		<div class="area">
			<v-head></v-head>
			<div class="box5 " @click="hreflogin">login</div>
			<div class="halfarea">
				<div class="half1">Create a free account</div>
				<input class="half2" placeholder="email" @input="useemail" />
				<input class="half2" placeholder="password" type="password" @input="usepassword" />
				<div class="half3">At least 8 characters, must include UPPER CASE letters and numbers</div>
				<input class="half2" placeholder="Verify password" type="password" @input="qeusepassword" />
				<input class="half2" style="font-size: 19px;" placeholder="Referral ID/Name/E-mail/Telephone（optional）" @input="usephone" />
				<div class="half4">
					<el-checkbox v-model="cheakval"></el-checkbox>
					<span>I am over 18 years old, and I agree to the Binance Terms of Use</span>
				</div>
				<div class="half5">Auwels Terms of Use</div>
				<div class="half6 shou" @click="forcreate">Create account</div>
				<div class="half7">
					<span>Already registered?</span>
					<span style="color: rgba(69, 141, 254, 1);" class="shou" @click="hreflogin">Log In</span>
				</div>
			</div>
		</div>
	</div>
</template>
<!-- //Only by agreeing to the terms can you register -->
<script>
import head from '../assembly/head/head.vue';
import https from '../https.js';
export default {
	data() {
		return {
			emailval: '',
			passwordval: '',
			queepasswordval: '',
			phoneval: '',
			cheakval: ''
		};
	},
	components: {
		'v-head': head
	},

	methods: {
		hreflogin() {
			this.$router.push({ path: '/login' });
		},
		useemail(e) {
			this.emailval = e.target.value;
		},
		usepassword(e) {
			this.passwordval = e.target.value;
		},
		qeusepassword(e) {
			this.queepasswordval = e.target.value;
		},
		usephone(e) {
			this.phoneval = e.target.value;
		},
		forcreate() {
			let reg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
			let regEnUp = /[A-Z]+/; //大写字母
			let regNum = /[0-9]+/; //数字
			if (!reg.test(this.emailval)) {
				this.$alert('Incorrect mailbox format', {
					confirmButtonText: 'Determine'
				});
				return false;
			} else if (!regEnUp.test(this.passwordval)) {
				this.$alert('Password must contain uppercase letters', {
					confirmButtonText: 'Determine'
				});
				return false;
			} else if (!regNum.test(this.passwordval)) {
				this.$alert('Password must contain numbers', {
					confirmButtonText: 'Determine'
				});
				return false;
			} else if (this.passwordval.length < 8) {
				this.$alert('Password must be greater than or equal to 8 digits', {
					confirmButtonText: 'Determine'
				});
				return false;
			} else if (this.passwordval != this.queepasswordval) {
				this.$alert('The two passwords are inconsistent', {
					confirmButtonText: 'Determine'
				});
				return false;
			} else if (!/^1[3456789]\d{9}$/.test(this.phoneval)) {
				this.$alert('Incorrect phone number format', {
					confirmButtonText: 'Determine'
				});
				return false;
			}
			let params = { baseInfo: { email: this.emailval, password: this.passwordval, phone: this.phoneval } };
			https
				.fetchPost('/account/signUp', params)
				.then(data => {
					window.console.log(data);
					if (data.data.msg != '') {
						this.$router.push({ path: '/Registsucess' });
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
.box5 {
	cursor: pointer;
	position: absolute;
	margin-top: 46px;
	width: 95px;
	height: 31px;
	background: RGBA(134, 220, 248, 1);
	border-radius: 2px;
	margin-left: 1240px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
	line-height: 31px;
	text-align: center;
}
::-webkit-input-placeholder {
	/*Chrome/Safari*/
	font-size: 18px;
	color: rgba(153, 153, 153, 1);
}
::-moz-placeholder {
	/*Firefox*/
	font-size: 18px;
	color: rgba(153, 153, 153, 1);
}
::-ms-input-placeholder {
	/*IE*/
	font-size: 18px;
	color: rgba(153, 153, 153, 1);
}
.half7 {
	width: 540px;
	text-align: center;
	margin-top: 5px;
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
	background: rgba(0, 195, 255, 1);
	border-radius: 1px;
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
	text-decoration:underline;
	cursor: pointer;
}
.half5:hover{
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
	color: rgba(102, 102, 102, 1);
}
.area {
	background-image: url('../../static/Cover.png');
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
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	color: rgba(51, 51, 51, 1);
}
.half1 {
	margin-top: 20px;
	font-size: 24px;
	color: rgba(51, 51, 51, 1);
	text-align: center;
}
@media screen and (max-width: 1300px) {
	.halfarea {
		width: 620px;
		height: 591px;
		background: rgba(255, 255, 255, 1);
		box-shadow: 0px 2px 22px 0px rgba(0, 0, 0, 0.5);
		border-radius: 12px;
		position: absolute;
		left: 0px;
		right: 0px;
		display: flex;
		align-items: center;
		flex-direction: column;
		top: 15%;
		margin: 0 auto;
	}
}
@media screen and (min-width: 1300px) {
.halfarea {
	width: 540px;
	display: flex;
	align-items: center;
	flex-direction: column;
	height: 571px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 22px 0px rgba(0, 0, 0, 0.5);
	border-radius: 12px;
	position: absolute;
	left: 0px;
	right: 0px;
	top: 15%;
	margin: 0 auto;
}
}
</style>
