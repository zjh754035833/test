<template>
	<div class="all">
		<div class="toparea">
			<div class="text1" v-for="item in list" :key=item.index>
				<div>{{ item.msg }}</div>
				<div style="height: 3px;"></div>
				<span>{{ item.price }}</span>
				<span style="color: rgba(238, 66, 86, 1);" v-if="item.priceper > 0">{{ item.priceper }}%</span>
				<span style="color: rgba(1, 211, 210, 1)" v-if="item.priceper < 0">{{ item.priceper }}%</span>
			</div>
		</div>
		<div class="halfarea">
			<div class="halfarea-1">
				<span class="box1">AUWELS</span>
				<div class="box3">
					<span @click="forbuyshell" style="z-index: 1;">Buy/Sell</span>
					<span @click="forAnction">Anction</span>
					<span @click="forSavings">Savings</span>
					<span @click="forMining">Mining</span>
				</div>
				<img src="../../static/Fill.png" class="box2" />
				<div class="box5">
					<span @click="forsignup">sign up</span>
					<span @click="forlogin">login</span>
				</div>
			</div>
			<div class="halfarea-2">
				<div>Build. Understand. G</div>
				<div>Auwels is a platform that helps your mobile team build better apps, understand your users, and grow your business.</div>
				<div class="shou">learn more</div>
			</div>
		</div>
		<div class="bottomarea4">
			<div class="bottomarea4-1">OUR STRENGTHS</div>
			<div class="boxzall">
				<div class="z1">
					<img src="../../static/x3.png" class="z-img1" />
					<div class="xx">Market</div>
					<div class="xx2">best rates on the market</div>
				</div>
				<div class="z2">
					<img src="../../static/x2.png" class="z-img2" />
					<div class="xx">Market</div>
					<div class="xx2">best rates on the market</div>
				</div>
				<div class="z3">
					<img src="../../static/x1.png" class="z-img3" />
					<div class="xx">Market</div>
					<div class="xx2">fast transaction</div>
				</div>
			</div>
		</div>
		<div class="index1">
			<img src="../../static/mobile1.png" />
			<div class="index1-1">The simplest way to have a professioanal webpage.</div>
			<div class="index1-2">Get all the benefits of an in-wall or in-ceiling speaker system without any of the hassle. Just replace a few lights around your house, and start streaming crisp, clear audio, everywhere.</div>
		</div>
		<div class="index2">
			<img src="../../static/mobile2.png" />
			<div>Trade on the go</div>
			<div>Take Poloniex everywhere you go with our apps.</div>
			<img src="../../static/dowload2.png" />
			<img src="../../static/dowload1.png" />
		</div>
	
		<!-- <div class="bottomarea5">
			<div class="bottomarea5-1">OUR ADVANTAGE</div>
			<div class="bottomarea5-2">
				<div>
					<div>Streamlined</div>
					<div>
						Buy crypto and deposit it directly to your Auwels wallet: start trading on the world’s leading crypto exchange in an instant! Once you use one of the
						options above to buy Bitcoin and other crypto, your purchased crypto will go directly to your Auwels account.
					</div>
				</div>
				<div><img src="../../static/S4.png" /></div>
				<div>
					<div>Reliable</div>
					<div>We work with the most trustworthy third-party partners to make your crypto-buying experience easy and convenient.</div>
				</div>
			</div>
			<div class="bottomarea5-3">
				<div><img src="../../static/S5.png" /></div>
				<div>
					<div>Many Options</div>
					<div>
						Pick from the various payment methods here. Buy Bitcoin with credit card (You can also buy XRP, ETH, LTC and BCH), or buy crypto with US Dollars or Euro
						through TUSD or PAX stablecoins. You also have options to turn your TUSD or PAX back into cash.
					</div>
				</div>
				<div><img src="../../static/S2.png" class="imgs2" />
				</div>
			</div>
		</div> -->
		<div class="bottomarea"></div>
		<v-footer></v-footer>
	</div>
</template>

<script>
import footer from '../../build/foot/foot.vue';

