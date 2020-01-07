<template>
	<div style="height: 100vh;">
		<el-dialog title="发送内容" :visible.sync="updatedialogTableVisible" width="60%">
			<div class="diag1"><el-input type="textarea" placeholder="请输入内容" v-model="updatetextarea"  show-word-limit></el-input></div>
		</el-dialog>
		<div class="toparea1">
			<img src="../../static/loginsu.png" />
			<div><span>你好---管理员</span></div>
			<el-button type="primary" plain @click="tuichudeng" style="margin-left: 20px;">退出登录</el-button>
		</div>
		<div style="display: flex;">
			<div style="width: 15%;background-color: #333333;height: 90vh;">
				<div class="user1">导航菜单</div>
				<div style="width: 100%;">
					<el-menu default-active="2" class="el-menu-vertical-demo" background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
						<el-submenu index="1">
							<template slot="title">
								<span>信息管理</span>
							</template>
							<el-menu-item index="1-1" @click="openarea(1)">信息管理/导出</el-menu-item>
						</el-submenu>
						<el-submenu index="2">
							<template slot="title">
								<span>开户管理</span>
							</template>
							<el-menu-item index="2-1" @click="openarea(2)">开户</el-menu-item>
						</el-submenu>
					</el-menu>
				</div>
			</div>
			<div style="width: 85%;background:rgba(255,255,255,1);max-height: 100px;">
				<div v-if="area2 == true">
					<div class="top1"><span style="	margin-left: 10px;">首页>开户管理>开户</span></div>
					<div class="loginz">
						<img src="../../static/loginsu.png" />
						<input class="half2" placeholder="用户名" @input="usename" />
						<input class="half3" placeholder="密码" @input="usepassword" type="text" />
						<input class="half4" placeholder="每条短信价格" type="number" @input="mobileprice" />
						<div class="denglu shou" @click="register()">开户</div>
					</div>
				</div>
				<div v-if="area1 == true">
					<div class="top1"><span style="	margin-left: 10px;">首页>信息管理>信息管理/导出</span></div>
					<div class="block" style="margin-top: 20px;">
						<el-date-picker
							v-model="valuedate"
							type="datetimerange"
							range-separator="至"
							start-placeholder="开始日期"
							end-placeholder="结束日期"
							value-format="timestamp"
						></el-date-picker>
						<el-button type="primary" @click="serchbysend">按发送时间段查询</el-button>
					</div>
					<div class="block" style="margin-top: 20px;">
						<el-date-picker
							v-model="valuedate2"
							type="datetimerange"
							range-separator="至"
							start-placeholder="开始日期"
							end-placeholder="结束日期"
							value-format="timestamp"
						></el-date-picker>
						<el-button type="primary" @click="serchbyinsert">按导入时间段查询</el-button>
					</div>
					<div>
						<el-table :data="alllist" style="width: 100%" height="60vh" :row-class-name="tableRowClassName">
							<el-table-column label="批次" width="80" align="center">
								<template slot-scope="scope">
									<el-popover trigger="hover" placement="top">
										<div slot="reference" class="name-wrapper">
											<el-tag size="medium">{{ scope.$index + 1 }}</el-tag>
										</div>
									</el-popover>
								</template>
							</el-table-column>
							<el-table-column label="手机号数量" width="120" align="center">
								<template slot-scope="scope">
									<el-popover trigger="hover" placement="top">
										<div slot="reference" class="name-wrapper">
											<el-tag size="medium">{{ scope.row.num }}</el-tag>
										</div>
									</el-popover>
								</template>
							</el-table-column>
							<el-table-column label="发送状态" width="120" align="center">
								<template slot-scope="scope">
									<el-popover trigger="hover" placement="top">
										<div slot="reference" class="name-wrapper">
											<el-tag size="medium" v-if="scope.row.sendstate > 0">已发{{ scope.row.sendstate }}条</el-tag>
											<el-tag size="medium" v-if="scope.row.sendstate == 0" style="color: #507AA5;">尚未发送</el-tag>
										</div>
									</el-popover>
								</template>
							</el-table-column>
							<el-table-column label="发送人" width="120" align="center">
								<template slot-scope="scope">
									<el-popover trigger="hover" placement="top">
										<div slot="reference" class="name-wrapper">
											<el-tag size="medium">{{ scope.row.username }}</el-tag>
										</div>
									</el-popover>
								</template>
							</el-table-column>
							<el-table-column label="单条信息价格" width="120" align="center">
								<template slot-scope="scope">
									<el-popover trigger="hover" placement="top">
										<div slot="reference" class="name-wrapper">
											<el-tag size="medium">{{ scope.row.mobileprice }}</el-tag>
										</div>
									</el-popover>
								</template>
							</el-table-column>
							<el-table-column label="发送内容" width="200" align="center">
								<template slot-scope="scope">
									<el-popover trigger="hover" placement="top">
										<div slot="reference" class="name-wrapper">
											<el-tag size="medium" v-if="scope.row.usermessage.length > 30">{{ scope.row.usermessage.substring(0, 30) + '...' }}</el-tag>
											<el-tag size="medium" v-if="scope.row.usermessage.length <= 30">{{ scope.row.usermessage }}</el-tag>
										</div>
										<div><el-button type="primary" plain @click="updatenum(scope.row.userid, scope.row.mtimesmp)">文本详情</el-button></div>
									</el-popover>
								</template>
							</el-table-column>
							<el-table-column label="发送时间" width="240" align="center">
								<template slot-scope="scope">
									<i class="el-icon-time"></i>
									<span style="margin-left: 10px">{{ scope.row.sendtime | timestampToTime }}</span>
								</template>
							</el-table-column>
							<el-table-column label="最终导入时间" width="240" align="center">
								<template slot-scope="scope">
									<i class="el-icon-time"></i>
									<span style="margin-left: 10px">{{ scope.row.mtimesmp | timestampToTime2 }}</span>
								</template>
							</el-table-column>
							<el-table-column label="操作" fixed="right" width="270">
								<template slot-scope="scope">
									<div v-if="scope.row.sate == 'y'">
										<div style="color: white;">(用户已经删除该批次)</div>
										<el-button @click="deletenum(scope.row.userid, scope.row.mtimesmp)">删除</el-button>
									</div>
									<div v-if="scope.row.sate == 'n'">
										<el-button @click="toExport(scope.row.userid, scope.row.mtimesmp)">导出手机号</el-button>
										<el-button @click="toExport1(scope.row.userid, scope.row.mtimesmp)">导出文案</el-button>
										<el-button type="danger" style="margin-top: 10px;" @click="changenum(scope.row.userid, scope.row.mtimesmp)">修改发送条数</el-button>
									</div>
									<div v-if="scope.row.sate == 'g'">
										<div style="color: white;">(用户已经更新了该批次,请重新导出)</div>
										<el-button @click="toExport(scope.row.userid, scope.row.mtimesmp)">导出手机号</el-button>
										<el-button @click="toExport1(scope.row.userid, scope.row.mtimesmp)">导出文案</el-button>
										<el-button type="danger" @click="forreally(scope.row.userid, scope.row.mtimesmp)">标记为正常</el-button>
									</div>
								</template>
							</el-table-column>
						</el-table>
					</div>
					<div style="float: right;margin-right: 100px;height: 5vh;display: flex;align-items: center;">
						<el-pagination
							@size-change="handleSizeChange"
							@current-change="handleCurrentChange"
							:page-size="10"
							layout="total, prev, pager, next, jumper"
							:total="allnum"
						></el-pagination>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
