// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

//从elment-ui中导出组件 Button,Select...
import {
  Button,
  Select,
  Row,
  Col,
  Pagination,
  Table,
  TableColumn,
  Form,
  FormItem,
  Input,
  Dialog,
  Option
} from 'element-ui'

import App from './App'

import router from './router'

import 'element-ui/lib/theme-chalk/index.css'
import lang from 'element-ui/lib/locale/lang/en'
import locale from 'element-ui/lib/locale'

// 优雅的导入第三方库
//日期处理库
import moment from 'moment'
//网络请求
import axios from 'axios'
//魔幻线条框架
import curvejs from 'curvejs'

/**
 * 重新定义vue对象
 * Object.defineProperty(obj, prop, desc)
 * 作用就是直接在一个对象上定义一个新属性，或者修改一个已经存在的属性
 *
 * 参数说明：
 * obj 需要定义属性的当前对象
 * prop 当前需要定义的属性名
 * desc 属性描述符
 */

Object.defineProperty(Vue.prototype, '$moment', { value: moment });
Object.defineProperty(Vue.prototype, '$axios', { value: axios });
Object.defineProperty(Vue.prototype, '$curvejs', { value: curvejs });

//使用组件ElimentUi
Vue.use(Button);
Vue.use(Select);
Vue.use(Row);
Vue.use(Col);
Vue.use(Pagination);
Vue.use(Table);
Vue.use(TableColumn);
Vue.use(Form);
Vue.use(FormItem);
Vue.use(Input);
Vue.use(Dialog);
Vue.use(Option);
//使用语言组件
locale.use(lang);



Vue.config.productionTip = false




/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  // render: h => h(App)
  components: { App },
  template: '<App/>'
})

/***********************************
 * 关键说明：
 render: h => h(App)
 等价于
 render: function (createElement) {
     return createElement(App);
}
 createElement(简写成h)是vuejs里的一个函数。
 作用就是生成一个 VNode节点，render 函数得到这个 VNode 节点之后，
 返回给 Vue.js 的 mount 函数，渲染成真实 DOM 节点，并挂载到根节点上。

 其实在vue 1.0 中，这样的写法也就是如下的含义：
 new Vue({
  el: '#app',
  template:'</App>'
  componets: {App}
})
 然后在 App.vue中使用
 <div id='app'>
 <app></app>
 </div>

 */
