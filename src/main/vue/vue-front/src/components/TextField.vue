<template>
  <input
    class="textfield"
    ref="input"
    :type="type"
    v-model="text"
    @input="updated"
    :placeholder="placeholder"
    @keyup.enter="$emit('enter')"
    :style="`font-size:${getFontSize}`"
  />
</template>

<script>
export default {
  props: {
    type: String,
    value: String,
    placeholder: String,
    fontSize: String
  },
  computed: {
    getFontSize() {
      if(this.fontSize === undefined) return '14px'
      else return this.fontSize + 'px'
    }
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
.textfield {
  margin-left: 5px;
  border: none;
  border-bottom: 1px solid #777;
  &:focus {
    border-bottom: 1px solid rgb(21, 127, 232);
  }
  transition: border 0.5s linear;
  outline: none;
  width: 100%;
  padding: 5px 10px;
}
</style>
