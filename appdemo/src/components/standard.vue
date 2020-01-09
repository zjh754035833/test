<template>
	<div>
		<v-head></v-head>
		<div class="our1"></div>
		<div class="standard">
			<span>Stands</span>
			<span>What is the Australian Digital Currency Industry Code of Conduct?</span>
		</div>
		<br />
		<div class="standard1">
			The Australian Digital Currency Industry Code of Conduct is an audited, self-regulatory scheme that allows Australian digital currency exchanges to prove to consumers
			that they met strict best-practice standards in the operation of their businesses.
			<br />
			<br />
			Australian consumers doing business with a Blockchain Australia Certified digital currency exchange can be confident that the exchange meets best practice standards in
			the following areas:
		</div>
		<div class="standard2">
			<li>legal compliance</li>
			<li>reputation and background of the exchange owners and operators</li>
			<li>anti-money laundering and counter-terrorism financing protections and reporting</li>
			<li>consumer protection including:</li>
			<li>transparent pricing</li>
			<li>dispute resolution processes</li>
		</div>
		<div class="standard3">How is Compliance with the Australian Digital Currency Industry Code of Conduct Confirmed?</div>
		<div class="standard4">
A digital currency exchange applies the following process to confirm compliance with the Australian Digital Currency Industry Code of Conduct:Appoint an Independent Auditor
A digital currency exchange seeking Blockchain Australia Certification under the Australian Digital Currency Industry Code of Conduct must first nominate an independent and professionally competent external auditor.  The proposed auditor must be approved by Blockchain Australia’s AML/CTF Committee.</div>
		<v-foot ></v-foot>
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
	mounted() {},
	methods: {},
	created() {}
};
</script>

<style scoped="scoped">
	.standard4{
		width:929px;
		height:176px;
		font-size:17px;
		font-weight:400;
		color:rgba(153, 153, 153, 1);
		line-height:24px;
		margin-left: 300px;
		margin-top: 30px;
		}
	.standard3{
		font-size:18px;
		font-weight:400;
		color:rgba(51,51,51,1);
		margin-left: 300px;
		margin-top: 27px;
	}
	.standard2{
		margin-left: 305px;
		font-size:16px;
		margin-top: 20px;
font-weight:400;
color:rgba(153,153,153,1);
	}
.standard > span:nth-of-type(1) {
	font-size: 25px;
	font-weight: 500;
	color: rgba(51, 51, 51, 1);
	margin-left: 181px;
}
.standard > span:nth-of-type(2) {
	font-size: 18px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
	margin-left: 37px;
}
.standard1 {
	width: 862px;
	font-size: 17px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	line-height: 24px;
	margin-left: 300px;
}
.standard {
	margin-top: 39px;
}
.our1 {

		width: 100%;
		height: 68px;
		background-image: url("../../static/user1.png");
		background-size: 100%;
}
</style>
