<template>
  
<div class="container">
        
      
      <h1 class="title">
        single salon page {{$route.params.id}}
      </h1>
       

</div>




</template>

<script>

import axios from "axios";
import navbar from '~/components/navbar.vue'

export default {
    data () {
    return { showme: true }
  },
  components: {
    navbar
  }
}
</script>

<style>

</style>
