<template>
	<div>
		<div class="area">
			<v-head></v-head>
			<div class="box5 " @click="hreflogin">login</div>
			<div class="halfarea">
				<div class="half1">Create a free account</div>
				<input class="half2" placeholder="Phone email" />
				<input class="half2"  placeholder="password" />
				<div class="half3">At least 8 characters, must include UPPER CASE letters and numbers</div>
				<input class="half2" placeholder="Phone number" />
				<div class="half4">
					<el-checkbox></el-checkbox>
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

<script>
import head from '../assembly/head/head.vue';

export default {
	components: {
		'v-head': head
	},
	methods: {
		hreflogin() {
			this.$router.push({ path: '/login' });
		},
		forcreate(){
			this.$router.push({ path: '/Registsucess' });
		},
		
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
	margin-top: 23px;
}
.half7>span:nth-of-type(1){
	font-size:17px;
	color:rgba(102,102,102,1);
}
.half7>span:nth-of-type(2){
	font-size:17px;
	color:#458DFE;
}
.half4>span{
	margin-left:10px;
}
.half6 {
	width:432px;
	height:46px;
	background:rgba(0,195,255,1);
	border-radius: 1px;
	margin-top: 32px;
	margin-left: 54px;
	color: rgba(255, 255, 255, 1);
	font-size:18px;
	line-height: 46px;
	text-align: center;
}
.half5 {
	font-size: 16px;
	color: rgba(69, 141, 254, 1);
	margin-top: 5px;
	margin-left: 70px;
}

.half4 {
	margin-top: 24px;
	font-size:13px;
	margin-left: 50px;
	color: rgba(102, 102, 102, 1);
}
.half3 {
	font-size:12px;
	color: rgba(102, 102, 102, 1);
	margin-left: 51px;
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
	padding-bottom: 10px;
	width: 437px;
	font-size:15px;
	height: 17px;
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	margin-left: 51px;
	color: rgba(51, 51, 51, 1);
}
.half1 {
	margin-top: 20px;
	font-size: 24px;
	color: rgba(51, 51, 51, 1);
	text-align: center;
}
.halfarea {
	width:540px;
	height:571px;
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
