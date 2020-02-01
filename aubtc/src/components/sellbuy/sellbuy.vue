<template>
	<div>
		<v-sell :style="gquanp"></v-sell>
		<div :style="kquanp" class="quanp">
			<img src="../../../static/formore.png" class="nomore" @click="tquanp" />
			<div id="myChart1" ref="myChart1"></div>
		</div>
		<el-dialog title="" :visible.sync="dixdiag.sell1" width="60%" top="0" :before-close="handleClose1">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
				<span>Buy</span>
			</div>
			<div class="buy1all">
				<div class="bu1-1">
					<div class="bu1-1-all">
						<div>
							<div class="bu1-1-1"><span>Price :</span></div>
							<span class="bu1-1-2">0.887</span>
							<img src="../../../static/newsell2.png" />
							<span class="bu1-1-3">AUD</span>
						</div>
						<div style="margin-top: 45px;">
							<div class="bu1-1-1"><span>Buy :</span></div>
							<span class="bu1-1-2">12000</span>
							<img src="../../../static/newsell1.png" />
							<span class="bu1-1-3">BTC</span>
						</div>
						<div style="margin-top: 45px;">
							<div class="bu1-1-1"><span>Pay :</span></div>
							<span class="bu1-1-2">15000</span>
							<img src="../../../static/newsell2.png" />
							<span class="bu1-1-3">AUD</span>
						</div>
					</div>
				</div>
			</div>
			<div class="bu1-4" style="justify-content: center;margin-top: 50px;">
				<div @click="dixdiag.sell1 = false" class="shou">Cancel</div>
				<div @click="dixdiag.buy2 = true" class="shou">Confirm</div>
			</div>
		</el-dialog>
		<el-dialog title="" :visible.sync="dixdiag.timeout" width="60%" top="0" :before-close="handleClose1">
			<div class="timeoutall">
				<img src="../../../static/newselltimeout.png" />
				<div>Time ou</div>
				<div>Payment timed out, please regain price</div>
				<div class="shou" @click="closealldiag">close</div>
			</div>
		</el-dialog>
		<el-dialog title="" :visible.sync="dixdiag.changeprice" width="60%" top="0" :before-close="buy5tcanel">
			<div class="changepriceall">
				<div>The market price fluctuates, Please check the payment amount again.</div>
				<div class="buy4all-3-1-4" v-if="buy4outime == true">
					<span>REMAINING</span>
					<span v-show="!show" class="count">{{ countbefore }}:{{ countreal }}</span>
				</div>
				<div>
					<div @click="buy5t(1)" class="shou">Cancel</div>
					<div @click="buy5t(2)" class="shou">OK</div>
				</div>
			</div>
		</el-dialog>
		<el-dialog title="" :visible.sync="dixdiag.buy4" width="60%" top="0" :before-close="handleClose1">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
				<span>Payment</span>
			</div>
			<div class="buy4all">
				<div class="buy4all-1">
					<div class="buy4all-1-1">
						<div><img src="../../../static/newbuysell0.png" v-if="t1 == true" /></div>
						<div><img src="../../../static/newbuysell0.png" v-if="t2 == true" /></div>
						<div><img src="../../../static/newbuysell0.png" v-if="t3 == true" /></div>
					</div>
					<img src="../../../static/newbuysell11.png" class="buy4all-1-2" />
					<div class="buy4all-1-3">Order summary</div>
				</div>
				<div class="buy4all-2">
					<div class="buy4all-2-1">Payment details</div>
					<div class="buy4all-2-2">
						<div class="buy4all-2-2-all">
							<div class="buy4all-2-2-all-1">Card number</div>
							<div>
								<el-autocomplete
									class="buy4all-2-2-all-input"
									popper-class="my-autocomplete"
									v-model="state"
									:fetch-suggestions="querySearch"
									placeholder="xxx xxx xxx"
									@select="handleSelect"
								>
									<i class="el-icon-edit el-input__icon" slot="suffix" @click="handleIconClick"></i>
									<template slot-scope="{ item }">
										<div class="name">{{ item.value }}</div>
										<span class="addr">{{ item.address }}</span>
									</template>
								</el-autocomplete>
							</div>
							<div class="buy4all-2-2-all-1">Name</div>
							<input placeholder="Full name on the card" />
							<div class="buy4all-2-2-all-1">
								<span>Expiry date</span>
								<span>CVC</span>
							</div>
							<div class="buy4all-2-2-all-4">
								<input placeholder="MM/YY" />
								<input placeholder="XXX" />
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="buy4all-3">
				<div class="buy4all-3-1">
					<div class="buy4all-3-1-1">You’re about to pay for 1 order</div>
					<div class="buy4all-3-1-3"></div>
					<div class="buy4all-3-1-2">
						<div>
							<span>Postage</span>
							<span>$20.00</span>
						</div>
						<div>
							<span>Total</span>
							<span>$20.00</span>
						</div>
						<div>
							<span>Included GST</span>
							<span>$1.72</span>
						</div>
					</div>
				</div>
			</div>
			<div class="buy4-5">
				<div class="shou" @click="calncelbuy4">Cancel</div>
				<div class="shou" @click="buy4t">Pay now</div>
			</div>
		</el-dialog>
		<el-dialog title="" :visible.sync="dixdiag.buy3" width="60%" top="0" :before-close="handleClose1">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
				<span>Buy</span>
			</div>
			<div class="buy3-1"></div>
			<div class="buy3all">
				<div class="buy3-2">
					<span>Account available Balance</span>
					<img src="../../../static/newsell2.png" />
					<span>0</span>
					<span>AUD</span>
				</div>
				<div class="buy3-3">*Account available Balance is not enough</div>
				<div class="buy3-4">
					<div @click="dixdiag.buy3 = false" class="shou">Change Method</div>
					<div @click="buyt3()" class="shou">Recharge now</div>
				</div>
			</div>
		</el-dialog>
		<el-dialog title="" :visible.sync="dixdiag.buy2" width="60%" top="0" :before-close="handleCloseall">
			<div class="buy2all">
				<img src="../../../static/newsellsucess.png" />
				<div>Successful</div>
			</div>
		</el-dialog>
		<el-dialog title="" :visible.sync="dixdiag.buy1" width="60%" top="0" :before-close="handleClose1">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
				<span>Buy</span>
			</div>
			<div class="buy1all">
				<div class="bu1-1">
					<div class="bu1-1-all">
						<div>
							<div class="bu1-1-1"><span>Price :</span></div>
							<span class="bu1-1-2">0.887</span>
							<img src="../../../static/newsell2.png" />
							<span class="bu1-1-3">AUD</span>
						</div>
						<div style="margin-top: 45px;">
							<div class="bu1-1-1"><span>Buy :</span></div>
							<span class="bu1-1-2">12000</span>
							<img src="../../../static/newsell1.png" />
							<span class="bu1-1-3">BTC</span>
						</div>
						<div style="margin-top: 45px;">
							<div class="bu1-1-1"><span>Pay :</span></div>
							<span class="bu1-1-2">15000</span>
							<img src="../../../static/newsell2.png" />
							<span class="bu1-1-3">AUD</span>
						</div>
					</div>
				</div>
				<div class="bu1-2">Choose Payment Method</div>
				<div class="bu1-3">
					<img src="../../../static/buyt1.png" @click="buyt1()" class="shou" v-show="zftype == 'blank'" />
					<img src="../../../static/buy2blue.png" class="shou" v-show="zftype == 'account'" />
					<img src="../../../static/buyt2.png" @click="buyt2()" class="shou" v-show="zftype == 'account'" style="margin-left: 37px;" />
					<img src="../../../static/buy1blue.png" class="shou" v-show="zftype == 'blank'" style="margin-left: 37px;" />
				</div>
				<div class="bu1-4">
					<div @click="dixdiag.buy1 = false" class="shou">Cancel</div>
					<div @click="qurenbuy" class="shou">Confirm</div>
				</div>
			</div>
		</el-dialog>
	
		<div :style="gquanp">
			<div class="sellbuy1">
				<div class="sellbuy3">
					<el-dropdown trigger="click" class="shou">
						<span>
							<span class="zi1">{{ biz }}</span>
							<span class="zi2">/USDT</span>
							<i class="el-icon-arrow-down el-icon--right"></i>
						</span>
						<el-dropdown-menu slot="dropdown">
							<el-dropdown-item><span @click="forbiz(1)" style="font-size: 20px;">BTC</span></el-dropdown-item>
							<el-dropdown-item><span @click="forbiz(2)" style="font-size: 20px;">USDT</span></el-dropdown-item>
						</el-dropdown-menu>
					</el-dropdown>
				</div>
				<div class="sellbuy2">
					<div class="text2" v-for="(item, index) in list" :key="index">
						<div v-show="item.msg != 'Last Price'">{{ item.msg }}</div>
						<div class="lastprice"  v-show="item.msg == 'Last Price'">{{ item.msg }}</div>
						<div style="height: 3px;"></div>
						<span class="lastprice" style="color:rgba(0, 195, 255, 1);" v-show="item.msg == 'Last Price'" >{{ item.price }}</span>
						<span v-show="(item.msg != '24h change') & (item.msg != 'Last Price')">{{ item.price }}</span>
						<span style="color:rgba(238,66,86,1);" v-show="item.msg == '24h change'">{{ item.price }}</span>
					</div>
				</div>
			</div>
			<div class="sellbuy6"></div>
			<div class="clichart">
				<div>time</div>
				<div>
					<el-dropdown :hide-on-click="false">
						<span class="el-dropdown-link">
							<span class="ALLZI">M</span>
							<i class="el-icon-arrow-down "></i>
						</span>
						<el-dropdown-menu slot="dropdown">
							<el-dropdown-item>1m</el-dropdown-item>
							<el-dropdown-item>3m</el-dropdown-item>
							<el-dropdown-item>5m</el-dropdown-item>
							<el-dropdown-item>15m</el-dropdown-item>
							<el-dropdown-item>30m</el-dropdown-item>
						</el-dropdown-menu>
					</el-dropdown>
				</div>
				<div>
					<el-dropdown :hide-on-click="false">
						<span class="el-dropdown-link">
							<span class="ALLZI">M</span>
							<i class="el-icon-arrow-down "></i>
						</span>
						<el-dropdown-menu slot="dropdown">
							<el-dropdown-item>1m</el-dropdown-item>
							<el-dropdown-item>3m</el-dropdown-item>
							<el-dropdown-item>5m</el-dropdown-item>
							<el-dropdown-item>15m</el-dropdown-item>
							<el-dropdown-item>30m</el-dropdown-item>
						</el-dropdown-menu>
					</el-dropdown>
				</div>
				<div>1D</div>
				<div>1W</div>
				<div>1M</div>
				<div>Original</div>
				<div>TradingView</div>
				<div>Depth</div>
				<img src="../../../static/formore.png" @click="formore" />
			</div>
			<div id="myChart" ref="myChart"></div>
			<div class="newsellbuy1" v-if="buystyle == true">
				<div class="newsellbuy1-1">
					<div class=" newSellstyle">Buy</div>
					<div class="newbuystyle" @mouseenter="mouall(2)">SELL</div>
				</div>
				<div class="newsellbuy1-2">
					<div class="newsellbuy1-2-1">
						<span>Get</span>
						<input onkeyup="this.value=this.value.replace(/[^0-9\.]/g,'')" type="text" @input="buybtcvalue" />
						<div>
							<img src="../../../static/newsell1.png" />
							<span>BTC</span>
						</div>
					</div>
				</div>
				<div class="newsellbuytx" :style="isbtc">*Minimum purchase amount 2Btc</div>
				<div class="newsellbuy1-2">
					<div class="newsellbuy1-2-1">
						<span>Pay</span>
						<input onkeyup="this.value=this.value.replace(/[^0-9\.]/g,'')" type="text" />
						<div>
							<img src="../../../static/newsell2.png" />
							<span>USD</span>
						</div>
					</div>
				</div>
				<div class="newsellbuy1-3"><div class="shou" style="background:rgba(238,66,86,1);" @click="forbuy">BUY NOW</div></div>
			</div>
			<div class="newsellbuy1" v-if="sellstyle == true">
				<div class="newsellbuy1-1">
					<div class="newbuystyle" @mouseenter="mouall(1)">Buy</div>
					<div class="newSellstyle">Sell</div>
				</div>
				<div class="newsellbuy1-2">
					<div class="newsellbuy1-2-1">
						<span>Pay</span>
						<input onkeyup="this.value=this.value.replace(/[^0-9\.]/g,'')" type="text" />
						<div>
							<img src="../../../static/newsell1.png" />
							<span>BTC</span>
						</div>
					</div>
				</div>
				<div class="newsellbuy1-2">
					<div class="newsellbuy1-2-1">
						<span>Get</span>
						<input onkeyup="this.value=this.value.replace(/[^0-9\.]/g,'')" type="text" />
						<div>
							<img src="../../../static/newsell2.png" />
							<span>USD</span>
						</div>
					</div>
				</div>
				<div class="newsellbuy1-3"><div class="shou" @click="dixdiag.sell1 = true">sell</div></div>
			</div>
		</div>
		<v-foot :style="gquanp"></v-foot>
	</div>
