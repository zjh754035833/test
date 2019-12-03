<template>
	<div>
		<div class="area">
			<v-head></v-head>
			<div class="login" @click="hrefsignup">sign up</div>
			<div class="halfarea">
				<div class="half1">Log In</div>
				<input class="half2" placeholder="Email" />
				<input class="half2"  placeholder="password" />
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
import head from '../../build/head/head.vue';

export default {
	data() {
		return {
			clientHeight: ''
		};
	},

	components: {
		'v-head': head
	},
	methods: {
		hrefsignup() {
			this.$router.push({ path: '/signup' });
		},
		formyaccount() {
			localStorage.removeItem('clicksell')
			localStorage.setItem('loginstate',1);
			this.$router.push({ path: '/Myaccount' });
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
	margin-left: 53px;
	color: rgba(255, 255, 255, 1);
	font-size: 22px;
	line-height: 46px;
	text-align: center;
}
.half5 {
	font-size: 16px;
	margin-top: 26px;
	color: rgba(69, 141, 254, 1);
	margin-left: 67px;
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
	margin-left: 51px;
	color: rgba(51, 51, 51, 1);
}
.half1 {
	width:534px;
	font-size:18px;
	color: rgba(51, 51, 51, 1);
	text-align: center;
	margin-top: 40px;
}
.halfarea {
width:534px;
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
</style>
