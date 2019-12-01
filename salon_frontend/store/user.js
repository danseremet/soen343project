
export const state = () => ({
    user: {},
    authenticated: false,
  })
  
  export const mutations = {
    populate (state, new_user) {
      console.log('pop');
      state.user = {}
      state.user = new_user;
      state.authenticated = true;
    },  

    login (state) {
        console.log('login');
        state.loggedIn = true;
      },  

  }

  export const getters = {
    authenticated: (state) => {
      return state.authenticated;
    },

  }

//   export const actions = {
//     populate (context) {
//         context.commit('populate')
//       },

//   }