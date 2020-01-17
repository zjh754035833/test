<template>
	<div>
		<div class="savingall">
			<div class="savingtop"><img src="../../../static/indeximgsaving.png" /></div>
			<div class="savinghalf">
				<div  v-for="(item,index) in savinglist" :key="index"  >
				<div :class="[item.ismove == false ? 'savingwhite' : 'savingblue']" @mouseenter="mouall(index)" @mouseleave="leaveall(index)">
				<div :class="[item.ismove == false ? 'savingwhiteall' : 'savingblueall']">
				<div :class="[item.ismove == false ? 'savingwhite-1' : 'savingblue-1']">{{item.per}}%</div>
				<div :class="[item.ismove == false ? 'savingwhite-2' : 'savingblue-2']" >{{item.days}}30 Days</div>
				<div :class="[item.ismove == false ? 'savingwhite-3' : 'savingblue-3']">Minimum amount {{item.aud}} AUD</div>
				<div  :class="[item.ismove == false ? 'savingwhite-4' : 'savingblue-4']" @click="forpurchase(item.index)">Purchase</div>
				</div>
				</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	components: {
	},
	data() {
		return {
			savinglist:[
				{
					per:2.59,
					days:30,
					aud:2000,
					ismove:false,
				},
				{
					per:2.99,
					days:60,
					aud:3000,
					ismove:false,
				},
				{
					per:3.99,
					days:90,
					aud:4000,
					ismove:false,
				},
				{
					per:4.99,
					days:365,
					aud:5000,
					ismove:false
				},
			]
		};
	},

	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods:{
		forpurchase(){
			this.$router.push({ path: '/Purchase' });
		},
		mouall(e){
			window.console.log(e)
			this.savinglist[e].ismove=true
		},
		leaveall(e){
			window.console.log(e)
			this.savinglist[e].ismove=false
		}
	}
};
</script>

<style scoped="scoped" src="./Saving.css">
</style>
