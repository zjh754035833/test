<template>
	<div class="all">
		<div class="loginz">
			<img src="../../static/loginsu.png" />
			<input class="half2" placeholder="用户名" @input="usename" />
			<input class="half3" placeholder="密码" type="password" @input="usepassword" />
			<div class="denglu shou" @click="login()">登录</div>
		</div>
	</div>
</template>

<script>
import https from '../https.js';
export default {
	components: {},
	data() {
		return {
			usenameval: '',
			passwordval: ''
		};
	},
	computed: {},
	mounted() {
	var token = localStorage.getItem('token');
		if (token != null & token != '') {
			this.isadmin(token)
		}
		
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		isadmin(e) {
			let param = { token: e };
			https.fetchGet('/isAdmin', param).then(data => {
				window.console.log(data);
				if (data.data.state == 0) {
				localStorage.removeItem('token')
				} else if (data.data.state == 1) {
						this.$router.push({ path: '/Artboard' });
				}
			});
		},
		usename(e) {
			this.usenameval = e.target.value;
		},
		usepassword(e) {
			this.passwordval = e.target.value;
		},
		login() {
			let params = { user_name: this.usenameval, pass_word: this.passwordval };
			https
				.fetchGet('/login', params)
				.then(data => {
					window.console.log(data);
					if (data.data.state == '0') {
						this.$alert(data.data.msg, {
							confirmButtonText: '确定'
						});
						return false;
					} else if (data.data.state == '1') {
						localStorage.setItem('token', data.data.token);
						this.$router.push({ path: '/Artboard' });
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
.denglu {
	width: 386px;
	height: 54px;
	background: rgba(0, 161, 233, 1);
	text-align: center;
	margin-top: 68px;
	font-size: 18px;
	line-height: 54px;
	font-weight: 500;
	color: rgba(255, 255, 255, 1);
	border-radius: 4px;
}
::-webkit-input-placeholder {
	/*Chrome/Safari*/
	color: rgba(153, 153, 153, 1);
}
::-moz-placeholder {
	/*Firefox*/
	color: rgba(153, 153, 153, 1);
}
::-ms-input-placeholder {
	/*IE*/
	color: rgba(153, 153, 153, 1);
}
.half2 {
	margin-top: 100px;
	width: 386px;
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	font-size: 16px;
	color: rgba(51, 51, 51, 1);
}
.half3 {
	margin-top: 88px;
	width: 386px;
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	font-size: 16px;
	color: rgba(51, 51, 51, 1);
}
.all {
	background-image: url('../../static/loginbj.png');
	background-position: center 0;
	background-size: cover;
	width: 100%;
	min-height: 100vh;

	overflow: hidden;
}
.loginz {
	width: 527px;
	height: 554px;
	display: flex;
	flex-direction: column;
	position: absolute;
	left: 0;

	right: 0;

	top: 0;

	bottom: 0;
	margin: auto;
	align-items: center;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 8px 14px 0px rgba(50, 150, 251, 0.32);
	border-radius: 7px;
}
.loginz > img {
	width: 198px;
	height: 77px;
	margin-top: 67px;
}
</style>