export default {
	components: {
		'v-footer': footer
	},
	data() {
		return {
			list: [
				{ msg: 'Bitcoin 24h', priceper: '-4.95', price: '$8,148.85' },
				{ msg: 'Ethereum 24h', priceper: '-4.95', price: '$8,148.85' },
				{ msg: 'XRP 24h', priceper: '+4.95', price: '$8,148.85' },
				{ msg: 'Bitcoin Cash 24h', priceper: '+4.95', price: '$8,148.85' },
				{ msg: 'Litecoin 24h', priceper: '-4.95', price: '$8,148.85' }
			]
		};
	},
	methods: {
			forbuyshell() {
					this.$router.push({ path: '/sellbuy' });
				},
				forAnction() {
					this.$router.push({ path: '/newAnction' });
				},
				forSavings() {
					this.$router.push({ path: '/Savings' });
				},
				forMining() {
					this.$router.push({ path: '/Mining' });
				},
				forlogin(){
					this.$router.push({ path: '/login' });
				},
				forsignup(){
						this.$router.push({ path: '/signup' });
				}
	
	},
	created() {},
	mounted() {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	.index2>div:nth-of-type(2){
		margin-top: 294px;
		margin-left: 752px;
		font-size:26px;
		font-family:SFUIDisplay-Bold,SFUIDisplay;
		font-weight:bold;
	color:rgba(153,153,153,1);
		position: absolute;
	}
	.index2>div:nth-of-type(1){
		margin-top: 220px;
		margin-left: 752px;
		font-size:51px;
		font-family:SFUIDisplay-Bold,SFUIDisplay;
		font-weight:bold;
		color:rgba(51,51,51,1);
		line-height:61px;
		position: absolute;
	}
	.index2{
		width:1439px;
		height:618px;
		background:rgba(247,247,247,1);
		border-radius:2px;
		
	}
	.index2>img:nth-of-type(1){
		width: 506px;
		height: 523px;
		position: absolute;
		margin-top: 95px;
		margin-left: 172px;
	}
	.index2>img:nth-of-type(2){
		width:215px;
		height:72px;
		position: absolute;
		margin-top: 376px;
		margin-left: 752px;
	}
	.index2>img:nth-of-type(3){
		width:215px;
		height:72px;
		position: absolute;
		margin-top: 376px;
		margin-left: 983px;
	}
	.index1{
		width:1440px;
		height:800px;
		background:rgba(10,62,105,1);
	}
	.index1>img{
		width:281px;
		height:578px;
		position: absolute;
		margin-top: 109px;
		margin-left: 257px;
	}
	.index1-1{
		position: absolute;
		margin-top: 258px;
		margin-left: 728px;
		width:475px;
		height:86px;
		font-size:36px;
		font-weight:400;
		color:rgba(255,255,255,1);
		line-height:43px;
	}
	.index1-2{
		position: absolute;
		margin-top: 371px;
		margin-left: 728px;
		width:475px;
		height:150px;
		font-size:18px;
		font-weight:400;
		color:rgba(138,154,183,1);
		line-height:30px;
	}
.imgs2 {
	margin-top: 112px;
	width: 510px;
	height: 242px;
}
.bottomarea5-3 > div:nth-of-type(2) > div:nth-of-type(1) {
	font-size: 25px;
	color: rgba(255, 255, 255, 1);
	margin-top: 123px;
}
.bottomarea5-3 > div:nth-of-type(2) > div:nth-of-type(2) {
	width: 430px;
	font-size: 17px;
	margin-top: 17px;
	color: #97abea;
}
.z-img1 {
	width: 49px;
	height: 61px;
}
.z-img2 {
	width: 76px;
	height: 49px;
}
.z-img3 {
	width: 42px;
	height: 45px;
}
.bottomarea5-2 > div > img {
	margin-top: 120px;
	width: 333px;
	height: 284px;
}
.bottomarea5-3 > div:nth-of-type(1) > img {
	width: 286px;
	height: 337px;
	margin-left: 136px;
}

.bottomarea5-2 > div:nth-of-type(3) {
	margin-top: 158px;
}
.bottomarea5-2 > div > div:nth-of-type(1) {
	font-size: 25px;
	color: rgba(255, 255, 255, 1);
}
.bottomarea5-2 > div > div:nth-of-type(2) {
	width: 430px;
	font-size: 17px;
	margin-top: 17px;
	font-family: ArialMT;
	color: #97abea;
	line-height: 24px;
}
.bottomarea5-2 > div > div:nth-of-type(3) {
	width: 338px;
	font-size: 17px;
	font-family: ArialMT;
	color: rgba(255, 255, 255, 1);
	line-height: 24px;
}

.bottomarea5-3 {
	position: absolute;
	margin-top: 99px;
	margin-left: 731px;
	display: flex;
	flex-direction: column;
}
.bottomarea5-2 {
	position: absolute;
	margin-top: 204px;
	margin-left: 247px;
	display: flex;
	flex-direction: column;
}
.bottomarea5-1 {
	font-size: 27px;
	font-weight: normal;
	color: rgba(255, 255, 255, 1);
	position: absolute;
	width: 1440px;
	margin-top: 44px;
	text-align: center;
}
.bottomarea5 {
	width: 1440px;
	height: 1185px;
	background: rgba(30, 73, 211, 1);
	border-radius: 1px;
}
.xx2 {
	position: absolute;
	margin-top: 100px;
	color: #828A93;
}
.xx {
	position: absolute;
	margin-top: 60px;
}
.boxzall {
	width: 1440px;
	display: flex;
	margin-top: 80px;
	position: absolute;
	justify-content: center;
}
.z1 {
	width: 400px;
	display: flex;
	flex-direction: column;
	align-items: center;
	color: rgba(255, 255, 255, 1);
	font-size: 22px;
}
.z2 {
	width: 400px;
	display: flex;
	flex-direction: column;
	align-items: center;
	color: rgba(255, 255, 255, 1);
	font-size: 22px;
}
.z3 {
	width: 400px;
	display: flex;
	flex-direction: column;
	align-items: center;
	color: rgba(255, 255, 255, 1);
	font-size: 22px;
}
.z1 > img {
	width: 49px;
	height: 45px;
}
.bottomarea4-1 {
	width: 1440px;
	text-align: center;
	font-size:20px;
	color:rgba(102,117,127,1);
	position: absolute;
	margin-top: 20px;
}
.bottomarea4 {
	width: 1440px;
height:259px;
	background: rgba(0, 17, 35, 1);
}
.bottomarea {
	background-image: url('../../static/TrustedBy.png');
	width: 1440px;
	height: 141px;
	background-size: 100%;
}
.halfarea-2 {
	display: flex;
	position: absolute;
	flex-direction: column;
	margin-left: 116px;
}
.halfarea-2 > div:nth-of-type(1) {
	margin-top: 197px;
	width: 470px;
	height: 47px;
	font-size: 42px;
	color: rgba(255, 255, 255, 1);
	line-height: 48px;
}
.halfarea-2 > div:nth-of-type(2) {
	margin-top: 23px;
	width: 460px;
	font-size: 22px;
	color: rgba(255, 255, 255, 1);
	line-height: 32px;
}
.halfarea-2 > div:nth-of-type(3) {
	margin-top: 43px;
	width: 178px;
	height: 57px;
background:rgba(0,195,255,1);
	border-radius: 2px;
	border: 1px solid rgba(69, 141, 254, 1);
	font-size: 22px;
	color: rgba(255, 255, 255, 1);
	line-height: 57px;
	text-align: center;
}
.box5 {
	position: absolute;
	margin-top: 30px;
	display: flex;
	font-size: 18px;
	font-weight: normal;
	color: rgba(255, 255, 255, 1);
	margin-left: 1109px;
}
.box5 > span {
	width: 95px;
	height: 31px;
	border-radius: 2px;
	border: 1px solid rgba(255, 255, 255, 1);
	text-align: center;
	line-height: 31px;
	font-weight: bold;
	cursor: pointer;
}
.box5 > span:nth-of-type(2) {
	margin-left: 22px;
	background:rgba(0,195,255,1);
	border: 0px solid rgba(255, 255, 255, 1);
}
.box3 {
	position: absolute;
	margin-top: 30px;
	display: flex;
	font-size: 18px;
	font-weight: normal;
	color: rgba(255, 255, 255, 1);
}

.box3:nth-of-type(1) {
	margin-left: 453px;
}
.box3 > span {
	font-weight: bold;
	cursor: pointer;
	margin-left: 54px;
}
.box2 {
	position: absolute;
	margin-left: 120px;
	margin-top: 28px;
	width: 37px;
	height: 34px;
}
.box1 {
	position: absolute;
	margin-top: 19px;
	margin-left: 182px;
	font-size: 34px;
	font-weight: 900;
	color: rgba(255, 255, 255, 1);
}
.halfarea {
	background-image: url('../../static/Group.png');
	width: 1440px;
	height: 710px;
	background-size: 100%;
}

.text1 {
	font-size: 16px;
	color: rgba(84, 95, 107, 1);
	line-height: 18px;
	margin-top: 16px;
}

.text1 > span {
	font-size: 16px;
	font-weight: normal;
	color: rgba(255, 255, 255, 1);
	line-height: 18px;
}
.toparea {
	width: 1440px;
	height: 76px;
	background: rgba(0, 17, 35, 1);
	justify-content: space-around;
	border-radius: 1px;
	z-index: -1;
	display: flex;
}
</style>
