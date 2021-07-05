<template>
    <!-- 开源镜像软件站 - 首页 -->
    <div class="components-layout-demo-basic">
    <a-layout>
        <a-layout-header class="external-header" style="background:white"><!-- 布局头部 -->
            <a-row type="flex">
                <a-col style="background:white" :flex="1"><!-- logo部分 -->
                    logo部分
                </a-col>
                <a-col style="background:white" :flex="2"></a-col>
                <a-col style="background:white" :flex="2"><!-- 菜单部分 -->
                    菜单栏
                </a-col>
            </a-row>
        </a-layout-header>
        <a-layout-content class="external-content" style="height:200px"><!--布局中部 -->
            <div class="inside-content-box" style="height:100%"><!-- 内容布局容器 -->
                <div class="list-box"><!-- 文件镜像列表 --> 

                </div>
                <div class="news-box"><!-- 简介栏 -->

                </div>
            </div>
        </a-layout-content>
        <a-layout-footer class="external-footer"><!-- 布局底部 -->
            
        </a-layout-footer>
    </a-layout>
    </div>
</template>
<style scoped>
    @import "../assets/css/index.css";
</style>
