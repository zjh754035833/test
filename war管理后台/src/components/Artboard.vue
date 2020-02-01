<template>
	<div>
		<v-admin v-if="admin == 'y'"></v-admin>
		<v-user v-if="admin == 'n'"></v-user>
	</div>
</template>

<script>
var token;
import https from '../https.js';
import user from '../assets/user.vue';
import admin from '../assets/admin.vue';
export default {
	components: {
		'v-admin': admin,
		'v-user': user
	},
	data() {
		return {
			admin: ''
		};
	},
	computed: {},
	mounted() {
		token = localStorage.getItem('token');
		this.isadmin();
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		isadmin() {
			let param = { token: token };
			https.fetchGet('/isAdmin', param).then(data => {
				window.console.log(data);
				if (data.data.state == 0) {
					this.$router.push({ path: '/' });
					this.open(data.data.msg);
				} else if (data.data.state == 1) {
					if (data.data.msg == 'admin') {
						this.admin = 'y';
					} else {
						this.admin = 'n';
					}
				}
			});
		},
		open(e) {
			this.$alert(e, {
				confirmButtonText: '确定',
				callback: action => {
					/* this.$message({
							type: 'info',
							message: `action: ${action}`
						}); */
					window.console.log(action);
				}
			});
		},
	},
	created() {}
};
</script>

<style scoped></style>
