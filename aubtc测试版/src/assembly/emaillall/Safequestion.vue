<template>
	<div>
		<el-dialog title="" :visible.sync="dialogTableVisible" width="60%" :before-close="handleClose">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
				<span>Set new password</span>
			</div>
			<div class="tanchu2"></div>
			<div class="tanchu3">
				<div>
					<span>Question 1</span>
					<el-select v-model="form1.value1" clearable placeholder="Month" class="xiala2">
						<el-option v-for="item in options1" :key="item.value" :label="item.label" :value="item.value"></el-option>
					</el-select>
				</div>
				<div>
					<span>Answer :</span>
					<input class="input2" />
				</div>
				<div>
					<span>Question 1</span>
					<el-select v-model="form1.value2" clearable placeholder="Month" class="xiala2">
						<el-option v-for="item in options2" :key="item.value" :label="item.label" :value="item.value"></el-option>
					</el-select>
				</div>
				<div>
					<span>Answer :</span>
					<input class="input2" />
				</div>
				<div>
					<span>Question 1</span>
					<el-select v-model="form1.value3" clearable placeholder="Month" class="xiala2">
						<el-option v-for="item in options3" :key="item.value" :label="item.label" :value="item.value"></el-option>
					</el-select>
				</div>
				<div>
					<span>Answer :</span>
					<input class="input2" />
				</div>
			</div>
			<div class="tanchu5">
				<div class="shou">Clear</div>
				<div class="shou">Confirm</div>
			</div>
		</el-dialog>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			dialogTableVisible: true,
			form1: {
				value1: 'My puppy name？',
				value2: 'My hometown？',
				value3: 'My name?',
				},
				options1: [
					{
						value: '1',
						label: '1.'
					},
					{
						value: '2',
						label: '2'
					},
					{
						value: '3',
						label: '3'
					}
				],
				options2: [
					{
						value: '1',
						label: '1.'
					},
					{
						value: '2',
						label: '2'
					},
					{
						value: '3',
						label: '3'
					}
				],
				options3: [
					{
						value: '1',
						label: '1.'
					},
					{
						value: '2',
						label: '2'
					},
					{
						value: '3',
						label: '3'
					}
				]
		};
	},
	created() {},
	mounted() {},
	methods: {
		handleClose(done) {
			if (this.dialogTableVisible == true) {
				done();
			}
		}
	}
};
</script>

<style scoped="scoped">
.xiala2 {
	width: 227px;
	height: 38px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	margin-left: 100px;
}
.input2 {
	width: 225px;
	margin-left: 100px;
	height: 36px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.tanchu3 > div > span {
	width: 91px;
	position: absolute;
	height: 23px;
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.tanchu3 > div {
	display: flex;
	flex-direction: column;
	margin-top: 16px;
	justify-content: center;
}
.tanchu3 {
	width: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
}
.tanchu5 {
	display: flex;
	width: 100%;
	justify-content: center;
	margin-top: 60px;
}
.tanchu5 > div:nth-of-type(1) {
	width: 278px;
	height: 46px;
	border-radius: 1px;
	border: 1px solid rgba(0, 195, 255, 1);
	font-size: 18px;
	color: rgba(0, 195, 255, 1);
	line-height: 46px;
	text-align: center;
}
.tanchu5 > div:nth-of-type(2) {
	width: 278px;
	height: 46px;
	background: rgba(0, 195, 255, 1);
	border-radius: 1px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
	line-height: 46px;
	text-align: center;
	margin-left: 30px;
}

.tanchu > img {
	width: 5px;
	height: 15px;
	background: rgba(0, 195, 255, 1);
	border-radius: 2px;
}
.tanchu > span {
	font-size: 17px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
	margin-left: 11px;
}
.tanchu2 {
	width: 100%;
	height: 1px;
	margin-top: 12px;
	background: rgba(209, 216, 245, 0.6);
}
</style>
