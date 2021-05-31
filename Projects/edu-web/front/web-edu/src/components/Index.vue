<template>
  <a-layout id="components-layout-demo-responsive">
    <a-layout-sider
      theme="light"
      width="230px"
      breakpoint="lg"
      size="large"
      collapsed-width="0"
      @collapse="onCollapse"
      @breakpoint="onBreakpoint"
    >
      <div class="logo">
          <img class="img-logo" src="../assets/logo.jpg"/>
      </div>
      <a-menu size="large" theme="light" mode="inline" :default-selected-keys="['4']">
        <a-menu-item style="height:40px" key="1">
          <a-icon type="user" />
          <span class="nav-text">nav 1</span>
        </a-menu-item>
        <a-menu-item key="2">
          <a-icon type="video-camera" />
          <span class="nav-text">nav 2</span>
        </a-menu-item>
        <a-menu-item key="3">
          <a-icon type="upload" />
          <span class="nav-text">nav 3</span>
        </a-menu-item>
        <a-menu-item key="4">
          <a-icon type="user" />
          <span class="nav-text">nav 4</span>
        </a-menu-item>
      </a-menu>
    </a-layout-sider>
    <a-layout>
      <!-- 头部 -->
      <a-layout-header class="header">
          <a-row>
            <a-col :span="8">
              <a-input-search placeholder="input search text" :style="{width: '300px'}" @search="onSearch" />
            </a-col>
            <a-col :span="12"/>
            <a-col :span="4">
              <a-row>
                <a-col :xs="{ span: 5, offset: 1 }" :lg="{ span: 6, offset: 2 }">
                  <a-icon :style="{ fontSize: '26px', color: 'rgb(119,119,119)' }" type="message" />
                </a-col>
                <a-col :xs="{ span: 11, offset: 1 }" :lg="{ span: 6, offset: 2 }">
                  <a-icon :style="{ fontSize: '26px', color: 'rgb(119,119,119)' }" type="user" />
                </a-col>
                <a-col :xs="{ span: 5, offset: 1 }" :lg="{ span: 6, offset: 2 }">
                  <a-icon :style="{ fontSize: '26px', color: 'rgb(119,119,119)' }" type="setting" />
                </a-col>
              </a-row>
            </a-col>
          </a-row>

      
      </a-layout-header>
      <a-layout-content class="content">
        <div class="div_content">
          content
        </div>
      </a-layout-content>
      <a-layout-footer class="footer">
        Ant Design ©2018 Created by Ant UED
      </a-layout-footer>
    </a-layout>
  </a-layout>
</template>

<script>
export default {
    name: 'Index',
    methods: {
        onCollapse(collapsed, type) {
        console.log(collapsed, type);
        },
        onBreakpoint(broken) {
        console.log(broken);
        },
    },
};
</script>

<style scoped src = "../assets/css/index.css"/>
