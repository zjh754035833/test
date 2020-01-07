<template>
	<div>
			<div class="box5">
				<div>
				<img src="../../../static/fdjindex.png"  />
				<input placeholder="Search"  />
				</div>
				<div @click="forsign">sign up</div>
				<div @click="forlogin">login</div>
			</div>
		</div>
</template>

<script>
export default {
	components: {
	},
	data() {
		return {
			/* blue1: '',
			loginstate:'' */
		};
	},
	methods: {
		/* forindex() {
			this.$router.push({ path: '/' });
		}, */
		forlogin() {
			this.$router.push({ path: '/login' });
		},
		forsign() {
			this.$router.push({ path: '/signup' });
		},
		/* forbuyshell() {
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
		} */
	},
	mounted() {
		/* this.blue1 = localStorage.getItem('clicksell');
		this.loginstate=localStorage.getItem('loginstate'); */
	}
};
</script>

<style scoped="scoped">
	::-webkit-input-placeholder {
		/*Chrome/Safari*/
		color:rgba(51,51,51,1);
		font-weight:500;
	}
	::-moz-placeholder {
		/*Firefox*/
	color:rgba(51,51,51,1);
	font-weight:500;
	}
	::-ms-input-placeholder {
		/*IE*/
	color:rgba(51,51,51,1);
	font-weight:500;
	}
	.box5{
		display: flex;
		align-items: center;
		margin-left: 180px;
	}
	.box5>div>input{
		width:183px;
		padding-left: 42px;
		height:31px;
		line-height: 31px;
		font-size: 14px;
		background:rgba(247,247,247,1);
		border:1px solid rgba(218,218,218,1);
	}
	.box5>div>img{
		width:17px;
		height:17px;
		margin-left: 15px;
		position: absolute;
	}
	.box5>div:nth-of-type(1){
	display: flex;
	align-items: center;
	}
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
.box5 > div:nth-of-type(2) {
	width:95px;
	margin-left: 9px;
	height:31px;
	background:rgba(247,247,247,1);
	border:1px solid rgba(218,218,218,1);
	font-weight: 600;
	border-radius: 2px;
	font-size: 14px;
	line-height: 31px;
	color: rgba(102, 102, 102, 1);
	text-align: center;
}
.box5 > div:nth-of-type(3) {
	font-weight: 600;
width:95px;
height:33px;
background:rgba(0,195,255,1);
	margin-left: 22px;
	border-radius: 2px;
	font-size: 14px;
	color: rgba(255, 255, 255, 1);
	line-height: 33px;
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
