<template>
  <v-app-bar app clipped-left clipped-right color="primary" dark>

    <v-dialog
        v-model="dialog"
        persistent
        max-width="600px"
    >
      <v-card>
        <v-card-title>
          <span class="headline">로그인</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <v-text-field
                    label="아이디"
                    v-model="loginModalEmail"
                    required
                ></v-text-field>
              </v-col>
              <v-col cols="12">
                <v-text-field
                    label="비밀번호"
                    type="password"
                    v-model="loginModalPassword"
                    required
                ></v-text-field>
              </v-col>
            </v-row>
          </v-container>

        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn class="text-capitalize mt-0 element-0" color="success" @click="dialog = false">취소</v-btn>
          <v-btn class="text-capitalize mt-0 element-0" color="success" @click="login()">로그인</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
    <v-dialog
        v-model="modalAlert"
        persistent
        max-width="600px"
    >
      <v-card>
        <v-card-title>
          <span class="headline">알림</span>
        </v-card-title>
        <v-card-text>
          <v-container>
            <v-row>
              <v-col cols="12">
                <h3>{{ modalMsg }}</h3>
              </v-col>
              <v-col cols="12">
              </v-col>
            </v-row>
          </v-container>

        </v-card-text>
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn class="text-capitalize mt-0 element-0" color="success" @click="modalAlert = false">확인</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>


    <v-toolbar-title class="align-center d-flex">
      <span class="logo-icon">
        <!--img src="../../assets/logo-light-icon.png" /-->
        <h5 v-if="this.$store.state.isLogin"><v-icon>mdi-account-circle</v-icon> {{ this.$store.state.userName }}님</h5>
        <h5 v-else>맛만 좋네</h5>

      </span>
      <!--span class="logo-text ml-2">
        <img src="../../assets/logo-light-text.png" class="mt-2" />
      </span-->
    </v-toolbar-title>
    <!--v-app-bar-nav-icon
      class="d-block d-md-none"
      @click="$vuetify.breakpoint.smAndDown ? setSidebarDrawer(!Sidebar_drawer) : $emit('input', !value)"
    /-->
    <v-spacer />
    <!---right part -->
    <v-autocomplete
        append-icon=""
        v-model="value"
        :items="items"
        style="padding-top: 15px;"
        label=""
    ></v-autocomplete>
    <v-icon>mdi-magnify</v-icon>
    <!--v-btn dark color="success" href="https://www.wrappixel.com/templates/materialpro-vuetify-admin/">Upgrade to Proz</v-btn-->
    <v-menu bottom left transition="scale-transition">
      <template v-slot:activator="{ on }">
        <v-btn dark icon v-on="on">
          <v-icon>mdi-dots-vertical</v-icon>
        </v-btn>
      </template>
      <v-list>
        <v-list-item @click="href">
          <v-list-item-title @click="dialog=true" v-if="!this.$store.state.isLogin">로그인</v-list-item-title>
          <v-list-item-title @click="logout()" v-else>로그아웃</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>
  </v-app-bar>

</template>
<script>
// Utilities
import { mapState, mapMutations } from "vuex";
import { BUS } from '../../views/pages/EventBus';

export default {
  name: "Header",

  // eslint-disable-next-line vue/no-unused-components
  components: { BUS },

  props: {
    value: {
      type: Boolean,
      default: false
    }
  },
  data: () => ({
    items: ['감자', '못난이 감자', '못난이 고구마', '못난이 사과', '못난이 귤'],
    values: ['', ''],
    value: null,
    dialog : false,
    loginModalEmail : '',
    loginModalPassword : '',
    modalAlert : false,
    modalMsg : '',


    userprofile: [
      { title: "로그인" },
      { title: "My Balance" },
      { title: "Inbox" },
      { title: "Account Setting" },
      { title: "Logout" }
    ],
    href() {
      return undefined;
    }
  }),

  computed: {
    ...mapState(["Sidebar_drawer"])
  },

  methods: {
    ...mapMutations({
      setSidebarDrawer: "SET_SIDEBAR_DRAWER"
    }),

    login(){
      this.$store.dispatch('POST_LOGIN', {
        email : this.loginModalEmail,
        password : this.loginModalPassword
      }).then((result) => {
        console.log("결과" + result);//바깥 리설트
        if(result.data.statusCode == 'OK'){
          this.$store.state.isLogin = true;
          this.$store.state.userEmail = result.data.data.email;
          this.$store.state.userName = result.data.data.name;
          this.$store.state.userSeq = result.data.data.id;
          this.dialog = false;
          this.loginModalEmail = '';
          this.loginModalPassword = '';
          console.log("로그인 완료 : " + result.data.email + ", " + result.data.name +", ");
        }
        else{
          BUS.$emit('alertModalOpen', result.data.message);
        }
      })
    },
    logout(){
      this.$store.state.isLogin = false;
      this.$store.state.userEmail = '';
      this.$store.state.userName = '';
      this.$store.state.userSeq = '';
    }
  },
  mounted() {
    let vm = this;
    BUS.$on('loginModalOpen',function(fromData){
      console.log("로그인 모달 오픈 요청, FROM => " + fromData);
      vm.dialog = true;
    });

    BUS.$on('alertModalOpen',function(fromData){
      console.log("알럿 모달 오픈 요청, FROM => " + fromData);
      if(fromData == 'SUCCESS'){
        return;
      }
      vm.modalMsg = fromData;
      vm.dialog = false;
      vm.modalAlert = true;
    });

    //BUS.$emit('loginModalOpen', 1);

  }
};
</script>