<template>
    <span class="errorMessage"><span class="em">*</span> {{errMsg}}</span>
</template>

<script>
export default {
    props: {
        errMsg: String
    }
}
</script>

<style lang="scss" scoped>
.errorMessage{
    .em {
        font-weight: 600;
    }
    font-weight: 400;
    color: #e12727;
    font-size: 10px;
    position: absolute;
    bottom: -15px;
    left: 30px;
}
</style>