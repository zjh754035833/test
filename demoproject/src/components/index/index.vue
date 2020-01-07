<template>
	<div class="all">
		<div ref="element">
			<div>
				<v-sell style="height: 10vh;"></v-sell>
				<el-carousel trigger="click" height="80vh">
					<el-carousel-item v-for="item in indexlist" :key="item">
						<div class="halfarea">
							<img src="../../../static/indeimg.png" />
							<div class="halfarea-2"><div class="shou" @click="forbuyshell()">Buy/Sell</div></div>
						</div>
					</el-carousel-item>
				</el-carousel>
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
			</div>
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
					<div v-for="gtem in tableData" :key="gtem.index">
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
				<div class="bottomarea4-1">OUR STRENGTHS</div>
				<div class="indexboxzall">
					<div class="z1">
						<img src="../../../static/x3.png" class="z-img1" />
						<div class="xx">Market</div>
						<div class="xx2">best rates on the market</div>
					</div>
					<div class="z2">
						<img src="../../../static/x2.png" class="z-img2" />
						<div class="xx">Market</div>
						<div class="xx2">best rates on the market</div>
					</div>
					<div class="z3">
						<img src="../../../static/x1.png" class="z-img3" />
						<div class="xx">Market</div>
						<div class="xx2">fast transaction</div>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="index1" v-if="topheight == 1">
			<img src="../../../static/mobile1.png" />
			<div class="index1-1">The simplest way to have a professioanal webpage.</div>
			<div class="index1-2">
				Get all the benefits of an in-wall or in-ceiling speaker system without any of the hassle. Just replace a few lights around your house, and start streaming crisp,
				clear audio, everywhere.
			</div>
		</div>
		<div class="index1" v-if="topheight == 2">
			<img src="../../../static/mobile1.png" />
			<div style="  margin-top: 10%;margin-left: 45%;position: absolute; display: flex;flex-direction: column;">
				<transition name="el-fade-in-linear">
					<div v-show="show1" class="transition-indexbox1">
						<div>{{ str1 }}</div>
					</div>
				</transition>
				<transition name="el-fade-in-linear">
					<div v-show="show2" class="transition-indexbox2">
						<div>{{ str2 }}</div>
					</div>
				</transition>
				<transition name="el-fade-in-linear">
					<div v-show="show3" class="transition-indexbox3">
						<div>{{ str3 }}</div>
					</div>
				</transition>
				<transition name="el-fade-in-linear">
					<div v-show="show4" class="transition-indexbox4">
						<div>{{ str4 }}</div>
					</div>
				</transition>
			</div>
		</div>
		<div class="index2">
			<img src="../../../static/mobile2.png" />
			<div>Trade on the go</div>
			<div>Take Poloniex everywhere you go with our apps.</div>
			<img src="../../../static/dowload2.png" class="shou" @click="dowloadapp" />
			<img src="../../../static/dowload1.png" class="shou" @click="dowloadgoogle" />
		</div> -->

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
				<div><img src="../../../static/S4.png" /></div>
				<div>
					<div>Reliable</div>
					<div>We work with the most trustworthy third-party partners to make your crypto-buying experience easy and convenient.</div>
				</div>
			</div>
			<div class="bottomarea5-3">
				<div><img src="../../../static/S5.png" /></div>
				<div>
					<div>Many Options</div>
					<div>
						Pick from the various payment methods here. Buy Bitcoin with credit card (You can also buy XRP, ETH, LTC and BCH), or buy crypto with US Dollars or Euro
						through TUSD or PAX stablecoins. You also have options to turn your TUSD or PAX back into cash.
					</div>
				</div>
				<div><img src="../../../static/S2.png" class="imgs2" />
				</div>
			</div>
		</div> -->
		<div class="bottomarea"></div>
		<v-footer></v-footer>
	</div>
</template>

<script>
var _this;
import footer from '../../assembly/foot/foot.vue';
import sell from '../../assembly/sell/sell.vue';
import https from '../../https.js';
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
			indexlist: [{}, {}, {}],
			tableData: [
				{
					img: require('../../../static/Bitmap.png'),
					text1: 'BNB',
					text2: 'BNB',
					text3: '$19.2',
					text4: '-1.04',
					img5: require('../../../static/Path5.png')
				},

				{
					img: require('../../../static/Bitmap (6).png'),
					text1: 'BNB',
					text2: 'BNB',
					text3: '$19.2',
					text4: '+1.04',
					img5: require('../../../static/Path5.png')
				},
				{
					img: require('../../../static/Bitmap (2).png'),
					text1: 'BN123B',
					text2: 'BN23B',
					text3: '$192.2',
					text4: '-1.04',
					img5: require('../../../static/Path5.png')
				},
				{
					img: require('../../../static/Bitmap (3).png'),
					text1: 'BNB',
					text2: 'BNB',
					text3: '$19.2',
					text4: '-1.04',
					img5: require('../../../static/Path5.png')
				},
				{
					img: require('../../../static/Bitmap (4).png'),
					text1: 'BCHABC',
					text2: 'BNB',
					text3: '$19.2',
					text4: '+1.04',
					img5: require('../../../static/Path5.png')
				},
				{
					img: require('../../../static/Bitmap (5).png'),
					text1: 'BNB',
					text2: 'BNB',
					text3: '$19.2',
					text4: '-1.04',
					img5: require('../../../static/Path5.png')
				}
			],
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
			str4: ''
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
						} else {
							this.inmove();
						}
					}
				}
			}
		},
		scrollHandle() {
			let height = this.$refs.element.offsetHeight;
			var top = document.documentElement.scrollTop || document.body.scrollTop; // 获取页面滚动高度
			if (top >= height - 50) {
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
<style scoped  src="./index.css">
</style>
