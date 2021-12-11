<template>
  <button :style="getStyle" @click="$emit('click')">
    <span class="font-content-wrap"
      ><span class="font-content"><slot></slot></span
    ></span>
  </button>
</template>

<script>
export default {
  props: {
    type: String
  },
  computed: {
    getStyle() {
      switch (this.type) {
        case "Green":
          return "background: rgb(0, 196, 196)";
        case "Blue":
          return "background: rgb(26, 115, 232)";
        case "Gray":
          return "background: #999;"
        case "Red":
          return "background: rgb(235 42 42);"
      }
      return "background: #333;";
    }
  }
};
</script>

<style lang="scss" scoped>
button {
  position: relative;
  width: 100%;
  height: auto;
  padding: 12px 16px;
  border: none;
  color: #fff;
  cursor: pointer;
  box-shadow: 0 3px 1px -2px rgb(0 0 0 / 20%), 0 2px 2px 0 rgb(0 0 0 / 14%),
    0 1px 5px 0 rgb(0 0 0 / 12%);
  border-radius: 5px;
  outline: none;
  user-select: none;
  .font-content-wrap {
    align-items: center;
    color: inherit;
    display: flex;
    flex: 1 0 auto;
    justify-content: inherit;
    line-height: normal;
    position: relative;
    .font-content {
      font-size: 0.875rem;
      font-weight: 900 !important;
      line-height: 24px !important;
      margin: 0 auto;
    }
  }
  &:hover,
  &:active,
  &:focus {
      opacity: 0.8;
  }
}
</style>
