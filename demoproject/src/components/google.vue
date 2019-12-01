<template>
	<div>
		<v-sell></v-sell>
		<div class="sms1"><span>Security > Enabled SMS authenticator</span></div>
		<div class="google1">
			<el-steps :active="1" align-center finish-status="success">
				<el-step title="步骤1" ></el-step>
				<el-step title="步骤2" ></el-step>
				<el-step title="步骤3" ></el-step>
				<el-step title="步骤4" ></el-step>
			</el-steps>
		</div>
		<v-footer></v-footer>
	</div>
</template>

<script>
import sell from '../../build/sell/sell.vue';
import footer from '../../build/foot/foot.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer
	},
	data() {
		return {
			numberempty: false,
			phonenumber: ''
		};
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	}
};
</script>

<style>
	.el-step__title {
		color:rgba(217,217,217,1);
	}
.sms1 {
	width: 1440px;
	height: 60px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	font-size: 17px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
	line-height: 60px;
}
.sms1 > span {
	position: absolute;
	margin-left: 148px;
}
.google1 {
	width: 1169px;
	height: 291px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 23px;
	margin-left: 142px;
}
</style>
