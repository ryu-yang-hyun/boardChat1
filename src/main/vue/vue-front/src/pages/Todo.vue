<template>
  <div class="todo-wrap">
    <div class="todo">
      <div v-if="todoLists.length === 0" class="nothing">
        아직 할 일이 없군요! 어서 목표를 세우세요!
      </div>
      <div v-else class="todo-list-title">
        할 일 목록입니다! 오늘도 화이팅! 😍
      </div>
      <draggable v-model="todoLists" @start="dragStart" @end="dragEnd">
        <TodoCard
          v-for="(item, index) in todoLists"
          :todoData="item"
          :key="`todo_${index}`"
          @select="clickCard(item)"
        />
      </draggable>
      <i class="mdi mdi-plus-thick" @click="popupToggle"></i>
      <LayerPopup v-if="popup" :title="popupTitle" @close="popupToggle">
        <TodoContent :content="selectedContent" />
      </LayerPopup>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapActions } from "vuex";
import Types from "@/types/types";
import TodoCard from "@/components/todo/TodoCard";
import TodoContent from "@/components/todo/TodoContent";
import LayerPopup from "@/components/layout/LayerPopup";
import draggable from "vuedraggable";
export default {
  name: "Todo",
  components: {
    TodoCard,
    draggable,
    LayerPopup,
    TodoContent
  },
  computed: {
    ...mapGetters({
      dragEvent: "getDragEvent",
    }),
    newContent() {
      return {
        id: -1,
        title: "",
        statud: Types.TodoStatus.TODO,
        order: this.todoLists.length + 1,
        startTime: "",
        endTime: "",
        opend: false
      }
    },
    popupTitle() {
      return this.selectedContent.id === -1 ? 'NEW TO-DO' : 'EDIT TO-DO'
    }
  },
  data() {
    return {
      msg: "Todo",
      popup: false,
      selectedContent: {},
      todoLists: [
        {
          id: 1,
          title: "1번 타이틀 입니다.",
          content: "반갑습니다.",
          status: Types.TodoStatus.TODO,
          order: 1,
          startTime: "",
          endTime: "",
          opend: false,
        },
        {
          id: 1,
          title: "2번 타이틀 입니다.",
          content: "반갑습니다. 열려라 참깨! 으하하하하하하하 \n크크크크크 풉풉풉풉 하하하하 반갑습니다.\n열려라 참깨! 으하하하하하하하 크크크크크 풉풉풉풉 하하하하 반갑습니다. 열려라 참깨! 으하하하하하하하 크크크크크 풉풉풉풉 하하하하 반갑습니다. 열려라 참깨! 으하하하하하하하 크크크크크 풉풉풉풉 하하하하",
          status: Types.TodoStatus.IN_PROGRESS,
          order: 2,
          startTime: "",
          endTime: "",
          opend: true,
        },
        {
          id: 1,
          title: "3번 타이틀 입니다.",
          content: "반갑습니다.",
          status: Types.TodoStatus.DONE,
          order: 3,
          startTime: "",
          endTime: "",
          opend: false,
        },
      ],
    };
  },
  methods: {
    popupToggle: function () {
      this.selectedContent = this.newContent;
      this.popup = !this.popup;
    },
    clickCard: function(item) {
      this.selectedContent = item;
      this.popup = !this.popup;
    },
    dragStart: function () {
      this.setDragStart();
    },
    dragEnd: function () {
      this.setDragEnd();
      this.todoLists.forEach((x, i) => (x.order = i + 1));
    },
    ...mapActions({
      setDragStart: "dragStart",
      setDragEnd: "dragEnd",
    }),
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style lang="scss" scoped>
.todo-wrap {
  .todo {
    position: relative;
    width:100%;
    height:calc(100vh - 144px);
    .mdi.mdi-plus-thick {
      position: absolute;
      right: 0px;
      bottom: 0px;
      font-size: 30px;
      line-height: 50px;
      text-align: center;
      width: 50px;
      height: 50px;
      border-radius: 50%;
      background: #aaa;
      color: #fff;
      opacity: 0.3;
      transition-duration: 0.5s;
      cursor: pointer;
      &:active,
      &:hover {
        opacity: 1;
      }
    }
    .nothing {
      position: absolute;
      left: 0;
      top: 0;
      right: 0;
      bottom: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100%;
      font-size: 18px;
      color: #777;
      user-select: none;
    }
    .todo-list-title {
      text-align: center;
      margin: 5px 0 15px;
      font-size: 17px;
      color: #777;
      user-select: none;
    }
  }
}
</style>
