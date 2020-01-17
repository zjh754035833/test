<template>
	<div>
		<el-dialog title="" :visible.sync="dialogTableVisible" width="60%" :before-close="handleClose" top="1%">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
				<span>Set up security questions</span>
			</div>
			<div  class="tanchu1">
				<div class="tanchu1-1"> 
					<div style="margin-top: 0px;">
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
				<div class="tanchu1-2">
					<div>NOTE:</div>
					<div>Security verification questions are important basis for recovering your account. Once set up, the answer cannot be modified and the corresponding answer is no longer displayed anywhere.We recommend that you:
*Choose more hidden questions
<br>
*Don't forget the answer to the questions
<br>
*Keeping any questions answer in any written form poses a certain security risk
<br>
*Don't provide anyone security questions and answers about   your account</div>
				</div>
			</div>
			<div class="tanchu" style="margin-top: 24px;">
				<img src="../../../static/bluejiao.png" />
				<span>Account Status</span>
			</div>
			<div class="tanchu4"></div>
			<div  class="tanchu3">
				<div>
					<li>
						<span>Google 2FA Enable:</span>
						<span>No</span>
					</li>
					<li>
						<span>SMS  Enable:</span>
						<span>No</span>
					</li>
					<li>
						<span> Account Verify:</span>
						<span>No</span>
					</li>		
				</div>
				
			<div class="tanchu5">
				<span>Completing the above security settings can effectively protect your account security. It is recommended that you enable the above security settings in the user center as soon as possible after completing setting the security questions.
</span>
			</div>
			<div class="tanchu6">Confirm</div>
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
			if(this.dialogTableVisible==true){
				done();
			}
		}
	}
};
</script>

<style scoped="scoped">
	.tanchu6{
		width:278px;
		height:46px;
		font-size:16px;
		text-align: center;
		line-height: 46px;
		margin-top: 17px;
		color:rgba(255,255,255,1);
		background:rgba(0,195,255,1);
		border-radius:1px;
	}
	.tanchu5>span{
		font-size:13px;
		line-height:25px;
		font-weight:400;
		margin-left: 10px;
		margin-right: 10px;
		color:rgba(102,102,102,1);
	}
	.tanchu5{
		display: flex;
		justify-content: center;
		align-items: center;
			width: 100%;
		height:82px;
		background:rgba(246,246,246,1);
		margin-top: 15px;
		border-radius:2px;
	}
	.tanchu3>div:nth-of-type(1){
		width: 100%;
		display: flex;
		justify-content: space-between;
	}
	.tanchu3>div>li>span:nth-of-type(1){
	font-size:16px;
	font-weight:400;
	color:rgba(102,102,102,1);
	}
	.tanchu3>div>li>span:nth-of-type(2){
	font-size:16px;
	font-weight:400;
	color:rgba(0, 195, 255, 1);
	}
	.tanchu4{
		width:100%%;
		height:0.5px;
		opacity: 0.5;
		background:rgba(209, 216, 245, 0.6);
		margin-top: 9px;
		}
	.tanchu3{
		display: flex;
		flex-direction: column;
		align-items: center;
		width: 100%;
		margin-top: 20px;
	}
	.tanchu1-2{
		width:432px;
		height:320px;
		background:rgba(246,246,246,1);
		border-radius:2px;
		margin-left: 16px;
		display: flex;
		justify-content: center;
		flex-direction: column;
	}
	.tanchu1-2>div:nth-of-type(1){
		font-size:16px;
		font-weight:bold;
		color:rgba(51,51,51,1);
		margin-left: 16px;
	}
	.tanchu1-2>div:nth-of-type(2){
		width:406px;
		height:258px;
		font-size:14px;
		font-weight:400;
		color:rgba(102,102,102,1);
		margin-left: 16px;
		line-height:25px;
	}
	.tanchu1-1>div{
		margin-top: 16px;
		display: flex;
		align-items: center;
	}
	.input2{
		margin-left: 100px;
		width:227px;
		height:38px;
		background:rgba(255,255,255,1);
		border-radius:1px;
		border:1px solid rgba(218,218,218,1);
	}
	.xiala2{
		margin-left: 100px;
		width:227px;
		height:38px;
		background:rgba(255,255,255,1);
		border-radius:1px;
	}
	.tanchu1{
		margin-top: 38px;
		display: flex;
		
	}
.tanchu1-1{
	margin-left: 15px;
	}
	.tanchu1-1>div>span{
		font-size:16px;
		font-weight:400;
		color:rgba(102,102,102,1);
		position: absolute;
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
