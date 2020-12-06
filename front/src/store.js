import Axios from 'axios'
import Vue from 'vue'
import Vuex from 'vuex'
import { BUS } from './views/pages/EventBus';

Vue.use(Vuex)

export default new Vuex.Store({
    components: { BUS },
    state: {
        //local
        //API_HOST: 'http://localhost:8080',
        //product
        API_HOST: 'http://35.185.255.70:8080',
        isLogin: true,
        userEmail : 'lee',
        userName : '이태호',
        userSeq : 3,

        Sidebar_drawer: null,
        Customizer_drawer: false,
        SidebarColor: 'white',
        SidebarBg: ''
      },
    mutations: {
        SET_SIDEBAR_DRAWER (state, payload) {
            state.Sidebar_drawer = payload
        },
        SET_CUSTOMIZER_DRAWER (state, payload) {
            state.Customizer_drawer = payload
        },
        SET_SIDEBAR_COLOR (state, payload) {
            state.SidebarColor = payload
        },
        SET_API_HOST (state, payload) {
            state.API_HOST = payload
        },

    },
    actions: {
        ///////////////////////////////////////////////////////////
        //    * SPECIAL API
        ///////////////////////////////////////////////////////////
        POST_INIT_DATA (context, payload) {
            return Axios.post(this.state.API_HOST + '/api/init/data', {
            })
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                })
        },
        ///////////////////////////////////////////////////////////
        //    * REVIEW API
        ///////////////////////////////////////////////////////////
        GET_REVIEW_DETAIL_DATA (context, payload) {
            return Axios.get(this.state.API_HOST + '/api/reviews?productId=' + payload.productId)
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                    //BUS.$emit('alertModalOpen', error);
                })
        },
        ///////////////////////////////////////////////////////////
        //    * PRODUCT API
        ///////////////////////////////////////////////////////////
        GET_MY_SALES_PRODUCT_DATA (context, payload) {
            return Axios.get(this.state.API_HOST + '/api/products?userId=' + this.state.userSeq)
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                })
        },
        GET_PRODUCT_DATA (context, payload) {
            let type = payload.type; //all, title, category
            let param = '';
            if(type == 'all'){
                param = '';
            }
            else if(type == 'title'){
                param = '?title=' + payload.keyword;
            }
            else{
                param = '?categoryName=' + payload.keyword;
            }
            return Axios.get(this.state.API_HOST + '/api/products' + param)
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                    //BUS.$emit('alertModalOpen', error);
                })
        },
        GET_PRODUCT_DETAIL_DATA (context, payload) {
            return Axios.get(this.state.API_HOST + '/api/products/' + payload.productId)
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                    //BUS.$emit('alertModalOpen', error);
                })
        },
        POST_PRODUCT_DATA (context, payload) {
            return Axios.post(this.state.API_HOST + '/api/products', {
                'category' : payload.category,
                'introduction': payload.introduction,
                'price' : payload.price,
                'productionArea' : payload.productionArea,
                'productionDate' : payload.productionDate,
                'title' : payload.title,
                'userId' : payload.userId,
                'storageMethod' : payload.storageMethod,
                'weightPerUnit' : payload.weightPerUnit,
                'composition' : payload.composition,
                'producer' : payload.producer,
                'origin' : payload.origin
            })
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                })
        },
        ///////////////////////////////////////////////////////////
        //    * PRODUCT API
        ///////////////////////////////////////////////////////////
        POST_FILE_DATA (context, payload) {
            return Axios.post(this.state.API_HOST + '/api/file/product/' + payload.id, payload.file,
                { headers: { 'Content-Type': 'multipart/form-data' }}
                )
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                })
        },
        ///////////////////////////////////////////////////////////
        //    * MAIN API
        ///////////////////////////////////////////////////////////
        GET_MAIN_DATA (context, payload) {
            return Axios.get(this.state.API_HOST + '/api/main/data')
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                    //BUS.$emit('alertModalOpen', error);
                })
        },

        ///////////////////////////////////////////////////////////
        //    * ORDER API
        ///////////////////////////////////////////////////////////
        GET_ORDER_DATA (context, payload) {
            let param = '?userId=' + this.state.userSeq;
            if(this.state.userSeq == ''){
                param = '';
            }
            return Axios.get(this.state.API_HOST + '/api/orders' + param)
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                    //BUS.$emit('alertModalOpen', error);
                })
        },
        POST_ORDER_DATA (context, payload) {
            return Axios.post(this.state.API_HOST + '/api/orders', {
                'productId' : payload.productId,
                'quantity': payload.quantity,
                'userId' : this.state.userSeq
            })
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                })
        },
        ///////////////////////////////////////////////////////////
        //    * USER API
        ///////////////////////////////////////////////////////////
        POST_LOGIN (context, payload){
            return Axios.post(this.state.API_HOST + '/api/login', {
                'email' : payload.email,
                'password': payload.password
            })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                    BUS.$emit('alertModalOpen', error);
                })
        },
        GET_USER (context, playload) {
            return Axios.get(this.state.API_HOST + '/api/' + playload.test)
                .then((result) => {
                   return result.data.result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                })
        },
        POST_USER (context, payload) {
            return Axios.post(this.state.API_HOST + '/api/users', {
                'email' : payload.id,
                'isSeller': true,
                'name' : payload.name,
                'password' : payload.password
            })
                .then((result) => {
                    console.log(payload.data);
                    return result
                })
                .catch(error => {
                    //에러팝업창
                    console.log(error);
                })
        }
    }
})