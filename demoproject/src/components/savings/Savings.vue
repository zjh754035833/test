<template>
	<div>
		<v-sell></v-sell>
		<div class="savingall">
			<div class="savingtop"><img src="../../../static/indeximg1.png" /></div>
			<div class="savinghalf">
				<div class="savinghalf-1">
					<div></div>
					<div>My investment  </div>
					<div>Click Login to view assets</div>
					<div>introduction</div>
					<div>Details</div>
				</div>
				<div class="savinghalf-2">
					<div :class="[gentype1 == 'on' ? 'savinghalf-1-2' : 'savinghalf-1-3 ']"    @mouseenter="forblue(1)" >
						<div>
					
						<span v-if="gentype1 == 'on'">Investment Assets=</span>
						<span style="color:rgba(102,102,102,1);" v-if="gentype1 == 'off'">Investment Assets=</span>
						</div>
						<div style="margin-top: 26px;"><span >678 </span><span style="font-size: 15px;">AUD</span></div>
					</div>
					<div :class="[gentype2 == 'on' ? 'savinghalf-1-2' : 'savinghalf-1-3 ']" @mouseenter="forblue(2)">
						<div>
							<span v-if="gentype2 == 'on'">Cumulative Income=</span>
						<span style="color:rgba(102,102,102,1);" v-if="gentype2 == 'off'">Cumulative Income=</span>
						</div>
						<div style="margin-top: 26px;"><span>678 </span><span style="font-size: 15px;">AUD</span></div>
					</div>
				</div>
				<div class="savinghalf-3">
					<div :class="[halftype1 == 'on' ? 'savinghalf-3-black' : 'savinghalf-3-white ']"  @mouseenter="forblack(1)">
						<div class="savinghalf-3-whiteall">
							<img src="../../../static/clipboardcopy.png" v-if="halftype1 == 'on'" />
							<img src="../../../static/clipboard.png" v-if="halftype1 != 'on'"/>
						<div>30 Days</div>
						<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sit amet..</div>
						<div class="shou">Buy More</div>
						</div>
					</div>
					<div :class="[halftype2 == 'on' ? 'savinghalf-3-black' : 'savinghalf-3-white ']"  @mouseenter="forblack(2)">
						<div class="savinghalf-3-whiteall">
							<img src="../../../static/target.png"  v-if="halftype2 != 'on'" />
							<img src="../../../static/targetcopy.png" v-if="halftype2 == 'on'" />
						<div>60 Days</div>
						<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sit amet..</div>
						<div class="shou">Buy More</div>
						</div>
					</div>
					<div :class="[halftype3 == 'on' ? 'savinghalf-3-black' : 'savinghalf-3-white ']"  @mouseenter="forblack(3)">
						<div class="savinghalf-3-whiteall">
							<img src="../../../static/shenbao.png"  v-if="halftype3 == 'on'" />
							<img src="../../../static/shenbaox.png" v-if="halftype3 != 'on'" />
						<div>90 Days</div>
						<div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis sit amet..</div>
						<div class="shou">Buy More</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div style="margin-top: 80px;"><v-footer></v-footer></div>
	</div>
</template>

<script>
import sell from '../../assembly/sell/sell.vue';
import footer from '../../assembly/foot/foot.vue';
export default {
	components: {
		'v-sell': sell,
		'v-footer': footer
	},
	data() {
		return {
			styletype:"2",
			gentype1:"on",
			gentype2:"off",
			halftype1:"on",
			halftype2:"off",
			halftype3:"off"
		};
	},
	created() {
		localStorage.setItem('clicksell', 3);
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods:{
		forblack(e){
			if(e==1){
				this.halftype1="on"
				this.halftype2="off"
				this.halftype3="off"
			}else if(e==2){
				this.halftype1="off"
				this.halftype2="on"
				this.halftype3="off"
			}else if(e==3){
				this.halftype1="off"
				this.halftype2="off"
				this.halftype3="on"
			}
		},
		forblue(e){
			if(e==1){
				this.gentype1="on"
				this.gentype2="off"
			}else if(e==2){
				this.gentype1="off"
				this.gentype2="on"
			}
		},
		forkuang(e){
			this.styletype=e
		},
		leavekuang(){
			this.styletype="2"
		}
	}
};
</script>

<style scoped="scoped" src="./Saving.css">
</style>
