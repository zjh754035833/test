<template>
	<div>
		<div :style="kquanp">
			<img src="../../static/formore.png" class="nomore"  @click="tquanp"   />
			<div id="myChart1" ref="myChart1"></div>
		</div>
		<div :style="gquanp">
			<v-sell></v-sell>
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
			<div class="sellbuy1">
				<div class="sellbuy3">
					<span>BTC</span>
					<span>/USDT</span>
				</div>
				<div class="sellbuy2">
					<div class="text1" v-for="(item, index) in list" :key="index">
						<div>{{ item.msg }}</div>
						<div style="height: 3px;"></div>
						<span v-if="item.msg != '24h change'">{{ item.price }}</span>
						<span style="color:rgba(238,66,86,1);" v-if="item.msg == '24h change'">{{ item.price }}</span>
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
				<img src="../../static/formore.png" @click="formore" />
			</div>
			<div id="myChart" ref="myChart"></div>
			<div class="sellbuy5"><span>Buy BTC</span></div>
			<div class="sellbuy4">
				<div>
					<span>Price：</span>
					<input />
				</div>
				<div>
					<span>Amount：</span>
					<input />
				</div>
				<div class="sellbuy4-1">
					<div>25%</div>
					<div>50%</div>
					<div>75%</div>
					<div>100%</div>
				</div>
				<div>
					<span>Total：</span>
					<input />
				</div>
				<div class="forbuy">Buy</div>
			</div>
			<div class="sellbuy5" style="margin-top: 25px;"><span>Buy BTC</span></div>
			<div class="sellbuy4" style="margin-top: 95px;">
				<div>
					<span>Price：</span>
					<input />
				</div>
				<div>
					<span>Amount：</span>
					<input />
				</div>
				<div class="sellbuy4-1">
					<div>25%</div>
					<div>50%</div>
					<div>75%</div>
					<div>100%</div>
				</div>
				<div>
					<span>Total：</span>
					<input />
				</div>
				<div class="forbuy" style="background:rgba(1,211,210,1);">sell</div>
			</div>
		</div>
	</div>
</template>

<script>
import echarts from 'echarts';
import sell from '../assembly/sell/sell.vue';

