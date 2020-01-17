import Vue from 'vue'
import VueRouter from 'vue-router'

import login from '@/components/Registerlogin/login'

import SMS from '@/components/authenticator/SMS'
import google from '@/components/authenticator/google'
import emailsOK from '@/components/emailsOK'
import passwordisOK from '@/components/passwordisOK'
/* import place from '@/components/Anction/placeabid'
import placedetail from '@/components/Anction/placedetail'
import historybid from '@/components/Anction/historybid'
import createauction from '@/components/Anction/creatauction' */
Vue.use(VueRouter)

const routes = [
	/* {
		path: '/newAnction',
		name: 'newAnction',
		component: () => import( '@/components/Anction/newAnction')
	}, */
	{
		path: '/',
		name: 'index',
		component: () => import( /* webpackChunkName: "index" */ '@/components/index/index')
	},
	{
		path: '/Generation',
		name: 'Generation',
		component: () => import( /* webpackChunkName: "index" */ '@/components/Generation/Generation')
	},
	{
		path: '/Crypto',
		name: 'Crypto',
		component: () => import( /* webpackChunkName: "index" */ '@/components/Deposit/Crypto')
	},
	{
		path: '/withdraw',
		name: 'withdraw',
		component: () => import( /* webpackChunkName: "index" */ '@/components/withdraw/withdraw')
	},
	{
		path: '/Fiat',
		name: 'Fiat',
		component: () => import( /* webpackChunkName: "index" */ '@/components/Deposit/Fiat')
	},
	{
		path: '/changeEmail',
		name: 'changeEmail',
		component: () => import( /* webpackChunkName: "index" */ '@/components/changeEmail')
	},

	{
		path: '/signup',
		name: 'signup',
		component: () => import( /* webpackChunkName: "signup" */ '@/components/Registerlogin/signup')
	},
	{
		path: '/login',
		name: 'login',
		component: login
	},
	{
		path: '/sellbuy',
		name: 'sellbuy',
		component: () => import( /* webpackChunkName: "sellbuy" */ '@/components/sellbuy/sellbuy')
	},
	{
		path: '/Mining',
		name: 'Mining',
		component: () => import( /* webpackChunkName: "Mining" */ '@/components/Mining/Mining')
	},

	
	{
		path: '/Savings',
		name: 'Savings',
		component: () => import( '@/components/savings/Savings')
	},
	{
		path: '/Registsucess',
		name: 'Registsucess',
		component: () => import( /* webpackChunkName: "Registsucess" */ '@/components/Registerlogin/Registsucess')
	},
	{
		path: '/Myaccount',
		name: 'Myaccount',
		component: () => import( /* webpackChunkName: "Myaccount" */ '@/components/Myaccount/Myaccount')
	},
	{
		path: '/Purchase',
		name: 'Purchase',
		component: () => import( /* webpackChunkName: "Myaccount" */ '@/components/savings/Purchase')
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
		path: '/emailsOK/:text/',
		name: 'emailsOK',
		component: emailsOK
	},
	{
		path: '/passwordisOK/:text/',
		name: 'passwordisOK',
		component: passwordisOK
	},
	{
		path: '/passwordisOK',
		name: 'passwordisOK',
		component: passwordisOK
	},
	{
		path: '/emailsOK',
		name: 'emailsOK',
		component: emailsOK
	}
	/* {
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
	}, */
]

const router = new VueRouter({
	routes
})

export default router