</template>

<script>
import echarts from 'echarts';
import sell from '../../assembly/sell/sell.vue';
import foot from '../../assembly/foot/foot.vue'
export default {
	components: {
		'v-sell':sell,
		'v-foot':foot
	},
	name: 'echarts',
	data() {
		return {
			restaurants: [],
			state: '',
			biz: 'BTC',
			dixdiag: {
				buy1: false,
				buy2: false,
				buy3: false,
				buy4: false,
				changeprice: false,
				timeout: false,
				sell1: false
			},
			zftype: 'account',
			isbtc: 'display:none',
			buystyle: true,
			sellstyle: false,
			booleenpin: false,
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
				{ msg: 'Last Price', price: '8,148.85 $8,767.8' },
				{ msg: '24h change', price: '-78.23 -0.87%' },
				{ msg: '24h High', price: '8,635.00' },
				{ msg: '24h Low', price: '8,766.00' },
				{ msg: '', price: '' }
			],
			resData: '',
			echartsOption: {
				title: {
					text: '',
					left: 0
				},
				tooltip: {
					trigger: 'axis',
					axisPointer: {
						type: 'cross'
					}
				},
				legend: {
					data: []
				},
				grid: {
					left: '10%',
					right: '10%',
					bottom: '15%'
				},
				xAxis: {
					type: 'category',
					data: [],
					scale: true,
					boundaryGap: false,
					axisLine: { onZero: false },
					splitLine: { show: false },
					splitNumber: 20,
					min: 'dataMin',
					max: 'dataMax'
				},
				yAxis: {
					scale: true,
					splitArea: {
						show: true
					}
				},
				dataZoom: [
					{
						type: 'inside',
						start: 30,
						end: 70
					},
					{
						show: true,
						type: 'slider',
						y: '90%',
						start: 0,
						end: 75
					}
				],
				series: [
					{
						name: '日K',
						type: 'k',
						data: [],
						itemStyle: {
							normal: {
								color: 'rgba(238, 66, 86, 1)',
								color0: 'rgba(1, 211, 210, 1)'
							}
						},
						markPoint: {
							label: {
								normal: {
									formatter: function(param) {
										return param != null ? Math.round(param.value) : '';
									}
								}
							},
							data: [
								{
									name: 'highest value',
									type: 'max',
									valueDim: 'highest'
								},
								{
									name: 'lowest value',
									type: 'min',
									valueDim: 'lowest'
								},
								{
									name: 'average value on close',
									type: 'average',
									valueDim: 'close'
								}
							],
							tooltip: {
								formatter: function(param) {
									return param.name + '<br>' + (param.data.coord || '');
								}
							}
						},
						markLine: {
							symbol: ['none', 'none'],
							data: [
								[
									{
										name: 'from lowest to highest',
										type: 'min',
										valueDim: 'lowest',
										symbol: 'circle',
										symbolSize: 10,
										label: {
											normal: { show: false },
											emphasis: { show: false }
										}
									},
									{
										type: 'max',
										valueDim: 'highest',
										symbol: 'circle',
										symbolSize: 10,
										label: {
											normal: { show: false },
											emphasis: { show: false }
										}
									}
								]
							]
						}
					}
				]
			},
			kquanp: 'display:none',
			gquanp: 'display:block',
			t1: '',
			t2: '',
			t3: '',
			show: true,
			count: '',
			countreal: '00',
			countbefore: '01',
			timer: null,
			buyallvalue: 1300,
			myallprice: 1200,
			buy4outime: false,
			changepricetype: true
		};
	},

	mounted() {
		this.setEchartOption();
		this.restaurants = this.loadAll();
		document.querySelector('body').setAttribute('style', 'background-color:rgba(250, 250, 250, 1)');
		this.myChart = echarts.init(document.getElementById('myChart'));
		this.myChart1 = echarts.init(document.getElementById('myChart1'));
		this.myChart.setOption(this.echartsOption);
		this.myChart1.setOption(this.echartsOption);
	},
	methods: {
		querySearch(queryString, cb) {
			var restaurants = this.restaurants;
			var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
			// 调用 callback 返回建议列表的数据
			cb(results);
		},
		createFilter(queryString) {
			return restaurant => {
				return restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0;
			};
		},
		loadAll() {
			return [
				{ value: '13677644444', },
				{ value: '13877644444',  },
			];
		},
		handleSelect(item) {
			window.console.log(item);
		},
		handleIconClick(ev) {
			window.console.log(ev);
		},
		qurenbuy() {
			if (this.zftype == 'blank') {
				this.dixdiag.buy4 = true;
			} else if (this.zftype == 'account') {
				if (this.myallprice < this.buyallvalue) {
					/* 如果余额不足以购买币 */
					this.dixdiag.buy3 = true;
				} else {
					/* 如果余额不足以购买币，支付成功 */
					this.dixdiag.buy2 = true;
				}
			}
		},
		forbiz(e) {
			window.console.log(e);
			this.biz = e;
			if (e == 1) {
				this.biz = 'BTC';
			} else if (e == 2) {
				this.biz = 'USDT';
			}
		},

		buy5t(e) {
			this.buy4outime = false; /* 不显示超时 */
			clearInterval(this.timer); /* 关闭倒计时 */
			this.closealldiag();
			if (e == 1) {
				window.console.log(1);
			} else if (e == 2) {
				this.dixdiag.buy2 = true;
			}
		},
		buy5tcanel() {
			this.buy4outime = false; /* 不显示超时 */
			clearInterval(this.timer); /* 关闭倒计时 */
			this.closealldiag();
		},
		getCode() {
			/* 开启倒计时 */
			this.count = '';
			this.timer = null;
			this.countbefore = '01';
			this.countreal = '00';
			const TIME_COUNT = 60;
			if (!this.timer) {
				this.count = TIME_COUNT;
				this.show = false;
				this.count--;
				this.timer = setInterval(() => {
					if (this.count < 10) {
						this.count = '0' + this.count;
					}
					this.countreal = this.count;
					this.countbefore = '00';
					if (this.count > 0 && this.count <= TIME_COUNT) {
						this.count--;
					} else {
						clearInterval(this.timer);
						if (this.buy4outime == true) {
							/* 如果倒计时开启着，且时间已超过一分钟，则提示超时 */
							this.dixdiag.timeout = true;
						}

						this.timer = null;
					}
				}, 1000);
			}
		},
		forbuy4type(e) {
			/* 选择卡牌类型 */
			if (e == 1) {
				this.t1 = true;
				this.t2 = false;
				this.t3 = false;
			} else if (e == 2) {
				this.t1 = false;
				this.t2 = true;
				this.t3 = false;
			} else if (e == 3) {
				this.t1 = false;
				this.t2 = false;
				this.t3 = true;
			}
		},
		buy4t() {
			/*pay now （银行卡支付）*/
			if (this.changepricetype == true) {
				/* 如果监测到价格发生了改变，弹出提醒 */
				this.dixdiag.changeprice = true;
				this.buy4outime = true; /* 开启倒计时 */
				this.getCode();
			} else {
				/*支付成功 */
				this.buy4outime = false;
				this.dixdiag.buy2 = true;
			}
		},
		buyt1() {
			/*余额支付*/
			this.zftype = 'account';
		},
		buyt3() {
			/* 跳转至银行卡支付 */
			this.dixdiag.buy4 = true;
		},
		buyt2() {
			/* 跳转至银行卡支付 */
			this.zftype = 'blank';
			//this.dixdiag.buy4 = true;
		},
		forbuy() {
			/* 跳转至支付类型选择 */
			this.dixdiag.buy1 = true;
		},
		calncelbuy4() {
			this.dixdiag.buy4 = false;
		},
		handleClose1(done) {
			/* 关闭当前弹出层 */
			this.$confirm('Confirm closing？')
				.then(e => {
					window.console.log(e);
					done();
				})
				.catch(e => {
					window.console.log(e);
				});
		},
		closealldiag() {
			this.dixdiag.buy1 = false;
			this.dixdiag.buy2 = false;
			this.dixdiag.buy3 = false;
			this.dixdiag.buy4 = false;
			this.dixdiag.changeprice = false;
			this.dixdiag.timeout = false;
			this.dixdiag.sell1 = false;
			this.buy4outime = false; /* 不显示超时 */
			clearInterval(this.timer); /* 关闭倒计时 */
		},
		handleCloseall() {
			/* 关闭所有弹出层 */
			this.$confirm('Confirm closing？')
				.then(e => {
					window.console.log(e);
					this.closealldiag();
				})
				.catch(e => {
					window.console.log(e);
				});
		},
		mouall(e) {
			if (e == 1) {
				this.buystyle = true;
				this.sellstyle = false;
			} else if (e == 2) {
				this.sellstyle = true;
				this.buystyle = false;
			}
		},

		buybtcvalue(e) {
			if (e.target.value <= 2) {
				this.isbtc = 'display:block';
			} else {
				this.isbtc = 'display:none';
			}
		},
		formore() {
			this.kquanp = 'display:block';
			this.gquanp = 'display:none';
		},
		tquanp() {
			this.kquanp = 'display:none';
			this.gquanp = 'display:block';
		},
		setEchartOption() {
			// 数据意义：开盘(open)，收盘(close)，最低(lowest)，最高(highest)
			this.resData = splitData([
				['2013/1/24', 2320.26, 2320.26, 2287.3, 2362.94],
				['2013/1/25', 2300, 2291.3, 2288.26, 2308.38],
				['2013/1/28', 2295.35, 2346.5, 2295.35, 2346.92],
				['2013/1/29', 2347.22, 2358.98, 2337.35, 2363.8],
				['2013/1/30', 2360.75, 2382.48, 2347.89, 2383.76],
				['2013/1/31', 2383.43, 2385.42, 2371.23, 2391.82],
				['2013/2/1', 2377.41, 2419.02, 2369.57, 2421.15],
				['2013/2/4', 2425.92, 2428.15, 2417.58, 2440.38],
				['2013/2/5', 2411, 2433.13, 2403.3, 2437.42],
				['2013/2/6', 2432.68, 2434.48, 2427.7, 2441.73],
				['2013/2/7', 2430.69, 2418.53, 2394.22, 2433.89],
				['2013/2/8', 2416.62, 2432.4, 2414.4, 2443.03],
				['2013/2/18', 2441.91, 2421.56, 2415.43, 2444.8],
				['2013/2/19', 2420.26, 2382.91, 2373.53, 2427.07],
				['2013/2/20', 2383.49, 2397.18, 2370.61, 2397.94],
				['2013/2/21', 2378.82, 2325.95, 2309.17, 2378.82],
				['2013/2/22', 2322.94, 2314.16, 2308.76, 2330.88],
				['2013/2/25', 2320.62, 2325.82, 2315.01, 2338.78],
				['2013/2/26', 2313.74, 2293.34, 2289.89, 2340.71],
				['2013/2/27', 2297.77, 2313.22, 2292.03, 2324.63],
				['2013/2/28', 2322.32, 2365.59, 2308.92, 2366.16],
				['2013/3/1', 2364.54, 2359.51, 2330.86, 2369.65],
				['2013/3/4', 2332.08, 2273.4, 2259.25, 2333.54],
				['2013/3/5', 2274.81, 2326.31, 2270.1, 2328.14],
				['2013/3/6', 2333.61, 2347.18, 2321.6, 2351.44],
				['2013/3/7', 2340.44, 2324.29, 2304.27, 2352.02],
				['2013/3/8', 2326.42, 2318.61, 2314.59, 2333.67],
				['2013/3/11', 2314.68, 2310.59, 2296.58, 2320.96],
				['2013/3/12', 2309.16, 2286.6, 2264.83, 2333.29],
				['2013/3/13', 2282.17, 2263.97, 2253.25, 2286.33],
				['2013/3/14', 2255.77, 2270.28, 2253.31, 2276.22],
				['2013/3/15', 2269.31, 2278.4, 2250, 2312.08],
				['2013/3/18', 2267.29, 2240.02, 2239.21, 2276.05],
				['2013/3/19', 2244.26, 2257.43, 2232.02, 2261.31],
				['2013/3/20', 2257.74, 2317.37, 2257.42, 2317.86],
				['2013/3/21', 2318.21, 2324.24, 2311.6, 2330.81],
				['2013/3/22', 2321.4, 2328.28, 2314.97, 2332],
				['2013/3/25', 2334.74, 2326.72, 2319.91, 2344.89],
				['2013/3/26', 2318.58, 2297.67, 2281.12, 2319.99],
				['2013/3/27', 2299.38, 2301.26, 2289, 2323.48],
				['2013/3/28', 2273.55, 2236.3, 2232.91, 2273.55],
				['2013/3/29', 2238.49, 2236.62, 2228.81, 2246.87],
				['2013/4/1', 2229.46, 2234.4, 2227.31, 2243.95],
				['2013/4/2', 2234.9, 2227.74, 2220.44, 2253.42],
				['2013/4/3', 2232.69, 2225.29, 2217.25, 2241.34],
				['2013/4/8', 2196.24, 2211.59, 2180.67, 2212.59],
				['2013/4/9', 2215.47, 2225.77, 2215.47, 2234.73],
				['2013/4/10', 2224.93, 2226.13, 2212.56, 2233.04],
				['2013/4/11', 2236.98, 2219.55, 2217.26, 2242.48],
				['2013/4/12', 2218.09, 2206.78, 2204.44, 2226.26],
				['2013/4/15', 2199.91, 2181.94, 2177.39, 2204.99],
				['2013/4/16', 2169.63, 2194.85, 2165.78, 2196.43],
				['2013/4/17', 2195.03, 2193.8, 2178.47, 2197.51],
				['2013/4/18', 2181.82, 2197.6, 2175.44, 2206.03],
				['2013/4/19', 2201.12, 2244.64, 2200.58, 2250.11],
				['2013/4/22', 2236.4, 2242.17, 2232.26, 2245.12],
				['2013/4/23', 2242.62, 2184.54, 2182.81, 2242.62],
				['2013/4/24', 2187.35, 2218.32, 2184.11, 2226.12],
				['2013/4/25', 2213.19, 2199.31, 2191.85, 2224.63],
				['2013/4/26', 2203.89, 2177.91, 2173.86, 2210.58],
				['2013/5/2', 2170.78, 2174.12, 2161.14, 2179.65],
				['2013/5/3', 2179.05, 2205.5, 2179.05, 2222.81],
				['2013/5/6', 2212.5, 2231.17, 2212.5, 2236.07],
				['2013/5/7', 2227.86, 2235.57, 2219.44, 2240.26],
				['2013/5/8', 2242.39, 2246.3, 2235.42, 2255.21],
				['2013/5/9', 2246.96, 2232.97, 2221.38, 2247.86],
				['2013/5/10', 2228.82, 2246.83, 2225.81, 2247.67],
				['2013/5/13', 2247.68, 2241.92, 2231.36, 2250.85],
				['2013/5/14', 2238.9, 2217.01, 2205.87, 2239.93],
				['2013/5/15', 2217.09, 2224.8, 2213.58, 2225.19],
				['2013/5/16', 2221.34, 2251.81, 2210.77, 2252.87],
				['2013/5/17', 2249.81, 2282.87, 2248.41, 2288.09],
				['2013/5/20', 2286.33, 2299.99, 2281.9, 2309.39],
				['2013/5/21', 2297.11, 2305.11, 2290.12, 2305.3],
				['2013/5/22', 2303.75, 2302.4, 2292.43, 2314.18],
				['2013/5/23', 2293.81, 2275.67, 2274.1, 2304.95],
				['2013/5/24', 2281.45, 2288.53, 2270.25, 2292.59],
				['2013/5/27', 2286.66, 2293.08, 2283.94, 2301.7],
				['2013/5/28', 2293.4, 2321.32, 2281.47, 2322.1],
				['2013/5/29', 2323.54, 2324.02, 2321.17, 2334.33],
				['2013/5/30', 2316.25, 2317.75, 2310.49, 2325.72],
				['2013/5/31', 2320.74, 2300.59, 2299.37, 2325.53],
				['2013/6/3', 2300.21, 2299.25, 2294.11, 2313.43],
				['2013/6/4', 2297.1, 2272.42, 2264.76, 2297.1],
				['2013/6/5', 2270.71, 2270.93, 2260.87, 2276.86],
				['2013/6/6', 2264.43, 2242.11, 2240.07, 2266.69],
				['2013/6/7', 2242.26, 2210.9, 2205.07, 2250.63],
				['2013/6/13', 2190.1, 2148.35, 2126.22, 2190.1]
			]);
			this.echartsOption.xAxis.data = this.resData.categoryData;
			this.echartsOption.series[0].data = this.resData.values;

			function splitData(rawData) {
				var categoryData = [];
				var values = [];
				for (var i = 0; i < rawData.length; i++) {
					categoryData.push(rawData[i].splice(0, 1)[0]);
					values.push(rawData[i]);
				}
				return {
					categoryData: categoryData,
					values: values
				};
			}
		}
	}
};
</script>

<style scoped src="./sellbuy.css"></style>
