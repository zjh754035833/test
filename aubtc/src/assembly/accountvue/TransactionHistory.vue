<template>
	<div>
		<div class="walletall-2">
			<div class="historystyle">
				<div>Transaction History</div>
				<div class="history-2-1-1" v-if="Cryptoblue != true" @mouseenter="forhisblue(1)">Crypto</div>
				<div class="history-2-1-2" v-if="Cryptoblue == true">
					Crypto
					<div class="historydixian"></div>
				</div>
				<div class="history-2-1-1" v-if="Fiatblue != true" style="margin-left: 46px;" @mouseenter="forhisblue(2)">Fiat</div>
				<div class="history-2-1-2" v-if="Fiatblue == true" style="margin-left: 46px;">
					Fiat
					<div class="historydixian"></div>
				</div>
			</div>
			<div class="walletall-2-1">
				<div class="walletall-2-1-1" v-if="Depositsblue != true" @mouseenter="forblue(1)">Deposits</div>
				<div class="walletall-2-1-2" v-if="Depositsblue == true">
					Deposits
					<div class="dixian"></div>
				</div>
				<div class="walletall-2-1-1" v-if="Withdrawalblue != true" style="margin-left: 100px;" @mouseenter="forblue(2)">Withdrawal</div>
				<div class="walletall-2-1-2" v-if="Withdrawalblue == true" style="margin-left: 100px;">
					Withdrawal
					<div class="dixian"></div>
				</div>
			</div>
		<div class="Cryptoall-4">
			<el-table :data="tableData" style="width: 100%" header-cell-style="background-color:rgba(245,245,245,1);">
				<template slot="empty">
					<img class="data-pic" src="../../../static/noshuju.png" alt="" />
					<div>No records found.</div>
				</template>
				<el-table-column prop="Status" label="Status" width="180"></el-table-column>
				<el-table-column prop="Coin" label="Coin" width="180"></el-table-column>
				<el-table-column prop="Amount" label="Amount" width="180"></el-table-column>
				<el-table-column prop="Date" label="Date" width="180"></el-table-column>
				<el-table-column prop="Information" label="Information"></el-table-column>
			</el-table>
		</div>
		</div>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			checktype: false,
			deposittype: false,
			Depositsblue: true,
			Cryptoblue: true,
			Fiatblue: false,
			Withdrawalblue: false,
			tableData: [],
		};
	},
	mounted() {},
	methods: {
		forblue(e) {
			if (e == 1) {
				this.tableData=this.tableData1;
				this.Depositsblue = true;
				this.Withdrawalblue = false;
			} else if (e == 2) {
				this.Depositsblue = false;
				this.Withdrawalblue = true;
				this.tableData=[];
			}
		},
		forhisblue(e){
			if (e == 1) {
				this.tableData=this.tableData1;
				this.Cryptoblue = true;
				this.Fiatblue = false;
			} else if (e == 2) {
				this.Cryptoblue = false;
				this.Fiatblue = true;
				this.tableData=[];
			}
		}
	}
};
</script>

<style scoped="scoped">
	.data-pic {
		width: 63px;
		height: 70px;
		margin-top: 123px;
	}
	/deep/.el-table::before {
		left: 0;
		bottom: 0;
		width: 100%;
		height: 0px;
	}
	.history-2-1-1 {
		font-size:16px;
		font-weight: 400;
		color: rgba(51, 51, 51, 1);
			margin-left: 543px;
		cursor: pointer;
	}
	.history-2-1-2 {
		font-size:16px;
		font-weight: bold;
		margin-left: 543px;
		cursor: pointer;
		color: rgba(41, 47, 136, 1);
	}
	.walletall-2-1-1 {
		font-size:16px;
		font-weight: 400;
		color: rgba(51, 51, 51, 1);
		margin-left: 33px;
		cursor: pointer;
	}
	.walletall-2-1-2 {
		font-size:16px;
		font-weight: bold;
		margin-left: 33px;
		cursor: pointer;
		color: rgba(41, 47, 136, 1);
	}
	.dixian {
		width:80px;
		height: 2px;
		background: rgba(41, 47, 136, 1);
		border-radius: 1px;
		position: absolute;
		margin-top: 10px;
	}
	.historydixian{
		width:55px;
		height: 2px;
		background: rgba(41, 47, 136, 1);
		border-radius: 1px;
		position: absolute;
		margin-top: 7px;
		}
	.walletall-2 {
		width:996px;
		height:711px;
		background:rgba(255,255,255,1);
		box-shadow:0px 2px 12px 0px rgba(220,220,220,0.5);
		border-radius:1px;
		margin-left: 347px;
		margin-top: 17px;
		position: absolute;
	}
	.historystyle{
		height: 75px;
		display: flex;
		align-items: center;
	}
	.historystyle>div:nth-of-type(1){
		font-size:20px;
		font-weight:bold;
		color:rgba(41,47,136,1);
		margin-left: 32px;
	}
	.walletall-2-1 {
		height: 62px;
		display: flex;
		align-items: center;
	}
</style>
