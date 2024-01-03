<template>
    <div>상점 등록
      <form @submit.prevent="registerStore">
        <div>
            <label for="name">Name:</label>
            <input type="text" v-model="formData.name" id="name" >
        </div>

        <div>
            <label for="phone">Phone:</label>
            <input type="text" v-model="formData.phone" id="phone" >
        </div>

        <div>
            <label for="address">Address:</label>
            <input type="text" v-model="formData.address" id="address" >
        </div>

        <div>
            <label for="introduction">Introduction:</label>
            <input type="text" v-model="formData.introduction" id="introduction" >
        </div>

        <div>
            <label for="categoryName">Category Name:</label>
            <input type="text" v-model="formData.categoryName" id="categoryName" >
        </div>

        <button type="submit">registerStore</button>
      </form>
    </div>
  </template>
  
  <script>
    import axios from 'axios'

    export default {
        name: 'registerStore',
        data() {
            return {
                formData: {
                    name: '',
                    phone: '',
                    address: '',
                    openStatus: 'O',
                    introduction: '',
                    categoryName: ''
                }
            }
        },
        methods: {
            registerStore() {
                axios
                    .post( process.env.VUE_APP_REQ_URL +'/api/v1/stores/insertStore', this.formData)
                    .then((response) => {
                        console.log(response)
                        this.$router.push("/dashboard")
                    }).catch((error) => {
                        console.error("실패 ", error);
                    })
            }
        }
    }
  </script>