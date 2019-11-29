<template>
  
<div class="container">
        
      
      <h1 class="title">
        single salon page {{$route.params.id}}
      </h1>
       

</div>




</template>

<script>

import axios from "axios";

export default {
    data () {
    return { 
      showme: true 
      }
  },
  created(){
    console.log(this.$route.params.id);
  },
  components: {
    
  }
}
</script>

<style>

</style>
