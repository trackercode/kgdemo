<!--查询条件组件-->
<template>
  <div>

    <el-form :inline="true" :model="formInline" >
        <!--性别查询条件下拉选宽：1先从数据字典中选中性别；
        2将选中的性别赋值给 model： formInline.sex 以实现对描述条件的级联渲染条件-->
        <el-form-item label="性别">
            <el-select v-model="formInline.sex" clearable placeholder="请选择性别">
                <el-option
                        v-for="(item, index) in type_options"
                        :key = "index"
                        :label="item.label"
                        :value="item.value">
                </el-option>
            </el-select>
        </el-form-item>
<!--邮箱查询条件:if else 条件渲染-->
<!--如果选择性别则启用表单-->
        <el-form-item v-if='formInline.sex' label="描述">
            <el-input v-model="formInline.email" placeholder="请输入邮箱后缀"></el-input>
        </el-form-item>
<!--如果没有选择性别则禁用表单-->
        <el-form-item v-else='formInline.sex' label="描述">
            <el-input v-model="formInline.email" disabled placeholder="请输入邮箱后缀"></el-input>
        </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="handleExportCommonData">导出</el-button>
      </el-form-item>
    </el-form>

  </div>
</template>


<script>
    import lodash from 'lodash'
    import Bus from '../eventBus'

    export default {
        name: 'db-filterinput',
        data() {
            return {
                //性别字典
                type_options: [{"label":"女","value":"女"},{"label":"男","value":"男"}],
                formInline: {
                    sex: '',
                    email: '',
                    page: 1,
                    size: 5
                },
                formLabelWidth: '120px',
            }
        },
        //监听属性，当formInline.sex改变时调用函数filterResultData
        watch: {
            'formInline.sex': 'filterResultData',
            'formInline.email': 'filterResultData'
        },

        methods: {
          /**
           * 定义 条件查询事filterResultData，事件的本质是一个函数。绑定就是对应关系。
            //根据【性别】和【电子邮箱】查询人员信息
            // _.debounce方法的作用是防抖动，这就是传说中的函抖术，当你的事件在不断触发的时候，会根据你设置的间隔时间只触发一次回调
            //如果我触发事件的时间间隔低于500毫秒,则不会调用function ()函数，这样限制了频率，就不会对身体不好啦。
           **/
            filterResultData: _.debounce(
                function () {
                  this.$axios({
                    url: 'http://127.0.0.1:8088/api/persons/query',
                    method: 'post',
                    contentType: 'application/json;charset=utf-8',
                    data: {"req_data": this.formInline}
                  }).then((data) => {
                    console.log("条件查询组件： ",data);
                    //对响应对象的数据赋值
                    data.data['sex'] = this.formInline.sex;
                    data.data['email'] = this.formInline.email;
                    /**
                     *当搜索条件（formInline.sex和formInline.email）改变的时候通过$emit触发事件filterResultData以发送查询请求
                     *触发间隔500毫秒
                     *组件间通信:当前子组件DbFilterinput通过$emit触发器
                     *触发事件filterResultData发送给父组件DbTable的监听器$on，以实现把表格数据data.data发送给父组件，
                     *父组件接受到数据后在父组件中渲染出表格
                     **/
                    Bus.$emit('filterResultData', data.data);
                    console.log("filterResultData:",data.data);
                  }).catch((e) => {
                    console.log(e);
                  })

                },
                500
            ),

          /**
           *导出
           *
           */

          handleExportCommonData() {
            /* if (exportUrl) {
                 this.handleMsg(null, '请填写附件导入地址，必须带上下文根！', 'error')
             }*/
            // let loading = this.$loading({fullscreen: true})
            this.$axios({
              url: 'http://127.0.0.1:8088/api/persons/exportExcel',
              method: 'post',
              contentType: 'application/json;charset=utf-8',
              responseType: 'blob',
              data: {"req_data": this.formInline}
            }).then(response => {
              debugger;
              // let fileName = window.decodeURI(response.headers['content-disposition'].split('=')[1])
               let fileName = '测试'
              let link = document.createElement('a')
              let url = window.URL.createObjectURL(new Blob([response.data], {type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8'}))
              link.target = '_blank'
              link.href = url
              link.download = fileName
              document.body.appendChild(link)
              link.click()
              document.body.removeChild(link)
              URL.revokeObjectURL(url)
              // loading.close()
            }).catch((e) => {
              console.log(e)
              // loading.close()
              // this.handleMsg('', e, 'error')
            })
          },
        },
      /**
       * 导出
       */
      // exportData() {
      //   this.handleExportCommonData('http://127.0.0.1:8088/api/persons/exportExcel', {"req_data": this.formInline});
      // },
    }


</script>
