import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import Test from '@/pages/Test'
import Login from '@/pages/Login'
import NotFound from '@/pages/NotFound'
import {
  store
} from '@/store/store'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [{
      path: '/',
      name: 'Home',
      component: Home,
      meta: {
        requiresLogin: true
      }
    },
    {
      path: '/test',
      name: 'Test',
      component: Test,
      meta: {
        requiresLogin: true
      }
    },
    {
      path: '/login',
      name: 'login',
      component: Login
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


router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresLogin) && store.state.member.id === -1) {
    // check 로직 추가
    next("/login")
  } else {
    next()
  }
})

export default router