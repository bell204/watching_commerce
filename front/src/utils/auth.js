import Cookie from 'vue-cookie'
const accessTokenKey = 'access'
const userKey = 'user'

// ACCESS TOKEN
export function getAccessToken () {
  return Cookie.get(accessTokenKey)
}

export function setAccessToken (accessToken) {
  Cookie.set(accessTokenKey, accessToken)
}

export function getUser () {
  return Cookie.get(userKey)
}

export function setUser (user) {
  Cookie.set(userKey, user)
}