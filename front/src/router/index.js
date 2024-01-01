import Vue from 'vue'
import Router from 'vue-router'
import index from '../views/index/index.vue'
import login from '../views/login/login.vue'
import signUp from '../views/signUp/signUp.vue'
import notFound from '../views/index/404.vue'
import dashboard from '../views/dashboard/index.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes : [
    { path: '/', component: index },
    { path: '/dashboard', component: dashboard, hidden: true },
    { path: '/login', component: login, hidden: true}, 
    { path: '/signUp', component: signUp, hidden: true }, 
    { path: '*', component: notFound, hidden: true }, 
  ]
})

 
export default router