var token;
import https from '../https.js';
/* import XLSX from 'xlsx'; */
export default {
	filters: {
		timestampToTime(cjsj) {
			var date = new Date(cjsj); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
			var Y = date.getFullYear() + '-';
			var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
			var D = date.getDate() + ' ';
			var h = date.getHours();
			/* var m = date.getMinutes() + ':';
			var s = date.getSeconds(); */
			return Y + M + D + h;
		},
		timestampToTime2(cjsj) {
			var date = new Date(cjsj); //时间戳为10位需*1000，时间戳为13位的话不需乘1000
			var Y = date.getFullYear() + '-';
			var M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
			var D = date.getDate() + ' ';
			var h = date.getHours() + ':';
			var m = date.getMinutes() + ':';
			var s = date.getSeconds();
			return Y + M + D + h + m + s;
		}
	},
	components: {},
	data() {
		return {
			area1: true,
			area2: false,
			valuedate: '',
			monety: '',
			fileList: [],
			textarea: '',
			radioval: '',
			isIndeterminate: true,
			phonelist: [],
			outputs: [],
			alllist: [],
			allnum: 0,
			daolist: '',
			modalmessage: '',
			userphonenum: 0,
			admin: '',
			dialogTableVisible: false,
			mobilepriceval: '',
			usenameval: '',
			passwordval: '',
			value2: '',
			page: 0,
			updatetextarea: '',
			updatevalue2: '',
			updatedialogTableVisible: false,
			updateuserid: '',
			updatetimesmpstr: '',
			updateloading: false,
			sendStart: '',
			sendEnd: '',
			valuedate2: '',
			insertStart: '',
			insertEnd: ''
		};
	},
	created: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:rgba(246, 246, 246, 1)');
		token = localStorage.getItem('token');
		this.getuserinfo();
	},
	methods: {
		serchbysend() {
			this.insertStart = '';
			this.insertEnd = '';

			if (this.valuedate == null || this.valuedate == '') {
				this.sendStart = '';
				this.sendEnd = '';
			} else {
				this.sendStart = this.valuedate[0];
				this.sendEnd = this.valuedate[1];
			}
			this.getuserinfo();
		},
		serchbyinsert() {
			this.sendStart = '';
			this.sendEnd = '';
			//window.console.log(this.valuedate);
			if (this.valuedate2 == null || this.valuedate2 == '') {
				this.insertStart = '';
				this.insertEnd = '';
			} else {
				this.insertStart = this.valuedate2[0];
				this.insertEnd = this.valuedate2[1];
			}
			this.getuserinfo();
		},
		tableRowClassName(row) {
			window.console.log(row);
			if (row.row.sate == 'y') {
				return 'warning-row';
			} else if (row.row.sate == 'g') {
				return 'success-row';
			}
		},
		tuichudeng() {
			localStorage.removeItem('token');
			token = localStorage.getItem('token');
			this.getuserinfo();
		},
		updatenum(userid, timesmpstr) {
			const loading = this.$loading({
				lock: true,
				text: '加载中',
				spinner: 'el-icon-loading',
				background: 'rgba(0, 0, 0, 0.7)'
			});
			let param = { userid: userid, token: token, timesmpstr: timesmpstr };
			https.fetchGet('/upDataMobile', param).then(data => {
				if (data.data.state == 1) {
					this.updatedialogTableVisible = true;
					this.updatevalue2 = data.data.message.sendtime;
					this.updatetextarea = data.data.message.usermessage;
					this.phonelist = data.data.valist;
					this.updateuserid = userid;
					this.updatetimesmpstr = timesmpstr;
					this.userphonenum = this.phonelist.length;
					loading.close();
				} else if (data.data.state == 0) {
					this.open(data.data.msg);
					loading.close();
					this.$router.push({ path: '/' });
				}
				window.console.log(data);
			});
		},
		openarea(e) {
			if (e == 1) {
				this.area1 = true;
				this.area2 = false;
			} else if (e == 2) {
				this.area2 = true;
				this.area1 = false;
			}
		},
		deletenum(userid, timesmpstr) {
			this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			})
				.then(({ value }) => {
					const loading = this.$loading({
						lock: true,
						text: '信息删除中，请稍后',
						spinner: 'el-icon-loading',
						background: 'rgba(0, 0, 0, 0.7)'
					});
					let param = { userid: userid, token: token, timesmpstr: timesmpstr, sendstate: value };
					https.fetchGet('/deleteMobileAdmin', param).then(data => {
						if (data.data.state == 1) {
							this.getuserinfo();
							this.open('删除成功');
							loading.close();
						} else if (data.data.state == 0) {
							this.open(data.data.msg);
							this.$router.push({ path: '/' });
							loading.close();
						}
						window.console.log(data);
					});
				})
				.catch(() => {});
		},
		changenum(userid, timesmpstr) {
			window.console.log(userid, timesmpstr);
			this.$prompt('请输入已发条数（输入0则表示尚未发送）', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				inputPattern: /^[0-9]*$/,
				inputErrorMessage: '请输入数字'
			})
				.then(({ value }) => {
					if (value == '' || value == null) {
						this.open('内容不能为空');
						return false;
					}
					let param = { userId: userid, token: token, timeSmpStr: timesmpstr, sendState: value };
					https.fetchGet('/updateSendNum', param).then(data => {
						if (data.data.state == 1) {
							this.getuserinfo();
						} else if (data.data.state == 0) {
							this.open(data.data.msg);
							this.$router.push({ path: '/' });
						}
						window.console.log(data);
					});
				})
				.catch(() => {});
		},
		forreally(userid, timesmpstr) {
			this.$confirm('此操作将该批次标记为正常, 是否继续?', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				type: 'warning'
			})
				.then(({ value }) => {
					let param = { userid: userid, token: token, timesmpstr: timesmpstr, sendstate: value };
					https.fetchGet('/forReally', param).then(data => {
						if (data.data.state == 1) {
							this.getuserinfo();
							this.open('标记成功');
						} else if (data.data.state == 0) {
							this.open(data.data.msg);
							this.$router.push({ path: '/' });
						}
						window.console.log(data);
					});
				})
				.catch(() => {});
		},
		forkaihu() {
			this.dialogTableVisible = true;
		},
		register() {
			var reg = /[\u4e00-\u9fa5]/gi;
			if (reg.test(this.usenameval) || this.usenameval == '') {
				this.open('用户名不能为空且不能为中文');
			} else if (this.passwordval == '' || reg.test(this.passwordval)) {
				this.open('密码不能为空且不能为中文');
			} else if (this.mobilepriceval == '') {
				this.open('短信价格不能为空');
			} else {
				this.$confirm('确定开户? 账号:' + this.usenameval + ' 密码:' + this.passwordval + ' 每条短信价格:' + this.mobilepriceval, {
					confirmButtonText: '确定',
					cancelButtonText: '取消'
				})
					.then(() => {
						let param = { usenameval: this.usenameval, token: token, passwordval: this.passwordval, mobilepriceval: this.mobilepriceval };
						window.console.log(param);
						https.fetchGet('/register', param).then(data => {
							window.console.log(data);
							if (data.data.state == 1) {
								this.open(data.data.msg);
							} else if (data.data.state == 0) {
								this.open(data.data.msg);
								this.$router.push({ path: '/' });
							}
						});
					})
					.catch(() => {});
			}
		},
		usename(e) {
			this.usenameval = e.target.value;
		},
		usepassword(e) {
			this.passwordval = e.target.value;
		},
		mobileprice(e) {
			window.console.log(e.target.value);
			this.mobilepriceval = e.target.value;
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

		handleCheckedCitiesChange(value) {
			window.console.log(value.userid);
			window.console.log(value.mtimesmp);
			let param = { timesmpstr: value.mtimesmp, userid: value.userid, token: token };
			https.fetchGet('/exportMobile', param).then(data => {
				window.console.log(data);
				if (data.data.state == 0) {
					this.open(data.data.msg);
					this.$router.push({ path: '/' });
				} else {
					this.daolist = data.data.valist;
					this.modalmessage = data.data.message.usermessage;
				}
			});
		},
		fakeClick(obj) {
			var ev = document.createEvent('MouseEvents');
			ev.initMouseEvent('click', true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);
			obj.dispatchEvent(ev);
		},
		exportRaw(name, data) {
			var urlObject = window.URL || window.webkitURL || window;
			var export_blob = new Blob([data]);
			var save_link = document.createElementNS('http://www.w3.org/1999/xhtml', 'a');
			save_link.href = urlObject.createObjectURL(export_blob);
			save_link.download = name;
			this.fakeClick(save_link);
		},
		toExport(userid, timesmpstr) {
			this.$confirm('即将导出文本，确认继续?', {
				confirmButtonText: '确定',
				cancelButtonText: '取消'
			})
				.then(() => {
					const loading = this.$loading({
						lock: true,
						text: '拼命导出文本中，请稍候',
						spinner: 'el-icon-loading',
						background: 'rgba(0, 0, 0, 0.7)'
					});
					let param = { userid: userid, token: token, timesmpstr: timesmpstr };
					https.fetchGet('/upDataMobile', param).then(data => {
						if (data.data.state == 1) {
							window.console.log(data.data);
							this.daolist = data.data.valist;
							this.modalmessage = data.data.message.usermessage;
							if (this.daolist == '') {
								this.open('导出数据为空');
								loading.close();
							} else {
								let data = [];
								this.daolist.forEach(x => {
									window.console.log(x);
									var datas = x + '\n';
									data.push(datas);
								});
							
								var temp_string = data.join('');
							
								this.exportRaw('mobile' + userid + timesmpstr + '.txt', temp_string);
							
								loading.close();
							}
						} else if (data.data.state == 0) {
							this.open(data.data.msg);
							loading.close();
							this.$router.push({ path: '/' });
						}
						window.console.log(data);
					});
				})
				.catch(() => {});
		},
		toExport1(userid, timesmpstr) {
			this.$confirm('即将导出文本，确认继续?', {
				confirmButtonText: '确定',
				cancelButtonText: '取消'
			})
				.then(() => {
					const loading = this.$loading({
						lock: true,
						text: '拼命导出文本中，请稍候',
						spinner: 'el-icon-loading',
						background: 'rgba(0, 0, 0, 0.7)'
					});
					let param = { userid: userid, token: token, timesmpstr: timesmpstr };
					https.fetchGet('/upDataMobile', param).then(data => {
						if (data.data.state == 1) {
							window.console.log(data.data);
							this.modalmessage = data.data.message.usermessage;
							if (this.modalmessage == '') {
								this.open('导出数据为空');
								loading.close();
							} else {
								var msgssage = [];
								msgssage.push(this.modalmessage);
								var temp_string2 = msgssage.join('');
								this.exportRaw('text' + userid + timesmpstr + '.txt', temp_string2);
								loading.close();
							}
						} else if (data.data.state == 0) {
							this.open(data.data.msg);
							loading.close();
							this.$router.push({ path: '/' });
						}
						window.console.log(data);
					});
				})
				.catch(() => {});
		},
		remove() {
			/* localStorage.removeItem('token'); */
		},

		getuserinfo() {
			const loading = this.$loading({
				lock: true,
				text: '数据加载中，请稍后',
				spinner: 'el-icon-loading',
				background: 'rgba(0, 0, 0, 0.7)'
			});
			let param = { token: token, page: this.page, sendStart: this.sendStart, sendEnd: this.sendEnd, insertStart: this.insertStart, insertEnd: this.insertEnd };
			https.fetchGet('/userInfo', param).then(data => {
				window.console.log(data);
				if (data.data.state == 0) {
					loading.close();
					this.open(data.data.msg);
					this.$router.push({ path: '/' });
				} else if (data.data.state == 1) {
						loading.close();
					if (data.data.msg == 'admin') {
						this.admin = 'y';
					} else {
						this.monety = data.data.msg;
					}
					this.alllist = data.data.dto;
					window.console.log(this.alllist);
					this.allnum = data.data.pageCounts;
				}
			});
		},
		handleChange(file, fileList) {
			window.console.log(11);
			this.fileList = fileList.slice(-3);
		},
		handleSizeChange(val) {
			window.console.log(`每页 ${val} 条`);
		},
		handleCurrentChange(val) {
			this.page = val - 1;
			window.console.log(val - 1);
			this.getuserinfo();
		}
		/* 		handleCheckAllChange(val) {
				this.checkList = val ? this.alllist : [];
				this.isIndeterminate = false;
			} */
	}
};
</script>

