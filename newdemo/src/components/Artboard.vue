<template>
	<div>
		<div class="toparea1">
			<img src="../../static/loginsu.png" />
			<div>
				<span>账户余额：</span>
				<span>￥18458.88</span>
			</div>
		</div>
		<div class="toparea2">
			<div>推广内容</div>
			<div><el-input type="textarea" placeholder="请输入内容" v-model="textarea" maxlength="200" show-word-limit></el-input></div>
			<div>批量导入信息</div>
			<div>
				<div>电话号码</div>
				<div class="shou">+批量导入</div>
			</div>
			<div class="allphone">
				<div style="margin-left: 18px;margin-top: 17px;">
					<el-checkbox-group v-model="checkList">
						<div class="checksty" v-for="(gtem, index) in phonelist" :key="index">
							<el-checkbox :label="gtem"></el-checkbox>
							<div class="xian"></div>
						</div>
					</el-checkbox-group>
				</div>
			</div>
			<div class="boottomarea">
				<el-checkbox :indeterminate="isIndeterminate" style="margin-left: 22px;" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
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
			<div class="dibu">发送</div>
		</div>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			checkAll: false,
			textarea: '',
			checkList: ['选中且禁用', '复选框 A'],
			isIndeterminate: true,
			phonelist: [
				'18362161491',
				'18362161492',
				'18362161493',
				'18362161494',
				'18362161495',
				'18362161497',
				'18362161498',
				'18362161499',
				'18362161490',
				'18362161416',
				'18362161426',
				'18362161436',
				'18362161446',
				'18362161456',
				'18362161466',
				'18362161476',
				'18362161486',
				'18362161406',
				'18362161196',
				'18362161296',
				'18362161396',
				'18362161496',
				'18362161596',
				'18362161696',
				'18362161796',
				'18362161896',
				'18362161996',
				'18362161096',
				'18362162496',
				'18362163496',
				'18362164496'
			]
		};
	},
	created: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:rgba(246, 246, 246, 1)');
	},
	methods: {
		handleSizeChange(val) {
			window.console.log(`每页 ${val} 条`);
		},
		handleCurrentChange(val) {
			window.console.log(`当前页: ${val}`);
		},
		handleCheckAllChange(val) {
			window.console.log(val);
			this.checkList = val ? this.phonelist : [];
			this.isIndeterminate = false;
		}
	}
};
</script>

<style scoped>
.dibu {
	width: 443px;
	height: 41px;
	background: rgba(0, 195, 255, 1);
	border-radius: 1px;
	font-size: 15px;
	font-weight: 400;
	color: rgba(255, 255, 255, 1);
	line-height: 41px;
	text-align: center;
	margin-top: 60px;
}
.fenpage {
	margin-left: 580px;
}
.boottomarea {
	display: flex;
	width: 1226px;
	height: 40px;
	align-items: center;
	margin-top: 40px;
}
.allphone::-webkit-scrollbar {
	/*滚动条整体样式*/
	width: 4px; /*高宽分别对应横竖滚动条的尺寸*/
	height: 4px;
}
.allphone::-webkit-scrollbar-thumb {
	/*滚动条里面小方块*/
	border-radius: 5px;
	-webkit-box-shadow: inset 0 0 5px rgba(216, 216, 216, 1);
	background: rgba(0, 0, 0, 0.2);
}
.allphone::-webkit-scrollbar-track {
	/*滚动条里面轨道*/
	-webkit-box-shadow: inset 0 0 5px rgba(216, 216, 216, 1);
	border-radius: 0;
	background: rgba(216, 216, 216, 1);
}
.xian {
	width: 198px;
	height: 1px;
	margin-top: 10px;
	opacity: 0.5;
	background-color: rgba(209, 216, 245, 0.6);
}
.checksty {
	height: 70px;
	display: inline-block;
	width: 198px;
}
.allphone {
	overflow: auto;
	position: relative;
	width: 1226px;
	height: 326px;
	background: rgba(255, 255, 255, 1);
	border-radius: 2px;
	border: 0.5px solid rgba(209, 216, 245, 1);
}
/deep/.el-textarea {
	background: rgba(255, 255, 255, 1);
}
/deep/ .el-textarea__inner {
	height: 174px;
	margin-top: 16px;
	font-size: 17px;
	padding-top: 24px;
	padding-bottom: 24px;
	color: rgba(102, 102, 102, 1);
	opacity: 1;
}
/deep/ .el-textarea .el-input__count {
	color: rgba(102, 102, 102, 1);
}
/deep/ .toparea2 > div[data-v-9cfc9dda]:nth-of-type(2) {
	width: 1224px;
	background: rgba(246, 246, 246, 1);
	opacity: 1;
	border: none;
	/* height: 30%; */
}
/deep/ .el-textarea__inner:focus {
	outline: 0;
	border-color: rgba(209, 216, 245, 1);
}
.toparea2 > div:nth-of-type(1) {
	width: 1224px;
	font-size: 17px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
	margin-top: 22px;
}
.toparea2 > div:nth-of-type(2) {
	width: 1224px;
	background: rgba(246, 246, 246, 1);
	border-radius: 1px;
	opacity: 0.5;
	border: 1px solid rgba(209, 216, 245, 1);
}
.toparea2 > div:nth-of-type(3) {
	width: 1224px;
	font-size: 17px;
	font-weight: 600;

	color: rgba(51, 51, 51, 1);
	margin-top: 31px;
}
.toparea2 > div:nth-of-type(4) {
	margin-top: 26px;
	width: 1224px;
	height: 53px;
	background: RGBA(251, 251, 251, 1);
	border-radius: 1px;
	display: flex;
	align-items: center;
}
.toparea2 > div:nth-of-type(4) > div:nth-of-type(1) {
	margin-left: 5px;
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.toparea2 > div:nth-of-type(4) > div:nth-of-type(2) {
	margin-left: 923px;
	width: 119px;
	height: 32px;
	border-radius: 4px;
	border: 1px solid rgba(69, 141, 254, 1);
	font-size: 14px;
	font-weight: 400;
	line-height: 32px;
	text-align: center;
	color: rgba(69, 141, 254, 1);
}
.toparea2 {
	flex-direction: column;
	display: flex;
	align-items: center;
	height: 908px;
	width: 100%;
	margin-top: 7px;
	background: rgba(255, 255, 255, 1);
}
.toparea1 {
	width: 100%;
	height: 71px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	display: flex;
	align-items: center;
}
.toparea1 > img {
	width: 121px;
	height: 49px;
	margin-left: 116px;
}
.toparea1 > div {
	margin-left: 908px;
}
.toparea1 > div > span:nth-of-type(1) {
	font-size: 13px;
	font-weight: 600;
	color: rgba(104, 104, 104, 1);
}
.toparea1 > div > span:nth-of-type(2) {
	font-size: 19.44px;
	font-weight: 600;
	color: rgba(192, 0, 0, 1);
}
</style>
