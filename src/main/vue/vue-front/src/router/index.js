import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import Test from '@/pages/Test'
import NotFound from '@/pages/NotFound'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/test',
      name: 'Test',
      component: Test
    },
    {
      path: '/404',
      name: 'notFound',
      component: NotFound
    },
    {
      path: '*',
      redirect: '/404'
    }
  ]
})
