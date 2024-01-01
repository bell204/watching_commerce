import {
    getAccessToken,
    setAccessToken,
    getUser,
    setUser
  } from '../../../../front/src/utils/auth'

  const user = {
    state: {
      info: {
        authToken: getAccessToken(),
        user: getUser()
      }
    },
    mutations: {
      setAccessToken (state, accessToken) {
        setAccessToken(accessToken)
        state.info.authToken = accessToken
      },
      setUser (state, user) {
        setUser(user)
        state.info.user = user
      },
    },
    actions: {
      setAccessToken (context, accessToken) {
        context.commit('setAccessToken', accessToken)
      },
      setUser (context, user) {
        console.log("setUser ac")
        context.commit('setUser', user)
      },
       
    },
    getters: {
      getUser (state) {
        return state.info
      }
    }
  }
  
  export default user
  