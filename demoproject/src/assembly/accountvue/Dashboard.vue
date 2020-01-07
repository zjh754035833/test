<template>
	<div>
		<div v-if="checktype == true"><v-checksg @func="getchecktype"></v-checksg></div>
		<div class="dashboard2">
			<div class="dashboard2-1">
				<div>My Account</div>
				<div>Deposit</div>
				<div>Withdraw</div>
			</div>
			<div class="dashboard2-2"></div>
			<div class="dashboard2-3">
				<div>
					<span class="dashboard2-3-1">Crypto Estimate</span>
					<span class="dashboard2-3-2">
						221,289,11
						<span class="dashboard2-3-3">BTC</span>
					</span>
				</div>
				<div>
					<span class="dashboard2-3-1">Fiat</span>
					<span class="dashboard2-3-2">
						99,111,11
						<span class="dashboard2-3-3">AUD</span>
					</span>
				</div>
			</div>
		</div>
		<div class="dashboardx-2">
			<div class="dashboardx-1-1"><span>Login history</span></div>
			<div class="dashboardx-1-2-xian" ></div>
			<div style="margin-top: 10px;"></div>
			<div class="dashboardx-2-1" v-for="(item, index) in Loginhistory" :key="index">
				<span>IP:47.888.999</span>
				<span>2019-12-19 11:45:27</span>
			</div>
		</div>
	
		<div class="dashboardx-1">
			<div class="dashboardx-1-1"><span>Announcements</span></div>
			<div class="dashboardx-1-2" v-for="(gtem, index) in Announcementslist" :key="index">
				<div class="dashboardx-1-2-xian" style="width: 940px;"></div>
				<div class="dashboardx-1-2-1">Binance Will Support Kava (KAVA) Staking and Launch a 30,000 KAVA Initia Staking Reward Airdrop</div>
				<div class="dashboardx-1-2-2"><div style="float: right;">2019-12-18</div></div>
			</div>
		</div>
			<div class="dashboard3">
				<div>
					<span>Increase your account security</span>
					<span>0</span>
					<span>/4</span>
				</div>
				<div class="dashboard3-1"></div>
				<div class="dashboard3-2">
					<li v-for="(item, index) in securitylist" :key="index">
						<span>{{ item.name }}</span>
						<span @click="forchecksg(item.id)">{{ item.value }}</span>
					</li>
				</div>
			</div>
			
			<div class="dashboardx-3">
				<div class="dashboardx-1-1"><span>Operation record</span></div>
				<div class="dashboardx-1-2-xian"></div>
				<div style="margin-top: 10px;"></div>
				<div class="dashboardx-2-1" v-for="(item, index) in Operationlist" :key="index">
					<span>{{ item.name }}</span>
					<span>{{ item.date }}</span>
				</div>
			</div>
		<!-- 		<div class="dashboard4">
			<div>Transaction History</div>
			<div>
				<div class="dashboard4-1">
					<span>Buy</span>
					<span>Amount</span>
					<span>Status</span>
					<span>Price</span>
					<span>Date</span>
				</div>
			</div>
			<div class="infinite-list-wrapper">
				<div class="dashboard4-2" v-for="(gtem, index) in historylist" :key="index">
					<div>{{ gtem.buy }}</div>
					<div>{{ gtem.Amount }}</div>
					<div>{{ gtem.Status }}</div>
					<div>{{ gtem.Price }}</div>
					<div>{{ gtem.Date }}</div>
					<div class="dashboard4-3"></div>
				</div>
			</div>
		</div> -->
	</div>
</template>

