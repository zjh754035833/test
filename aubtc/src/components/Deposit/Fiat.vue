<template>
	<div>
		<div class="Fiatall">
			<div class="Fiatall-1">
				<div class="Fiatall-1-1">
					<span>Wallet</span>
					<span>/Fiat Deposit</span>
				</div>
				<div class="Fiatall-xian"></div>
				<div class="Fiatall-1-2">
					<div class="Fiatall-1-2-all">
						<div>
							<span class="Fiatall-1-2-1">Deposit Amount</span>
							<input class="Fiatall-1-2-2" />
						</div>
						<div style="margin-top: 22px;">
							<span class="Fiatall-1-2-3">Crad Type</span>
							<el-select v-model="value" placeholder="Debit Card" class="Fiatall-1-2-4">
								<el-option v-for="item in cities" :key="item.value" :label="item.label" :value="item.value">
									<span style="float: left">{{ item.label }}</span>
									<span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>
								</el-option>
							</el-select>
						</div>
						<div style="display: flex;">
							<div class="Fiatall-1-2-5">
								<div>Enter card Information registerd with Bank</div>
								<input placeholder="Card Hold Name" />
								<input placeholder="Card Name" />
								<div class="Fiatall-1-2-5-1">
									<input placeholder="Expiration date" />
									<input placeholder="CSC" />
								</div>
							</div>
							<div class="Fiatall-1-2-6">
								<div >Billing Address</div>
								<input placeholder="Street Address" />
								<div class="Fiatall-1-2-6-1">
									<input placeholder="City/town"/>
									<el-select v-model="value" placeholder="Debit Card" class="Fiatall-1-2-6-2">
										<el-option v-for="item in cities" :key="item.value" :label="item.label" :value="item.value">
											<span style="float: left">{{ item.label }}</span>
											<span style="float: right; color: #8492a6; font-size: 13px">{{ item.value }}</span>
										</el-option>
									</el-select>
								</div>
								<input placeholder="Post Code" />
							</div>
						</div>
						<div class="Fiatall-1-3">
							<div>Cancel</div>
							<div>Confirm</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	components: {
	},
	data() {
		return {
			cities: []
		};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {}
};
</script>

<style scoped="scoped">
	.Fiatall-1-3{
		display: flex;
		justify-content: center;
		margin-top: 50px;
	}
	.Fiatall-1-3>div:nth-of-type(1){
		width:278px;
		height:46px;
		border-radius:1px;
		border:1px solid rgba(0,195,255,1);
		font-size:18px;
		text-align: center;
		color:rgba(0,195,255,1);
		line-height:46px;
	}
	.Fiatall-1-3>div:nth-of-type(2){
	width:278px;
	height:46px;
	background:rgba(0,195,255,1);
	border:1px solid rgba(0,195,255,1);
	font-size:18px;
	color:rgba(255,255,255,1);
	line-height:46px;
	text-align: center;
	margin-left: 30px;
	border-radius:1px;
	}
	.Fiatall-1-2-6-2{
		width:147px;
		height:42px;
		background:rgba(255,255,255,1);
		border-radius:1px;
	}
	.Fiatall-1-2-6-1{
		display: flex;
		justify-content: space-between;
		align-items: center;
		margin-top: 25px;
	}
	.Fiatall-1-2-6-1>input:nth-of-type(1){
		width:127px;
		height:40px;
		background:rgba(255,255,255,1);
		border-radius:1px;
		padding-left: 38px;
		border:1px solid rgba(218,218,218,1);
	}
	.Fiatall-1-2-6>input:nth-of-type(1){
		width:309px;
		height:40px;
		background:rgba(255,255,255,1);
		padding-left: 20px;
		border-radius:1px;
		border:1px solid rgba(218,218,218,1);
		margin-top: 28px;
	}
	.Fiatall-1-2-6>input:nth-of-type(2){
		width:127px;
		padding-left:38px;
		height:40px;
		background:rgba(255,255,255,1);
		border-radius:1px;
		margin-top: 35px;
		border:1px solid rgba(218,218,218,1);
	}
	.Fiatall-1-2-6>div:nth-of-type(1){
		font-size:17px;
		font-weight:400;
		margin-top: 35px;
		color:rgba(51,51,51,1);
	}
.Fiatall-1-2-5-1 > input {
	width: 138px;
	height: 40px;
	background: rgba(255, 255, 255, 1);
	padding-left: 20px;
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.Fiatall-1-2-5-1 {
	width: 329px;
	display: flex;
	justify-content: space-between;
}
.Fiatall-1-2-5 > div {
	font-size: 17px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
	margin-top: 35px;
}
.Fiatall-1-2-5 > input {
	width: 309px;
	height: 40px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
	margin-top: 27px;
	padding-left: 20px;
}
.Fiatall-1-2-5 {
	display: flex;
	flex-direction: column;
}
.Fiatall-1-2-6 {
	display: flex;
	flex-direction: column;
	margin-left: 151px;
}
.Fiatall-1-2-3 {
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.Fiatall-1-2-4 {
	width: 147px;
	height: 40px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	margin-left: 73px;
}
.Fiatall-1-2-1 {
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.Fiatall-1-2-2 {
	width: 152px;
	height: 40px;
	margin-left: 22px;
	padding-left: 37px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(218, 218, 218, 1);
}
.Fiatall-1-2-all {
	display: flex;
	justify-content: center;
	margin-left: 44px;
	flex-direction: column;
	margin-top: 30px;
	position: absolute;
}
.Fiatall-xian {
	width: 1177px;
	height: 1px;
	background: rgba(238, 238, 238, 1);
	margin-left: 32px;
	margin-top: 16px;
}
.Fiatall-1-2 {
	width: 1013px;
	height: 554px;
	background: RGBA(250, 250, 250, 1);
	border-radius: 2px;
	margin-left: 114px;
	margin-top: 25px;
}
.Fiatall-1-1 {
	display: flex;
	align-items: center;
	margin-top: 22px;
	margin-left: 32px;
}
.Fiatall-1-1 > span:nth-of-type(1) {
	font-size: 19px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
}
.Fiatall-1-1 > span:nth-of-type(2) {
	font-size: 19px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
}
.Fiatall {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 17px;
	margin-bottom: 60px;
}
.Fiatall-1 {
	width: 1241px;
	height: 759px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
}
</style>
