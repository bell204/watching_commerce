<template>
  <div>
    <form @submit.prevent="login">
      <label for="userId">User ID:</label>
      <input type="text" v-model="userId" id="userId" required>

      <label for="userPassword">Password:</label>
      <input type="password" v-model="userPassword" id="userPassword" required>

      <button type="submit">Login</button>
    </form>
  </div>
</template>

<script>
  import axios from 'axios'

  export default {
      name: 'login',
      data() {
          return {
            userId: '',
            userPassword: '',
          }
      },
      methods: {
          login() {
            axios
                .post( process.env.VUE_APP_REQ_URL +'/api/v1/users/login', {
                    id: this.userId, 
                    password: this.userPassword
                })
                .then((response) => {
                  console.log(response)
                }).catch((error) => {
                  console.error("실패 ", error);
                })
          }
      }
  }
</script>