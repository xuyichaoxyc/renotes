<template>
    <!-- 模仿清华软件源，https://mirrors.tuna.tsinghua.edu.cn/ -->
    <div class="container">
        <div class="header">
            <!-- 导航菜单(HOME BLOG FEED MIRRORS) -->
            <div class="nav-logo">
                <a class="a-nav-logo" href="#">
                    <span class="span-nav-logo">
                        <img class="img-nav-logo" src="../assets/img/logo.png"/>
                    </span>
                    开源镜像软件站
                </a>
            </div>
            <div class="nav-names">
                <ul id="nav">
                    <li><a href="#">HOME</a></li>
                    <li><a href="#">BLOG</a></li>
                    <li><a href="#">FEED</a></li>
                    <li><a href="#">MIRRORS</a></li>
                </ul>
            </div>
        </div>
        <div class="context">
            <!-- 中间所有内容 -->
            <div class="list">
                <!-- 列表头部 -->
                <div class="list-title">
                    <h3 class="h3-list-title">
                        <img src="../assets/img/ios.png" height="26" width="24" />
                        镜像列表
                    </h3>
                    <input class="list-input" placeholder="   搜索" @search="onSearch"/>
                </div>
                <div class="list-name">
                    <h5 class="h5-first-col-name">
                        Name
                    </h5>
                    <h5 class="h5-second-col-name">
                        Last Update
                    </h5>
                </div>
                <div class="mirrors">
                    <table class="table-mirrors"
                    v-for="(item, index) in mirrorsFiles"
                        :key="index"
                        @click="getFile(item.url)"
                        >
                        <tr class="tr-row">
                            <td class="td-1"><a>{{item.name}}</a></td>
                            <td class="td-2">{{item.updateTime}}</td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="news">
                <!-- 新闻标题内部 -->
                <!-- 新闻内容 -->
                <div class="news-url">
                    <div class="news-url-title">
                        <h4>
                            <span>
                                <img src="../assets/img/ios.png" height="26" width="24" />
                            </span>
                            新闻
                        </h4>
                    </div>
                    <ul>
                        <li><a>11</a></li>
                        <li><a>11</a></li>
                        <li><a>11</a></li>
                    </ul>
                </div>
                <!-- 域名选择 -->
                <div class="yuming-choose">
                    <div class="yuming-url-title">
                        <h4>
                            <span>
                                <img src="../assets/img/ios.png" height="26" width="24" />
                            </span>
                            域名选择
                        </h4>
                    </div>
                    <ul>
                        <li><a>http1</a>11</li>
                        <li><a>http1</a>11</li>
                        <li><a>http1</a>11</li>
                    </ul>
                </div>
                <!-- 下载连接 -->
                <div class="download-url">
                    <div class="download-url-title">
                        <h4>
                            <span>
                                <img src="../assets/img/ios.png" height="26" width="24" />
                            </span>
                            下载连接
                        </h4>
                    </div>
                    <p> 
                        常用下载
                    </p>
                    <button>获取最新下载</button>
                </div>
                <!-- 联系我们 -->
                <div class="call-us">
                    <div class="call-us-url-title">
                        <h4>
                            <span>
                                <img src="../assets/img/ios.png" height="26" width="24" />
                            </span>
                            联系我们
                        </h4>
                    </div>
                    <ul>
                        <li>11<a>http1</a></li>
                        <li>22<a>http1</a></li>
                        <li>33<a>http1</a></li>
                    </ul>
                </div>
                <!-- 相关链接 -->
                <div class="about-url">
                     <div class="call-us-url-title">
                        <h4>
                            <span>
                                <img src="../assets/img/ios.png" height="26" width="24" />
                            </span>
                            相关链接
                        </h4>
                    </div>
                    <ul>
                        <li><a>some</a></li>
                        <li><a>some</a></li>
                        <li><a>some</a></li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="foot">
                
            </div>
    </div>
</template>

<style scoped>
    @import "../assets/css/index3.css";
</style>

<script>
export default {
    data() {
        return {
            //测试文件数据
            mirrorsFiles: [
            {url: "11", name: "python", updateTime: "2021-07-13 14:35:44"},
            {url: "22", name: "java", updateTime: "2021-07-13 14:35:44"},
            {url: "33", name: "golang", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "44", name: "anaconda", updateTime: "2021-07-13 14:35:44"},
            {url: "55", name: "css", updateTime: "2021-07-13 14:35:44"},
        ],
        // mirrorUpdateTime: [
        //     {id: "1", },
        //     {id: "2", updateTime: "2021-07-14 15:35:44"},
        //     {id: "3", updateTime: "2021-07-15 16:35:44"},
        //     {id: "4", updateTime: "2021-07-16 17:35:44"},
        //     {id: "5", updateTime: "2021-07-17 18:35:44"},
        // ]
        }
    },
    methods: {
        //搜索框传入值
        onSearch(value) {
            console.log(value);
        },
        //点击列表中的文件
        getFile(url) {
            console.log(url);
        }
    },
};
</script>