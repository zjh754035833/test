<template>
	<div style="height: 100vh;">
		<el-dialog title="" :visible.sync="dialogTableVisible" width="60%">
			<div class="diag1"><el-input type="textarea" placeholder="请输入内容" v-model="textarea" show-word-limit></el-input></div>
			<div class="diag2">
				<el-date-picker
					v-model="value2"
					type="datetime"
					placeholder="请选择短信发送时间"
					format="yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒"
					value-format="timestamp"
				></el-date-picker>
			</div>
			<div style="margin-top: 40px;"><label for="getFile" class="labelsty shou ">+批量上传手机号完成上传</label></div>
			<input type="file" id="getFile" @change="loadTextFromFile" style="display:none;" ref="uploadExcelId" />
		</el-dialog>
		<el-dialog title="" :visible.sync="updatedialogTableVisible" width="60%">
			<div class="diag1"><el-input type="textarea" placeholder="请输入内容" v-model="updatetextarea"  show-word-limit></el-input></div>
			<div class="diag2">
				<el-date-picker
					v-model="updatevalue2"
					type="datetime"
					placeholder="请选择短信发送时间"
					format="yyyy 年 MM 月 dd 日 HH 时 mm 分 ss 秒"
					value-format="timestamp"
				></el-date-picker>
			</div>
			<div style="display: inline-block;margin-top: 30px;"><label for="getFile2" class="labelsty shou ">上传手机号</label></div>
			<div style="display: inline-block;font-weight: 500;font-size: 15px;">（{{ userphonenum }}）条 (最终上传号码会自动进行去重操作)</div>
			<input type="file" id="getFile2" @change="loadTextFromFileupdate" style="display:none;" ref="uploadExcelId" />
			<div style="margin-top: 30px;float: right;" @click="updatesure"><el-button type="primary" :loading="updateloading">确认修改</el-button></div>
		</el-dialog>
		<div class="toparea1">
			<img src="../../static/loginsu.png" />
			<div>
				<span>你好---{{ usenameval }}---账户余额：</span>
				<span>￥{{ monety }}</span>
			</div>
			<div style="margin-left: 400px;"><el-button type="primary" plain @click="tuichudeng">退出登录</el-button></div>
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
							<el-menu-item index="1-1" @click="openarea(1)">信息导入/查询</el-menu-item>
						</el-submenu>
						<el-submenu index="2">
							<template slot="title">
								<span>个人信息</span>
							</template>
							<el-menu-item index="2-1" @click="openarea(2)">修改密码</el-menu-item>
						</el-submenu>
					</el-menu>
				</div>
			</div>
			<div style="width: 85%;background:rgba(255,255,255,1);max-height: 100px;">
				<div v-if="area1">
					<div class="top1"><span style="	margin-left: 10px;">首页>信息管理>信息导入/查询</span></div>
					<div class="top2"><el-button type="primary" @click="forchuan">上传批次</el-button></div>
					<div>
						<el-table :data="alllist" style="width: 100%" height="70vh">
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
											<el-tag size="medium" v-if="scope.row.sendstate > 0">已发送{{ scope.row.sendstate }}条</el-tag>
											<el-tag size="medium" v-if="scope.row.sendstate == 0" style="color: #00C3FF;">尚未发送</el-tag>
										</div>
									</el-popover>
								</template>
							</el-table-column>
							<el-table-column label="发送内容" width="200" align="center" style="overflow: hidden;">
								<template slot-scope="scope">
									<el-popover trigger="hover" placement="top">
										<div slot="reference" class="name-wrapper">
											<el-tag size="medium" v-if="scope.row.usermessage.length > 30">{{ scope.row.usermessage.substring(0, 30) + '...' }}</el-tag>
											<el-tag size="medium" v-if="scope.row.usermessage.length <= 30">{{ scope.row.usermessage }}</el-tag>
										</div>
									</el-popover>
								</template>
							</el-table-column>
							<el-table-column label="发送时间" width="240" align="center">
								<template slot-scope="scope">
									<i class="el-icon-time"></i>
									<span style="margin-left: 10px">{{ scope.row.sendtime | timestampToTime }}</span>
								</template>
							</el-table-column>
							<el-table-column label="导入时间" width="240" align="center">
								<template slot-scope="scope">
									<i class="el-icon-time"></i>
									<span style="margin-left: 10px">{{ scope.row.mtimesmp | timestampToTime2 }}</span>
								</template>
							</el-table-column>
							<el-table-column label="操作" fixed="right" width="200" align="center">
								<template slot-scope="scope">
									<el-button @click="updatenum(scope.row.userid, scope.row.mtimesmp)">编辑</el-button>
									<el-button type="danger" @click="deletenum(scope.row.userid, scope.row.mtimesmp)">删除</el-button>
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
				<div v-if="area2 == true">
					<div class="top1"><span style="	margin-left: 10px;">首页>个人信息>修改密码</span></div>
					<div class="loginz">
						<div style="margin-top: 10vh;">修改密码</div>
						<div class="half2">用户名：{{ usenameval }}</div>
						<input class="half3" placeholder="原密码" @input="usepassword" type="text" />
						<input class="half4" placeholder="新密码" @input="newpassword" type="text" />
						<div class="denglu shou" @click="register()">确认</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
