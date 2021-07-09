<template>
    <!-- 模仿清华软件源，https://mirrors.tuna.tsinghua.edu.cn/ -->
    <div class="container">
        <div class="nav">
            <!-- 顶部导航 -->
        </div>
        <div class="context">
            <!-- 中间所有内容 -->
            <div class="list">
                <!-- 列表内部 -->
                <div class="list-title">
                    <h3 class="list-font">
                        <img src="../assets/img/ios.png" height="26" width="24" />
                        镜像列表
                    </h3>
                    <input class="list-input" placeholder="   搜索" @search="onSearch"/>
                </div>
            </div>
            <div class="news">
                <!-- 新闻标题内部 -->
            </div>
        </div>
    </div>
</template>

<style scoped>
    @import "../assets/css/index3.css";
</style>

<script>
export default {
    methods: {
        //搜索框传入值
        onSearch(value) {
            console.log(value);
        },
    },
};
</script>