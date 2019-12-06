<template>
	<div>
		<v-sell></v-sell>
		<div class="placedatail1">
			<div class="placedatail1-1">
				<div class="placedatail1-2">
					<div class="placedatail1-2-1">
						<span>BTC</span>
						<span>/USDT</span>
					</div>
					<div class="placedatail1-2-2">serial number 090098</div>
					<div class="placedatail1-2-3">seller：ad4789</div>
					<div class="placedatail1-2-4">
						In order to ensure that the package price is competitive in the market, the price of the product will be dynamically adjusted according to market
						conditions, demand and mining difficulty. This is one of the advantages of BitDeer over other platforms.
					</div>
					<div class="placedatail1-2-5">
						<span>REMAINING</span>
						<span>{{ h }}</span>
						<span>：</span>
						<span>{{ m }}</span>
						<span>：</span>
						<span>{{ s }}</span>
					</div>
				</div>
				<div class="placedatail1-3">
					<div>
						<span>Current bid：</span>
						<span>$8449.55</span>
						<span @click="forhistory" class="shou">4 bids</span>
					</div>
					<div>
						<div>
							<span>$</span>
							<input @input="detalvalue"/>
						</div>
						<div class="shou" @click="yzPlacebid">Place bid</div>
					</div>
					<div v-if="yzPlacebidsy==true">Bid increment $10</div>
					<div>Enter  $8500 or more and  bid increment $10</div>
					<div>
						<div></div>
						<div v-if="yzPlacebidsy==true">Bid incremen:ExplanationExplanation</div>
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="">
			<div class="">
				<div>{{ h }}</div>
				<div>:</div>
				<div>{{ m }}</div>
				<div>:</div>
				<div>{{ s }}</div>
			</div>
		</div> -->
		<div style=""><v-footer></v-footer></div>
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
		return {
			h: '00',
			m: '00',
			s: '00',
			yzPlacebidsy:false,
			detalvaluereal:""
		};
	},
	methods: {
		detalvalue(e){
			this.detalvaluereal=e.target.value;
		},
		yzPlacebid(){
			if(this.detalvaluereal==""){
				this.yzPlacebidsy=true
			}else{
				this.yzPlacebidsy=false
			}
		},
		forhistory(){
			this.$router.push({ path: '/historybid' });
		},
		getParams() {
			// 取到路由带过来的参数
			this.seat = this.$route.query.val;
			window.console.log(this.seat);
		},
		countTime: function() {
			//获取当前时间
			var date = new Date();
			var now = date.getTime();
			//设置截止时间
			var endDate = new Date('2020-12-22 23:23:23');
			var end = endDate.getTime();
			//时间差
			var leftTime = end - now;
			//定义变量 d,h,m,s保存倒计时的时间
			if (leftTime >= 0) {
				this.h = Math.floor((leftTime / 1000 / 60 / 60) % 24);
				this.m = Math.floor((leftTime / 1000 / 60) % 60);
				this.s = Math.floor((leftTime / 1000) % 60);
				if (this.h < 10) {
					this.h = '0' + this.h;
				}
				if (this.m < 10) {
					this.m = '0' + this.m;
				}
				if (this.s < 10) {
					this.s = '0' + this.s;
				}
			} else {
				this.h = '00';
				this.m = '00';
				this.s = '00';
			}
			//递归每秒调用countTime方法，显示动态时间效果
			setTimeout(this.countTime, 1000);
		}
	},

	mounted() {
		this.getParams();
		this.countTime();
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	}
};
</script>

