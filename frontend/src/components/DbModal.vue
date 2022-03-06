<!--编辑区域-->
<template>
    <el-dialog title="编辑" :visible="dialogFormVisible" :close-on-click-modal="false" :show-close="false">
        <el-form :model="form">
            <el-form-item label="用户编号" :label-width="formLabelWidth">
                <el-input :disabled="true" v-model="form.id" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="用户名称" :label-width="formLabelWidth">
                <el-input :disabled="true" v-model="form.username" auto-complete="off"></el-input>
            </el-form-item>

            <el-form-item label="电子邮件" :label-width="formLabelWidth">
                <el-input :disabled="true" v-model="form.email" auto-complete="off"></el-input>
            </el-form-item>

            <el-form-item label="电话" :label-width="formLabelWidth">
                <el-input v-model="form.phone" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="性别" :label-width="formLabelWidth">
                <el-input :disabled="true" v-model="form.sex" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="地址" :label-width="formLabelWidth">
                <el-input v-model="form.zone" auto-complete="off"></el-input>
            </el-form-item>

        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button :plain="true" type="danger" v-on:click="canclemodal">取消</el-button>
            <el-button :plain="true" @click="updateForm(form)">保存</el-button>
        </div>
    </el-dialog>
</template>


<script>
    export default {
        data(){
            return {
                formLabelWidth: '120px',
            }
        },
        //父组DbTable件传递过来的两个参数：对话框的可见性，表单
        props: ['dialogFormVisible', 'form'],
       mounted() {
         // this.dialogFormVisible=true,
         //   this.form={
         //     "createDatetime": "2017-06-29 05:37:14",
         //     "phone": "8613000001113",
         //     "zone": "中国佛山",
         //     "sex": "女",
         //     "id": 3,
         //     "email": "yoyo.wu@gmail.com",
         //     "username": "杨惠妍"
         //   },
          console.log("子组件dialogFormVisible: ",this.dialogFormVisible, " 子组件form: ",this.form)
       },
      methods: {
            //更新表单
            updateForm: function (formName) {
                let itemId = formName.id;
                let phone = formName.phone;
                let zone = formName.zone;
                this.$axios.put('http://127.0.0.1:8088/api/persons/detail/' + itemId, {
                    phone: phone,
                    zone: zone
                }).then(function (response) {
                        console.log(response);
                        this.form = response.data;
                    }).catch(function (error) {
                        console.log(error);
                    });
                location.reload();
            },
            //调用父组件的的"取消事件"，通过自定义事件通信
            canclemodal: function () {
                this.$emit('canclemodal');
            }
        }

    }

</script>
