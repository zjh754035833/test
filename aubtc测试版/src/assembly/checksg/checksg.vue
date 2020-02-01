<template>
	<div>
		<el-dialog title="" :visible.sync="dialogTableVisible" width="55%" style=" height: 85%;" @close="closediag">
			<div class="checksg1">To increase your account SECURITY, please enable 2FA.</div>
			<div class="checksg2">
				<div @click="forgoogle" class="shou">
					<div>Google</div>
					<div>Authentication</div>
				</div>
				
				<div @click="forsms" class="shou">
					<div>SMS</div>
					<div>Authentication</div>
				</div>
			</div>
			<div class="checksg3">I understand the risks for not enabling 2FA.</div>
			<div class="checksg4">Skip for now</div>
		</el-dialog>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			dialogTableVisible: true
		};
	},
	methods: {
		forgoogle() {
			this.$router.push({ path: '/google' });
		},
		forsms() {
			this.$router.push({ path: '/SMS' });
		},
		closediag() {
			this.$emit('func', false);
		}
	}
};
</script>

<style>
.checksg2 > div:nth-of-type(1) > div:nth-of-type(1) {
	font-size: 17px;
	font-weight: 600;
	margin-left: 38px;
	margin-top: 32px;
	color: rgba(51, 51, 51, 1);
}
.checksg2 > div:nth-of-type(1) > div:nth-of-type(2) {
	font-size: 17px;
	font-weight: 600;
	margin-left: 38px;
	margin-top: 9px;
	color: rgba(51, 51, 51, 1);
}
.checksg2 > div:nth-of-type(2) > div:nth-of-type(1) {
	font-size: 17px;
	font-weight: 600;
	margin-left: 38px;
	margin-top: 32px;
	color: rgba(51, 51, 51, 1);
}
.checksg2 > div:nth-of-type(2) > div:nth-of-type(2) {
	font-size: 17px;
	font-weight: 600;
	margin-left: 38px;
	margin-top: 9px;
	color: rgba(51, 51, 51, 1);
}
.checksg3 {
	margin-top: 30px;
	width: 100%;
	text-align: center;
	font-size: 16px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
}
.checksg4 {
	margin-top: 10px;
	width: 100%;
	text-align: center;
	font-size: 16px;
	font-weight: 400;
	color: rgba(238, 66, 86, 1);
}
.checksg2 > div:nth-of-type(1) {
	width: 270px;
	height: 129px;
	border-radius: 7px;
	background-image: url('../../../static/Googlepage.png');
	background-size: 100%;
}
.checksg2 {
	margin-top: 60px;
	display: flex;
	justify-content: center;
}
.checksg2 > div:nth-of-type(2) {
	width: 270px;
	height: 129px;
	border-radius: 7px;
	background-image: url('../../../static/SMSpage.png');
	background-size: 100%;
}
.checksg1 {
	width: 100%;
	text-align: center;
	font-size: 17px;
	font-weight: 600;
	color: rgba(102, 102, 102, 1);
}
</style>
