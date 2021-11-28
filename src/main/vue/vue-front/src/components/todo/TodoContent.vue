<template>
  <div>
    <InputField
      class="input-content"
      ref="title"
      type="text"
      :value.sync="content.title"
      placeholder="제목"
      title-show
    />
    <InputField
      class="input-content"
      ref="content"
      type="textarea"
      :value.sync="content.content"
      placeholder="내용"
      height="300"
      title-show
    />

    <button @click="submit">console</button>
  </div>
</template>

<script>
import InputField from "@/components/InputField";
export default {
  components: {
      InputField,
  },
  props: ["content"],
  created() {
    console.log(this.content);
  },
  methods: {
      submit() {
          console.log(this.content);
      }
  }
};
</script>

<style lang="scss" scoped>

.input-content {
    margin-bottom: 10px;
}
</style>