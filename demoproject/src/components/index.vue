<template>
	<div class="all">
		<div ref="element">
			<vue-seamless-scroll :data="list" :class-option="optionLeft" class="toparea">
				<div class="toparea2">
					<div class="text1" v-for="item in list" :key="item.index">
						<div>{{ item.msg }}</div>
						<div style="height: 3px;"></div>
						<span>{{ item.price }}</span>
						<span style="color: rgba(238, 66, 86, 1);" v-if="item.priceper > 0">{{ item.priceper }}%</span>
						<span style="color: rgba(1, 211, 210, 1)" v-if="item.priceper < 0">{{ item.priceper }}%</span>
					</div>
				</div>
			</vue-seamless-scroll>
			<div class="halfarea">
				<v-sell></v-sell>
				<!-- 	<div class="halfarea-1">
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
			</div> -->
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
		</div>
		<div class="index1" v-if="topheight == 1">
			<img src="../../static/mobile1.png" />
			<div class="index1-1">The simplest way to have a professioanal webpage.</div>
			<div class="index1-2">
				Get all the benefits of an in-wall or in-ceiling speaker system without any of the hassle. Just replace a few lights around your house, and start streaming crisp,
				clear audio, everywhere.
			</div>
		</div>
		<div class="index1" v-if="topheight == 2">
			<img src="../../static/mobile1.png" />
			<div style="  margin-top: 10%;margin-left: 45%;position: absolute; display: flex;flex-direction: column;">
				<transition name="el-fade-in-linear">
					<div v-show="show1" class="transition-box1">
						<div>{{ str1 }}</div>
					</div>
				</transition>
				<transition name="el-fade-in-linear">
					<div v-show="show2" class="transition-box2">
						<div>{{ str2 }}</div>
					</div>
				</transition>
				<transition name="el-fade-in-linear">
					<div v-show="show3" class="transition-box3">
						<div>{{ str3 }}</div>
					</div>
				</transition>
				<transition name="el-fade-in-linear">
					<div v-show="show4" class="transition-box4">
						<div>{{ str4 }}</div>
					</div>
				</transition>
			</div>
		</div>
		<div class="index2">
			<img src="../../static/mobile2.png" />
			<div>Trade on the go</div>
			<div>Take Poloniex everywhere you go with our apps.</div>
			<img src="../../static/dowload2.png" class="shou" @click="dowloadapp" />
			<img src="../../static/dowload1.png" class="shou" @click="dowloadgoogle" />
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
var _this;
import footer from '../assembly/foot/foot.vue';
import sell from '../assembly/sell/sell.vue';
import https from '../https.js';
var preD = function(e) {
	e.preventDefault();
};
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer
	},
	data() {
		return {
			list: [
				{ msg: 'Bitcoin 24h', priceper: '-4.95', price: '$8,148.85' },
				{ msg: 'Ethereum 24h', priceper: '-4.95', price: '$8,148.85' },
				{ msg: 'XRP 24h', priceper: '+4.95', price: '$8,148.85' },
				{ msg: 'XRP 24h', priceper: '+4.95', price: '$8,148.85' },
				{ msg: 'Litecoin 24h', priceper: '-4.95', price: '$8,148.85' }
			],
			topheight: 1,
			popupStatus: false,
			show1: false,
			show2: false,
			show3: false,
			show4: false,
			strx1: 'Display your product asnever before',
					strx2: 'Eos eu magna delenit, possim molestie sed ad, ne meliore fuisset his',
							strx3: 'Display your product asnever before',
									strx4: 'Eos eu magna delenit, possim molestie sed ad, ne meliore fuisset his',
			i1: 0,
			i2: 0,
			i3: 0,
			i4: 0,
			timer1: 0,
			timer2: 0,
			timer3: 0,
			timer4: 0,
			str1: '',
			str2: '',
			str3: '',
			str4 :''
		};
	},
	computed: {
		optionLeft() {
			return {
				direction: 2,
				limitMoveNum: 2
			};
		}
	},
	mounted() {
		_this = this;
		let params = { email: '18362161496@163.com', password: 'admin123' };
		https
			.fetchPost('/account/signUp', params)
			.then(data => {
				window.console.log(data);
			})
			.catch(err => {
				window.console.log(err);
			});
		window.addEventListener('scroll', this.scrollHandle);
	},
	methods: {
		typing1() {
			if (this.i1 <= this.strx1.length) {
					_this.show1 = true;
					this.str1 = this.strx1.slice(0, this.i1++) + '.';
					this.timer1 = setTimeout(() => {
						this.typing1();
					}, 100);
			} else {
				if (this.i2 <= this.strx2.length) {
						_this.show2 = true;
					this.str2 = this.strx2.slice(0, this.i2++) + '.';
					this.timer2 = setTimeout(() => {
						this.typing1();
					}, 100);
				} else {
				if (this.i3 <= this.strx3.length) {
						_this.show3 = true;
					this.str3 = this.strx3.slice(0, this.i3++) + '.';
					this.timer13 = setTimeout(() => {
						this.typing1();
					}, 100);
				} else {
					if (this.i4 <= this.strx4.length) {
							_this.show4 = true;
						this.str4 = this.strx4.slice(0, this.i4++) + '.';
						this.timer4 = setTimeout(() => {
							this.typing1();
						}, 100);
					}else{
						this.inmove()
					}

			}
			}
			}
		},
		scrollHandle() {
			let height = this.$refs.element.offsetHeight;
			var top = document.documentElement.scrollTop || document.body.scrollTop; // 获取页面滚动高度
			if (top >= height-50) {
				/* if(this.str4==""){
					this.notmove();
				} */
				this.topheight = 2;
				setTimeout(function() {
					_this.typing1();
				}, 500);
				/* setTimeout(function() {
					_this.show2 = true;
				}, 1000);
				setTimeout(function() {
					_this.show3 = true;
				}, 1500);
				setTimeout(function() {
					_this.show4 = true; */
					
			/* 	}, 2000); */
			}
			window.console.log(height);
		},
		forbuyshell() {
			this.$router.push({ path: '/sellbuy' });
		},
		notmove() {
			document.body.style.overflow = 'hidden';
			document.addEventListener('touchmove', preD, { passive: false });
		},
		inmove() {
			document.body.style.overflow = ''; // 出现滚动条
			document.removeEventListener('touchmove', preD, { passive: false });
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
		forlogin() {
			this.$router.push({ path: '/login' });
		},
		forsignup() {
			this.$router.push({ path: '/signup' });
		},
		dowloadapp() {
			alert('下载中');
		},
		dowloadgoogle() {
			alert('下载中');
		}
	},
	created() {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.transition-box1 > div {
	width: 241px;
}
.transition-box2 > div {
	margin-left: 30px;
	width: 241px;
}
.transition-box3 > div {
	width: 241px;
}
.transition-box4 > div {
	margin-left: 30px;
	width: 241px;
}
.transition-box1 {
	background-image: url('../../static/lankuang.png');
	background-size: 100%;
	width: 268px;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 64px;
	margin-left: 268px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
}
.transition-box2 {
	background-image: url('../../static/baikuang.png');
	background-size: 100%;
	width: 268px;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 83px;
	font-size: 18px;
	color: rgba(10, 62, 105, 1);
	margin-top: 61px;
}
.transition-box3 {
	background-image: url('../../static/lankuang.png');
	background-size: 100%;
	width: 268px;
	height: 64px;
	margin-left: 268px;
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 61px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
}
.transition-box4 {
	background-image: url('../../static/baikuang.png');
	background-size: 100%;
	width: 268px;
	margin-top: 61px;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 18px;
	color: rgba(10, 62, 105, 1);
	height: 83px;
}
.index2 > div:nth-of-type(2) {
	margin-top: 294px;
	margin-left: 752px;
	font-size: 26px;
	font-family: SFUIDisplay-Bold, SFUIDisplay;
	font-weight: bold;
	color: rgba(153, 153, 153, 1);
	position: absolute;
}
.index2 > div:nth-of-type(1) {
	margin-top: 220px;
	margin-left: 752px;
	font-size: 51px;
	font-family: SFUIDisplay-Bold, SFUIDisplay;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	line-height: 61px;
	position: absolute;
}
.index2 {
	width: 100%;
	height: 618px;
	background: rgba(247, 247, 247, 1);
	border-radius: 2px;
}
.index2 > img:nth-of-type(1) {
	width: 506px;
	height: 523px;
	position: absolute;
	margin-top: 95px;
	margin-left: 172px;
}
.index2 > img:nth-of-type(2) {
	width: 215px;
	height: 72px;
	position: absolute;
	margin-top: 376px;
	margin-left: 752px;
}
.index2 > img:nth-of-type(3) {
	width: 215px;
	height: 72px;
	position: absolute;
	margin-top: 376px;
	margin-left: 983px;
}
.index1 {
	width: 100%;
	height: 800px;
	background: rgba(10, 62, 105, 1);
}
.index1 > img {
	width: 281px;
	height: 578px;
	position: absolute;
	margin-top: 109px;
	margin-left: 257px;
}
.index1-1 {
	position: absolute;
	margin-top: 258px;
	margin-left: 728px;
	width: 475px;
	height: 86px;
	font-size: 36px;
	font-weight: 400;
	color: rgba(255, 255, 255, 1);
	line-height: 43px;
}
.index1-2 {
	position: absolute;
	margin-top: 371px;
	margin-left: 728px;
	width: 475px;
	height: 150px;
	font-size: 18px;
	font-weight: 400;
	color: rgba(138, 154, 183, 1);
	line-height: 30px;
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
	width: 100%;
	margin-top: 44px;
	text-align: center;
}
.bottomarea5 {
	width: 100%;
	height: 1185px;
	background: rgba(30, 73, 211, 1);
	border-radius: 1px;
}
.xx2 {
	position: absolute;
	margin-top: 100px;
	color: #828a93;
}
.xx {
	position: absolute;
	margin-top: 60px;
}
.boxzall {
	width: 100%;
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
	width: 100%;
	text-align: center;
	font-size: 20px;
	color: rgba(102, 117, 127, 1);
	position: absolute;
	margin-top: 20px;
}
.bottomarea4 {
	width: 100%;
	height: 259px;
	background: rgba(0, 17, 35, 1);
}
.bottomarea {
	background-image: url('../../static/TrustedBy.png');
	width: 100%;
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
	margin-top: 137px;
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
	background: rgba(0, 195, 255, 1);
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
	background: rgba(0, 195, 255, 1);
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
	width: 100%;
	height: 710px;
	background-size: 100%;
}

.text1 {
	font-size: 16px;
	color: rgba(84, 95, 107, 1);
	float: left;
	margin-right: 146px;
}

.text1 > span {
	font-size: 16px;
	font-weight: normal;
	color: rgba(255, 255, 255, 1);
	line-height: 18px;
}
.toparea {
	height: 76px;
	background: rgba(0, 17, 35, 1);
	border-radius: 1px;
	overflow: hidden;
}
.toparea2 {
	display: flex;
	background: rgba(0, 17, 35, 1);
	border-radius: 1px;
	height: 76px;
	align-items: center;
}
</style>
