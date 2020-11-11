<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="12">
        <v-card class="position-relative profile-card mb-7">
          <v-card-text class="pa-5">
            <div class="text-center">
              <v-row class="mt-6">
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
                    <!--h5 class="title blue-grey--text text--darken-2 font-weight-regular mb-4">평균시세보다 50% 이상 저렴해요!</h5-->
                    <span style="color:black;" class="mx-4 blue-grey--text">평균시세보다 50% 이상 저렴해요!</span>
                  </td>
                  <td style="text-align: right;">
                    <span class="mx-4 success--text">전체보기</span>
                  </td>
                </tr>
              </table>
            </v-row>

            <v-divider class="mb-4"></v-divider>

            <div style="width: auto; height: 220px; overflow-x: scroll; white-space: nowrap;">
              <table>
                <tr>
                  <td>
                    <div class="text-center"  style="width:110px; white-space: normal">
                      <img
                          src="img/1.png"
                          alt="product"
                          width="100"
                      />
                      <h6 class="font-weight-regular">[버섯스토리] 무농약 생송이버섯 330g</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:yellow;font-size: 16px;text-shadow: 1px 1px 3px #000">★</b> 4.8/5 (781)</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:red;">60%</b> 4000원</h6>
                    </div>
                  </td>
                  <td>
                    <div class="text-center"  style="width:110px; white-space: normal">
                      <img
                          src="img/2.png"
                          alt="product"
                          width="100"
                      />
                      <h6 class="font-weight-regular">[버섯스토리] 무농약 생송이버섯 330g</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:yellow;font-size: 16px;text-shadow: 1px 1px 3px #000">★</b> 4.8/5 (781)</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:red;">60%</b> 4000원</h6>
                    </div>
                  </td>
                  <td>
                    <div class="text-center"  style="width:110px; white-space: normal">
                      <img
                          src="img/3.png"
                          alt="product"
                          width="100"
                      />
                      <h6 class="font-weight-regular">[버섯스토리] 무농약 생송이버섯 330g</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:yellow;font-size: 16px;text-shadow: 1px 1px 3px #000">★</b> 4.8/5 (781)</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:red;">60%</b> 4000원</h6>
                    </div>
                  </td>
                  <td>
                    <div class="text-center"  style="width:110px; white-space: normal">
                      <img
                          src="img/5.png"
                          alt="product"
                          width="100"
                      />
                      <h6 class="font-weight-regular">[버섯스토리] 무농약 생송이버섯 330g</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:yellow;font-size: 16px;text-shadow: 1px 1px 3px #000">★</b> 4.8/5 (781)</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:red;">60%</b> 4000원</h6>
                    </div>
                  </td>
                  <td>
                    <div class="text-center"  style="width:110px; white-space: normal">
                      <img
                          src="img/4.png"
                          alt="product"
                          width="100"
                      />
                      <h6 class="font-weight-regular">[버섯스토리] 무농약 생송이버섯 330g</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:yellow;font-size: 16px;text-shadow: 1px 1px 3px #000">★</b> 4.8/5 (781)</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:red;">60%</b> 4000원</h6>
                    </div>
                  </td>
                  <td>
                    <div class="text-center"  style="width:110px; white-space: normal">
                      <img
                          src="img/6.png"
                          alt="product"
                          width="100"
                      />
                      <h6 class="font-weight-regular">[버섯스토리] 무농약 생송이버섯 330g</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:yellow;font-size: 16px;text-shadow: 1px 1px 3px #000">★</b> 4.8/5 (781)</h6>
                      <h6 class="op-5 font-weight-regular"><b style="color:red;">60%</b> 4000원</h6>
                    </div>
                  </td>

                </tr>
              </table>

            </div>

          </v-card-text>
        </v-card>
              <v-card>
                <v-card-text class="text-center pa-7">
                  <img
                      src="https://randomuser.me/api/portraits/men/81.jpg"
                      alt="user"
                      width="150px"
                      class="img-fluid rounded-circle shadow-sm"
                  />
                  <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">Hanna Gover</h4>
                  <h6 class="subtitle-2 font-weight-light">Accoubts Manager Amix corp</h6>
                </v-card-text>
              </v-card>
            </v-col>
            <v-col cols="12" lg="8">
              <v-card>
                <v-card-text>
                  <h3 class="title blue-grey--text text--darken-2 font-weight-regular">Default Form</h3>
                  <h6 class="subtitle-2 font-weight-light">All with vuetify element attributes</h6>
                </v-card-text>
                <v-divider></v-divider>
                <v-card-text>
                  <v-text-field
                      v-model="dtext"
                      label="Default Text e.g. 'George deo'"
                      filled
                      background-color="transparent"
                  ></v-text-field>
                  <v-text-field
                      type="email"
                      v-model="emailtext"
                      label="Email e.g. 'example@gmail.com"
                      filled
                      background-color="transparent"
                  ></v-text-field>
                  <v-text-field
                      v-model="password"
                      filled
                      background-color="transparent"
                      :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
                      :rules="[rules.required, rules.min]"
                      :type="show1 ? 'text' : 'password'"
                      name="input-10-1"
                      label="Password"
                      hint="At least 8 characters"
                      counter
                      @click:append="show1 = !show1"
                  ></v-text-field>
                  <v-textarea
                      filled
                      name="input-7-4"
                      rows="3"
                      label="Textarea"
                      value
                      background-color="transparent"
                  ></v-textarea>
                  <div class="mt-4">
                    <v-select :items="items" filled label="Select Country" background-color="transparent"></v-select>
                  </div>
                  <v-btn class="text-capitalize mt-5 element-0" color="success">Submit</v-btn>
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
        components: {}
      };
      </script>