<style scoped="scoped">
.placedatail1-3 > div:nth-of-type(1) {
	margin-top: 31px;
	margin-left: 34px;
}
.placedatail1-3 > div:nth-of-type(1) > span:nth-of-type(1) {
	font-size: 20px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.placedatail1-3 > div:nth-of-type(1) > span:nth-of-type(2) {
	font-size: 23px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
}
.placedatail1-3 > div:nth-of-type(2) {
	display: flex;
	margin-top: 30px;
}
.placedatail1-3 > div:nth-of-type(2) > div:nth-of-type(1) {
	width: 178px;
	height: 45px;
	background: rgba(255, 255, 255, 1);
	border-radius: 2px;
	margin-left: 163px;
	font-size: 21px;
	padding-left: 17px;
	display: flex;
	align-items: center;
	border: 1px solid rgba(226, 226, 226, 1);
}
.placedatail1-3 > div:nth-of-type(2) > div:nth-of-type(1) > input {
	border: none;
	outline: medium;
	color: rgba(51, 51, 51, 1);
	font-size: 21px;
}
.placedatail1-3 > div:nth-of-type(2) > div:nth-of-type(2) {
	width: 117px;
	height: 45px;
	font-size: 17px;
	color: rgba(255, 255, 255, 1);
	text-align: center;
	line-height: 45px;
	background: rgba(238, 66, 86, 1);
	border-radius: 2px;
}
.placedatail1-3 > div:nth-of-type(1) > span:nth-of-type(3) {
	text-decoration: underline;
	font-size: 17px;
	font-weight: 400;
	color: rgba(0, 195, 255, 1);
	margin-left: 16px;
}
.placedatail1-3>div:nth-of-type(3){
	font-size:18px;
	margin-left: 163px;
	text-decoration: underline;
	margin-top: 18px;
	font-weight:400;
	color:rgba(238,66,86,1);
}
.placedatail1-3>div:nth-of-type(5){
	margin-left: 163px;
	margin-top: 12px;
	display: flex;
	align-items: center;
}
.placedatail1-3>div:nth-of-type(5)>div:nth-of-type(1){
	width:6px;
	height:6px;
	background:rgba(153,153,153,1);
	border-radius:6px;
}
.placedatail1-3>div:nth-of-type(5)>div:nth-of-type(2){
	font-size:15px;
	font-weight:400;
	color:rgba(153,153,153,1);
	margin-left: 10px;
}
.placedatail1-3>div:nth-of-type(4){
	font-size:18px;
	margin-left: 163px;
	margin-top: 11px;
	font-weight:400;
	color:rgba(51,51,51,1);
}
.placedatail1-3 {
	width: 563px;
	height: 348px;
	background: rgba(246, 246, 246, 1);
	border-radius: 2px;
	display: inline-block;
	margin-left: 61px;
	position: absolute;
	margin-top: 105px;
}
.placedatail1-2-5 > span:nth-of-type(1) {
	font-size: 18px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
}
.placedatail1-2-5 > span:nth-of-type(2) {
	margin-left: 36px;
}
.placedatail1-2-5 > span {
	font-size: 25px;
	font-weight: bold;
	color: rgba(0, 195, 255, 1);
}
.placedatail1-2-5 {
	margin-top: 19px;
	width: 393px;
	height: 74px;
	background: rgba(246, 246, 246, 1);
	border-radius: 2px;
	display: flex;
	justify-content: center;
	align-items: center;
}
.placedatail1-2-4 {
	width: 430px;
	margin-top: 24px;
	font-size: 17px;
	color: rgba(102, 102, 102, 1);
	line-height: 24px;
}
.placedatail1-2-3 {
	margin-top: 23px;
	font-size: 18px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
}
.placedatail1-2-2 {
	margin-top: 12px;
	font-size: 18px;
	color: rgba(153, 153, 153, 1);
}
.placedatail1-2 {
	margin-top: 90px;
	margin-left: 55px;
	display: inline-block;
}
.placedatail1-2-1 > span:nth-of-type(1) {
	font-size: 31px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
}
.placedatail1-2-1 > span:nth-of-type(2) {
	font-size: 19px;
	color: rgba(153, 153, 153, 1);
}
.placedatail1-1 {
	width: 1146px;
	height: 634px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 17px 0px rgba(219, 219, 219, 0.5);
}
.placedatail1 {
	margin-top: 20px;
	display: flex;
	justify-content: center;
}
</style>
