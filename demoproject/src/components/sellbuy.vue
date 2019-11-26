<template>
	<div>
		<v-sell></v-sell>
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
		<div id="myChart" :style="{ width: '800px', height: '621px',position:'absolute' }" class="biaoti"></div>
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
		<div class="sellbuy5" style="margin-top: 421px;"><span>Buy BTC</span></div>
		<div class="sellbuy4" style="margin-top: 458px;">
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
</template>

<script>
import sell from '../../build/sell/sell.vue';

export default {
	components: {
		'v-sell': sell
	},
	data() {
		return {
			list: [
				{ msg: 'Last Price', price: '8,148.85 $8,767.8' },
				{ msg: '24h change', price: '-78.23 -0.87%' },
				{ msg: '24h High', price: '8,635.00' },
				{ msg: '24h Low', price: '8,766.00' },
				{ msg: '24h Volume', price: '208,988,999.98 USDT' }
			]
		};
	},
	mounted() {
		this.drawLine();
		
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		splitData(rawData) {
			var categoryData = [];
			var values = [];
			var volumes = [];
			for (var i = 0; i < rawData.length; i++) {
				categoryData.push(rawData[i].splice(0, 1)[0]);
				values.push(rawData[i]);
				volumes.push([i, rawData[i][4], rawData[i][0] > rawData[i][1] ? 1 : -1]);
			}

			return {
				categoryData: categoryData,
				values: values,
				volumes: volumes
			};
		},
		calculateMA(dayCount, data) {
			var result = [];
			for (var i = 0, len = data.values.length; i < len; i++) {
				if (i < dayCount) {
					result.push('-');
					continue;
				}
				var sum = 0;
				for (var j = 0; j < dayCount; j++) {
					sum += data.values[i - j][1];
				}
				result.push(+(sum / dayCount).toFixed(3));
			}
			return result;
		},
		drawLine() {
			var rawData = [[17512.58,17633.11,17434.27,17642.81,86160000],[17652.36,17716.66,17652.36,17790.11,79330000],[17716.05,17685.09,17669.72,17755.7,102600000],[17661.74,17792.75,17568.02,17811.48,104890000],[17799.39,17737,17710.67,17806.38,85230000],[17718.03,17603.32,17579.56,17718.03,115230000],[17605.45,17716.05,17542.54,17723.55,99410000],[17687.28,17541.96,17484.23,17687.28,90120000],[17555.39,17576.96,17528.16,17694.51,79990000],[17586.48,17556.41,17555.9,17731.63,107100000],[17571.34,17721.25,17553.57,17744.43,81020000],[17741.66,17908.28,17741.66,17918.35,91710000],[17912.25,17926.43,17885.44,17962.14,84510000],[17925.95,17897.46,17867.41,17937.65,118160000],[17890.2,18004.16,17848.22,18009.53,89390000],[18012.1,18053.6,17984.43,18103.46,89820000],[18059.49,18096.27,18031.21,18167.63,100210000],[18092.84,17982.52,17963.89,18107.29,102720000],[17985.05,18003.75,17909.89,18026.85,134120000],[17990.94,17977.24,17855.55,17990.94,83770000],[17987.38,17990.32,17934.17,18043.77,92570000],[17996.14,18041.55,17920.26,18084.66,109090000],[18023.88,17830.76,17796.55,18035.73,100920000],[17813.09,17773.64,17651.98,17814.83,136670000],[17783.78,17891.16,17773.71,17912.35,80100000],[17870.75,17750.91,17670.88,17870.75,97060000],[17735.02,17651.26,17609.01,17738.06,95020000],[17664.48,17660.71,17615.82,17736.11,81530000],[17650.3,17740.63,17580.38,17744.54,80020000],[17743.85,17705.91,17668.38,17783.16,85590000],[17726.66,17928.35,17726.66,17934.61,75790000],[17919.03,17711.12,17711.05,17919.03,87390000],[17711.12,17720.5,17625.38,17798.19,88560000],[17711.12,17535.32,17512.48,17734.74,86640000],[17531.76,17710.71,17531.76,17755.8,88440000],[17701.46,17529.98,17469.92,17701.46,103260000],[17501.28,17526.62,17418.21,17636.22,79120000],[17514.16,17435.4,17331.07,17514.16,95530000],[17437.32,17500.94,17437.32,17571.75,111990000],[17507.04,17492.93,17480.05,17550.7,87790000],[17525.19,17706.05,17525.19,17742.59,86480000],[17735.09,17851.51,17735.09,17891.71,79180000],[17859.52,17828.29,17803.82,17888.66,68940000],[17826.85,17873.22,17824.73,17873.22,73190000],[17891.5,17787.2,17724.03,17899.24,147390000],[17754.55,17789.67,17664.79,17809.18,78530000],[17789.05,17838.56,17703.55,17838.56,75560000],[17799.8,17807.06,17689.68,17833.17,82270000],[17825.69,17920.33,17822.81,17949.68,71870000],[17936.22,17938.28,17936.22,18003.23,78750000],[17931.91,18005.05,17931.91,18016,71260000],[17969.98,17985.19,17915.88,18005.22,69690000],[17938.82,17865.34,17812.34,17938.82,90540000],[17830.5,17732.48,17731.35,17893.28,101690000],[17710.77,17674.82,17595.79,17733.92,93740000],[17703.65,17640.17,17629.01,17762.96,94130000],[17602.23,17733.1,17471.29,17754.91,91950000],[17733.44,17675.16,17602.78,17733.44,248680000],[17736.87,17804.87,17736.87,17946.36,99380000],[17827.33,17829.73,17799.8,17877.84,85130000],[17832.67,17780.83,17770.36,17920.16,89440000]];
			var upColor = '#00da3c';
			var downColor = '#ec0000';
			var data = this.splitData(rawData);
			// 基于准备好的dom，初始化echarts实例
			let myChart = this.$echarts.init(document.getElementById('myChart'));
			// 绘制图表
			myChart.setOption({
				backgroundColor: '#fff',
				animation: false,
				legend: {
					bottom: 10,
					left: 'center',
					data: ['Dow-Jones index', 'MA5', 'MA10', 'MA20', 'MA30']
				},
				tooltip: {
					trigger: 'axis',
					axisPointer: {
						type: 'cross'
					},
					backgroundColor: 'rgba(245, 245, 245, 0.8)',
					borderWidth: 1,
					borderColor: '#ccc',
					padding: 10,
					textStyle: {
						color: '#000'
					},
					position: function(pos, params, el, elRect, size) {
						var obj = { top: 10 };
						obj[['left', 'right'][+(pos[0] < size.viewSize[0] / 2)]] = 30;
						return obj;
					}
					// extraCssText: 'width: 170px'
				},
				axisPointer: {
					link: { xAxisIndex: 'all' },
					label: {
						backgroundColor: '#777'
					}
				},
				toolbox: {
					feature: {
						dataZoom: {
							yAxisIndex: false
						},
						brush: {
							type: ['lineX', 'clear']
						}
					}
				},
				brush: {
					xAxisIndex: 'all',
					brushLink: 'all',
					outOfBrush: {
						colorAlpha: 0.1
					}
				},
				visualMap: {
					show: false,
					seriesIndex: 5,
					dimension: 2,
					pieces: [
						{
							value: 1,
							color: downColor
						},
						{
							value: -1,
							color: upColor
						}
					]
				},
				grid: [
					{
						left: '10%',
						right: '8%',
						height: '50%'
					},
					{
						left: '10%',
						right: '8%',
						top: '63%',
						height: '16%'
					}
				],
				xAxis: [
					{
						type: 'category',
						data: data.categoryData,
						scale: true,
						boundaryGap: false,
						axisLine: { onZero: false },
						splitLine: { show: false },
						splitNumber: 20,
						min: 'dataMin',
						max: 'dataMax',
						axisPointer: {
							z: 100
						}
					},
					{
						type: 'category',
						gridIndex: 1,
						data: data.categoryData,
						scale: true,
						boundaryGap: false,
						axisLine: { onZero: false },
						axisTick: { show: false },
						splitLine: { show: false },
						axisLabel: { show: false },
						splitNumber: 20,
						min: 'dataMin',
						max: 'dataMax'
					}
				],
				yAxis: [
					{
						scale: true,
						splitArea: {
							show: true
						}
					},
					{
						scale: true,
						gridIndex: 1,
						splitNumber: 2,
						axisLabel: { show: false },
						axisLine: { show: false },
						axisTick: { show: false },
						splitLine: { show: false }
					}
				],
				dataZoom: [
					{
						show: true,
						xAxisIndex: [0, 1],
						type: 'slider',
						top: '85%',
						start: 98,
						end: 100
					}
				],
				series: [
					{
						name: 'Dow-Jones index',
						type: 'candlestick',
						data: data.values,
						itemStyle: {
							normal: {
								color: upColor,
								color0: downColor,
								borderColor: null,
								borderColor0: null
							}
						},
						tooltip: {
							formatter: function(param) {
								param = param[0];
								return [
									'Date: ' + param.name + '<hr size=1 style="margin: 3px 0">',
									'Open: ' + param.data[0] + '<br/>',
									'Close: ' + param.data[1] + '<br/>',
									'Lowest: ' + param.data[2] + '<br/>',
									'Highest: ' + param.data[3] + '<br/>'
								].join('');
							}
						}
					},
					{
						name: 'MA5',
						type: 'line',
						data: this.calculateMA(5, data),
						smooth: true,
						lineStyle: {
							normal: { opacity: 0.5 }
						}
					},
					{
						name: 'MA10',
						type: 'line',
						data: this.calculateMA(10, data),
						smooth: true,
						lineStyle: {
							normal: { opacity: 0.5 }
						}
					},
					{
						name: 'MA20',
						type: 'line',
						data: this.calculateMA(20, data),
						smooth: true,
						lineStyle: {
							normal: { opacity: 0.5 }
						}
					},
					{
						name: 'MA30',
						type: 'line',
						data: this.calculateMA(30, data),
						smooth: true,
						lineStyle: {
							normal: { opacity: 0.5 }
						}
					},
					{
						name: 'Volume',
						type: 'bar',
						xAxisIndex: 1,
						yAxisIndex: 1,
						data: data.volumes
					}
				]
			});
		}
	}
};
</script>

<style scoped>
	.biaoti{
		margin-top: 139px;
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
	position: absolute;
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
