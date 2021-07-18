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
                    <ul
                    v-for="(item,index) in news"
                    :key="index"
                    @click="getNews(item.url)"
                    >
                        <li class="li-news"><a class="a-news">{{item.news}}</a></li>
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
                    <ul
                    v-for="(item, index) in yuming"
                    :key="index"
                    @click="getYumingUrl(item.url)"
                    >
                        <li class="li-yuming"><a class="a-yuming">{{item.url}}</a>{{item.context}}</li>
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
                    <button class="get-download">获取最新下载</button>
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
                    <ul
                    v-for="(item, index) in callUs"
                    :key="index"
                    @click="getCallUs(item.url)"
                    >
                        <li class="li-call-us">item.context<a class="a-call-us"> {{item.url}}</a></li>
                    </ul>
                </div>
                <!-- 相关链接 -->
                <div class="about-url">
                     <div class="about-url-title">
                        <h4>
                            <span>
                                <img src="../assets/img/ios.png" height="26" width="24" />
                            </span>
                            相关链接
                        </h4>
                    </div>
                    <ul 
                    v-for="(item, index) in aboutUrl"
                    :key="index"
                    @click="getAboutUrl(item.url)"
                    >
                        <li class="li-about"><a class="a-about">{{item.context}}</a></li>
                    </ul>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        <div class="foot">
            <div class="explain">
                <p>
                    网站相关介绍内容
                </p>
                <p>
                    网站相关介绍内容
                </p>
                <p>
                    网站相关介绍内容
                </p>
                <p>
                    网站相关介绍内容
                </p>
            </div>
            <div class="information">
                <h3>
                    Contact Us
                </h3>
                <ul class="ul-information">
                    <li ><span>
                            <img ref="../assets/ios.png" width="15px" height="15px"/>
                        </span>Mailing List</li>
                    <li><span>
                            <img ref="../assets/ios.png" width="15px" height="15px"/>
                        </span>Blog</li>
                </ul>
            </div>
            <div class="footer-logo">
                <img ref="../assets/img/logo.png" width="150px" height="150px"/>
            </div>
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
            news: [
                {news:"某工厂的xxxxxxxx倒闭了",url:"http://xxxxxx"},
                {news:"某工厂的xxxxxxxx倒闭了",url:"http://xxxxxx"},
                {news:"某工厂的xxxxxxxx倒闭了",url:"http://xxxxxx"}
            ],
            yuming: [
                {url:"http://ssadad.com", context:"某网站"},
                {url:"http://ssadad.com", context:"某网站"},
                {url:"http://ssadad.com", context:"某网站"}
            ],
            callUs: [
                {url: "http://github.com/xxx", context:"问题反馈"},
                {url: "http://github.com/xxx", context:"问题反馈"}
            ],
            aboutUrl: [
                {url: "http://sssss.ww.com", context:"镜像网站1"},
                {url: "http://sssss.ww.com", context:"镜像网站1"},
                {url: "http://sssss.ww.com", context:"镜像网站1"}
            ]
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
        },
        //点击新闻内容
        getNews(url) {
            console.log(url);
        },
        //点击域名链接
        getYumingUrl(url) {
            console.log(url);
        },
        //点击联系我们的链接
        getCallUs(url) {
            console,log(url);
        },
        //点击相关联接
        getAboutUrl(url) {
            console.log(url);
        }
    },
};
</script>