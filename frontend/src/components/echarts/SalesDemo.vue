<template>
  <div class="test">
    <h1>{{ msg }}</h1>
    <!--    <h2><span style="color: red; ">echarts研究</span></h2>-->
    <hr style="height:10px;border:none;border-top:10px groove skyblue;"/>
    <!--    为echats准备dom盒子-->
    <div id="main" style="width: 600px;height:400px;"></div>

  </div>
</template>

<script>
  import Bus from "../../eventBus";
  var echarts = require('echarts');
  export default {
    name: 'SalesDemo',
    data() {
      return {
        msg: 'echarts4.2.0-rc.2绘图研究',
        option: {
          //标题
          title: {
            text: '第一个 ECharts 实例'
          },
          //提示
          tooltip: {
            trigger: 'axis', //触发类型；轴触发，axis则鼠标hover到一条柱状图显示全部数据，item则鼠标hover到折线点显示相应数据，
            axisPointer: {  //坐标轴指示器，坐标轴触发有效，
              type: 'line', //默认为line，line直线，cross十字准星，shadow阴影
              crossStyle: {
                color: '#fff'
              }
            }
          },
          //图例
          legend: {
            data: [{
              name: '销量',
              // 图标为圆角方形。
              icon: 'roundRect',
              // 设置文本为红色
              textStyle: {
                color: "rgba(35, 42, 163, 1)"
              }
            }]
            // data:['销量']
          },
          //网格布局
          grid: {
            show:true,
            left: "5%",
            top: "10%",
            right: "5%",
            bottom: "5%",
            backgroundColor: "rgba(133,131,224,1)",
            borderColor: "rgba(96, 67, 67, 1)",
          },
          xAxis: [
            {
            data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"],
            axisLine: {
              show: true,    // 是否显示坐标轴轴线
              symbol: ['none', 'arrow'],     // 轴线两端箭头，两个值，none表示没有箭头，arrow表示有箭头
              symbolSize: [10, 20],     // 轴线两端箭头大小，数值一表示宽度，数值二表示高度
              lineStyle: {
                color: '#333',    // 坐标轴线线的颜色
                width: '1',    // 坐标轴线线宽
                type: 'solid',     // 坐标轴线线的类型（'solid'，实线类型；'dashed'，虚线类型；'dotted',点状类型）
              },
            },
          },
            {
              data: ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"],
              axisLine: {
                show: true,    // 是否显示坐标轴轴线
                symbol: ['none', 'arrow'],     // 轴线两端箭头，两个值，none表示没有箭头，arrow表示有箭头
                symbolSize: [10, 20],     // 轴线两端箭头大小，数值一表示宽度，数值二表示高度
                lineStyle: {
                  color: '#333',    // 坐标轴线线的颜色
                  width: '1',    // 坐标轴线线宽
                  type: 'solid',     // 坐标轴线线的类型（'solid'，实线类型；'dashed'，虚线类型；'dotted',点状类型）
                },
              },
            },
          ],
          yAxis: {},
          series: [{
            name: '销量',
            type: 'bar',
            barWidth:'40%',
            data: [5, 20, 36, 10, 10, 20]
          }]
        },
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
        var myChart = echarts.init(document.getElementById('main'));
        myChart.setOption(this.option);
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
