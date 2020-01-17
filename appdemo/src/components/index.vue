<template>
	<div class="indexall">
		<div class="indexallimg">
			<img src="../../static/newimg.png" />
			<div class="giftfont">The gift are probided by our member AUSSIEBIT.(2020-01-17~2020-01-24)</div>
			<img src="../../static/anniu.png" class="shou" @click="forwailian" />
		</div>
		<div class="indextop" style="margin-top: 0px;">
			<div class="index1">
				<div>Why join AAC Australia</div>
				<div>
					<li>Industry Network</li>
					<li>Best-practice Exchange</li>
					<li>Conferences & Academy</li>
					<li>International Networks</li>
					<li>Regulatory Engagement</li>
					<li>Industry Standards & Certification</li>
				</div>
				<div class="shou" @click="formembership">READ MORE</div>
			</div>
			<div class="index2"><img src="../../static/indeximg2.png" /></div>
		</div>
		<div class="indextop">
			<div class="index2"><img src="../../static/indeximg3.png" /></div>
			<div class="index1">
				<div>Cryptocurrency explained</div>
				<div>
					A Cryptocurrency is a digital or virtual currency that is secured by Cryptography, which makes it nearly impossible to counterfeit or double-spend. Many
					Cryptocurrencies are decentralized networks based on Blockchain technology—a distributed ledger enforced by a disparate network of computers.
				</div>
				<div class="shou" @click="forvideo">READ MORE</div>
			</div>
		</div>
		<div class="index3 shou" @click="forvideo">
			<el-carousel :interval="3000" autoplay="true" indicator-position="outside">
				<el-carousel-item v-for="item in swiplist" :key="item" >
					<div class="index3-1">
						<div>{{ item.text1 }}</div>
						<div></div>
						<div >{{ item.text2 }}</div>
					</div>
				</el-carousel-item>
			</el-carousel>
		</div>
		<div class="index6"><div class="index7"></div></div>
		<!-- <div class="index8">
				<span>PARTNERS</span>
				<img src="../../static/indeximg5.png" />
			</div>
			<div class="index6">
				<div class="index7"></div>
			</div> -->
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			swiplist: [
				{
					text1: 'This Key Sign Shows Bitcoin Bulls Are Accumulating..',
					text2:'BitcoinBitcoin price is confined in a range below the key $8,200 resistance against the US Dollar, suggesting a short term accumulation phase. BTC could either rally above $8,200 or it might dip to $7,700 before a decent bounce.Bitcoin is moving in a range between $8,200 and $8,000 against the US Dollar.The bulls are likely aiming an upside break above the $8,200 resistance area.There is a key bearish trend line forming with ...'
				},
				{
					text1: 'Reserve Bank of Australia Considers ..',
					text2:"ByJeff FawkesThe Australian Central Bank has its own blockchain lab since 2018, where they test Ethereum-based private blockchain. The platform securely emulates the Central Bank and commercial banks conducting transactions with each other.Blockchain technology is becoming magic during 2020 when different powerful entities show interest in regulated currencies. Australian crypto gigs won't be too happy, but this is coming, guys.Reserve Bank of Australia Plays with Ethereum.."
				},
				{
					text1: 'Australias Blockchain Roadmap To Release Shortly',
					text2:'viaBlockchain MagazineThe Department of Industry, Innovation, and Science considers that blockchain is an assuring application in agriculture and food production in Australia, plugging its advantages in providing '
				}
			]
		};
	},
	computed: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		
		formembership(){
			this.$router.push({ path: '/Membership' });
		},
		forwailian() {
			window.location.href = 'https://docs.google.com/forms/d/1uTkDsxb65mmh9ieRQVh7oNauaX0b6yAvsTg-W4X26PY/edit?usp=sharing';
		},
		forvideo(){
			this.$router.push({ path: '/resource' });
		}
	},
	created() {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	.giftfont{
		justify-content: center;
		margin-top: 20px;
		font-size: 20px;
		color: #C0C0C0;
	}
.index8 > span {
	font-size: 37px;
	color: rgba(0, 0, 0, 1);
	margin-left: 94px;
}
.index8 > img {
	width: 933px;
	height: 34px;
	margin-right: 92px;
}
.index8 {
	display: flex;
	justify-content: space-between;
	align-items: center;
}
.index8 {
	margin-top: 60px;
}
.index7 {
	width: 1248px;
	height: 1px;
	background-color: rgba(223, 223, 223, 1);
	margin-top: 51px;
}
.index6 {
	width: 100%;
	display: flex;
	justify-content: center;
}
.index4 {
	margin-top: 86px;
	width: 100%;
}
.index3-1 {
	display: flex;
	flex-direction: column;
	align-items: center;
}
.index3-1 > div:nth-of-type(1) {
	font-size: 38px;
	font-family: SFUIDisplay-Regular, SFUIDisplay;
	font-weight: 400;
}
.index3-1 > div:nth-of-type(2) {
	width: 93px;
	height: 4px;
	background: rgba(208, 124, 124, 1);
	margin-top: 20px;
}
.index3-1 > div:nth-of-type(3) {
	width: 1165px;
	height: 175px;
	margin-top: 10px;
	font-size: 25px;
	font-weight: 400;
	text-align: center;
	color: rgba(153, 153, 153, 1);
	line-height: 35px;
}

/deep/ .el-carousel__button:nth-child(2n) {
	width: 9px;
	height: 9px;
	background: rgba(211, 211, 211, 1);
	border-radius: 9px;
}
/deep/ .el-carousel__indicator.is-active button {
	width: 13px;
	height: 13px;
	background: RGBA(208, 124, 124, 1);
	border-radius: 13px;
}
/deep/ .el-carousel__button:nth-child(2n + 1) {
	width: 9px;
	height: 9px;
	background: rgba(211, 211, 211, 1);
	border-radius: 9px;
}
/deep/ .el-carousel__button {
	width: 9px;
	height: 9px;
	border-radius: 9px;
	background: rgba(211, 211, 211, 1);
}
.index3 {
	width: 100%;
	margin-top: 80px;
}
.indextop {
	display: flex;
}

.indexallimg {
	width: 100%;
	height: 670px;
	background-image: url(../../static/indexasd.png);
	background-size: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
}
.indexallimg > img:nth-of-type(1) {
	width: 100%;
	height: 280px;
	margin-top: 100px;
}
.indexallimg > img:nth-of-type(2) {
	width: 222px;
	height: 60px;
	margin-top: 50px;
}
.index1 {
	width: 50%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
.index1 > div:nth-of-type(3) {
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
.index1 > div:nth-of-type(1) {
	font-size: 48px;
	font-weight: bold;
	color: rgba(37, 37, 37, 1);
}
.index1 > div:nth-of-type(2) {
	width: 565px;
	font-size: 18px;
	line-height: 34px;
	font-weight: 400;
	margin-top: 14px;
	color: rgba(149, 149, 149, 1);
}
.index2 {
	width: 50%;
}
.index2 > img {
	width: 100%;
}
</style>
