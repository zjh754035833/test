<template>
  <div>
     <v-sell></v-sell>
     <div class="ming1">BTC/BCH</div>
     <div class="ming2">The SHA256 mining machine sharing package currently supports BTC/BCH mining.</div>
     <div class="ming3">
       <div>
        <div>
          <span class="ming4">Round 1: Expected to start mining time</span>
          <div class="ming5"> 2019/11/20</div>
        </div>
        <div class="ming6">
            <div>
              <div class="ming6-1"></div>
             <span class="ming6-2">Minimum calculation fee</span>
              <span class="ming6-3">$0.0766/T</span>
            </div>
           <div>
             <div class="ming6-1" style="background:rgba(255,100,100,1);"></div>
            <span class="ming6-2">Minimum calculation fee</span>
             <span class="ming6-3">$0.0766/T</span>
           </div>
           <div>
             <div class="ming6-1" style="background:rgba(1,211,210,1);"></div>
            <span class="ming6-2">Minimum calculation fee</span>
             <span class="ming6-3">$0.0766/T</span>
           </div>
        </div>
        <div class="ming7">The daily net mining income is equal to the daily mining output minus the calculation fee and electricity fee.</div>
       </div>
        <div>
          <img src="../../static/shand.png"  class="shandian"/>
          <div class="ming7-1">$0.112/T</div>
          <div class="ming7-2">Buy now</div>

        </div>
     </div>
     <v-footer style="margin-top: 561px;"></v-footer>
  </div>
</template>

<script>
  import sell from '../../build/sell/sell.vue';
  import footer from '../../build/foot/foot.vue';
  export default {
    components: {
      'v-sell': sell,
      "v-footer":footer
    },
    data() {
      return {

      };
    },
    mounted() {
      document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
    }
  };
</script>

<style>
  .ming7-2{
    width:233px;
    height:50px;
    background:rgba(255,255,255,1);
    border-radius:1px;
    opacity:0.9185;
    position: absolute;
    margin-top: 151px;
    margin-left: 50px;
    font-size:26px;
    font-family:SFUIDisplay-Regular,SFUIDisplay;
    font-weight:400;
    color:rgba(238,66,86,1);
    line-height: 50px;
    text-align: center;
    }
  .ming7-1{
font-size:50px;
font-weight:bold;
color:rgba(255,255,255,1);
width:333px;
position: absolute;
text-align: center;
margin-top: 56px;
  }
  .shandian{
width:34px;
height:48px;
position: absolute;
margin-top: 30px;
margin-left: 21px;
  }
  .ming7{
font-size:12px;
font-weight:400;
color:rgba(255,255,255,1);
position: absolute;
margin-top: 190px;
margin-left: 50px;
    }
  .ming6-3{
    font-size:35px;
    position: absolute;
    color:rgba(255,255,255,1);
    margin-left: 54px;
    margin-top: 18px;
  }
  .ming6>div{
    width: 270px;
  }
  .ming6-2{
    margin-left: 54px;
    font-size:16px;
    color:rgba(255,255,255,1);
    position: absolute;
    }
  .ming6-1{
    width:2px;
    height:60px;
    background:rgba(248,231,28,1);
    border-radius:1px;
    margin-left: 35px;
      position: absolute;
  }
  .ming6{
display: flex;
margin-top: 93px;
position: absolute;
  }
  .ming5{
width:108px;
height:28px;
background:RGBA(99, 99, 99, 1);
border-radius:1px;
font-size:14px;
line-height: 28px;
text-align: center;
color:rgba(255,255,255,1);
position: absolute;
margin-top: 24px;
margin-left: 389px;
    }
  .ming4{
    margin-top: 28px;
    margin-left: 35px;
    position: absolute;
  font-size:18px;
  color:rgba(255, 255, 255, 1);
  }
  .ming3>div:nth-of-type(1){
    width: 860px;
    height:232px;
    background:rgba(46,46,46,1);
  }
  .ming3>div:nth-of-type(2){
    width:333px;
    height:232px;
    background:rgba(238,66,86,1);
    border-radius:1px;
  }

  .ming3{
width:1193px;
height:232px;
display: flex;
position: absolute;
margin-top: 241px;
margin-left: 124px;
  }
  .ming2{
   width: 1440px;
    font-size:22px;
    font-weight:400;
    color:rgba(153,153,153,1);
    text-align: center;
    position: absolute;
    margin-top: 161px;
  }
  .ming1{
font-size:50px;
font-weight:400;
color:rgba(51,51,51,1);
width: 1440px;
text-align: center;
position: absolute;
margin-top: 80px;
  }
</style>
