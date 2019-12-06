<template>
	<div>
		<div class="halfarea-1">
			<img src="../../../static/Fill.png" class="box2" />
			<span class="box1 shou" @click="forindex" >AUWELS</span>
			<div class="box3">
				<span @click="forbuyshell" :class="[blue1 == 1 || blue2 == 1? 'blue' : '']" @mouseenter="mouall(1)" @mouseleave="leaveall(1)">Buy/Sell</span>
				<div  @mouseenter="mouAnction" @mouseleave="leaveAnction">
				<div @click="forAnction" :class="[blue1 == 2 || blue2 == 2 ? 'blue' : '']">Anction</div>
					<div class="anctionshow" :style="anctionstyle"  >
						<div style=""></div>
						<div :style="anction1" @mouseenter="forkuang1" @mouseleave="leavekuang1" @click="forpice"><div style="margin-left: 21px;z-index: 9999;" >Place a bid</div></div>
						<div class="xian5"></div>
						<div @mouseenter="forkuang2" @mouseleave="leavekuang2" :style="anction2" @click="forcreate"><div style="margin-left: 21px;" >Creat an auction</div></div>
					</div>
					</div>
				<span @click="forSavings" :class="[blue1 == 3 || blue2 == 3 ? 'blue' : '']" @mouseenter="mouall(3)" @mouseleave="leaveall(3)">Savings</span>
				<span @click="forMining" :class="[blue1 == 4 || blue2 == 4 ? 'blue' : '']" @mouseenter="mouall(4)" @mouseleave="leaveall(4)">Mining</span>
			</div>
			<v-wallet v-if="loginstate!=1"></v-wallet>
			<div class="box5"  v-if="loginstate==1">
				<span @mouseenter="forkuang" @mouseleave="leavekuang">Wallet</span>
				<img src="../../../static/dx1.png" v-if="tankstyle == 'display:none'"/>
				<img src="../../../static/dx2.png"  v-if="tankstyle == 'display:block'" />
				<span>Orders</span>
				<img src="../../../static/dx2.png" />
				<div @click="formyaccount" class="shou"></div>
				<span>
					<img src="../../../static/dowload4.png" />
					<span class="yuanjiao">2</span>
				</span>
				<span><img src="../../../static/dowload3.png" /></span>
				<div>
					<span>AUD</span>
					<img src="../../../static/dx2.png" style="margin-left: 2px;" />
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
	import wallet from '../wallet/wallet.vue';
export default {
	components: {
		'v-wallet': wallet
	},
	data() {
		return {
			blue1: '',
			tankstyle: 'display:none',
			anctionstyle: 'display:none',
			anction1: '',
			anction2: '',
			loginstate:'',
			blue2:''
		};
	},
	mounted() {
		this.blue1 = localStorage.getItem('clicksell');
		localStorage.removeItem('clicksell')
				this.loginstate=localStorage.getItem('loginstate');
	},
	methods: {
		forcreate(){
			this.$router.push({ path: '/createauction' });
		},
		forpice(){
			this.$router.push({ path: '/place' });
		},
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
			this.tankstyle = 'display:block';
		},
		leavekuang() {
			this.tankstyle = 'display:none';
		},
		formyaccount() {
			this.$router.push({ path: '/Myaccount' });
		},
		forkuang1() {
			this.anction1 = 'background:rgba(0,195,255,1);';
		},
		leavekuang1() {
			this.anction1 = '';
		},
		forkuang2() {
			this.anction2 = 'background:rgba(0,195,255,1);';
		},
		leavekuang2() {
			this.anction2 = '';
		},
		mouAnction(){
			this.blue2=2;
			this.anctionstyle = 'display:block';
		},
		mouall(e){
			this.blue2=e;
		},
		leaveall(){
			this.blue2="";
		},
		leaveAnction(){
			this.blue2="";
			this.anctionstyle = 'display:none';
		}
	}
};
</script>

<style scoped="scoped">
.blue {
	color: #00c3ff;
}
.xian5{
		width: 100%;
	height: 2px;
	background: rgba(10, 62, 105, 1);
	position: absolute;
	margin-top: 55px;
}
.xian4 {
	width: 175px;
	height: 2px;
	background-color: #27557e;
	position: absolute;
	margin-left: 10px;
	margin-top: 55px;
}
.anctionshow > div:nth-of-type(1) {
	height: 20px;
	width: 100%;
}
.anctionshow > div:nth-of-type(2) {
	display: flex;
	align-items: center;
	width: 100%;
	height: 55px;
	background: rgba(10, 62, 105, 1);
	box-shadow: 0px 2px 5px 0px rgba(193, 208, 232, 1);
	font-size: 14px;
	font-weight: 600;
	color: rgba(255, 255, 255, 1);
	position: absolute;
}
.anctionshow > div:nth-of-type(4) {
	display: flex;
	align-items: center;
	font-size: 14px;
	width: 100%;
	height: 55px;
	font-weight: 600;
	background: rgba(10, 62, 105, 1);
	box-shadow: 0px 2px 5px 0px rgba(193, 208, 232, 1);
	margin-top: 57px;
	color: rgba(255, 255, 255, 1);
	position: absolute;
}
.anctionshow {
	z-index: 999;
	font-size: 14px;
	width: 15%;
	height: 131px;
	position: absolute;
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
	font-size: 14px;
	width: 18%;
	height: 111px;
	background: rgba(10, 62, 105, 1);
	box-shadow: 0px 2px 5px 0px rgba(193, 208, 232, 1);
	position: absolute;
	margin-left: 951px;
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
	font-weight:bold ;
	font-size: 16px;
	color: rgba(255, 255, 255, 1);
}

.box3 > span {
	cursor: pointer;
	margin-left: 45px;
}
.box3 > div {
	cursor: pointer;
	margin-left: 45px;
	
}
.box2 {
	margin-left: 126px;
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
