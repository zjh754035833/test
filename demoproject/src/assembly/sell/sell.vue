<template>
	<div>
		<div class="halfarea-1">
			<img src="../../../static/indexfill.png" class="box2 shou" @click="forindex()" />
			<div class="box3">
				<div>
					<span @click="forbuyshell" @mouseenter="mouall(1)" @mouseleave="leaveall(1)">BUY/SELL</span>
					<div class="dxian" v-if="blue1 == 1 || blue2 == 1"></div>
				</div>
				<!-- <div @mouseenter="mouAnction" @mouseleave="leaveAnction">
					<div @click="forAnction">
						<el-popover placement="top-start"  width="200" trigger="hover" content="coming soon......">
							<el-button slot="reference">ANCTION</el-button>
						</el-popover>
					</div>
					<div class="dxian" v-if="blue1 == 2 || blue2 == 2"></div>
					<div>
						<div class="anctionshow" :style="anctionstyle">
							<div style=""></div>
							<div :style="anction1" @mouseenter="forkuang1" @mouseleave="leavekuang1" @click="forpice">
								<div style="margin-left: 21px;z-index: 9999;">Place a bid</div>
							</div>
							<div class="xian5"></div>
							<div @mouseenter="forkuang2" @mouseleave="leavekuang2" :style="anction2" @click="forcreate"><div style="margin-left: 21px;">Creat an auction</div></div>
						</div>
					</div>
				</div> -->

				<div>
					<span @click="forMining" @mouseenter="mouall(4)" @mouseleave="leaveall(4)">MINING</span>
					<div class="dxian" v-if="blue1 == 4 || blue2 == 4"></div>
				</div>
				<div>
					<span @click="forSavings" @mouseenter="mouall(3)" @mouseleave="leaveall(3)">
						<el-badge value="coming soon......" class="item">SAVING</el-badge>
					</span>
					<!-- <div class="dxian" v-if="blue1 == 3 || blue2 == 3"></div> -->
				</div>
			</div>
			<v-wallet v-if="loginstate == '' || loginstate == null"></v-wallet>
			<div class="box5" v-if="(loginstate != '') & (loginstate != null)">
				<!-- <div  @mouseenter="forkuang" @mouseleave="leavekuang" class="shou" style="height: 100%;">
				<span>Wallet</span>
				<img src="../../../static/dx22.png" v-if="tankstyle == 'display:none'" />
				<img src="../../../static/dx11.png" v-if="tankstyle == 'display:block'" />
				<div class="waletshow" :style="tankstyle">
					<div>
						<span>BTC</span>
						<span>${{ btcval }}</span>
					</div>
					<div class="xian4"></div>
					<div>
						<span>AUD</span>
						<span>${{ audval }}</span>
					</div>
				</div>
				</div> -->
				<!-- <span style="margin-left: 20px;">Orders</span> -->
				<!-- <img src="../../../static/dx11.png" /> -->
				<div @click="formyaccount" class="" @mouseenter="forkuang3" @mouseleave="leavekuang3">
					<div class="shou dashboadr">dash board</div>
					
				</div>
				<span style="display: flex;margin-left: 30px;">
					<img src="../../../static/dowload44.png" style="width: 27px;height: 20px;" />
					<span class="yuanjiao">2</span>
				</span>
				<!-- 	<img src="../../../static/dowload33.png" style="width: 21px;height: 21px;margin-left: 20px;" />
				<div>
					<span>AUD</span>
					<img src="../../../static/dx2.png" style="margin-left: 2px;" />
				</div> -->
			</div>
	
		</div>
		<div class="waletshow2" :style="tankstyle3">
			<div><span>Vi***@163.com</span></div>
			<div>
				<img src="../../../static/ma1.png" />
				<span>Security</span>
			</div>
			<div>
				<img src="../../../static/ma2.png" style="width: 16px;height: 13px;" />
				<span>Identification</span>
			</div>
			<div>
				<img src="../../../static/ma3.png" style="width: 15px;height: 14px;" />
				<span>Referral</span>
			</div>
			<div>
				<img src="../../../static/ma4.png" style="width: 16px;height: 16px;" />
				<span>Log out</span>
			</div>
		</div>
	</div>
