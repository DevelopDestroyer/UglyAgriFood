<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="12">
        <v-card class="position-relative profile-card mb-7">
          <v-card-text class="pa-5">
            <div class="text-center">
              <v-row class="mt-6">
                <v-col cols="12" style="text-align: center;">
                  <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">못난이 푸드를 할인된 가격에 만나보세요!</h4><br/>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/1.png"
                      alt="user"
                      class="rounded-circle"
                      width="100"
                      @click="alert('hi');"
                  />
                  <h4 @click="alert('hi');" class="font-weight-regular">전체보기</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/2.png"
                      alt="user"
                      class="rounded-circle"
                      width="100"
                  />
                  <h4 class="font-weight-regular">농산</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/3.png"
                      alt="user"
                      class="rounded-circle"
                      width="100"
                  />
                  <h4 class="font-weight-regular">수산</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/4.png"
                      alt="user"
                      class="rounded-circle"
                      width="100"
                  />
                  <h4 class="font-weight-regular">축산</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/5.png"
                      alt="user"
                      class="rounded-circle"
                      width="100"
                  />
                  <h4 class="font-weight-regular">가공</h4>
                </v-col>
                <v-col cols="4">
                  <img
                      src="img/6.png"
                      alt="user"
                      class="rounded-circle"
                      width="100"
                  />
                  <h4 class="font-weight-regular">기타</h4>
                </v-col>
              </v-row>
            </div>
          </v-card-text>
        </v-card>
        <v-card class="mb-7">
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
                  <td style="width:70%;">
                    <span style="color:black; font-size: 18px;" class="mx-4 blue-grey--text" v-if="this.$store.state.userName == ''"><b>비회원님을 위한 추천상품</b></span>
                    <span style="color:black; font-size: 18px;" class="mx-4 blue-grey--text" v-else><b>{{this.$store.state.userName }}님을 위한 추천상품</b></span>
                  </td>
                  <td style="text-align: right;">
                    <span class="mx-4 success--text"><b style="color:#f76707; font-size: 14px;">더보기＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>

            <v-divider class="mb-4"></v-divider>

            <div style="width: auto; height: 220px; overflow-x: scroll; white-space: nowrap;">
              <table>
                <tr>
                  <td valign="top" v-for="item in recommendProductList" v-bind:key="item.id">
                    <div class="text-left"  style="width:110px; white-space: normal">
                      <img
                          src="img/1.png"
                          alt="product"
                          width="100px"
                          style="border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;"
                      />
                      <h6 class="font-weight-regular" style="line-height:12px;">{{item.name}}</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px #000">★★★★</b>(781)</h6>
                      <h6 class="op-5 font-weight-regular">시세 평균 <span style="text-decoration:line-through"> {{item.retailProduct.todayAvgPrice}}원</span></h6>
                      <h4><b style="color:red;">60%</b> {{item.price}}원</h4>
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
                  <td style="width:70%;">
                    <!--h5 class="title blue-grey--text text--darken-2 font-weight-regular mb-4">평균시세보다 50% 이상 저렴해요!</h5-->
                    <span style="color:black; font-size: 18px;" class="mx-4 blue-grey--text"><b>평균시세보다 50% 이상 저렴해요!</b></span>
                  </td>
                  <td style="text-align: right;">
                    <span class="mx-4 success--text"><b style="color:#f76707; font-size: 14px;">더보기＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>

            <v-divider class="mb-4"></v-divider>

            <div style="width: auto; height: 220px; overflow-x: scroll; white-space: nowrap;">
              <table>
                <tr>
                  <td valign="top" v-for="item in cheapProductList" v-bind:key="item.id">
                    <div class="text-left"  style="width:110px; white-space: normal">
                      <img
                          src="img/1.png"
                          alt="product"
                          width="100px"
                          style="border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;"
                      />
                      <h6 class="font-weight-regular" style="line-height:12px;">{{item.name}}</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px #000">★★★★</b>(781)</h6>
                      <h6 class="op-5 font-weight-regular">시세 평균 <span style="text-decoration:line-through"> {{item.retailProduct.todayAvgPrice}}원</span></h6>
                      <h4><b style="color:red;">60%</b> {{item.price}}원</h4>
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

        data: () => ({
          //main data api
          recommendProductList : [],
          cheapProductList : [],
          relatedProductList : [],

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
        methods: {
          getMainData(){
            let vm = this;
            this.$store.dispatch('GET_MAIN_DATA', {
              'data':'getMaindata Req'
            }).then((result) => {
              //console.log("결과" + result);//바깥 리설트
              //console.log("결과2" + result.statusCode);//바깥 리설트
              //console.log("결과3" + result.data.statusCode);//바깥 리설트
              //console.log("결과" + result.data);//바깥 리설트
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
          }
        }
      };
      </script>
