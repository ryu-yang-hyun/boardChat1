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
      <i class="mdi mdi-plus-thick" @click="newTodo"></i>
      <LayerPopup v-if="popup" :title="popupTitle" @close="closePopup">
        <TodoContent
          :content="selectedContent"
          @close="closePopup"
          @save="save"
          @remove="remove"
        />
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
import { reqTodo } from "@/utils/axios"
export default {
  name: "Todo",
  components: {
    TodoCard,
    draggable,
    LayerPopup,
    TodoContent,
  },
  computed: {
    ...mapGetters({
      dragEvent: "getDragEvent",
    }),
    newContent() {
      return {
        id: -1,
        title: "",
        status: Types.TodoStatus.TODO,
        orders: this.todoLists.length + 1,
        startTime: `${(new Date()).toLocaleDateString().replaceAll(". ", "-").replaceAll(".", "")} 00:00:00`,
        endTime: `${(new Date()).toLocaleDateString().replaceAll(". ", "-").replaceAll(".", "")} 00:00:00`,
        opend: false,
      };
    },
    popupTitle() {
      return this.selectedContent.id === -1 ? "NEW TO-DO" : "EDIT TO-DO";
    },
  },
  async mounted() {
    const result = await reqTodo.list()
    this.todoLists.push(...result.data.map( this.convertItem ))
    this.todoLists.sort( (a, b) => a.orders - b.orders )
  },
  data() {
    return {
      msg: "Todo",
      popup: false,
      selectedContent: {},
      origin: {},
      todoLists: [
        // {
        //   id: 1,
        //   title: "1번 타이틀 입니다.",
        //   content: "반갑습니다.",
        //   status: Types.TodoStatus.TODO,
        //   order: 1,
        //   startTime: null,
        //   endTime: null,
        //   opend: false,
        // },
        // {
        //   id: 1,
        //   title: "2번 타이틀 입니다.",
        //   content:
        //     "반갑습니다. 열려라 참깨! 으하하하하하하하 \n크크크크크 풉풉풉풉 하하하하 반갑습니다.\n열려라 참깨! 으하하하하하하하 크크크크크 풉풉풉풉 하하하하 반갑습니다. 열려라 참깨! 으하하하하하하하 크크크크크 풉풉풉풉 하하하하 반갑습니다. 열려라 참깨! 으하하하하하하하 크크크크크 풉풉풉풉 하하하하",
        //   status: Types.TodoStatus.IN_PROGRESS,
        //   order: 2,
        //   startTime: null,
        //   endTime: null,
        //   opend: true,
        // },
        // {
        //   id: 1,
        //   title: "3번 타이틀 입니다.",
        //   content: "반갑습니다.",
        //   status: Types.TodoStatus.DONE,
        //   order: 3,
        //   startTime: null,
        //   endTime: null,
        //   opend: false,
        // },
      ],
    };
  },
  methods: {
    convertItem: function ( x ) {
      x.opend = false;
      x.startTime = x.startTime ? x.startTime : new Date()
      x.endTime = x.endTime ? x.endTime : new Date()
      x.startTime = `${(new Date(x.startTime)).toLocaleDateString().replaceAll(". ", "-").replaceAll(".", "")} 00:00:00`
      x.endTime = `${(new Date(x.endTime)).toLocaleDateString().replaceAll(". ", "-").replaceAll(".", "")} 00:00:00`
      return x;
    },
    newTodo: function () {
      console.log("new todo");
      this.selectedContent = this.newContent;
      this.popup = true;
    },
    closePopup: function () {
      if (this.selectedContent.id > 0) {
        this.selectedContent.title = this.origin.title;
        this.selectedContent.content = this.origin.content;
        this.selectedContent.status = this.origin.status;
        this.selectedContent.startTime = this.origin.startTime;
        this.selectedContent.endTime = this.origin.endTime;
      }
      this.popup = false;
    },
    clickCard: function (item) {
      this.origin = JSON.parse(JSON.stringify(item));
      this.selectedContent = item;
      this.popup = true;
    },
    save: async function (item) {
      if(this.selectedContent.id === -1) {
        const result = await reqTodo.insert(item)
        this.todoLists.push(this.convertItem(result.data))
      }
      else {
        const result = await reqTodo.modify(item)
        this.todoLists.filter( x => x.id === item.id )[0] = this.convertItem(result.data)
      }
      this.popup = false;
    },
    remove: async function() {
      reqTodo.remove(this.selectedContent.id)

      this.todoLists = this.todoLists.filter( x => x.id !== this.selectedContent.id )
      this.closePopup()
    },
    dragStart: function () {
      this.setDragStart();
    },
    dragEnd: function () {
      this.setDragEnd();
      this.todoLists.forEach((x, i) => {
        if( x.orders !== i + 1) {
          x.orders = i + 1;
          reqTodo.order( x );
        }
      });
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
    width: 100%;
    height: calc(100vh - 144px);
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
