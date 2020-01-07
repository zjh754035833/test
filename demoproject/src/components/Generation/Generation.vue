<template>
	<div>
		<v-sell></v-sell>
		<div class="genenationall">
			<div class="genenation1" v-if="genenationtype == '1'">
				<div class="genenation1-1">Financial regulations require us to verify your identity. Once complete,you can sell and withdrew cryptocurrency.</div>
				<div class="genenation1-2">
					<div class="genenation1-2-1">
						<span>Title</span>
						<el-select v-model="form1.value1" clearable placeholder="Ms." class="xiala">
							<el-option v-for="item in options1" :key="item.value" :label="item.label" :value="item.value"></el-option>
						</el-select>
					</div>
					<div class="genenation1-2-2">
						<span>*</span>
						<span style="margin-left: 6px;">First Name</span>
						<input v-model="form1.firstnameval" />
						<span style="margin-left: 42px;">Middle Name</span>
						<input v-model="form1.middlenameval" />
						<span style="margin-left: 44px;">*</span>
						<span style="margin-left: 6px;">Last Name</span>
						<input v-model="form1.lastnameval" />
					</div>
					<div class="genenation1-2-3">
						<span>*</span>
						<span style="margin-left: 6px;">First Name</span>
						<el-select v-model="form1.value2" clearable placeholder="Month" class="xiala2">
							<el-option v-for="item in options2" :key="item.value" :label="item.label" :value="item.value"></el-option>
						</el-select>
						<el-select v-model="form1.value3" clearable placeholder="Day" class="xiala2">
							<el-option v-for="item in options3" :key="item.value" :label="item.label" :value="item.value"></el-option>
						</el-select>
						<el-select v-model="form1.value4" clearable placeholder="Year" class="xiala2">
							<el-option v-for="item in options4" :key="item.value" :label="item.label" :value="item.value"></el-option>
						</el-select>
					</div>
					<div class="genenation1-2-4">
						<span>*</span>
						<span style="margin-left: 6px;">Street Address</span>
						<input v-model="form1.addressval" />
						<input placeholder="City/town" v-model="form1.cityval" />
						<el-select v-model="form1.value1" clearable placeholder="Victoria" class="xiala2">
							<el-option v-for="item in options1" :key="item.value" :label="item.label" :value="item.value"></el-option>
						</el-select>
					</div>
					<div class="genenation1-2-5"><input placeholder="Post Code" v-model="form1.codeval" /></div>
					<div class="genenation1-2-6">
						<div @click="forclear" class="shou">Clear</div>
						<div @click="fornext(1)" class="shou">NEXT</div>
					</div>
				</div>
			</div>
			<div class="genenation2" v-if="genenationtype == '2'">
				<div style="margin-top: 32px;">
					<div class="genenation2-1">Passport Personal Informat ion page</div>
					<div class="genenation2-2">
						<div class="genenation2-2-1">
							<div class="area1">
								<el-upload
									action="https://jsonplaceholder.typicode.com/posts/"
									:on-preview="handlePreview"
									:on-remove="handleRemove"
									:before-remove="beforeRemove"
									multiple
									:limit="3"
									:on-exceed="handleExceed"
									:file-list="fileList"
								>
									<div class="upload-demo"><el-button size="small" type="primary">+Select upload picture</el-button></div>
								</el-upload>
								<div slot="tip" class="el-upload__tip">(.jpg .jpeg .jpe)</div>
							</div>
							<div>Selfie</div>
							<div class="area2">
								<el-upload
									action="https://jsonplaceholder.typicode.com/posts/"
									:on-preview="handlePreview"
									:on-remove="handleRemove"
									:before-remove="beforeRemove"
									multiple
									:limit="3"
									:on-exceed="handleExceed"
									:file-list="fileList"
								>
									<div class="upload-demo"><el-button size="small" type="primary">+Select upload picture</el-button></div>
								</el-upload>
								<div slot="tip" class="el-upload__tip">(.jpg .jpeg .jpe )</div>
							</div>
						</div>
						<div class="genenation2-2-2">
							<div>NOTE:</div>
							<div>
								<li>Uploaded photos must be in either PNG or JPEG (.jpg .jpeg .jpe .jfif .jif) format.</li>
								<li>Photos must be clear and high-resolution, with all information clearly visible.</li>
								<li>Photos and documents must not be edited or manipulated in any way.</li>
								<li>We only accept pictures taken in color.</li>
								<li>Documents presented must be original (not copies).</li>
								<li>No watermark on the photos.</li>
								<li>The ID must be valid (during its validity period).</li>
								<li>Your face must be clearly visible.</li>
								<li>Only one person per photo.</li>
							</div>
						</div>
					</div>
					<div class="alldi">
						<div class="return shou" @click="forreturn(2)">Return</div>
						<div class="Done shou" @click="fornext(2)">Done</div>
					</div>
				</div>
			</div>
			<div class="genenation2" v-if="genenationtype == '3'">
				<div style="margin-top: 12px;">
					<div class="genenation2-1">ID/Driver's license Front Side</div>
					<div class="genenation2-2">
						<div class="genenation2-2-1">
							<div class="area1" style="height: 145px;">
								<el-upload
									action="https://jsonplaceholder.typicode.com/posts/"
									:on-preview="handlePreview"
									:on-remove="handleRemove"
									:before-remove="beforeRemove"
									multiple
									:limit="3"
									:on-exceed="handleExceed"
									:file-list="fileList"
								>
									<div class="upload-demo"><el-button size="small" type="primary">+Select upload picture</el-button></div>
								</el-upload>
								<div slot="tip" class="el-upload__tip">(.jpg .jpeg .jpe)</div>
							</div>
							<div>ID/Driver's license Backside</div>
							<div class="area2" style="height: 145px;">
								<el-upload
									action="https://jsonplaceholder.typicode.com/posts/"
									:on-preview="handlePreview"
									:on-remove="handleRemove"
									:before-remove="beforeRemove"
									multiple
									:limit="3"
									:on-exceed="handleExceed"
									:file-list="fileList"
								>
									<div class="upload-demo"><el-button size="small" type="primary">+Select upload picture</el-button></div>
								</el-upload>
								<div slot="tip" class="el-upload__tip">(.jpg .jpeg .jpe )</div>
							</div>
						</div>
						<div class="genenation2-2-2" style="height: 333px;">
							<div>NOTE:</div>
							<div>
								<li>Uploaded photos must be in either PNG or JPEG (.jpg .jpeg .jpe .jfif .jif) format.</li>
								<li>Photos must be clear and high-resolution, with all information clearly visible.</li>
								<li>Photos and documents must not be edited or manipulated in any way.</li>
								<li>We only accept pictures taken in color.</li>
								<li>Documents presented must be original (not copies).</li>
								<li>No watermark on the photos.</li>
								<li>The ID must be valid (during its validity period).</li>
								<li>Your face must be clearly visible.</li>
								<li>Only one person per photo.</li>
							</div>
						</div>
					</div>
					<div class="Selfie">Selfie</div>
					<div class="areabutt">
						<el-upload
							action="https://jsonplaceholder.typicode.com/posts/"
							:on-preview="handlePreview"
							:on-remove="handleRemove"
							:before-remove="beforeRemove"
							multiple
							:limit="3"
							:on-exceed="handleExceed"
							:file-list="fileList"
						>
							<div class="upload-demo"><el-button size="small" type="primary">+Select upload picture</el-button></div>
						</el-upload>
						<div slot="tip" class="el-upload__tip">(.jpg .jpeg .jpe )</div>
					</div>
					<div class="alldi">
						<div class="return shou" @click="forreturn(3)">Return</div>
						<div class="Done shou" @click="fornext(3)">Done</div>
					</div>
				</div>
			</div>
			<div class="genenation4" v-if="genenationtype == '4'">
				<div class="genenation4-1">Choose the type of certificate</div>
				<div class="genenation4-2">Please select the type of certificate and make sure it is true and valid</div>
				<div class="genenation4-3">
					<div :class="[gentype1 == 'on' ? 'blue' : 'hui ']" @mouseenter="forblue(1)" @mouseleave="leaveblue(1)">
						<img src="../../../static/tt1.png" v-if="gentype1 == 'off'" />
						<img src="../../../static/tt2.png" v-if="gentype1 == 'on'" />
						<div v-if="gentype1 == 'off'">ID</div>
						<div style="color: white;" v-if="gentype1 == 'on'">ID</div>
					</div>
					<div :class="[gentype2 == 'on' ? 'blue' : 'hui ']" @mouseenter="forblue(2)" @mouseleave="leaveblue(2)">
						<img src="../../../static/tt3.png" v-if="gentype2 == 'off'" />
						<img src="../../../static/tt4.png" v-if="gentype2 == 'on'" />
						<div v-if="gentype2 == 'off'">Passport</div>
						<div style="color: white;" v-if="gentype2 == 'on'">Passport</div>
					</div>
					<div :class="[gentype3 == 'on' ? 'blue' : 'hui ']" @mouseenter="forblue(3)" @mouseleave="leaveblue(3)">
						<img src="../../../static/tt5.png" v-if="gentype3 == 'off'" />
						<img src="../../../static/tt6.png" v-if="gentype3 == 'on'" />
						<div v-if="gentype3 == 'off'">Driver's license</div>
						<div style="color: white;" v-if="gentype3 == 'on'">Driver's license</div>
					</div>
				</div>
				<div class="alldi">
					<div class="return shou" @click="forreturn(4)">Return</div>
					<div class="Done shou">Done</div>
				</div>
			</div>
		</div>
		<v-footer style="margin-top: 30px;"></v-footer>
	</div>
