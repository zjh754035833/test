<template>
	<div>
		<div class="area">
			<v-sell ></v-sell>
			<div class="halfareall">
			<div class="halfarea" >
				<img src="../../../static/auseelogo.png" />
				<input class="half2" placeholder="Email"   @input="useemail" />
				<input class="half3"  placeholder="password"  type="password"   @input="usepassword"/>
				<div  @click="formyaccount"  :class="[iswrite?'half6blue shou':'half6 shou']">Log in</div>
				<div class="half5">Forgot password?</div>
			</div>
			</div>
		</div>
	</div>
</template>

<script>
import sell from '../../assembly/sell/sell.vue';
import https from '../../https.js';
export default {
	data() {
		return {
			clientHeight: '',
			emailval: '',
			passwordval: '',
			iswrite:false
		};
	},

	components: {
		'v-sell': sell
	},
	methods: {
		useemail(e) {
			this.emailval = e.target.value;
			if(this.emailval!=""&this.passwordval!=""){
				this.iswrite=true
			}else{
				this.iswrite=false
			}
		},
		usepassword(e) {
			this.passwordval = e.target.value;
			if(this.emailval!=""&this.passwordval!=""){
				this.iswrite=true
			}else{
				this.iswrite=false
			}
		},
		hrefsignup() {
			this.$router.push({ path: '/signup' });
		},
		formyaccount() {
		/* 	let regEnUp = /[A-Z]+/; //大写字母
			let regNum = /[0-9]+/; //数字 */
		
			let params = { username: this.emailval, password: this.passwordval };
			https
				.fetchPost('/account/signIn', params)
				.then(data => {
					window.console.log(data);
					if(data.data.token!=""&data.data.token!=null){
							localStorage.removeItem('clicksell')
							localStorage.setItem('token',data.data.token); 
							this.$router.push({ path: '/Myaccount' })
					}else{
						this.$alert(data.data.msg, {
							confirmButtonText: 'Determine'
						});
					}
				})
				.catch(err => {
					window.console.log(err);
				});
		/* 	localStorage.removeItem('clicksell')
			localStorage.setItem('loginstate',1); */
		//	this.$router.push({ path: '/Myaccount' });
		}
	}
};
</script>

<style src="./login.css" scoped >





</style>
