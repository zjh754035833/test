<template>
	<div>
		<v-sell></v-sell>
		<div class="placeabid1">
			<div class="placeabid2">
				<el-table :data="tableData" style="width: 100%" :default-sort="{ prop: 'date', order: 'descending' }" >
					<el-table-column prop="date" label="日期" sortable width="180" style=""></el-table-column>
					<el-table-column prop="name" label="姓名" sortable width="180"></el-table-column>
					<el-table-column prop="address" label="地址" ></el-table-column>
				</el-table>
			</div>
		</div>
		<div style="height: 101px; ">
			<el-pagination
				class="fenpage"
				background
				@size-change="handleSizeChange"
				@current-change="handleCurrentChange"
				:current-page.sync="currentPage3"
				:page-size="100"
				layout="prev, pager, next, jumper"
				:total="1000"
			></el-pagination>
		</div>
		<v-footer style="margin-top: 60px;"></v-footer>
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
.el-table--enable-row-hover .el-table__body tr:hover>td {
background:rgba(255,255,255,1) !important;
box-shadow:0px 8px 19px -5px rgba(69,141,254,0.43);
border-top:rgba(69,141,254,0.27) solid 1px;
border-bottom:rgba(69,141,254,0.27) solid 1px;
}
.fenpage {
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
