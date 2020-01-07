<template>
	<div>
		<v-sell></v-sell>
		<div class="placeabid1">
			<div class="placeabid4">
				<div v-for="(item, index) in list" :key="index">
					<div class="typemon shou" @click="forxuanzhong(index)">
						<img :src="item.img" />
						<div :class="[item.checked == true ? 'blue' : '']">{{ item.text1 }}</div>
						<div v-if="item.checked == true"></div>
					</div>
				</div>
			</div>
			<div class="placeabid2">
				<el-table
					:data="tableData"
					style="width: 90%;margin-left: 5%;margin-top: 30px;"
					:default-sort="{ prop: 'date', order: 'descending' }"
					class="tablebox"
					@row-click="getrollthing"
				>
					<el-table-column prop="date" label="Amount" sortable></el-table-column>
					<el-table-column prop="name" label="Remaining" sortable></el-table-column>
					<el-table-column prop="name" label="Currrent Price" sortable></el-table-column>
					<el-table-column prop="address" label="Seller"></el-table-column>
				</el-table>
			</div>
		</div>
		<div style="margin-top: 10px;">
			<el-pagination
				class="fenpage"
				background
				@size-change="handleSizeChange"
				@current-change="handleCurrentChange"
				:page-size="100"
				layout="prev, pager, next, jumper"
				:total="1000"
			></el-pagination>
		</div>
		<v-footer style="margin-top: 20px;"></v-footer>
	</div>
</template>

<script>
import sell from '../../assembly/sell/sell.vue';
import footer from '../../assembly/foot/foot.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer
	},
	data() {
		return {
			list: [
				{
					img: require('../../../static/Bitmap.png'),
					text1: 'BNB',
					checked: true
				},

				{
					img: require('../../../static/Bitmap (6).png'),
					text1: 'BTC',
					checked: false
				},
				{
					img: require('../../../static/Bitmap (2).png'),
					text1: 'ETH',
					checked: false
				}
			],
			tableData: [],
			tableDataall: [
				[
					{
						date: '0.5',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '0.5',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '0.5',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '0.5',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '0.5',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '0.5',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '0.5',
						name: '4 hours',
						address: '$5000'
					}
				],
				[
					{
						date: '1.5',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '1.5',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '15',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '15',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '15',
						name: '4 hours',
						address: '$5000'
					},
					{
						date: '15',
						name: '1hours',
						address: '$5000'
					},
					{
						date: '0.5',
						name: '1 hours',
						address: '$5000'
					}
				]
			],
			tableStatus: [{ text: '0.5-1.5', value: '0.5-1.5' }, { text: '1.5-2.5', value: '1.5-2.5' }],
			currentPage4: 4
		};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
		this.tableData = this.tableDataall[0];
	},
	methods: {
		handleSizeChange(val) {
			window.console.log(`每页 ${val} 条`);
		},
		handleCurrentChange(val) {
			window.console.log(`当前页: ${val}`);
		},
		forxuanzhong(e) {
			this.list.forEach(item => {
				item.checked = false;
			});
			this.list[e].checked = true;
			this.tableData = this.tableDataall[e];
		},
		getrollthing(val) {
			window.console.log(val);
			this.$router.push({ path: '/placedetail',
			query: {
				val: val.date
			},
			});
		}
	}
};
</script>

<style  scoped="scoped">
/deep/  .el-table th,
/deep/  .el-table tr {
	background-color: #fff;
	cursor: pointer;
}
.blue {
	color: rgba(0, 195, 255, 1);
}
.typemon {
	width: 143px;
	display: flex;
	align-items: center;
	margin-left: 20px;
	margin-top: 25px;
}
.typemon > img {
	width: 44px;
	height: 50px;
}
.typemon > div:nth-of-type(1) {
	width: 80px;
	height: 50px;
	display: flex;
	justify-content: center;
	align-items: center;
	font-size: 16px;
	font-weight: bold;
}
.typemon > div:nth-of-type(2) {
	width: 6px;
	height: 32px;
	background: rgba(0, 195, 255, 1);
	border-radius: 1px;
	float: right;
	position: absolute;
	margin-left: 138px;
}
/deep/  .el-table__row {
	height: 68px;
}
.placeabid4 {
	margin-left: 176px;
	margin-top: 21px;
	width: 163px;
	height: 573px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 17px 0px rgba(219, 219, 219, 0.5);
}
/deep/  .el-table--enable-row-hover .el-table__body tr:hover > td {
	background: rgba(255, 255, 255, 1) !important;
	box-shadow: 0px 8px 19px -5px rgba(69, 141, 254, 0.43);
	border-top: rgba(69, 141, 254, 0.27) solid 1px;
	border-bottom: rgba(69, 141, 254, 0.27) solid 1px;
}
.fenpage {
	margin-left: 747px;
}
.placeabid3 {
	height: 653px;
}
.placeabid2 {
	width: 943px;
	box-shadow: 0px 2px 17px 0px rgba(219, 219, 219, 0.5);
	background: rgba(255, 255, 255, 1);
	height: 573px;
	margin-top: 21px;
	margin-left: 31px;
}
.placeabid1 {
	display: flex;
	justify-content: center;
	width: 100%;
}
</style>
