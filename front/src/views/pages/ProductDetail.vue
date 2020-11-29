<template>
  <v-container fluid class="down-top-padding">
    <v-row>
        <v-col cols="12" sm="12">
            <BaseCard v-bind:heading=productDetailData.title>
              <div class="text-center">
                <img src="img/product_detail_sample.jpg" style="max-width: 100%"/>
              </div>
            </BaseCard>
            <BaseCard heading="상품정보">
              <table style="width: 100%;">
                <tr>
                  <td style="width: 35%; color:dimgray;">원산지</td>
                  <td>{{ productDetailData.origin }}</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">생산자</td>
                  <td>{{ productDetailData.productionArea }}</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">보관방법, 취급방법</td>
                  <td>{{ productDetailData.storageMethod }}</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">제조년월일</td>
                  <td>{{ productDetailData.productionDate }}</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">개당중량</td>
                  <td>{{ productDetailData.weightPerUnit }}</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">상품구성</td>
                  <td>{{ productDetailData.composition }}</td>
                </tr>
              </table>
            </BaseCard>
            <BaseCard heading="상품소개">
              {{ productDetailData.introduction }}
            </BaseCard>
            <BaseCard heading="'생표고버섯'의 시세">
              <v-col cols="12" lg="12">
              <v-card>
                <b style="color:red;">※ 시세대비 {{ productDetailData.pricePercent }}% 저렴합니다.</b>
                <br/>
                <br/>
                <table  style="width:100%">
                  <tr>
                    <td colspan="6">
                       <span class="info--text">
                        <span class="overline">
                          <i class="mdi mdi-brightness-1 mr-2"></i>
                        </span>
                        <span class="font-weight-regular">평균시세</span>
                      </span>
                    </td>
                  </tr>
                  <tr>
                    <td colspan="6">
                      <v-sparkline
                          type="bar"
                          :fill="fill2"
                          height="80px"
                          :gradient="gradient2"
                          :line-width="width2"
                          :padding="padding2"
                          :smooth="radius2 || false"
                          :value="[p1, p2, p3, p4, p5, p6]"
                          auto-draw
                      ></v-sparkline>
                    </td>
                    <!--td>
                      <v-sparkline
                          type="bar"
                          :fill="fill"
                          height="80px"
                          :gradient="gradient"
                          :line-width="width"
                          :padding="padding"
                          :smooth="radius || false"
                          :value="value"
                          auto-draw
                      ></v-sparkline>
                    </td-->
                  </tr>
                  <tr style="text-align: center;">
                    <td>
                      오늘
                    </td>
                    <td>
                     어제
                    </td>
                    <td>
                      한주
                    </td>
                    <td>
                      이주
                    </td>
                    <td>
                    한달
                    </td>
                    <td>
                    일년
                    </td>
                  </tr>
                  <tr style="text-align: center; color:gray; font-size: 4px;">
                    <td>
                      {{productDetailData.retailProduct.todayAvgPrice}}
                    </td>
                    <td>
                      {{productDetailData.retailProduct.oneDayAvgPrice}}
                    </td>
                    <td>
                      {{productDetailData.retailProduct.oneWeekAvgPrice}}
                    </td>
                    <td>
                      {{productDetailData.retailProduct.twoWeekAvgPrice}}
                    </td>
                    <td>
                      {{productDetailData.retailProduct.oneMonthAvgPrice}}
                    </td>
                    <td>
                      {{productDetailData.retailProduct.oneYearAvgPrice}}
                    </td>
                  </tr>
                </table>
                </v-card>
              </v-col>
            </BaseCard>

            <BaseCard heading="리뷰">
              총 {{productDetailData.reviewCount}}개의 리뷰가 있습니다.
              <br/>
              <br/>
              <v-alert
                  v-for="item in reviewDetailData" v-bind:key="item.id"
                  border="right"
                  colored-border
                  type=""
                  elevation="2"
              >
                <v-list-item-avatar>
                  <img src="https://randomuser.me/api/portraits/men/81.jpg" />
                </v-list-item-avatar>
                <big><b>이태호짱</b></big>
                 / <b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px #000">★</b> 4.5점<br>
                너무 맛있네요
              </v-alert>

              <v-alert
                  border="right"
                  colored-border
                  type=""
                  elevation="2"
              >
                <v-list-item-avatar>
                  <img src="https://randomuser.me/api/portraits/men/81.jpg" />
                </v-list-item-avatar>
                <big><b>이진영짱</b></big>
                / <b style="color:#fdd835;font-size: 16px;text-shadow: 1px 1px 3px #000">★</b> 1점<br>
                별로에요
              </v-alert>

            </BaseCard>

            <BaseCard heading="구매하기">
              <table style="width:100%">
                <tr>
                  <td style="width: 20%">
                    <v-btn class="text-capitalize mt-0 element-0" color=""><b style="font-size: 24px; color:#FF9999">♥</b>찜하기</v-btn>
                  </td>
                  <td style="width: 30%; text-align: right;">
                    <b style="font-size: 20px;">{{productDetailData.price * cnt}}원</b>
                  </td>
                  <td style="text-align: right;">
                    <v-btn fab small color="primary" @click="cntReduce()">
                      －
                    </v-btn>
                    {{cnt}}개
                    <v-btn fab small color="primary" @click="cntAdd()">
                      ＋
                    </v-btn>
                  </td>
                </tr>
                <tr>
                  <td colspan="3">
                    <br/>
                    <v-btn dark color="success" style="width:100%">구매하기</v-btn>
                  </td>
                </tr>
              </table>
            </BaseCard>

        </v-col>
    </v-row>
  </v-container>