<script>
import checksg from '../checksg/checksg.vue';
export default {
	components: {
		'v-checksg': checksg
	},
	data() {
		return {
			historylist: [
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' },
				{ buy: '$988,889', Amount: '192', Status: 'failure', Price: '$0.22390', Date: '2019-11-12' }
			],
			checktype: false,
			Announcementslist: [{}, {}],
			Loginhistory: [{}, {}, {}, {}],
			Operationlist: [
				{ name: 'Change Password', date: '2019-12-19 11:45:27' },
				{ name: 'Auction', date: '2019-12-19 11:45:27' },
				{ name: 'Change Password', date: '2019-12-19 11:45:27' },
				{ name: 'Auction', date: '2019-12-19 11:45:27' }
			],
			securitylist: [{ name: 'Enable 2FA', value: 'on', id: 1 }, { name: 'Identity Verification', value: 'Verify', id: 2 }]
		};
	},
	methods: {
		forchecksg(e) {
			if (e == 1) {
				this.checktype = true;
			}
		},
		getchecktype(data) {
			this.checktype = data;
		}
	}
};
</script>

<style scoped="scoped">
.dashboardx-2-1 {
	height: 35px;
}
.dashboardx-2-1 > span:nth-of-type(1) {
	font-size: 14px;
	font-weight: 500;
	color: rgba(51, 51, 51, 1);
	margin-left: 16px;
}
.dashboardx-2-1 > span:nth-of-type(2) {
	font-size: 14px;
	font-weight: 400;
	float: right;
	margin-right: 19px;
	color: rgba(153, 153, 153, 1);
}
.dashboardx-1-2-xian {
	width: 455px;
	height: 1px;
	opacity: 0.8;
	background: rgba(238, 238, 238, 1);
	margin-left: 19px;
}
.dashboardx-1-2-2 {
	height: 26px;
	font-size: 12px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	margin-right: 20px;
}
.dashboardx-1-2-1 {
	width:940px;
	height: 42px;
	font-size: 14px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	margin-left: 16px;
	margin-top: 16px;
}
.dashboardx-1-1 > span {
	font-size: 18px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-left: 16px;
}
.dashboardx-1-1 {
	width: 493px;
	height: 58px;
	display: flex;
	align-items: center;
}

