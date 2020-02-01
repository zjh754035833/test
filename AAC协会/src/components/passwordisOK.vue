<template>
	<div>
		<div class="all">
			<div class="all-1">
				<div class="all-1-1">Reset  Password</div>
			
				<div class="all-1-4">
					<el-input placeholder="New password" v-model="passwordval" show-password class="xuanze" @input="usepassword" @blur="yspasswordval"></el-input>
						<div class="half3" v-if="tishi2 == true">At least 8 characters, must include UPPER CASE letters and numbers,Special characters can only contain'@#^*!?&%$-_'</div>
					<el-input placeholder="Confirm Password" v-model="confimpasswordbal" show-password class="xuanze" @input="confimpassword" @blur="ysconfimpassword" style="margin-top: 20px;"></el-input>
						<div class="half3" v-if="tishi3 == true">The two passwords are inconsistent</div>
				<div class="querenstyblue shou" @click="queren">Confirm rest</div>
					</div>
			<!-- <input v-model="passwordval" placeholder="newpassword" class="xuanze" @input="usepassword" @blur="yspasswordval">
			<div class="half3" v-if="tishi2 == true">At least 8 characters, must include UPPER CASE letters and numbers</div>
			<el-button type="primary" @click="queren" style="margin-top: 20px;">Reset</el-button> -->
			</div>
		</div>
	</div>
</template>

<script>
import https from '../https.js';
var reg = /^(?=.*?[a-z])(?=.*?[A-Z])(?=.*?\d)[a-zA-Z\d!#@*&.]*$/; //大写字母

export default {
	components: {
	},
	data() {
		return {
			passwordval: '',
			code:'',
			tishi2:false,
			confimpasswordbal:'',
			tishi3:false,
			iswrite:false
		};
	},
	computed: {},
	mounted() {
		let text = this.$route.params.text;
		this.code=text;
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		confimpassword(){
			if (this.confimpasswordbal!=this.passwordval) {
				this.tishi3 = true;
			} else {
				
				this.tishi3 = false;
			}
		},
		ysconfimpassword(){
			if (this.confimpasswordbal!=this.passwordval) {
				this.tishi3 = true;
			} else {
				this.tishi3 = false;
			}
		},
		yspasswordval() {
			if (!reg.test(this.passwordval)|| this.passwordval.length < 8  ) {
				this.tishi2 = true;
			} else {
				this.tishi2 = false;
			}
		},
		usepassword(e) {
			this.passwordval = e;
			if (!reg.test(this.passwordval)|| this.passwordval.length < 8 ) {
				this.tishi2 = true;
			} else {
				this.tishi2 = false;
			}
		},
		queren() {
			if (this.tishi2||this.tishi3||this.passwordval=="") {
			this.$alert('Incomplete information', {
				confirmButtonText: 'OK'
			});
			return false
			} 
			
				let params = { password: this.passwordval,code:this.code};
				https
					.fetchGet('/Message/forgetThePasswordEmail', params)
					.then(data => {
						window.console.log(data);
						if(data.data=="modify successfully"){
							this.$alert('Password reset succeeded', {
								confirmButtonText: 'OK'
							});
							this.$router.push({ path: '/login' });
						}else{
							this.$alert(data.data, {
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
	.querensty{
		line-height: 39px;
		text-align: center;
		font-size:14px;
		color:rgba(255,255,255,1);
		width:356px;
		height:39px;
		background:rgba(213,213,213,1);
		border-radius:1px;
		margin-top: 51px;
		}
		.querenstyblue{
			line-height: 39px;
			text-align: center;
			font-size:14px;
			color:rgba(255,255,255,1);
			width:356px;
			height:39px;
			background:darkblue;
			border-radius:1px;
			margin-top: 51px;
		}
	.half3{
		color: red;
		font-size: 14px;
	}
	.all-1-4{
		width:447px;
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
		height:296px;
		background:rgba(255,255,255,1);
		box-shadow:0px 2px 13px 0px rgba(0,0,0,0.09);
		margin-top: 20px;
	}
	.img1{
		width: 15px;
		height: 15px;
		}
	.all-1-3{
		width:380px;
		height:41px;
		font-size:14px;
		margin-left: 20px;
		font-weight:600;
		color:rgba(51,51,51,1);
	}
	.all-1-2{
		width:447px;
		height:65px;
		display: flex;
		justify-content: center;
		align-items: center;
		background:rgba(247,247,247,1);
		border-radius:2px;
		margin-top: 30px;
		border:1px solid rgba(218,218,218,1);
	}
	.all-1-1{
		font-size:23px;
		font-weight:bold;
		color:rgba(51,51,51,1);
		}
.all {
	display: flex;
	flex-direction: column;
	align-items: center;
}
.xuanze {
	border: none;
	outline: none;
	width:361px;
	border-bottom: #c0c0c0 1px solid;
}
/deep/.el-input__inner{
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	font-size: 15px;
	border-radius: 0px;
	color: rgba(51, 51, 51, 1);
}
/deep/.el-input--suffix .el-input__inner {
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	font-size: 15px;
	border-radius: 0px;
	color: rgba(51, 51, 51, 1);
}
.all-1{
	width:1158px;
	height:550px;
	margin-top: 45px;
	margin-bottom: 143px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	background:rgba(255,255,255,1);
	box-shadow:0px 2px 9px 0px rgba(220,220,220,0.5);
	border-radius:1px;
}
</style>
