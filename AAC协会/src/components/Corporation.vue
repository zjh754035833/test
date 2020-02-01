<template>
	<div>
		<img src="../../static/user1.png" class="individ1" />
		<div style="display: flex;margin-top: 43px;align-items: center;flex-direction: column;">
			<div class="individual3">

				<li>engage with and learn from other businesses implementing Cryptocurrency solutions;</li>
				<li>share best-practice and collaborate as appropriate;</li>
				<li>access national and global thought-leaders;</li>
				<li>contribute to Australia's Cryptocurrency advocacy agenda with key government and regulatory stakeholders;</li>
				<li>participate in Cryptocurrency Australia conferences, workshops and study tours.</li>
			</div>
			
		</div>
		<div style="display: flex;justify-content: center;">
		<div class="individual4" >
			<input placeholder="Company name" v-model="companyval"/>
			<input placeholder="Contact name" v-model="contactval"/>
			<input type="number" placeholder="Telephone(optional)" v-model="telephoneval"/>
			<input placeholder="Email" v-model="emailval"/>
			<input placeholder="Content" v-model="contentval"/>
			<div class="subilt shou" @click="sublim">SUBMIT</div>
		</div>
		</div>
		<div style="margin-bottom: 42px;"></div>
	</div>
</template>

<script>
	import https from '../https.js';
	var regemal = /^[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*@[a-zA-Z0-9]+([-_.][a-zA-Z0-9]+)*\.[a-z]{2,}$/;
export default {
	components: {
	},
	data() {
		return {
			companyval:"",
			contactval:"",
			telephoneval:"",
			emailval:"",
			contentval:""
		};
	},
	computed: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},/* Message/updateStatus */
	methods: {
		sublim(){
			if (!regemal.test(this.emailval)) {
			this.$alert('Incorrect email format', {
				confirmButtonText: 'OK'
			});
			return false;
			}else{
				if(this.contentval==null){
					this.$alert('Incomplete information', {
						confirmButtonText: 'OK'
					});
					return false
				}
			/* 	if(this.companyval==""||this.contentval==""||this.emailval==""||this.contentval==""){
					this.$alert('Incomplete information', {
						confirmButtonText: 'OK'
					});
					return false;
				} */
				const loading = this.$loading({
					lock: true,
					text: 'loading',
					spinner: 'el-icon-loading',
					background: 'rgba(0, 0, 0, 0.7)'
				});
				let fromNickName =this.emailval;
				let toEmail="contact@auscrypto.org";
				let subject="corporationapplication-("+this.companyval+")";
				let text=this.companyval+","+this.contactval+","+this.contentval+",telephone:"+this.telephoneval+",email:"+this.emailval;
				let params = {domainName:"auscrypto.org", fromNickName: fromNickName, fromEmail: toEmail, subject: subject,text:text, toEmail:"contact@auscrypto.org"};
			
				https
					.fetchPost('Message/resendEmail', params)
					.then(data => {
						window.console.log(data);
						loading.close();
						if (data.data.message == 'Queued. Thank you.') {
							this.$alert("sucess", {
								confirmButtonText: 'OK'
							});
						} else {
							this.$alert(data.data.msg, {
								confirmButtonText: 'OK'
							});
							return false;
						}
					})
					.catch(err => {
						window.console.log(err);
					});
		}
	}
	},
	created() {}
};
</script>

<style scoped="scoped">
	.individual4{
		display: flex;
		flex-direction: column;
		align-items: center;
		
	}
	.subilt{
		margin-top: 35px;
		font-size:15px;
		width:142px;
		height:47px;
		border:1px solid rgba(51,51,51,1);
		text-align: center;
		line-height: 47px;
	}
	.individual4>input{
		margin-top: 27px;
		padding-left: 25px;
		width:787px;
		height:48px;
		background:rgba(247,247,247,1);
		border-radius:1px;
		border:1px solid rgba(218,218,218,1);
		font-size:15px;
	}
.individual4>input:nth-of-type(5){
	margin-top: 27px;
	padding-left: 25px;
	width:787px;
	background:rgba(247,247,247,1);
	border-radius:1px;
	border:1px solid rgba(218,218,218,1);
	font-size:15px;
	height:88px;
}
	.individual3>li{
		margin-top: 23px;
		color: rgba(51, 51, 51, 1);
		font-size: 18px;
		
	}
	.individual3{
		
	}
.individ1 {
	width: 100%;
}
.individual2 {
	font-size: 22px;
	font-weight: 500;
	color: rgba(51, 51, 51, 1);
	margin-left: 143px;
}
</style>
