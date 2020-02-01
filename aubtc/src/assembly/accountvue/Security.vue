<template>
	<div>
		<div class="security">
			<div class="security-1">
				<div style="position: absolute;margin-top: 20px;">
					<div class="security-1-1">
						Increase your account security(
						<span style="color: red;">2</span>
						/4)
					</div>
					<div class="security-1-2">
						<div class="security-1-2-1">
							<div>
								<img src="../../../static/wancheng.png" class="securimg" />
								<span>Enable 2FA</span>
							</div>
							<div style="margin-top: 26px;">
								<img src="../../../static/wancheng.png" class="securimg" />
								<span>Verify identity</span>
							</div>
						</div>
						<div style="width: 50px;"></div>
						<div class="security-1-2-2">
							<div>
								<img src="../../../static/weiwancheng.png" class="securimg" />
								<span>Enable Anti-phishing Code</span>
							</div>
							<div style="margin-top: 26px;">
								<img src="../../../static/wancheng.png" class="securimg" />
								<span>Turn-on withdrawal whitelist</span>
							</div>
						</div>
					</div>
					<div></div>
				</div>
			</div>
			<div class="security-2">
				<div v-for="(item, index) in mangenlist" :key="index" class="security-2-item">
					<div class="security-2-1">
						<div class="security-2-1-1">{{ item.text }}</div>
						<div class="security-2-1-2">{{ item.value }}</div>
					</div>
				</div>
			</div>
			<div class="security-3">
				<div style="height: 17px;"></div>
				<div class="security-3-1">
					<div class="security-3-1-1">Address Management</div>
					<div class="security-3-1-2">Manage</div>
				</div>
				<div class="security-3-2">
					Address Management allows you to save and write memos fot each of your withdrawal addresses. The optional White list function helps protect your funds by only
					allowing withdrawals to whitelisted addresses.
				</div>
				<div class="security-3-3">
					<div class="testswitch">
						<input class="testswitch-checkbox" id="onoffswitch" type="checkbox" />
						<label class="testswitch-label" for="onoffswitch">
							<span class="testswitch-inner" data-on="ON" data-off="OFF"></span>
							<span class="testswitch-switch"></span>
						</label>
					</div>
					<span class="security-3-3-1">Whitelist off</span>
					<img class="security-3-3-2"  src="../../../static/switchtan.png"/>
				</div>
			</div>
		</div>
		<div class="security2">
			<div class="security2-1">
				<div></div>
				<div></div>
				<div></div>
			</div>
			<div class="security2-2"></div>
			<div class="security2-3"></div>
			<div class="security2-4"></div>
		</div>
	</div>
</template>

<script>
export default {
	components: {},
	data() {
		return {
			value1: '1',
			switchvalue: '',
			mangenlist: [{ text: 'Device Management', value: 'Manage' }, { text: 'Login Password', value: 'Change' }, { text: 'Chang Email', value: 'Change' }]
		};
	},
	mounted() {},
	methods: {
		changeSwitch(val) {
			window.console.log(val);
		}
	}
};
</script>

<style>
	.security-3-3-2{
		width: 15px;
		height: 15px;
		margin-left: 2px;
	}
	.security-3-3-1{
		font-size:16px;
		font-weight:bold;
		color:rgba(51,51,51,1);
		margin-left: 100px;
	}
	.security-3-3{
	width: 436px;
	margin-top: 10px;
	display: flex;
	align-items: center;
	}
.testswitch {
	position: absolute;
	width: 90px;
	margin: 0;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
}

.testswitch-checkbox {
	display: none;
}

.testswitch-label {
	display: block;
	overflow: hidden;
	cursor: pointer;
	border-radius: 20px;
}

.testswitch-inner {
	display: block;
	width: 200%;
	margin-left: -100%;
	transition: margin 0.3s ease-in 0s;
}

.testswitch-inner::before,
.testswitch-inner::after {
	display: block;
	float: right;
	width: 50%;
	height: 30px;
	padding: 0;
	line-height: 30px;
	font-size: 14px;
	color: white;
	font-family: Trebuchet, Arial, sans-serif;
	font-weight: bold;
	box-sizing: border-box;
}

