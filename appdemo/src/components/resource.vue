<template>
	<div>
		<v-head></v-head>
		<div class="resorce1">
			<div class="resorce1-1">
				<input placeholder="Bitcoin exchange rate" />
				<div>
					<img src="../../static/fangda.png" />
					<span>Search</span>
				</div>
			</div>
		</div>
		<div class="resorce2">
			<div class="resorce2-1">
				<div class="img1"></div>
				<div class="div1">
					<div style="margin-left: 40px;">
						<div class="z1">
							What is Blockchain?
							<br />
							World Economic Forum
							<br />
							(2.19 minutes)
						</div>
						<div class="z2">Blockchain is a form of distributed ledger technology that links together</div>
						<div class="z3">
							transaction and other information in cryptographic chain that cannot be altered. This gives all authorised participants full confidence in the security
							and authenticity of the records.
						</div>
					</div>
				</div>
			</div>
			<div class="resorce2-1">
				<div class="div1">
					<div style="margin-left: 40px;">
						<div class="z1">
							Don Tapscott
							<br />
							Author of “The Blockchain
							<br />
							Revolution”
						</div>
						<div class="z2">Blockchain is a form of distributed ledger technology that links together</div>
						<div class="z3">
							transaction and other information in cryptographic chain that cannot be altered. This gives all authorised participants full confidence in the security
							and authenticity of the records.
						</div>
					</div>
				</div>
				<div class="img2"></div>
			</div>
			<div class="resorce2-1">
				<div class="img3"></div>
				<div class="div1">
					<div style="margin-left: 40px;">
						<div class="z1">
							How to trade
							<br />
						by AAC)
							<br />
						</div>
						<div class="z2">Blockchain is a form of distributed ledger technology that links together</div>
						<div class="z3">
							transaction and other information in cryptographic chain that cannot be altered. This gives all authorised participants full confidence in the security
							and authenticity of the records.
						</div>
					</div>
				</div>
			</div>
		</div>
		<v-foot style="margin-top: 51px;"></v-foot>
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

<style>
.z1 {
	font-size: 30px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	line-height: 36px;
}
.z2 {
	font-size: 15px;
	font-weight: bold;
	color: rgba(102, 102, 102, 1);
	line-height: 27px;
	margin-top: 17px;
}
.z3 {
	font-size: 15px;
	font-weight: bold;
	color: rgba(153, 153, 153, 1);
	line-height: 27px;
}
.resorce2 {
	display: flex;
	margin-top: 32px;
	flex-direction: column;
	align-items: center;
}
.img1 {
	background-image: url('../../static/rimg1.png');
	background-size: 100%;
	width: 600px;
	height: 360px;
}
.img2 {
	background-image: url('../../static/rimg2.png');
	background-size: 100%;
	width: 600px;
	height: 360px;
}
.img3 {
	background-image: url('../../static/rimg3.png');
	background-size: 100%;
	width: 600px;
	height: 360px;
}
.div1 {
	width: 600px;
	height: 360px;
	display: flex;
	justify-content: center;
	flex-direction: column;
	background: rgba(255, 255, 255, 1);
}
.resorce2-1 {
	display: flex;
}
.resorce1 {
	width: 100%;
	height: 78px;
	background: rgba(46, 46, 46, 1);
	border-radius: 1px;
	display: flex;
	justify-content: center;
	align-items: center;
}
.resorce1-1 > input {
	width: 804px;
	height: 48px;
	background: rgba(247, 247, 247, 1);
	font-size: 19px;
	font-weight: 400;
	color: rgba(153, 153, 153, 0.43);
	padding-left: 35px;
}
.resorce1-1 > div {
	width: 133px;
	display: flex;
	justify-content: center;
	align-items: center;
	background: rgba(255, 227, 145, 1);
}

.resorce1-1 > div > img {
	width: 23px;
	height: 23px;
}
.resorce1-1 > div > span {
	font-size: 19px;
	font-weight: 400;
	margin-left: 10px;
	color: rgba(51, 51, 51, 1);
}
.resorce1-1 {
	display: flex;
}
</style>
