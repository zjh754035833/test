<template>
	<div>
		<v-sell></v-sell>
		<div class="sms1"><span>Security > Enabled SMS authenticator</span></div>
		<div class="google1">
			<div>Enabled Google authenticator</div>
			<div class="google2">
				<div v-for="(item, index) in numlist" :key="index">
					<div :class="[item.type == 'halfon' ? 'google2-1blue' : 'google2-1']" v-if="item.type != 'on'">{{ item.num }}</div>
					<div :class="[item.type == 'halfon' ? 'google2-4blue' : 'google2-4']">{{ item.text }}</div>
					<img src="../../static/gllgletu.png" class="google2-3" v-if="item.type == 'on'" />
					<div class="google2-2"></div>
				</div>
			</div>
		</div>
		<div class="google16">
			<div class="google16-1" v-if="numlist[2].type == 'halfon'">
				<div>
					<span>Step 1:</span>
					<span>Download and install the Google Authenticator app</span>
				</div>
				<div>
					<img src="../../static/apstore.png" />
					<img src="../../static/appstoregoo.png" />
				</div>
			</div>
			<div class="google16-2" v-if="numlist[1].type == 'halfon'">
				<div>
					<span>Step 2:</span>
					<span>Scan this QR code in the Google Authenticator app</span>
				</div>
				<div class="google16-2-1">
					<img src="../../static/erweima.png" />
					<div class="google16-2-2">
						<div>If you are unable to scan the QR code,please enter this code manually into the app.</div>
						<div>XYUIOUIOHHK</div>
					</div>
				</div>
				<div class="google16-2-3">NEXT</div>
			</div>
			<div class="google16-3" v-if="numlist[2].type == 'halfon'">
				<div class="google16-3-1">Step 3:</div>
				<div class="google16-3-2">
					<div>Please save this key on paper.This Key will allow you to recver your Google Authenticator in case of phone loss.</div>
					<div>Resetting your Google Authenticator requires opening a support ticket and takes at least 7days to process.</div>
					<div>XYUIOUIOHHK</div>
				</div>
				<div class="google16-3-3">NEXT</div>
			</div>
			<div class="google16-3" v-if="numlist[3].type == 'halfon'">
				
			</div>
		</div>

		<v-footer></v-footer>
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
			numlist: [
				{ num: '1', text: 'Download App', type: 'halfon' },
				{ num: '2', text: 'Scan QR Code', type: 'off' },
				{ num: '3', text: 'Type something', type: 'off' },
				{ num: '4', text: 'Enabled Google authenticator', type: 'off' }
			]
		};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	}
};
</script>

