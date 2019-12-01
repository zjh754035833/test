<template>
	<div>
	<div class="newanction1">
		<div class="newanction1-1">
			<div class="shou" @click="forplace">Place a bid</div>
			<div>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer iaculis, lacus sed viverra interdum, nulla mi interdum eros, ac hendrerit urna lectus sit amet
				massa. Phasellus eget nisi eget lectus fringilla vehicula. Sed maximus velit ac lectus consequat condimentum. Etiam in accumsan quam.
			</div>
		</div>
		<div class="newanction1-2">
			<div>Creat an auction</div>
			<div>
				Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer iaculis, lacus sed viverra interdum, nulla mi interdum eros, ac hendrerit urna lectus sit amet
				massa. Phasellus eget nisi eget lectus fringilla vehicula. Sed maximus velit ac lectus consequat condimentum. Etiam in accumsan quam.
			</div>
		</div>
		<img src="../../static/y1.png" class="newanction1-3" />
		<img src="../../static/y2.png" class="newanction1-4" />
	</div>
	<div style="height: 27px;"></div>
	</div>
</template>

<script>
	/* import storage  from '../../src/plugins/localstorage.js' */
export default {
	components: {},
	data() {
		return {
			pagetype:""
		};
	},
	methods: {
		forplace() {
			this.$emit('pagetype', '2');
			/* storage.set(this.pagetype) */
		}
	},
	
};
</script>

<style>
.newanction1-2 > div:nth-of-type(2) {
	width: 438px;
	height: 162px;
	font-size: 17px;
	color: rgba(102, 102, 102, 1);
	line-height: 24px;
	position: absolute;
	margin-left: 46px;
	margin-top: 80px;
}
.newanction1-2 > div:nth-of-type(1) {
	font-size: 31px;
	font-weight: bold;
	color: rgba(51, 51, 51, 1);
	margin-top: 29px;
	position: absolute;
	margin-left: 42px;
}
.newanction1-2 {
	position: absolute;
	width: 494px;
	height: 262px;
	margin-left: 580px;
	margin-top: 326px;
}
.newanction1-1 > div:nth-of-type(1) {
	font-size: 31px;
	font-weight: bold;
	margin-top: 22px;
	position: absolute;
	color: rgba(51, 51, 51, 1);
}
.newanction1-1 > div:nth-of-type(2) {
	width: 462px;
	height: 162px;
	font-size: 17px;
	color: rgba(102, 102, 102, 1);
	line-height: 24px;
	margin-top: 72px;
}
.newanction1-1 {
	position: absolute;
	width: 476px;
	height: 262px;
	margin-left: 81px;
	margin-top: 33px;
}
.newanction1-3 {
	position: absolute;
	width: 476px;
	height: 262px;
	margin-left: 580px;
	margin-top: 33px;
}
.newanction1-4 {
	position: absolute;
	width: 476px;
	height: 262px;
	margin-top: 326px;
	margin-left: 81px;
}
.newanction1 {
	width: 1146px;
	height: 634px;
	background: rgba(255, 255, 255, 1);
	box-shadow: 0px 2px 17px 0px rgba(219, 219, 219, 0.5);
	margin-left: 147px;
	margin-top: 20px;
}
</style>
