<template>
  <div class="board-wrap">
    <div class="board">
      <div v-if="boardLists.length === 0" class="nothing">
        자유롭게 작성하세요. 자유게시판 입니다.
      </div>
      <div v-else class="board-list-title">
        비매너 글은 삭제 처분합니다. 😍
      </div>
      <draggable v-model="boardLists" @start="dragStart" @end="dragEnd">
        <BoardCard
          v-for="(item, index) in boardLists"
          :boardData="item"
          :key="`board_${index}`"
          @select="clickCard(item)"
        />
      </draggable>
      <i class="mdi mdi-plus-thick" @click="newBoard"></i>
      <LayerPopup v-if="popup" :title="popupTitle" @close="closePopup">
        <BoardContent
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
import BoardCard from "@/components/board/BoardCard";
import BoardContent from "@/components/board/BoardContent";
import LayerPopup from "@/components/layout/LayerPopup";
import draggable from "vuedraggable";
import { reqBoard } from "@/utils/axios"
export default {
  name: "Board",
  components: {
    BoardCard,
    draggable,
    LayerPopup,
    BoardContent,
  },
  computed: {
    ...mapGetters({
      dragEvent: "getDragEvent",
    }),
    newContent() {
      return {
        id: -1,
        title: "",
        orders: this.boardLists.length + 1,
        startTime: `${(new Date()).toLocaleDateString().replaceAll(". ", "-").replaceAll(".", "")} 00:00:00`,
        // endTime: `${(new Date()).toLocaleDateString().replaceAll(". ", "-").replaceAll(".", "")} 00:00:00`,
        opend: false,
      };
    },
    popupTitle() {
      return this.selectedContent.id === -1 ? "NEW Board" : "EDIT Board";
    },
  },
  async mounted() {
    const result = await reqBoard.list()
    this.boardLists.push(...result.data.map( this.convertItem ))
    this.boardLists.sort( (a, b) => a.orders - b.orders )
  },
  data() {
    return {
      msg: "Board",
      popup: false,
      selectedContent: {},
      origin: {},
      boardLists: [
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
    newBoard: function () {
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
        const result = await reqBoard.insert(item)
        this.boardLists.push(this.convertItem(result.data))
      }
      else {
        const result = await reqBoard.modify(item)
        this.boardLists.filter( x => x.id === item.id )[0] = this.convertItem(result.data)
      }
      this.popup = false;
    },
    remove: async function() {
      reqBoard.remove(this.selectedContent.id)

      this.boardLists = this.boardLists.filter( x => x.id !== this.selectedContent.id )
      this.closePopup()
    },
    dragStart: function () {
      this.setDragStart();
    },
    dragEnd: function () {
      this.setDragEnd();
      this.boardLists.forEach((x, i) => {
        if( x.orders !== i + 1) {
          x.orders = i + 1;
          reqBoard.order( x );
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
.board-wrap {
  .board {
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
    .board-list-title {
      text-align: center;
      margin: 5px 0 15px;
      font-size: 17px;
      color: #777;
      user-select: none;
    }
  }
}
</style>