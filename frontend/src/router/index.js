import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserInfo from '@/components/UserInfo'

Vue.use(Router)

export default new Router({
  routes: [
    //可以配置重定向
    {path:'',redirect:"user"},
    //或者重新写个路径为空的路由
    // {path:"",component:page1},
    {
      path: '/hello',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/user',
      name: 'UserInfo',
      component: UserInfo
    },
  ]
})
