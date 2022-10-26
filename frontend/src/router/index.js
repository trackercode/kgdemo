import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserInfo from '@/components/UserInfo'
import SendData from "@/components/SendData";
import TestDemo from "@/components/TestDemo";
import SelectDemo from "@/components/SelectDemo";
import SalesDemo from "@/components/echarts/SalesDemo"
import TempDemo from "@/components/echarts/TempDemo"
import PerDemo from "@/components/echarts/PerDemo"
import CirGasflow from "@/components/echarts/CirGasflow"
import DouAxis from "@/components/echarts/DouAxis"
import JQueryDemo from "@/components/echarts/JQueryDemo"

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
    {
      path: '/send',
      name: 'SendData',
      component: SendData
    },
    {
      path: '/test',
      name: 'test',
      component: TestDemo
    },
    {
      path: '/select',
      name: 'select',
      component: SelectDemo
    },
    {
      path: '/sales',
      name: 'sales',
      component: SalesDemo
    },
    {
      path: '/temp',
      name: 'temp',
      component: TempDemo
    },
    {
      path: '/per',
      name: 'per',
      component: PerDemo
    },
    {
      path: '/cir',
      name: 'CirGasflow',
      component: CirGasflow
    },
    {
      path: '/dou',
      name: 'DouAxis',
      component: DouAxis
    },
    {
      path: '/jq',
      name: 'jQuery',
      component: JQueryDemo
    },
  ]
})
