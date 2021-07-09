<template>
    <!-- 开源镜像软件站 - mirror页 -->
    <el-container>
    <el-header style="height:90px"> <!-- 头部 -->
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
    </el-header>
    <el-container>
        <el-main>
            <!-- <div class="mirros-list"> -->
                <!-- <div class="list-head"> -->
                    <a-input-search class="search" placeholder="input search text" style="width: 200px" @search="onSearch" />
                            <br /><br />
                        

                <!-- </div> -->
                <!-- <div class="files_list"></div> -->
            <!-- </div> -->
        </el-main>
        <el-aside width="530px">
            <div class="news">
                right
            </div>
        </el-aside>
    </el-container>
    <el-footer>footer</el-footer>
    </el-container>
</template>
<style scoped>
    @import "../assets/css/index.css";
</style>
<script>
export default {
  methods: {
    onSearch(value) {
      console.log(value);
    },
  },
};
</script>
