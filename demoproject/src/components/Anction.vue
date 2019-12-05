<template>
  <div>
     <v-sell></v-sell>
     <div class="anction1">
       <div class="anction1-1">
         <span>BTC</span>
             <span>/USDT</span>
       </div>
        <div>serial number 090098</div>
         <div>In order to ensure that the package price is competitive in the market, the price of the product will be dynamically adjusted according to market conditions, demand and mining difficulty. This is one of the advantages of BitDeer over other platforms. For example, when mining difficulty drops dramatically, we will quickly introduce new price adjustments.</div>
    <div>Buy</div>
     </div>
     <div class="anction2">
       <div class="anction2-1">Distance start</div>
       <div class="anction2-2"></div>
       <img src="../../static/money.png"  class="anction2-3"/>
       <div class="anction2-4">
         <div>{{h}}</div>
           <div>:</div>
             <div>{{m}}</div>
             <div>:</div>
               <div>{{s}}</div>
       </div>
     </div>
     <div class="anction3">
<div class="anction3-1">Real-time bidding</div>
     </div>
     <div style="margin-top: 75px;">
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
      h: '00',
      m: '00',
      s: '00',
      };
    },
    methods:{
      countTime: function () {
                      //获取当前时间
                      var date = new Date();
                      var now = date.getTime();
                      //设置截止时间
                      var endDate = new Date("2020-12-22 23:23:23");
                      var end = endDate.getTime();
                      //时间差
                      var leftTime = end - now;
                      //定义变量 d,h,m,s保存倒计时的时间
                      if (leftTime >= 0) {
                          this.h = Math.floor(leftTime / 1000 / 60 / 60 % 24);
                          this.m = Math.floor(leftTime / 1000 / 60 % 60);
                          this.s = Math.floor(leftTime / 1000 % 60);
                          if(this.h<10){
                             this.h="0"+ this.h
                          }
                          if(this.m<10){
                             this.m="0"+ this.m
                          }
                          if(this.s<10){
                             this.s="0"+ this.s
                          }
                      }else{
                        this.h = '00';
                        this.m = '00';
                        this.s = '00';
                        }
                      //递归每秒调用countTime方法，显示动态时间效果
                      setTimeout(this.countTime, 1000);
                  }
    },

    mounted() {
      this.countTime();
      document.querySelector('body').setAttribute('style', 'background-color:#F0F0F0');
    }

  };
</script>

<style>
  .anction3-1{
    width:263px;
    height:44px;
    font-size:15px;
    font-weight: bold;
    color:rgba(51,51,51,1);
    background:RGBA(248, 248, 248, 1);
    border-radius:1px;
    position: absolute;
    justify-content: center;
    display: flex;
    align-items: center;
  }
  .anction3{
width:263px;
height:422px;
background:rgba(255,255,255,1);
box-shadow:0px 2px 11px 0px rgba(220,220,220,0.5);
border-radius:1px;
display: inline-block;
  }
  .anction2-4>div:nth-of-type(odd){
  width:44px;
  height:44px;
  background:rgba(176,142,112,1);
  color: rgba(255,255,255,1);;
  text-align: center;
  line-height:44px ;
  border-radius:1px;
    }
  .anction2-4>div:nth-of-type(even){
    text-align: center;
    line-height: 44px;
    color:rgba(255,255,255,1);
    font-size: 18px;
width:33px;
height:44px;
background:rgba(0,17,35,1);
border-radius:1px;
  }
  .anction2-4{
    margin-top: 114px;
    margin-left: 42px;
    display: flex;
    position: absolute;
    }
  .anction2-3{
    width:195px;
    height:189px;
    border-radius:1px;
    position: absolute;
    margin-top: 194px;
    margin-left: 46px;
  }
  .anction2-2{
    width:30px;
    height:1px;
    background-color: rgba(156, 162, 169, 1);
    position: absolute;
    margin-top: 79px;
    margin-left: 128px;

  }
  .anction2-1{
    margin-top: 39px;
position: absolute;
width:286px;
text-align: center;
font-size:18px;
color:rgba(156,162,169,1);
    }
  .anction2{
height:422px;
width:286px;
background-color:rgba(0,17,35,1);
border-radius:1px;
display: inline-block;
  }
  .anction1>div:nth-of-type(4){
width:178px;
height:57px;
background:rgba(213,213,213,1);
border-radius:2px;
color:rgba(255,255,255,1);
line-height:57px ;
text-align: center;
position: absolute;
margin-left: 31px;
margin-top: 331px;

    }
  .anction1>div:nth-of-type(3){
   width:480px;
   height:202px;
   font-size:18px;
   color:rgba(102,102,102,1);
   position: absolute;
   margin-top: 117px;
   margin-left: 40px;
   letter-spacing:0.5px;
   line-height: 24px;
    }
  .anction1>div:nth-of-type(2){
    font-size:18px;
    color:rgba(153,153,153,1);
  margin-left: 40px;
  margin-top: 78px;
  position: absolute;
    }
  .anction1-1>span{
position: absolute;
margin-left: 40px;
margin-top: 31px;
font-size:31px;
font-weight: bold;
  }
  .anction1-1>span:nth-of-type(2){
    position: absolute;
    margin-top: 31px;
    margin-left: 106px;
    margin-top: 41px;
font-size:19px;
color:rgba(153,153,153,1);
    }
  .anction1{
width:602px;
height:422px;
background:rgba(255,255,255,1);
box-shadow:0px 2px 11px 0px rgba(220,220,220,0.5);
border-radius:1px;
border:1px solid rgba(232,232,232,1);
margin-top: 61px;
margin-left: 109px;
display: inline-block;
  }
</style>
