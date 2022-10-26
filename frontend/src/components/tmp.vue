<script>
  created(){
    this.initWebSocket();
  },
  destroyed(){
    this.websock.close();//离开路由之后断开websocket连接
  },
  methods: {
    initWebSocket(){//初始化weosocket(必须)
      const wsuri = "后台给你的请求地址"; //请根据实际项目需要进行修改
      this.websock = new WebSocket(wsuri); //新建一个webstock对象
      this.websock.onmessage = this.websocketonmessage;
      this.websock.onopen = this.websocketonopen;
      this.websock.onerror = this.websocketonerror;
      this.websock.onclose = this.websocketclose;
    },

    websocketonopen(){//websocket连接后发送数据(send发送)
      let actions = {你要发送给后台的参数}; //请根据实际项目需要进行修改
      this.websocketsend(JSON.stringify(actions));
    },
    websocketonerror(){//连接建立失败重连
      this.initWebSocket();
    },
    websocketonmessage(e){ //数据接收
      this.redata = JSON.parse(e.data).data;
      console.log(this.redata);
    },

    websocketsend(Data){//数据发送
      this.websock.send(Data);
    },

    websocketclose(e){ //关闭
      console.log('断开连接', e);
    },
  },
</script>
