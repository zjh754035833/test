<template>
	<div class="footall">
		<img src="../../../static/foot1.png" />
		<!-- <span>Company</span> -->
		
		<div> 
		<span>About</span> 
			<span>Our mission</span>
			<span>Standard</span>
		</div> 
		<div>
		<span>Membership</span>
			<span>Individual</span>
			<span>Corporation</span>
		</div>
		<div>
		<span>Academy</span>
			<span>Subscription</span>
			<span>Resource library</span>
		</div>
		<div>
	<!-- 	<img src="../../../static/foot2.png" />
		<img src="../../../static/foot3.png" />
		<img src="../../../static/foot4.png" /> -->
		</div>
	</div>
</template>

<script>
</script>

<style >
	.footall>div{
		font-size:13px;
		color:rgba(51,51,51,1);
	}
	.footall>div:nth-of-type(1){
		font-size:13px;
		color:rgba(51,51,51,1);
		margin-left: 42px;
	}
	.footall{
		width:100%;
		height:122px;
		border-radius:1px;
		background:rgba(245,245,245,1);
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.footall>img:nth-of-type(1){
		width: 146px;
		height: 49px;
		margin-left: 141px;
	}
	.footall>div>img{
		width: 29px;
		height: 44px;
		margin-left: 27px;
	}
.footall>div{
	display: flex;
	flex-direction: column;
		margin-right: 78px;
	}
	.footall>div>span{
		margin-top: 20px;
	}
</style>
