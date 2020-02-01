<template>
	<div class="walletall">
		<div v-if="deposittype == true"><v-checkdeposit @funcdeposit="funcdeposit"></v-checkdeposit></div>
		<div class="walletall-1">
			<div class="walletall-1-1">
				<div>My Wallet</div>
				<img src="../../../static/tianyan.png" />
				<div @click="forDeposit()" class="shou">Deposit</div>
				<div @click="fordraw()" class="shou">Withdraw</div>
			</div>
			<div class="walletall-1-2"></div>
			<div class="walletall-1-3">
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
			<div class="walletall-2-1">
				<div class="walletall-2-1-1" v-if="Cryptoblue != true" @mouseenter="forblue(1)">Crypto Details</div>
				<div class="walletall-2-1-2" v-if="Cryptoblue == true">
					Crypto Details
					<div class="dixian"></div>
				</div>
				<div class="walletall-2-1-1" v-if="Fiatblue != true" style="margin-left: 100px;" @mouseenter="forblue(2)">Fiat Details</div>
				<div class="walletall-2-1-2" v-if="Fiatblue == true" style="margin-left: 100px;">
					Fiat Details
					<div class="dixian"></div>
				</div>
			</div>
			<div class="walletall-3">
				<el-table :data="tableData" style="width: 100%" header-cell-style="background-color:rgba(245,245,245,1);">
						<el-table-column prop="Coin" label="Coin" width="120" align="center">
							
							<template slot-scope="scope">
							<img :src="scope.row.Coin" style="width:43px;
height:38px;" />
							</template></el-table-column>

					<el-table-column prop="Name" label="Name" width="120"></el-table-column>
					<el-table-column prop="Totalbalance" label="Total balance" width="260"></el-table-column>
					<el-table-column prop="Availablebalance" label="Available balance" width="260"></el-table-column>
					<el-table-column prop="Inorder" label="In order" width="200"></el-table-column>
					<el-table-column prop="Action" label="Action" align="center">
						<template>
							<span class="walletall-3-1">Deposit</span>
							<span class="walletall-3-2">Withdraw</span>
							<span class="walletall-3-3">Anction</span>
						</template>
					</el-table-column>
				</el-table>
			</div>
		</div>
	</div>
</template>

<script>
import checkdeposit from '../checksg/checkdeposit.vue';
export default {
	components: {
		'v-checkdeposit': checkdeposit
	},
	data() {
		return {
			checktype: false,
			deposittype: false,
			Cryptoblue: true,
			Fiatblue: false,
			tableData1: [
				{
					Coin: require('../../../static/smalbtc.png'),
					Name: 'BTC',
					Totalbalance: '$112,111,00',
					Availablebalance: 'Available balance',
					Inorder: '$112,111,00'
				},
				{
					Coin: require('../../../static/newsell2.png'),
					Name: 'AUD',
					Totalbalance: '$112,111,00',
					Availablebalance: 'Available balance',
					Inorder: '$112,111,00'
				}
			],
			tableData: [
			]
		};
	},
	mounted() {
		this.tableData=this.tableData1;
	},
	methods: {
		forblue(e) {
			if (e == 1) {
				this.tableData=this.tableData1;
				this.Cryptoblue = true;
				this.Fiatblue = false;
			} else if (e == 2) {
				this.Cryptoblue = false;
				this.Fiatblue = true;
				this.tableData=[];
			}
		},
		forDeposit() {
			this.deposittype = true;
		},
		funcdeposit(data) {
			this.deposittype = data;
		},
		fordraw() {
			this.$router.push({ path: '/withdraw' });
		}
	}
};
</script>

<style scoped="scoped">
.walletall-3-1 {
	font-size: 16px;
	font-weight: 400;
	margin-right: 20px;
	color: rgba(153, 153, 153, 1);
}
.walletall-3-2 {
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	text-decoration: underline;
}
.walletall-3-3 {
	font-size: 16px;
	margin-left: 20px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	text-decoration: underline;
}
.walletall-3 {
	margin-top: 5px;
}
.walletall-2-1-1 {
	font-size: 20px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
	margin-left: 33px;
	cursor: pointer;
}
.walletall-2-1-2 {
	font-size: 20px;
	font-weight: bold;
	margin-left: 33px;
	cursor: pointer;
	color: rgba(41, 47, 136, 1);
}
.dixian {
	width: 150px;
	height: 2px;
	background: rgba(41, 47, 136, 1);
	border-radius: 1px;
	position: absolute;
	margin-top: 20px;
}
.walletall-2-1 {
	height: 62px;
	display: flex;
	align-items: center;
}
.walletall-1-3-1 {
	width: 50%;
}
.walletall-1-3-2 {
	width: 50%;
}
.walletxian {
	width: 1px;
	height: 149px;
	background: rgba(232, 231, 231, 1);
	margin-top: 25px;
	opacity: 0.8;
}
.walletall-1-3-1-1 {
	font-size: 18px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
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
.walletall-1-3 {
	display: flex;
}
.walletall-1-2 {
	width: 929px;
	opacity: 0.8;
	height: 1px;
	background: rgba(238, 238, 238, 1);
	margin-left: 28px;
}
.walletall-1-1 {
	display: flex;
	align-items: center;
	height: 54px;
}
.walletall-1-1 > div:nth-of-type(1) {
	font-size: 18px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-left: 32px;
}
.walletall-1-1 > div:nth-of-type(2) {
	width: 76px;
	height: 31px;
	background: rgba(255, 100, 100, 1);
	font-size: 12px;
	font-weight: 400;
	color: rgba(255, 255, 255, 1);
	border: 1px solid rgba(255, 100, 100, 1);
	margin-left: 607px;
	line-height: 31px;
	text-align: center;
}
.walletall-1-1 > div:nth-of-type(3) {
	width: 76px;
	height: 31px;
	border: 1px solid rgba(153, 153, 153, 1);
	font-size: 12px;
	margin-left: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	line-height: 31px;
	text-align: center;
}
.walletall-1-1 > img {
	width: 45px;
	height: 20px;
	margin-left: 13px;
}
.walletall-1 {
	width: 996px;
	height: 269px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-left: 347px;
	position: absolute;
	margin-top: 22px;
}
.walletall-2 {
	width: 996px;
	height: 425px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-left: 347px;
	margin-top: 304px;
	position: absolute;
}
</style>
