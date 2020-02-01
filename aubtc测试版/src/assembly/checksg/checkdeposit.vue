<template>
	<div>
		<el-dialog title="" :visible.sync="dialogTableVisible2" width="55%" style=" height: 85%;" @close="closedepositdiag" top="10%">
			<div class="checkdepositall">
				<img src="../../../static/crytow.png"  v-if="isblue==false"  @mouseenter="forcheckdeposital(1)" />
				<img src="../../../static/crytob.png"  v-if="isblue==true" @click="forcryto" />
				<img src="../../../static/fiatw.png"  v-if="isblue2==false"  class="checkdepositall-2" @mouseenter="forcheckdeposital(2)" />
				<img src="../../../static/fiatb.png" class="checkdepositall-2"  v-if="isblue2==true"  @click="forfiat"  />
			</div>
			<div class="checkdepositall2"></div>
		</el-dialog>
	</div>
</template>

<script>
	export default {
		components: {},
		data() {
			return {
				dialogTableVisible2: true,
				isblue:false,
				isblue2:false
			};
		},
		methods: {
			forcryto(){
				this.$router.push({ path: '/Crypto' });
			},
			forfiat(){
				this.$router.push({ path: '/Fiat' });
			},
			closedepositdiag() {
				this.$emit('funcdeposit', false);
			},
			forcheckdeposital(e){
				if(e==1){
					this.isblue=true
					this.isblue2=false
				}else if(e==2){
					this.isblue=false
					this.isblue2=true
				}
			}
			
		}
	};
</script>

<style scoped="scoped">
	.checkdepositall>img{
		width: 197px;
		height: 151px;
	}
	.checkdepositall-2{
		margin-left: 30px;
	}
	.checkdepositall{
		display: flex;
		justify-content: center;
		margin-top: 60px;
	}
	.checkdepositall2{
		height: 60px;
		}
</style>
