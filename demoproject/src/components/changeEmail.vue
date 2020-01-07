<template>
	<div>
		<v-sell></v-sell>
		<v-fillemail :typefillemail="typefillemail" FilltypeValue="FilltypeValue"></v-fillemail>
		<v-setpassword v-if="1 == 2"></v-setpassword>
		<v-setnewmail v-if="1 == 2"></v-setnewmail>
		<v-safequestion v-if="1 ==2"></v-safequestion>
		<v-securityquestions v-if="1 == 2"></v-securityquestions>
		<div class="changemailall">
			<div class="changemail1">
				<div class="changemail1-1">Change Email</div>
				<div class="changemail1-2">
					<div>NOTE</div>
					<div>
						You need to enable Google or mobile verification before changing your email.After the mailbox is replaced successfully, your withdrawal will be disabled for
						5 days.
					</div>
				</div>
				<div>
					<div class="changemail1-3">
						<img src="../../static/chagetu.png" />
						<span>1. Original email verification</span>
					</div>
					<div class="changemail1-3">
						<img src="../../static/chagetu.png" />
						<span>2. Fill in new email</span>
					</div>
					<div class="changemail1-3">
						<img src="../../static/chagetu.png" />
						<span>3. New email verification</span>
					</div>
				</div>
				<div class="changemail1-6" @click="fornext">Next</div>
				<div class="changemail1-7">Lost Current Email</div>
			</div>
		</div>
		<v-footer style="margin-top: 30px;"></v-footer>
	</div>
</template>

<script>
import sell from '../assembly/sell/sell.vue';
import footer from '../assembly/foot/foot.vue';
import fillemail from '../assembly/emaillall/Fillemail.vue';
import setpassword from '../assembly/emaillall/setpassword.vue';
import setnewmail from '../assembly/emaillall/setnewmail.vue';
import safequestion from '../assembly/emaillall/Safequestion.vue';
import securityquestions from '../assembly/emaillall/securityquestions.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer,
		'v-fillemail': fillemail,
		'v-setpassword': setpassword,
		'v-setnewmail': setnewmail,
		'v-safequestion': safequestion,
		'v-securityquestions': securityquestions
	},
	data() {
		return {
			typefillemail: false
		};
	},
	methods: {
		fornext() {
			this.typefillemail = true;
		},
		FilltypeValue: function(childValue) {
			// childValue就是子组件传过来的值
			this.typefillemail = childValue;
		}
	},

	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	}
};
</script>

<style scoped="scoped">
.changemail1-7 {
	font-size: 20px;
	font-weight: 400;
	color: rgba(0, 195, 255, 1);
	margin-top: 29px;
	text-decoration: underline;
}
.changemail1-6 {
	width: 534px;
	height: 58px;
	background: rgba(0, 195, 255, 1);
	border-radius: 1px;
	color: rgba(255, 255, 255, 1);
	font-size: 22px;
	line-height: 58px;
	text-align: center;
	margin-top: 75px;
}
.changemail1-3 {
	display: flex;
	align-items: center;
	margin-top: 52px;
}
.changemail1-3 > img {
	width: 11px;
	height: 19px;
}
.changemail1-3 > span {
	font-size: 20px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
	margin-left: 21px;
}
.changemail1-2 > div:nth-of-type(1) {
	font-size: 20px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-left: 30px;
	margin-top: 14px;
}
.changemail1-2 > div:nth-of-type(2) {
	font-size: 18px;
	font-weight: bold;
	color: rgba(153, 153, 153, 1);
	margin-left: 30px;
}
.changemail1-1 {
	font-size: 30px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-top: 48px;
}
.changemail1-2 {
	width: 792px;
	height: 99px;
	background: rgba(246, 246, 246, 1);
	border-radius: 2px;
	margin-top: 27px;
}
.changemailall {
	display: flex;
	justify-content: center;
}
.changemail1 {
	width: 1169px;
	height: 686px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 10px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 20px;
	display: flex;
	flex-direction: column;
	align-items: center;
}
</style>
