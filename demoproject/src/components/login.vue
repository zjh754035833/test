<template>
	<div>
		<div class="area">
			<v-head></v-head>
			<div class="login" @click="hrefsignup">sign up</div>
			<div class="halfarea">
				<div class="half1">Log In</div>
				<input class="half2" placeholder="Email"   @input="useemail" />
				<input class="half2"  placeholder="password"  type="password"   @input="usepassword"/>
				<div class="half6 shou" @click="formyaccount">Log in</div>
				<div class="half5">Forgot password?</div>
				<div class="halfboot">
					<img src="../../static/z1.png" />
					<img src="../../static/z2.png" />
					<img src="../../static/z3.png" />
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import head from '../assembly/head/head.vue';
import https from '../https.js';
export default {
	data() {
		return {
			clientHeight: '',
			emailval: '',
			passwordval: '',
		};
	},

	components: {
		'v-head': head
	},
	methods: {
		useemail(e) {
			this.emailval = e.target.value;
		},
		usepassword(e) {
			this.passwordval = e.target.value;
		},
		hrefsignup() {
			this.$router.push({ path: '/signup' });
		},
		formyaccount() {
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
			}
			let params = { username: this.emailval, password: this.passwordval };
			https
				.fetchPost('/account/signIn', params)
				.then(data => {
					window.console.log(data);
					if(data.data.token!=""&data.data.token!=null){
							localStorage.removeItem('clicksell')
							localStorage.setItem('token',data.data.token); 
							this.$router.push({ path: '/Myaccount' })
					}else{
						this.$alert(data.data.msg, {
							confirmButtonText: 'Determine'
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

<style scoped>
.halfboot {
	display: flex;
	margin-top: 21px;
	justify-content: center;
}
.halfboot > img:nth-of-type(1) {
}
.halfboot > img:nth-of-type(2) {
	margin-left: 42px;
}
.halfboot > img:nth-of-type(3) {
	margin-left: 42px;
}
.halfboot > img {
	width: 50px;
	height: 50px;
}
.login {
	cursor: pointer;
	font-size: 18px;
	margin-top: 46px;
	margin-left: 1240px;
	width: 95px;
	height: 31px;
	border-radius: 2px;
	border: 1px solid rgba(255, 255, 255, 1);
	position: absolute;
	color: rgba(255, 255, 255, 1);
	line-height: 31px;
	text-align: center;
}

::-webkit-input-placeholder {
	/*Chrome/Safari*/
	color: rgba(153, 153, 153, 1);
}
::-moz-placeholder {
	/*Firefox*/
	color: rgba(153, 153, 153, 1);
}
::-ms-input-placeholder {
	/*IE*/
	color: rgba(153, 153, 153, 1);
}
.half7 {
	width: 668px;
	text-align: center;
	margin-top: 113px;
}
.half6 {
width:427px;
height:46px;
	background: rgba(213, 213, 213, 1);
	border-radius: 1px;
	margin-top: 70px;
	color: rgba(255, 255, 255, 1);
	font-size: 22px;
	line-height: 46px;
	text-align: center;
}
.half5 {
	font-size: 16px;
	margin-top: 26px;
	color: rgba(69, 141, 254, 1);
}

.half4 {
	position: absolute;
	margin-top: 443px;
	font-size: 16px;
	margin-left: 62px;
	color: rgba(102, 102, 102, 1);
}
.half3 {
	position: absolute;
	margin-top: 395px;
	font-size: 15px;
	color: rgba(102, 102, 102, 1);
	margin-left: 62px;
}
.area {
	background-image: url('../../static/Cover.png');
	background-position: center 0;
	background-size: cover;
	min-height: 100vh;
	overflow: hidden;
}
.half2 {
	margin-top: 66px;
	width:432px;
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	font-size:15px;
	height: 17px;
	color: rgba(51, 51, 51, 1);
}
.half1 {
	width:534px;
	font-size:18px;
	color: rgba(51, 51, 51, 1);
	text-align: center;
	margin-top: 40px;
}
@media screen and (max-width: 1300px) {
.halfarea {
	display: flex;
	flex-direction: column;
	align-items: center;
width:620px;
height:514px;
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
@media screen and (min-width: 1300px) {
.halfarea {
	display: flex;
	flex-direction: column;
	align-items: center;
width:540px;
height:514px;
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
