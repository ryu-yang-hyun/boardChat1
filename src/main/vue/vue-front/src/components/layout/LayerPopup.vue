<template>
  <section class="layer-popup">
    <div class="background" @click="$emit('close')"></div>
    <div class="content-wrap">
      <div class="title">
        {{ contentTitle }}
      </div>
      <div class="content">
        <slot></slot>
      </div>
    </div>
  </section>
</template>

<script>
export default {
  props: ["title"],
  computed: {
    contentTitle: function () {
      return this.title !== undefined ? this.title : "팝업";
    },
  },
  data() {
    return {};
  },
};
</script>

<style lang="scss" scoped>
.layer-popup {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  z-index: 9999;
  .background {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background: RGBA(0, 0, 0, 0.2);
  }
  .content-wrap {
    position: absolute;
    display: flex;
    flex-direction: column;

    top: 15%;
    bottom: 15%;
    height: 70%;
    left: 15px;
    width: calc(100% - 30px);

    overflow: hidden;

    .title {
      height: 50px;
      padding: 15px 10px;
      text-align: center;
      line-height: 20px;
      font-size: 18px;
      font-weight: 700;

      background: #333;
      color: #fff;
      user-select: none;
    }

    .content {
      width: 100%;
      padding: 10px;
      max-height: calc(100% - 40px);
      overflow-y: scroll;
      overflow-x: hidden;
    }

    @media screen and (min-width: 700px) {
      width: 600px;
      left: calc(50% - 300px);
      .content {
        width: calc(100% + 15px);
        padding-right: 28px;
      }
    }

    background: #fff;
    border-radius: 10px;

    box-shadow: rgb(15 15 15 / 5%) 0px 0px 0px 1px,
      rgb(15 15 15 / 10%) 0px 5px 10px, rgb(15 15 15 / 20%) 0px 15px 40px;
  }
}
</style>