.infinite-list-wrapper {
	width: 100%;
	height: 330px;
	overflow: auto;
	position: relative;
}
.dashboard4-2 {
	height: 51px;
}
.dashboard4-3 {
	width: 988px;
	height: 2px;
	background-color: #eeeeee;
	margin-top: 60px;
	position: absolute;
}
.dashboard4-2 > div {
	display: inline-block;
}
.dashboard4-2 > div:nth-of-type(1) {
	margin-top: 24px;
	margin-left: 31px;
	font-size: 17px;
	color: rgba(102, 102, 102, 1);
	position: absolute;
}
.dashboard4-2 > div:nth-of-type(2) {
	margin-top: 24px;
	margin-left: 230px;
	position: absolute;
	color: rgba(102, 102, 102, 1);
	font-size: 17px;
}
.dashboard4-2 > div:nth-of-type(3) {
	margin-top: 24px;
	margin-left: 459px;
	position: absolute;
	color: rgba(153, 153, 153, 1);
	font-size: 17px;
}
.dashboard4-2 > div:nth-of-type(4) {
	margin-top: 24px;
	margin-left: 668px;
	position: absolute;
	color: rgba(102, 102, 102, 1);
	font-size: 17px;
}
.dashboard4-2 > div:nth-of-type(5) {
	margin-top: 24px;
	margin-left: 866px;
	position: absolute;
	color: rgba(153, 153, 153, 1);
	font-size: 17px;
}
.dashboard4-2 > div:nth-of-type(1) {
	margin-top: 24px;
	margin-left: 31px;
	position: absolute;
}
.dashboard4-1 {
	margin-top: 6px;
	position: absolute;
}
.dashboard4-1 > span:nth-of-type(1) {
	margin-left: 34px;
}
.dashboard4-1 > span {
	font-size: 18px;
	font-weight: 400;
	margin-left: 164px;
	color: rgba(102, 102, 102, 1);
}
.dashboard4 > div:nth-of-type(2) {
	width: 1038px;
	height: 46px;
	background: rgba(245, 245, 245, 1);
	border-radius: 1px;
	margin-top: 19px;
}
.dashboard4 > div:nth-of-type(1) {
	font-size: 18px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-top: 20px;
	margin-left: 24px;
}
.dashboard3-2 > li {
	margin-top: 15px;
	color: #666666;
}
.dashboard3-2 > li > span:nth-of-type(1) {
	color: #666666;
	font-size: 16px;
}
.dashboard3-2 > li > span:nth-of-type(2) {
	color: #00c3ff;
	font-size: 14px;
	text-decoration: underline;
	margin-left: 18px;
	cursor: pointer;
}
.dashboard3-2 {
	position: absolute;
	margin-left: 33px;
	margin-top: 10px;
}
.dashboard3-1 {
	width: 455px;
	height: 1px;
	opacity: 0.8;
	background-color: #eeeeee;
	position: absolute;
	margin-top: 18px;
	margin-left: 32px;
}
.dashboard3 > div > span:nth-of-type(1) {
	font-size: 18px;
	font-weight: bold;
	margin-left: 32px;
	color: rgba(51, 51, 51, 1);
}
.dashboard3 > div > span:nth-of-type(2) {
	font-size: 18px;
	color: #00c3ff;
	margin-left: 15px;
}
.dashboard3 > div {
	margin-top: 21px;
}
.dashboard3 > div > span:nth-of-type(3) {
	font-size: 18px;
}
.dashboard2-3 > div:nth-of-type(1) {
	color: #ff6464;
	margin-left: 33px;
	margin-top: 25px;
	width: 443px;
}
.dashboard2-3 > div:nth-of-type(2) {
	color: #fdda65;
	margin-left: 33px;
	margin-top: 22px;
	width: 443px;
}
.dashboard2-3-1 {
	margin-top: 3px;
	font-size: 16px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
}
.dashboard2-3-2 {
	font-size: 18px;
	font-weight: 400;
	color: #333333;
	float: right;
}
.dashboard2-3-3 {
	font-size: 18px;
	font-weight: 400;
	margin-left: 15px;
	color: #999999;
}
.dashboard2-1 {
}
.dashboard2-2 {
	width: 455px;
	height: 1px;
	background-color: #eeeeee;
	margin-left: 32px;
	margin-top: 13px;
	opacity: 0.8;
}
.dashboard2-1 > div:nth-of-type(1) {
	font-size: 18px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-top: 20px;
	margin-left: 24px;
	display: inline-block;
}
.dashboard2-1 > div:nth-of-type(2) {
	min-width: 76px;
	height: 31px;
	background: rgba(255, 100, 100, 1);
	font-weight: bold;
	display: inline-block;
	text-align: center;
	margin-left: 153px;
	line-height: 31px;
	font-size: 12px;
	color: rgba(255, 255, 255, 1);
}
.dashboard2-1 > div:nth-of-type(3) {
	min-width: 76px;
	height: 31px;
	border: 1px solid rgba(153, 153, 153, 1);
	font-weight: bold;
	display: inline-block;
	text-align: center;
	margin-left: 17px;
	line-height: 31px;
	font-size: 12px;
	color: rgba(102, 102, 102, 1);
}
.dashboard1 {
	font-size: 18px;
	font-weight: 400;
	color: rgba(0, 195, 255, 1);
	margin-left: 382px;
	margin-top: 28px;
	position: absolute;
}
.dashboard4 {
	width: 1038px;
	height: 442px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	position: absolute;
	margin-left: 373px;
	margin-top: 316px;
}
.dashboard2 {
	margin-top: 17px;
	height: 202px;
	width: 493px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	position: absolute;
	margin-left: 334px;
}
.dashboard3 {
	position: absolute;
	width: 493px;
	margin-top: 15px;
	margin-left: 836px;
	height: 204px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
}
.dashboardx {
	height: 711px;
	width: 493px;
	margin-left: 837px;
	position: absolute;
	margin-top: 17px;
}
.dashboardx-1 {
	width:994px;
	margin-left: 334px;
	height: 250px;
	margin-top: 478px;
	position: absolute;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
}
.dashboardx-2 {
	width: 492px;
	height: 241px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 228px;
	margin-left: 334px;
	position: absolute;
}
.dashboardx-3 {
	width: 492px;
	height: 240px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 228px;
	position: absolute;
	margin-left: 836px;
}
</style>
