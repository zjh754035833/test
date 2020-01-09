<template>
	<div>
		<v-head></v-head>
		<el-dialog title="" :visible.sync="dixdiag1" width="60%" top="0" >
			<div class="diagsub1">Payment</div>
			<div class="diagsub2"></div>
			<div class="diagsub3">
				<div class="diagsub3-1">You’re about to pay for 1 order</div>
				<div class="diagsub3-2">
					<span>Cost </span>
					<span>$29.9</span>
				</div>
			</div>
			<div class="diagsub4">Choose Payment Method</div>
			<div style="margin-top: 25px;">
				<el-radio-group v-model="radio" class="diagsub5">
					<el-radio :label="1" class="diagsub5"><div class="zhifu1"><img src="../../static/bit3.png" /><span>Bank Card</span></div></el-radio>

					<el-radio :label="2" class="diagsub5"><div class="zhifu2"><img src="../../static/bit2.png" /></div>
					</el-radio>
				</el-radio-group>
			</div>
			<div class="diagsub6 shou" @click="forpay()">Confirm</div>
			<div style="height: 41px;"></div>
		</el-dialog>
		<el-dialog title="" :visible.sync="dixdiag2" width="60%" top="0" >
			<div class="diagsub1">Payment details</div>
			<div class="diagsub2"></div>
			<div class="diagpay3">
				<div class="diagpay3-1">
					<div style="margin-left: 23px;">
					<div class="diagpay3-1-1">Name</div>
					<div class="diagpay3-1-2">
						<input placeholder="Full name on the card" />
					</div>
					<div class="diagpay3-1-3">Card number</div>
					<div class="diagpay3-1-4">
						<input placeholder="XXXX  XXXX   XXXX  XXXX" />
						<img src="../../static/bit4.png" />
					</div>
					<div class="diagpay3-1-5">
						<span>Expiry date </span><span style="margin-left: 81px;">CVC </span>
					</div>
					<div class="diagpay3-1-6"><input placeholder="MM/YY"><input placeholder="XXX" style="margin-left: 12px;"></div>
				</div>
				</div>
				<div class="diagpay3-2">
					<div class="diagpay3-2-1">Order summary</div>
					<div class="diagpay3-2-2"></div>
					<div class="diagpay3-2-3"><span style="margin-left: 17px;">Postage</span><span style="margin-right: 17px;">$20.00</span></div>
					<div class="diagpay3-2-3"><span style="margin-left: 17px;">Included GST</span><span style="margin-right: 17px;">$1.72</span></div>
					<div class="diagpay3-2-4">
						<span style="margin-left: 17px;">Total</span> <span style="margin-right: 17px;">$20.00</span>
					</div>
				</div>
			</div>
			<div class="diagpay3-3 shou">Pay now</div>
		</el-dialog>
		<div class="sub1">
			<div class="sub1-1">BI-WEEKLY NEWSLETTER FOR ACCOUNTANTS</div>
			<div class="sub1-2">IN THE CRYPTOCURRENCY INDUSTRY</div>
			<div class="sub1-3">Keep a pulse on the industrylearn through webinars,ask questions to other</div>
			<div class="sub1-4">readers and become an expert in accounting for this new asset class.</div>
			<div class="sub1-5">
				<div class="sub1-5-1">
					<span>$29.9</span>
					<span>per year</span>
				</div>
				<div class="sub1-5-2">Association consultation is given priority News will be pushed twice a week</div>
				<div class="sub1-5-3 shou" @click="forsub">Subscribe</div>
			</div>
		</div>
		<v-foot></v-foot>
	</div>
</template>

<script>
import head from '../assembly/head/head.vue';
import foot from '../assembly/foot/foot.vue';
export default {
	components: {
		'v-head': head,
		'v-foot': foot
	},
	data() {
		return {
			dixdiag1: false,
			dixdiag2:false,
			radio: 1
		};
	},
	computed: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		forsub(){
			this.dixdiag1=true
		},
		forpay(){
			this.dixdiag2=true
		}
	},
	created() {}
};
</script>

