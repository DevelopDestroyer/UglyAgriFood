<template>
  <v-container fluid class="down-top-padding">
    <v-row>
      <v-col cols="12" lg="12">
        <v-card>
          <v-card-text>
            <h3 class="title blue-grey--text text--darken-2 font-weight-regular">회원가입</h3>
            <h6 class="subtitle-2 font-weight-light">간편한 가입으로 맛만 좋네 서비스를 이용해보세요!</h6>
          </v-card-text>
          <v-divider></v-divider>
          <v-card-text>
            <v-text-field
              type="email"
              v-model="emailtext"
              label="ID를 입력해주세요"
              filled
              background-color="transparent"
            ></v-text-field>
            <v-text-field
                v-model="dtext"
                label="이름을 입력해주세요"
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
              label="비밀번호를 입력해주세요"
              hint="최소 8자 이상 입력해주세요"
              counter
              @click:append="show1 = !show1"
            ></v-text-field>
            <!--div class="mt-4">
              <v-select :items="items" filled label="구매자/판매자를 선택해주세요" background-color="transparent"></v-select>
            </div-->
            <v-btn class="text-capitalize mt-5 element-0" color="success" @click="testFunc()">완료</v-btn>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
//import { mapState } from "vuex";

export default {
  name: "Profile",

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
    items: ["구매자", "판매자", "America"]
  }),
  methods: {
    testFunc(){
      console.log("API호스트2 : " + this.$store.state.API_HOST);
      this.$store.dispatch('POST_USER', {
        id : 'test1111'
      }).then((result) => {
        //this.$store.dispatch('store/GET_USER', this.checkbox3).then((result) => {
        //  this.combobox3 = result;//안쪽 리설트
        //})
        console.log("결과" + result);//바깥 리설트
      })
    }
  },
  components: {}
};
</script>
