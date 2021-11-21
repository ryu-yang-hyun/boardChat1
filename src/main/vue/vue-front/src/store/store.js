// store.js
import Vue from 'vue'
import Vuex from 'vuex'
// import axios from 'axios'

Vue.use(Vuex)

export const store = new Vuex.Store({
  state: {
    menuOpen: false,
    counter: 0,
    member: {
      id: 0
    }
  },
  getters: {
    getMember: function (state) {
      return state.member
    },
    getMenuOpen: function (state) {
      return state.menuOpen
    }
  },
  mutations: {
    addCounter: function (state) {
      state.counter++
    },
    setMember: function (state, data) {
      state.member = data
    },
    setMenuOpen: function (state, value) {
      state.menuOpen = value
    },
    toggleMenuOpen: function (state) {
      state.menuOpen = !state.menuOpen
    }
  },
  actions: {
    addCounter: function (context) {
      return context.commit('addCounter')
    },
    closeMenu: function (context) {
      context.commit('setMenuOpen', false)
    },
    openMenu: function (context) {
      context.commit('setMenuOpen', true)
    },
    toggleMenu: function (context) {
      context.commit('toggleMenuOpen')
    }
    //   getServerData: function (context) {
    //     return axios.get("sample.json").then(function() {
    //       // ...
    //     });
    //   },
  }
})