<style scoped="scoped">
.block {
}
/deep/ .el-table .warning-row {
	background: #999999;
}

/deep/ .el-table .success-row {
	background: #00c3ff;
}
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
/deep/.el-textarea {
	background: rgba(255, 255, 255, 1);
}
/deep/ .el-textarea__inner {
	height: 174px;
	margin-top: 16px;
	font-size: 17px;
	padding-top: 24px;
	padding-bottom: 24px;
	color: rgba(102, 102, 102, 1);
	opacity: 1;
}
/deep/ .el-textarea .el-input__count {
	color: rgba(102, 102, 102, 1);
}
/deep/ .toparea2 > div[data-v-9cfc9dda]:nth-of-type(2) {
	width: 1224px;
	background: rgba(246, 246, 246, 1);
	opacity: 1;
	border: none;
	/* height: 30%; */
}
/deep/ .el-textarea__inner:focus {
	outline: 0;
	border-color: rgba(209, 216, 245, 1);
}
.diag2 {
	margin-top: 20px;
}
.diag1 {
	margin-top: 20px;
}
.el-date-editor.el-input {
	width: 100%;
}
.labelsty {
	display: block;
	width: 200px;
	height: 32px;
	border-radius: 4px;
	border: 1px solid rgba(69, 141, 254, 1);
	font-size: 14px;
	font-weight: 400;
	line-height: 32px;
	text-align: center;
	color: rgba(69, 141, 254, 1);
}
.user1 {
	width: 100%;
	height: 30px;
	color: rgba(255, 255, 255, 1);
	text-align: center;
	line-height: 30px;
	font-size: 15px;
}
.top1 {
	width: 100%;
	height: 5vh;
	background: rgba(245, 245, 245, 1);
	line-height: 30px;
	font-size: 13px;
}
.top2 {
	height: 8vh;
	display: flex;
	align-items: center;
}
.toparea1 {
	height: 10vh;
	width: 100%;
	background: #ffffff;
	border-radius: 1px;
	display: flex;
	align-items: center;
}
.toparea1 > img {
	width: 121px;
	height: 49px;
	margin-left: 116px;
}
.toparea1 > div {
	margin-left: 908px;
}
.toparea1 > div > span:nth-of-type(1) {
	font-size: 13px;
	font-weight: 600;
	color: rgba(104, 104, 104, 1);
}
.toparea1 > div > span:nth-of-type(2) {
	font-size: 19.44px;
	font-weight: 600;
	color: rgba(192, 0, 0, 1);
}
.half2 {
	margin-top: 70px;
	width: 386px;
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	font-size: 16px;
	color: rgba(51, 51, 51, 1);
}
.half3 {
	margin-top: 70px;
	width: 386px;
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	font-size: 16px;
	color: rgba(51, 51, 51, 1);
}
.half4 {
	margin-top: 70px;
	width: 386px;
	border: none;
	border-bottom: #c0c0c0 1px solid;
	outline: none;
	font-size: 16px;
	color: rgba(51, 51, 51, 1);
}
.loginz {
	display: flex;
	flex-direction: column;
	left: 0;
	right: 0;
	top: 0;
	bottom: 0;
	margin: auto;
	align-items: center;
	background: rgba(255, 255, 255, 1);
	border-radius: 7px;
}
.loginz > img {
	width: 100px;
	height: 38px;
	margin-top: 10vh;
}
</style>