export default {
	components: {
		'v-sell': sell
	},
	name: 'echarts',
	data() {
		return {
			booleenpin: false,
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
				{ msg: 'Last Price', price: '8,148.85 $8,767.8' },
				{ msg: '24h change', price: '-78.23 -0.87%' },
				{ msg: '24h High', price: '8,635.00' },
				{ msg: '24h Low', price: '8,766.00' },
				{ msg: '24h Volume', price: '208,988,999.98 USDT' }
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
			gquanp: 'display:block'
		};
	},
	created() {
		localStorage.setItem('clicksell', 1);
	},
	mounted() {
		this.setEchartOption();
		this.myChart = echarts.init(document.getElementById('myChart'));
		this.myChart1 = echarts.init(document.getElementById('myChart1'));
		this.myChart.setOption(this.echartsOption);
		this.myChart1.setOption(this.echartsOption);
		this.drawLine();
	},
	methods: {
		formore() {
			this.kquanp = 'display:block';
			this.gquanp = 'display:none';
		},
		tquanp(){
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

<style scoped>
.nomore{
	z-index: 99999;
	float: right;
	margin-right: 10%;
	cursor: pointer;
}
.clichart > div:nth-of-type(2) {
}
.clichart > div:nth-of-type(1) {
	margin-left: 20px;
}
.clichart > div:nth-of-type(7) {
}
.clichart > div {
	cursor: pointer;
	font-size: 14px;
}
.clichart > img {
	cursor: pointer;
	width: 16px;
	height: 16px;
	margin-right: 20px;
}
.ALLZI {
	font-size: 14px;
	font-family: ArialMT;
	color: rgba(51, 51, 51, 1);
}
.clichart {
	display: flex;
	align-items: center;
	justify-content: space-between;
	z-index: 999;
	width: 900px;
	height: 40px;
	background: rgba(238, 238, 238, 1);
	margin-top: 140px;
	margin-left: 91px;
	border-radius: 1px;
	position: absolute;
}
#myChart {
	position: absolute;
	width:900px;
	height: 621px;
	position: absolute;
	margin: 0 auto;
	margin-top: 150px;
	margin-left: 100px;
	
}
#myChart1 {
	left:0;
	right:0;
	top:0;
	bottom:0;
	z-index: -1;
		margin:  auto;
	font-size: 14px;
	width: 1440px;
	height: 600px;
	position: absolute;
	margin: 0 auto;
}
.blue1 {
	color: #00c3ff;
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
	height: 710px;
	background: rgba(254, 254, 254, 1);
	margin-top: 24px;
}
.all {
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
	color: rgba(0, 195, 255, 1);
	margin-left: 21px;
}
.bottomarea2 > span:nth-of-type(4) {
}
.bottomarea2 {
	font-size: 20px;
	text-align: center;
	margin-top: 25px;
	display: flex;
	justify-content: center;
}
.biaoti {
	margin-top: 200px;
	margin-left: 88px;
}
.sellbuy6 {
	margin-left: 88px;
	margin-top: 139px;
	width: 900px;
	height: 40px;
	background: rgba(238, 238, 238, 1);
	border-radius: 1px;
	position: absolute;
}
.forbuy {
	font-size: 18px;
	width: 224px;
	height: 37px;
	background: rgba(238, 66, 86, 1);
	border-radius: 1px;
	line-height: 37px;
	text-align: center;
	color: rgba(255, 255, 255, 1);
	position: absolute;
	margin-top: 216px;
	margin-left: 60px;
}
.sellbuy4 > div > span {
	margin-left: 27px;
	font-size: 14px;
	color: rgba(51, 51, 51, 1);
	margin-top: 31px;
	position: absolute;
}
.sellbuy4 > div:nth-of-type(2) > span {
	margin-left: 27px;
	font-size: 14px;
	color: rgba(51, 51, 51, 1);
	margin-top: 73px;
	position: absolute;
}
.sellbuy4 > div:nth-of-type(4) > span {
	margin-left: 35px;
	font-size: 14px;
	color: rgba(51, 51, 51, 1);
	position: absolute;
	margin-top: 151px;
}
.sellbuy4 > div {
	position: absolute;
}
.sellbuy4 > div > input {
	margin-top: 27px;
	width: 224px;
	height: 28px;
	border-radius: 1px;
	position: absolute;
	border: 1px solid rgba(238, 238, 238, 1);
	margin-left: 91px;
}
.sellbuy4 > div:nth-of-type(2) > input {
	width: 224px;
	height: 28px;
	border-radius: 1px;
	position: absolute;
	border: 1px solid rgba(238, 238, 238, 1);
	margin-left: 91px;
	margin-top: 69px;
}
.sellbuy4-1 {
	display: flex;
	justify-content: space-around;
	margin-top: 107px;
	margin-left: 91px;
}
.sellbuy4-1 > div {
	text-align: center;
	line-height: 28px;
	margin-left: 3px;
	font-size: 13px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	width: 51px;
	height: 28px;
	border-radius: 1px;
	border: 1px solid rgba(238, 238, 238, 1);
}

.sellbuy4 > div:nth-of-type(4) > input {
	width: 224px;
	height: 28px;
	border-radius: 1px;
	position: absolute;
	border: 1px solid rgba(238, 238, 238, 1);
	margin-left: 91px;
	margin-top: 147px;
}
.sellbuy5 > span {
	margin-left: 22px;
}
.sellbuy5 {
	display: flex;
	align-items: center;
	width: 342px;
	height: 40px;
	font-size: 16px;
	background: rgba(238, 238, 238, 1);
	border-radius: 1px;
	margin-left: 1007px;
	margin-top: 140px;
	position: absolute;
	font-weight: bold;
	border-radius: 1px;
	border: 1px solid rgba(232, 232, 232, 1);
}
.sellbuy4 {
	display: flex;
	flex-direction: column;
	width: 344px;
	height: 263px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	border: 1px solid rgba(232, 232, 232, 1);
	margin-left: 1007px;
	margin-top: 180px;
}
.sellbuy1 > div:nth-of-type(1) > span:nth-of-type(1) {
	font-size: 28px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
}
.sellbuy1 > div:nth-of-type(1) > span:nth-of-type(2) {
	margin-top: 9px;
	font-size: 17px;
	color: rgba(153, 153, 153, 1);
}
.sellbuy3 {
	display: flex;
	position: absolute;
	margin-left: 19px;
}
.sellbuy1 {
	width: 1270px;
	height: 86px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	position: absolute;
	display: flex;
	align-items: center;
	margin-top: 42px;
	margin-left: 85px;
}
.sellbuy2 {
	display: flex;
	align-items: center;
	margin-left: 177px;
	justify-content: space-around;
	width: 800px;
}
.text1 {
	font-size: 15px;
	font-family: ArialMT;
	color: rgba(153, 153, 153, 1);
}

.text1 > span {
	font-size: 15px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
}
</style>
