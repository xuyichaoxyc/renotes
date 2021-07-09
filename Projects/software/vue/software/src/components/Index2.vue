<template>
  <div class="container">
      <div class="navbar">
          <a-row style="padding:13px">
            <a-col :span="1"></a-col>
            <a-col :span="4"> <!-- LOGO展示 -->
                LOGO展示
            </a-col>
            <a-col :span="8"></a-col>
            <a-col :span="10"> <!-- 导航菜单 -->
                导航菜单(HOME BLOG FEED MIRRORS)
            </a-col>
            <a-col :span="1"></a-col>
        </a-row>
      </div>
      <!-- <div class="hidden-line1">  </div> -->
      <br/>
      <div class="mirrors">
          <div class="list">
             <div class="list-title">
                 <h3>
                     镜像列表
                 </h3>
                 <a-input-search placeholder="input search text" style="width: 200px; float:right;margin-right:15px" @search="onSearch" />
             </div>
             <table class="files-table">
                <tr>
                    <th v-for='(item,ind) in columnList' :key="ind">{{item}}</th> 
                <tr v-for='(item,index) in inforList' :key="index">
                    <td v-for='(it,ind) in columnList' :key="ind">{{item[it]}}</td>
                </tr>
            </table>
          </div>
          <div class="news"></div>
      </div>
      <div class="footer">底部</div>
  </div>
</template>
<style scoped>
    @import "../assets/css/index2.css";
</style>
<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>
