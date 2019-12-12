import Vue from 'vue'
import VueRouter from 'vue-router'
// import index from '@/components/index'
// import signup from '@/components/signup'
import login from '@/components/login'
// import sellbuy from '@/components/sellbuy'
// import Mining from '@/components/Mining'
// import Savings from '@/components/Savings'
// import Anction from '@/components/Anction'
// import newAnction from '@/components/newAnction'
// import Registsucess from '@/components/Registsucess'
// import Myaccount from '@/components/Myaccount'
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
   component: () => import( /* webpackChunkName: "index" */ '@/components/index')
 },
 {
   path: '/signup',
   name: 'signup',
   component: () => import( /* webpackChunkName: "signup" */ '@/components/signup')
 },
 {
   path: '/login',
   name: 'login',
   component: login
 },
 {
   path: '/sellbuy',
   name: 'sellbuy',
   component: () => import( /* webpackChunkName: "sellbuy" */ '@/components/sellbuy')
 },
 {
   path: '/Mining',
   name: 'Mining',
   component: () => import( /* webpackChunkName: "Mining" */ '@/components/Mining')
 },
 {
   path: '/Anction',
   name: 'Anction',
   component: () => import( /* webpackChunkName: "Anction" */ '@/components/Anction')
 },
 {
   path: '/newAnction',
   name: 'newAnction',
   component: () => import( /* webpackChunkName: "newAnction" */ '@/components/newAnction')
 },
 {
   path: '/Savings',
   name: 'Savings',
   component: () => import( /* webpackChunkName: "Savings" */ '@/components/Savings')
 },
 {
   path: '/Registsucess',
   name: 'Registsucess',
   component: () => import( /* webpackChunkName: "Registsucess" */ '@/components/Registsucess')
 },
 {
   path: '/Myaccount',
   name: 'Myaccount',
   component: () => import( /* webpackChunkName: "Myaccount" */ '@/components/Myaccount')
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
