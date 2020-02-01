<template>
	<div>
		<div class="creatauction">
			<div class="creatauction1">
				<div class="creatauction1-1">
					<div>Creat an auction for you own</div>
					<div>Advertisement rules and requirements</div>
					<div>
						<li>
							For your ads to display you need to have Bitcoins in your Auwels wallet. You need 0.04 BTC or more for
							<br />
							with online payment methods.
						</li>
						<li>Certain payment methods require you to be ID verified before your ads are visible.</li>
						<li>Each completed trade costs advertisers 1% of the total trade amount. See all fees on our fees page.</li>
						<li>Once a trade is opened the price is final, except when there is a clear mistake in the pricing.</li>
						<li>You are not allowed to buy or sell Bitcoin on behalf of someone else (brokering).</li>
						<li>You may only use payment accounts that are registered in your own name (no third party payments!).</li>
						<li>You must provide your payment details in the advertisement or in the trade chat.</li>
						<li>All communication must happen on Auwels.com.</li>
						<li>
							Payment methods marked High Risk have a significant risk of fraud. Be careful and always ID verify your trading
							<br />
							partners when using high risk payment methods.
						</li>
					</div>
					<div>Trade type</div>
					<div>
						<div>I want to sell my coins online</div>
						<div>
							<el-select v-model="value" clearable placeholder="Bit coin">
								<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
							</el-select>
						</div>
					</div>
					<div>More information</div>
					<div class="biaodan">
						<div>
							<div>Amount</div>
							<input />
							<div>Market Value</div>
							<div>$4000</div>
						</div>
						<div><li style="margin-left: 20px;">If you wish to sell bitcoins make sure you have bitcoins in your Auwes wallet.</li></div>
						<div>
							<div>Bid Increment</div>
							<input @input="forvalue1" value="$" />
						</div>
						<div><li style="margin-left: 20px;">Bid Increment: The amount by which the auctioneer increases the bidding.</li></div>
						<div>
							<div>Starting from</div>
							<input @input="forvalue2" value="$" />
						</div>
						<div>
							<div>Set an reserve price</div>
							<div class="xuankuang">
								<el-radio v-model="radio1" label="1">Yes</el-radio>
								<el-radio v-model="radio1" label="2" style="margin-top: 60px;">NO</el-radio>
							</div>
							<input @input="forvalue3" value="$" />
						</div>
						<div>
							<li>Reserve price: Never formally disclosed, the reserve price is the confidential minimum price agreed upon</li>
							<div>between the consignor and Auwels. if bidding ends before the reserve is reached, the coin will not be sold.</div>
						</div>
						<div class="bottomarea">
							<span>Opening hours</span>
							<input />
							<span>Days</span>
							<input />
							<span>hours</span>
							<input />
							<span>minutes</span>
							<li>Up to 2 days</li>
						</div>
						<div class="boottompost"><div class="forpost shou">post</div></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			radio1: '1',
			value: 'Bitcoin',
			options: [
				{
					value: '选项1',
					label: 'ETH'
				},
				{
					value: '选项2',
					label: 'Bitcoin cash'
				},
				{
					value: '选项3',
					label: 'Bitcoin'
				}
			]
		};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		forvalue1(e) {
			window.console.log(e.target.value);
			if (e.target.value == '' || e.target.value == null) {
				e.target.value = '$';
			}
		},
		forvalue2(e) {
			window.console.log(e.target.value);
			if (e.target.value == '' || e.target.value == null) {
				e.target.value = '$';
			}
		},
		forvalue3(e) {
			window.console.log(e.target.value);
			if (e.target.value == '' || e.target.value == null) {
				e.target.value = '$';
			}
		}
	},
	
};
</script>

