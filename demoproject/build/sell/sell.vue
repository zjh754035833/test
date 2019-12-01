<template>
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
			<span @click="forsign">sign up</span>
			<span @click="forlogin">login</span>
		</div>
	</div>
</template>

<script>
export default {
	components: {},
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
			this.$emit('pagetype', '1');
			this.$router.push({ path: '/newAnction' });
		},
		forSavings() {
			this.$router.push({ path: '/Savings' });
		},
		forMining() {
			this.$router.push({ path: '/Mining' });
		}
	}
};
</script>

<style scoped="scoped">
.halfarea-1 {
	width: 1440px;
	height: 65px;
	background: rgba(10, 62, 105, 1);
}
.box5 > span {
	cursor: pointer;
}
.box5 > span:nth-of-type(1) {
	position: absolute;
	margin-top: 20px;
	width: 95px;
	height: 31px;
	font-weight: 900;
	border-radius: 2px;
	border: 1px solid rgba(255, 255, 255, 1);
	margin-left: 1115px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
	line-height: 31px;
	text-align: center;
}
.box5 > span:nth-of-type(2) {
	font-weight: 900;
	position: absolute;
	margin-top: 20px;
	width: 95px;
	height: 33px;
	background: #00c3ff;
	border-radius: 2px;
	margin-left: 1232px;
	font-size: 18px;
	color: rgba(255, 255, 255, 1);
	line-height: 31px;
	text-align: center;
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
