<template>
  <v-container fluid class="down-top-padding">
    <v-row >
      <v-col cols="12" lg="12">
        <v-card>
          <v-card-text class="text-left pa-3">
            <h4 class="mt-0 title blue-grey--text text--darken-2 font-weight-regular">나의 판매리스트</h4>
            <v-tabs
                v-model="active"
                color=""
                slider-color=""
            >
              <v-tab
                  ripple
                  style="width:50%"
                  @click="isReviewWriteBefore = true"
              >
                판매중 상품
              </v-tab>
              <v-tab
                  ripple
                  style="width:50%"
                  @click="isReviewWriteBefore = false"
              >
                판매종료 상품
              </v-tab>
              <v-tab-item
                  v-for="n in 3"
                  :key="n"
              >
                <!--v-card flat>
                  <v-card-text>{{ text }} 그리고 {{isReviewWriteBefore}}</v-card-text>
                </v-card-->
              </v-tab-item>
            </v-tabs>
          </v-card-text>
        </v-card>
      </v-col>


      <v-col cols="12" lg="12">

        <v-card v-for="item in mySalesList" v-bind:key="item.id">
          <v-row class="mt-1 pa-2">
            <v-col cols="5" style="text-align: right;">

              <img v-bind:src="'download/' + item.id + '_thumbnailImage.jpg'" style="max-width: 128px;border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;">
            </v-col>
            <v-col cols="7">
              <small class="blue-grey--text text--darken-2">{{ item.createdAt.split('T')[0] }}</small><br/>
              <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">{{ item.title }}</h4>
              <br/>
              <v-btn dark color="success">판매종료</v-btn>
            </v-col>
          </v-row>
        </v-card>

        <!--v-card v-if="isReviewWriteBefore">
        <v-row class="mt-1 pa-2">
          <v-col cols="5" style="text-align: right;">

            <img src="img/4.png"  style="max-width: 128px;border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;">
          </v-col>
          <v-col cols="7">
            <small class="blue-grey--text text--darken-2">2020.11.10</small><br/>
            <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">국내산 햇 꿀밤고구마, 1kg, 1박스</h4>
            <br/>
            <v-btn dark color="success">판매종료</v-btn>
          </v-col>
        </v-row>
        </v-card-->

      </v-col>
      <div style="height:700px;">
      </div>

    </v-row>
  </v-container>
</template>

<script>
import {BUS} from "@/views/pages/EventBus";

export default {
  name: "Profile",

  data: () => ({
    mySalesList : [],
    orderDefaultSelected: "평점순",
    orderSelected: ["평점순", "가격낮은순", "가격높은순"],
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
    items: ["London", "India", "America"],

    isReviewWriteBefore : true,
    active: null,
    text: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.'

  }),
  components: {},
  mounted (){
    this.getSalesData();

  },
  methods: {
    getSalesData(){
      let vm = this;
      this.$store.dispatch('GET_MY_SALES_PRODUCT_DATA', {
        'data':'getSalesData Req'
      }).then((result) => {
        if(result.data.statusCode == 'OK'){
          console.log("정상응답");
          vm.mySalesList = result.data.data;
          console.log("나의판매상품 api 응답 완료");
        }
        else{
          BUS.$emit('alertModalOpen', result.data.message);
        }
      })
    }
  }
};
</script>
