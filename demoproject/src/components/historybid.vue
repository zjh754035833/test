<template>
	<div>
		<v-sell></v-sell>
		<div class="history">
			<div class="history1">
				<div class="history1-1">
					<span style="margin-left: 0px;">Bidders</span>
					<span>: 4</span>
					<span>Bids</span>
					<span>: 4</span>
					<span>Duration</span>
					<span>: 7 days</span>
				</div>
				<div class="history1-2">
					Only actual bids (not automatic bids generated up to a bidder's maximum) are shown. Automatic bids may be placed days or hours before a listing ends.
				</div>
				<div class="history1-3">Learn more about bidding.</div>
				<div class="history1-4">
					<el-popover placement="right-start"  width="200" trigger="hover" content="To keep Auwels a safe place for buyers, member-specific information is not displayed. Each bidder is assigned an anonymous name, that is used consistently throughout the bid history for an item.">
						<img src="../../static/gantan.png" class="gantan" slot="reference" />
					</el-popover>
					<el-table :data="tableData" style="width: 100%;height: 100%;">
						<el-table-column prop="date" label="Bidders"></el-table-column>
						<el-table-column prop="name" label="Bids"></el-table-column>
						<el-table-column prop="address" label="Bid time"></el-table-column>
						<el-table-column prop="address" label="Bid time"></el-table-column>
					</el-table>
				</div>
				<div class="history1-5">
					<div>View more</div>
					<img src="../../static/hengxiangjt.png" />
				</div>
			</div>
		</div>

		<v-footer></v-footer>
	</div>
</template>

<script>
import sell from '../assembly/sell/sell.vue';
import footer from '../assembly/foot/foot.vue';
export default {
	data() {
		return {
			tableData: [
				{
					date: '2016-05-02',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1518 弄'
				},
				{
					date: '2016-05-04',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1517 弄'
				},
				{
					date: '2016-05-01',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1519 弄'
				},
				{
					date: '2016-05-03',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1516 弄'
				},
				{
					date: '2016-05-03',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1516 弄'
				},
				{
					date: '2016-05-03',
					name: '王小虎',
					address: '上海市普陀区金沙江路 1516 弄'
				}
			]
		};
	},
	components: {
		'v-sell': sell,
		'v-footer': footer
	}
};
</script>

<style scoped="scoped">
	.gantan{
		margin-left: 70px;
		margin-top: 15px;
		width:17px;
		position: absolute;
		z-index: 999;
		
		height:17px;
	}
/deep/ .el-table__row {
	height: 68px;
}
.history1-5 {
	width: 100%;
	justify-content: center;
	height: 30px;
	align-items: center;
	display: flex;
	margin-top: 34px;
}
.history1-5 > div {
	font-size: 18px;
	color: rgba(153, 153, 153, 1);
}
.history1-5 > img {
	width: 5px;
	margin-left: 20px;
	margin-top: 5px;
	height: 11px;
}
.history1-4 {
	margin-top: 28px;
	margin-left: 57px;
	height: 380px;
}
.history1-3 {
	font-size: 15px;
	margin-left: 52px;
	font-weight: 400;
	color: rgba(0, 195, 255, 1);
}
.history1-2 {
	margin-top: 28px;
	font-size: 14px;
	font-weight: 400;
	margin-left: 52px;
	color: rgba(102, 102, 102, 1);
}
.history1-1 > span:nth-of-type(odd) {
	margin-left: 51px;
	font-size: 15px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.history1-1 > span:nth-of-type(even) {
	font-size: 15px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
}
.history1-1 {
	margin-top: 22px;
	margin-left: 52px;
}
.history {
	width: 100%;
	display: flex;
	justify-content: center;
	margin-top: 20px;
}
.history1 {
	width: 1146px;
	height: 631px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 17px 0px rgba(219, 219, 219, 0.5);
}
</style>
