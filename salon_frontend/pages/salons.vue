<template>
  
<div id="main" class="container">
        
      <div class="title ">
        All Available Salons
      </div>


      <AllSalonsTable />
</div>




</template>

<script>
import AllSalonsTable from '~/components/AllSalonsTable.vue'

export default {
    data () {
    return { 
      showme: true 
      }
  },
  components: {
    AllSalonsTable
  }
}
</script>

<style>
.container {
  display: flex;
  flex-direction: column; /* or inline-flex */
}
</style>
