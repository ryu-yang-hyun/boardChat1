<template>
  <section id="header" :class="menuListClass">
    <div :class="menuListClass" class="menu">
      <ul
        v-for="(item, index) in menuList"
        :key="`menu${index}`"
        :class="item.type"
      >
        <li v-if="item.type === 'top'">
          <!-- <NuxtLink :to="item.link"> -->
          {{ item.title }}
          <!-- </NuxtLink> -->
        </li>
        <li v-else-if="item.type === 'divider'">
          <div class="divider"></div>
        </li>
        <li
          v-for="(child, i) in item.children"
          :key="`child${i}`"
          class="child"
        >
          <!-- <NuxtLink :to="child.link"> -->
          {{ child.title }}
          <!-- </NuxtLink> -->
        </li>
      </ul>
      <ul class="divider">
        <li><div class="divider"></div></li>
      </ul>
      <ul class="top">
        <li>
          <div><a @click="$store.commit('logout')">로그아웃</a></div>
        </li>
      </ul>
      <div class="close" @click="clickMenu">
        <span>닫기</span>
        <i class="mdi mdi-close-thick" />
      </div>
    </div>
    <div class="content">
      <span>H201803030_류양현</span>
    </div>
    <div class="left">
      <i class="mdi" :class="menuClass" @click="clickMenu"></i>
    </div>
  </section>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
export default {
  components: {
  },
  computed: {
    ...mapGetters({
      menu: "getMenuOpen", // getCounter 는 Vuex 의 getters 에 선언된 속성 이름
    }),
    search() {
      return this.$store.state.search;
    },
    menuClass() {
      return this.menu ? "mdi-menu-open" : "mdi-menu";
    },
    menuListClass() {
      return this.menu ? "opend" : "";
    },
  },
  data() {
    return {
      keyword: "",
      menuList: [
        {
          type: "top",
          title: "탑 메뉴1",
          link: "/",
          children: [
            {
              type: "child",
              title: "자식 메뉴1",
              link: "/",
            },
            {
              type: "child",
              title: "자식 메뉴2",
              link: "/",
            },
            {
              type: "child",
              title: "자식 메뉴3",
              link: "/",
            },
          ],
        },
        {
          type: "divider",
          children: [],
        },
        {
          type: "top",
          title: "탑 메뉴2",
          link: "/",
          children: [
            {
              type: "child",
              title: "자식 메뉴1",
              link: "/",
            },
            {
              type: "child",
              title: "자식 메뉴2",
              link: "/",
            },
            {
              type: "child",
              title: "자식 메뉴3",
              link: "/",
            },
          ],
        },
        {
          type: "top",
          title: "탑 메뉴3",
          link: "/",
          children: [],
        },
        {
          type: "top",
          title: "탑 메뉴4",
          link: "/",
          children: [
            {
              type: "child",
              title: "자식 메뉴1",
              link: "/",
            },
            {
              type: "child",
              title: "자식 메뉴2",
              link: "/",
            },
          ],
        },
        {
          type: "top",
          title: "탑 메뉴5",
          link: "/",
          children: [],
        },
      ],
    };
  },
  methods: {
    ...mapActions({
        clickMenu: 'toggleMenu'
    })
  },
};
</script>

<style lang="scss" scoped>
#header {
  position: fixed;
  top: 0px;
  left: 0px;
  right: 0px;
  height: 54px;
  background: #fcfcfc;

  width: 100%;
  max-width: 500px;
  margin: 0 auto;
  text-align: center;

  .menu {
    margin-top: 54px;
    transition: 0.3s;
    background: #fcfcfc;
    border-bottom: 0.5px solid #eee;
    max-height: 0;
    overflow-y: hidden;
    box-sizing: border-box;
    &.opend {
      max-height: 100vh;
    }

    ul {
      list-style-type: none;
      margin: 0;
      padding: 0 15px;
      padding-bottom: 0px;
      li {
        width: 100%;
        a {
          color: #333;
          text-decoration: none;
        }
        line-height: 1.8;
        font-size: 15px;
        font-weight: 600;
        text-align: left;
        &.child {
          padding-left: 10px;
          font-size: 13px;
          color: #555;
          &:last-child {
            padding-bottom: 10px;
          }
        }
      }
      &.divider {
        padding: 10px 0;
        .divider {
          margin: 0 20px;
          height: 1px;
          background: #efefef;
        }
      }
      &:last-child {
        padding-bottom: 15px;
      }
      &:first-child {
        padding-top: 5px;
      }
    }

    .close {
      display: flex;
      flex-direction: row-reverse;
      margin-left: auto;
      padding: 5px 15px;
      text-align: right;
      color: #999;
      align-items: center;
      align-content: center;
      i {
        font-size: 12px;
        cursor: pointer;
      }
      span {
        font-size: 12px;
        font-weight: 800;
        cursor: pointer;
      }
    }
  }

  .left {
    position: absolute;
    left: 0;
    top: 0;
    height: 54px;
    display: flex;
    line-height: 54px;
    .mdi {
      float: right;
      width: 54px;
      font-size: 30px;
      color: #333;
      cursor: pointer;
      transition: 0.5s;
    }
  }

  .content {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    line-height: 54px;
    color: #333;
    font-size: 20px;
    font-weight: 900;
    user-select: none;
    > span {
      padding: 5px 20px;
    }
  }
}
</style>
