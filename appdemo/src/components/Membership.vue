<template>
	<div>
		<v-head></v-head>
		<img src="../../static/menber1.png" class="membership1" />
		<div class="membershipall">
			<div class="membership2">Blockchain Australia Membership</div>
			<div class="membership3">
				<div>Blockchain Australia is Australia’s industry network for businesses implementing or evaluating blockchain or distributed ledger technology.</div>
				<div>As part of the Blockchain Australia network, individual businesses may:</div>
				<li>engage with and learn from other businesses implementing blockchain solutions;</li>
				<li>share best-practice and collaborate as appropriate;</li>
				<li>access national and global thought-leaders;</li>
				<li>contribute to Blockchain Australia’s advocacy agenda with key government and regulatory stakeholders; and</li>
				<li>participate in Blockchain Australia conferences, workshops and study tours.</li>
				<div>
					Collectively, Blockchain Australia members help advance the adoption of blockchain technology in Australia and work together to advocate for appropriate
					regulatory and policy settings.
				</div>
				<div>A digital currency exchange applies the following process to confirm compliance with the Australian Digital Currency Industry Code of Conduct:</div>
			</div>
		</div>
		<div class="membershipimg">
			<div class="img1"><div class="menbersign">Sign up</div></div>
			<div class="img2"><div class="menbersign">Sign up</div></div>
			<!-- <img src="../../static/menber2.png" />
			<img src="../../static/menber3.png" /> -->
			<!-- <div class="img3">
				<div>AAC</div>
				<div>Membership list</div>
				<div>Association of Australian Cryptocurrency</div>
				<div>View</div>
			</div> -->
		</div>
		<v-foot style="margin-top: 78px;"></v-foot>
	</div>
</template>

<script>
import head from '../assembly/head/head.vue';
import foot from '../assembly/foot/foot.vue';
export default {
	components: {
		'v-head': head,
		'v-foot': foot
	},
	data() {
		return {};
	},
	computed: {},
	mounted() {
	},
	methods: {},
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
	margin-top: 330px;
	position: absolute;
	background-color: rgba(255, 227, 145, 1);
}
.membershipimg {
	display: flex;
	margin-left: 211px;
}
.img1 {
	background-image: url('../../static/menber2.png');
	background-size: 100%;
	width: 260px;
	height: 420px;
	justify-content: center;
	display: flex;
}
.img2 {
	background-image: url('../../static/menber3.png');
	background-size: 100%;
	margin-left: 20px;
	width: 260px;
	justify-content: center;
	display: flex;
	height: 420px;
}
.img3 {
	width: 460px;
	height: 420px;
	background: rgba(235, 123, 97, 1);
}
.img3>div{
	margin-left: 40px;
}
.img3>div:nth-of-type(1){
	font-size:14px;
	font-weight:400;
	margin-top: 34px;
	color:rgba(255,199,176,1);
}
.img3>div:nth-of-type(2){
	font-size:36px;
	margin-top: 14px;
	font-weight:600;
	color:rgba(255,255,255,1);
}
.img3>div:nth-of-type(3){
width:262px;
height:56px;
font-size:20px;
margin-top: 14px;
font-weight:300;
color:rgba(255,255,255,1);
line-height:28px;
}
.img3>div:nth-of-type(4){
	width:126px;
	height:42px;
	font-size:20px;
	font-weight:400;
	text-align: center;
	line-height: 42px;
	margin-top: 142px;
	color:rgba(255,255,255,1);
	border:2px solid rgba(255,227,145,1);
}
.membershipall {
	display: flex;
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
	width: 863px;
	height: 420px;
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
