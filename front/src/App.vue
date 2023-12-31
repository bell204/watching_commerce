<template>
<div id="app">
    <router-link to="/">홈</router-link>
    <router-link to="/signUp">회원가입</router-link>
    <router-link to="/login">로그인</router-link>
    <router-view></router-view>
  </div>
</template>

<script>
  export default {
      name: 'App',

      created() {},
      mounted() {
        console.log(process.env)
      },
  }
</script>