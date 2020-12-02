<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="12">
        <v-card class="position-relative profile-card mb-0">
          <v-card-text class="pa-4">
            <div class="text-center">
              <v-row class="mt-0">
                <v-col cols="12" style="text-align: left;">
                  <h4 class="mt-0 title blue-grey--text text--darken-2 font-weight-regular"><b>{{ this.state.userName }}</b>님 안녕하세요!</h4><br/>
                </v-col>
                <v-col cols="3">
                  <img
                      src="img/mypage1.png"
                      alt="user"
                      width="60px"
                      @click="goBuyHistory()"
                  />
                </v-col>
                <v-col cols="3">
                  <img
                      src="img/mypage2.png"
                      alt="user"
                      width="60"
                  />
                </v-col>
                <v-col cols="3">
                  <img
                      src="img/mypage3.png"
                      alt="user"
                      width="60"
                      @click="goMySalesList()"
                  />
                </v-col>
                <v-col cols="3">
                  <img
                      src="img/mypage4.png"
                      alt="user"
                      width="60"
                      @click="goProductUpload()"
                  />
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
              <table style="width:100%;">
                <tr>
                  <td style="width:70%;">
                    <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">나의 좋아요 내역</h4>
                  </td>
                  <td style="text-align: right;">
                    <span class="mx-4 success--text"><b style="color:#f76707; font-size: 18px;">＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>
          </v-card-text>
        </v-card>


        <v-card class="mb-12">
          <v-card-text class="pa-0">
            <v-row class="my-0" align="center">
              <table style="width:100%;">
                <tr>
                  <td style="width:70%;">
                    <h4 class="pa-5 mt-2 title blue-grey--text text--darken-2 font-weight-regular">공지사항</h4>
                  </td>
                  <td style="text-align: right;">
                    <span class="pa-2 mx-4 success--text"><b style="color:#f76707; font-size: 18px;">＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>
            <v-divider></v-divider>
            <v-row class="my-1" align="center">
              <table style="width:100%;">
                <tr>
                  <td style="width:70%;">
                    <h4 class="pa-5 mt-2 title blue-grey--text text--darken-2 font-weight-regular">앱 문의 및 건의</h4>
                  </td>
                  <td style="text-align: right;">
                    <span class="pa-2 mx-4 success--text"><b style="color:#f76707; font-size: 18px;">＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>
          </v-card-text>
        </v-card>


        <v-card class="mb-12">
          <v-card-text class="pa-0">
            <v-row class="my-0" align="center">
              <table style="width:100%;">
                <tr>
                  <td style="width:70%;">
                    <h4 class="pa-5 mt-2 title blue-grey--text text--darken-2 font-weight-regular">로그아웃</h4>
                  </td>
                  <td style="text-align: right;">
                    <span class="pa-2 mx-4 success--text"><b style="color:#f76707; font-size: 18px;">＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>
            <v-divider></v-divider>
            <v-row class="my-1" align="center">
              <table style="width:100%;">
                <tr>
                  <td style="width:70%;">
                    <h4 class="pa-5 mt-2 title blue-grey--text text--darken-2 font-weight-regular">회원정보수정</h4>
                  </td>
                  <td style="text-align: right;">
                    <span class="pa-2 mx-4 success--text"><b style="color:#f76707; font-size: 18px;">＞</b></span>
                  </td>
                </tr>
              </table>
            </v-row>
          </v-card-text>
        </v-card>
            </v-col>
          </v-row>
        </v-container>
      </template>

      <script>
      export default {
        name: "Main",

        data: () => ({
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
        methods: {
          goProductUpload(){
            location.href="/#/pages/ProductUpload"
          },
          goMySalesList(){
            location.href="/#/pages/MySalesList"
          },
          goBuyHistory(){
            location.href="/#/pages/BuyHistory"
          },


        }

      };
      </script>
