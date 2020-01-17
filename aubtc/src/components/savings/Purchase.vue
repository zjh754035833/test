<template>
	<div class="pruchaseall">
		<div class="pruchaseaone">
			<div class="pruchaseaone-1">
				<div class="pruchaseaone-1-1">
					<div style="margin-top: 22px;margin-left: 31px;">
						<div class="pruchaseaone-1-1-1">Details</div>
						<div class="pruchaseaone-1-1-2">
							<div class="pruchaseaone-1-1-2-1">
								<div>
									2.59
									<span style="font-size: 26px;">%</span>
								</div>
								<div>Expected Return</div>
							</div>
							<div class="pruchaseaone-1-1-2-2"></div>
							<div class="pruchaseaone-1-1-2-1">
								<div style="color: rgba(41, 47, 136, 1);">
									30
									<span style="font-size: 26px;">Days</span>
								</div>
								<div>Investment horizon</div>
							</div>
						</div>
						<div class="pruchaseaone-1-1-3">Repayment of principle and interest at maturity</div>
					</div>
				</div>
				<div class="pruchaseaone-1-2">
					<div style="margin-left: 31px;margin-top: 22px;">
						<div class="pruchaseaone-1-2-1">Investment Now</div>
						<div class="pruchaseaone-1-2-2">
							<div>
								<span>$</span>
								<input />
							</div>
							<div>Buy Now</div>
						</div>
						<div class="pruchaseaone-1-2-3">Minimum purchase amount: 1000AUD</div>
						<div class="pruchaseaone-1-2-4">
							<span>Available Balance:</span>
							<span>$0.11</span>
							<span>Deposit</span>
						</div>
					</div>
				</div>
			</div>
			<div class="pruchaseaone-2">
				<div style="height: 21px;"></div>
				<div class="pruchaseaone-2-1">Project Cycle</div>
					<div class="google2">
						<div v-for="(item, index) in numlist" :key="index">
							<div :class="[item.type == 'halfon' ? 'google2-1blue' : 'google2-1']" v-if="item.type != 'on'">{{ item.num }}</div>
							<div :class="[item.type == 'halfon' ? 'google2-4blue' : 'google2-4']">{{ item.text }}
							<br />
							{{ item.text1 }}
							
							</div>
							<div class="google2-2"></div>
						</div>
					</div>
					<div class="xianx"></div>
				<div class="pruchaseaone-2-2">
					<div>NOTE：</div>
					<li>No early redemption</li>
					<li>
						Using T + 1 calculation method, the calculation of profit start date is calculated on working days. If the
						purchase encounters a weekend or holiday, the profit is calculated on the first working day after the holiday ends.
					</li>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			numlist: [
				{ num: '1', text: '2020-01-20', type: 'halfon',text1:" Subscription date" },
				{ num: '2', text: '2020-01-21 ', type: 'off',text1:"Value date"  },
				{ num: '3', text: '2020-02-20 ', type: 'off' ,text1:"Maturity date" },
				{ num: '4', text: '2020-02-21 ', type: 'off' ,text1:"Settlement date" }
			]
		};
	},

	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {}
};
</script>

<style scoped="scoped" src="./Purchase.css"></style>
