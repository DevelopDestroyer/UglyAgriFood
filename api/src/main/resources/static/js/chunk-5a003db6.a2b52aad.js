(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-5a003db6"],{"5a05":function(t,e,i){"use strict";i.r(e);var a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-container",{staticClass:"down-top-padding",attrs:{fluid:""}},[i("v-row",[i("v-col",{attrs:{cols:"12",lg:"12"}},[i("v-card",{staticClass:"position-relative profile-card mb-7"},[i("v-card-text",{staticClass:"pa-2"},[i("div",{staticClass:"text-center"},[i("v-row",{staticClass:"mt-2"},[i("v-col",{staticStyle:{"text-align":"left"},attrs:{cols:"12"}},[i("h4",{staticClass:"mt-2 title blue-grey--text text--darken-2 font-weight-regular",staticStyle:{"font-size":"24px",color:"#444444"}},[t._v("못난이 푸드를 할인된 가격에 만나보세요!")]),i("br")]),i("v-col",{attrs:{cols:"4"}},[i("img",{staticStyle:{"border-radius":"20%",border:"solid 1px #efefef","box-shadow":"5px 5px 5px #efefef"},attrs:{src:"img/main1.png",alt:"user",width:"85px;"},on:{click:function(e){return t.goProductList("all")}}}),i("h4",{staticClass:"font-weight-regular",staticStyle:{"font-size":"18px",color:"#444444"},on:{click:function(e){return t.goProductList("all")}}},[t._v("전체보기")])]),i("v-col",{attrs:{cols:"4"}},[i("img",{staticStyle:{"border-radius":"20%",border:"solid 1px #efefef","box-shadow":"5px 5px 5px #efefef"},attrs:{src:"img/main2.png",alt:"user",width:"85px"},on:{click:function(e){return t.goProductList("농산물")}}}),i("h4",{staticClass:"font-weight-regular",staticStyle:{"font-size":"18px",color:"#444444"},on:{click:function(e){return t.goProductList("농산물")}}},[t._v("농산")])]),i("v-col",{attrs:{cols:"4"}},[i("img",{staticStyle:{"border-radius":"20%",border:"solid 1px #efefef","box-shadow":"5px 5px 5px #efefef"},attrs:{src:"img/main3.png",alt:"user",width:"85px"},on:{click:function(e){return t.goProductList("수산물")}}}),i("h4",{staticClass:"font-weight-regular",staticStyle:{"font-size":"18px",color:"#444444"},on:{click:function(e){return t.goProductList("수산물")}}},[t._v("수산")])]),i("v-col",{attrs:{cols:"4"}},[i("img",{staticStyle:{"border-radius":"20%",border:"solid 1px #efefef","box-shadow":"5px 5px 5px #efefef"},attrs:{src:"img/main4.png",alt:"user",width:"85px;"},on:{click:function(e){return t.goProductList("축산물")}}}),i("h4",{staticClass:"font-weight-regular",staticStyle:{"font-size":"18px",color:"#444444"},on:{click:function(e){return t.goProductList("축산물")}}},[t._v("축산")])]),i("v-col",{attrs:{cols:"4"}},[i("img",{staticStyle:{"border-radius":"20%",border:"solid 1px #efefef","box-shadow":"5px 5px 5px #efefef"},attrs:{src:"img/main5.png",alt:"user",width:"85px;"},on:{click:function(e){return t.goProductList("가공물")}}}),i("h4",{staticClass:"font-weight-regular",staticStyle:{"font-size":"18px",color:"#444444"},on:{click:function(e){return t.goProductList("가공물")}}},[t._v("가공")])]),i("v-col",{attrs:{cols:"4"}},[i("img",{staticStyle:{"border-radius":"20%",border:"solid 1px #efefef","box-shadow":"5px 5px 5px #efefef"},attrs:{src:"img/main6.png",alt:"user",width:"85px;"},on:{click:function(e){return t.goProductList("기타")}}}),i("h4",{staticClass:"font-weight-regular",staticStyle:{"font-size":"18px",color:"#444444"},on:{click:function(e){return t.goProductList("기타")}}},[t._v("기타")])])],1)],1)])],1),i("v-card",{staticClass:"mb-7"})],1),i("v-col",{staticStyle:{height:"140px"},attrs:{cols:"12",lg:"12"}},[i("div",{staticStyle:{width:"100%",display:"flex"}},[i("div",{staticStyle:{flex:"1"}}),i("div",{staticStyle:{width:"280px"}},[i("image-slider",{staticStyle:{height:"140px"}},[i("transition-group",{attrs:{name:"fade",tag:"div"}},t._l([t.currentNumber],(function(e){return i("div",{key:e},[i("img",{staticStyle:{"max-width":"280px"},attrs:{src:t.currentImage},on:{mouseover:t.stopRotation,mouseout:t.startRotation}})])})),0)],1)],1),i("div",{staticStyle:{flex:"1"}})])]),i("v-col",{attrs:{cols:"12",lg:"12"}},[i("v-card",{staticClass:"mb-12"},[i("v-card-text",{staticClass:"pa-5"},[i("v-row",{staticClass:"my-1",attrs:{align:"center"}},[i("table",{staticStyle:{width:"100%"}},[i("tr",[i("td",{staticStyle:{width:"60%"}},[""==this.$store.state.userName?i("span",{staticClass:"mx-2",staticStyle:{color:"#444444","font-size":"18px"}},[i("b",[t._v("비회원님을 위한 추천상품")])]):i("span",{staticClass:"mx-2",staticStyle:{color:"#444444","font-size":"18px"}},[i("b",[t._v(t._s(this.$store.state.userName)+"님을 위한 추천상품")])])]),i("td",{staticStyle:{"text-align":"right"}},[i("span",{staticClass:"mx-4 success--text"},[i("b",{staticStyle:{color:"#f76707","font-size":"16px"}},[t._v("더보기＞")])])])])])]),i("v-divider",{staticClass:"mb-4"}),i("div",{staticStyle:{width:"auto",height:"230px","overflow-x":"scroll","white-space":"nowrap"}},[i("table",[i("tr",t._l(t.recommendProductList,(function(e){return i("td",{key:e.id,attrs:{valign:"top"},on:{click:function(i){return t.goProductDetail(e.id)}}},[i("div",{staticClass:"text-left",staticStyle:{width:"140px","white-space":"normal"}},[i("img",{staticStyle:{"border-radius":"7px","-moz-border-radius":"7px","-khtml-border-radius":"7px","-webkit-border-radius":"7px"},attrs:{src:"img/1.png",alt:"product",width:"120px"}}),i("h6",{staticClass:"font-weight-regular",staticStyle:{"font-size":"14px"}},[t._v(t._s(e.name))]),i("h6",{staticClass:"op-5 font-weight-regular",staticStyle:{"font-size":"10px"}},[i("b",{staticStyle:{color:"#fdd835","font-size":"16px","text-shadow":"1px 1px 3px gray"}},[t._v(t._s(t.ranStar(e.reviewCount)))]),t._v(" ("+t._s(e.reviewCount)+") ")]),i("h6",{staticClass:"op-5 font-weight-regular",staticStyle:{"font-size":"10px"}},[t._v("시세 평균 "),i("span",{staticStyle:{"text-decoration":"line-through","font-size":"10px"}},[t._v(" "+t._s(e.retailProduct.todayAvgPrice)+"원")])]),i("h4",{staticStyle:{"font-size":"16px"}},[i("b",{staticStyle:{color:"#f76707","font-size":"18px"}},[t._v(t._s(e.pricePercent)+"%")]),t._v(" "+t._s(e.price)+"원")])])])})),0)])])],1)],1)],1),i("v-col",{attrs:{cols:"12",lg:"12"}},[i("v-card",{staticClass:"mb-12"},[i("v-card-text",{staticClass:"pa-5"},[i("v-row",{staticClass:"my-1",attrs:{align:"center"}},[i("table",{staticStyle:{width:"100%"}},[i("tr",[i("td",{staticStyle:{width:"60%"}},[i("span",{staticClass:"mx-2",staticStyle:{color:"#444444","font-size":"18px"}},[i("b",[t._v("시세보다 50% 이상 저렴해요!")])])]),i("td",{staticStyle:{"text-align":"right"}},[i("span",{staticClass:"mx-4 success--text"},[i("b",{staticStyle:{color:"#f76707","font-size":"16px"}},[t._v("더보기＞")])])])])])]),i("v-divider",{staticClass:"mb-4"}),i("div",{staticStyle:{width:"auto",height:"230px","overflow-x":"scroll","white-space":"nowrap"}},[i("table",[i("tr",t._l(t.cheapProductList,(function(e){return i("td",{key:e.id,attrs:{valign:"top"},on:{click:function(i){return t.goProductDetail(e.id)}}},[i("div",{staticClass:"text-left",staticStyle:{width:"140px","white-space":"normal"}},[i("img",{staticStyle:{"border-radius":"7px","-moz-border-radius":"7px","-khtml-border-radius":"7px","-webkit-border-radius":"7px"},attrs:{src:"img/1.png",alt:"product",width:"120px"}}),i("h6",{staticClass:"font-weight-regular",staticStyle:{"font-size":"14px"}},[t._v(t._s(e.name))]),i("h6",{staticClass:"op-5 font-weight-regular",staticStyle:{"font-size":"10px"}},[i("b",{staticStyle:{color:"#fdd835","font-size":"16px","text-shadow":"1px 1px 3px gray"}},[t._v(t._s(t.ranStar(e.reviewCount)))]),t._v(" ("+t._s(e.reviewCount)+") ")]),i("h6",{staticClass:"op-5 font-weight-regular",staticStyle:{"font-size":"10px"}},[t._v("시세 평균 "),i("span",{staticStyle:{"text-decoration":"line-through"}},[t._v(" "+t._s(e.retailProduct.todayAvgPrice)+"원")])]),i("h4",{staticStyle:{"font-size":"16px"}},[i("b",{staticStyle:{color:"#f76707","font-size":"18px"}},[t._v(t._s(e.pricePercent)+"%")]),t._v(" "+t._s(e.price)+"원")])])])})),0)])])],1)],1)],1)],1)],1)},s=[],r=i("72de"),o={name:"Main",el:"image-slider",data:function(){return{recommendProductList:[],cheapProductList:[],relatedProductList:[],images:["img/banner1.png","img/banner2.png","img/banner3.png"],currentNumber:0,timer:null,dtext:"George deo",emailtext:"",password:"",disableinput:"",checkbox1:"",checkbox2:"",checkbox3:"",show1:!1,rules:{required:function(t){return!!t||"Required."},min:function(t){return t.length>=8||"Min 8 characters"},emailMatch:function(){return"The email and password you entered don't match"}},items:["London","India","America"]}},components:{},created:function(){this.getMainData()},mounted:function(){this.startRotation()},computed:{currentImage:function(){return this.images[Math.abs(this.currentNumber)%this.images.length]}},methods:{startRotation:function(){this.timer=setInterval(this.next,3e3)},stopRotation:function(){clearTimeout(this.timer),this.timer=null},next:function(){this.currentNumber+=1},prev:function(){this.currentNumber-=1},goProductDetail:function(t){location.href="/#/pages/ProductDetail/"+t},goProductList:function(t){location.href="/#/pages/ProductList/"+t},getMainData:function(){var t=this;this.$store.dispatch("GET_MAIN_DATA",{data:"getMaindata Req"}).then((function(e){"OK"==e.data.statusCode?(console.log("정상응답"),t.recommendProductList=e.data.data.recommendProductList,t.cheapProductList=e.data.data.cheapProductList,t.relatedProductList=e.data.data.relatedProductList,console.log("메인데이터 api 응답 완료")):r["a"].$emit("alertModalOpen",e.data.message)}))},ranStar:function(t){var e=Math.floor(3*Math.random()+5);return 0==t?"★":5==e?"★★★★★":4==e?"★★★★":"★★★"}}},c=o,n=i("2877"),l=i("6544"),d=i.n(l),u=i("b0af"),p=i("99d9"),f=i("62ad"),x=i("a523"),g=i("ce7e"),h=i("0fd9"),m=Object(n["a"])(c,a,s,!1,null,null,null);e["default"]=m.exports;d()(m,{VCard:u["a"],VCardText:p["b"],VCol:f["a"],VContainer:x["a"],VDivider:g["a"],VRow:h["a"]})},"99d9":function(t,e,i){"use strict";i.d(e,"a",(function(){return r})),i.d(e,"b",(function(){return c})),i.d(e,"c",(function(){return n}));var a=i("b0af"),s=i("80d2"),r=Object(s["g"])("v-card__actions"),o=Object(s["g"])("v-card__subtitle"),c=Object(s["g"])("v-card__text"),n=Object(s["g"])("v-card__title");a["a"]}}]);
//# sourceMappingURL=chunk-5a003db6.a2b52aad.js.map