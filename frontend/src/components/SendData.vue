<template>
  <div class="send">
    <h1>{{ msg }}</h1>
    <h2><span style="color: red; ">关键接口调用测试</span></h2>
    <el-row>
      <el-button type="primary" @click="sendData">发送请求</el-button>
    </el-row>
  </div>
</template>

<script>
  export default {
    name: 'SendData',
    data() {
      return {
        msg: 'axios网络库测试用例',
        quryStr: this.$qs.stringify({
          'grant_type': 'password',
          'unionId': 'otwEQxLcrEVcJTpXC4mvBeztDow4',
          'openId': 'oMCsg5Su_5thmzW_0LOSF7qZtg6k',
          'username': '',
          'loginType': '4',
          'smsId': '',
          'smsCode': ''
        }),
      }
    },
    computed: {

    },

    methods: {
      //w3c不让伪造请求头
      sendData(){

        let config = {
          method: 'post',
          url: 'https://cm.jt169.com/api/ac88ceb386aa4231b09bf472cb937c24/app/oauth/token',
          headers: {
            'Host': 'cm.jt169.com',
            'Connection': 'keep-alive',
            'Authorization': 'Basic YXBwOmFwcA==',
            'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.143 Safari/537.36 MicroMessenger/7.0.9.501 NetType/WIFI MiniProgramEnv/Windows WindowsWechat',
            'content-type': 'application/x-www-form-urlencoded',
            'x-tenant-flag': '1',
            'Referer': 'https://servicewechat.com/wx878b0b74ecfe5cd5/135/page-frame.html',
            'Accept-Encoding': 'gzip, deflate, br',
            'Cookie': 'acw_tc=2f6a1fec16508652999517799ed1750f824ea7b5dd0786667e84bf21d8aa27'
          },
          data : this.quryStr
        };

        this.$axios(config)
          .then(function (response) {
            console.log("ccccccccc",JSON.stringify(response.data));
          })
          .catch(function (error) {
            console.log(error);
          });


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
</style>
