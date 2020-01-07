<template>
	<div class="walletall">
	<div class="walletall-1">
		<div class="walletall-1-1">
			<div>My Wallet</div>
			<img src="../../../static/tianyan.png" />
			<div>Deposit</div>
			<div>Withdraw</div>
		</div>
		<div class="walletall-1-2"></div>
		<div class="walletall-1-3" >
			<div class="walletall-1-3-1">
				<div class="walletall-1-3-1-1">Crypto wallet</div>
				<div class="walletx2-3">
					<div>
						<span class="walletx2-3-1">Total balance</span>
						<span class="walletx2-3-2">
							221,289,11
							<span class="walletx2-3-3">BTC</span>
						</span>
					</div>
					<div>
						<span class="walletx2-3-1">Available balance</span>
						<span class="walletx2-3-2">
							99,111,11
							<span class="walletx2-3-3">BTC</span>
						</span>
					</div>
				</div>
			</div>
			<div class="walletxian"></div>
			<div class="walletall-1-3-2">
				<div class="walletall-1-3-1-1">Fiat wallet</div>
				<div class="walletx2-3">
					<div>
						<span class="walletx2-3-1">Total balance</span>
						<span class="walletx2-3-2">
							221,289,11
							<span class="walletx2-3-3">BTC</span>
						</span>
					</div>
					<div>
						<span class="walletx2-3-1">Available balance</span>
						<span class="walletx2-3-2">
							99,111,11
							<span class="walletx2-3-3">AUD</span>
						</span>
					</div>
				</div>
			</div>	
		</div>
	</div>
	<div class="walletall-2">
		
	</div>
	</div>
</template>

<script>
	export default {
	data() {
		return {
	
		};
	},
	methods:{

		
	}
	}
</script>

<style scoped="scoped">
	.walletall-1-3-1{
		width: 50%;
	}
	.walletall-1-3-2{
		width: 50%;
		}
	.walletxian{
		width:1px;
		height:149px;
		background: rgba(232, 231, 231, 1);
		margin-top: 25px;
		opacity: 0.8;
	}
	.walletall-1-3-1-1{
		font-size:18px;
		font-weight:bold;
		color:rgba(51,51,51,1);
		margin-left: 32px;
		margin-top: 23px;
	}
	.walletx2-3 > div:nth-of-type(1) {
		color: #ff6464;
		margin-left: 33px;
		margin-top: 25px;
		width: 443px;
	}
	.walletx2-3 > div:nth-of-type(2) {
		color: #fdda65;
		margin-left: 33px;
		margin-top: 22px;
		width: 443px;
	}
	.walletx2-3-1 {
		margin-top: 3px;
		font-size: 16px;
		font-weight: 400;
		color: rgba(153, 153, 153, 1);
	}
	.walletx2-3-2 {
		font-size: 18px;
		font-weight: 400;
		color: #333333;
		float: right;
		margin-right: 33px;
	}
	.walletx2-3-3 {
		font-size: 18px;
		font-weight: 400;
		margin-left: 15px;
		color: #999999;
	}
	.walletall-1-3{
		display: flex;
		}
	.walletall-1-2{
		width:929px;
		opacity: 0.8;
		height:1px;
		background: rgba(238, 238, 238, 1);
		margin-left: 28px;
	}
	.walletall-1-1{
		display: flex;
		align-items: center;
		height: 54px;
	}
	.walletall-1-1>div:nth-of-type(1){
		font-size:18px;
		font-weight:bold;
		color:rgba(51,51,51,1);
		margin-left: 32px;
	}
	.walletall-1-1>div:nth-of-type(2){
		width:76px;
		height:31px;
		background:rgba(255,100,100,1);
		font-size:12px;
		font-weight:400;
		color:rgba(255,255,255,1);
		border:1px solid rgba(255,100,100,1);
		margin-left: 607px;
		line-height:31px;
		text-align: center;
	}
	.walletall-1-1>div:nth-of-type(3){
	width:76px;
	height:31px;
	border:1px solid rgba(153,153,153,1);
	font-size:12px;
	margin-left:17px;
	font-weight:400;
	color:rgba(102,102,102,1);
	line-height:31px;
	text-align: center;
	}
	.walletall-1-1>img{
		width:45px;
		height:20px;
		margin-left: 13px;
	}
	.walletall-1{
		width:996px;
		height:269px;
		background:rgba(255,255,255,1);
		box-shadow:0px 2px 12px 0px rgba(220,220,220,0.5);
		border-radius:1px;
		margin-left: 347px;
		position: absolute;
		margin-top: 22px;
	}
	.walletall-2{
		width:996px;
		height:425px;
		background:rgba(255,255,255,1);
		box-shadow:0px 2px 12px 0px rgba(220,220,220,0.5);
		border-radius:1px;
		margin-left: 347px;
		margin-top: 304px;
		position: absolute;
		}
</style>