</template>

<script>
import {BUS} from "@/views/pages/EventBus";

const gradients = [
  ["#FF0000"],
  ["#FF0000"],
  ["#FF0000", "#FF0000", "#FF0000"],
  ["#FF0000"],
  ["#FF0000"],
  ["#FF0000", "#FF0000", "#FF0000"],
];

const gradients2 = [
  ["#1e88e5"],
  ["#1e88e5"],
  ["#1e88e5", "#1e88e5", "#1e88e5"],
  ["#1e88e5", "#1e88e5"],
  ["#1e88e5", "#1e88e5", "#1e88e5"],
  ["#1e88e5", "#1e88e5", "#1e88e5"]
];

export default {
  name: "Icons",

  data: () => ({
    testTitle : "[버섯스토리] 무농약 생표고버섯 330g",
    cnt : 1,
    p1 : 10000,
    p2 : 23000,
    p3 : 21000,
    p4 : 10300,
    p5 : 30000,
    p6 : 13400,
    reviewDetailData : [],
    productDetailData : {
      "id": 1,
      "userDTO": {
        "id": 2,
        "email": "chu",
        "name": "추대윤"
      },
      "title": "",
      "category": "농산물",
      "productionArea": "광주",
      "productionDate": "2020-08-21",
      "price": 10000,
      "introduction": "흠집이 좀 있는데 단맛이 많아서 일반사과랑 맛이 똑같습니다.",
      "retailProduct": {
        "id": 1,
        "isDeleted": false,
        "createdAt": "2020-11-29T20:06:53.483",
        "updatedAt": "2020-11-29T20:06:53.483",
        "deletedAt": null,
        "name": "사과",
        "kind": "후지(10개)",
        "grade": "상품",
        "todayAvgPrice": "27,138",
        "oneDayAvgPrice": "1",
        "oneWeekAvgPrice": "29,582",
        "twoWeekAvgPrice": "29,782",
        "oneMonthAvgPrice": "-",
        "oneYearAvgPrice": "0"
      },
      "createdAt": "2020-11-29T20:06:53.524",
      "updatedAt": "2020-11-29T20:06:53.524",
      "pricePercent": 36,
      "reviewCount": 1
    },

    fill: true,
    gradient: gradients[4],
    gradients,
    padding: 8,
    radius: 0,
    value: [0.0001, 0],
    width: 4,

    fill2: true,
    gradient2: gradients2[4],
    gradients2,
    radius2: 0,
    padding2: 0,
    value2: [5, 27507, 29581, 29781, 0, 10000],
    //value2: new Array(),
    width2: 4
  }),
  components: {
  },
  created () {
    this.getProductDetailData();
  },
  methods :{
    cntAdd(){
      this.cnt++;
    },
    cntReduce(){
      if(this.cnt==1)
        return;
      this.cnt--;
    },
    getReviewDetailData(){
      let vm = this;

      this.$store.dispatch('GET_REVIEW_DETAIL_DATA', {
        productId : this.$route.params.productId
      }).then((result) => {
        if(result.data.statusCode == 'OK'){
          console.log("정상응답");
          vm.productDetailData = result.data.data;
          console.log("product detail api 응답 완료" + vm.value2[5]);
        }
        else{
          BUS.$emit('alertModalOpen', result.data.message);
        }
      })
    },
    getProductDetailData(){
      let vm = this;

      this.$store.dispatch('GET_PRODUCT_DETAIL_DATA', {
        productId : this.$route.params.productId
      }).then((result) => {
        if(result.data.statusCode == 'OK'){
          console.log("정상응답");
          vm.productDetailData = result.data.data;
          vm.p1 = Number(result.data.data.retailProduct.todayAvgPrice.replace(/,/gi, "").replace("-", 0));
          vm.p2 = Number(result.data.data.retailProduct.oneDayAvgPrice.replace(/,/gi, "").replace("-", 0));
          vm.p3 = Number(result.data.data.retailProduct.oneWeekAvgPrice.replace(/,/gi, "").replace("-", 0));
          vm.p4 = Number(result.data.data.retailProduct.twoWeekAvgPrice.replace(/,/gi, "").replace("-", 0));
          vm.p5 = Number(result.data.data.retailProduct.oneMonthAvgPrice.replace(/,/gi, "").replace("-", 0));
          vm.p6 = Number(result.data.data.retailProduct.oneYearAvgPrice.replace(/,/gi, "").replace("-", 0));
          console.log("product detail api 응답 완료" + vm.value2[5]);
        }
        else{
          BUS.$emit('alertModalOpen', result.data.message);
        }
      })
    },
  }
};
</script>