<style scoped="scoped">
	.diagpay3-3{
		float: right;
		width:127px;
		height:48px;
		background:rgba(38,0,120,1);
		margin-top: 35px;
		text-align: center;
		line-height: 48px;
		font-size:19px;
		color:rgba(255,255,255,1);
		margin-bottom: 30px;
	}
	.diagpay3-2-4{
		display: flex;
		justify-content: space-between;
		font-size:23px;
		margin-top: 106px;
		font-weight:600;
		color:rgba(41,47,136,1);
	}
	.diagpay3-2-3{
		margin-top: 30px;
		display: flex;
		justify-content: space-between;
		font-size:15px;
		font-weight:400;
		color:rgba(102,102,102,1);
		}
	.diagpay3-2-2{
		width:309px;
		height:1px;
		background-color: rgba(0, 0, 0, 0.17);
		opacity: 0.5;
		margin-top: 10px;
		margin-left: 20px;
	}
	.diagpay3-2-1{
		font-size:18px;
		font-weight:400;
		color:rgba(51,51,51,1);
		margin-top: 20px;
		margin-left: 17px;
		}
	.diagpay3-1-6>input{
		width:127px;
		height:41px;
		font-size:12px;
		padding-left: 20px;
		background:rgba(255,255,255,1);
		border-radius:1px;
		border:1px solid rgba(238,238,238,1);
	}
	.diagpay3-1-6{
		margin-top: 12px;
	}
	.diagpay3-1-5{
		display: flex;
		font-size:18px;
		margin-top: 23px;
		font-weight:400;
		color:rgba(51,51,51,1);
	}
	.diagpay3-1-4>input{
		width:210px;
		height:41px;
		font-size:12px;
		padding-left: 20px;
		background:rgba(255,255,255,1);
		border-radius:1px;
		border:1px solid rgba(238,238,238,1);
	}
	.diagpay3-1-4>img{
		width: 47px;
		height: 30px;
	}
	.diagpay3-1-4{
		margin-top: 20px;
		display: flex;
		align-items: center;
		}
	.diagpay3-1-3{
		margin-top: 19px;
		font-size:18px;
		font-weight:400;
		color:rgba(51,51,51,1);
		}
	.diagpay3-1-2>input{
		width:286px;
		height:41px;
		padding-left: 20px;
		font-size:12px;
		margin-top: 12px;
		background:rgba(255,255,255,1);
		border-radius:1px;
		border:1px solid rgba(238,238,238,1);
	}
	.diagpay3-1-1{
		margin-top: 10px;
		font-size:18px;
		font-weight:400;
		color:rgba(51,51,51,1);
		}
	.diagpay3-1{
		width:408px;
		height:311px;
		background:RGBA(248, 248, 248, 1);
		border-radius:2px;
	}
	.diagpay3-2{
		width:349px;
		height:311px;
		background:RGBA(248, 248, 248, 1);
		border-radius:2px;
		margin-left: 10px;
	}
	.diagpay3{
		display: flex;
		justify-content: center;
		margin-top: 13px;
	}
	.diagsub3-2{
		float: right;
		margin-top: 43px;
		margin-right: 26px;
	}
	.diagsub3-2>span:nth-of-type(1){
		font-size:23px;
		font-weight:600;
		color:rgba(102,102,102,1);
	}
	.diagsub3-2>span:nth-of-type(2){
	font-size:31px;
	font-weight:bold;
	color:rgba(41,47,136,1);
	margin-left: 20px;
	}
	.diagsub3-1{
		font-size:15px;
		font-weight:400;
		color:rgba(102,102,102,1);
		margin-top: 18px;
		position: absolute;
		margin-left: 17px;
	}
	.diagsub6{
		width:127px;
		height:48px;
		background:rgba(38,0,120,1);
		float: right;
		margin-right: 42px;
		color:rgba(255,255,255,1);
		text-align: center;
		line-height: 48px;
		}
	.zhifu1>img{
		width: 39px;
		height: 26px;
	}
	.zhifu1>span{
		font-size:18px;
		font-weight:400;
		margin-left: 5px;
		color:rgba(50,56,141,1);
	}
.diagsub5 {
	display: flex;
	align-items: center;
}
.zhifu1 {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 163px;
	height: 60px;
	background: rgba(255, 255, 255, 0);
	box-shadow: 0px 2px 7px 0px rgba(41, 47, 136, 0.16);
	border-radius: 4px;
	border: 1px solid rgba(38, 0, 120, 0.05);
}
.zhifu2 {
	display: flex;
	justify-content: center;
	align-items: center;
	width: 163px;
	height: 60px;
	background: rgba(255, 255, 255, 0);
	box-shadow: 0px 2px 7px 0px rgba(41, 47, 136, 0.16);
	border-radius: 4px;
	border: 1px solid rgba(38, 0, 120, 0.05);
}
.zhifu2 > img {
	width: 98px;
	height: 37px;
}
.diagsub4 {
	font-size: 18px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
	margin-top: 24px;
}
.diagsub3 {
	width: 100%;
	height: 99px;
	background: RGBA(248, 248, 248, 1);
	border-radius: 2px;
}
.diagsub2 {
	width: 100%;
	margin-top: 13px;
	height: 1px;
	background: rgba(0, 0, 0, 0.17);
	opacity: 0.5;
}
.diagsub1 {
	font-size: 20px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
}
/deep/ .el-dialog__header {
	padding: 0;
}

/deep/.el-dialog__wrapper {
	display: flex;
	align-items: center;
	width: 100%;
	height: 100%;
	position: fixed;
	top: 0;
	right: 0;
	bottom: 0;
	left: 0;
	overflow: auto;
	margin: 0;
}
/deep/.el-dialog {
	margin: 0 auto;
}
.sub1-5-1 > span:nth-of-type(1) {
	font-size: 50px;
	font-weight: bold;
	color: rgba(41, 47, 136, 1);
}
.sub1-5-1 > span:nth-of-type(2) {
	font-size: 30px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
}
.sub1-5-1 {
	margin-top: 33px;
	margin-left: 56px;
}
.sub1-5-2 {
	margin-top: 15px;
	margin-left: 54px;
	margin-top: 15px;
	font-size: 18px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	line-height: 26px;
}
.sub1-5-3 {
	width: 127px;
	height: 48px;
	background: rgba(38, 0, 120, 1);
	line-height: 48px;
	margin-left: 54px;
	margin-top: 40px;
	text-align: center;
	font-size: 19px;
	font-weight: 400;
	color: rgba(255, 255, 255, 1);
}
.sub1-5 {
	width: 553px;
	height: 270px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(130, 130, 130, 0.27);
	border-radius: 2px;
	margin-top: 60px;
}
.sub1-3 {
	font-size: 20px;
	color: rgba(255, 255, 255, 1);
	opacity: 0.5;
	margin-top: 20px;
}
.sub1-4 {
	font-size: 20px;
	color: rgba(255, 255, 255, 1);
	opacity: 0.5;
}
.sub1-1 {
	font-size: 46px;
	color: rgba(255, 255, 255, 1);
	margin-top: 71px;
}
.sub1-2 {
	font-size: 46px;
	color: rgba(255, 255, 255, 1);
}
.sub1 {
	width: 100%;
	height: 690px;
	background: url(../../static/sub1.png);
	background-size: 100%;
	display: flex;
	flex-direction: column;
	align-items: center;
}
</style>
