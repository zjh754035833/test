<template>
	<div>
		<div>
			<el-dialog title="" :visible.sync="dialogTableVisible" width="75%">
				<div class="tanchu">
					<img src="../../../static/bluejiao.png" />
					<span>OUTPUT CHART-SHA-356(BITCOIN MINIMG)</span>
				</div>
				<div class="tanchu2"><span>Output in AUD</span></div>
				<div class="tanchu3"></div>
			</el-dialog>
		</div>
		<div class="ming1">
			<div>Make mining simpler and safer, start from $1</div>
			<div>Just choose your customized mining algorithm and get started today!</div>
			<div>
				<div class="ming2">
					<img src="../../../static/greensj.png" />
					<span>We diverse mining portfolio, choose from 10+ major mining algorithms, that span over 20+ minable cryptocurrency.</span>
				</div>
				<div class="ming3">
					<img src="../../../static/greensj.png" />
					<span>Mining outputs will be added to your account daily and automatically.</span>
				</div>
			</div>
		</div>
		<div class="ming1-1">
			<div style="display: inline-block;">
				<div class="ming4">
					<div>Select hash power</div>
					<div>{{ changeth }}TH/s</div>
					<div>
						<!-- <img src="../../../static/shandl.png" class="shandl" /> -->
						<div class="jindu">
							<div class="shandian">
								<el-slider v-model="value1" @change="changesider1" :format-tooltip="formatTooltip1" tooltip-class="toolstyle" :max="1000"></el-slider>
							</div>
							<!-- <el-progress :percentage="per" status="success" :color="customColor"></el-progress> -->
						</div>
					</div>
					<div>
						<span>TH/S</span>
						<span>1000TH/S</span>
					</div>
				</div>

				<div class="ming5">
					<div>Choose duration</div>
					<div>{{ changeday }}days</div>
					<div>
						<div class="jindu">
							<div class="shijian">
								<el-slider v-model="value2"  :format-tooltip="formatTooltip2" tooltip-class="toolstyle" :max="360"></el-slider>
								<!-- <el-progress :percentage="per" status="success" :color="customColor"></el-progress> -->
							</div>
						</div>
					</div>
					<div><span>Days</span></div>
				</div>
			</div>
			<div class="ming7">
				<div class="ming7-1">
					<div>3.5%</div>
					<div>Average on last 7-day-annual yield</div>
					<div class="ming7-1-3">
						<span>Mining from:</span>
						<span>$1</span>
						<span>Start date:</span>
						<span>2019-11-28</span>
					</div>
					<div></div>
					<div @click="formining" class="shou">view historical yield</div>
				</div>
			</div>
			<div class="ming6">
				<div class="ming6-1">
					<div>
						<span>Amount</span>
						<span>${{ nowprice }}</span>
					</div>
					<div>
						<span>Expected due output</span>
						<span>${{ estimated }}</span>
					</div>
					<div></div>
					<div class="shou">Start mining</div>
				</div>
			</div>
		</div>
		<div style="height: 27px;"></div>
	</div>
</template>

<script>
var _this;
import https from '../../https.js'
export default {
	components: {
		
	},
	data() {
		return {
			customColor: '#0091d5 0%,#0091d5 15%,#004a86 100%',
			gridData: [
				{
					date: '2016-05-02',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄'
				},
				{
					date: '2016-05-04',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄'
				},
				{
					date: '2016-05-01',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄'
				},
				{
					date: '2016-05-03',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄'
				}
			],
			dialogTableVisible: false,
			value1: 1,
			value2: 1,
			changeth: 10,
			changeday: 1,
			nowprice: '',
			yearh: '0.035',
			estimated: ''
		};
	},
		
	mounted() {
		
		_this = this;
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		suanli(){
			let params = { h: this.changeth, day: this.changeday };
			https
				.fetchPost('/debug/testMin', params)
				.then(data => {
					window.console.log(data);
					this.nowprice=(data.data.capital).toFixed(4);
					this.estimated=(data.data.capital+data.data.profit-data.data.fee).toFixed(4)
				})
				.catch(err => {
					window.console.log(err);
				});
		},
		formatTooltip1(val) {
			if (val < 10) {
				val = 10;
			}
			_this.changeth = val;
			this.nowprice = (_this.changeth * 0.1).toFixed(4);
			this.estimatval();
			return val + ' TH/s';
		},
		formatTooltip2(val) {
			if (val == 0) {
				val = 1;
			}
			_this.changeday = val;
			this.estimatval();
			return val + ' days';
		},
		changesider1(e) {
			window.console.log(e);
		},
		formining() {
			this.dialogTableVisible = true;
		},
		estimatval() {
			this.suanli()
		}
	}
};
</script>

<style src="./Ming.css" scoped="scoped"></style>
