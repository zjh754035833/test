<template>
	<div>
		<div class="resorce1">
			<div class="resorce1-1">
				<input placeholder="Bitcoin exchange rate" />
				<div>
					<img src="../../static/fangda.png" />
					<span>Search</span>
				</div>
			</div>
		</div>
		<div class="resorce2">
			<div class="resorce2-1">
				<div class="img1 shou" @click="forhref('https://www.youtube.com/watch?v=Pl8OlkkwRpc')">
					<div class="z1">
						What is the blockchain?
					</div>
				</div>
				<div class="div1">
					<div style="margin-left: 40px;">
						<div class="z2">This Key Sign Shows Bitcoin Bulls Are Accumulating..</div>
						<div class="z3">
							Bitcoin price is confined in a range below the key $8,200 resistance against the US Dollar, suggesting a short term accumulation phase. BTC could either rally above $8,200 or it might dip to $7,700 before a decent bounce.Bitcoin is moving in a range between $8,200 and $8,000 against the US Dollar.The bulls are likely...
						</div>
						<div class="shou read"  @click="readmore('https://cryptonews.com.au/story/this-key-sign-shows-bitcoin-bulls-are-accumulating-important-levels-to-watch-109532')" >READ MORE</div>
					</div>
				</div>
			</div>
			<div class="resorce2-1">
				<div class="div1">
					<div style="margin-left: 40px;">
						<div class="z2">Reserve Bank of Australia Considers ..</div>
						<div class="z3">
							By Jeff FawkesThe Australian Central Bank has its own blockchain lab since 2018, where they test Ethereum-based private blockchain. The platform securely emulates the...
						</div>
						<div class="shou read" @click="readmore('https://cryptonews.com.au/story/reserve-bank-of-australia-considers-ultimate-ethereum-based-crypto-109349')">READ MORE</div>
					</div>
				</div>
				<div class="img2 shou" @click="forhref('https://www.youtube.com/watch?v=sDNN0uH2Z3o')">
					<div class="z1">
						Why Blockchain Matters More Than You Think!
					</div>
				</div>
			</div>
			<div class="resorce2-1">
				<div class="img3 shou" @click="forhref('https://www.youtube.com/watch?v=UU8Mvy5WY7k')">
					<div class="z1">
						Bitcoin or bitcon?
					</div>
				</div>
				<div class="div1">
					<div style="margin-left: 40px;">
					<div class="z2">Australias Blockchain Roadmap ...</div>
					<div class="z3">
						via Blockchain MagazineThe Department of Industry, Innovation, and Science considers that blockchain is an assuring application in agriculture and food production in Australia, plugging its advantages in providing ....
					</div>
					<div class="shou read"  @click="readmore('https://cryptonews.com.au/story/australias-blockchain-roadmap-to-release-shortly-109286')">READ MORE</div>
					</div>
				</div>
			</div>
		</div>
		<div style="margin-bottom: 51px;"></div>
	</div>
</template>

<script>
export default {
	components: {
	},
	data() {
		return {};
	},
	computed: {},
	mounted() {},
	methods: {
		forhref(e){
			window.location.href=e
		},
		readmore(e){
			window.location.href=e
		}
		
	},
	created() {}
	
	
};
</script>

<style scoped="scoped">
	.read{
		width: 150px;
		height: 40px;
		color: #ffffff;
		background: #282927;
		border-color: #282927;
		border-radius: 15px;
		margin-top: 40px;
		text-align: center;
		font-size: 15px;
		line-height: 40px;
	}
.z1 {
	text-align: center;
	font-size: 30px;
	margin-top: 40px;
	font-weight: bold;
	color: white;
	line-height: 36px;
}
.z2 {
	font-size: 22px;
	font-weight: bold;
	color: black;
	margin-bottom: 20px;
	line-height: 27px;
	margin-top: 17px;
}
.z3 {
	font-size: 15px;
	font-weight: bold;
	color: rgba(153, 153, 153, 1);
	line-height: 27px;
}
.resorce2 {
	display: flex;
	flex-direction: column;
	align-items: center;
}
.img1 {
	background-image: url('../../static/rimg1.png');
	background-size: 100%;
	width: 600px;
	height: 360px;
	
}
.img2 {
	background-image: url('../../static/rimg2.png');
	background-size: 100%;
	width: 600px;
	height: 360px;
}
.img3 {
	background-image: url('../../static/rimg3.png');
	background-size: 100%;
	width: 600px;
	height: 360px;
}
.div1 {
	width: 600px;
	height: 360px;
	display: flex;
	justify-content: center;
	flex-direction: column;
	background: rgba(255, 255, 255, 1);
}
.resorce2-1 {
	display: flex;
}
.resorce1 {
	width: 100%;
	height: 78px;
	background: rgba(46, 46, 46, 1);
	border-radius: 1px;
	display: flex;
	justify-content: center;
	align-items: center;
}
.resorce1-1 > input {
	width: 804px;
	height: 48px;
	background: rgba(247, 247, 247, 1);
	font-size: 19px;
	font-weight: 400;
	color: rgba(153, 153, 153, 0.43);
	padding-left: 35px;
}
.resorce1-1 > div {
	width: 133px;
	display: flex;
	justify-content: center;
	align-items: center;
	background: rgba(255, 227, 145, 1);
}

.resorce1-1 > div > img {
	width: 23px;
	height: 23px;
}
.resorce1-1 > div > span {
	font-size: 19px;
	font-weight: 400;
	margin-left: 10px;
	color: rgba(51, 51, 51, 1);
}
.resorce1-1 {
	display: flex;
}
</style>
