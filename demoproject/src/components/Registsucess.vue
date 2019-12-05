<template>
	<div>
		<v-sell></v-sell>
		<div class="success">
			<img src="../../static/sucess.png" />
			<div>Account activated</div>
			<div>Congratulations! Your Auwels account has been activated. Please log in to start trading.</div>
			<div @click="forlogin" class="shou">Log ln</div>
		</div>
		
		<v-footer style="margin-top: 88px;"></v-footer>
	</div>
</template>
<script>
import sell from '../assembly/sell/sell.vue';
import footer from '../assembly/foot/foot.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer
	},
	data() {
		return {};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods:{
		forlogin(){
			this.$router.push({ path: '/login' });
		}
	}
};
</script>
<style>
.success {
	width: 1169px;
	height: 599px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 48px;
	margin-left: 142px;
	display: flex;
	flex-direction: column;
	align-items: center;
	
}
.success>img{
	width:266px;
	height:209px;
	margin-top: 76px;
}
.success>div:nth-of-type(1){
	font-size:30px;
	font-weight:600;
	color:rgba(51,51,51,1);
	margin-top: 40px;
}
.success>div:nth-of-type(2){
	font-size:18px;
	font-weight:600;
	color:rgba(153,153,153,1);
	margin-top: 9px;
}
.success>div:nth-of-type(3){
	width:534px;
	height:58px;
	background:rgba(0,195,255,1);
	border-radius:1px;
	font-size:22px;
	color:rgba(255,255,255,1);
	line-height:58px;
	text-align: center;
	margin-top: 37px;
}
</style>
