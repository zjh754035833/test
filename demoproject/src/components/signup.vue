<template>
  <div >
  <div class="area">
  <v-head>

  </v-head>
  <div class="box5 " @click="hreflogin">
        login
      </div>
<div class="halfarea">
  <div class="half1">Create a free account</div>
  <input class="half2" placeholder="Phone email"/>
    <input class="half2" style="margin-top: 228px;"  placeholder="Phone number"/>
    <input class="half2" style="margin-top:320px;" placeholder="password"/>
    <div class="half3">At least 8 characters, must include UPPER CASE letters and numbers</div>
    <div class="half4"><el-checkbox></el-checkbox>
    <span>I am over 18 years old, and I agree to the Binance Terms of Use
     </span>
    </div>
    <div class="half5">Auwels’s Terms of Use</div>
    <div class="half6">Create account</div>
    <div class="half7">
      <span>Already registered? </span>
       <span style="color: rgba(69, 141, 254, 1);">Log In</span>
    </div>
</div>
  </div>
  </div>
</template>

<script>
  import head from '../../build/head/head.vue'

  export default {
   components: {
      'v-head':head
     },
     methods:{
       hreflogin(){
          this.$router.push({ path: '/login' });
       }
     }
     }
</script>

<style scoped>
 .box5 {
    cursor: pointer;
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
::-webkit-input-placeholder {/*Chrome/Safari*/
　　font-size:18px;
color:rgba(153,153,153,1);

}
::-moz-placeholder {/*Firefox*/
　　　font-size:18px;
color:rgba(153,153,153,1);
}
::-ms-input-placeholder {/*IE*/
　　　　font-size:18px;
color:rgba(153,153,153,1);
}
  .half7{
width: 668px;
text-align: center;
margin-top: 113px;
  }
  .half6{
  width:534px;
  height:58px;
  background:rgba(69,141,254,1);
  border-radius:1px;
  position: absolute;
  margin-top: 32px;
  margin-left: 67px;
  color:rgba(255,255,255,1);
  font-size:22px;
  line-height: 58px;
  text-align: center;
  }
  .half5{
font-size:16px;
color:rgba(69, 141, 254, 1);
margin-top: 468px;
margin-left: 87px;
  }

  .half4{
position: absolute;
margin-top: 443px;
font-size:16px;
margin-left: 62px;
color:rgba(102,102,102,1);
  }
  .half3{
position: absolute;
margin-top: 395px;
font-size:15px;
color:rgba(102,102,102,1);
margin-left: 62px;
  }
.area{
 width: 1440px;
   height: 894px;
   background-image: url('../../static/Cover.png');
   background-size: 100%;
   overflow: hidden;

}
.half2{
position: absolute;
margin-top: 134px;
width: 540px;
border:none;
  border-bottom: #c0c0c0 1px solid;
  outline:none;
  margin-left: 64px;
  color:rgba(51,51,51,1);
}
.half1{
width:668px;
  font-size:30px;
  color:rgba(51,51,51,1);
  text-align: center;
  position: absolute;
  margin-top: 51px;
}
.halfarea{
width:668px;
height:675px;
background:rgba(255,255,255,1);
box-shadow:0px 2px 22px 0px rgba(0,0,0,0.5);
border-radius:12px;
position: absolute;
left: 386px;
top: 162px;
}
</style>
