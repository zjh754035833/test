<template>
	<div>
		<div class="mingall">
		<div class="ming1">
			<div>Make mining simpler and safer, start from $1</div>
			<div>

				<div class="ming3">
					<img src="../../../static/greensj.png" />
					<span>We diverse mining portfolio, choose from 10+ major mining algorithms, that span over 20+ minable cryptocurrency.</span>
				</div>
				<div class="ming3">
					<img src="../../../static/greensj.png" />
					<span>Mining outputs will be added to your account daily and automatically.</span>
				</div>
				<div class="ming3">
					<img src="../../../static/greensj.png" />
					<span>purchase & redeem at anytime</span>
				</div>
			</div>
		</div>
		<div class="ming1-1">
			<div>
				<div class="ming4">
					<div class="ming4top">
					<div class="ming4-1">
						<div>Select mining algorithms</div>
						<div>{{ changeth }}</div>
						<div>TH/s</div>
					</div>
					
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
						<div>TH/S</div>
						<div>1000TH/S</div>
					</div>
					</div>
					<div class="mingxian"></div>
					<div class="ming4-bottom">
						<div class="ming4-bottom-1">3.5% </div>
						<div class="ming4-bottom-2">
							<div >Average on last 7-day-annual yield</div>
							<div style="margin-top: 13px;">
								<span>Mining from: <span class="ming-bottom-value">$1</span> </span>
								<span style="margin-left: 52px;">Start date: <span class="ming-bottom-value">2019-11-28</span> </span>
							</div>
						</div>
					</div>
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
		<div style="height: 30px;"></div>
		</div>
	</div>
</template>

<script>
var _this;
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
			changeth: 10,
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
		formatTooltip1(val) {
			if (val < 10) {
				val = 10;
			}
			_this.changeth = val;
			this.nowprice = (_this.changeth * 0.1).toFixed(4);
			this.estimatval();
			return val + ' TH/s';
		},
		changesider1(e) {
			window.console.log(e);
		},
		formining() {
			this.dialogTableVisible = true;
		},
		estimatval() {
		}
	}
};
</script>

<style src="./Ming.css" scoped="scoped"></style>