</template>

<script>
import wallet from '../wallet/wallet.vue';
import https from '../../https.js';
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
			loginstate: '',
			blue2: '',
			btcval: '',
			tankstyle3: 'display:none',
			audval: ''
		};
	},
	mounted() {
		this.blue1 = localStorage.getItem('clicksell');
		localStorage.removeItem('clicksell');
		this.loginstate = localStorage.getItem('token');
		if ((this.loginstate != '') & (this.loginstate != null)) {
			https
				.fetchGet('/account/walletInfo', '')
				.then(data => {
					window.console.log(data.data.detail);
					this.btcval = data.data.detail.mbtc;
					this.audval = data.data.detail.meth;
				})
				.catch(err => {
					window.console.log(err);
				});
		}
	},
	methods: {
		forcreate() {
			this.$router.push({ path: '/createauction' });
		},
		forpice() {
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
			/* 			this.$router.push({ path: '/newAnction' }); 暂不开放 */
		},
		forSavings() {
			/* this.$router.push({ path: '/Savings' }); 暂不开放 */
		},
		forMining() {
			this.$router.push({ path: '/Mining' });
		},
		forkuang() {
			this.tankstyle = 'display:block';
		},
		forkuang3() {
			this.tankstyle3 = 'display:block';
		},
		leavekuang3() {
			this.tankstyle3 = 'display:none';
		},
		leavekuang() {
			this.tankstyle = 'display:none';
		},
		formyaccount() {
			this.$router.push({ path: '/Myaccount' });
		},
		forkuang1() {
			this.anction1 = 'background:rgba(0,195,255,1);color:rgba(255, 255, 255, 1)';
		},
		leavekuang1() {
			this.anction1 = '';
		},
		forkuang2() {
			this.anction2 = 'background:rgba(0,195,255,1);color:rgba(255, 255, 255, 1)';
		},
		leavekuang2() {
			this.anction2 = '';
		},
		mouAnction() {
			/* 	this.blue2 = 2;  暂不开放
			this.anctionstyle = 'display:block'; */
		},
		mouall(e) {
			this.blue2 = e;
		},
		leaveall() {
			this.blue2 = '';
		},
		leaveAnction() {
			this.blue2 = '';
			this.anctionstyle = 'display:none';
		}
	}
};
</script>

