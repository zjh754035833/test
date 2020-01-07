<template>
	<div class="indexall">
		<v-head></v-head>
		<img src="../../static/indeximg1.png" />
		<div class="indextop" style="margin-top: 0px;">
			<div class="index1">
				<div>What We Do</div>
				<div>
					AAC Australia aims to encourage the responsible adoption of blockchain technology by industry and governments across Australia as a means to drive innovation in
					service delivery across all sectors of the economy.
				</div>
			</div>
			<div class="index2"><img src="../../static/indeximg2.png" /></div>
		</div>
		<div class="indextop">
			<div class="index2"><img src="../../static/indeximg3.png" /></div>
			<div class="index1">
				<div>What We Do</div>
				<div>
					AAC Australia aims to encourage the responsible adoption of blockchain technology by industry and governments across Australia as a means to drive innovation in
					service delivery across all sectors of the economy.
				</div>
			</div>
		</div>
		<div class="index3">
			<el-carousel :interval="3000" autoplay="true" indicator-position="outside">
				<el-carousel-item v-for="item in swiplist" :key="item">
					<div class="index3-1">
						<div>{{ item.text1 }}</div>
						<div></div>
						<div>{{ item.text2 }}</div>
					</div>
				</el-carousel-item>
			</el-carousel>
		</div>
			<img src="../../static/indeximg4.png" class="index4"/>
			<div class="index6">
				<div class="index7"></div>
			</div>
			<div class="index8">
				<span>PARTNERS</span>
				<img src="../../static/indeximg5.png" />
			</div>
			<div class="index6">
				<div class="index7"></div>
			</div>
			<v-foot style="margin-top: 10px;background-color: #F0F0F0;"></v-foot>
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
		return {
			swiplist: [
				{
					text1: 'Understanding the Australian blockchain',
					text2:
						'Blockchain technology is used to create and manage trusted digital transactions.  A distributed ledger is used to store transactions and other records in a cryptographically connected chain that cannot be altered.  This gives all authorised participants full confidence that they have access to an accurate and up to date copy of all relevant transactions with full confidence in the security and authenticity of the records.'
				},
				{
					text1: 'Understanding the Australian blockchain',
					text2:
						'Blockchain technology is used to create and manage trusted digital transactions.  A distributed ledger is used to store transactions and other records in a cryptographically connected chain that cannot be altered.  This gives all authorised participants full confidence that they have access to an accurate and up to date copy of all relevant transactions with full confidence in the security and authenticity of the records.'
				},
				{
					text1: 'Understanding the Australian blockchain',
					text2:
						'Blockchain technology is used to create and manage trusted digital transactions.  A distributed ledger is used to store transactions and other records in a cryptographically connected chain that cannot be altered.  This gives all authorised participants full confidence that they have access to an accurate and up to date copy of all relevant transactions with full confidence in the security and authenticity of the records.'
				}
			]
		};
	},
	computed: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {},
	created() {}
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
	.index8>span{
		font-size:37px;
		color:rgba(0,0,0,1);
		margin-left: 94px;
		
	}
	.index8>img{
		width: 933px;
		height: 34px;
		margin-right: 92px;
	}
	.index8{
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.index8{
		margin-top: 60px;
		}
	.index7{
		width:1248px;
		height:1px;
		background-color: rgba(223, 223, 223, 1);
		margin-top: 51px;
	}
	.index6{
		width: 100%;
		display: flex;
		justify-content: center;
		}
	.index4{
		margin-top: 86px;
		width: 100%
	}
	.index3-1{
			display: flex;
			flex-direction: column;
			align-items: center;
		}
		.index3-1>div:nth-of-type(1){
			font-size:38px;
font-family:SFUIDisplay-Regular,SFUIDisplay;
font-weight:400;
		}
		.index3-1>div:nth-of-type(2){
			width:93px;
			height:4px;
			background:rgba(208,124,124,1);
			margin-top: 20px;
				}
		.index3-1>div:nth-of-type(3){
		width:1165px;
		height:175px;
		margin-top: 10px;
		font-size:25px;
		font-weight:400;
		text-align: center;
		color:rgba(153,153,153,1);
		line-height:35px;
				}
		
/deep/	.el-carousel__button:nth-child(2n) {
	width:9px;
	height:9px;
	background:rgba(211,211,211,1);
		border-radius: 9px;
	}
/deep/	.el-carousel__indicator.is-active button{
	width:13px;
	height:13px;
	background:RGBA(208, 124, 124, 1);
	border-radius: 13px;
}
/deep/	.el-carousel__button:nth-child(2n + 1) {
	width:9px;
	height:9px;
	background:rgba(211,211,211,1);
	border-radius: 9px;
	}
/deep/	.el-carousel__button{
	width:9px;
	height:9px;
		border-radius: 9px;
	background:rgba(211,211,211,1);
}
	.index3 {
		width: 100%;
		margin-top: 80px;
	}
	.indextop {
		display: flex;
	}
	
	.indexall > img {
		width: 100%;
	}
	.index1 {
		display: flex;
		flex-direction: column;
		justify-content: center;
		width: 50%;
	}
	.index1 > div:nth-of-type(1) {
		font-size: 48px;
		margin-left: 111px;
		font-weight: bold;
		color: rgba(37, 37, 37, 1);
	}
	.index1 > div:nth-of-type(2) {
		width: 465px;
		height: 149px;
		margin-left: 111px;
		font-size: 20px;
		font-weight: 400;
		margin-top: 24px;
		color: rgba(149, 149, 149, 1);
	}
	.index2 {
		width: 50%;
	}
	.index2 > img {
		width: 100%;
	}
</style>

