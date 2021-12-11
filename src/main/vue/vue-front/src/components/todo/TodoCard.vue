<template>
  <section
    class="todo-card-wrap"
    :class="`${isDone ? 'done' : ''} ${todoData.opend ? 'open' : ''}`"
  >
    <div class="todo-card-left" @click="changeState">
      <i
        v-if="todoData.status === TodoStatus.TODO"
        class="mdi mdi-calendar-blank"
      />
      <i
        v-else-if="todoData.status === TodoStatus.IN_PROGRESS"
        class="mdi mdi-calendar-arrow-right"
      />
      <i v-else class="mdi mdi-calendar-check" />
    </div>
    <div class="todo-card-content" @click="$emit('select')">
      <div class="title" v-html="todoData.title" />
      <div class="content" v-html="content" />
    </div>
    <div class="todo-card-right">
      <div
        class="icon-wrap"
        @click="
          () => {
            todoData.opend = !todoData.opend;
          }
        "
      >
        <i v-if="todoData.opend" class="mdi mdi-triangle" />
        <i v-else class="mdi mdi-triangle mdi-rotate-180" />
      </div>
    </div>
  </section>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import Types from "@/types/types";
import { reqTodo } from "@/utils/axios"
export default {
  props: ["todoData"],
  computed: {
    ...mapGetters({
      dragEvent: "getDragEvent",
    }),
    isDone() {
      if (this.todoData.status === this.TodoStatus.DONE) return true;
      else false;
    },
    content() {
      return this.todoData.content !== null ? this.todoData.content.replace(/\n/g, '<br />') : '';
    },
  },
  data() {
    return {
      TodoStatus: Types.TodoStatus,
    };
  },
  methods: {
    changeState: function () {
      const status = this.todoData.status;
      this.todoData.status =
        status === this.TodoStatus.TODO
          ? this.TodoStatus.IN_PROGRESS
          : status === this.TodoStatus.IN_PROGRESS
          ? this.TodoStatus.DONE
          : this.TodoStatus.TODO;
      reqTodo.status(this.todoData.id, this.todoData.status);
    },
  },
  watch: {
    "todoData.order": function (val) {
      if (this.dragEvent) return;
      console.log("순서바뀜")
      console.log(val);
      // TODO: 순서 변경 시 ajax를 통해 순서 변경 알림
    },
    "todoData.status": function (val) {
      if (this.dragEvent) return;
      console.log("상태바뀜")
      console.log(val);
      // TODO: 상태 변경 시 ajax를 통해 상태 변경 알림
    },
  },
};
</script>

<style lang="scss" scoped>
section.todo-card-wrap {
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
  .todo-card-left {
    width: 40px;
    padding: 10px 5px;
    .mdi {
      font-size: 30px;
      color: #777;
    }
  }
  .todo-card-right {
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
  .todo-card-content {
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