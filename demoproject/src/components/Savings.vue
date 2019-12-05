<template>
  <div>
   <v-sell></v-sell>
   <div class="savings1">
     <div class="savings1-1">Price List</div>
     <div class="savingall">
     <div  class="savings1-2" >
      <div>
        <span>$</span>
        <span>12</span>
      </div>
      <div>/1 month</div>
      <div class="savxian"></div>
      <div class="savbox">
           <li>Award-winning, 24/7 support</li>
            <li>Optimized for eCommerce</li>
             <li>1TB Storage</li>
              <li>Free business email</li>
      </div>
      <div class="gobuy shou">Buy</div>
     </div>
     <div  class="savings1-2">
   <div>
        <span>$</span>
        <span>24</span>
      </div>
      <div>/2 month</div>
      <div class="savxian"></div>
      <div class="savbox">
          <li>Award-winning, 24/7 support</li>
           <li>Optimized for eCommerce</li>
            <li>1TB Storage</li>
             <li>Free business email</li>
      </div>
      <div class="gobuy shou">Buy</div>
     </div>
     <div  class="savings1-2">
   <div>
        <span>$</span>
        <span>39</span>
      </div>
      <div>/3 month</div>
      <div class="savxian"></div>
      <div class="savbox">
          <li>Award-winning, 24/7 support</li>
           <li>Optimized for eCommerce</li>
            <li>1TB Storage</li>
             <li>Free business email</li>
      </div>
      <div class="gobuy shou">Buy</div>
     </div>
     </div>

   </div>
   <div style="margin-top: 88px;">
     <v-footer></v-footer>
   </div>
</div>
</template>

<script>
  import sell from '../assembly/sell/sell.vue';
  import footer from '../assembly/foot/foot.vue';
  export default {
    components: {
      'v-sell': sell,
      "v-footer":footer
    },
    data() {
      return {

      };
    },
	created() {
		localStorage.setItem('clicksell',3);
	},
    mounted() {
      document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
    }
    }
</script>

<style>
  .gobuy{
    color:rgba(255,255,255,1);
    width:234px;
    height:62px;
    background:rgba(0,195,255,1);
    margin-top: 358px;
    font-size:19px;
    text-align: center;
    line-height: 62px;
  }
 .savbox{

display: flex;
flex-direction: column;
margin-top: 204px;
margin-left: 35px;
 }
 .savbox>li{
   font-size:14px;
   line-height: 24px;
   color:RGBA(155, 155, 155, 1);
 }
  .savxian{
  width:304px;
  height:0.5px;
  opacity: 0.5;
  margin-top: 169px;
background-color: rgba(151, 151, 151, 1);
    }
  .savings1-2>div:nth-of-type(2){
font-size:14px;
    color:RGBA(213, 213, 213, 1);
margin-top: 119px;
  }
  .savings1-2>div{
    position: absolute;
    display: flex;
    justify-content: center;
     width:304px;
  }
  .savings1-2>div>span:nth-of-type(1){
    font-size:19px;
    font-family:Helvetica;
    color:rgba(238,66,86,1);
    margin-top: 56px;
  }
  .savings1-2>div>span:nth-of-type(2){
    font-size:56px;
    font-family:Helvetica;
    color:rgba(238,66,86,1);
    margin-top:46px;
  }
  .savings1-2{
    width:304px;
    height:455px;
  background:rgba(255,255,255,1);
    border-radius:12px;
    display: inline-block;
    margin-top: 117px;
  }
  .savings1-1{
width:1169px;
font-size:30px;
text-align: center;
position: absolute;
margin-top: 39px;
font-weight:bold;
color:rgba(0,195,255,1);
    }
    .savingall{
      display: flex;
      justify-content: space-between;
      width:1069px;
      margin-left: 50px;
    }
  .savings1{

width:1169px;
height:599px;
background:rgba(255,255,255,1);
box-shadow:0px 2px 10px 0px rgba(220,220,220,0.5);
border-radius:1px;
border:1px solid rgba(232,232,232,1);
margin-left: 142px;
margin-top: 48px;
  }
</style>
