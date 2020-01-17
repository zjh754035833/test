<template>
	<div>
		<img src="../../static/user1.png" class="individ1" />
		<div style="display: flex;margin-top: 43px;">
			<div class="individual2" >AAC membership</div>
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
			</div>
			
		</div>
		<div style="margin-bottom: 42px;"></div>
	</div>
</template>

<script>
export default {
	components: {
	},
	data() {
		return {};
	},
	computed: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {},
	created() {}
};
</script>

<style scoped="scoped">
	.membership3 {
		width: 900px;
		font-size: 16px;
		margin-left: 76px;
		font-weight: 600;
		color: rgba(102, 102, 102, 1);
		line-height: 24px;
		margin-bottom: 50px;
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
	.individual4{
		margin-left: 406px;	
		
	}
	.subilt{
		margin-top: 35px;
		font-size:15px;
		width:142px;
		height:47px;
		border:1px solid rgba(51,51,51,1);
		text-align: center;
		line-height: 47px;
	}
	.individual4>input{
		margin-top: 27px;
		padding-left: 25px;
		width:787px;
		height:48px;
		background:rgba(247,247,247,1);
		border-radius:1px;
		border:1px solid rgba(218,218,218,1);
		font-size:15px;
	}

.individ1 {
	width: 100%;
}
.individual2 {
	font-size: 22px;
	font-weight: 500;
	color: rgba(51, 51, 51, 1);
	margin-left: 143px;
}
</style>
