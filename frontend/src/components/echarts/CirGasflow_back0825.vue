<template>
  <div class="test">
    <h1>{{ msg }}</h1>
    <!--    <h2><span style="color: red; ">echarts研究</span></h2>-->
    <hr style="height:10px;border:none;border-top:10px groove skyblue;"/>
    <!--   vue的ref，相当于dom中 的id -->
    <div ref="main" class="echarts-box" style="width: 850px; height: 532px; border: 1px solid red"></div>

  </div>
</template>

<script>
  import Bus from "../../eventBus";
  //局部引用echarts，（此系统已经全局引用，这里就不局部引用了）
  // var echarts = require('echarts');
  export default {
    name: 'CirGasflow',
    data() {
      return {
        msg: 'echarts4.2.0-rc.2绘图研究: 温度-环流气模型',
        tmpArry: [[]],
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

        //---
        //循环气体统计时间
        var category = [-1.00,0.50,1.00,1.50,2.00,2.50,3.00,3.50,4.00,4.50,5.00,5.50,6.00,6.50,7.00,7.50,8.00,8.50,9.00,9.50,10.00,10.50,11.00,11.50,12.00,12.50,13.00,13.50,14.00,14.50,15.00,15.50,16.00];
        //预测温度
        var lineData = [1596,1590,1587,1585,1584,1583,1582,1581,1580,1579,1579,1578,1577,1576,1575];

        //循环气体流量
        var barData = [80.463,80.501,79.758,80.133,79.866,80.012,79.962,79.772,80.056,79.689,79.430,79.656,80.079,79.857,79.614,79.679,80.079,79.435,80.098,80.358,80.246,79.875,79.776,79.939,80.541,80.413,79.807,70.331,69.240,70.621,70.094,69.904,70.027];
        //实测温度x
        // var barData1 = ['20.60', '50.00', '50.00', '6.00', '7.50', '8.50', '9.00', '12.50', '14.00', '21.50',
        //   '23.20', '24.50','66.66','33.21','44.13','14.88','55.57'];
        //实际温度坐标
        var temp = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17];
        for(var i=0;i<lineData.length;i++){
          this.tmpArry[i]=[];
          for(var j=0;j<2;j++){
            if(j==0){
              this.tmpArry[i][j]= i*2;
            }else{
              this.tmpArry[i][j]=lineData[i];
            }
          }
        }
        console.log("this.tmpArry",this.tmpArry)




        // option
        var option = {
          title: {
            text: '温度-环流气模型',
            left: 'center',
            top: '20px',
            textStyle: {
              color: '#4b4b4b',
              fontSize: 16,
              fontWeight: '700'
            }
          },
          tooltip: {
            trigger: 'axis',
            axisPointer: {
              label: {
                show: true,
                backgroundColor: '#7B7DDC'
              }
            },
            formatter: (parms) => {

              var str ='';
              // console.log(parms);
              for (i=0;i<parms.length;i++){
                 if(parms[i].seriesName !== '预测温度'){
                  str += parms[i].axisValue+"</br>"
                  }
                 if (parms[i].seriesName === '循环气体流量') {
                    str += `${parms[i].marker}${parms[i].seriesName}: ${parms[i].value}L/min</br>`
                  } else if(parms[i].seriesName === '实测温度'){
                    str += `${parms[i].marker}${parms[i].seriesName}: ${parms[i].value}℃</br>`
                  }else if(parms[i].seriesName === '预测温度'){
                   str += `${parms[i].marker}${parms[i].seriesName}: ${parms[i].value[1]}℃</br>`
                 }

                console.log("parms["+i+"]: "+JSON.stringify(parms[i]))
              }
              console.log("str--> "+str);
              return str;
            }
          },
          legend: {
            data: [ '循环气体流量', '实测温度', '预测温度' ],
            top: '60px',
            right: '20px',
            // type: '',
            itemWidth: 20,
            itemHeight: 10,
            icon: 'rect'
          },
          grid: {
            top: '140px',
            width: '80%',
            left: '100px',
            right: '100px'
          },
          dataZoom: [
            {
              start:0,
              end:100,
            },
            {
              type: 'inside'
            }],
          xAxis: {
            name: '时间',
            nameLocation:'middle',
            nameGap:-15,
            // offset: "1",
            // position: "top",
            nameTextStyle: {
              color: '#828282',
            },
            data: category,
            axisLine: {
              symbol: ['none', 'arrow'],     // 轴线两端箭头，两个值，none表示没有箭头，arrow表示有箭头
              symbolSize: [10, 20],     // 轴线两端箭头大小，数值一表示宽度，数值二表示高度
              lineStyle: {
                color: '#828282'
              }
            },
            axisTick: {
              show: true,
              lineStyle: {
                color: '#828282'
              }
            },
            splitLine: { show: false },
            axisLabel: {
              color: '#828282'
            },
            boundaryGap: false
          },
          yAxis: [
            {
            name: ' 循环气体流量（L/min）',
            nameTextStyle: {
              color: '#828282'
            },
              max:100,
              min:60,
            splitLine: { show: false },
            axisLine: {
              symbol: ['none', 'arrow'],     // 轴线两端箭头，两个值，none表示没有箭头，arrow表示有箭头
              symbolSize: [10, 20],     // 轴线两端箭头大小，数值一表示宽度，数值二表示高度
              lineStyle: {
                color: '#828282'
              }
            },
            axisTick: {
              show: true,
              lineStyle: {
                color: '#828282'
              }
            },
            axisLabel: {
              formatter: '{value} ',
              color: '#828282'
            }
          },
            {
              name: '溫度（℃）',
              nameTextStyle: {
                color: '#828282'
              },
              max:2000,
              min:1000,
              splitLine: { show: false },
              axisLine: {
                symbol: ['none', 'arrow'],     // 轴线两端箭头，两个值，none表示没有箭头，arrow表示有箭头
                symbolSize: [10, 20],     // 轴线两端箭头大小，数值一表示宽度，数值二表示高度
                lineStyle: {
                  color: '#828282'
                }
              },
              axisTick: {
                show: true,
                lineStyle: {
                  color: '#828282'
                }
              },
              axisLabel: {
                formatter: '{value} ',
                color: '#828282'
              }
            }],
          series: [
            {
              name: '循环气体流量',
              type: 'line',
              smooth: true, // 平滑曲线
              showAllSymbol: true,
              // symbol: 'emptyCircle',
              // symbol: 'circle',
              symbolSize: 5,
              showSymbol: true,
               yAxisIndex: 0,
              // xAxisIndex: 0,
              itemStyle: {
                normal: {
                  color: '#8583e0',
                  lineStyle: {
                    color: '#8583e0',
                    width: 1
                  },
                }
              },
              data: barData
            },
            {
              name: '实测温度',
              yAxisIndex: 1,
              // xAxisIndex: 1,
              type: 'line',
              smooth: true, // 平滑曲线
              data:[],
              markPoint:{
                // name:'实测温度',
                data: [{"value": "1583","xAxis": 11*2,"yAxis": "1583"},{"value": "1577","xAxis": 14*2,"yAxis": "1577"}]
              },
            },
            {
              name: '预测温度',
              type: 'line',
              smooth: true, // 平滑曲线
              showAllSymbol: true,
              // symbol: 'emptyCircle',
              // symbol: 'circle',
              symbolSize: 5,
              showSymbol: true,
              yAxisIndex: 1,
              // xAxisIndex: 1,
              itemStyle: {
                normal: {
                  color: '#ff90a8',
                  lineStyle: {
                    color: '#ff90a8',
                    width: 1
                  },
                }
              },
              data: this.tmpArry
            }
          ]
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
