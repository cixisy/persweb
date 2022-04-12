<template>
  <div>
    用户名：
    <input v-model:value="username" name = "用户名"></input><br>
    密码：
    <input v-model:value="password"  name = "密码"></input><br>
    <button type="button" style="height: 30px" v-on:dblclick="loginop()">登录</button>
  </div>
</template>

<script>
export default {
  name: "login",
  data(){
    return{
      username:"",
      password:""
    }
  },
  methods:{
    loginop(){
      this.axios.get('/api/login/syslogin').then((response) => {
        var result = response.data;
        console.log(result)
      }).catch((response) => {
        console.log(response);
        this.$message({
          type: 'success',
          message: response,
          showClose: false,
          duration: 3000,
          center: true,
          dangerouslyUseHtmlString: false
        })
      })


    }

  }
}
</script>

<style scoped>

</style>
