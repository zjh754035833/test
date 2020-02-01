<template>
	<div>
		<el-dialog title="" :visible.sync="dialogTableVisible" width="60%" :before-close="handleClose">
			<div class="tanchu">
				<img src="../../../static/bluejiao.png" />
				<span>Set new password</span>
			</div>
			<div class="tanchu2"></div>
			<div class="tanchu3">
				<div class="tanchu3-1" style="margin-top: 89px;">
					<span>New Email :</span>
					<input />
				</div>
			
				<div class="tanchu3-3" style="margin-top: 67px;">
					<span>Confirm New Email :</span>
					<input />
				</div>
			</div>
			<div class="tanchu5">
				<div>Clear</div>
				<div>Confirm</div>
			</div>
		</el-dialog>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			dialogTableVisible: true
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
.tanchu5 {
	display: flex;
	width: 100%;
	justify-content: center;
	margin-top: 97px;
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
.tanchu3 {
	display: flex;
	justify-content: center;
	flex-direction: column;
	align-items: center;
}
.tanchu3 > div {
	display: flex;
	align-items: center;
	margin-top: 32px;
}
.tanchu3 > div > span {
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	position: absolute;
}
.tanchu3 > div > input {
	width: 249px;
	height: 38px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	margin-left: 180px;
	border: 1px solid rgba(218, 218, 218, 1);
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
