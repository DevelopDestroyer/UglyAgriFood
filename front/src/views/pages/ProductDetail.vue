<template>
  <v-container fluid class="down-top-padding">
    <v-row>
        <v-col cols="12" sm="12">
            <BaseCard v-bind:heading=testTitle>
              <div class="text-center">
                <img src="img/product_detail_sample.jpg" style="max-width: 100%"/>
              </div>
            </BaseCard>
            <BaseCard heading="상품정보">
              <table style="width: 100%;">
                <tr>
                  <td style="width: 35%; color:dimgray;">원산지</td>
                  <td>국내산</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">생산자</td>
                  <td>해남화산농협</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">보관방법, 취급방법</td>
                  <td>상온보관</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">제조년월일</td>
                  <td>2020-11-09</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">개당중량</td>
                  <td>3kg</td>
                </tr>
                <tr>
                  <td style="width: 35%; color:dimgray;">상품구성</td>
                  <td>고구마 3kg, 1개</td>
                </tr>
              </table>
            </BaseCard>
            <BaseCard heading="상품소개">
              안녕하세요 상품소개란입니다 감사합니다.
            </BaseCard>
            <BaseCard heading="'생표고버섯'의 시세">
              <v-col cols="12" lg="12">
              <v-card>
                <b style="color:red;">※ 시세대비 60% 저렴합니다.</b>
                <br/>
                <br/>
                <table  style="width:100%">
                  <tr>
                    <td colspan="2">
                      <v-sparkline
                          type="bar"
                          :fill="fill2"
                          height="80px"
                          :gradient="gradient2"
                          :line-width="width2"
                          :padding="padding2"
                          :smooth="radius2 || false"
                          :value="value2"
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
                  <tr>
                    <td>
                      <center>
                      <span class="info--text">
                        <span class="overline">
                          <i class="mdi mdi-brightness-1 mr-2"></i>
                        </span>
                        <span class="font-weight-regular">평균가격</span>
                      </span>
                      </center>
                    </td>
                    <td>
                      <center>
                      <span class="info--text">
                        <span class="overline">
                          <i class="mdi mdi-brightness-1 mr-2"></i>
                        </span>
                        <span class="font-weight-regular">판매가격</span>
                      </span>
                      </center>
                    </td>
                  </tr>
                </table>
                </v-card>
              </v-col>
            </BaseCard>

            <BaseCard heading="리뷰">
              <v-alert
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
                    <b style="font-size: 20px;">12000원</b>
                  </td>
                  <td style="text-align: right;">
                    <v-btn class="text-capitalize mt-0 element-0" color="">≪</v-btn>
                    1개
                    <v-btn class="text-capitalize mt-0 element-0" color="">≫</v-btn>
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
    value2: [100, 40],
    width2: 4
  }),
  components: {
  }
};
</script>
