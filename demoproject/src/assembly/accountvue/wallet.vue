<template>
	<div>
		<div>
			<el-dialog  :visible.sync="dialogTableVisible1" width="60%">
				<div class="tanchu">
					<img src="../../../static/bluejiao.png" />
				<span>Please select mode of payment</span>
				</div>
				<div class="xiant"></div>
				<div style="height: 366px;">
					<div class="account3-3" v-for="(gtem, index) in newlist" :key="index" style="width: 50%;">
						<div :style="{ backgroundImage: 'url(' + gtem.wimage + ')' }" class="account3-3-1 shou" @click="fortu1(gtem.id)">
							<img src="../../../static/xpath6.png" v-if="gtem.checked == true" />
						</div>
						<div class="account3-3-2">
							<div>{{ gtem.title }}</div>
							<div>{{ gtem.msg }}</div>
							<div>{{ gtem.clicktype }}</div>
						</div>
					</div>
				</div>
			
			</el-dialog>
		</div>
		<div>
			<el-dialog title="" :visible.sync="dialogTableVisible2" width="60%">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
			<span>Please select mode of payment</span>
			</div>
			<div class="xiant"></div>
			<div style="height: 366px;">
				<div class="account3-3" v-for="(gtem, index) in newlist2" :key="index" style="width: 100%;">
					<div :style="{ backgroundImage: 'url(' + gtem.wimage + ')' }" class="account3-3-1 shou" @click="fortu2(gtem.id)">
						<img src="../../../static/xpath6.png" v-if="gtem.checked == true" />
					</div>
					<div class="account3-3-2">
						<div>{{ gtem.title }}</div>
						<div>{{ gtem.msg }}</div>
						<div>{{ gtem.clicktype }}</div>
					</div>
				</div>
			</div>
			</el-dialog>
		</div>
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
				<div class="xianx"></div>
				<div class="account2-2-1">
					<img src="../../../static/q1.png"/>
					<div>
						<div>Estimated Vale</div>
						<div>30,0000</div>
					</div>
					<img src="../../../static/q2.png" />
					<div>
						<div>Fiat</div>
						<div>
							<span>AUD</span>
							<span>4200</span>
						</div>
					</div>
				</div>
				<div  class="account2-3" >
					<div>
						<div>BTC</div>
						<div>10</div>
					</div>
					<div>
						<div>ETH</div>
						<div>10</div>
					</div>
					<div>
						<div>XRP</div>
						<div>30</div>
					</div>
					<div>
						<div>LTC</div>
						<div>70</div>
					</div>
					<div>
						<div>BNB</div>
						<div>30</div>
					</div>
				</div>
			</div>
		</div>
		<div class="account3">
			<!-- <div class="account3-1">Select Network</div>
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
			</div> -->
			<div class="account3-1">Select Network</div>
			<div class="account3-2"></div>
			<div class="account3-3" v-for="(gtem, index) in alllist" :key="index">
				<div :style="{ backgroundImage: 'url(' + gtem.wimage + ')' }" class="account3-3-1 shou" @click="forall(gtem.id)">
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
			
				{ wimage: require('../../../static/xpath3.png'), msg: 'Buy BTC with credit card now  >', checked: false, id: 1, title: 'American Express:', clicktype: 'Buy/Sell' },
				
				{ wimage: require('../../../static/xpath4.png'), msg: 'Buy BTC with credit card now  >', checked: false, id: 2, title: 'MasterCard:', clicktype: 'Buy/Sell' }
			],
			alllist: [
				{ wimage: require('../../../static/1all.png'), msg: 'Three credit card types >', checked: true, id: 0, title: 'Credit Card', clicktype: 'Next' },
				{ wimage: require('../../../static/2all.png'), msg: 'Optional currency to buy >', checked: false, id: 1, title: 'Select currency', clicktype: 'Next' },
			],
			newlist2:[
				{ wimage: require('../../../static/xpath2.png'), msg: '12uvW2iVm41z4aiotu5L7LDaN3DA6Tqh2L', checked: true, id: 0, title: 'ETH Address:', clicktype: 'Copy Address' },
					{ wimage: require('../../../static/xpath1.png'), msg: '12uvW2iVm41z4aiotu5L7LDaN3DA6Tqh2L', checked: false, id: 1, title: 'BTC Address:', clicktype: 'Copy Address' },
			],
			dialogTableVisible1:false,
			dialogTableVisible2:false
		};
	},
	methods:{
		fortu1(e) {
			this.newlist.forEach(gtem => {
				gtem.checked = false;
			});
			this.newlist[e].checked = true;
		},
		fortu2(e) {
			this.newlist2.forEach(gtem => {
				gtem.checked = false;
			});
			this.newlist2[e].checked = true;
		},
		forall(e){
			if(e==0){
				this.dialogTableVisible1=true
			}else if(e==1){
				this.dialogTableVisible2=true
			}
			}
		
	}
	}
</script>

<style scoped="scoped">
	.xiant{
		height:1px;
		margin-top: 22px;
		background-color: rgba(238, 238, 238, 1);
	}
	.tanchu {
		
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
	.xianx{
		width:1px;
		height:114px;
		position: absolute;
		background: rgba(208, 208, 208, 1);
		margin-left: 544px;
		margin-top: 10px;
	}
	.account2-3{
		margin-left: 113px;
		display: flex;
		font-size:17px;
		font-family:SFUIDisplay-Regular,SFUIDisplay;
		font-weight:400;
		color:rgba(102,102,102,1);
		margin-top: 10px;
	}
	.account2-3>div:nth-of-type(1){
		margin-left: 0px;
	}
	.account2-3>div>div:nth-of-type(2){
		color: rgba(51, 51, 51, 1);
	}
	.account2-3>div{
		margin-left: 45px;
	}
	.account2-2-1{
		display: flex;
		align-items: center;
		}
	.account2-2-1>img:nth-of-type(1){
		width:58px;
		height:58px;
		margin-left: 32px;
	}
	.account2-2-1>img:nth-of-type(2){
		width:58px;
		height:58px;
		margin-left: 355px;
	}
	.account2-2-1>div:nth-of-type(1){
		margin-left: 23px;
		font-size:17px;
		font-weight:400;
		color:rgba(153,153,153,1);
	}
	.account2-2-1>div:nth-of-type(2){
		margin-left: 23px;
		font-size:17px;
		font-weight:400;
		color:rgba(153,153,153,1);
	}
	.account2-2-1>div:nth-of-type(2)>div:nth-of-type(1){
		font-weight:400;
		color:rgba(153,153,153,1);
	}
	.account2-2-1>div:nth-of-type(2)>div:nth-of-type(2){
	font-size:14px;
	font-weight:400;
	color:rgba(102, 102, 102, 1)
	}
	.account2-2-1>div:nth-of-type(2)>div:nth-of-type(2)>span:nth-of-type(2){
	font-size:19.71px;
	font-weight:600;
	margin-left: 5px;
	color:rgba(0, 195, 255, 1)
	}
	.account2-2-1>div:nth-of-type(1)>div:nth-of-type(2){
		font-size:19.71px;
		font-weight:600;
		color:rgba(0, 195, 255, 1);
	}
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
		width: 50%;
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
		height: 40%;
		width: 50%;
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
	
	.account2-2 {
		margin-top: 17px;
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
