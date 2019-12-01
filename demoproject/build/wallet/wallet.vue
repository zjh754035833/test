<template>
	<div>
		<div class="halfarea-1">
			<span class="box1">AUWELS</span>
			<div class="box3">
				<span @click="forbuyshell">Buy/Sell</span>
				<span @click="forAnction">Anction</span>
				<span @click="forSavings">Savings</span>
				<span @click="forMining">Mining</span>
			</div>
			<img src="../../static/Fill.png" class="box2" />
			<div class="box5">
				<span @click="forkuang">Wallet</span>
				<img src="../../static/dx1.png" />
				<span @click="forkuang">Orders</span>
				<img src="../../static/dx2.png" />
				<span class="headimg"></span>
				<span>
					<img src="../../static/dowload4.png" style="height: 21px;width: 25px;" />
					<span class="yuanjiao">2</span>
				</span>
				<span><img src="../../static/dowload3.png" /></span>
				<span class="and">
					AUD
					<img src="../../static/dx2.png" style="width:8px;height:5px;margin-left:8px;" />
				</span>
			</div>
		</div>
		<div class="waletshow" :style="tankstyle">
			<div>
				<span>BTC</span>
				<span>$177,222,111,99</span>
			</div>
			<div class="xian4"></div>
			<div>
				<span>AUD</span>
				<span>A$998,020,00</span>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			tankstyle: 'display:none'
		};
	},
	methods: {
		forlogin() {
			this.$router.push({ path: '/login' });
		},
		forsign() {
			this.$router.push({ path: '/signup' });
		},
		forbuyshell() {
			this.$router.push({ path: '/sellbuy' });
		},
		forAnction() {
			this.$router.push({ path: '/newAnction' });
		},
		forSavings() {
			this.$router.push({ path: '/Savings' });
		},
		forMining() {
			this.$router.push({ path: '/Mining' });
		},
		forkuang() {
			if(this.tankstyle =='display:none'){
				this.tankstyle = 'display:block';
			}else{
				this.tankstyle = 'display:none';
			}
			
		}
	}
};
</script>

<style scoped="scoped">
.xian4 {
	width: 175px;
	height: 2px;
	background-color: #27557e;
	position: absolute;
	margin-left: 10px;
	margin-top: 51px;
}
.waletshow > div:nth-of-type(1) {
	font-size: 14px;
	font-weight: 600;
	margin-top: 22px;
	color: rgba(255, 255, 255, 1);
	position: absolute;
}
.waletshow > div:nth-of-type(3) {
	font-size: 14px;
	font-weight: 600;
	margin-top: 71px;
	color: rgba(255, 255, 255, 1);
	position: absolute;
}
.waletshow > div:nth-of-type(1) > span:nth-of-type(1) {
	position: absolute;
	margin-left: 13px;
}
.waletshow > div:nth-of-type(1) > span:nth-of-type(2) {
	position: absolute;
	margin-left: 58px;
}
.waletshow > div:nth-of-type(3) > span:nth-of-type(1) {
	position: absolute;
	margin-left: 13px;
}
.waletshow > div:nth-of-type(3) > span:nth-of-type(2) {
	position: absolute;
	margin-left: 58px;
}
.waletshow {
	width: 194px;
	height: 111px;
	background: rgba(10, 62, 105, 1);
	box-shadow: 0px 2px 5px 0px rgba(193, 208, 232, 1);
	position:absolute;
	margin-left: 981px;
	z-index: 999;
	margin-top: -10px;
}
.yuanjiao {
	width: 16px;
	height: 16px;
	background: rgba(255, 100, 100, 1);
	z-index: 10;
	position: absolute;
	text-align: center;
	line-height: 16px;
	font-size: 10px;
	margin-top: -5px;
	margin-left: -5px;
	border-radius: 16px;
}
.and {
	width: 76px;
	height: 29px;
	background: #507aa5;
	border-radius: 15px;
	font-size: 16px;
	text-align: center;
	line-height: 29px;
	display: flex;
	justify-content: center;
	align-items: center;
}
.headimg {
	width: 33px;
	height: 33px;
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 20px;
}
.halfarea-1 {
	width: 1440px;
	height: 65px;
	background: rgba(10, 62, 105, 1);
}
.box5 {
	margin-left: 950px;
	width: 490px;
	height: 65px;
	display: flex;
	align-items: center;
}
.box5 > span {
	margin-left: 22px;
	cursor: pointer;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
}
.box5 > span > img {
	cursor: pointer;
	width: 25px;
	height: 25px;
}
.box5 > img {
	margin-left: 6px;
	width: 8px;
	height: 5px;
	cursor: pointer;
	font-size: 18px;
	font-family: ArialMT;
	color: rgba(255, 255, 255, 1);
}

.box3 {
	position: absolute;
	margin-top: 24px;
	display: flex;
	font-size: 18px;
	font-weight: bold;
	color: rgba(255, 255, 255, 1);
}
.box3:nth-of-type(1) {
	margin-left: 380px;
}
.box3 > span {
	cursor: pointer;
	margin-left: 54px;
}
.box2 {
	position: absolute;
	margin-left: 134px;
	margin-top: 14px;
	width: 37px;
	height: 34px;
}
.box1 {
	position: absolute;
	margin-top: 9px;
	margin-left: 196px;
	font-size: 34px;
	font-weight: 900;
	color: rgba(255, 255, 255, 1);
}
</style>
