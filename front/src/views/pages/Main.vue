<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="12">
        <v-card class="position-relative profile-card mb-7">
          <v-card-text class="pa-2">
            <div class="text-center">
              <v-row class="mt-2">
                <v-col cols="12" style="text-align: left;">
                  <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular" style="font-size: 24px; color:#444444">못난이 푸드를 할인된 가격에 만나보세요!</h4><br/>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/main1.png"
                      alt="user"
                      width="85px;"
                      style="border-radius: 20%; border: solid 1px #efefef; box-shadow: 5px 5px 5px #efefef;"
                      @click="goProductList('all')"
                  />
                  <h4 @click="goProductList('all')" class="font-weight-regular"  style="font-size: 18px; color: #444444">전체보기</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/main2.png"
                      alt="user"
                      style="border-radius: 20%; border: solid 1px #efefef; box-shadow: 5px 5px 5px #efefef;"
                      width="85px"
                      @click="goProductList('농산물')"
                  />
                  <h4 @click="goProductList('농산물')" class="font-weight-regular" style="font-size: 18px; color: #444444">농산</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/main3.png"
                      alt="user"
                      style="border-radius: 20%; border: solid 1px #efefef; box-shadow: 5px 5px 5px #efefef;"
                      width="85px"
                      @click="goProductList('수산물')"
                  />
                  <h4 @click="goProductList('수산물')" class="font-weight-regular" style="font-size: 18px; color: #444444">수산</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/main4.png"
                      alt="user"
                      style="border-radius: 20%; border: solid 1px #efefef; box-shadow: 5px 5px 5px #efefef;"
                      width="85px;"
                      @click="goProductList('축산물')"
                  />
                  <h4 @click="goProductList('축산물')" class="font-weight-regular" style="font-size: 18px; color: #444444">축산</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/main5.png"
                      alt="user"
                      style="border-radius: 20%; border: solid 1px #efefef; box-shadow: 5px 5px 5px #efefef;"
                      width="85px;"
                      @click="goProductList('가공품')"
                  />
                  <h4 @click="goProductList('가공품')" class="font-weight-regular" style="font-size: 18px; color: #444444">가공</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/main6.png"
                      alt="user"
                      style="border-radius: 20%; border: solid 1px #efefef; box-shadow: 5px 5px 5px #efefef;"
                      width="85px;"
                      @click="goProductList('기타')"
                  />
                  <h4 @click="goProductList('기타')" class="font-weight-regular" style="font-size: 18px; color: #444444">기타</h4>
                </v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>
        <v-card class="mb-7">
        </v-card>
      </v-col>

      <v-col cols="12" lg="12" style="height:140px;">
        <div style="width:100%; display: flex;">
          <div style="flex: 1;">
          </div>
          <div style="width:280px;" @click="goBlog();">
            <image-slider style="height:140px;">
              <transition-group name='fade' tag='div'>
                <div
                    v-for="number in [currentNumber]"
                    :key='number'
                >
                  <img
                      :src="currentImage"
                      style="max-width:280px;"
                      v-on:mouseover="stopRotation"
                      v-on:mouseout="startRotation"
                  />
                </div>
              </transition-group>

            </image-slider>
          </div>
          <div style="flex: 1;">
          </div>

        </div>
        <!--div style="width:100%; text-align: center;">
          <p>
            <a @click="prev" style="color:darkgray">◀</a> || <a @click="next" style="color:darkgray">▶</a>
          </p>

        </div-->
      </v-col>


      <v-col cols="12" lg="12">
        <v-card class="mb-12">
          <v-card-text class="pa-5">

            <v-row class="my-1" align="center">
              <!--h3 class="title blue-grey--text text--darken-2 font-weight-regular mb-4">평균시세보다 50% 이상 저렴해요!</h3>
              <span class="mx-4 success--text">전체보기</span-->

              <table style="width:100%;">
                <tr>
                  <td style="width:60%;">
                    <span style="color:#444444; font-size: 18px;" class="mx-2" v-if="this.$store.state.userName == ''"><b>비회원님을 위한 추천상품</b></span>
                    <span style="color:#444444; font-size: 18px;" class="mx-2" v-else><b>{{this.$store.state.userName }}님을 위한 추천상품</b></span>
                  </td>
                  <td style="text-align: right;">
                    <span class="mx-4 success--text"><b style="color:#f76707; font-size: 16px;">더보기＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>

            <v-divider class="mb-4"></v-divider>

            <div style="width: auto; height: 240px; overflow-x: scroll; white-space: nowrap;">
              <table>
                <tr>
                  <td valign="top" v-for="item in recommendProductList" v-bind:key="item.id" @click="goProductDetail(item.id)">
                    <div class="text-left"  style="width:140px; white-space: normal;">
                      <img
                          v-bind:src="'download/' + item.id + '_thumbnailImage.jpg'"
                          alt="product"
                          width="120px"
                          style="border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;"
                      />
                      <h6 class="font-weight-regular" style="font-size:14px;">{{item.title}}</h6>
                      <h6 class="op-5 font-weight-regular" style="font-size:10px;">
                        <b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px gray">{{ ranStar(item.reviewCount) }}</b>
                        ({{item.reviewCount}})
                      </h6>
                      <h6 class="op-5 font-weight-regular" style="font-size:10px;">시세 평균 <span style="text-decoration:line-through; font-size: 10px;"> {{item.retailProduct.todayAvgPrice}}원</span></h6>
                      <h4 style="font-size: 16px;"><b style="color:#f76707; font-size: 18px;">{{ 100 - item.pricePercent }}%</b> {{comma(item.price)}}원</h4>
                    </div>
                  </td>

                </tr>
              </table>
            </div>

          </v-card-text>
        </v-card>
      </v-col>


      <v-col cols="12" lg="12">
        <v-card class="mb-12">
          <v-card-text class="pa-5">

            <v-row class="my-1" align="center">
              <!--h3 class="title blue-grey--text text--darken-2 font-weight-regular mb-4">평균시세보다 50% 이상 저렴해요!</h3>
              <span class="mx-4 success--text">전체보기</span-->

              <table style="width:100%;">
                <tr>
                  <td style="width:60%;">
                    <!--h5 class="title blue-grey--text text--darken-2 font-weight-regular mb-4">평균시세보다 50% 이상 저렴해요!</h5-->
                    <span style="color:#444444; font-size: 18px;" class="mx-2"><b>시세보다 50% 이상 저렴해요!</b></span>
                  </td>
                  <td style="text-align: right;">
                    <span class="mx-4 success--text"><b style="color:#f76707; font-size: 16px;">더보기＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>

            <v-divider class="mb-4"></v-divider>

            <div style="width: auto; height: 240px; overflow-x: scroll; white-space: nowrap;">
              <table>
                <tr>
                  <td valign="top" v-for="item in cheapProductList" v-bind:key="item.id" @click="goProductDetail(item.id)">
                    <div class="text-left"  style="width:140px; white-space: normal">
                      <img
                          v-bind:src="'download/' + item.id + '_thumbnailImage.jpg'"
                          alt="product"
                          width="120px"
                          style="border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;"
                      />
                      <h6 class="font-weight-regular" style="font-size:14px;">{{item.title}}</h6>
                      <h6 class="op-5 font-weight-regular" style="font-size:10px;">
                        <b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px gray">{{ ranStar(item.reviewCount) }}</b>
                        ({{ item.reviewCount }})
                      </h6>
                      <h6 class="op-5 font-weight-regular" style="font-size:10px;">시세 평균 <span style="text-decoration:line-through"> {{item.retailProduct.todayAvgPrice}}원</span></h6>
                      <h4 style="font-size: 16px;"><b style="color:#f76707; font-size: 18px;">{{ 100 - item.pricePercent }}%</b> {{comma(item.price)}}원</h4>
                    </div>
                  </td>

                </tr>
              </table>
            </div>

          </v-card-text>
        </v-card>
            </v-col>
          </v-row>
        </v-container>
      </template>

      <script>
      import {BUS} from "@/views/pages/EventBus";

      export default {
        name: "Main",
        el: 'image-slider',
        data: () => ({
          //main data api
          recommendProductList : [],
          cheapProductList : [],
          relatedProductList : [],


          images: ['img/banner1.png', 'img/banner2.png', 'img/banner3.png'],
          currentNumber: 0,
          timer: null,

          dtext: "George deo",
          emailtext: "",
          password: "",
          disableinput: "",
          checkbox1: "",
          checkbox2: "",
          checkbox3: "",
          show1: false,
          rules: {
            required: value => !!value || "Required.",
            min: v => v.length >= 8 || "Min 8 characters",
            emailMatch: () => "The email and password you entered don't match"
          },
          items: ["London", "India", "America"]
        }),
        components: {},
        created () {
          this.getMainData();
        },
        mounted: function () {
          this.startRotation();
        },

        computed: {
          currentImage: function() {
            return this.images[Math.abs(this.currentNumber) % this.images.length];
          }
        },
        methods: {
          startRotation: function() {
            this.timer = setInterval(this.next, 3000);
          },

          stopRotation: function() {
            clearTimeout(this.timer);
            this.timer = null;
          },

          next: function() {
            this.currentNumber += 1
          },
          prev: function() {
            this.currentNumber -= 1
          },
          goBlog(){
            location.href="https://matmanjohne.tistory.com/";
          },
          goProductDetail(param){
            location.href= "/#/pages/ProductDetail/"+param;
          },

          goProductList(param){
            location.href= "/#/pages/ProductList/"+param;
          },
          comma(x){
            return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
          },
          getMainData(){
            let vm = this;
            this.$store.dispatch('GET_MAIN_DATA', {
              'data':'getMaindata Req'
            }).then((result) => {
              if(result.data.statusCode == 'OK'){
                console.log("정상응답");
                vm.recommendProductList = result.data.data.recommendProductList;
                vm.cheapProductList = result.data.data.cheapProductList;
                vm.relatedProductList = result.data.data.relatedProductList;

                console.log("메인데이터 api 응답 완료");
              }
              else{
                BUS.$emit('alertModalOpen', result.data.message);
              }
            })
          },
          ranStar(reviewCnt){
            let res = Math.floor( Math.random() * 3 + 5 );
            if(reviewCnt == 0)
              return '★';
            else if(res == 5)
              return '★★★★★';
            else if(res == 4)
              return '★★★★';
            else
              return '★★★';

          }
        }
      };
      </script>
