<template>
	<div>
	<div class="dashboard1">Dashboard</div>
	<div class="dashboard2">
		<div class="dashboard2-1">
			<div>My Account</div>
			<div>Deposit</div>
			<div>Withdraw</div>
		</div>
		<div class="dashboard2-2"></div>
		<div class="dashboard2-3">
			<li>
				<span class="dashboard2-3-1">Total balance</span>
				<span class="dashboard2-3-2">992,329,12</span>
				<span class="dashboard2-3-3">BTC</span>
			</li>
			<li>
				<span class="dashboard2-3-1">Available balance</span>
				<span class="dashboard2-3-2">992,32323229,12</span>
				<span class="dashboard2-3-3">BTC</span>
			</li>
		</div>
	</div>
	<div class="dashboard3">
		<div>
			<span>Increase your account security</span>
			<span>0</span>
			<span>/4</span>
		</div>
		<div class="dashboard3-1"></div>
		<div class="dashboard3-2">
			<li>
				<span>Enable 2FA</span>
				<span @click="forchecksg">On</span>
			</li>
			<li>
				<span>Identity Verification</span>
				<span>Verify</span>
			</li>
			<li>
				<span>Anti-phishing Code</span>
				<span>Setup</span>
			</li>
			<li>
				<span>Turn-on withdrawal whitelist</span>
				<span>Turn on</span>
			</li>
		</div>
	</div>
	<div class="dashboard4">
		<div>Transaction History</div>
		<div>
			<div class="dashboard4-1">
				<span>Buy</span>
				<span>Amount</span>
				<span>Status</span>
				<span>Price</span>
				<span>Date</span>
			</div>
		</div>
		<div class="infinite-list-wrapper" v-infinite-scroll="loadMore">
			<div class="dashboard4-2" v-for="(gtem, index) in historylist" :key="index">
				<div>{{ gtem.buy }}</div>
				<div>{{ gtem.Amount }}</div>
				<div>{{ gtem.Status }}</div>
				<div>{{ gtem.Price }}</div>
				<div>{{ gtem.Date }}</div>
				<div class="dashboard4-3"></div>
			</div>
		</div>
	</div>
	</div>
</template>

<script>
	export default {
	data() {
		return {
			historylist: [
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' }
			],
		};
	},
	methods:{
		forchecksg(){
				localStorage.setItem('checksg',true);
		}
	}
	}
</script>

