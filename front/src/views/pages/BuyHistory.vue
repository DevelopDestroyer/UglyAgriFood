<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="12">
        <v-card>
          <v-card-text class="text-left pa-3">
            <h4 class="mt-0 title blue-grey--text text--darken-2 font-weight-regular">구매내역</h4>
          </v-card-text>
        </v-card>
      </v-col>


      <v-col cols="12" lg="12" v-for="item in myOrderList" v-bind:key="item.id">
        <v-card>
        <v-row class="mt-1 pa-2">
          <v-col cols="12">
            <small class="blue-grey--text text--darken-2">{{item.product.createdAt.split('T')[0]}} {{item.product.createdAt.split('T')[1]}}</small>
          </v-col>
          <v-col cols="4" style="text-align: right;">
            <img v-bind:src="item.product.imageUrl"  style="max-width: 128px;border-radius: 7px;
                            -moz-border-radius: 7px;
                            -khtml-border-radius: 7px;
                            -webkit-border-radius: 7px;">
          </v-col>
          <v-col cols="8">
            <h4 class="mt-2 title blue-grey--text text--darken-2 font-weight-regular">{{ item.product.name }}</h4>
            <small class="blue-grey--text text--darken-2">{{ item.product.comment }}</small><br/>
            <small class="blue-grey--text text--darken-2">{{ item.product.price }}원</small><br/>
            <small class="blue-grey--text text--darken-2">배송준비중</small><br/>
          </v-col>


        </v-row>
        </v-card>
      </v-col>

    </v-row>
  </v-container>
</template>

<script>
import {BUS} from "@/views/pages/EventBus";

export default {
  name: "Profile",

  data: () => ({
    myOrderList: [],

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
    this.getBuyData();
  },
  methods: {
    getBuyData(){
      let vm = this;
      this.$store.dispatch('GET_ORDER_DATA', {
        'data':'getBuyData Req'
      }).then((result) => {
        //console.log("결과" + result);//바깥 리설트
        //console.log("결과2" + result.statusCode);//바깥 리설트
        //console.log("결과3" + result.data.statusCode);//바깥 리설트
        //console.log("결과" + result.data);//바깥 리설트
        if(result.data.statusCode == 'OK'){
          console.log("정상응답");
          vm.myOrderList = result.data.data.recommendProductList;

          console.log("구매이력 api 응답 완료");
        }
        else{
          BUS.$emit('alertModalOpen', result.data.message);
        }
      })
    }
  }
};
</script>
