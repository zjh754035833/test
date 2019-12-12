import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '@/components/index'
import Artboard from'@/components/Artboard'
Vue.use(VueRouter)

const routes = [
 {
   path: '/',
   name: 'index',
   component: index
 },
 {
   path: '/Artboard',
   name: 'Artboard',
   component: Artboard
 },
]

const router = new VueRouter({
  routes
})

export default router
