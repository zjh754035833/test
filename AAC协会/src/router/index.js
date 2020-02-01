import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '@/components/index'
import about from '@/components/about'
import ourmission from '@/components/ourmission'
import standard from '@/components/standard'
import Membership from '@/components/Membership'
import Memberlist from '@/components/Memberlist'
import individual from '@/components/individual'
import resource from '@/components/resource'
import login from '@/components/login'
import sigin from '@/components/sigin'
import Corporation from '@/components/Corporation'
import Subscription from '@/components/Subscription'
import usercenter from '@/components/usercenter'
import emailsOK from '@/components/emailsOK'
import realstandard from '@/components/realStandard'
import passwordisOK from '@/components/passwordisOK'
Vue.use(VueRouter)
 
const routes = [{
		path: '/sigin',
		name: 'sigin',
		component: sigin,
		
	}, {
		path: '/login',
		name: 'login',
		component: login,
		
	},
	{
		path: '/Subscription',
		name: 'Subscription',
		component: Subscription
	},
	{
		path: '/',
		name: 'index',
		component: index
	},
	{
		path: '/about',
		name: 'about',
		component: about
	},
	{
		path: '/ourmission',
		name: 'ourmission',
		component: ourmission
	},
	{
		path: '/standard',
		name: 'standard',
		component: standard
	},
	{
		path: '/Membership',
		name: 'Membership',
		component: Membership
	},
	{
		path: '/Memberlist',
		name: 'Memberlist',
		component: Memberlist
	},
	{
		path: '/individual',
		name: 'individual',
		component: individual
	},
	{
		path: '/resource',
		name: 'resource',
		component: resource
	},
	{
		path: '/Corporation',
		name: 'Corporation',
		component: Corporation
	},
	{
		path: '/usercenter',
		name: 'usercenter',
		component: usercenter
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
	},
	{
		path: '/realstandard',
		name: 'realstandard',
		component: realstandard
	},
]

const router = new VueRouter({
	routes
})

export default router
