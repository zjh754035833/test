<template>
	<div id="app"><router-view /></div>
</template>

<style>
body {
	margin: 0;
	padding: 0;
	font-size: 20px;
}
.shou {
	cursor: pointer;
}
.toolstyle {
	font-size: 14px;
	font-weight: 600;
	background-color: white !important;
	color:rgba(0,227,170,1) !important;
}
.el-tooltip__popper[x-placement^=top] .popper__arrow:after {
    border-top-color: rgba(0,227,170,1) !important;
}
.el-tooltip__popper[x-placement^=top] .popper__arrow {
    border-top-color: rgba(0,227,170,1) !important;
}
</style>
<script>
/* export default {
		data(){},
        mounted() {
			window.console.log('init!')
		}
	}; */
</script>
