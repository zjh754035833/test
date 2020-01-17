<template>
	<div>
	<div class="index3">
		<el-carousel :interval="3000" autoplay="true" indicator-position="outside" height="500px">
			<el-carousel-item v-for="item in swiplist" :key="item">
				<div class="index3-1">
					<div>{{ item.text1 }}</div>
					<div></div>
					<div>{{ item.text3 }}</div>
					<div>{{ item.text2 }}</div>
					<div>READ MORE</div>
				</div>
			</el-carousel-item>
		</el-carousel>
	</div>
	</div>
</template>

<script>
	export default {
		components: {
		},
		data() {
			return {
				swiplist: [
					{
						text1: 'STANDARDS',
						text2:'The Australian Digital Currency Industry Code of Conduct establishes best-practice standards for digital currency businesses in Australia. Blockchain Australia Certified digital currency businesses offer peace of mind to consumers as they have passed an external audit demonstrating compliance with these standards.',
						text3:'Australian Digital Currency Code of Conduct'
					},
					{
						text1: 'STANDARDS',
						text2:'The Australian Digital Currency Industry Code of Conduct establishes best-practice standards for digital currency businesses in Australia. Blockchain Australia Certified digital currency businesses offer peace of mind to consumers as they have passed an external audit demonstrating compliance with these standards.',
						text3:'Australian Digital Currency Code of Conduct'
					},
					{
						text1: 'STANDARDS',
						text2:'The Australian Digital Currency Industry Code of Conduct establishes best-practice standards for digital currency businesses in Australia. Blockchain Australia Certified digital currency businesses offer peace of mind to consumers as they have passed an external audit demonstrating compliance with these standards.',
						text3:'Australian Digital Currency Code of Conduct'
					}
				]
			};
		},
		computed: {},
		mounted() {
		},
		methods: {},
		created() {}
	};
</script>

<style scoped="scoped">
	.index3{
		margin-top: 80px;
	}
	.about1{
		width: 100%;
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
				width:51px;
				height:5px;
				background:rgba(208,124,124,1);
				margin-top: 20px;
					}
			.index3-1>div:nth-of-type(3){
			margin-top: 40px;
			font-size:29px;
			font-weight:400;
			text-align: center;
			color:rgba(153,153,153,1);
					}
					.index3-1>div:nth-of-type(4){
					width:970px;
					margin-top: 20px;
					font-size:22px;
					font-weight:400;
					text-align: center;
					color:rgba(153,153,153,1);
					line-height:35px;
							}
					.index3-1>div:nth-of-type(5){
					width:222px;
					height:60px;
					margin-top: 40px;
					font-size:19px;
					font-weight:400;
					color:rgba(255,255,255,1);
					line-height:60px;
					text-align: center;
					background:rgba(208,124,124,1);
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
</style>
