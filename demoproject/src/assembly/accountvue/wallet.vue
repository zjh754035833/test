<template>
	<div>
		<div class="account4">
			<span>Wallet /</span>
			<span>Deposit</span>
		</div>
		<div class="account2">
			<div>
				<div>Balance Details</div>
				<div>Deposit</div>
				<div>Withdraw</div>
			</div>
			<div class="account2-1"></div>
			<div class="account2-2">
				<div class="account2-2-1"></div>
				<div class="account2-2-2"></div>
				<div class="account2-2-3">Account Balance</div>
				<div class="account2-2-4">Estimated Value</div>
				<div class="account2-2-5">
					<span>BTC</span>
					<span>8190.22</span>
				</div>
				<div class="account2-2-6">$7890.11</div>
			</div>
		</div>
		<div class="account3">
			<div class="account3-1">Select Network</div>
			<div class="account3-2"></div>
			<div class="account3-3" v-for="(gtem, index) in newlist" :key="index">
				<div :style="{ backgroundImage: 'url(' + gtem.wimage + ')' }" class="account3-3-1 shou" @click="fortu(gtem.id)">
					<img src="../../../static/xpath6.png" v-if="gtem.checked == true" />
				</div>
				<div class="account3-3-2">
					<div>{{ gtem.title }}</div>
					<div>{{ gtem.msg }}</div>
					<div>{{ gtem.clicktype }}</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	export default {
	data() {
		return {
			newlist: [
				{ wimage: require('../../../static/xpath5.png'), msg: 'Buy BTC with credit card now  >', checked: true, id: 0, title: 'VISA:', clicktype: 'Buy/Sell' },
				{ wimage: require('../../../static/xpath1.png'), msg: '12uvW2iVm41z4aiotu5L7LDaN3DA6Tqh2L', checked: false, id: 1, title: 'BTC Address:', clicktype: 'Copy Address' },
				{ wimage: require('../../../static/xpath3.png'), msg: 'Buy BTC with credit card now  >', checked: false, id: 2, title: 'American Express:', clicktype: 'Buy/Sell' },
				{ wimage: require('../../../static/xpath2.png'), msg: '12uvW2iVm41z4aiotu5L7LDaN3DA6Tqh2L', checked: false, id: 3, title: 'ETH Address:', clicktype: 'Copy Address' },
				{ wimage: require('../../../static/xpath4.png'), msg: 'Buy BTC with credit card now  >', checked: false, id: 4, title: 'MasterCard:', clicktype: 'Buy/Sell' }
			],
		};
	},
	methods:{
		fortu(e) {
			this.newlist.forEach(gtem => {
				gtem.checked = false;
			});
			this.newlist[e].checked = true;
		}
	}
	}
</script>

<style>
	
	.account3-3-1 > img {
		width: 35px;
		height: 35px;
		position: absolute;
		right: 6px;
		bottom: 3px;
	}
	.account3-3-2 {
		position: absolute;
		margin-left: 162px;
	}
	.account3-3-2 > div:nth-of-type(1) {
		font-size: 17px;
		font-weight: bold;
		color: rgba(51, 51, 51, 1);
	}
	.account3-3-2 > div:nth-of-type(2) {
		font-size: 15px;
		font-weight: 400;
		color: rgba(102, 102, 102, 1);
		margin-top: 7px;
	}
	.account3-3-2 > div:nth-of-type(3) {
		width: 109px;
		height: 31px;
		border: 1px solid rgba(0, 195, 255, 1);
		font-size: 12px;
		color: rgba(0, 195, 255, 1);
		line-height: 31px;
		margin-top: 10px;
		text-align: center;
	}
	.account3-3:nth-of-type(3) {
		margin-top: 19px;
	}
	.account3-3:nth-of-type(4) {
		margin-top: 19px;
	}
	.account3-3 {
		height: 92px;
		width: 498px;
		float: left;
		margin-top: 42px;
	}
	
	.account3-3-1 {
		z-index: 999;
		position: absolute;
		width: 118px;
		height: 74px;
		background-size: 100%;
		margin-left: 29px;
		margin-top: 9px;
	}
	.account3-2 {
		width: 929px;
		height: 2px;
		background-color: #eeeeee;
		margin-left: 36px;
		margin-top: 12px;
	}
	.account3-1 {
		font-size: 20px;
		font-weight: bold;
		color: rgba(51, 51, 51, 1);
		margin-top: 15px;
		margin-left: 34px;
	}
	.account2-2-5 > span:nth-of-type(1) {
		font-size: 20px;
		color: #00c3ff;
	}
	.account2-2-5 > span:nth-of-type(2) {
		font-size: 40px;
		font-weight: bold;
		color: rgba(51, 51, 51, 1);
		margin-left: 5px;
	}
	.account2-2-5 {
		position: absolute;
		margin-top: 35px;
		margin-left: 51px;
	}
	.account2-2-6 {
		position: absolute;
		margin-top: 35px;
		margin-left: 516px;
		font-weight: bold;
		font-size: 40px;
		color: rgba(51, 51, 51, 1);
	}
	.account2-2-3 {
		font-size: 18px;
		font-weight: 400;
		color: rgba(153, 153, 153, 1);
		position: absolute;
		margin-left: 51px;
	}
	.account2-2-4 {
		font-size: 18px;
		font-weight: 400;
		color: rgba(153, 153, 153, 1);
		position: absolute;
		margin-left: 516px;
	}
	.account2-2-1 {
		width: 3px;
		height: 88px;
		background: rgba(1, 211, 210, 1);
		border-radius: 1px;
		position: absolute;
		margin-left: 32px;
	}
	.account2-2-2 {
		width: 3px;
		height: 88px;
		background: rgba(238, 66, 86, 1);
		border-radius: 1px;
		position: absolute;
		margin-left: 492px;
	}
	.account2-2 {
		margin-top: 26px;
	}
	.account2-1 {
		width: 929px;
		height: 2px;
		background-color: #eeeeee;
		margin-left: 29px;
		margin-top: 19px;
	}
	.account2 > div:nth-of-type(1) {
		margin-top: 14px;
		display: flex;
	}
	.account2 > div:nth-of-type(1) > div:nth-of-type(1) {
		font-size: 20px;
		font-weight: bold;
		color: rgba(51, 51, 51, 1);
		margin-left: 32px;
	}
	.account2 > div:nth-of-type(1) > div:nth-of-type(2) {
		width: 76px;
		height: 33px;
		background: rgba(255, 100, 100, 1);
		font-size: 12px;
		text-align: center;
		line-height: 33px;
		color: rgba(255, 255, 255, 1);
		margin-left: 605px;
	}
	.account2 > div:nth-of-type(1) > div:nth-of-type(3) {
		width: 76px;
		height: 31px;
		margin-left: 17px;
		border: 1px solid rgba(153, 153, 153, 1);
		font-size: 12px;
		text-align: center;
		line-height: 31px;
		color: rgba(102, 102, 102, 1);
	}
	.account4 {
		position: absolute;
		margin-left: 395px;
		margin-top: 28px;
	}
	.account4 > span:nth-of-type(1) {
		font-size: 18px;
		font-weight: 400;
		color: rgba(153, 153, 153, 1);
	}
	.account4 > span:nth-of-type(2) {
		font-size: 18px;
		font-weight: 400;
		color: #458dfe;
	}
</style>
