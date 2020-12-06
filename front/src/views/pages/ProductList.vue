<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="12">
        <v-card>
          <v-card-text class="text-left pa-3">
            <h4 v-if="this.$route.params.category == 'all'" class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">상품 전체보기</h4>
            <h4 v-else-if="(this.$route.params.category).indexOf('_') != -1" class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">
              {{ this.$route.params.category.substr(1) }}에 대한 검색결과 입니다.</h4>
            <h4 v-else class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">{{ this.$route.params.category }} 전체보기</h4>
            <!--h6 class="subtitle-2 font-weight-light">평점순□</h6-->
            <v-select v-model="orderDefaultSelected" :items="orderSelected" filled label="정렬" background-color="transparent"></v-select>
          </v-card-text>
        </v-card>
      </v-col>

      <v-col cols="12" lg="12" v-for="item in productList" v-bind:key="item.id">
        <v-card>
          <v-row class="mt-6 pa-3">
            <v-col cols="6" @click="goProductDetail(item.id)">
              <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">{{ item.title }}</h4>
              <small class="blue-grey--text text--darken-2">{{ item.productionArea }} | {{ item.productionDate }} 이후</small><br/>
              <b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px gray">{{ ranStar(item.reviewCount) }}</b>
              <small class="blue-grey--text text--darken-2">({{ item.reviewCount }})</small><br/>
              <b style="font-size: 24px;">{{ comma(item.price) }}원</b> <i style="text-decoration:line-through;">{{ item.retailProduct.todayAvgPrice }}</i>
            </v-col>
            <v-col cols="6" style="text-align: right;" @click="goProductDetail(item.id)">
              <img v-bind:src="'download/' + item.id + '_thumbnailImage.jpg'" style="max-width: 128px;border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;">
            </v-col>
            <v-col cols="12">
              <v-alert
                  text
                  dense
                  color="warning"
                  icon="mdi-clock-fast"
                  border="left"
              >
                <b>빅데이터</b> 고구마의 현재 시세는 1kg 당 {{ comma(item.retailProduct.todayAvgPrice) }}원 입니다. 이 상품은 시세보다 <b style="color:#f76707; font-size: 24px">{{ 100 - item.pricePercent }}%</b> 저렴해요!
              </v-alert>
            </v-col>
          </v-row>
        </v-card>
      </v-col>

      <!--v-col cols="12" lg="12">
        <v-card>
        <v-row class="mt-6 pa-3">
          <v-col cols="8">
            <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">국내산 햇 꿀밤고구마, 1kg, 1박스</h4>
            <small class="blue-grey--text text--darken-2">충남 당진 | 2020.11.10 이후</small><br/>
            <b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px #000">★★★★</b>
            <small class="blue-grey--text text--darken-2">(341)</small><br/>
            <b style="font-size: 24px;">13,200원</b> <i style="text-decoration:line-through;">30,000</i>
          </v-col>
          <v-col cols="4" style="text-align: right;">
            <img src="img/4.png"  style="max-width: 128px;border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;">
          </v-col>
          <v-col cols="12">
            <v-alert
                text
                dense
                color="warning"
                icon="mdi-clock-fast"
                border="left"
            >
              <b>빅데이터</b> 고구마의 현재 시세는 1kg 당 30,000원 입니다. 이 상품은 시세보다 <b style="color:#f76707; font-size: 24px">66%</b> 저렴해요!
            </v-alert>
          </v-col>
        </v-row>
        </v-card>
      </v-col>

      <v-col cols="12" lg="12">
        <v-card>
          <v-row class="mt-6 pa-3">
            <v-col cols="8">
              <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">국내산 햇 꿀밤고구마, 1kg, 1박스</h4>
              <small class="blue-grey--text text--darken-2">충남 당진 | 2020.11.10 이후</small><br/>
              <b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px #000">★★★★</b>
              <small class="blue-grey--text text--darken-2">(341)</small><br/>
              <b style="font-size: 24px;">13,200원</b> <i style="text-decoration:line-through;">30,000</i>
            </v-col>
            <v-col cols="4" style="text-align: right;">
              <img src="img/3.png"  style="max-width: 128px;border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;">
            </v-col>
            <v-col cols="12">
              <v-alert
                  text
                  dense
                  color="warning"
                  icon="mdi-clock-fast"
                  border="left"
              >
                <b>빅데이터</b> 고구마의 현재 시세는 1kg 당 30,000원 입니다. 이 상품은 시세보다 <b style="color:#f76707; font-size: 24px">66%</b> 저렴해요!
              </v-alert>
            </v-col>
          </v-row>
        </v-card>
      </v-col-->

    </v-row>
  </v-container>
</template>

<script>
import {BUS} from "@/views/pages/EventBus";

export default {
  name: "Profile",

  data: () => ({
    productList : [],

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
    items: ["London", "India", "America"]
  }),

  components: {},
  created () {
    this.getProductData();
  },
  methods: {
    goProductDetail(id){
      location.href="/#/pages/productDetail/" + id;
    },
    comma(x){
      return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
    getProductData(){
      let vm = this;
      let type = '';
      let keyword = '';
      if((this.$route.params.category).indexOf('_') != -1){
        //검색기능
        type = 'title';
        keyword = this.$route.params.category.substr(1);
      }
      else if((this.$route.params.category).indexOf('all') != -1 || this.$route.params.category == null || this.$route.params.category == ''){
        type = 'all';
      }
      else{
        type = 'category';
        keyword = this.$route.params.category;
      }

      this.$store.dispatch('GET_PRODUCT_DATA', {
        type : type,
        keyword : keyword
      }).then((result) => {
        if(result.data.statusCode == 'OK'){
          console.log("정상응답");
          vm.productList = result.data.data;
          console.log("product api 응답 완료");
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
