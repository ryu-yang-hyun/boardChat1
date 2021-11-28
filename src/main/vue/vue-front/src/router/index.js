import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/pages/Home'
import Todo from '@/pages/Todo'
import Chat from '@/pages/Chat'
import Board from '@/pages/Board'
import Login from '@/pages/Login'
import NotFound from '@/pages/NotFound'
import {
  store
} from '@/store/store'
import { reqAuth } from "@/utils/axios"

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
      path: '/todo',
      name: 'todo',
      component: Todo,
      meta: {
        requiresLogin: true
      }
    },
    {
      path: '/board',
      name: 'board',
      component: Board,
      meta: {
        requiresLogin: true
      }
    },
    {
      path: '/chat',
      name: 'chat',
      component: Chat,
      meta: {
        requiresLogin: true
      }
    },
    {
      path: '/login',
      name: 'login',
      component: Login,
      meta: {
        notLogin: true
      }
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


router.beforeEach( async (to, from, next) => {
  if (to.matched.some(record => record.meta.requiresLogin) && store.state.member.id === -1) {
    // check 로직 추가
    const result = await reqAuth.check()
    if(result.data.id === -1) next("/login")
    else {
      store.commit('setMember', result.data)
      next()
    }
  } else if(to.matched.some(record => record.meta.notLogin)) {
    if(store.state.member.id !== -1) next('/')
    else {
      const result = await reqAuth.check()
      if(result.data.id === -1) next()
      else {
        store.commit('setMember', result.data)
        next('/')
      }
    }
  } else {
    next()
  }
})

export default router