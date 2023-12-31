<template>
  <div>
    <form @submit.prevent="signUp">
      <label for="userId">User ID:</label>
      <input type="text" v-model="userId" id="userId" required>

      <label for="userPassword">Password:</label>
      <input type="password" v-model="userPassword" id="userPassword" required>

      <button type="submit">signUp</button>
    </form>
  </div>
</template>


<script>
  import axios from 'axios'

  export default {
      name: 'signUp',
      data() {
          return {
            userId: '',
            userPassword: '',
          }
      },
      methods: {
        signUp() {
          axios
                .post( process.env.VUE_APP_REQ_URL +'/api/v1/users/signUp', {
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