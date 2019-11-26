import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '@/components/index'
import signup from '@/components/signup'
import login from '@/components/login'
import sellbuy from '@/components/sellbuy'
import Mining from '@/components/Mining'
import Savings from '@/components/Savings'
import Anction from '@/components/Anction'

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
   path: '/Savings',
   name: 'Savings',
   component: Savings
 }
]

const router = new VueRouter({
  routes
})

export default router
