<template>
	<div>
		<v-sell></v-sell>
		<div>
			<el-dialog title="" :visible.sync="dialogTableVisible" width="75%">
				<div class="tanchu">
					<img src="../../static/bluejiao.png" />
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
					<img src="../../static/greensj.png" />
					<span>We diverse mining portfolio, choose from 10+ major mining algorithms, that span over 20+ minable cryptocurrency.</span>
				</div>
				<div class="ming3">
					<img src="../../static/greensj.png" />
					<span>Mining outputs will be added to your account daily and automatically.</span>
				</div>
			</div>
		</div>
		<div class="ming1-1">
			<div style="display: inline-block;">
				<div class="ming4">
					<div>Select hash power</div>
					<div>780 TH/s</div>
					<div>
						<div :style="moveall" class="mingfor">
							<div>780TH/s</div>
							<img src="../../static/sjxgreen.png" />
						</div>
						<img src="../../static/shandl.png" class="shandl" />
						<div class="jindu"><el-progress :percentage="per" status="success" :color="customColor"></el-progress></div>
					</div>
					<div>
						<span>TH/S</span>
						<span>1000TH/S</span>
					</div>
				</div>

				<div class="ming5">
					<div>Choose duration</div>
					<div>7 days</div>
					<div>
						<div :style="moveall2" class="mingfor">
							<div>780TH/s</div>
							<img src="../../static/sjxgreen.png" />
						</div>
						<img src="../../static/shandl.png" class="shandl" />
						<div class="jindu"><el-progress :percentage="perduration" status="success" :color="customColor"></el-progress></div>
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
						<span>$22.1</span>
					</div>
					<div>
						<span>Estimated daily output will be</span>
						<span>$0.11</span>
					</div>
					<div></div>
					<div @click="formining" class="shou">Start mining</div>
				</div>
			</div>
		</div>
		<v-footer style="margin-top: 27px;"></v-footer>
	</div>
</template>

<script>
import sell from '../assembly/sell/sell.vue';
import footer from '../assembly/foot/foot.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer
	},
	data() {
		return {
			customColor: '#0091d5 0%,#0091d5 15%,#004a86 100%',
			moveall: '',
			per: '',
			perduration: '',
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
			dialogTableVisible: false
		};
	},
	created() {
		localStorage.setItem('clicksell', 4);
	},
	mounted() {
		this.perduration = '30';
		this.per = '20';
		this.moveall = 'margin-left:' + (-35 + (this.per / 100) * 65) + '%';
		this.moveall2 = 'margin-left:' + (-35 + (this.perduration / 100) * 65) + '%';
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		formining() {
			this.dialogTableVisible = true;
		}
	}
};
</script>

