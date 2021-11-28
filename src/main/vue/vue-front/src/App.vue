<template>
  <div id="app">
    <Header />
    <Bottom />
    <router-view id="content-wrap" />
  </div>
</template>

<script>
import Header from "@/components/layout/Header";
import Bottom from "@/components/layout/Bottom";

export default {
  name: "App",
  components: {
    Header,
    Bottom,
  },
};
</script>

<style lang="scss">
@import "@mdi/font/css/materialdesignicons.css";
@import "./assets/style.scss";

#app {
  min-height: 100vh;
  position: relative;
  padding-top: 54px;
  padding-bottom: 60px;
  background:#EAEAEA;

  #content-wrap {
    z-index: 99999;
    margin: 0 auto;
    width: 100%;
    max-width: 500px;
    background: #fff;
    min-height: calc( 100vh - 114px );
    padding: 10px;
  }
  #header {
    z-index: 9999;
  }
  #bottom {
    z-index: 9999;
  }
}
</style>