<style scoped="scoped">
.boottompost {
	width: 100%;
	display: flex;
	justify-content: center;
	margin-top: 59px;
}
.forpost {
	width: 456px;
	height: 50px;
	background: rgba(0, 195, 255, 1);
	border-radius: 1px;
	color: rgba(255, 255, 255, 1);
	text-align: center;
	line-height: 50px;
}
.bottomarea > input {
	width: 67px;
	height: 40px;
	margin-left: 30px;
	font-size: 17px;
	text-align: center;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.bottomarea > span {
	margin-left: 13px;
}
.bottomarea > li {
	font-size: 15px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	margin-left: 23px;
}
.bottomarea {
	margin-top: 23px;
	display: flex;
	height: 50px;
	align-items: center;
	color: rgba(102, 102, 102, 1);
	margin-left: 25px;
	font-size: 17px;
}
.biaodan > div:nth-of-type(7) > li:nth-of-type(1) {
	font-size: 15px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
}

.biaodan > div:nth-of-type(7) > div {
	font-size: 15px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	padding-left: 20px;
}
.biaodan > div:nth-of-type(7) {
	width: 924px;
	display: flex;
	flex-direction: column;
	padding-left: 5px;
	margin-top: 21px;
	justify-content: center;
	font-size: 15px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	height: 60px;
	background: rgba(242, 242, 242, 1);
	border-radius: 2px;
	margin-left: 25px;
}
.xuankuang {
	display: flex;
	flex-direction: column;
	margin-left: 47px;
	margin-top: 5px;
}
.biaodan > div:nth-of-type(6) {
	display: flex;
	margin-top: 32px;
}
.biaodan > div:nth-of-type(6) > div:nth-of-type(1) {
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	margin-left: 25px;
}
.biaodan > div:nth-of-type(6) > input {
	width: 147px;
	height: 40px;
	font-size: 17px;
	text-align: center;
	margin-left: 25px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.biaodan > div:nth-of-type(5) {
	display: flex;
	margin-top: 21px;
	height: 40px;
	align-items: center;
}
.biaodan > div:nth-of-type(5) > div {
	font-size: 17px;
	font-weight: 400;
	margin-left: 25px;
	color: rgba(102, 102, 102, 1);
}
.biaodan > div:nth-of-type(5) > input {
	width: 147px;
	height: 40px;
	font-size: 17px;
	text-align: center;
	margin-left: 60px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}

.biaodan > div:nth-of-type(3) {
	display: flex;
	margin-top: 21px;
	height: 40px;
	align-items: center;
}
.biaodan > div:nth-of-type(4) {
	font-size: 13px;
	font-weight: 400;
	width: 747px;
	height: 30px;
	display: flex;
	align-items: center;
	background: rgba(242, 242, 242, 1);
	margin-left: 25px;
	margin-top: 10px;
	border-radius: 2px;
	color: rgba(153, 153, 153, 1);
}

.biaodan > div:nth-of-type(3) > div {
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	margin-left: 25px;
}
.biaodan > div:nth-of-type(3) > input {
	width: 147px;
	height: 40px;
	font-size: 17px;
	text-align: center;
	margin-left: 52px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.biaodan > div:nth-of-type(1) {
	display: flex;
	height: 40px;
	align-items: center;
	margin-left: 25px;
}
.biaodan > div:nth-of-type(2) {
	display: flex;
	align-items: center;
	margin-top: 10px;
	margin-left: 25px;
	width: 747px;
	height: 30px;
	background: rgba(242, 242, 242, 1);
	border-radius: 2px;
	font-size: 13px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
}
.biaodan > div:nth-of-type(1) > input {
	width: 147px;
	height: 40px;
	font-size: 17px;
	text-align: center;
	margin-left: 52px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.biaodan > div:nth-of-type(1) > div:nth-of-type(2) {
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	margin-left: 52px;
}
.biaodan > div:nth-of-type(1) > div:nth-of-type(3) {
	font-size: 15px;
	font-weight: bold;
	margin-left: 8px;
	color: rgba(51, 51, 51, 1);
}
.biaodan > div:nth-of-type(1) > div:nth-of-type(1) {
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.biaodan {
	width: 1012px;
	height: 649px;
	background: RGBA(250, 250, 250, 1);
	border-radius: 2px;
	margin-top: 10px;
}
.creatauction1-1 {
	margin-left: 65px;
	margin-top: 28px;
	font-size: 26px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
}
.creatauction1-1 > div:nth-of-type(2) {
	margin-top: 10px;
}
.creatauction1-1 > div:nth-of-type(3) {
	width: 1018px;
	height: 342px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	background: rgba(246, 246, 246, 1);
	border-radius: 2px;
}
.creatauction1-1 > div:nth-of-type(4) {
	font-size: 21px;
	margin-top: 32px;
}
.creatauction1-1 > div:nth-of-type(5) {
	width: 1013px;
	height: 76px;
	background: rgba(246, 246, 246, 1);
	border-radius: 2px;
	display: flex;
	align-items: center;
	margin-top: 10px;
}
.creatauction1-1 > div:nth-of-type(6) {
	margin-top: 22px;
	font-size: 21px;
}
.creatauction1-1 > div:nth-of-type(5) > div:nth-of-type(1) {
	font-size: 17px;
	color: rgba(102, 102, 102, 1);
	margin-left: 32px;
}
.creatauction1-1 > div:nth-of-type(5) > div:nth-of-type(2) {
	font-size: 17px;
	width: 147px;
	height: 40px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	margin-left: 75px;
}
.creatauction1-1 > div:nth-of-type(3) > li {
	font-size: 14px;
	margin-top: 5px;
	font-weight: 400;
	margin-left: 10px;
	color: rgba(51, 51, 51, 1);
}
.creatauction1 {
	width: 1146px;
	margin-top: 20px;
	height: 1331px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 17px 0px rgba(219, 219, 219, 0.5);
}
.creatauction {
	display: flex;
	justify-content: center;
}
</style>
