<template>
  <div class="board-content">
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

    <!-- <div class="date-range">
      <InputField
        class="input-content"
        ref="sDate"
        type="date"
        :value.sync="content.startTime"
        placeholder="시작일"
        title-show
      />
      <InputField
        class="input-content"
        ref="eDate"
        type="date"
        :value.sync="content.endTime"
        placeholder="종료일"
        title-show
      />
    </div> -->

    <div class="button-wrap">
      <Button @click="submit">저장</Button>
      <Button type="Gray" @click="cancel">취소</Button>
      <Button v-if="content.id > 0" type="Red" @click="remove">삭제</Button>
    </div>
  </div>
</template>

<script>
import InputField from "@/components/InputField";
import Button from "@/components/Button";

export default {
  components: {
    InputField,
    Button,
  },
  props: ["content"],
  created() {
    console.log(this.content);
  },
  methods: {
    submit() {
      this.$emit('save', this.content);
    },
    cancel() {
      this.$emit('close'); 
    },
    remove() {
      this.$emit('remove');
    }
  },
  data() {
    return {
      origin: {},
    };
  },
};
</script>

<style lang="scss" scoped>
.board-content {
  .input-content {
    margin-bottom: 10px;
  }
  .date-range {
    display:flex;
    padding: 0px 5px;
    .input-content {
      width: calc(50% - 5px);
      &:first-child {
        margin-right: 10px;
      }
    }
  }
  .button-wrap {
    text-align: right;
    > button {
      width: auto;
      margin-left: 5px;
      padding: 5px 15px;
    }
  }
}
</style>