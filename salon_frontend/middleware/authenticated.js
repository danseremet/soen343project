
  export default function ({ store, redirect }) {
      console.log(store.state.authenticated)
    // If the user is not authenticated
    if (!store.state.authenticated) {
      return redirect('/login')
    }
  }