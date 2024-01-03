<template>
    <div>
      dashbaord
      <router-link to="myPage">마이페이지</router-link>
      <div>
        <ul>
          <li v-for="category in categories" :key="category.id">{{ category.name }}</li>
        </ul>
     </div>
    </div>
  </template>
  
  <script>
    import axios from 'axios'

    export default {
        name: 'dashboard',
        data() {
            return {
              categories : []
            }
        },
        methods: {
            searchCategory() {
              axios
                    .get( process.env.VUE_APP_REQ_URL +'/api/v1/categories/search')
                    .then((response) => {
                      console.log(response)
                      this.categories = response.data;
                    }).catch((error) => {
                      console.error("실패 ", error);
                    })
            }
        },

        mounted() {
          this.searchCategory();
        }
    }
  </script>