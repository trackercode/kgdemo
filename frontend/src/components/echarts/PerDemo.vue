<template>
  <div class="test">
    <h1>{{ msg }}</h1>
    <!--    <h2><span style="color: red; ">echarts研究</span></h2>-->
    <hr style="height:10px;border:none;border-top:10px groove skyblue;"/>
<!--   vue的ref，相当于dom中 的id -->
    <div ref="main" class="echarts-box" style="width: 790px; height: 532px; border: 1px solid red"></div>

  </div>
</template>

<script>
  import Bus from "../../eventBus";
  //局部引用echarts，（此系统已经全局引用，这里就不局部引用了）
  // var echarts = require('echarts');
  export default {
    name: '性能摘要',
    data() {
      return {
        msg: 'echarts4.2.0-rc.2绘图研究-性能摘要',

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

        var category = ['8:20', '8:30', '8:40', '8:50', '9:00', '9:10', '9:20', '9:30', '9:40', '9:50', '10:10', '10:20'];
        // var dottedBase = []
        var lineData = [192, 1228, 245, 248, 308, 707, 867, 641, 544, 515, 561, 677];
        var barData = ['4.60', '5.00', '55.00', '65.00', '75.00', '85.00', '9.90', '12.00', '14.00', '21.50', '8.50', '9.90'];
        var barData1 = ['20.60', '50.00', '50.00', '6.00', '7.50', '8.50', '9.00', '12.50', '14.00', '21.50', '23.20', '24.50'];

        // option
        var option = {
          title: {
            text: '性能摘要',
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
              let str = `${parms[0].axisValue}</br>`
              parms.forEach(e => {
                if (e.seriesName === '已消耗的主机内存') {
                  str += `${e.marker}${e.seriesName}: ${e.value}GB</br>`
                } else {
                  str += `${e.marker}${e.seriesName}: ${e.value}%</br>`
                }
              })
              return str
            }
          },
          legend: {
            data: [ '已消耗的主机CPU', '就绪', '已消耗的主机内存' ],
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
          xAxis: {
            data: category,
            axisLine: {
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
          yAxis: [{
            name: '已消耗的主机CPU就绪（%）',
            nameTextStyle: {
              color: '#828282'
            },
            splitLine: { show: false },
            axisLine: {
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
              name: '已消耗的主机内存（GB）',
              nameTextStyle: {
                color: '#828282'
              },
              splitLine: { show: false },
              axisLine: {
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
              name: '已消耗的主机CPU',
              type: 'line',
              smooth: true, // 平滑曲线
              showAllSymbol: true,
              // symbol: 'emptyCircle',
              // symbol: 'circle',
              symbolSize: 5,
              showSymbol: true,
              yAxisIndex: 0,
              itemStyle: {
                normal: {
                  color: '#fded33',
                  lineStyle: {
                    color: '#fded33',
                    width: 1
                  },
                  areaStyle: {
                    color: new this.$echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                      offset: 0,
                      color: 'rgba(253,237,51,0)'
                    }, {
                      offset: 0.8,
                      color: 'rgba(253,237,51,0.3)'
                    }, {
                      offset: 1,
                      color: 'rgba(253,237,51,0.6)'
                    }])
                  }
                }
              },
              data: barData
            },
            {
              name: '就绪',
              type: 'line',
              smooth: true, // 平滑曲线
              showAllSymbol: true,
              // symbol: 'emptyCircle',
              // symbol: 'circle',
              symbolSize: 5,
              showSymbol: true,
              yAxisIndex: 0,
              itemStyle: {
                normal: {
                  color: '#ffba7e',
                  lineStyle: {
                    color: '#ffba7e',
                    width: 1
                  },
                  areaStyle: {
                    // color: '#94C9EC'
                    color: new this.$echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                      offset: 0,
                      color: 'rgba(255,186,126,0)'
                    }, {
                      offset: 0.8,
                      color: 'rgba(255,186,126,0.3)'
                    }, {
                      offset: 1,
                      color: 'rgba(255,186,126,0.6)'
                    }])
                  }
                }
              },
              data: barData1
            },
            {
              name: '已消耗的主机内存',
              type: 'line',
              smooth: true, // 平滑曲线
              showAllSymbol: true,
              // symbol: 'emptyCircle',
              // symbol: 'circle',
              symbolSize: 5,
              showSymbol: true,
              yAxisIndex: 1,
              itemStyle: {
                normal: {
                  color: '#ff90a8',
                  lineStyle: {
                    color: '#ff90a8',
                    width: 1
                  },
                  areaStyle: {
                    // color: '#94C9EC'
                    color: new this.$echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                      offset: 0,
                      color: 'rgba(255,144,168,0)'
                    }, {
                      offset: 0.8,
                      color: 'rgba(255,144,168,0.3)'
                    }, {
                      offset: 1,
                      color: 'rgba(255,144,168,0.6)'
                    }])
                  }
                }
              },
              data: lineData
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
