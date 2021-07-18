<template>
    <div class="container">
        <!--{{}} 输出对象属性和函数返回值-->
        <h1>{{ msg }}</h1>
        <!-- <h1>site : {{site}}</h1>
        <h1>url : {{url}}</h1>
        <h3>{{details()}}</h3>
        <h1 v-for="data in ydata" :key="data">{{data}}</h1>
        <h3 v-for="item in xdata" :key="item">{{item}}</h3> -->
    </div>
</template>

<script>
export default {
  name: 'apidata',
  // data用来定义返回数据的属性
  data () {
    return {
      msg: 'hello,xxbandy！',
      site: "bgops",
      url: "https://xxbandy.github.io",
      xdata: null,
      ydata: null,
    }
  },
  methods: {
    details: function() {
      return this.site
    },
  },
  mounted () {
      // response返回一个json{"data": "数据","status": "状态码","statusText":"状态文本","headers":{ "content-type": "application/json; charset=utf-8" },"config":"配置文件","method":"方法","url":"请求url","request":"请求体"}
      axios.get('http://localhost:8000/v1/line').then(response => (this.xdata = response.data.legend_data,this.ydata = response.data.xAxis_data))

  }
}
</script>