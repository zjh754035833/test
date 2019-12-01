<template>
	<div>
		<v-sell></v-sell>
		<div class="sms1"><span>Security > Enabled SMS authenticator</span></div>
		<div class="sms2">
			<div>Enabled SMS authenticator</div>
			<div class="sms2-1">
				<div>
					<img src="../../static/china.png" class="country" />
					<img src="../../static/sanjiao.png" class="forcountry" />
					<input class="phonenumber" placeholder="Enter phone number"  v-on:keyup="phonenumberinput" />
					<span class="yanz" v-if="numberempty == true">Please enter your phone number</span>
				</div>
				<div>SMS Authentication Code</div>
				<div class="sms2-2">
					<input maxlength="1" />
					<input maxlength="1" />
					<input maxlength="1" />
					<input maxlength="1" />
					<input maxlength="1" />
					<input maxlength="1" />
				</div>
				<div class="sendsms" @click="sensms">Send SMS</div>
				<div class="SMSsuper" @click="clicksms">Enabled SMS authenticator</div>
			</div>
		</div>
		<v-footer style="margin-top: 88px;"></v-footer>
	</div>
</template>

<script>
import sell from '../../build/sell/sell.vue';
import footer from '../../build/foot/foot.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer
	},
	data() {
		return {
			numberempty: false,
			phonenumber:""
		};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		phonenumberinput(e) {
			window.console.log(e.target.value);
			this.phonenumber=e.target.value
			if(this.phonenumber!=""){
				this.numberempty=false 
			}
		},
		clicksms() {
			if(this.phonenumber==""){
				this.numberempty=true 
			}
		},
		sensms(){
			if(this.phonenumber==""){
				this.numberempty=true 
			}
		}
	}
};
</script>

<style>
.yanz {
	font-size: 14px;
	font-weight: 400;
	color: rgba(238, 66, 86, 1);
	margin-left: -220px;
}
.SMSsuper {
	width: 534px;
	height: 58px;
	background: rgba(0, 195, 255, 1);
	border-radius: 1px;
	font-size: 22px;
	line-height: 58px;
	margin-top: 35px;
	text-align: center;
	color: rgba(255, 255, 255, 1);
}
.sendsms {
	width: 128px;
	height: 37px;
	border: 1px solid rgba(0, 195, 255, 1);
	text-align: center;
	line-height: 37px;
	font-size: 16px;
	font-weight: 400;
	color: rgba(0, 195, 255, 1);
	margin-left: 520px;
	margin-top: -37px;
	position: absolute;
}
.forcountry {
	width: 8px;
	height: 5px;
	position: absolute;
	margin-left: 35px;
	margin-top: 12px;
}
.country {
	width: 25px;
	height: 24px;
	position: absolute;
}
::-webkit-input-placeholder {
	color: rgba(153, 153, 153, 1);
}
::-moz-placeholder {
	color: rgba(153, 153, 153, 1);
}
::-ms-input-placeholder {
	color: rgba(153, 153, 153, 1);
}
.sms2-1 {
	margin-top: 181px;
	position: absolute;
	margin-left: 308px;
}
.sms2-1 > div:nth-of-type(2) {
	font-size: 18px;
	color: rgba(153, 153, 153, 1);
	margin-top: 59px;
}
.phonenumber {
	padding-left: 65px;
	padding-bottom: 29px;
	font-size: 18px;
	width: 540px;
	border: none;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	border-bottom: #c0c0c0 1px solid;
	outline: none;
}
.sms2-2 > input:nth-of-type(1) {
	margin-left: 0px;
}
.sms2-2 > input {
	margin-top: 28px;
	padding-left: 23px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	border: none;
	width: 45px;
	margin-left: 17px;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
}
.sms2 > div:nth-of-type(1) {
	width: 1169px;
	font-size: 30px;
	font-weight: 600;
	text-align: center;
	color: rgba(51, 51, 51, 1);
	margin-top: 56px;
	position: absolute;
}
.sms1 {
	width: 1440px;
	height: 60px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	line-height: 60px;
}
.sms1 > span {
	position: absolute;
	margin-left: 148px;
}
.sms2 {
	width: 1169px;
	height: 565px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 23px;
	margin-left: 142px;
}
</style>