<style scoped="scoped">
.dashboadr {
	height: 30px;
	display: flex;
	justify-content: center;
	align-items: center;
	background-color: rgba(41, 47, 136, 1);
	font-size: 14px;
	width: 100px;
	color: white;
	border-radius: 5px;
}
.dxian {
	width: 80px;
	height: 2px;
	background: rgba(0, 195, 255, 1);
	position: absolute;
	bottom: 0;
}
.blue {
}
.xian5 {
	width: 100%;
	height: 2px;
	background: rgba(255, 255, 255, 1);
	position: absolute;
	margin-top: 55px;
}
.xian4 {
	width: 175px;
	height: 2px;
	background-color: rgba(255, 255, 255, 1);
	position: absolute;
	margin-left: 10px;
	margin-top: 55px;
}
.anctionshow > div:nth-of-type(1) {
	height: 20px;
	width: 194px;
}
.anctionshow > div:nth-of-type(2) {
	display: flex;
	align-items: center;
	width: 194px;
	height: 55px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 5px 0px rgba(193, 208, 232, 1);
	font-size: 14px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
	position: absolute;
}
.anctionshow > div:nth-of-type(4) {
	display: flex;
	align-items: center;
	font-size: 14px;
	width: 100%;
	height: 55px;
	font-weight: 600;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 5px 0px rgba(193, 208, 232, 1);
	margin-top: 57px;
	color: rgba(51, 51, 51, 1);
	position: absolute;
}
.anctionshow {
	z-index: 999;
	font-size: 14px;
	width: 194px;
	height: 131px;
	position: absolute;
	margin-top: 3px;
	margin-left: -40px;
}
.waletshow > div:nth-of-type(1) {
	font-size: 14px;
	font-weight: 600;
	margin-top: 22px;
	color: rgba(102, 102, 102, 1);
	position: absolute;
}
.waletshow > div:nth-of-type(3) {
	font-size: 14px;
	font-weight: 600;
	margin-top: 71px;
	color: rgba(102, 102, 102, 1);
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
	width: 15%;
	height: 111px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 5px 0px rgba(193, 208, 232, 1);
	position: absolute;
	z-index: 999;
	margin-top: 80px;
}
.waletshow2 {
	margin-left: 940px;
	position: absolute;
	font-size: 14px;
	width: 194px;
	margin-top: -10px;
	height: 240px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 5px 0px rgba(193, 208, 232, 1);
	z-index: 999;
}
.waletshow2 > div {
	height: 48px;
	display: flex;
	align-items: center;
}
.waletshow2 > div > img {
	margin-left: 19px;
	width: 14px;
	height: 16px;
}
.waletshow2 > div > span {
	margin-left: 14px;
	font-size: 15px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.yuanjiao {
	width: 16px;
	height: 16px;
	background: rgba(255, 100, 100, 1);
	z-index: 10;
	text-align: center;
	color: rgba(255, 255, 255, 1);
	line-height: 16px;
	font-size: 10px;
	margin-top: -6px;
	margin-left: -5px;
	border-radius: 16px;
}
.box5 > div:nth-of-type(3) {
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
.box5 > div:nth-of-type(1) {
	font-size: 18px;
	display: flex;
	align-items: center;
	font-weight: 400;
	margin-left: 384px;
	color: rgba(102, 102, 102, 1);
}
.box5 > div:nth-of-type(1) > img {
	margin-left: 6px;
	width: 8px;
	height: 5px;
	cursor: pointer;
	color: rgba(255, 255, 255, 1);
}
.box5 > div:nth-of-type(3) > img {
	width: 8px;
	height: 5px;
}

.halfarea-1 {
	display: flex;
	align-items: center;
	width: 100%;
	height: 65px;
	background: rgba(255, 255, 255, 1);
}
.box5 {
	height: 65px;
	display: flex;
	align-items: center;
}
.box5 > div:nth-of-type(2) {
	height: 100%;
	margin-left: 30px;
	display: flex;
	align-items: center;
}
.box5 > div:nth-of-type(2) > div:nth-of-type(1) {
	width: 26px;
	display: flex;
	justify-content: center;
	color: rgba(102, 102, 102, 1);
	align-items: center;
	height: 26px;
	font-size: 14px;
	border: 2px solid rgba(102, 102, 102, 1);
	border-radius: 26px;
}
.box5 > span {
	cursor: pointer;
	font-size: 18px;
	color: rgba(102, 102, 102, 1);
}
.box5 > div:nth-of-type(1) > span {
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
	font-weight: bold;
	font-size: 16px;
	color: rgba(51, 51, 51, 1);
	margin-left: 50px;
}

.box3 > span {
	cursor: pointer;
}
.box3 > div {
	cursor: pointer;
	margin-left: 45px;
	display: flex;
	position: relative;
	justify-content: center;
	align-items: center;
	flex-direction: column;
	height: 65px;
	align-items: center;
}
.box2 {
	margin-left: 25px;
	width: 192px;
	height: 28px;
}
.box1 {
	margin-left: 18px;
	font-size: 34px;
	font-weight: 900;
	color: rgba(255, 255, 255, 1);
}
</style>
