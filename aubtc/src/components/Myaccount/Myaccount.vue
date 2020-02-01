<template>
	<div>
		<div class="accounthalf">
			<div class="account1">
				<div class="account1-1">
					<div></div>
					<div>vicky@google.com</div>
					<div>Identity Verification</div>
				</div>
				<div style="margin-top: 77px;">
					<div class="account1-2 shou" v-for="(item, index) in list" :key="index" @click="forxuanzhog(item.id)">
						<img :src="item.wimage" v-if="item.checked == false" />
						<img :src="item.limage" v-if="item.checked == true" />
						<span class="wmsg" v-if="item.checked == false">{{ item.msg }}</span>
						<span class="wmsg" style="color:rgba(0,195,255,1);font-weight: bold;" v-if="item.checked == true">{{ item.msg }}</span>
						<span class="bluet" v-if="item.checked == true"></span>
					</div>
				</div>
			</div>
			<div v-if="xztype == '1'">
			<v-newwallet></v-newwallet>
			</div>
			<div v-if="xztype == '0'">
				<v-usercenter></v-usercenter>
			</div>
			<div v-if="xztype == '2'">
				<v-history></v-history>
			</div>
			<div v-if="xztype == '3'">
				<v-security></v-security>
			</div>
			
		</div>
	</div>
</template>

<script>
import security from '../../assembly/accountvue/Security.vue'
import usercenter from '../../assembly/accountvue/Dashboard.vue'
import newwallet from '../../assembly/accountvue/wallet.vue'
import history from '../../assembly/accountvue/TransactionHistory.vue'
export default {
	components: {
		'v-usercenter':usercenter,
		'v-newwallet':newwallet,
		'v-security':security,
		'v-history':history
	},
	data() {
		return {
			xztype: '0',
			list: [
				{ wimage: require('../../../static/myuser.png'), limage: require('../../../static/myuserblue.png'), msg: 'User Center', checked: true, id: 0 },
				{ wimage: require('../../../static/accountw2.png'), limage: require('../../../static/account2.png'), msg: 'Wallet', checked: false, id: 1 },
				{ wimage: require('../../../static/accountw3.png'), limage: require('../../../static/account3.png'), msg: 'Transaction History', checked: false, id: 2 },
				{ wimage: require('../../../static/accountw4.png'), limage: require('../../../static/account4.png'), msg: 'Security', checked: false, id: 3 },
				{ wimage: require('../../../static/accountw5.png'), limage: require('../../../static/account5.png'), msg: ' Settings', checked: false, id: 4 }
			],
			newlist: [
				{ wimage: require('../../../static/xpath5.png'), msg: 'Buy BTC with credit card now  >', checked: true, id: 0, title: 'VISA:', clicktype: 'Buy/Sell' },
				{ wimage: require('../../../static/xpath1.png'), msg: '12uvW2iVm41z4aiotu5L7LDaN3DA6Tqh2L', checked: false, id: 1, title: 'BTC Address:', clicktype: 'Copy Address' },
				{ wimage: require('../../../static/xpath3.png'), msg: 'Buy BTC with credit card now  >', checked: false, id: 2, title: 'American Express:', clicktype: 'Buy/Sell' },
				{ wimage: require('../../../static/xpath2.png'), msg: '12uvW2iVm41z4aiotu5L7LDaN3DA6Tqh2L', checked: false, id: 3, title: 'ETH Address:', clicktype: 'Copy Address' },
				{ wimage: require('../../../static/xpath4.png'), msg: 'Buy BTC with credit card now  >', checked: false, id: 4, title: 'MasterCard:', clicktype: 'Buy/Sell' }
			],
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
		};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		loadMore() {
				
		},
		forxuanzhog(e) {
			this.list.forEach(item => {
				item.checked = false;
			});
			this.list[e].checked = true;
			this.xztype = e;
		},
	
	}
};
</script>

<style >

.account1-2 {
	width: 233px;
	height: 80px;
}

.account1-2 > img {
	width: 31px;
	height: 36px;
	position: absolute;
	margin-left: 25px;
}
.wmsg {
	line-height: 34px;
	height: 34px;
	position: absolute;
	margin-left: 70px;
	font-size: 13px;
	color: rgba(153, 153, 153, 1);
}
.bluet {
	width: 6px;
	height: 32px;
	background: #00c3ff;
	position: absolute;
	margin-left: 227px;
	border-radius: 1px;
}
.account1-1 > div:nth-of-type(1) {
	width: 57px;
	height: 57px;
	background: rgba(10, 62, 105, 1);
	border-radius: 30px;
}
.account1-1 > div:nth-of-type(2) {
	font-size: 16px;
	font-weight: bold;
	color: rgba(102, 102, 102, 1);
	margin-top: 21px;
}
.account1-1 > div:nth-of-type(3) {
	min-width: 128px;
	height: 31px;
	border: 1px solid rgba(0, 195, 255, 1);
	text-align: center;
	line-height: 31px;
	font-size: 12px;
	font-weight: 400;
	margin-top: 15px;
	color: rgba(0, 195, 255, 1);
}
.account1-1 {
	display: flex;
	align-items: center;
	flex-direction: column;
	margin-top: 33px;
	width: 233px;
}
.accounthalf {
	width: 100%;
	height: 785px;
}
.account1 {
	width: 233px;
	height: 711px;

	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 20px 0px rgba(188, 188, 188, 0.5);
	border-radius: 1px;
	position: absolute;
	margin-left:90px;
	margin-top: 17px;
}
.account2 {
	width: 996px;
	height:229px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-left: 377px;
	margin-top: 67px;
	position: absolute;
}
.account3 {
	width: 996px;
	height: 452px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-left: 377px;
	margin-top: 307px;
	position: absolute;
}
</style>
