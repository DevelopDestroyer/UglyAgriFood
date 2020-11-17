<template>
  <v-navigation-drawer
    v-model="Sidebar_drawer"
    :dark="SidebarColor !== 'white'"
    :color="SidebarColor"
    mobile-break-point="960"
    clipped
    :right="$vuetify.rtl"
    mini-variant-width="70"
    :expand-on-hover="expandOnHover"
    app
    id="main-sidebar"
  >
    <v-list dense nav>
      <!---USer Area -->
      <v-list-item two-line class="px-0">
        <v-list-item-avatar>
          <img src="https://randomuser.me/api/portraits/men/81.jpg" />
        </v-list-item-avatar>

        <v-list-item-content>
          <v-list-item-title>Dohn Deo</v-list-item-title>
          <v-list-item-subtitle class="caption">Webdesigner</v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <!---USer Area -->
      <!---Sidebar Items -->
      <v-list-item
        v-for="item in items"
        :key="item.title"
        :to="item.to"
        :active-class="`success white--text`"
        link
      >
        <v-list-item-icon>
          <v-icon>{{ item.icon }}</v-icon>
        </v-list-item-icon>

        <v-list-item-content>
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item-content>
      </v-list-item>
      <!---Sidebar Items -->
    </v-list>
  </v-navigation-drawer>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "Sidebar",
  props: {
    expandOnHover: {
      type: Boolean,
      default: false
    }
  },
  data: () => ({
    items: [
      {
        title: "Dashboard",
        icon: "mdi-view-dashboard",
        to: "/dashboard/basic-dashboard"
      },

      {
        title: "Profile",
        icon: "mdi-account-circle",
        to: "/pages/profile"
      },

      {
        title: "Alerts",
        icon: "mdi-alert",
        to: "/pages/alerts"
      },

      {
        title: "Icons",
        icon: "mdi-emoticon",
        to: "/pages/icons"
      },

      {
        title: "Basic Table",
        icon: "mdi-table-column-width",
        to: "/pages/tables-simple"
      },


      {
        title: "메인",
        icon: "mdi-table-column-width",
        to: "/pages/Main"
      },
      {
        title: "제품상세",
        icon: "mdi-table-column-width",
        to: "/pages/ProductDetail"
      },
      {
        title: "제품리스트",
        icon: "mdi-table-column-width",
        to: "/pages/ProductList"
      },
      {
        title: "마이페이지",
        icon: "mdi-table-column-width",
        to: "/pages/myInfo"
      },
      {
        title: "판매 글쓰기",
        icon: "mdi-table-column-width",
        to: "/pages/productUpload"
      },
      {
        title: "구매내역",
        icon: "mdi-table-column-width",
        to: "/pages/buyHistory"
      },
      {
        title: "나의 리뷰",
        icon: "mdi-table-column-width",
        to: "/pages/myReviewList"
      },
      {
        title: "나의 판매",
        icon: "mdi-table-column-width",
        to: "/pages/mySalesList"
      },
      {
        title: "회원가입",
        icon: "mdi-table-column-width",
        to: "/pages/join"
      }

    ]
  }),
  computed: {
    ...mapState(["SidebarColor", "SidebarBg"]),
    Sidebar_drawer: {
      get() {
        return this.$store.state.Sidebar_drawer;
      },
      set(val) {
        this.$store.commit("SET_SIDEBAR_DRAWER", val);
      }
    }
  },
  watch: {
    "$vuetify.breakpoint.smAndDown"(val) {
      this.$emit("update:expandOnHover", !val);
    }
  },

  methods: {}
};
</script>
<style lang="scss">
#main-sidebar{
  box-shadow:1px 0 20px rgba(0,0,0,.08);
  -webkit-box-shadow:1px 0 20px rgba(0,0,0,.08);
  .v-navigation-drawer__border{
    display: none;
  }
  .v-list{
    padding: 8px 15px;
  }
  .v-list-item{
      &__icon--text,
      &__icon:first-child{
        justify-content: center;
        text-align: center;
        width: 20px;
        
      }
      
  }    
}
</style>