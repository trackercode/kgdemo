<template>
  <div class="test">
    <h1>{{ msg }}</h1>
    <h2><span style="color: red; ">Vue临时测试用例</span></h2>
    <el-button @click="open" type="text">点击打开 Message Box</el-button>
    <hr style="height:10px;border:none;border-top:10px groove skyblue;"/>
    <table border="1">
      <tr>
        <td>示例名:</td>
        <td>数据model</td>
        <td>v-for结果</td>
      </tr>
      <tr>
        <td>v-for取值测试1:</td>
        <td>
          <p align="left">
          list: {       <br/>
          '1': 'name',  <br/>
          '2': 'sex',   <br/>
          '5': 'age'    <br/>
          }
          </p>
        </td>
        <td>
          <div class="div-left" v-for="(val, key, index) in list">
            <p align="left">
            <span>值：{{ val }}</span><br/>
            <span>键：{{ key }}</span><br/>
            <span>索引：{{ index }}</span>
            </p>
          </div>
        </td>
      </tr>
      <tr>
        <td>v-for取值测试2:</td>
        <td>
          <p align="left">
            "sampleidlist": [                 <br/>
            {                                 <br/>
            "SAMPLE_ID": "21705410CC4"         <br/>
            },                                <br/>
            {                                 <br/>
            "SAMPLE_ID": "21704120RH1"         <br/>
            },                                <br/>
            {                                 <br/>
            "SAMPLE_ID": "21704430LF2"         <br/>
            },                                <br/>
            {                                 <br/>
            "SAMPLE_ID": "21704420LF2"         <br/>
            },                                <br/>
            {                                 <br/>
            "SAMPLE_ID": "21703370BOF3"        <br/>
            },                                <br/>
            {                                 <br/>
            "SAMPLE_ID": "21703320BOF3"        <br/>
            }                                 <br/>
            ],                                <br/>
          </p>
        </td>
        <td>
          <div class="div-left2" style="float: left" v-for="(val, key, index) in sampleidlist">
            <p align="left">
            <span>值：{{ val.SAMPLE_ID }}</span><br/>
            <span>键：{{ key }}</span><br/>
            <span>索引：{{ index }}</span>
            </p>
          </div>
        </td>
      </tr>
    </table>

    <template>
      <el-select v-model="value" placeholder="请选择">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
          :disabled="item.disabled">
        </el-option>
      </el-select>
    </template>

    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>

  </div>
</template>

<script>
  import Bus from "../eventBus";

  export default {
    name: 'TestDemo',
    data() {
      return {
        sampleidlist1: [],
        msg: '八钢画面VUE测试',
        list: {
          '1': 'name',
          '2': 'sex',
          '5': 'age'
        },
        "sampleidlist": [
          {
            "SAMPLE_ID": "21705410CC4"
          },
          {
            "SAMPLE_ID": "21704120RH1"
          },
          {
            "SAMPLE_ID": "21704430LF2"
          },
          {
            "SAMPLE_ID": "21704420LF2"
          },
          {
            "SAMPLE_ID": "21703370BOF3"
          },
          {
            "SAMPLE_ID": "21703320BOF3"
          }
        ],
        options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        value: ''
      }
    },
    mounted () {
      // console.log("子组件dialogFormVisible: ")

      this.assembleObj()
    },

    //$msg  elmentui的Message,
    //$mb  elmentui的MessageBox,
    methods: {
      //页面可以直接调用
      open() {
        this.$mb.alert('这是一段内容', '标题名称', {
          confirmButtonText: '确定',
          callback: action => {
            this.$msg.message({
              type: 'info',
              message: `action: ${action}`
            });
          }
        });
      },
      assembleObj: function (){
        // 组合下拉框数据
        this.sampleidlist1=[{id:0,name:"请选择"}];
        var i=1;
        for(let item of this.sampleidlist){
          this.sampleidlist1.push({
            id:i,
            name:item.SAMPLE_ID
          })
          i++;
        };
        console.log("组装后的sampleidlist1： ",this.sampleidlist1)
      },

    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }

  .div-left {
    float: left
  }

  /*.div-left{width:300px;height:120px;border:1px solid #000;float:left}*/
</style>
