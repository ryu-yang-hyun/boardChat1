webpackJsonp([1],{"+fna":function(t,e){},"07+B":function(t,e){},"1QwG":function(t,e){},"8ZX1":function(t,e){},B7m3:function(t,e){},Cvt8:function(t,e){},GF8M:function(t,e){},Gao2:function(t,e){},"IL/b":function(t,e){},NHnr:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=n("7+uW"),i=n("Dd8w"),r=n.n(i),s=n("NYxO"),o={components:{},computed:r()({},Object(s.c)({menu:"getMenuOpen"}),{search:function(){return this.$store.state.search},menuClass:function(){return this.menu?"mdi-menu-open":"mdi-menu"},menuListClass:function(){return this.menu?"opend":""}}),data:function(){return{keyword:"",menuList:[{type:"top",title:"Todo",link:"/"},{type:"divider",children:[]},{type:"top",title:"Board",link:"/"}]}},methods:r()({},Object(s.b)({clickMenu:"toggleMenu"}))},c={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{class:t.menuListClass,attrs:{id:"header"}},[n("div",{staticClass:"menu",class:t.menuListClass},[t._l(t.menuList,function(e,a){return n("ul",{key:"menu"+a,class:e.type},["top"===e.type?n("li",[t._v("\n        "+t._s(e.title)+"\n        ")]):"divider"===e.type?n("li",[n("div",{staticClass:"divider"})]):t._e(),t._v(" "),t._l(e.children,function(e,a){return n("li",{key:"child"+a,staticClass:"child"},[t._v("\n        "+t._s(e.title)+"\n        ")])})],2)}),t._v(" "),t._m(0),t._v(" "),n("ul",{staticClass:"top"},[n("li",[n("div",[n("a",{on:{click:function(e){return t.$store.commit("logout")}}},[t._v("로그아웃")])])])]),t._v(" "),n("div",{staticClass:"close",on:{click:t.clickMenu}},[n("span",[t._v("닫기")]),t._v(" "),n("i",{staticClass:"mdi mdi-close-thick"})])],2),t._v(" "),t._m(1),t._v(" "),n("div",{staticClass:"left"},[n("i",{staticClass:"mdi",class:t.menuClass,on:{click:t.clickMenu}})])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("ul",{staticClass:"divider"},[e("li",[e("div",{staticClass:"divider"})])])},function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"content"},[e("span",[this._v("H201803030_류양현")])])}]};var u={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{attrs:{id:"bottom"}},[n("ul",t._l(t.menuList,function(e,a){return n("li",{key:"bottomMenu"+a},[n("router-link",{attrs:{to:e.link}},[n("i",{staticClass:"mdi",class:t.$route.path===e.link||"/"===t.$route.path&&"/todo"===e.link?e.icon.active:e.icon.default}),t._v(" "),n("span",[t._v(t._s(e.title))])])],1)}),0)])},staticRenderFns:[]};var d={name:"App",components:{Header:n("VU/8")(o,c,!1,function(t){n("rCNZ")},"data-v-881bca36",null).exports,Bottom:n("VU/8")({data:function(){return{menuList:[{title:"Todo",link:"/todo",icon:{default:"mdi-chart-box-outline",active:"mdi-chart-box"}},{title:"Board",link:"/board",icon:{default:"mdi-star-outline",active:"mdi-star"}}]}}},u,!1,function(t){n("B7m3")},"data-v-2dc3a0fe",null).exports}},l={render:function(){var t=this.$createElement,e=this._self._c||t;return e("div",{attrs:{id:"app"}},[e("Header"),this._v(" "),e("Bottom"),this._v(" "),e("router-view",{attrs:{id:"content-wrap"}})],1)},staticRenderFns:[]};var p=n("VU/8")(d,l,!1,function(t){n("Z04/")},null,null).exports,m=n("Xxa5"),v=n.n(m),h=n("exGp"),f=n.n(h),g=n("/ocq"),_={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"hello"},[this._v("\n  "+this._s(this.msg)+"\n")])},staticRenderFns:[]};n("VU/8")({name:"Home",data:function(){return{msg:"Home"}}},_,!1,function(t){n("dyXR")},"data-v-60d78192",null).exports;var C,x=n("mvHQ"),b=n.n(x),k=n("Gu7T"),w=n.n(k),y={TodoStatus:{TODO:"TODO",IN_PROGRESS:"IN_PROGRESS",DONE:"DONE"}},T=n("mtWM"),E=n.n(T),D=this,S=(C=f()(v.a.mark(function t(e){return v.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:return"/"===e.url.substring(0,1)&&(e.url="http://localhost:8080"+e.url),t.prev=1,t.next=4,E()(e);case 4:return t.abrupt("return",t.sent.data);case 7:return t.prev=7,t.t0=t.catch(1),t.abrupt("return",t.t0);case 10:case"end":return t.stop()}},t,D,[[1,7]])})),function(t){return C.apply(this,arguments)}),L=function(t,e){return S({method:"POST",url:"/api/account/login",data:{email:t,password:e}})},O=function(){return S({method:"GET",url:"/api/account/check"})},$=function(){return S({method:"GET",url:"/api/todos"})},M=function(t,e){return S({method:"POST",url:"/api/todos/status",data:{id:t,status:e}})},P=function(t){return S({method:"POST",url:"/api/todos/modify",data:t})},F=function(t){return S({method:"POST",url:"/api/todos",data:t})},B=function(t){var e={method:"PATCH",url:"/api/todos/order/"+t.id+"/"+t.orders};return S(e)},R=function(t){return S({method:"DELETE",url:"/api/todos/"+t})},N={list:function(){return S({method:"GET",url:"/api/board"})},modify:function(t){return S({method:"POST",url:"/api/board/modify",data:t})},insert:function(t){return S({method:"POST",url:"/api/board",data:t})},remove:function(t){return S({method:"DELETE",url:"/api/board/"+t})}},A={props:["todoData"],computed:r()({},Object(s.c)({dragEvent:"getDragEvent"}),{isDone:function(){if(this.todoData.status===this.TodoStatus.DONE)return!0},content:function(){return null!==this.todoData.content?this.todoData.content.replace(/\n/g,"<br />"):""}}),data:function(){return{TodoStatus:y.TodoStatus}},methods:{changeState:function(){var t=this.todoData.status;this.todoData.status=t===this.TodoStatus.TODO?this.TodoStatus.IN_PROGRESS:t===this.TodoStatus.IN_PROGRESS?this.TodoStatus.DONE:this.TodoStatus.TODO,M(this.todoData.id,this.todoData.status)}},watch:{"todoData.order":function(t){this.dragEvent||(console.log("순서바뀜"),console.log(t))},"todoData.status":function(t){this.dragEvent||(console.log("상태바뀜"),console.log(t))}}},I={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"todo-card-wrap",class:(t.isDone?"done":"")+" "+(t.todoData.opend?"open":"")},[n("div",{staticClass:"todo-card-left",on:{click:t.changeState}},[t.todoData.status===t.TodoStatus.TODO?n("i",{staticClass:"mdi mdi-calendar-blank"}):t.todoData.status===t.TodoStatus.IN_PROGRESS?n("i",{staticClass:"mdi mdi-calendar-arrow-right"}):n("i",{staticClass:"mdi mdi-calendar-check"})]),t._v(" "),n("div",{staticClass:"todo-card-content",on:{click:function(e){return t.$emit("select")}}},[n("div",{staticClass:"title",domProps:{innerHTML:t._s(t.todoData.title)}}),t._v(" "),n("div",{staticClass:"content",domProps:{innerHTML:t._s(t.content)}})]),t._v(" "),n("div",{staticClass:"todo-card-right"},[n("div",{staticClass:"icon-wrap",on:{click:function(){t.todoData.opend=!t.todoData.opend}}},[t.todoData.opend?n("i",{staticClass:"mdi mdi-triangle"}):n("i",{staticClass:"mdi mdi-triangle mdi-rotate-180"})])])])},staticRenderFns:[]};var G=n("VU/8")(A,I,!1,function(t){n("IL/b")},"data-v-c41048e6",null).exports,z=n("trBP"),U=(n("1QwG"),n("2K70"),{props:{type:String,value:String|Date,placeholder:String,fontSize:String,titleShow:String,height:String},components:{DatePicker:z.default},computed:{getFontSize:function(){return void 0===this.fontSize?"14px":this.fontSize+"px"},getHeight:function(){return void 0===this.height?"":this.height+"px"},title:function(){return void 0!==this.titleShow}},data:function(){return{text:""}},created:function(){"date"===this.type?null===this.value?this.text=new Date:this.text=new Date(this.value):this.text=this.value},methods:{updated:function(t){this.text=t.target.value,this.$emit("update:value",this.text)},datePickerUpdate:function(){var t=this.text.toLocaleDateString().replaceAll(". ","-").replaceAll(".","")+" 00:00:00";this.$emit("update:value",t)},focus:function(){this.$refs.input.focus()}}}),H={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"textfield-wrap",class:t.title?"contain-title":""},["checkbox"!==t.type||"text"!==t.type&&"password"!==t.type?"radio"!==t.type||"text"!==t.type&&"password"!==t.type?"text"===t.type||"password"===t.type?n("input",{directives:[{name:"model",rawName:"v-model",value:t.text,expression:"text"}],ref:"input",staticClass:"textfield",style:"font-size:"+t.getFontSize,attrs:{placeholder:t.placeholder,type:t.type},domProps:{value:t.text},on:{input:[function(e){e.target.composing||(t.text=e.target.value)},t.updated],keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.$emit("enter")}}}):t._e():n("input",{directives:[{name:"model",rawName:"v-model",value:t.text,expression:"text"}],ref:"input",staticClass:"textfield",style:"font-size:"+t.getFontSize,attrs:{placeholder:t.placeholder,type:"radio"},domProps:{checked:t._q(t.text,null)},on:{input:t.updated,keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.$emit("enter")},change:function(e){t.text=null}}}):n("input",{directives:[{name:"model",rawName:"v-model",value:t.text,expression:"text"}],ref:"input",staticClass:"textfield",style:"font-size:"+t.getFontSize,attrs:{placeholder:t.placeholder,type:"checkbox"},domProps:{checked:Array.isArray(t.text)?t._i(t.text,null)>-1:t.text},on:{input:t.updated,keyup:function(e){return!e.type.indexOf("key")&&t._k(e.keyCode,"enter",13,e.key,"Enter")?null:t.$emit("enter")},change:function(e){var n=t.text,a=e.target,i=!!a.checked;if(Array.isArray(n)){var r=t._i(n,null);a.checked?r<0&&(t.text=n.concat([null])):r>-1&&(t.text=n.slice(0,r).concat(n.slice(r+1)))}else t.text=i}}}),t._v(" "),"textarea"===t.type?n("textarea",{directives:[{name:"model",rawName:"v-model",value:t.text,expression:"text"}],ref:"input",staticClass:"textfield",style:"font-size:"+t.getFontSize+";height:"+t.getHeight,attrs:{placeholder:t.placeholder},domProps:{value:t.text},on:{input:[function(e){e.target.composing||(t.text=e.target.value)},t.updated]}}):t._e(),t._v(" "),"date"===t.type?n("DatePicker",{style:"font-size:"+t.getFontSize,on:{change:t.datePickerUpdate},model:{value:t.text,callback:function(e){t.text=e},expression:"text"}}):t._e(),t._v(" "),t.title?n("div",{staticClass:"textfield-title"},[t._v(t._s(t.placeholder))]):t._e()],1)},staticRenderFns:[]};var V=n("VU/8")(U,H,!1,function(t){n("07+B")},"data-v-403dc0b6",null).exports,Z={props:{type:String},computed:{getStyle:function(){switch(this.type){case"Green":return"background: rgb(0, 196, 196)";case"Blue":return"background: rgb(26, 115, 232)";case"Gray":return"background: #999;";case"Red":return"background: rgb(235 42 42);"}return"background: #333;"}}},j={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("button",{style:t.getStyle,on:{click:function(e){return t.$emit("click")}}},[n("span",{staticClass:"font-content-wrap"},[n("span",{staticClass:"font-content"},[t._t("default")],2)])])},staticRenderFns:[]};var q=n("VU/8")(Z,j,!1,function(t){n("iAck")},"data-v-3d999195",null).exports,X={components:{InputField:V,Button:q},props:["content"],created:function(){console.log(this.content)},methods:{submit:function(){this.$emit("save",this.content)},cancel:function(){this.$emit("close")},remove:function(){this.$emit("remove")}},data:function(){return{origin:{}}}},J={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"todo-content"},[n("InputField",{ref:"title",staticClass:"input-content",attrs:{type:"text",value:t.content.title,placeholder:"제목","title-show":""},on:{"update:value":function(e){return t.$set(t.content,"title",e)}}}),t._v(" "),n("InputField",{ref:"content",staticClass:"input-content",attrs:{type:"textarea",value:t.content.content,placeholder:"내용",height:"300","title-show":""},on:{"update:value":function(e){return t.$set(t.content,"content",e)}}}),t._v(" "),n("div",{staticClass:"date-range"},[n("InputField",{ref:"sDate",staticClass:"input-content",attrs:{type:"date",value:t.content.startTime,placeholder:"시작일","title-show":""},on:{"update:value":function(e){return t.$set(t.content,"startTime",e)}}}),t._v(" "),n("InputField",{ref:"eDate",staticClass:"input-content",attrs:{type:"date",value:t.content.endTime,placeholder:"종료일","title-show":""},on:{"update:value":function(e){return t.$set(t.content,"endTime",e)}}})],1),t._v(" "),n("div",{staticClass:"button-wrap"},[n("Button",{on:{click:t.submit}},[t._v("저장")]),t._v(" "),n("Button",{attrs:{type:"Gray"},on:{click:t.cancel}},[t._v("취소")]),t._v(" "),t.content.id>0?n("Button",{attrs:{type:"Red"},on:{click:t.remove}},[t._v("삭제")]):t._e()],1)],1)},staticRenderFns:[]};var Q=n("VU/8")(X,J,!1,function(t){n("GF8M")},"data-v-8e34a212",null).exports,Y={props:["title"],computed:{contentTitle:function(){return void 0!==this.title?this.title:"팝업"}},data:function(){return{}}},W={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"layer-popup"},[n("div",{staticClass:"background",on:{click:function(e){return t.$emit("close")}}}),t._v(" "),n("div",{staticClass:"content-wrap"},[n("div",{staticClass:"title"},[t._v("\n      "+t._s(t.contentTitle)+"\n    ")]),t._v(" "),n("div",{staticClass:"content"},[t._t("default")],2)])])},staticRenderFns:[]};var K=n("VU/8")(Y,W,!1,function(t){n("m+wS")},"data-v-62ccd433",null).exports,tt=n("w/TU"),et=n.n(tt),nt={name:"Todo",components:{TodoCard:G,draggable:et.a,LayerPopup:K,TodoContent:Q},computed:r()({},Object(s.c)({dragEvent:"getDragEvent"}),{newContent:function(){return{id:-1,title:"",status:y.TodoStatus.TODO,orders:this.todoLists.length+1,startTime:(new Date).toLocaleDateString().replaceAll(". ","-").replaceAll(".","")+" 00:00:00",endTime:(new Date).toLocaleDateString().replaceAll(". ","-").replaceAll(".","")+" 00:00:00",opend:!1}},popupTitle:function(){return-1===this.selectedContent.id?"NEW TO-DO":"EDIT TO-DO"}}),mounted:function(){var t=this;return f()(v.a.mark(function e(){var n,a;return v.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,$();case 2:a=e.sent,(n=t.todoLists).push.apply(n,w()(a.data.map(t.convertItem))),t.todoLists.sort(function(t,e){return t.orders-e.orders});case 5:case"end":return e.stop()}},e,t)}))()},data:function(){return{msg:"Todo",popup:!1,selectedContent:{},origin:{},todoLists:[]}},methods:r()({convertItem:function(t){return t.opend=!1,t.startTime=t.startTime?t.startTime:new Date,t.endTime=t.endTime?t.endTime:new Date,t.startTime=new Date(t.startTime).toLocaleDateString().replaceAll(". ","-").replaceAll(".","")+" 00:00:00",t.endTime=new Date(t.endTime).toLocaleDateString().replaceAll(". ","-").replaceAll(".","")+" 00:00:00",t},newTodo:function(){console.log("new todo"),this.selectedContent=this.newContent,this.popup=!0},closePopup:function(){this.selectedContent.id>0&&(this.selectedContent.title=this.origin.title,this.selectedContent.content=this.origin.content,this.selectedContent.status=this.origin.status,this.selectedContent.startTime=this.origin.startTime,this.selectedContent.endTime=this.origin.endTime),this.popup=!1},clickCard:function(t){this.origin=JSON.parse(b()(t)),this.selectedContent=t,this.popup=!0},save:function(){var t=f()(v.a.mark(function t(e){var n,a;return v.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(-1!==this.selectedContent.id){t.next=7;break}return t.next=3,F(e);case 3:n=t.sent,this.todoLists.push(this.convertItem(n.data)),t.next=11;break;case 7:return t.next=9,P(e);case 9:a=t.sent,this.todoLists.filter(function(t){return t.id===e.id})[0]=this.convertItem(a.data);case 11:this.popup=!1;case 12:case"end":return t.stop()}},t,this)}));return function(e){return t.apply(this,arguments)}}(),remove:function(){var t=f()(v.a.mark(function t(){var e=this;return v.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:R(this.selectedContent.id),this.todoLists=this.todoLists.filter(function(t){return t.id!==e.selectedContent.id}),this.closePopup();case 3:case"end":return t.stop()}},t,this)}));return function(){return t.apply(this,arguments)}}(),dragStart:function(){this.setDragStart()},dragEnd:function(){this.setDragEnd(),this.todoLists.forEach(function(t,e){t.orders!==e+1&&(t.orders=e+1,B(t))})}},Object(s.b)({setDragStart:"dragStart",setDragEnd:"dragEnd"}))},at={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"todo-wrap"},[n("div",{staticClass:"todo"},[0===t.todoLists.length?n("div",{staticClass:"nothing"},[t._v("\n      아직 할 일이 없군요! 어서 목표를 세우세요!\n    ")]):n("div",{staticClass:"todo-list-title"},[t._v("\n      할 일 목록입니다! 오늘도 화이팅! 😍\n    ")]),t._v(" "),n("draggable",{on:{start:t.dragStart,end:t.dragEnd},model:{value:t.todoLists,callback:function(e){t.todoLists=e},expression:"todoLists"}},t._l(t.todoLists,function(e,a){return n("TodoCard",{key:"todo_"+a,attrs:{todoData:e},on:{select:function(n){return t.clickCard(e)}}})}),1),t._v(" "),n("i",{staticClass:"mdi mdi-plus-thick",on:{click:t.newTodo}}),t._v(" "),t.popup?n("LayerPopup",{attrs:{title:t.popupTitle},on:{close:t.closePopup}},[n("TodoContent",{attrs:{content:t.selectedContent},on:{close:t.closePopup,save:t.save,remove:t.remove}})],1):t._e()],1)])},staticRenderFns:[]};var it=n("VU/8")(nt,at,!1,function(t){n("Xlb6")},"data-v-234d0a88",null).exports,rt=n("aYPZ"),st={props:["boardData"],computed:r()({},Object(s.c)({dragEvent:"getDragEvent"}),{content:function(){return null!==this.boardData.content?this.boardData.content.replace(/\n/g,"<br />"):""}}),methods:{},watch:{}},ot={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"board-card-wrap"},[t._m(0),t._v(" "),n("div",{staticClass:"board-card-content",on:{click:function(e){return t.$emit("select")}}},[n("div",{staticClass:"title",domProps:{innerHTML:t._s(t.boardData.title)}}),t._v(" "),n("div",{staticClass:"content",domProps:{innerHTML:t._s(t.content)}})]),t._v(" "),n("div",{staticClass:"board-card-right"},[n("div",{staticClass:"icon-wrap",on:{click:function(){t.boardData.opend=!t.boardData.opend}}},[t.boardData.opend?n("i",{staticClass:"mdi mdi-triangle"}):t._e()])])])},staticRenderFns:[function(){var t=this.$createElement,e=this._self._c||t;return e("div",{staticClass:"board-card-left"},[e("i",{staticClass:"mdi mdi-calendar-check"})])}]};var ct=n("VU/8")(st,ot,!1,function(t){n("u5qc")},"data-v-6d209e54",null).exports,ut={components:{InputField:V,Button:q},props:["content"],created:function(){console.log(this.content)},methods:{submit:function(){this.$emit("save",this.content)},cancel:function(){this.$emit("close")},remove:function(){this.$emit("remove")}},data:function(){return{origin:{}}}},dt={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"board-content"},[n("InputField",{ref:"title",staticClass:"input-content",attrs:{type:"text",value:t.content.title,placeholder:"제목","title-show":""},on:{"update:value":function(e){return t.$set(t.content,"title",e)}}}),t._v(" "),n("InputField",{ref:"content",staticClass:"input-content",attrs:{type:"textarea",value:t.content.content,placeholder:"내용",height:"300","title-show":""},on:{"update:value":function(e){return t.$set(t.content,"content",e)}}}),t._v(" "),n("div",{staticClass:"button-wrap"},[n("Button",{on:{click:t.submit}},[t._v("저장")]),t._v(" "),n("Button",{attrs:{type:"Gray"},on:{click:t.cancel}},[t._v("취소")]),t._v(" "),t.content.id>0?n("Button",{attrs:{type:"Red"},on:{click:t.remove}},[t._v("삭제")]):t._e()],1)],1)},staticRenderFns:[]};var lt=n("VU/8")(ut,dt,!1,function(t){n("8ZX1")},"data-v-d8452920",null).exports,pt={name:"Board",components:{BoardCard:ct,draggable:et.a,LayerPopup:K,BoardContent:lt},computed:r()({},Object(s.c)({dragEvent:"getDragEvent"}),{newContent:function(){return{id:-1,title:"",orders:this.boardLists.length+1,startTime:(new Date).toLocaleDateString().replaceAll(". ","-").replaceAll(".","")+" 00:00:00",opend:!1}},popupTitle:function(){return-1===this.selectedContent.id?"NEW Board":"EDIT Board"}}),mounted:function(){var t=this;return f()(v.a.mark(function e(){var n,a;return v.a.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,N.list();case 2:a=e.sent,(n=t.boardLists).push.apply(n,w()(a.data.map(t.convertItem))),t.boardLists.sort(function(t,e){return t.orders-e.orders});case 5:case"end":return e.stop()}},e,t)}))()},data:function(){return{msg:"Board",popup:!1,selectedContent:{},origin:{},boardLists:[]}},methods:r()({convertItem:function(t){return t.opend=!1,t.startTime=t.startTime?t.startTime:new Date,t.endTime=t.endTime?t.endTime:new Date,t.startTime=new Date(t.startTime).toLocaleDateString().replaceAll(". ","-").replaceAll(".","")+" 00:00:00",t.endTime=new Date(t.endTime).toLocaleDateString().replaceAll(". ","-").replaceAll(".","")+" 00:00:00",t},newBoard:function(){console.log("new todo"),this.selectedContent=this.newContent,this.popup=!0},closePopup:function(){this.selectedContent.id>0&&(this.selectedContent.title=this.origin.title,this.selectedContent.content=this.origin.content,this.selectedContent.status=this.origin.status,this.selectedContent.startTime=this.origin.startTime,this.selectedContent.endTime=this.origin.endTime),this.popup=!1},clickCard:function(t){this.origin=JSON.parse(b()(t)),this.selectedContent=t,this.popup=!0},save:function(){var t=f()(v.a.mark(function t(e){var n,a;return v.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(-1!==this.selectedContent.id){t.next=7;break}return t.next=3,N.insert(e);case 3:n=t.sent,this.boardLists.push(this.convertItem(n.data)),t.next=11;break;case 7:return t.next=9,N.modify(e);case 9:a=t.sent,this.boardLists.filter(function(t){return t.id===e.id})[0]=this.convertItem(a.data);case 11:this.popup=!1;case 12:case"end":return t.stop()}},t,this)}));return function(e){return t.apply(this,arguments)}}(),remove:function(){var t=f()(v.a.mark(function t(){var e=this;return v.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:N.remove(this.selectedContent.id),this.boardLists=this.boardLists.filter(function(t){return t.id!==e.selectedContent.id}),this.closePopup();case 3:case"end":return t.stop()}},t,this)}));return function(){return t.apply(this,arguments)}}(),dragStart:function(){this.setDragStart()},dragEnd:function(){this.setDragEnd(),this.boardLists.forEach(function(t,e){t.orders!==e+1&&(t.orders=e+1,N.order(t))})}},Object(s.b)({setDragStart:"dragStart",setDragEnd:"dragEnd"}))},mt={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{staticClass:"board-wrap"},[n("div",{staticClass:"board"},[0===t.boardLists.length?n("div",{staticClass:"nothing"},[t._v("\n      자유롭게 작성하세요. 자유게시판 입니다.\n    ")]):n("div",{staticClass:"board-list-title"},[t._v("\n      비매너 글은 삭제 처분합니다. 😍\n    ")]),t._v(" "),n("draggable",{on:{start:t.dragStart,end:t.dragEnd},model:{value:t.boardLists,callback:function(e){t.boardLists=e},expression:"boardLists"}},t._l(t.boardLists,function(e,a){return n("BoardCard",{key:"board_"+a,attrs:{boardData:e},on:{select:function(n){return t.clickCard(e)}}})}),1),t._v(" "),n("i",{staticClass:"mdi mdi-plus-thick",on:{click:t.newBoard}}),t._v(" "),t.popup?n("LayerPopup",{attrs:{title:t.popupTitle},on:{close:t.closePopup}},[n("BoardContent",{attrs:{content:t.selectedContent},on:{close:t.closePopup,save:t.save,remove:t.remove}})],1):t._e()],1)])},staticRenderFns:[]};var vt=n("VU/8")(pt,mt,!1,function(t){n("Gao2")},"data-v-96cc46a4",null).exports,ht={props:{errMsg:String}},ft={render:function(){var t=this.$createElement,e=this._self._c||t;return e("span",{staticClass:"errorMessage"},[e("span",{staticClass:"em"},[this._v("*")]),this._v(" "+this._s(this.errMsg))])},staticRenderFns:[]};var gt={name:"Login",data:function(){return{emailErrMsg:"",pwErrMsg:"",emailPattern:/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,validate:{email:"",password:""}}},components:{FieldErrorMsg:n("VU/8")(ht,ft,!1,function(t){n("eSxY")},"data-v-32462998",null).exports,InputField:V,Button:q},methods:{login:function(t){var e=this;return f()(v.a.mark(function t(){var n,a;return v.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(n=!0,e.checker("pw")||(n=!1),e.checker("email")||(n=!1),n){t.next=5;break}return t.abrupt("return");case 5:return t.next=7,L(e.validate.email,e.validate.password);case 7:(a=t.sent).data.id>0&&(e.$store.commit("setMember",a.data),e.$router.push("/"));case 9:case"end":return t.stop()}},t,e)}))()},register:function(t){},checker:function(t){if("email"===t){if(0===this.validate.email.length)return this.error(t,"이메일 주소를 입력해주세요.");if(this.validate.email.length>24)return this.error(t,"이메일 주소는 최대 24글자 까지 입력해주세요.");if(!this.emailPattern.test(this.validate.email))return this.error(t,"이메일 형식이 잘못되었습니다.");this.emailErrMsg=""}else if("pw"===t){if(0===this.validate.password.length)return this.error(t,"비밀번호를 입력해주세요.");if(this.validate.password.length<8)return this.error(t,"비밀번호를 8자 이상 입력해주세요.");this.pwErrMsg=""}return!0},error:function(t,e){switch(t){case"email":this.emailErrMsg=e,this.$refs.email.focus();break;case"pw":this.pwErrMsg=e,this.$refs.pw.focus()}return!1}},watch:{"validate.email":function(){this.emailErrMsg&&this.checker("email")},"validate.password":function(){this.pwErrMsg&&this.checker("pw")}}},_t={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("section",{staticClass:"container"},[n("div",{staticClass:"section-title"},[t._v("로그인")]),t._v(" "),n("div",{staticClass:"section-login-form"},[n("div",{staticClass:"section-input-text"},[n("i",{staticClass:"mdi mdi-at --grey"}),t._v(" "),n("InputField",{ref:"email",attrs:{type:"text",value:t.validate.email,placeholder:"이메일 주소",fontSize:"17",autocomplete:"email"},on:{"update:value":function(e){return t.$set(t.validate,"email",e)}}}),t._v(" "),t.emailErrMsg?n("FieldErrorMsg",{attrs:{errMsg:t.emailErrMsg}}):t._e()],1),t._v(" "),n("div",{staticClass:"section-input-text"},[n("i",{staticClass:"mdi mdi-lock-open --grey"}),t._v(" "),n("InputField",{ref:"pw",attrs:{type:"password",value:t.validate.password,placeholder:"비밀번호",fontSize:"17",autocomplete:"current-password"},on:{"update:value":function(e){return t.$set(t.validate,"password",e)},enter:t.login}}),t._v(" "),t.pwErrMsg?n("FieldErrorMsg",{attrs:{errMsg:t.pwErrMsg}}):t._e()],1),t._v(" "),n("Button",{staticClass:"login-button",attrs:{type:"Green"},on:{click:t.login}},[t._v("로그인")]),t._v(" "),n("div",{staticClass:"v-divider or"}),t._v(" "),n("Button",{staticClass:"login-button",attrs:{type:"Blue"},on:{click:t.register}},[t._v("회원가입")])],1)])},staticRenderFns:[]};var Ct=n("VU/8")(gt,_t,!1,function(t){n("ksXg")},"data-v-0a06751e",null).exports,xt={render:function(){var t=this.$createElement;return(this._self._c||t)("div",{staticClass:"hello"},[this._v("\n  "+this._s(this.msg)+"\n")])},staticRenderFns:[]};var bt=n("VU/8")({name:"NotFound",data:function(){return{msg:"404 Not Found"}}},xt,!1,function(t){n("+fna")},"data-v-13dd7256",null).exports;a.a.use(s.a);var kt=new s.a.Store({state:{menuOpen:!1,counter:0,member:{id:-1},todo:{dragEvent:!1}},getters:{getMember:function(t){return t.member},getMenuOpen:function(t){return t.menuOpen},getDragEvent:function(t){return t.todo.dragEvent}},mutations:{addCounter:function(t){t.counter++},setMember:function(t,e){t.member=e},setMenuOpen:function(t,e){t.menuOpen=e},toggleMenuOpen:function(t){t.menuOpen=!t.menuOpen},setDragEvent:function(t,e){t.todo.dragEvent=e}},actions:{addCounter:function(t){return t.commit("addCounter")},closeMenu:function(t){t.commit("setMenuOpen",!1)},openMenu:function(t){t.commit("setMenuOpen",!0)},toggleMenu:function(t){t.commit("toggleMenuOpen")},dragStart:function(t){t.commit("setDragEvent",!0)},dragEnd:function(t){t.commit("setDragEvent",!1)}}}),wt=this;a.a.use(g.a);var yt=new g.a({mode:"history",routes:[{path:"/",name:"Home",component:it,meta:{requiresLogin:!0}},{path:"/todo",name:"todo",component:it,meta:{requiresLogin:!0}},{path:"/board",name:"board",component:vt,meta:{requiresLogin:!0}},{path:"/chat",name:"chat",component:rt.default,meta:{requiresLogin:!0}},{path:"/login",name:"login",component:Ct,meta:{notLogin:!0}},{path:"/404",name:"notFound",component:bt},{path:"*",redirect:"/404"}]});yt.beforeEach(function(){var t=f()(v.a.mark(function t(e,n,a){var i,r;return v.a.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(!e.matched.some(function(t){return t.meta.requiresLogin})||-1!==kt.state.member.id){t.next=7;break}return t.next=3,O();case 3:-1===(i=t.sent).data.id?a("/login"):(kt.commit("setMember",i.data),a()),t.next=19;break;case 7:if(!e.matched.some(function(t){return t.meta.notLogin})){t.next=18;break}if(-1===kt.state.member.id){t.next=12;break}a("/"),t.next=16;break;case 12:return t.next=14,O();case 14:-1===(r=t.sent).data.id?a():(kt.commit("setMember",r.data),a("/"));case 16:t.next=19;break;case 18:a();case 19:case"end":return t.stop()}},t,wt)}));return function(e,n,a){return t.apply(this,arguments)}}());var Tt=yt;a.a.config.productionTip=!1,new a.a({el:"#app",store:kt,router:Tt,components:{App:p},template:"<App/>"})},PPzs:function(t,e,n){"use strict";var a={render:function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",{attrs:{id:"app"}},[t._v("\n  유저이름: \n  "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.userName,expression:"userName"}],attrs:{type:"text"},domProps:{value:t.userName},on:{input:function(e){e.target.composing||(t.userName=e.target.value)}}}),t._v("\n  내용: "),n("input",{directives:[{name:"model",rawName:"v-model",value:t.message,expression:"message"}],attrs:{type:"text"},domProps:{value:t.message},on:{keyup:t.sendMessage,input:function(e){e.target.composing||(t.message=e.target.value)}}}),t._v(" "),t._l(t.recvList,function(e,a){return n("div",{key:a},[n("h3",[t._v("유저이름: "+t._s(e.userName))]),t._v(" "),n("h3",[t._v("내용: "+t._s(e.content))])])})],2)},staticRenderFns:[]};e.a=a},QJH4:function(t,e){},Xlb6:function(t,e){},"Z04/":function(t,e){},aYPZ:function(t,e,n){"use strict";var a=n("QJH4"),i=n.n(a),r=n("PPzs");var s=function(t){n("Cvt8")},o=n("VU/8")(i.a,r.a,!1,s,"data-v-4a788fbe",null);e.default=o.exports},dyXR:function(t,e){},eSxY:function(t,e){},iAck:function(t,e){},ksXg:function(t,e){},"m+wS":function(t,e){},rCNZ:function(t,e){},u5qc:function(t,e){}},["NHnr"]);
//# sourceMappingURL=app.fbb7b633a8bb63e34da8.js.map