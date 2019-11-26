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
					<span @click="forbuyshell">Buy/Sell</span>
					<span @click="forAnction">Anction</span>
				</div>
			</div>
			<div class="halfarea-2">
				<div>Build. Understand. G</div>
				<div>Auwels is a platform that helps your mobile team build better apps, understand your users, and grow your business.</div>
				<div class="shou">learn more</div>
			</div>
		</div>
		<div class="bottomarea"></div>
		<div class="bottomarea2">
			<span>Binance Optimizes API Order Rate Limits 11-18</span>
			<span></span>
			<span>More</span>
			<span></span>
		</div>
		<div class="bottomarea3">
			<div class="bottomarea3-1">
				<div class="bottomarea3-1-top">
					<span>Name</span>
					<span>Last Price</span>
					<span>24h Change</span>
					<span>Markets</span>
				</div>
				<div class="xian"></div>
				<div v-for="gtem in tableData" :key='gtem.index'>
					<div class="tablesty">
						<img :src="gtem.img" />
						<span>
							<span>{{ gtem.text1 }}</span>
							<span>{{ gtem.text2 }}</span>
						</span>
						<span>{{ gtem.text3 }}</span>

						<span style="color: rgba(238, 66, 86, 1);" v-if="gtem.text4 > 0">{{ gtem.text4 }}%</span>
						<span style="color: rgba(1, 211, 210, 1)" v-if="gtem.text4 < 0">{{ gtem.text4 }}%</span>
						<span><img :src="gtem.img5" /></span>
					</div>
					<div class="xian2"></div>
				</div>
				<div class="more"><span>View more markets</span></div>
			</div>
		</div>
		<div class="bottomarea4">
			<div class="bottomarea4-1">Our strengths</div>
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
		<div class="bottomarea5">
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
					<img src="../../static/Bitmap.png" />
					<div>
						Pick from the various payment methods here. Buy Bitcoin with credit card (You can also buy XRP, ETH, LTC and BCH), or buy crypto with US Dollars or Euro
						through TUSD or PAX stablecoins. You also have options to turn your TUSD or PAX back into cash.
					</div>
				</div>
				<div><img src="../../static/S2.png" class="imgs2" />
				</div>
			</div>
		</div>
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
			tableData: [
				{
					img: require('../../static/Bitmap.png'),
					text1: 'BNB',
					text2: 'BNB',
					text3: '$19.2',
					text4: '-1.04',
					img5: require('../../static/Path5.png')
				},

				{
					img: require('../../static/Bitmap (6).png'),
					text1: 'BNB',
					text2: 'BNB',
					text3: '$19.2',
					text4: '+1.04',
					img5: require('../../static/Path5.png')
				},
				{
					img: require('../../static/Bitmap (2).png'),
					text1: 'BN123B',
					text2: 'BN23B',
					text3: '$192.2',
					text4: '-1.04',
					img5: require('../../static/Path5.png')
				},
				{
					img: require('../../static/Bitmap (3).png'),
					text1: 'BNB',
					text2: 'BNB',
					text3: '$19.2',
					text4: '-1.04',
					img5: require('../../static/Path5.png')
				},
				{
					img: require('../../static/Bitmap (4).png'),
					text1: 'BCHABC',
					text2: 'BNB',
					text3: '$19.2',
					text4: '+1.04',
					img5: require('../../static/Path5.png')
				},
				{
					img: require('../../static/Bitmap (5).png'),
					text1: 'BNB',
					text2: 'BNB',
					text3: '$19.2',
					text4: '-1.04',
					img5: require('../../static/Path5.png')
				}
			],
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
			this.$router.push({ path: '/Anction' });
		},
		forSavings() {
			this.$router.push({ path: '/Savings' });
		},
		forMining() {
			this.$router.push({ path: '/Mining' });
		}
	
	},
	created() {},
	mounted() {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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
	margin-top: 120px;
}
.xx {
	position: absolute;
	margin-top: 80px;
}
.boxzall {
	width: 1440px;
	display: flex;
	margin-top: 192px;
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
	color: rgba(255, 255, 255, 1);
	font-size: 27px;
	position: absolute;
	margin-top: 69px;
}
.bottomarea4 {
	width: 1440px;
	height: 437px;
	background: rgba(0, 17, 35, 1);
}
.more {
	display: flex;
	justify-content: center;
	font-size: 18px;
	margin-top: 25px;
	color: rgba(153, 153, 153, 1);
}
.tablesty > img {
	width: 44px;
	height: 50px;
	margin-left: 28px;
	position: absolute;
}
.tablesty > span:nth-of-type(1) {
	margin-left: 90px;
	font-size: 18px;
	position: absolute;
	font-weight: normal;
}
.tablesty > span > span:nth-of-type(1) {
	color: rgba(51, 51, 51, 1);
}
.tablesty > span > span:nth-of-type(2) {
	color: rgba(153, 153, 153, 1);
	font-size: 16px;
	margin-left: 16px;
}
.tablesty > span:nth-of-type(2) {
	margin-left: 566px;
	font-size: 17px;
	color: rgba(51, 51, 51, 1);
	font-weight: bold;
	position: absolute;
}
.tablesty > span:nth-of-type(3) {
	font-size: 17px;
	font-weight: bold;
	margin-left: 771px;
	position: absolute;
}
.tablesty > span:nth-of-type(4) {
	font-size: 17px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	position: absolute;
	margin-left: 980px;
}

.tablesty {
	display: flex;
	align-items: center;
	height: 78px;
}
.xian {
	width: 1143px;
	height: 1px;
	background: rgba(238, 238, 238, 1);
	margin-top: 27px;
}
.xian2 {
	width: 1143px;
	height: 1px;
	background: rgba(238, 238, 238, 1);
}
.bottomarea3-1-top > span:nth-of-type(1) {
	margin-left: 41px;
}
.bottomarea3-1-top > span:nth-of-type(2) {
	margin-left: 476px;
}
.bottomarea3-1-top > span:nth-of-type(3) {
	margin-left: 124px;
}
.bottomarea3-1-top > span:nth-of-type(4) {
	margin-left: 111px;
}
.bottomarea3-1-top {
	font-size: 18px;
	color: rgba(102, 102, 102, 1);
	display: flex;
	margin-top: 32px;
}
.bottomarea3-1 {
	width: 1146px;
	height: 634px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 17px 0px rgba(219, 219, 219, 0.5);
	border-radius: 7px;
	position: absolute;
	margin-left: 147px;
	margin-top: 15px;
}
.bottomarea3 {
	width: 1440px;
	height: 710px;
	background: rgba(254, 254, 254, 1);
	margin-top: 24px;
}
.all {
	background-color: #e8e8e8;
}
.bottomarea2 > span:nth-of-type(1) {
	color: rgba(46, 46, 46, 1);
}
.bottomarea2 > span:nth-of-type(2) {
	width: 2px;
	height: 23px;
	margin-top: 1.5px;
	background-color: rgba(151, 151, 151, 1);
	margin-left: 30px;
}
.bottomarea2 > span:nth-of-type(3) {
	color: rgba(69, 141, 254, 1);
	margin-left: 21px;
}
.bottomarea2 > span:nth-of-type(4) {
}
.bottomarea2 {
	font-size: 20px;
	width: 1440px;
	text-align: center;
	margin-top: 41px;
	display: flex;
	justify-content: center;
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
	background: rgba(1, 211, 210, 1);
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
	cursor: pointer;
}
.box5 > span:nth-of-type(2) {
	margin-left: 22px;
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
