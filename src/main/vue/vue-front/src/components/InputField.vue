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
    <DatePicker
      v-if="type === 'date'"
      v-model="text"
      @change="datePickerUpdate"
      :style="`font-size:${getFontSize}`"
    />

    <div class="textfield-title" v-if="title">{{ placeholder }}</div>
  </div>
</template>

<script>
import DatePicker from "vue2-datepicker";
import "vue2-datepicker/index.css";
import "vue2-datepicker/locale/ko";
export default {
  props: {
    type: String,
    value: String | Date,
    placeholder: String,
    fontSize: String,
    titleShow: String,
    height: String,
  },
  components: {
    DatePicker,
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
    if(this.type === 'date') {
      if(this.value === null) this.text = new Date();
      else this.text = new Date(this.value)
    }
    else this.text = this.value;
  },
  methods: {
    updated(e) {
      this.text = e.target.value;
      this.$emit("update:value", this.text);
    },
    datePickerUpdate() {
      const date = `${this.text.toLocaleDateString().replaceAll(". ", "-").replaceAll(".", "")} 00:00:00`
      this.$emit("update:value", date);
    },
    focus() {
      this.$refs.input.focus();
    },
  },
  // watch: {
  //   "todoData.order": function (val) {
  //     if (this.dragEvent) return;
  //     console.log("순서바뀜")
  //     console.log(val);
  //     // TODO: 순서 변경 시 ajax를 통해 순서 변경 알림
  //   },
  //   "todoData.status": function (val) {
  //     if (this.dragEvent) return;
  //     console.log("상태바뀜")
  //     console.log(val);
  //     // TODO: 상태 변경 시 ajax를 통해 상태 변경 알림
  //   },
  // },
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
    background: #fafafa;
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
    background: #f5f5f5;
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
  .mx-datepicker {
    width:100%;
  }
}
</style>