</template>

<script>
import sell from '../../assembly/sell/sell.vue';
import footer from '../../assembly/foot/foot.vue';
export default {
	data() {
		return {
			genenationtype: '1',
			form1: {
				value1: 'Ms.',
				value2: 'qqq',
				value3: '',
				value4: '',
				firstnameval: '',
				middlenameval: '',
				lastnameval: '',
				addressval: '',
				codeval: '',
				cityval: ''
			},
			gentype1: 'on',
			gentype2: 'off',
			gentype3: 'off',
			options1: [
				{
					value: '选项1',
					label: 'Ms.'
				},
				{
					value: '选项2',
					label: 'Mr.'
				}
			],
			options2: [
				{
					value: '1',
					label: '1.'
				},
				{
					value: '2',
					label: '2'
				},
				{
					value: '3',
					label: '3'
				}
			],
			options3: [
				{
					value: '1',
					label: '1.'
				},
				{
					value: '2',
					label: '2'
				},
				{
					value: '3',
					label: '3'
				}
			],
			options4: [
				{
					value: '1',
					label: '1.'
				},
				{
					value: '2',
					label: '2'
				},
				{
					value: '3',
					label: '3'
				}
			]
		};
	},
	created() {
		localStorage.setItem('clicksell', 3);
	},
	mounted() {
		document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
	},
	methods: {
		forblue(e) {
			if (e == 1) {
				this.gentype1 = 'on';
				this.gentype2 = 'off';
				this.gentype3 = 'off';
			} else if (e == 2) {
				this.gentype2 = 'on';
				this.gentype1 = 'off';
				this.gentype3 = 'off';
			} else if (e == 3) {
				this.gentype3 = 'on';
				this.gentype2 = 'off';
				this.gentype1 = 'off';
			}
		},
		leaveblue(e) {
			if (e == 1) {
				this.gentype1 = 'on';
				this.gentype2 = 'off';
				this.gentype3 = 'off';
			} else if (e == 2) {
				this.gentype2 = 'on';
				this.gentype1 = 'off';
				this.gentype3 = 'off';
			} else if (e == 3) {
				this.gentype3 = 'on';
				this.gentype2 = 'off';
				this.gentype1 = 'off';
			}
		},
		forkuang(e) {
			this.styletype = e;
		},
		leavekuang() {
			this.styletype = '2';
		},
		forclear() {
			this.form1 = {};
		},
		fornext(e) {
			this.genenationtype = e + 1;
		},
		forreturn(e) {
			this.genenationtype = e - 1;
		}
	},
	components: {
		'v-sell': sell,
		'v-footer': footer
	}
};
</script>

<style scoped="scoped" src="./generation.css">
</style>
