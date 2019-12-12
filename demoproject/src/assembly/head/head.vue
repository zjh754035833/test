<template>
	<div class="halfarea-1">
		<img src="../../../static/Fill.png" class="box2" />
		<span class="box1 shou"  @click="forindex">AUWELS</span>
		<div class="box3">
			<span @click="forbuyshell">Buy/Sell</span>
			<span @click="fornewAnction">Anction</span>
			<span @click="forSavings">Savings</span>
			<span @click="forMining">Mining</span>
		</div>
		<!--    <div class="box5">
           login
         </div> -->
	</div>
</template>

<script>
export default {
	data() {
		return {
			blue1: ''
		};
	},
	components: {},
	methods: {
		forbuyshell() {
			this.$router.push({ path: '/sellbuy' });
		},
		fornewAnction() {
			this.$router.push({ path: '/newAnction' });
		},
		forSavings() {
			this.$router.push({ path: '/Savings' });
		},
		forMining() {
			this.$router.push({ path: '/Mining' });
		},
		forindex() {
			this.$router.push({ path: '/' });
		}
	}
};
</script>

<style scoped="scoped">
	
.halfarea-1 {
	width: 100%;
	height: 50px;
	display: flex;
	align-items: center;
	margin-top: 30px;
	position: absolute;
}

.box3 {
	display: flex;
	font-size: 18px;
	align-items: center;
	font-weight: normal;
	color: rgba(255, 255, 255, 1);
}
.box3:nth-of-type(1) {
	margin-left: 51px;
}
.box3 > span {
	margin-left: 54px;
	cursor: pointer;
}
.box2 {
	margin-left: 134px;
	width: 37px;
	height: 34px;
}
.box1 {
	margin-left: 25px;
	font-size: 34px;
	font-weight: 900;
	color: rgba(255, 255, 255, 1);
}
</style>