<style scoped="scoped">
	.infinite-list-wrapper{
			width: 100%;
			height: 300px;
			overflow: auto;
			position:relative
	
	
		}
	.dashboard4-2 {
		height: 51px;
	}
	.dashboard4-3 {
		width: 988px;
		height: 2px;
		background-color: #eeeeee;
		margin-top: 60px;
		margin-left: 25px;
		position: absolute;
	}
	.dashboard4-2 > div {
		display: inline-block;
	}
	.dashboard4-2 > div:nth-of-type(1) {
		margin-top: 24px;
		margin-left: 31px;
		font-size: 17px;
		color: rgba(102, 102, 102, 1);
		position: absolute;
	}
	.dashboard4-2 > div:nth-of-type(2) {
		margin-top: 24px;
		margin-left: 230px;
		position: absolute;
		color: rgba(102, 102, 102, 1);
		font-size: 17px;
	}
	.dashboard4-2 > div:nth-of-type(3) {
		margin-top: 24px;
		margin-left: 459px;
		position: absolute;
		color: rgba(153, 153, 153, 1);
		font-size: 17px;
	}
	.dashboard4-2 > div:nth-of-type(4) {
		margin-top: 24px;
		margin-left: 668px;
		position: absolute;
		color: rgba(102, 102, 102, 1);
		font-size: 17px;
	}
	.dashboard4-2 > div:nth-of-type(5) {
		margin-top: 24px;
		margin-left: 866px;
		position: absolute;
		color: rgba(153, 153, 153, 1);
		font-size: 17px;
	}
	.dashboard4-2 > div:nth-of-type(1) {
		margin-top: 24px;
		margin-left: 31px;
		position: absolute;
	}
	.dashboard4-1 {
		margin-top: 6px;
		position: absolute;
	}
	.dashboard4-1 > span:nth-of-type(1) {
		margin-left: 34px;
	}
	.dashboard4-1 > span {
		font-size: 18px;
		font-weight: 400;
		margin-left: 164px;
		color: rgba(102, 102, 102, 1);
	}
	.dashboard4 > div:nth-of-type(2) {
		width: 1038px;
		height: 46px;
		background: rgba(245, 245, 245, 1);
		border-radius: 1px;
		margin-top: 19px;
	}
	.dashboard4 > div:nth-of-type(1) {
		font-size: 18px;
		font-weight: bold;
		color: rgba(51, 51, 51, 1);
		margin-top: 20px;
		margin-left: 24px;
	}
	.dashboard3-2 > li {
		margin-top: 15px;
		color: #666666;
	}
	.dashboard3-2 > li > span:nth-of-type(1) {
		color: #666666;
		font-size: 16px;
	}
	.dashboard3-2 > li > span:nth-of-type(2) {
		color: #00c3ff;
		font-size: 14px;
		text-decoration: underline;
		margin-left: 18px;
	}
	.dashboard3-2 {
		position: absolute;
		margin-left: 33px;
		margin-top: 10px;
	}
	.dashboard3-1 {
		width: 455px;
		height: 2px;
		background-color: #eeeeee;
		position: absolute;
		margin-top: 18px;
		margin-left: 32px;
	}
	.dashboard3 > div > span:nth-of-type(1) {
		font-size: 18px;
		font-weight: bold;
		margin-left: 32px;
		color: rgba(51, 51, 51, 1);
	}
	.dashboard3 > div > span:nth-of-type(2) {
		font-size: 18px;
		color: #00c3ff;
		margin-left: 15px;
	}
	.dashboard3 >div{
		margin-top: 21px;
	}
	.dashboard3 > div > span:nth-of-type(3) {
		font-size: 18px;
	}
	.dashboard2-3 > li:nth-of-type(1) {
		color: #ff6464;
		margin-left: 33px;
		margin-top: 25px;
	}
	.dashboard2-3 > li:nth-of-type(2) {
		color: #fdda65;
		margin-left: 33px;
		margin-top: 22px;
	}
	.dashboard2-3-1 {
		margin-top: 3px;
		font-size: 16px;
		font-weight: 400;
		color: rgba(153, 153, 153, 1);
		position: absolute;
	}
	.dashboard2-3-2 {
		font-size: 18px;
		font-weight: 400;
		color: #333333;
		margin-left: 155px;
	}
	.dashboard2-3-3 {
		font-size: 18px;
		font-weight: 400;
		margin-left: 15px;
		color: #999999;
	}
	.dashboard2-1 {
	}
	.dashboard2-2 {
		width: 455px;
		height: 2px;
		background-color: #eeeeee;
		margin-left: 32px;
		margin-top: 13px;
	}
	.dashboard2-1 > div:nth-of-type(1) {
		font-size: 18px;
		font-weight: bold;
		color: rgba(51, 51, 51, 1);
		margin-top: 20px;
		margin-left: 24px;
		display: inline-block;
	}
	.dashboard2-1 > div:nth-of-type(2) {
		min-width: 76px;
		height: 31px;
		background: rgba(255, 100, 100, 1);
		font-weight: bold;
		display: inline-block;
		text-align: center;
		margin-left: 193px;
		line-height: 31px;
		font-size: 12px;
		color: rgba(255, 255, 255, 1);
	}
	.dashboard2-1 > div:nth-of-type(3) {
		min-width: 76px;
		height: 31px;
		border: 1px solid rgba(153, 153, 153, 1);
		font-weight: bold;
		display: inline-block;
		text-align: center;
		margin-left: 17px;
		line-height: 31px;
		font-size: 12px;
		color: rgba(102, 102, 102, 1);
	}
	.dashboard1 {
		font-size: 18px;
		font-weight: 400;
		color: rgba(0, 195, 255, 1);
		margin-left: 382px;
		margin-top: 28px;
		position: absolute;
	}
	.dashboard4 {
		width: 1038px;
		height: 412px;
		background: rgba(255, 255, 255, 1);
		box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
		border-radius: 1px;
		position: absolute;
		margin-left: 373px;
		margin-top: 316px;
	}
	.dashboard2 {
		margin-top: 65px;
		width: 516px;
		height: 244px;
		background: rgba(255, 255, 255, 1);
		box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
		border-radius: 1px;
		position: absolute;
		margin-left: 373px;
	}
	.dashboard3 {
		margin-top: 65px;
		position: absolute;
		width: 517px;
		height: 244px;
		background: rgba(255, 255, 255, 1);
		box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
		border-radius: 1px;
		margin-left: 895px;
	}
</style>
