<template>
	<div>
		<div class="placeabid1">
			<div class="placeabid2">
				<el-table :data="tableData" class="placeabid3">
					<el-table-column label="Type" width="180" align="left">
						<template slot-scope="scope">
							<img :src="scope.row.img" style="width:44px;height:50px;" />
							<span style="position: absolute;margin-top: 18px;">BNB</span>
						</template>
					</el-table-column>
					<el-table-column prop="name" label="Amount" width="180" align="left" :filters="tableStatus"></el-table-column>
					<el-table-column prop="address" label="Remaining" align="left" :filters="tableStatus"></el-table-column>
					<el-table-column prop="address" label="Currrent Price" align="left" :filters="tableStatus"></el-table-column>
					<el-table-column prop="address" label="Seller" align="left" :filters="tableStatus"></el-table-column>
				</el-table>
			</div>
		</div>
		<div style="height: 101px; ">
				<el-pagination class="fenpage"
				background
					@size-change="handleSizeChange"
					@current-change="handleCurrentChange"
					:current-page.sync="currentPage3"
					:page-size="100"
					layout="prev, pager, next, jumper"
					:total="1000"
				></el-pagination>
		</div>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			tableStatus: [{ text: '0.5-1.5', value: '0.5-1.5' }, { text: '1.5-2.5', value: '1.5-2.5' }],
			tableData: [
				{
					date: '2016-05-02',
					name: '王小虎额问问',
					address: '上海市普陀区喂喂喂金沙江路 1518 弄',
					img: require('../../static/Bitmap.png')
				},
				{
					date: '2016-05-02',
					name: '王小虎额问问',
					address: '上海市普陀区喂喂喂金沙江路 1518 弄',
					img: require('../../static/Bitmap.png')
				},
				{
					date: '2016-05-02',
					name: '王小虎额问问',
					address: '上海市普陀区喂喂喂金沙江路 1518 弄',
					img: require('../../static/Bitmap.png')
				},
				{
					date: '2016-05-02',
					name: '王小虎额问问',
					address: '上海市普陀区喂喂喂金沙江路 1518 弄',
					img: require('../../static/Bitmap.png')
				},
				{
					date: '2016-05-02',
					name: '王小虎额问问',
					address: '上海市普陀区喂喂喂金沙江路 1518 弄',
					img: require('../../static/Bitmap.png')
				},
				{
					date: '2016-05-02',
					name: '王小虎额问问',
					address: '上海市普陀区喂喂喂金沙江路 1518 弄',
					img: require('../../static/Bitmap.png')
				},
				{
					date: '2016-05-02',
					name: '王小虎额问问',
					address: '上海市普陀区喂喂喂金沙江路 1518 弄',
					img: require('../../static/Bitmap.png')
				}
			],
			currentPage1: 5,
			currentPage2: 5,
			currentPage3: 5,
			currentPage4: 4
		};
	},
	methods: {
		handleSizeChange(val) {
			window.console.log(`每页 ${val} 条`);
		},
		handleCurrentChange(val) {
			window.console.log(`当前页: ${val}`);
		}
	}
};
</script>

<style>
	.fenpage{
		position: absolute;
		margin-left: 747px;
		margin-top: 28px;
	}
.placeabid3 {
	height: 653px;
}
.placeabid2 {
	width: 1029px;
	margin-top: 32px;
	margin-left: 31px;
	position: absolute;
}
.placeabid1 {
	width: 1146px;
	height: 703px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 17px 0px rgba(219, 219, 219, 0.5);
	margin-top: 21px;
	margin-left: 147px;
}
</style>
