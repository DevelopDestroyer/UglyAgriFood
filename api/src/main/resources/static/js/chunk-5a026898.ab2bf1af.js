(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5a026898"],{4631:function(t,a,e){"use strict";e.r(a);var s=function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("v-container",{staticClass:"down-top-padding",attrs:{fluid:""}},[e("v-row",[e("v-col",{attrs:{cols:"12",lg:"12"}},[e("v-card",{staticClass:"position-relative profile-card mb-0"},[e("v-card-text",{staticClass:"pa-4"},[e("div",{staticClass:"text-center"},[e("v-row",{staticClass:"mt-0"},[e("v-col",{staticStyle:{"text-align":"left"},attrs:{cols:"12"}},[e("h4",{staticClass:"mt-0 title blue-grey--text text--darken-2 font-weight-regular"},[e("b",[t._v(t._s(this.state.userName))]),t._v("님 안녕하세요!")]),e("br")]),e("v-col",{attrs:{cols:"3"}},[e("img",{attrs:{src:"img/mypage1.png",alt:"user",width:"60px"},on:{click:function(a){return t.goBuyHistory()}}})]),e("v-col",{attrs:{cols:"3"}},[e("img",{attrs:{src:"img/mypage2.png",alt:"user",width:"60"}})]),e("v-col",{attrs:{cols:"3"}},[e("img",{attrs:{src:"img/mypage3.png",alt:"user",width:"60"},on:{click:function(a){return t.goMySalesList()}}})]),e("v-col",{attrs:{cols:"3"}},[e("img",{attrs:{src:"img/mypage4.png",alt:"user",width:"60"},on:{click:function(a){return t.goProductUpload()}}})])],1)],1)])],1),e("v-card",{staticClass:"mb-7"})],1),e("v-col",{attrs:{cols:"12",lg:"12"}},[e("v-card",{staticClass:"mb-12"},[e("v-card-text",{staticClass:"pa-5"},[e("v-row",{staticClass:"my-1",attrs:{align:"center"}},[e("table",{staticStyle:{width:"100%"}},[e("tr",[e("td",{staticStyle:{width:"70%"}},[e("h4",{staticClass:"mt-2 title blue-grey--text text--darken-2 font-weight-regular"},[t._v("나의 좋아요 내역")])]),e("td",{staticStyle:{"text-align":"right"}},[e("span",{staticClass:"mx-4 success--text"},[e("b",{staticStyle:{color:"#f76707","font-size":"18px"}},[t._v("＞")])])])])])])],1)],1),e("v-card",{staticClass:"mb-12"},[e("v-card-text",{staticClass:"pa-0"},[e("v-row",{staticClass:"my-0",attrs:{align:"center"}},[e("table",{staticStyle:{width:"100%"}},[e("tr",[e("td",{staticStyle:{width:"70%"}},[e("h4",{staticClass:"pa-5 mt-2 title blue-grey--text text--darken-2 font-weight-regular"},[t._v("공지사항")])]),e("td",{staticStyle:{"text-align":"right"}},[e("span",{staticClass:"pa-2 mx-4 success--text"},[e("b",{staticStyle:{color:"#f76707","font-size":"18px"}},[t._v("＞")])])])])])]),e("v-divider"),e("v-row",{staticClass:"my-1",attrs:{align:"center"}},[e("table",{staticStyle:{width:"100%"}},[e("tr",[e("td",{staticStyle:{width:"70%"}},[e("h4",{staticClass:"pa-5 mt-2 title blue-grey--text text--darken-2 font-weight-regular"},[t._v("앱 문의 및 건의")])]),e("td",{staticStyle:{"text-align":"right"}},[e("span",{staticClass:"pa-2 mx-4 success--text"},[e("b",{staticStyle:{color:"#f76707","font-size":"18px"}},[t._v("＞")])])])])])])],1)],1),e("v-card",{staticClass:"mb-12"},[e("v-card-text",{staticClass:"pa-0"},[e("v-row",{staticClass:"my-0",attrs:{align:"center"}},[e("table",{staticStyle:{width:"100%"}},[e("tr",[e("td",{staticStyle:{width:"70%"}},[e("h4",{staticClass:"pa-5 mt-2 title blue-grey--text text--darken-2 font-weight-regular"},[t._v("로그아웃")])]),e("td",{staticStyle:{"text-align":"right"}},[e("span",{staticClass:"pa-2 mx-4 success--text"},[e("b",{staticStyle:{color:"#f76707","font-size":"18px"}},[t._v("＞")])])])])])]),e("v-divider"),e("v-row",{staticClass:"my-1",attrs:{align:"center"}},[e("table",{staticStyle:{width:"100%"}},[e("tr",[e("td",{staticStyle:{width:"70%"}},[e("h4",{staticClass:"pa-5 mt-2 title blue-grey--text text--darken-2 font-weight-regular"},[t._v("회원정보수정")])]),e("td",{staticStyle:{"text-align":"right"}},[e("span",{staticClass:"pa-2 mx-4 success--text"},[e("b",{staticStyle:{color:"#f76707","font-size":"18px"}},[t._v("＞")])])])])])])],1)],1)],1)],1)],1)},i=[],c={name:"Main",data:function(){return{dtext:"George deo",emailtext:"",password:"",disableinput:"",checkbox1:"",checkbox2:"",checkbox3:"",show1:!1,rules:{required:function(t){return!!t||"Required."},min:function(t){return t.length>=8||"Min 8 characters"},emailMatch:function(){return"The email and password you entered don't match"}},items:["London","India","America"]}},components:{},methods:{goProductUpload:function(){location.href="/#/pages/ProductUpload"},goMySalesList:function(){location.href="/#/pages/MySalesList"},goBuyHistory:function(){location.href="/#/pages/BuyHistory"}}},r=c,l=e("2877"),n=e("6544"),o=e.n(n),d=e("b0af"),u=e("99d9"),g=e("62ad"),p=e("a523"),v=e("ce7e"),h=e("0fd9"),x=Object(l["a"])(r,s,i,!1,null,null,null);a["default"]=x.exports;o()(x,{VCard:d["a"],VCardText:u["b"],VCol:g["a"],VContainer:p["a"],VDivider:v["a"],VRow:h["a"]})},"99d9":function(t,a,e){"use strict";e.d(a,"a",(function(){return c})),e.d(a,"b",(function(){return l})),e.d(a,"c",(function(){return n}));var s=e("b0af"),i=e("80d2"),c=Object(i["g"])("v-card__actions"),r=Object(i["g"])("v-card__subtitle"),l=Object(i["g"])("v-card__text"),n=Object(i["g"])("v-card__title");s["a"]}}]);
//# sourceMappingURL=chunk-5a026898.ab2bf1af.js.map