<style>
.google16-3-2 {
	margin-left: 449px;
	margin-top: 61px;
	position: absolute;
}
.google16-3-2 > div:nth-of-type(1) {
	width: 519px;
	height: 63px;
	font-size: 17px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
}
.google16-3-2 > div:nth-of-type(2) {
	width: 460px;
	height: 42px;
	font-size: 17px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
}
.google16-3-2 > div:nth-of-type(3) {
	margin-top: 26px;
	width: 187px;
	height: 48px;
	font-size: 17px;
	text-align: center;
	line-height: 48px;
	color: rgba(153, 153, 153, 1);
	background: rgba(241, 241, 241, 1);
}
.google16-3-1 {
	font-size: 30px;
	font-weight: 600;
	margin-left: 324px;
	position: absolute;
	margin-top: 49px;
	color: rgba(51, 51, 51, 1);
}
.google16-2 > div:nth-child(3) {
	float: right;
	text-align: center;
	line-height: 60px;
	position: absolute;
	width: 178px;
	height: 60px;
	background: rgba(0, 195, 255, 1);
	border-radius: 2px;
	color: rgba(255, 255, 255, 1);
	margin-top: 200px;
	margin-left: 450px;
}
.google16-3-3 {
	float: right;
	text-align: center;
	line-height: 60px;
	margin-top: 200px;
	margin-right: 64px;
	width: 178px;
	height: 60px;
	background: rgba(0, 195, 255, 1);
	border-radius: 2px;
	color: rgba(255, 255, 255, 1);
}
.google16-2-1 > div > div:nth-of-type(1) {
	width: 365px;
	font-size: 17px;

	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	line-height: 21px;
}
.google16-2-1 > div > div:nth-of-type(2) {
	width: 187px;
	height: 48px;
	background: rgba(241, 241, 241, 1);
	margin-top: 10px;
	font-size: 18px;
	text-align: center;
	line-height: 48px;
}
.google16-2-1 > img {
	width: 123px;
	height: 134px;
	margin-top: 26px;
}
.google16-2-1 {
	display: flex;
}
.google16-2-2 {
	display: flex;
	flex-direction: column;
	margin-top: 41px;
	margin-left: 17px;
}
.google16-2 > div:nth-of-type(1) > span:nth-of-type(1) {
	font-size: 32px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
}
.google16-2 > div:nth-of-type(1) > span:nth-of-type(2) {
	font-size: 20px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	margin-left: 16px;
}
.google16-2 > div:nth-of-type(1) {
	height: 30px;
	display: flex;
	margin-top: 49px;
	align-items: center;
}
.google16-2 {
	width: 1169px;
	display: flex;
	flex-direction: column;
	align-items: center;
}
.google16-1 > div:nth-of-type(2) {
	display: flex;
	justify-content: center;
	margin-top: 45px;
}
.google16-1 > div:nth-of-type(2) > img {
	width: 290px;
	height: 118px;
	border-radius: 7px;
}
.google16-1 > div:nth-of-type(2) > img:nth-of-type(2) {
	margin-left: 21px;
}
.google16-1 > div:nth-of-type(1) > span:nth-of-type(1) {
	font-size: 32px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
}
.google16-1 > div:nth-of-type(1) > span:nth-of-type(2) {
	font-size: 20px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	margin-left: 16px;
}
.google16-1 > div:nth-of-type(1) {
	height: 30px;
	display: flex;
	margin-top: 49px;
	align-items: center;
}
.google16-1 {
	width: 1169px;
	display: flex;
	flex-direction: column;
	align-items: center;
}
.google16 {
	width: 1169px;
	height: 291px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 8px;
	margin-left: 142px;
}

.google2-4 {
	position: absolute;
	width: 258px;
	margin-top: 50px;
	font-size: 14px;
	text-align: center;
	color: rgba(217, 217, 217, 1);
	height: 20px;
	line-height: 20px;
	margin-left: -103px;
}
.google2-4blue {
	position: absolute;
	width: 258px;
	margin-top: 50px;
	font-size: 14px;
	text-align: center;
	color: rgba(0, 195, 255, 1);
	height: 20px;
	line-height: 20px;
	margin-left: -103px;
}
.google2-3 {
	margin-left: 5px;
	width: 34px;
	height: 34px;
}
.google2 > div:nth-of-type(4) > div:nth-last-of-type(1) {
	display: none;
}
.google2-2 {
	width: 161px;
	height: 1px;
	margin-left: 11px;
	border-bottom: 1px #d9d9d9 dashed;
}
.google2-1 {
	margin-left: 5px;
	color: rgba(255, 255, 255, 1);
	text-align: center;
	line-height: 34px;
	width: 34px;
	height: 34px;
	background: rgba(217, 217, 217, 1);
	border-radius: 30px;
}
.google2-1blue {
	margin-left: 5px;
	color: rgba(255, 255, 255, 1);
	text-align: center;
	line-height: 34px;
	width: 34px;
	height: 34px;
	background: rgba(0, 195, 255, 1);
	border-radius: 30px;
}
.google2 {
	margin-top: 65px;
	display: flex;
	align-items: center;
	flex-direction: row;
}
.google3 {
	margin-top: 65px;
	display: flex;
	align-items: center;
	flex-direction: row;
}
.google2 > div {
	display: flex;
	align-items: center;
}
.google1 > div:nth-of-type(1) {
	font-size: 30px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
	margin-top: 40px;
}
.el-step.is-center .el-step__line {
}
.el-step__title {
	color: rgba(217, 217, 217, 1);
}
.sms1 {
	width: 100%;
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
.google1 {
	width: 1169px;
	height: 291px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 23px;
	margin-left: 142px;
}
</style>
