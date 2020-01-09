<template>
	<div class="head1">
		<img src="../../../static/headimg.png" />
		<span style="margin-left: 120px;" class="shou" @click="forhome">Home</span>
		<div class="shou" @mouseenter="mouall(1)" @mouseleave="leaveall(1)" style="z-index: 999;">
			<span @click="forabout">About</span>
			<i class="el-icon-arrow-down el-icon--right" v-if="jiantoustyle1 == 1"></i>
			<i class="el-icon-arrow-up el-icon--right" v-if="jiantoustyle1 == 2"></i>
			<div class="headkuang1" :style="headkuang1style">
				<div class="headkuang1-1"  @click="forstandard">Our mission</div>
				<div class="headkuang1-2" @click="formission">About as</div>
			</div>
		</div>
		<div class="shou" @mouseenter="mouall(2)" @mouseleave="leaveall(2)" style="z-index: 999;">
			<span @click="forMembership">Membership</span>
			<i class="el-icon-arrow-down el-icon--right" v-if="jiantoustyle2 == 1"></i>
			<i class="el-icon-arrow-up el-icon--right" v-if="jiantoustyle2 == 2"></i>
			<div class="headkuang2" :style="headkuang2style">
				<div class="headkuang2-1" @click="forindividual">Individual</div>
				<div class="headkuang2-2" @click="forCorporation">Corporation</div>
				<div class="headkuang2-2" @click="formemberlist">Membership list</div>
			</div>
		</div>
		<div class="shou" @mouseenter="mouall(3)" @mouseleave="leaveall(3)" style="z-index: 999;margin-right: 50px;">
		<span class="shou" @click="forresource">Resource library</span>
			<i class="el-icon-arrow-down el-icon--right" v-if="jiantoustyle3 == 1"></i>
			<i class="el-icon-arrow-up el-icon--right" v-if="jiantoustyle3 == 2"></i>
			<div class="headkuang3" :style="headkuang3style">
				<div class="headkuang3-1" @click="forSubscription">Subscription</div>
			</div>
		</div>
		<div class="shou" @mouseenter="mouall(4)" @mouseleave="leaveall(4)" style="z-index: 999;margin-right: 150px;" v-if="islogin==true">
		<span class="shou" @click="forresource">Doggie  yang</span>
			<i class="el-icon-arrow-down el-icon--right" v-if="jiantoustyle4 == 1"></i>
			<i class="el-icon-arrow-up el-icon--right" v-if="jiantoustyle4 == 2"></i>
			<div class="headkuang3" :style="headkuang4style">
				<div class="headkuang3-1" @click="forUsercenter">User Center</div>
				<div class="headkuang3-1"  style="margin-top: 0px;">Log out</div>
			</div>
		</div>
		<div class="login shou" @click="forlogin" v-if="islogin==false">Login</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			headkuang1style: 'display:none',
			headkuang2style: 'display:none',
			headkuang3style: 'display:none',
			headkuang4style: 'display:none',
			jiantoustyle1: 1,
			jiantoustyle2: 1,
			jiantoustyle3: 1,
			jiantoustyle4: 1,
			islogin:false
		};
	},
	computed: {},
	mounted() {
		if((localStorage.getItem('token'))!=""&(localStorage.getItem('token'))!=null){
			this.islogin=true;
		}
	},
	methods: {
		forstandard() {
			this.$router.push({ path: '/Standard' });
		},
		forhome() {
			this.$router.push({ path: '/' });
		},
		forabout() {
		},
		forMembership() {
			this.$router.push({ path: '/Membership' });
		},
		formission() {
			this.$router.push({ path: '/ourmission' });
		},
		forUsercenter(){
			this.$router.push({ path: '/usercenter' });
		},
		formemberlist() {
			this.$router.push({ path: '/Memberlist' });
		},
		forCorporation() {
			this.$router.push({ path: '/Corporation' });
		},
		forindividual() {
			this.$router.push({ path: '/individual' });
		},
		forresource() {
			this.$router.push({ path: '/resource' });
		},
		forlogin() {
			this.$router.push({ path: '/login' });
		},
		forSubscription(){
			this.$router.push({ path: '/Subscription' });
		},
		mouall(e) {
			if (e == 1) {
				this.headkuang1style = 'display:block';
				this.jiantoustyle1 = 2;
			} else if (e == 2) {
				this.headkuang2style = 'display:block';
				this.jiantoustyle2 = 2;
			} else if (e == 3) {
				this.headkuang3style = 'display:block';
				this.jiantoustyle3 = 2;
			}else if(e == 4){
				this.headkuang4style = 'display:block';
				this.jiantoustyle4 = 2;
			}
		},
		leaveall(e) {
			if (e == 1) {
				this.headkuang1style = 'display:none';
				this.jiantoustyle1 = 1;
			} else if (e == 2) {
				this.jiantoustyle2 = 1;
				this.headkuang2style = 'display:none';
			} else if (e == 3) {
				this.jiantoustyle3 = 1;
				this.headkuang3style = 'display:none';
			} else if (e == 4) {
				this.jiantoustyle4 = 1;
				this.headkuang4style = 'display:none';
			}
		}
	},
	created() {}
};
</script>

