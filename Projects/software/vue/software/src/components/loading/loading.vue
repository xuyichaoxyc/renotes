<template>
    <div class="loading-wrapper">
        <div class="loading-content">
            <img width="50" height="50" src="../../assets/svg/puff.svg"/>
            <p class="title">{{title}}</p>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            title: '正在加载中。。。'
        }
    }
}
</script>