<style scoped="scoped">
/deep/ .el-icon-circle-check:before {
	display: none;
}
.tanchu3 {
	height: 350px;
}
.tanchu2 > span {
	margin-left: 18px;
}
.tanchu2 {
	margin-top: 21px;
	height: 43px;
	background: rgba(0, 195, 255, 1);
	border-radius: 2px;
	font-weight: 400;
	font-size: 17px;
	color: rgba(255, 255, 255, 1);
	line-height: 43px;
}
.tanchu {
	height: 40px;
	align-items: center;
	display: flex;
}
.tanchu > img {
	width: 4px;
	height: 17px;
	margin-left: 30px;
}
.tanchu > span {
	font-size: 17px;
	margin-left: 5px;
}
.ming6-1 > div:nth-of-type(3) {
	width: 777px;
	height: 1px;
	background-color: #eeeeee;
	margin-top: 20px;
	margin-left: 30px;
}
.ming6-1 > div:nth-of-type(4) {
	width: 164px;
	height: 42px;
	background: rgba(0, 195, 255, 1);
	border-radius: 2px;
	font-size: 18px;
	text-align: center;
	color: rgba(255, 255, 255, 1);
	line-height: 42px;
	float: right;
	margin-right: 32px;
	margin-top: 12px;
}
.ming6-1 {
	position: absolute;
}
.ming6-1 > div:nth-of-type(1) {
	height: 30px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-top: 16px;
	width: 837px;
}
.ming6-1 > div:nth-of-type(1) > span:nth-of-type(1) {
	font-size: 17px;
	color: rgba(102, 102, 102, 1);
	margin-left: 35px;
}
.ming6-1 > div:nth-of-type(1) > span:nth-of-type(2) {
	font-size: 22px;
	margin-right: 42px;
	font-weight: bold;
	color: #333333;
}
.ming6-1 > div:nth-of-type(2) > span:nth-of-type(1) {
	font-size: 17px;
	color: rgba(102, 102, 102, 1);
	margin-left: 35px;
}
.ming6-1 > div:nth-of-type(2) > span:nth-of-type(2) {
	font-size: 22px;
	font-weight: bold;
	margin-right: 42px;
	color: #333333;
}
.ming6-1 > div:nth-of-type(2) {
	height: 30px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	margin-top: 16px;
	width: 837px;
}
.ming7-1-3 {
	margin-top: 12px;
}
.ming7-1-3 > span:nth-of-type(1) {
	color: #666666;
	font-size: 13px;
}
.ming7-1-3 > span:nth-of-type(2) {
	color: #333333;
	font-weight: bold;
	font-size: 13px;
}
.ming7-1-3 > span:nth-of-type(3) {
	margin-left: 44px;
	color: #666666;
	font-size: 13px;
}
.ming7-1-3 > span:nth-of-type(4) {
	color: #333333;
	font-weight: bold;
	font-size: 13px;
}
.ming7-1 {
	width: 414px;
	position: absolute;
	display: flex;
	flex-direction: column;
	align-items: center;
}
.ming7-1 > div:nth-of-type(1) {
	font-size: 45px;
	color: rgba(238, 66, 86, 1);
	margin-top: 29px;
}
.ming7-1 > div:nth-of-type(2) {
	margin-top: 10px;
	font-size: 13px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.ming7-1 > div:nth-of-type(4) {
	width: 348px;
	height: 2px;
	background: #eeeeee;
	margin-top: 41px;
}
.ming7-1 > div:nth-of-type(5) {
	width: 170px;
	height: 40px;
	font-size: 16px;
	line-height: 40px;
	text-align: center;
	background: rgba(243, 243, 243, 1);
	border: 1px solid rgba(219, 219, 219, 1);
	margin-top: 29px;
}
.mingfor {
	font-size: 14px;
	color: #00e3aa;
}
.mingfor > img {
	width: 7px;
	height: 4px;
	position: absolute;
	margin-left: 28%;
}
.el-progress.is-success .el-progress__text {
	display: none;
}
.el-progress__text i {
	display: none;
}
.el-progress.is-success .el-progress-bar__inner {
	background: linear-gradient(270deg, rgba(0, 228, 167, 1) 0%, rgba(0, 195, 255, 1) 100%);
}
.ming4 > div:nth-of-type(1) {
	font-size: 18px;
	font-weight: bold;
	margin-left: 37px;
	margin-top: 15px;
	position: absolute;
}
.ming4 > div:nth-of-type(2) {
	font-size: 14px;
	margin-left: 40px;
	margin-top: 44px;
	position: absolute;
}
.ming5 > div:nth-of-type(1) {
	font-size: 18px;
	font-weight: bold;
	margin-left: 37px;
	margin-top: 15px;
	position: absolute;
}
.ming5 > div:nth-of-type(2) {
	font-size: 14px;
	margin-left: 40px;
	margin-top: 44px;
	position: absolute;
}
.ming4 > div:nth-of-type(3) {
	font-size: 14px;
	position: absolute;
	width: 414px;
	display: flex;
	margin-top: 90px;
	height: 20px;
	justify-content: center;
}
.ming5 > div:nth-of-type(3) {
	font-size: 14px;
	position: absolute;
	width: 414px;
	display: flex;
	margin-top: 90px;
	height: 20px;
	justify-content: center;
}
.ming4 > div:nth-of-type(3) > div:nth-of-type(1) {
	margin-top: -20px;
	position: absolute;
}
.ming5 > div:nth-of-type(3) > div:nth-of-type(1) {
	margin-top: -20px;
	position: absolute;
}
.ming4 > div:nth-of-type(4) {
	position: absolute;
	font-size: 13px;
	font-weight: 400;
	margin-top: 113px;
	margin-left: 30px;
	color: rgba(153, 153, 153, 1);
}
.ming5 > div:nth-of-type(4) {
	position: absolute;
	font-size: 13px;
	font-weight: 400;
	margin-top: 113px;
	margin-left: 30px;
	color: rgba(153, 153, 153, 1);
}
.ming4 > div:nth-of-type(4) > span:nth-of-type(2) {
	margin-left: 237px;
}
.ming5 > div:nth-of-type(4) > span:nth-of-type(2) {
	margin-left: 237px;
}
.shandl {
	width: 20px;
	height: 20px;
}
.jindu {
	width: 328px;
	height: 5px;
}
.ming7 {
	margin-left: 7px;
	width: 414px;
	height: 294px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 7px 0px rgba(220, 220, 220, 0.5);
	border-radius: 2px;
	display: inline-block;
}
.ming6 {
	width: 837px;
	height: 176px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 7px 0px rgba(220, 220, 220, 0.5);
	border-radius: 2px;
	margin-top: 7px;
}
.ming5 {
	width: 414px;
	height: 144px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 7px 0px rgba(220, 220, 220, 0.5);
	border-radius: 2px;
	margin-top: 6px;
}
.ming1-1 {
	margin-left: 301px;
	margin-top: 9px;
}
.ming4 {
	width: 414px;
	height: 144px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 7px 0px rgba(220, 220, 220, 0.5);
	border-radius: 2px;
}
.ming2 {
	margin-left: 23px;
}
.ming3 {
	margin-left: 23px;
}
.ming2 > span {
	margin-left: 10px;
	margin-right: 20px;
	font-size: 14px;
	color: #ffffff;
	opacity: 0.8;
}
.ming2 > img {
	width: 5px;
	height: 9px;
}
.ming3 > img {
	width: 5px;
	height: 9px;
}
.ming3 > span {
	margin-left: 10px;
	font-size:14px;
	color: #ffffff;
	opacity: 0.8;
}
.ming1 {
	width: 100%;
	height: 192px;
	background: rgba(10, 62, 105, 1);
	display: flex;
	align-items: center;
	flex-direction: column;
}
.ming1 > div:nth-of-type(3) {
	height: 73px;
	background: #1e4d75;
	border-radius: 3px;
	margin-top: 12px;
	display: flex;
	flex-direction: column;
	justify-content: center;
}
.ming1 > div:nth-of-type(2) {
	font-size: 14px;
	font-weight: 400;
	color: rgba(255, 255, 255, 1);
	margin-top: 9px;
}
.ming1 > div:nth-of-type(1) {
	font-size: 28px;
	font-weight: bold;
	margin-top: 12px;
	color: rgba(255, 255, 255, 1);
}
</style>