.testswitch-inner::after {
	content: attr(data-on);
	padding-left: 10px;
	background-color: #00e500;
	color: #ffffff;
}

.testswitch-inner::before {
	content: attr(data-off);
	padding-right: 10px;
	background-color:RGBA(182, 179, 182, 1);
	color:white;
	text-align: right;
}

.testswitch-switch {
	position: absolute;
	display: block;
	width: 22px;
	height: 22px;
	margin: 0px;
	background: white;
	top: 2px;
	bottom: 0;
	right: 60px;
	border: 2px solid #999999;
	border-radius: 20px;
	transition: all 0.3s ease-in 0s;
}

.testswitch-checkbox:checked + .testswitch-label .testswitch-inner {
	margin-left: 0;
}

.testswitch-checkbox:checked + .testswitch-label .testswitch-switch {
	right: 0px;
}

.security-3-2 {
	width: 436px;
	height: 85px;
	font-size: 16px;
	font-weight: 400;
	color: rgba(153, 153, 153, 1);
	line-height: 19px;
	margin-top: 27px;
}
.security-3-1-1 {
	font-size: 18px;
	font-weight: 600;
	color: rgba(51, 51, 51, 1);
}
.security-3-1-2 {
	width: 116px;
	height: 31px;
	margin-left: 130px;
	border: 1px solid rgba(41, 47, 136, 1);
	font-size: 12px;
	font-weight: 400;
	line-height: 31px;
	text-align: center;
	color: rgba(41, 47, 136, 1);
}
.security-3-1 {
	display: flex;
	align-items: center;
}
.security-2-1-1 {
	font-size: 18px;
	font-weight: bold;
	margin-left: 31px;
	color: rgba(51, 51, 51, 1);
}
.security-2-1-2 {
	width: 71px;
	height: 31px;
	border: 1px solid rgba(238, 238, 238, 1);
	text-align: center;
	line-height: 31px;
	margin-left: 350px;
	font-size: 12px;
	position: absolute;
	font-weight: 600;
	color: rgba(102, 102, 102, 1);
}
.security-2-2 {
	width: 455px;
	height: 1px;
	background: rgba(238, 238, 238, 1);
	opacity: 0.5;
	margin-left: 18px;
}
.security-2-1 {
	display: flex;
	align-items: center;
	height: 70px;
}
.security-2-1 > div:nth-of-type(1) {
	font-size: 18px;
	font-weight: 400;
	color: rgba(51, 51, 51, 1);
}
.security-2-1 > div:nth-of-type(2) {
	width: 71px;
	height: 31px;
	border: 1px solid rgba(238, 238, 238, 1);
}
.securimg {
	width: 14px;
	height: 14px;
}
.security-1-2 {
	width: 100%;
	display: flex;
	font-size: 18px;
	font-weight: 400;
	margin-top: 54px;
	color: rgba(102, 102, 102, 1);
}

.security-1-2-1 {
	margin-left: 26px;
}
.security-1-2-2 {
}
.security-1-1 {
	font-size: 18px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-left: 24px;
}
.security {
	margin-left: 334px;
	margin-top: 17px;
	position: absolute;
}
.security-1 {
	width: 493px;
	height: 192px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
}
.security-2 {
	width: 492px;
	height: 217px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 8px;
}
.security-3 {
	width: 492px;
	height: 282px;
	display: flex;
	flex-direction: column;
	align-items: center;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 11px;
}

.security2 {
	margin-left: 836px;
	margin-top: 17px;
	position: absolute;
}
.security2-1 {
	width: 492px;
	height: 192px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
}
.security2-2 {
	width: 492px;
	height: 217px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 8px;
}
.security2-3 {
	width: 492px;
	height: 181px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 11px;
}
.security2-4 {
	width: 492px;
	height: 93px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 11px 0px rgba(220, 220, 220, 0.5);
	border-radius: 1px;
	margin-top: 8px;
}
</style>
