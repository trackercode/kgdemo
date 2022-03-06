<!--表组件-->
<template>
    <div>
        <el-table
                :data="tableData.data"
                border
                style="width: 100%"
                class="table">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    width="80">
            </el-table-column>
            <el-table-column
                    prop="username"
                    label="用户名称"
                    width="140">
            </el-table-column>
            <el-table-column
                    prop="email"
                    label="电子邮件"
                    width="170">
            </el-table-column>
            <el-table-column
                    prop="phone"
                    label="电话"
                    width="160">
            </el-table-column>
            <el-table-column
                    prop="sex"
                    label="性别"
                    width="70">
            </el-table-column>
            <el-table-column
                    prop="zone"
                    label="地址"
                    width="200">
            </el-table-column>
            <el-table-column
                    prop="createDatetime "
                    label="创建时间"
                    width="120"
                    :formatter="formatter">
            </el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="100">
                <template slot-scope="scope">
                    <el-button @click="editItem(scope.$index, tableData.data)"
                               type="text"
                               size="large">编辑
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

      <el-pagination class="pagination"
                     @size-change="(val)=>handleSizeChange(val,tableData,getCustomers)"
                     @current-change="(val)=>handleCurrentChange(val,tableData,getCustomers)"
                     :page-sizes="tableData.pageSizes"
                     :current-page="tableData.queryForm.page"
                     :page-size="tableData.queryForm.size"
                     :total="tableData.total"
                     layout="prev,pager,next,sizes,total">
      </el-pagination>
        <!-- -号分割转化为驼峰式，既 DbModal.vue -->
        <db-modal :dialogFormVisible="dialogFormVisible"
                  :form="form"
                  v-on:canclemodal="dialogVisible">
        </db-modal>
    </div>

</template>

<script>
    import Bus from '../eventBus'
    import DbModal from './DbModal.vue'

    export default {
        //组件数据属性
        data(){
            return {
              tableData: {
                //表数据
                data: [],
                /* 页面默认-表格默认查询块 */
                queryForm: {
                  sex: '',
                  email: '',
                  page: 1,
                  size: 5
                },
                /* 页面默认-表格查询默认页码 */
                currentPage: 1,
                /* 页面默认-表格查询总条数 */
                total: 0,
                /* 页面默认-表格查询默认分页类型 */
                pageSizes: [5, 10, 15, 20, 25, 30, 35, 40],
                /* 页面默认-表格查询默认每页条数 */
                pageSize: 5
              },
                dialogFormVisible: false,
                //详情编辑表单
                form: {},
            }
        },
        //编辑区组件
        components: {
            DbModal
        },
        //挂载dom节点的时候
        mounted () {
            //获取用户数据
            this.getCustomers();
            /**
            *条件查询事filterResultData件在子组件DbFilterinput中被$emit触发后，在此父组件中被$on监听到
             * ，条件查询事件的结果赋值给vue的数据属性，以渲染表格
            *  $on： 监听 event 事件后运行 fn回掉方法，事件的本质是函数调用
             **/
            Bus.$on('filterResultData', (data) => {
              console.log("查询条件: ",data)
                //事件触发时回填的表数据
                this.tableData.data = data.data;
                this.tableData.total = data.count;
                this.tableData.queryForm.sex=data.sex;

            });
        },

        methods: {
          /**
           * 分页每页大小变更
           * @param val 当前每页大小
           * @param tableData 表格对象，默认为this.tableData
           * @param callback 表格查询回调函数
           */
          handleSizeChange(val, tableData = this.tableData, callback) {
            tableData.pageSize = val
            tableData.queryForm.size = tableData.pageSize
            callback && callback.call()
          },
          /**
           * 分页页码变更
           * @param val 当前页码
           * @param tableData 表格对象，默认为this.tableData
           * @param callback 表格查询回调函数
           */
          handleCurrentChange(val, tableData = this.tableData, callback) {
            tableData.currentPage = val
            tableData.queryForm.page = tableData.currentPage
            callback && callback.call()
          },

            //设置对话框默认不可见
            dialogVisible: function () {
                this.dialogFormVisible = false;
            },

          //获取用户信息
          getCustomers: function () {
            this.$axios({
              url: 'http://127.0.0.1:8088/api/persons/query',
              method: 'post',
              contentType: 'application/json;charset=utf-8',
              data: {'req_data': this.tableData.queryForm}
            }).then(({data}) => {
              // console.log(data)
              //{data}是响应数据，包括响应头和响应体
              // 从http响应中获取表数据
              this.tableData.data = [...data.data];
              // 从http响应中获取条数
              this.tableData.total = data['count']

            }).catch((data) => {
              console.log(data)
            })
          },

            //编辑：点击编辑时设置对话框为见。通过点击事件获取入参
            //参见页面：<el-button @click="editItem(scope.$index, tableData.data)"
            editItem: function (index, rows) {
            console.log("index： ",index);
            console.log("rows： ",rows);
                this.dialogFormVisible = true;
                const itemId = rows[index].id;
                const idurl = 'http://127.0.0.1:8088/api/persons/detail/' + itemId;
                this.$axios.get(idurl).then((response) => {
                    // this.form = JSON.parse(response.data);
                  this.form = response.data;
                  console.log("点击编辑时thisForm",this.form)
                }).catch(function (response) {
                    console.log(response)
                });
                console.log("父组件中的值>>> ",this.dialogFormVisible,this.form)
            },
            //日期格式化
            formatter(row, column) {
                let data = this.$moment(row.createDatetime , this.$moment.ISO_8601);
                return data.format('YYYY-MM-DD')
            },

        }
    }
</script>

<style>
/*类选择器，表样式*/
    .table {
        margin-top: 30px;
    }
    /**类选择器，分页样式*/
    .pagination {
        margin-top: 10px;
        float: right;
    }

</style>
