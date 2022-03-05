<!--左侧仪表板-->
<template>
    <li class="el-menu-item is-active" style="">{{msg}}</li>
</template>

<script>

    export default {
        name: 'db-sidebar',
        data() {
            return {
                msg: '菜单组件'
            }
        }
    }

</script>

<style>
    li {
        padding-left: 20px;
    }
</style>
