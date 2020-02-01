<template>
	<div>
		<div class="all">
			<el-input v-model="emailval" placeholder="Please enter your email to be activated" class="xuanze"></el-input>
			<el-button type="primary" @click="queren" style="margin-top: 20px;">activation</el-button>
		</div>
	</div>
</template>

<script>
import https from '../https.js';
export default {
	components: {
	},
	data() {
		return {
			emailval: ''
		};
	},
	computed: {},
	mounted() {
		let text = this.$route.params.text;
		window.console.log(text)
		
		if(text !=null& text!=""){
			let params = { code: text };
			https
				.fetchPost('/account/verifyEmail', params)
				.then(data => {
					window.console.log(data.data);
					if(data.data.msg=="SUCCESS"){
						this.$alert('Successful activation', {
							confirmButtonText: 'OK'
						});
						this.$router.push({ path: '/login' });
					}else{
						this.$alert('Please enter email to resend activation', {
							confirmButtonText: 'OK'
						});
					}
				})
				.catch(err => {
					window.console.log(err);
				});
		}
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		queren() {
				let params = { email: this.emailval };
				https
					.fetchPost('/account/sendVerifyEmail', params)
					.then(data => {
						window.console.log(data.data.msg);
						if(data.data.msg=="SUCCESS"){
							this.$alert('Send successfully', {
								confirmButtonText: 'OK'
							});
						}else{
							this.$alert('fail in send', {
								confirmButtonText: 'OK'
							});
						}
					})
					.catch(err => {
						window.console.log(err);
					});
		}
	},
	created() {}
};
</script>

<style scoped="scoped">
.all {
	display: flex;
	flex-direction: column;
	align-items: center;
	margin-top: 100px;
}
.xuanze {
	width: 60%;
}
</style>
