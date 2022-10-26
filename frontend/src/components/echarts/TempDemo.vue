<template>
  <div class="test">
    <h1>{{ msg }}</h1>
    <!--    <h2><span style="color: red; ">echarts研究</span></h2>-->
    <hr style="height:10px;border:none;border-top:10px groove skyblue;"/>
<!--   vue的ref，相当于dom中 的id -->
    <div ref="main" class="echarts-box" style="width: 600px; height: 400px; border: 1px solid red"></div>

  </div>
</template>

<script>
  import Bus from "../../eventBus";
  //局部引用echarts，（此系统已经全局引用，这里就不局部引用了）
  // var echarts = require('echarts');
  export default {
    name: 'TemDemo',
    data() {
      return {
        msg: 'echarts4.2.0-rc.2绘图研究',

      }
    },
    mounted () {
      this.drawSales();
      // console.log("子组件dialogFormVisible: ")

    },

    //$msg  elmentui的Message,
    //$mb  elmentui的MessageBox,
    methods: {
      //页面可以直接调用
      drawSales: function (){
        var option={
          title: {
            text: 'ECharts 入门示例  自定义颜色'
          },
          label: {
            normal: {
              show:true,
                textStyle: {
                color: '#FFFFFF',
                  fontSize: 40
              }
            },
          },
          itemStyle: {
            normal: {
              color: function(params) {
                // build a color map as your need.
                var colorList = [
                  '#C1232B', '#B5C334', '#FCCE10', '#E87C25', '#27727B',
                  '#FE8463', '#9BCA63', '#FAD860', '#F3A43B', '#60C0DD',
                  '#D7504B', '#C6E579', '#F4E001', '#F0805A', '#26C0C0'
                ];
                return colorList[params.dataIndex]
              }
            }
          },
          tooltip: {},
          legend: {
            data:['销量']
          },
          xAxis: {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
          },
          yAxis: {},
          series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
          }]
        };
        //document.getElementById('main') 等价于 this.$refs.main
        var myChart = this.$echarts.init(this.$refs.main);
        myChart.setOption(option);
      }
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
