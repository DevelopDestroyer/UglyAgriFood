<template>
  <v-container fluid class="down-top-padding">
    <v-row>
        <v-col cols="12" sm="12">
            <BaseCard v-bind:heading=testTitle>
              <div class="text-center">
                <img src="img/product_detail_sample.jpg" style="max-width: 100%"/>
              </div>
            </BaseCard>

            <BaseCard heading="상품소개">
              안녕하세요 상품소개란입니다 감사합니다.
            </BaseCard>

            <BaseCard heading="상품등급">
                B
            </BaseCard>

            <BaseCard heading="생표고버섯의 평균">
              <v-col cols="12" lg="12">
              <v-card>
                <table  style="width:100%">
                  <tr>
                    <td colspan="2">
                      <div class="d-flex align-center">
                        <div class="d-flex align-center px-2">
                      <span class="success--text">
                        <span class="overline">
                          <i class="mdi mdi-brightness-1 mr-2"></i>
                        </span>
                        <span class="font-weight-regular">Ample</span>
                      </span>
                        </div>
                        <div class="d-flex align-center px-2">
                      <span class="info--text">
                        <span class="overline">
                          <i class="mdi mdi-brightness-1 mr-2"></i>
                        </span>
                        <span class="font-weight-regular">Pixel</span>
                      </span>
                        </div>
                      </div>
                    </td>
                  </tr>
                  <tr>
                    <td style="width:50%">
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
                    <td>
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
                    </td>
                  </tr>
                </table>
                </v-card>
              </v-col>
            </BaseCard>

            <BaseCard heading="리뷰">
                <IconClickable></IconClickable>
            </BaseCard>

            <BaseCard heading="구매하기">
                <IconMdiSvg></IconMdiSvg>
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
  ["#FF0000", "#FF0000"],
  ["#FF0000", "#FF0000", "#FF0000"],
  ["#FF0000", "#FF0000", "#FF0000"]
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
    value: [9, 0],
    width: 4,

    fill2: true,
    gradient2: gradients2[4],
    gradients2,
    radius2: 0,
    padding2: 0,
    value2: [0, 4],
    width2: 4
  }),
  components: {
      IconClickable: () => import('@/components/vuetifyComponents/icons/IconClickable'),
      IconMdiSvg: () => import('@/components/vuetifyComponents/icons/IconMdiSvg'),
  }
};
</script>
