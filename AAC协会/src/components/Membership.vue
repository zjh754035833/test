<template>
	<div>
		<img src="../../static/memver.png"  style="width: 100%;"/>
		<div class="membershipall">
			<div class="membership2">AAC membership</div>
			<div class="membership3">
				<div>
					Association of Australian Cryptocurrency(AAC) is Australia’s industry network for businesses applying or evaluating Cryptocurrency or distributed ledger
					technology.
				</div>
				<div>As part of the Australia Cryptocurrency network, individual businesses may:</div>
				<li style="margin-top: 0px;">Get industry information and analysis report pushed by the ACC </li>
				<li >Certification issued by the ACC</li>
				<li>Blockchain Scale Ups</li>
				<li>Use ACC logos in your email signatures, company website and literature</li>
				<li>Be promoted by ACC to target audiences through avenues like social media</li>
				<li>Eligibility to participate in events or summits.</li>
				<div>
					Collectively, Cryptocurrency Australia members help advance the adoption of Cryptocurrency technology in Australia and work together to advocate for appropriate regulatory and policy settings.
				</div>
				<div class="membershipimg">
					<div class="img1"><div class="menbersign shou" v-show="nologin" @click="forsignup">Sign up</div></div>
					<div class="img2"><div class="menbersign shou" v-show="nologin" @click="forsignup">Sign up</div></div>
					<!-- <img src="../../static/menber2.png" />
					<img src="../../static/menber3.png" /> -->
					<!-- <div class="img3">
						<div>AAC</div>
						<div>Membership list</div>
						<div>Association of Australian Cryptocurrency</div>
						<div>View</div>
					</div> -->
				</div>
			</div>
		</div>
		
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			nologin: true
		};
	},
	computed: {},
	mounted() {
		if ((localStorage.getItem('token') != '') & (localStorage.getItem('token') != null)) {
			this.nologin = false;
		}
	},
	methods: {
		forsignup() {
			this.$router.push({ path: '/Sigin' });
		}
	},
	created() {}
};
</script>

<style scoped="scoped">
.menbersign {
	width: 86px;
	height: 42px;
	font-size: 16px;
	line-height: 42px;
	text-align: center;
	margin-top: 400px;
	position: absolute;
	background-color: rgba(255, 227, 145, 1);
}
.membershipimg {
	display: flex;
}
.img1 {
	background-image: url('../../static/menber2.png');
	background-size: 100%;
	width: 380px;
	height: 520px;
	justify-content: center;
	display: flex;
}
.img2 {
	background-image: url('../../static/menber3.png');
	background-size: 100%;
	margin-left: 20px;
	width: 380px;
	justify-content: center;
	display: flex;
	height: 520px;
}
.img3 {
	width: 460px;
	height: 420px;
	background: rgba(235, 123, 97, 1);
}
.img3 > div {
	margin-left: 40px;
}
.img3 > div:nth-of-type(1) {
	font-size: 14px;
	font-weight: 400;
	margin-top: 34px;
	color: rgba(255, 199, 176, 1);
}
.img3 > div:nth-of-type(2) {
	font-size: 36px;
	margin-top: 14px;
	font-weight: 600;
	color: rgba(255, 255, 255, 1);
}
.img3 > div:nth-of-type(3) {
	width: 262px;
	height: 56px;
	font-size: 20px;
	margin-top: 14px;
	font-weight: 300;
	color: rgba(255, 255, 255, 1);
	line-height: 28px;
}
.img3 > div:nth-of-type(4) {
	width: 126px;
	height: 42px;
	font-size: 20px;
	font-weight: 400;
	text-align: center;
	line-height: 42px;
	margin-top: 142px;
	color: rgba(255, 255, 255, 1);
	border: 2px solid rgba(255, 227, 145, 1);
}
.membershipall {
	display: flex;
	margin-bottom: 56px;
}
.membership1 {
	width: 100%;
}
.membership2 {
	margin-left: 107px;
	margin-top: 48px;
	width: 241px;
	height: 68px;
	font-size: 25px;
	font-weight: 500;
	color: rgba(51, 51, 51, 1);
	line-height: 34px;
}
.membership3 {
	width: 900px;
	font-size: 16px;
	margin-top: 53px;
	margin-left: 76px;
	font-weight: 600;
	color: rgba(102, 102, 102, 1);
	line-height: 24px;
}
.membership3 > div:nth-of-type(2) {
	font-size: 15px;
	color: rgba(153, 153, 153, 1);
	margin-top: 20px;
}
.membership3 > div:nth-of-type(3) {
	margin-top: 20px;
}
.membership3 > div:nth-of-type(4) {
	font-size: 15px;
	color: rgba(153, 153, 153, 1);
	margin-top: 20px;
}
.membership3 > li:nth-of-type(1) {
	font-size: 15px;
	margin-top: 20px;
	color: rgba(153, 153, 153, 1);
}
.membership3 > li {
	font-size: 15px;
	color: rgba(153, 153, 153, 1);
}
</style>
