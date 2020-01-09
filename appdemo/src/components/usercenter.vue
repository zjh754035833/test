<template>
	<div>
		<v-head></v-head>
		<img src="../../static/user1.png" class="userimg" />
		<div class="userall">
			<div class="userall1">
				<div class="userall1-1">
					<span>User Center</span>
					<div class="userall1-2">
						<div>
							<span class="user1">User Name :</span>
							<span class="user2">Doggige Yang</span>
						</div>
						<div style="margin-top: 20px;">
							<span class="user1">Type of membership：</span>
							<span class="user2">Individual</span>
							<span class="user1" style="margin-left: 50px;">Account Type：</span>
							<span class="user2">Star Member</span>
							<img src="../../static/xingxing.png" style="height: 18px;width: 18px;margin-left: 10px;" />
						</div>
					</div>
				</div>
				<!-- <div class="userall1-2">
					<span>Account Type：</span>
					<span>Star Member</span>
					<img  src="../../static/xingxing.png" style="height: 18px;width: 18px;margin-left: 10px;"/>
				</div> -->
			</div>
			<div class="userall2">
				<div class="userall2-1">Message</div>
				<div class="userall2-2">
					<div class="userall2-2-2">
						<div class="resorce1-1">
							<input placeholder="Bitcoin exchange rate" />
							<div class="shou">
								<img src="../../static/fangda.png" />
								<span>Search</span>
							</div>
						</div>
						<el-select v-model="value" placeholder="Any" class="selectall">
							<el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
						</el-select>
					</div>
					<el-table :data="tableData" style="width: 100%">
						<el-table-column prop="Subject" label="Subject"></el-table-column>
						<el-table-column prop="Date" label="Date" width="180"></el-table-column>
						<el-table-column prop="Status" label="Status" width="120"></el-table-column>
					</el-table>
				</div>
			</div>
		</div>
		<v-foot></v-foot>
	</div>
</template>

<script>
import head from '../assembly/head/head.vue';
import foot from '../assembly/foot/foot.vue';
export default {
	components: {
		'v-head': head,
		'v-foot': foot
	},
	data() {
		return {
			options: [],
			value: '',
			tableData: [
				{
					Subject: 'Test',
					Date: '2020-01-03',
					Status: 'Read'
				},
				{
					Subject: 'Test',
					Date: '2020-01-03',
					Status: 'Read'
				},
				{
					Subject: 'Test',
					Date: '2020-01-03',
					Status: 'Read'
				},
				{
					Subject: 'Test',
					Date: '2020-01-03',
					Status: 'Read'
				},
				{
					Subject: 'Test',
					Date: '2020-01-03',
					Status: 'Read'
				},
				{
					Subject: 'Test',
					Date: '2020-01-03',
					Status: 'Read'
				}
			]
		};
	},
	computed: {},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:whitesmoke');
	},
	methods: {},
	created() {}
};
</script>

<style scoped="scoped">
	.user1{
		font-size:20px;
		font-weight:400;
		color:rgba(153, 153, 153, 1);
		
		}
		.user2{
			font-size:20px;
			font-weight:400;
			margin-left: 10px;
			color:rgba(51, 51, 51, 1);
			
			}
.userall1-2 {
	margin-left: 27px;
}
.selectall {
	width: 142px;
	height: 48px;
	margin-left: 17px;
}
.resorce1-1 {
	display: flex;
}
.resorce1-1 > div > img {
	width: 23px;
	height: 23px;
}
.resorce1-1 > div {
	width: 133px;
	height: 48px;
	display: flex;
	justify-content: center;
	align-items: center;
	background: rgba(255, 227, 145, 1);
	border: 1px solid rgba(255, 227, 145, 1);
}
.resorce1-1 > input {
	width: 480px;
	height: 48px;
	padding-left: 20px;
	background: rgba(255, 255, 255, 1);
	border-radius: 1px;
	border: 1px solid rgba(238, 238, 238, 1);
}
.userall2-2-2 {
	width: 862px;
	height: 88px;
	background: rgba(238, 238, 238, 1);
	display: flex;
	align-items: center;
	justify-content: center;
}
.userall2-1 {
	font-size: 25px;
	margin-left: 218px;
	font-weight: 500;
	color: rgba(51, 51, 51, 1);
}
.userall2 {
	margin-top: 54px;
	display: flex;
}
.userall2-2 {
	width: 862px;
	margin-left: 50px;
	height: 448px;
	margin-bottom: 50px;
}

.userall1-2 > span:nth-of-type(1) {
	font-size: 20px;
	font-weight: 500;
	color: rgba(153, 153, 153, 1);
}
.userall1-2 > span:nth-of-type(2) {
	font-size: 20px;
	font-weight: 500;
	color: rgba(51, 51, 51, 1);
}
.userall {
}
.userimg {
	width: 100%;
	height: 68px;
}
.userall1-1 {
	display: flex;
	margin-left: 218px;
	margin-top: 72px;
}
.userall1-1 > span:nth-of-type(1) {
	font-size: 25px;
	font-weight: 500;
	color: rgba(51, 51, 51, 1);
}
</style>