<style>
.headkuang1-1 {
	width: 220px;
	height: 70px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(211, 210, 210, 0.5);
	border-radius: 1px;
	margin-top: 15px;
	line-height: 70px;
	font-size: 19px;
	padding-left: 20px;
}
.headkuang2-1 {
	width: 220px;
	height: 70px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(211, 210, 210, 0.5);
	border-radius: 1px;
	margin-top: 15px;
	line-height: 70px;
	font-size: 19px;
	padding-left: 20px;
}
.headkuang3-1 {
	width: 220px;
	height: 70px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(211, 210, 210, 0.5);
	border-radius: 1px;
	margin-top: 15px;
	line-height: 70px;
	font-size: 19px;
	padding-left: 20px;
}
.headkuang1-1:hover {
	background: rgba(247, 247, 247, 1);
}
.headkuang2-1:hover {
	background: rgba(247, 247, 247, 1);
}
.headkuang3-1:hover {
	background: rgba(247, 247, 247, 1);
}
.headkuang1-2:hover {
	background: rgba(247, 247, 247, 1);
}
.headkuang2-2:hover {
	background: rgba(247, 247, 247, 1);
}
.headkuang1-2 {
	width: 220px;
	font-size: 19px;
	height: 70px;
	line-height: 70px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(211, 210, 210, 0.5);
	border-radius: 1px;
	padding-left: 20px;
}
.headkuang2-2 {
	width: 220px;
	font-size: 19px;
	height: 70px;
	line-height: 70px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 12px 0px rgba(211, 210, 210, 0.5);
	border-radius: 1px;
	padding-left: 20px;
}
.login {
	width: 127px;
	height: 39px;
	background: rgba(38, 0, 120, 1);
	font-size: 17px;
	text-align: center;
	line-height: 39px;
	font-weight: 400;
	margin-right: 126px;
	color: rgba(255, 255, 255, 1);
}
.headkuang1 {
	position: absolute;
}
.headkuang2 {
	position: absolute;
}
.headkuang3 {
	position: absolute;
}
.head1 {
	display: flex;
	align-items: center;
	width: 100%;
	height: 77px;
	justify-content: space-between;
	background: rgba(255, 255, 255, 1);
	font-size: 19px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
}

.head1 > img {
	width: 166px;
	height: 56px;
	margin-left: 140px;
}

.head1 > span:nth-of-type(1):hover {
	text-decoration: underline;
}

.head1 > span:nth-of-type(2):hover {
	text-decoration: underline;
}
.head1 > div:nth-of-type(1):hover {
	text-decoration: underline;
}

.head1 > div:nth-of-type(2):hover {
	text-decoration: underline;
}
</style>
