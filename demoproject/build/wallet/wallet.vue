<template>
	<div>
		<div class="halfarea-1">
			<img src="../../static/Fill.png" class="box2" />
			<span class="box1 shou" @click="forindex">AUWELS</span>
			<div class="box3">
				<span @click="forbuyshell" :class="[blue1 == 1 ? 'blue' : '']">Buy/Sell</span>
				<span @click="forAnction" :class="[blue1 == 2 ? 'blue' : '']">Anction</span>
				<span @click="forSavings" :class="[blue1 == 3 ? 'blue' : '']">Savings</span>
				<span @click="forMining" :class="[blue1 == 4 ? 'blue' : '']">Mining</span>
			</div>
			<div class="box5">
				<span @click="forkuang">Wallet</span>
				<img src="../../static/dx1.png" />
				<span @click="forkuang">Orders</span>
				<img src="../../static/dx2.png" />
				<div @click="formyaccount" class="shou"></div>
				<span>
					<img src="../../static/dowload4.png" />
					<span class="yuanjiao">2</span>
				</span>
				<span><img src="../../static/dowload3.png" /></span>
				<div>
					<span>AUD</span>
					<img src="../../static/dx2.png" style="" />
				</div>
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
	data() {
		return {
			blue1: '',
			tankstyle: 'display:none'
		};
	},
	mounted() {
		this.blue1 = localStorage.getItem('clicksell');
	},
	methods: {
		forindex() {
			this.$router.push({ path: '/' });
		},
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
			if (this.tankstyle == 'display:none') {
				this.tankstyle = 'display:block';
			} else {
				this.tankstyle = 'display:none';
			}
		},
		formyaccount() {
			this.$router.push({ path: '/Myaccount' });
		}
	}
};
</script>

<style scoped="scoped">
.blue {
	color: #00c3ff;
}
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
	position: absolute;
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
.box5 > div:nth-of-type(2) {
	width: 76px;
	height: 29px;
	margin-left: 30px;
	background-color: #507aa5;
	border-radius: 15px;
	font-size: 16px;
	color: rgba(255, 255, 255, 1);
	display: flex;
	justify-content: center;
	align-items: center;
}
.box5 > div:nth-of-type(2) > img {
	width: 8px;
	height: 5px;
}

.halfarea-1 {
	display: flex;
	align-items: center;
	width: 100%;
	height: 65px;
	background: rgba(10, 62, 105, 1);
}
.box5 {
	height: 65px;
	display: flex;
	align-items: center;
}
.box5 > div:nth-of-type(1) {
	width: 33px;
	height: 33px;
	border: 1px solid rgba(255, 255, 255, 1);
	border-radius: 20px;
	margin-left: 30px;
}
.box5 > span {
	cursor: pointer;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
}
.box5 > span:nth-of-type(1) {
	margin-left: 185px;
}
.box5 > span:nth-of-type(2) {
	margin-left: 22px;
}
.box5 > span:nth-of-type(3) {
	margin-left: 30px;
	width: 25px;
	height: 21px;
}
.box5 > span:nth-of-type(4) {
	width: 25px;
	height: 25px;
	margin-left: 30px;
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
	color: rgba(255, 255, 255, 1);
}

.box3 {
	display: flex;
	font-size: 16px;
	color: rgba(255, 255, 255, 1);
}

.box3 > span {
	cursor: pointer;
	margin-left: 45px;
}
.box2 {
	margin-left: 159px;
	width: 37px;
	height: 34px;
}
.box1 {
	margin-left: 18px;
	font-size: 34px;
	font-weight: 900;
	color: rgba(255, 255, 255, 1);
}
</style>
