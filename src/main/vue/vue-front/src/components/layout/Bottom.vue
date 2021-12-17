<template>
  <section id="bottom">
    <ul>
      <li v-for="(item, index) in menuList" :key="`bottomMenu${index}`">
        <router-link :to="item.link">
        <i
          class="mdi"
          :class="
            $route.path === item.link || ($route.path === '/' && item.link === '/todo')
              ? item.icon.active
              : item.icon.default
          "
        />
        <span>{{ item.title }}</span>
        </router-link>
      </li>
    </ul>
  </section>
</template>

<script>
export default {
  data() {
    return {
      menuList: [
        // {
        //   title: "홈",
        //   link: "/",
        //   icon: {
        //     default: "mdi-home-variant-outline",
        //     active: "mdi-home-variant",
        //   },
        // },
        {
          title: "Todo",
          link: "/todo",
          icon: {
            default: "mdi-chart-box-outline",
            active: "mdi-chart-box",
          },
        },
        {
          title: "Board",
          link: "/board",
          icon: {
            default: "mdi-star-outline",
            active: "mdi-star",
          },
        }
        // {
        //   title: "Chat",
        //   link: "/chat",
        //   icon: {
        //     default: "mdi-comment-alert-outline",
        //     active: "mdi-comment-alert",
        //   },
        // }
      ],
    };
  },
};
</script>

<style lang="scss" scoped>
#bottom {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  height: 60px;

  width: 100%;
  max-width: 500px;
  margin: 0 auto;
  text-align: center;
  background: #fff;
  box-shadow: 0 0 10px 2px rgb(0 0 0 / 15%);
  ul {
    display: flex;
    flex-direction: row;
    list-style-type: none;
    margin: 0;
    padding: 5px 10px;
    li {
      width: 100%;
      border-radius: 15px;
      margin: 0 3px;
      transition: 0.5s;
      // height: 40px;
      cursor: pointer;
      &:hover {
        background: rgb(219, 230, 255);
      }
      a {
        display: inline-flex;
        text-decoration: none;
        color: #868e96;
        flex-direction: column;
        height: 50px;
        width: 100%;
        i {
          font-size: 35px;
          line-height: 35px;
          height: 35px;
        }
        span {
          display: inline-block;
          font-size: 10px;
          line-height: 15px;
          height: 15px;
          font-weight: 400;
        }

        &[aria-current="page"] {
          color: #333;
          span {
            font-weight: 900;
          }
        }
      }
    }
  }
}
</style>
