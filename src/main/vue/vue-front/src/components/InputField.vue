<template>
  <div class="textfield-wrap" :class="title ? 'contain-title' : ''">
    <input
      v-if="type === 'text' || type === 'password'"
      class="textfield"
      ref="input"
      :type="type"
      v-model="text"
      @input="updated"
      :placeholder="placeholder"
      @keyup.enter="$emit('enter')"
      :style="`font-size:${getFontSize}`"
    />
    <textarea
      v-if="type === 'textarea'"
      class="textfield"
      ref="input"
      v-model="text"
      @input="updated"
      :placeholder="placeholder"
      :style="`font-size:${getFontSize};height:${getHeight}`"
    />
    <div class="textfield-title" v-if="title">{{ placeholder }}</div>
  </div>
</template>

<script>
export default {
  props: {
    type: String,
    value: String,
    placeholder: String,
    fontSize: String,
    titleShow: String,
    height: String
  },
  computed: {
    getFontSize() {
      if (this.fontSize === undefined) return "14px";
      else return this.fontSize + "px";
    },
    getHeight() {
      if (this.height === undefined) return "";
      else return this.height + "px";
    },
    title() {
      return this.titleShow === undefined ? false : true;
    },
  },
  data() {
    return {
      text: "",
    };
  },
  created() {
    this.text = this.value;
  },
  methods: {
    updated(e) {
      this.text = e.target.value;
      this.$emit("update:value", this.text);
    },
    focus() {
      this.$refs.input.focus();
    },
  },
};
</script>

<style lang="scss" scoped>
.textfield-wrap {
  width: 100%;

  &.contain-title {
    padding-top: 15px;
    position: relative;
  }
  .textfield-title {
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    font-size: 11px;
    color: #333;
    padding: 0 10px;
    line-height: 15px;
    height: 15px;
    transition: 0.1s;
  }
  input.textfield {
    margin-left: 5px;
    border: none;
    border-bottom: 1px solid #999;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
    background:#F5F5F5;
    &:focus {
      border-bottom: 1px solid rgb(21, 127, 232);
      & + .textfield-title {
        color: rgb(21, 127, 232);
        font-size: 12px;
        font-weight: 700;
      }
    }
    transition: border 0.5s linear;
    outline: none;
    width: calc(100% - 5px);
    padding: 5px 10px;
  }
  textarea.textfield {
    margin-left: 5px;
    border: none;
    border-bottom: 1px solid #999;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
    background:#F5F5F5;
    &:focus {
      border-bottom: 1px solid rgb(21, 127, 232);
      & + .textfield-title {
        color: rgb(21, 127, 232);
        font-size: 12px;
        font-weight: 700;
      }
    }
    transition: border 0.5s linear;
    outline: none;
    width: calc(100% - 5px);
    padding: 10px;
  }
}
</style>
