<template>
	<div>
		<div class="Cryptoall">
			<div class="Cryptoall-1">
				<div class="Cryptoall-1-1">
					<span>Wallet</span>
					<span>/Crypto Dposit</span>
					<img src="../../../static/crytow2.png" />
					<span>Buy BTC with credit card now>></span>
				</div>
				<div class="Cryptoall-2">
					<div class="Cryptoall-2-1">
						<div class="Cryptoall-2-1-1">
							<div class="Cryptoall-2-1-2">
								<div class="Cryptoall-2-1-2-1">Select Network:</div>
								<div class="Cryptoall-2-1-2-2">
									<img src="../../../static/smalbtc.png" />
									<span>BTC</span>
								</div>
							</div>
							<div class="Cryptoall-2-1-3">
								<div>BTC Adress:</div>
								<input />
								<div>
									<div>
										<img class="dopimg" src="../../../static/dop2.png" />
										Copy Address
									</div>
									<div>
										<img class="dopimg" src="../../../static/dop1.png" />
										Show QR code
									</div>
								</div>
							</div>
						</div>
						<div class="Cryptoall-2-1-4">
							<li>Send only BTC to this deposit address.</li>
							<div>Sending coin or token other than BTC to this address may result in the loss of your deposit.</div>
						</div>
					</div>
					<div class="Cryptoall-2-2">
						<div>Coin:</div>
						<div>
							<img src="../../../static/smalbtc.png" class="smallbtc" />
							<span style="margin-left: 43px;position: absolute;z-index: 99;font-size:15px;">BTC</span>
							<el-select v-model="value" placeholder="Bitcoin">
								<el-option v-for="item in cities" :key="item.value" :label="item.label" :value="item.value">
									<span style="float: left">{{ item.label }}</span>
									<span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>
								</el-option>
							</el-select>
						</div>
						<div>
							<span class="Cryptoallspan1">Total balance</span>
							<span class="Cryptoallspan2">992,329,12</span>
							<span class="Cryptoallspan3">BTC</span>
						</div>
						<li>
							Coins will be depostied after
							<span>1</span>
							network confirmations
						</li>
					</div>
				</div>
				<div class="Cryptoall-3">
					<span>Recent Deposit History</span>
					<span>View all</span>
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
	</div>
</template>

<script>
export default {
	components: {
	},
	data() {
		return {
			tableData: [],
			cities: []
		};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {}
};
</script>

<style scoped="scoped">
/deep/.el-table::before {
	left: 0;
	bottom: 0;
	width: 100%;
	height: 0px;
}
.data-pic {
	width: 63px;
	height: 70px;
	margin-top: 88px;
}
.Cryptoall-4 {
	width: 1175px;
	margin-left: 36px;
	margin-top: 18px;
}
.Cryptoall-3 {
	display: flex;
	align-items: center;
	margin-top: 24px;
}
.Cryptoall-3 > span:nth-of-type(1) {
	font-size: 20px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-left: 36px;
}
.Cryptoall-3 > span:nth-of-type(2) {
	font-size: 16px;
	font-weight: 400;
	color: rgba(0, 195, 255, 1);
	text-decoration: underline;
	margin-left: 870px;
}
.Cryptoallspan1 {
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	margin-left: 16px;
}
.Cryptoallspan2 {
	font-size: 18px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
	margin-left: 197px;
}
.Cryptoallspan3 {
	font-size: 18px;
	margin-left: 10px;
	font-weight: 400;
	color: RGBA(207, 207, 207, 1);
}
/deep/ .el-input__inner {
	padding-left:100px;
}
.Cryptoall-2-2 > div:nth-of-type(1) {
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	margin-left: 26px;
	margin-top: 19px;
}
.Cryptoall-2-2 > div:nth-of-type(2) {
	display: flex;
	width: 227px;
	height: 38px;
	margin-left: 26px;
	margin-top: 15px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	align-items: center;
}
.Cryptoall-2-2 > div:nth-of-type(3) {
	width: 462px;
	height: 70px;
	margin-left: 26px;
	display: flex;
	align-items: center;
	margin-top: 17px;
	background: rgba(255, 255, 255, 1);
	border-radius: 2px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.Cryptoall-2-2 > li {
	font-size: 16px;
	font-weight: 400;
	margin-left: 33px;
	margin-top: 29px;
	color: rgba(102, 102, 102, 1);
}
.smallbtc {
	position: absolute;
	z-index: 10;
	width: 21px;
	height: 21px;
	margin-left: 16px;
}
.Cryptoall-2-1-4 {
	margin-top: 52px;
	margin-left: 25px;
}
.Cryptoall-2-1-4 > li {
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.Cryptoall-2-1-4 > div {
	font-size: 13px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
}
.dopimg {
	width: 15px;
	height: 15px;
	margin-right: 4px;
}
.Cryptoall-2-1-3 {
	display: flex;
	flex-direction: column;
	margin-left: 57px;
	justify-content: center;
}
.Cryptoall-2-1-3 > div:nth-of-type(1) {
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.Cryptoall-2-1-3 > div:nth-of-type(2) {
	display: flex;
	margin-top: 15px;
}
.Cryptoall-2-1-3 > div:nth-of-type(2) > div:nth-of-type(1) {
	width: 134px;
	height: 38px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	font-size: 15px;
	font-weight: 400;
	display: flex;
	justify-content: center;
	align-items: center;
	color: rgba(51, 51, 51, 1);
	border: 1px solid rgba(218, 218, 218, 1);
}
.Cryptoall-2-1-3 > div:nth-of-type(2) > div:nth-of-type(2) {
	width: 158px;
	height: 38px;
	font-size: 15px;
	display: flex;
	margin-left: 20px;
	justify-content: center;
	align-items: center;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.Cryptoall-2-1-3 > input {
	width: 373px;
	margin-top: 19px;
	height: 38px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.Cryptoall-2-1-2-2 > img {
	width: 21px;
	height: 21px;
}
.Cryptoall-2-1-2-2 > span {
	font-size: 15px;
}
.Cryptoall-2-1-2-2 {
	width: 111px;
	height: 38px;
	margin-top: 18px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
	display: flex;
	justify-content: center;
	align-items: center;
}
.Cryptoall-2-1-2-1 {
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.Cryptoall-2-1-1 {
	display: flex;
	margin-top: 18px;
	margin-left: 25px;
}
.Cryptoall-2 {
	display: flex;
	justify-content: center;
	margin-top: 32px;
}
.Cryptoall-2-1 {
	width: 616px;
	height: 269px;
	background: RGBA(248, 248, 248, 1);
}
.Cryptoall-2-2 {
	width: 548px;
	margin-left: 10px;
	height: 269px;
	display: flex;
	flex-direction: column;
	background: RGBA(248, 248, 248, 1);
}
.Cryptoall-1-1 {
	width: 100%;
	display: flex;
	margin-top: 22px;
	align-items: center;
}
.Cryptoall-1-1 > span:nth-of-type(1) {
	font-size: 19px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	margin-left: 32px;
}
.Cryptoall-1-1 > span:nth-of-type(2) {
	font-size: 19px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
}
.Cryptoall-1-1 > span:nth-of-type(3) {
	font-size: 15px;
	font-weight: 400;
	margin-left: 12px;
	color: rgba(102, 102, 102, 1);
}
.Cryptoall-1-1 > img {
	width: 26px;
	height: 24px;
	margin-left: 650px;
}
.Cryptoall {
	display: flex;
	justify-content: center;
	align-items: center;
}
.Cryptoall-1 {
	width: 1241px;
	height: 778px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 17px;
	margin-bottom: 40px;
}
</style>
