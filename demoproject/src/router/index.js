import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '@/components/index'
import signup from '@/components/signup'
import login from '@/components/login'
import sellbuy from '@/components/sellbuy'
import Mining from '@/components/Mining'
import Savings from '@/components/Savings'
import Anction from '@/components/Anction'
import newAnction from '@/components/newAnction'
import Registsucess from '@/components/Registsucess'
import Myaccount from '@/components/Myaccount'
import SMS from '@/components/SMS'
import google from '@/components/google'
import place from '@/components/placeabid'
import placedetail from '@/components/placedetail'
import historybid from '@/components/historybid'
import createauction from '@/components/creatauction'
Vue.use(VueRouter)

const routes = [
 {
   path: '/',
   name: 'index',
   component: index
 },
 {
   path: '/signup',
   name: 'signup',
   component: signup
 },
 {
   path: '/login',
   name: 'login',
   component: login
 },
 {
   path: '/sellbuy',
   name: 'sellbuy',
   component: sellbuy
 },
 {
   path: '/Mining',
   name: 'Mining',
   component: Mining
 },
 {
   path: '/Anction',
   name: 'Anction',
   component: Anction
 },
 {
   path: '/newAnction',
   name: 'newAnction',
   component: newAnction
 },
 {
   path: '/Savings',
   name: 'Savings',
   component: Savings
 },
 {
   path: '/Registsucess',
   name: 'Registsucess',
   component: Registsucess
 },
 {
   path: '/Myaccount',
   name: 'Myaccount',
   component: Myaccount
 },
 {
   path: '/SMS',
   name: 'SMS',
   component: SMS
 },
 {
   path: '/google',
   name: 'google',
   component: google
 },
 {
   path: '/place',
   name: 'place',
   component: place
 },
 {
   path: '/placedetail',
   name: 'placedetail',
   component: placedetail
 },
 {
   path: '/historybid',
   name: 'historybid',
   component: historybid
 },
 {
   path: '/createauction',
   name: 'createauction',
   component: createauction
 },
]

const router = new VueRouter({
  routes
})

export default router
