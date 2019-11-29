export const state = () => ({
    user: {}
  })

  export const mutations = {
    add (state, obj) {
      state.user = obj
    },
  }