<template>
    <div class="container">
        <div class="load-svg">
            <img ref="../assets/svg/puff.svg"/>
        </div>
        <div class="header">
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
        <div class="middle" v-bind="loading">
            <div class="left">
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
            </div>
            <div class="right">
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
                <p>content</p>
            </div>
            <!-- <div class="right"></div> -->
            <div class="clener"></div>
        </div>
        
        <div class="footer">footer</div>
    </div>
</template>

<style scoped>
    @import "../assets/css/hello.css";
</style>
<script>
export default {
  data() {
      return {
          res: false,
      }
    },
  mounted() {
    console.log(111);
    // this.waitDateload();
  },
  computed: {
    //   loading() {
    //       return this.res
    //   }
  },
  methods: {
//     waitDateload() {
//       console.log(this.res);
//       setTimeout(() => {
//         this.res = true;
//         console.log(this.res);
//       }, 5000);
//     },
  }
}
</script>
