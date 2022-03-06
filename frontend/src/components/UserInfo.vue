<!--vue主页面,包装页-->
<template>
    <div class="wrapper">
        <db-header></db-header>
         <!--行布局器-->
        <el-row class="container">
           <!--列布局器-->
            <el-col :span="4" class="menu">
                <!--调用左侧仪表板组件-->
                <db-sidebar></db-sidebar>
                <db-sidebar></db-sidebar>
                <db-sidebar></db-sidebar>
                <db-sidebar></db-sidebar>
                <db-sidebar></db-sidebar>
                <db-sidebar></db-sidebar>
                <db-sidebar></db-sidebar>
                <db-sidebar></db-sidebar>
            </el-col>
            <el-col :span="20" class="content">
                <!--调用查询条件组件-->
                <db-filterinput></db-filterinput>

                <!--调用表组件：内容区-->
                <db-table></db-table>
            </el-col>
        </el-row>

        <el-row>
            <el-col :span="24">
                <footer class="footer">
                    <!--调用页脚组件-->
                    <db-footer></db-footer>
                </footer>
            </el-col>
        </el-row>
    </div>
</template>

<script>
//引用所需组件
    import DbHeader  from './DbHeader.vue'
    import DbSidebar from './DbSidebar.vue'
    import DbFilterinput from './DbFilterinput.vue'
    import DbTable from './DbTable.vue'
    import DbFooter from './DbFooter.vue'
    import ElRow from "element-ui/packages/row/src/row";

    //导出组件
    export default {
        name: 'UserInfo',
        components: {
            ElRow, DbHeader,
            DbSidebar,
            DbFilterinput,
            DbTable,
            DbFooter
        },
    }

</script>

<style>

    element.style {
        background-color: rgb(10, 47, 88);
    }

    body {
        font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
        margin: 0;
        display: flex;
        min-height: 100vh;
        flex-direction: column;
    }

    .el-menu, body, html {
        height: auto;
    }

    .wrapper {

        position: relative;
    }

    footer, div {
        display: block;
    }

    .container {
        padding-top: 70px;
        flex: 1;
    }

    .container, .wrapper {
        height: 100%;
    }

    .menu {
        height: auto;
        background-color: #eef1f6;
    }

    .content {
        padding-top: 25px;
        padding-right: 25px;
        padding-bottom: 125px;
        padding-left: 25px;
    }

    .footer {
        height: 120px;
        background-color: #324057;
        color: #a4aebd;
        width: 100%;
        z-index: 1000;
        margin-top: -120px;
        line-height: 1;
        font-size: 22px;
    }

</style>
