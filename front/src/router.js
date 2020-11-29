import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
    mode: 'hash',
    base: process.env.BASE_URL,
    routes: [
        {
            path: '/',
            redirect: 'pages/main',
            component: () => import('@/layouts/Layout'),
            children: [
                // Components
                {
                    name: 'Alerts',
                    path: 'pages/alerts',
                    component: () => import('@/views/pages/Alerts'),
                },

                {
                    name: 'Profile',
                    path: 'pages/profile',
                    component: () => import('@/views/pages/Profile'),
                },

                {
                    name: 'Icons',
                    path: 'pages/icons',
                    component: () => import('@/views/pages/Icons'),
                },

                {
                    name: 'TableSimple',
                    path: 'pages/tables-simple',
                    component: () => import('@/views/pages/TableSimple'),
                },

                {
                    name: 'Dashboard',
                    path: 'dashboard/basic-dashboard',
                    component: () => import('@/views/dashboard/BasicDashboard'),
                },

                {
                    name: 'Main',
                    path: 'pages/main',
                    component: () => import('@/views/pages/Main'),
                },
                {
                    name: 'Product Detail',
                    path: 'pages/productDetail/:productId',
                    component: () => import('@/views/pages/ProductDetail'),
                },
                {
                    name: 'Product List',
                    path: 'pages/productList/:category',
                    component: () => import('@/views/pages/ProductList'),
                },
                {
                    name: 'My infomation',
                    path: 'pages/myInfo',
                    component: () => import('@/views/pages/MyInfo'),
                },
                {
                    name: 'Product upload',
                    path: 'pages/productUpload',
                    component: () => import('@/views/pages/ProductUpload'),
                },
                {
                    name: 'Buy History',
                    path: 'pages/buyHistory',
                    component: () => import('@/views/pages/BuyHistory'),
                },
                {
                    name: 'My Review List',
                    path: 'pages/myReviewList',
                    component: () => import('@/views/pages/MyReviewList'),
                },
                {
                    name: 'My Sales List',
                    path: 'pages/mySalesList',
                    component: () => import('@/views/pages/MySalesList'),
                },
                {
                    name: 'Join',
                    path: 'pages/join',
                    component: () => import('@/views/pages/Join'),
                }

            ]
        },

    ],
})