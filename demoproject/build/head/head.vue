<template>
  <div class="halfarea-1">
         <span class="box1">AUWELS</span>
         <div class="box3">
           <span @click="forbuyshell">Buy/Sell</span>
           <span  @click="forAnction">Anction</span>
           <span  @click="forSavings">Savings</span>
           <span  @click="forMining">Mining</span>
         </div>
         <img src="../../static/Fill.png" class="box2" />
     <!--    <div class="box5">
           login
         </div> -->
       </div>
</template>

<script>

  export default {

    components: {
    },
    methods: {
  forbuyshell(){
   this.$router.push({ path: '/sellbuy' });
      },
  forAnction(){
     this.$router.push({ path: '/Anction' });
  },
  forSavings(){
     this.$router.push({ path: '/Savings' });
  },
  forMining(){
     this.$router.push({ path: '/Mining' });
  }
    }
  };
</script>

<style scoped="scoped">
  .box5 {
    position: absolute;
    margin-top: 30px;
   width:95px;
   height:31px;
   background:RGBA(134, 220, 248, 1);
   border-radius:2px;
    margin-left: 1240px;
    font-size:18px;
   color:rgba(255,255,255,1);
    line-height: 31px;
    text-align: center;
  }


  .box3 {
    position: absolute;
    margin-top: 30px;
    display: flex;
    font-size: 18px;
    font-weight: normal;
    color: rgba(255, 255, 255, 1);
  }
  .box3:nth-of-type(1) {
    margin-left: 380px;
  }
  .box3 > span {
    margin-left: 54px;
      cursor: pointer;
  }
  .box2 {
    position: absolute;
    margin-left: 134px;
    margin-top: 28px;
    width: 37px;
    height: 34px;
  }
  .box1 {
    position: absolute;
    margin-top: 19px;
    margin-left: 196px;
    font-size: 34px;
    font-weight: 900;
    color: rgba(255, 255, 255, 1);
  }

</style>
