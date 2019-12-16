<template>
	<div>
		<div>
			<el-dialog title="" :visible.sync="dialogTableVisible" width="60%">
				<div class="loginz">
					<img src="../../static/loginsu.png" />
					<input class="half2" placeholder="用户名" @input="usename" />
					<input class="half3" placeholder="密码" @input="usepassword" type="text" />
					<input class="half4" placeholder="每条短信价格" type="number" @input="mobileprice" />
					<div class="denglu shou" @click="register()">开户</div>
				</div>
			</el-dialog>
		</div>
		<div class="toparea1">
			<img src="../../static/loginsu.png" />
			<div v-if="admin != 'y'">
				<span>账户余额：</span>
				<span>￥{{ monety }}</span>
			</div>
			<div v-if="admin == 'y'" class="kaihu shou" @click="forkaihu">开户</div>
		</div>
		<div class="toparea2">
			<div v-if="admin != 'y'"> 推广内容</div>
			<div v-if="admin != 'y'"><el-input type="textarea" placeholder="请输入内容" v-model="textarea" maxlength="200" show-word-limit></el-input></div>
			<div v-if="admin == 'y'"></div>
			<div v-if="admin == 'y'"></div>
			<div>批量导入信息</div>
			<div>
				<div>电话号码</div>
				<div @click="toExport()" v-if="admin == 'y'" class="shou">+批量导出</div>
				<label for="getFile" class="shou" v-if="admin != 'y'">+批量上传</label>
				<input type="file" id="getFile" @change="loadTextFromFile" style="display:none;" ref="uploadExcelId" />
				<!-- 	<input type="file" ref="upload" accept=".xls,.xlsx"  id="getFile" style="display:none;"/> -->
			</div>
			<div class="allphone">
				<div style="margin-left: 18px;margin-top: 17px;">
					<div class="checksty" v-for="(gtem, index) in alllist" :key="index">
						<el-radio v-model="radioval" :label="gtem" border @change="handleCheckedCitiesChange" class="kuangti">
							第{{ index + 1 }}批次 ({{ gtem.num }}条数据)
							<span style="margin-left: 30px; color: #00C3FF;position: ;" v-if="gtem.sendstate == 0">尚未发送</span>
							<!-- 							<input  value="2" /> -->
							<span style="margin-left: 30px; color:#999999;" v-if="gtem.sendstate > 0">已发送{{ gtem.sendstate }}条</span>
							<button class="xgts" @click="changenum(gtem.userid, gtem.mtimesmp)" v-if="admin == 'y'">修改发送条数</button>
							<span style="position: relative;float: right;">导入时间:{{ gtem.mtimesmp | timestampToTime }}</span>
						</el-radio>
						<div class="xian"></div>
					</div>
					<!-- <el-checkbox-group v-model="checkList" @change="handleCheckedCitiesChange">
						<div class="checksty" v-for="(gtem, index) in alllist" :key="index">
							<el-checkbox :label="gtem">第{{index+1}}批次 ({{gtem.length}}条数据)</el-checkbox>
							<div class="xian"></div>
						</div>
					</el-checkbox-group> -->
				</div>
			</div>
			<div class="boottomarea">
				<!-- 	<el-checkbox :indeterminate="isIndeterminate" style="margin-left: 22px;" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox> -->
				<!-- <el-pagination
					class="fenpage"
					background
					@size-change="handleSizeChange"
					@current-change="handleCurrentChange"
					:page-size="100"
					layout="prev, pager, next, jumper"
					:total="1000"
				></el-pagination> -->
				<div class="mooe">
					共
					<span style="color: #00C3FF;">{{ allnum }}</span>
					批
				</div>
			</div>
		<!-- 	<div class="dibu">发送</div> -->
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
			allnum: '',
			daolist: '',
			modalmessage: '',
			admin: '',
			dialogTableVisible: false,
			mobilepriceval: '',
			usenameval: '',
			passwordval: ''
		};
	},
	created: {},
	mounted() {
		_this = this;
		document.querySelector('body').setAttribute('style', 'background-color:rgba(246, 246, 246, 1)');
		window.addEventListener('beforeunload', e => this.remove(e));
		token = localStorage.getItem('token');
		this.getuserinfo();
		/* this.$refs.upload.addEventListener('change', e => {
			//绑定监听表格导入事件
			this.readExcel(e);
		}); */
	},
	methods: {
		changenum(userid, timesmpstr) {
			window.console.log(userid, timesmpstr);
			this.$prompt('请输入已发条数', '提示', {
				confirmButtonText: '确定',
				cancelButtonText: '取消',
				inputPattern: /^[0-9]*$/,
				inputErrorMessage: '请输入数字'
			})
				.then(({ value }) => {
					if(value==""||value==null){
						this.open("内容不能为空")
						return false
					}
				let param = { userid: userid, token: token, timesmpstr: timesmpstr,sendstate:value };
				https.fetchGet('/updatesendnum', param).then(data => {
					if (data.data.state == 1) {
						this.getuserinfo();
					} else if (data.data.state == 0) {
						this.open(data.data.msg);
						this.$router.push({ path: '/' });
					}
					window.console.log(data);
				
				});
				})
				.catch(() => {
					
				});
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
					window.console.log(action)
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
		remove() {},
		loadTextFromFile(e) {
			if(this.textarea==''||this.textarea==null){
				this.open('发送内容不能为空')
				document.getElementById('getFile').value = null;
				return false
			}
			let file = e.target.files[0];
			let reader = new FileReader();
			reader.onload = e => this.dealNum(e);
			reader.onerror = e => this.error(e);
			reader.readAsText(file);
			this.$refs.uploadExcelId.value = null;
		},
		dealNum(e) {
			this.phonelist = e.target.result.split('\r\n');
		
			let param = { phonelist: this.phonelist, token: token ,textarea:this.textarea};

			https.fetchPost('/insertMobile', JSON.stringify(param)).then(data => {
				window.console.log(data);
				if (data.data.state == 1) {
					this.open('导入成功');
					document.getElementById('getFile').value = null;
					_this.getuserinfo();
				} else if (data.data.state == 0) {
					this.open(data.data.msg);
					this.$router.push({ path: '/' });
				}
			});
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
			let param = { token: token };
			https.fetchGet('/userinfo', param).then(data => {
				window.console.log(data);
				if (data.data.state == 0) {
					this.open(data.data.msg);
					this.$router.push({ path: '/' });
				} else if (data.data.state == 1) {
					if (data.data.msg == 'admin') {
						this.admin = 'y';
					} else {
						this.monety = data.data.msg;
					}
					this.alllist = data.data.pageitems.content;
					this.allnum = this.alllist.length;
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
			window.console.log(`当前页: ${val}`);
		}
		/* 		handleCheckAllChange(val) {
			this.checkList = val ? this.alllist : [];
			this.isIndeterminate = false;
		} */
	}
};
</script>

<style scoped>
.xgts {
	line-height: 20px;
	text-align: center;
	font-size: 13px;
	margin-left: 10px;
}
.kaihu {
	width: 150px;
	height: 40px;
	background-color: #00c3ff;
	border-radius: 6px;
	color: #eeeeee;
	text-align: center;
	line-height: 40px;
	font-size: 20px;
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
	margin-top: 0px;
}
.kuangti {
	width: 1198px;
}
.mooe {
	position: relative;
	margin-left: 1000px;
	font-size: 15px;
}
.dibu {
	width: 443px;
	height: 41px;
	background: rgba(0, 195, 255, 1);
	border-radius: 1px;
	font-size: 15px;
	font-weight: 400;
	color: rgba(255, 255, 255, 1);
	line-height: 41px;
	text-align: center;
	margin-top: 60px;
}
.fenpage {
	margin-left: 580px;
}
.boottomarea {
	display: flex;
	width: 1226px;
	height: 40px;
	align-items: center;
	margin-top: 40px;
}
.allphone::-webkit-scrollbar {
	/*滚动条整体样式*/
	width: 4px; /*高宽分别对应横竖滚动条的尺寸*/
	height: 4px;
}
.allphone::-webkit-scrollbar-thumb {
	/*滚动条里面小方块*/
	border-radius: 5px;
	-webkit-box-shadow: inset 0 0 5px rgba(216, 216, 216, 1);
	background: rgba(0, 0, 0, 0.2);
}
.allphone::-webkit-scrollbar-track {
	/*滚动条里面轨道*/
	-webkit-box-shadow: inset 0 0 5px rgba(216, 216, 216, 1);
	border-radius: 0;
	background: rgba(216, 216, 216, 1);
}
.xian {
	width: 1198px;
	height: 1px;
	margin-top: 10px;
	opacity: 0.5;
	background-color: rgba(209, 216, 245, 0.6);
}
.checksty {
	height: 70px;
	display: inline-block;
	width: 1198px;
}
.allphone {
	overflow: auto;
	position: relative;
	width: 1226px;
	height: 326px;
	background: rgba(255, 255, 255, 1);
	border-radius: 2px;
	border: 0.5px solid rgba(209, 216, 245, 1);
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
.toparea2 > div:nth-of-type(1) {
	width: 1224px;
	font-size: 17px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
	margin-top: 22px;
}
.toparea2 > div:nth-of-type(2) {
	width: 1224px;
	background: rgba(246, 246, 246, 1);
	border-radius: 1px;
	opacity: 0.5;
	border: 1px solid rgba(209, 216, 245, 1);
}
.toparea2 > div:nth-of-type(3) {
	width: 1224px;
	font-size: 17px;
	font-weight: 600;

	color: rgba(51, 51, 51, 1);
	margin-top: 31px;
}
.toparea2 > div:nth-of-type(4) {
	margin-top: 26px;
	width: 1224px;
	height: 53px;
	background: RGBA(251, 251, 251, 1);
	border-radius: 1px;
	display: flex;
	align-items: center;
}
.toparea2 > div:nth-of-type(4) > div:nth-of-type(1) {
	margin-left: 5px;
	font-size: 16px;
	font-weight: 400;
	color: rgba(102, 102, 102, 1);
}
.toparea2 > div:nth-of-type(4) > div:nth-of-type(2) {
	margin-left: 803px;
	width: 119px;
	height: 32px;
	border-radius: 4px;
	border: 1px solid rgba(69, 141, 254, 1);
	font-size: 14px;
	font-weight: 400;
	line-height: 32px;
	text-align: center;
	color: rgba(69, 141, 254, 1);
}
.toparea2 > div:nth-of-type(4) > label {
	margin-left: 50px;
	width: 119px;
	height: 32px;
	border-radius: 4px;
	border: 1px solid rgba(69, 141, 254, 1);
	font-size: 14px;
	font-weight: 400;
	line-height: 32px;
	text-align: center;
	color: rgba(69, 141, 254, 1);
}
.toparea2 {
	flex-direction: column;
	display: flex;
	align-items: center;
	height: 908px;
	width: 100%;
	margin-top: 7px;
	background: rgba(255, 255, 255, 1);
}
.toparea1 {
	width: 100%;
	height: 71px;
	background: rgba(255, 255, 255, 1);
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
</style>