var token, _this;
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
			monety: '',
			fileList: [],
			textarea: '',
			radioval: '',
			isIndeterminate: true,
			phonelist: [],
			outputs: [],
			alllist: [],
			allnum: 0,
			area1: true,
			area2: false,
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
			newpasswordval: ''
		};
	},
	created: {},
	mounted() {
		_this = this;
		document.querySelector('body').setAttribute('style', 'background-color:rgba(246, 246, 246, 1)');
		token = localStorage.getItem('token');
		this.getuserinfo();
	},
	methods: {
		tuichudeng() {
			localStorage.removeItem('token');
			token = localStorage.getItem('token');
			this.getuserinfo();
		},
		openarea(e) {
			if (e == 1) {
				this.area1 = true;
				this.area2 = false;
			} else if (e == 2) {
				this.area1 = false;
				this.area2 = true;
			}
		},
		forchuan() {
			this.value2 = '';
			this.textarea = '';
			this.dialogTableVisible = true;
		},
		updatesure() {
			this.$confirm('确定修改?  ', {
				confirmButtonText: '确定',
				cancelButtonText: '取消'
			})
				.then(({ value }) => {
					const loading = this.$loading({
						lock: true,
						text: '信息修改中',
						spinner: 'el-icon-loading',
						background: 'rgba(0, 0, 0, 0.7)'
					});
					window.console.log(value);
					this.updateloading = true;
					let param = {
						phonelist: this.phonelist,
						token: token,
						textarea: this.updatetextarea,
						sendtime: this.updatevalue2,
						userid: this.updateuserid,
						timesmpstr: this.updatetimesmpstr,
						msgNum: this.phonelist.length
					};

					https.fetchPost('/upDateAll', JSON.stringify(param)).then(data => {
						if (data.data.state == 1) {
							_this.getuserinfo();
							this.open('修改成功');
							this.updateloading = false;
							loading.close();
						} else if (data.data.state == 0) {
							this.open(data.data.msg);
							this.$router.push({ path: '/' });
							loading.close();
						}
						loading.close();
					});
				})
				.catch(() => {});
		},
		updatenum(userid, timesmpstr) {
			const loading = this.$loading({
				lock: true,
				text: '手机号拼命加载中，稍等片刻',
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
					this.$router.push({ path: '/' });
					loading.close();
				}
				window.console.log(data);
			});
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
					https.fetchGet('/deleteMobile', param).then(data => {
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
			this.$prompt('请输入已发条数', '提示', {
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
		forkaihu() {
			this.dialogTableVisible = true;
		},
		register() {
			var reg = /[\u4e00-\u9fa5]/gi;
			if (this.newpasswordval == '' || reg.test(this.newpasswordval)) {
				this.open('新密码不能为空且不能为中文');
			} else {
				this.$confirm('确定重置? 账号:' + this.usenameval + ' 新密码:' + this.newpasswordval, {
					confirmButtonText: '确定',
					cancelButtonText: '取消'
				})
					.then(() => {
						let param = { usenameval: this.usenameval, token: token, passwordval: this.passwordval, newpasswordval: this.newpasswordval };
						window.console.log(param);
						https.fetchGet('/updateUser', param).then(data => {
							window.console.log(data);
							if (data.data.state == 1) {
								this.open(data.data.msg);
							} else if (data.data.state == 0) {
								this.open(data.data.msg);
								this.$router.push({ path: '/' });
							} else if (data.data.state == 2) {
								this.open(data.data.msg);
								localStorage.removeItem('token');
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

		newpassword(e) {
			this.newpasswordval = e.target.value;
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
		toExport() {
			this.$confirm('即将导出文本，确认继续?', {
				confirmButtonText: '确定',
				cancelButtonText: '取消'
			})
				.then(() => {
					if (this.daolist == '') {
						this.open('导出数据为空');
					} else {
						var data = [];
						var msgssage = [];
						this.daolist.forEach(x => {
							window.console.log(x);
							var datas = x + '\n';
							data.push(datas);
						});
						msgssage.push(this.modalmessage);
						var temp_string = data.join('');
						var temp_string2 = msgssage.join('');
						this.exportRaw('mobile.txt', temp_string);
						this.exportRaw('text.txt', temp_string2);
					}
				})
				.catch(() => {});
		},
		remove() {
			/* localStorage.removeItem('token'); */
		},
		loadTextFromFile(e) {
			if (this.textarea == '' || this.textarea == null || this.value2 == '' || this.value2 == null) {
				this.open('发送内容和时间不能为空');
				document.getElementById('getFile').value = null;
				return false;
			}
			let file = e.target.files[0];
			let reader = new FileReader();
			reader.onload = e => this.dealNum(e);
			reader.onerror = e => this.error(e);
			reader.readAsText(file);
			this.$refs.uploadExcelId.value = null;
		},
		loadTextFromFileupdate(e) {
			/* if (this.updatetextarea == '' || this.updatetextarea == null || this.updatevalue2 == '' || this.updatevalue2 == null) {
				this.open('发送内容和时间不能为空');
				document.getElementById('getFile2').value = null;
				return false;
			} */
			let file = e.target.files[0];
			let reader = new FileReader();
			reader.onload = e => this.updatedealNum(e);
			reader.onerror = e => this.error(e);
			reader.readAsText(file);
			this.$refs.uploadExcelId.value = null;
		},
		unique1(arr) {
			var hash = [];
			for (var i = 0; i < arr.length; i++) {
				if (hash.indexOf(arr[i]) == -1) {
					hash.push(arr[i]);
				}
			}
			return hash;
		},
		updatedealNum(e) {
			this.phonelist = e.target.result.split('\r\n');
			this.userphonenum = this.phonelist.length;
			document.getElementById('getFile2').value = null;
		},
		dealNum(e) {
			this.phonelist = e.target.result.split('\r\n');
			this.$confirm('确定导入?导入号码将自动进行筛选去重操作', {
				confirmButtonText: '确定',
				cancelButtonText: '取消'
			})
				.then(({ value }) => {
					const loading = this.$loading({
						lock: true,
						text: '号码导入中，请稍后',
						spinner: 'el-icon-loading',
						background: 'rgba(0, 0, 0, 0.7)'
					});
					window.console.log(value);
					let param = { phonelist: this.phonelist, token: token, textarea: this.textarea, sendtime: this.value2 };

					https.fetchPost('/insertMobile', JSON.stringify(param)).then(data => {
						window.console.log(data);
						if (data.data.state == 1) {
							document.getElementById('getFile').value = null;
							_this.getuserinfo();
							this.open('导入成功');
							window.console.log(data);
							loading.close();
						} else if (data.data.state == 0) {
							this.open(data.data.msg);
							this.$router.push({ path: '/' });
							loading.close();
						}
					});
				})
				.catch(() => {});
		},
		error() {
			this.open('读取失败');
		},
		/* 	readExcel(e) {
				//表格导入
				var that = this;
				const files = e.target.files;
				window.console.log(files);
				if (files.length <= 0) {
					//如果没有文件名
					return false;
				} else if (!/\.(xls|xlsx)$/.test(files[0].name.toLowerCase())) {
					alert('上传格式不正确，请上传xls或者xlsx格式');
					return false;
				}
	
				const fileReader = new FileReader();
				fileReader.onload = ev => {
					try {
						const data = ev.target.result;
						const workbook = XLSX.read(data, {
							type: 'binary'
						});
						const wsname = workbook.SheetNames[1]; //取第一张表
						const ws = XLSX.utils.sheet_to_json(workbook.Sheets[wsname]); //生成json表格内容
							let param = JSON.stringify(ws);
							window.console.log(ws);
						https
							.fetchPost('/insertmobile', param)
							.then(data => {
								window.console.log(data);
							
							})
						that.outputs = []; //清空接收数据
						for (var i = 0; i < ws.length; i++) {
							var sheetData = {
								address: ws[i].addr,
								value: ws[i].value
							};
							that.outputs.push(sheetData);
						}
						this.$refs.upload.value = '';
					} catch (e) {
						return false;
					}
				};
				fileReader.readAsBinaryString(files[0]);
			}, */
		getuserinfo() {
			const loading = this.$loading({
				lock: true,
				text: '数据加载中，请稍后',
				spinner: 'el-icon-loading',
				background: 'rgba(0, 0, 0, 0.7)'
			});
			let param = { token: token, page: this.page };
			https.fetchGet('/userInfo', param).then(data => {
				window.console.log(data);
				if (data.data.state == 0) {
					this.open(data.data.msg);
					this.$router.push({ path: '/' });
					loading.close();
				} else if (data.data.state == 1) {
					loading.close();
					if (data.data.msg == 'admin') {
						this.admin = 'y';
					} else {
						this.monety = data.data.msg;
					}
					if ((data.data.dto.length == 0) & (this.page > 0)) {
						this.page = this.page - 1;
						this.getuserinfo();
					} else {
						this.alllist = data.data.dto;
						window.console.log(this.alllist);
						this.usenameval = data.data.username;
						this.allnum = data.data.pageCounts;
					}
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
	margin-left: 208px;
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
</style>
