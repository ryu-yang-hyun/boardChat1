<template>
  <section
    class="board-card-wrap"
    >
    <div class="board-card-left">
      <i class="mdi mdi-calendar-check" />
    </div>
    <div class="board-card-content" @click="$emit('select')">
      <div class="title" v-html="boardData.title" />
      <div class="content" v-html="content" />
    </div>
    <div class="board-card-right">
      <div
        class="icon-wrap"
        @click="
          () => {
            boardData.opend = !boardData.opend;
          }
        "
      >
        <i v-if="boardData.opend" class="mdi mdi-triangle" />
      </div>
    </div>
  </section>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import { reqBoard } from "@/utils/axios"
export default {
  props: ["boardData"],
  computed: {
    ...mapGetters({
      dragEvent: "getDragEvent",
    }),
    content() {
      return this.boardData.content !== null ? this.boardData.content.replace(/\n/g, '<br />') : '';
    },
  },
  methods: {
    
  },
  watch: {
  },
};
</script>

<style lang="scss" scoped>
section.board-card-wrap {
  border: 1px solid #e5e5e5;
  border-radius: 10px;
  padding: 10px;
  width: 100%;
  display: flex;
  margin-bottom: 5px;
  transition: 0.3s;
  cursor: pointer;
  &.done {
    opacity: 0.5;
    background: #f9f9f9;
  }
  &:active,
  &:hover {
    background: #f5f5f5;
  }
  .board-card-left {
    width: 40px;
    padding: 10px 5px;
    .mdi {
      font-size: 30px;
      color: #777;
    }
  }
  .board-card-right {
    width: 50px;
    padding: 3px 5px 7px;
    .icon-wrap {
      height: 40px;
      width: 40px;
      text-align: center;
      line-height: 40px;
      //   border-radius: 50%;
      //   border: 1px solid rgb(195, 220, 255);
      //   background:rgb(244, 249, 255);
      .mdi {
        font-size: 24px;
        color: rgb(108, 108, 108);
      }
    }
  }
  &:not(.open) {
    height: 70px;
    user-select: none;
    .title {
      text-overflow: ellipsis;
      overflow: hidden;
      white-space: nowrap;
    }
    .content {
      height: 20px;
      text-overflow: ellipsis;
      overflow: hidden;
      white-space: nowrap;
    }
  }
  .board-card-content {
    width: calc(100% - 90px);
    padding: 0 10px;
    .title {
      position: relative;
      height: 30px;
      line-height: 30px;
      font-size: 16px;
      font-weight: 600;
      color: #333;
    }
    .content {
      position: relative;
      line-height: 20px;
      font-size: 13px;
      font-weight: 400;
      color: #777;
    }
  }
}
</style>