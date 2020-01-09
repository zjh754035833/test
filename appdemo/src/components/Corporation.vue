<template>
	<div>
		<v-head></v-head>
		<img src="../../static/user1.png" class="individ1" />
		<div style="display: flex;margin-top: 43px;justify-content: center;">
			<div class="individual3">
				<div style="margin-top: 0px;">Get industry information and analysis report pushed by the ACC </div>
				<div >Certification issued by the ACC</div>
				<div>Blockchain Scale Ups</div>
				<div>Use ACC logos in your email signatures, company website and literature</div>
				<div>Be promoted by ACC to target audiences through avenues like social media</div>
				<div>Eligibility to participate in events or summits.</div>
			</div>
			
		</div>
		<div style="display: flex;justify-content: center;">
		<div class="individual4" >
			<input placeholder="Company name"/>
			<input placeholder="Contact name" />
			<input type="number" placeholder="Telephone"/>
			<input placeholder="Email"/>
			<div class="subilt shou">SUBMIT</div>
		</div>
		</div>
		<div></div>
		<v-foot style="margin-top: 42px;"></v-foot>
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
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {},
	created() {}
};
</script>

<style scoped="scoped">
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
	.individual3>div:nth-of-type(2n){
		color: rgba(153, 153, 153, 1);
		font-size: 15px;
		margin-top: 10px;
	}
	.individual3>div:nth-of-type(2n+1){
		margin-top: 43px;
		color: rgba(51, 51, 51, 1);
		font-size: 18px;
		
	}
	.individual3{
		
		margin-left: 40px;
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
