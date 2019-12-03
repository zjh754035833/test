<template>
	<div>
		<v-wallet v-if="loginstate==1"></v-wallet>
		<div class="halfarea-1" v-if="loginstate!=1">
			<img src="../../static/Fill.png" class="box2" />
			<span class="box1 shou" @click="forindex">AUWELS</span>
			<div class="box3">
				<span @click="forbuyshell" :class="[blue1 == 1 ? 'blue' : '']">Buy/Sell</span>
				<span @click="forAnction" :class="[blue1 == 2 ? 'blue' : '']">Anction</span>
				<span @click="forSavings" :class="[blue1 == 3 ? 'blue' : '']">Savings</span>
				<span @click="forMining" :class="[blue1 == 4 ? 'blue' : '']">Mining</span>
			</div>

			<div class="box5">
				<div @click="forsign">sign up</div>
				<div @click="forlogin">login</div>
			</div>
		</div>
	</div>
</template>

<script>
import wallet from '../../build/wallet/wallet.vue';
export default {
	components: {
		'v-wallet': wallet
	},
	data() {
		return {
			blue1: '',
			loginstate:''
		};
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
			localStorage.setItem('clicksell', 1);
		},
		forAnction() {
			this.$emit('pagetype', '1');
			this.$router.push({ path: '/newAnction' });
		},
		forSavings() {
			this.$router.push({ path: '/Savings' });
		},
		forMining() {
			this.$router.push({ path: '/Mining' });
		}
	},
	mounted() {
		this.blue1 = localStorage.getItem('clicksell');
		this.loginstate=localStorage.getItem('loginstate');
	}
};
</script>

<style scoped="scoped">
.blue {
	color: #00c3ff;
}
.halfarea-1 {
	height: 65px;
	background: rgba(10, 62, 105, 1);
	display: flex;
	align-items: center;
}
.box5 {
	display: flex;
	justify-content: center;
}
.box5 > div {
	cursor: pointer;
}
.box5 > div:nth-of-type(1) {
	width: 95px;
	height: 31px;
	margin-left: 275px;
	font-weight: 900;
	border-radius: 2px;
	border: 1px solid rgba(255, 255, 255, 1);
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
	text-align: center;
}
.box5 > div:nth-of-type(2) {
	font-weight: 900;
	width: 95px;
	height: 33px;
	margin-left: 22px;
	background: #00c3ff;
	border-radius: 2px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
	line-height: 31px;
	text-align: center;
}

.box3 {
	display: flex;
	font-size: 18px;
	font-weight: bold;
	color: rgba(255, 255, 255, 1);
}
.box3:nth-of-type(1) {
}
.box3 > span {
	cursor: pointer;
	margin-left: 54px;
}
.box2 {
	width: 37px;
	height: 34px;
	margin-left: 120px;
}
.box1 {
	margin-left: 25px;
	font-size: 34px;
	font-weight: 900;
	color: rgba(255, 255, 255, 1);
}
</style>
