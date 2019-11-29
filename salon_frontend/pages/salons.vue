<template>
  
<div id="main" class="container">
        
      <div class="title ">
        All Available Salons
      </div>

<div class="row">
      <div v-for="salon in salons" v-bind:key="salon.id" class="col-sm-6" style="padding:20px;">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">{{salon.name}}</h5>
        <p class="card-text">Owned by (salon.salonOwner).</p>
        <a href="#" class="btn btn-primary">Go to {{salon.name}}'s Page</a>
      </div>
    </div>
  </div>
</div>

<!-- <AllSalonsTable /> -->


</div>




</template>

<script>
import AllSalonsTable from '~/components/AllSalonsTable.vue'
import SalonAccordion from '~/components/SalonAccordion.vue'

export default {
    data () {
    return { 
      salons: [],
      }
  },
  async asyncData({$axios}) {
    let all_salons = await $axios.get(
      "/api/v1/salons"
    );
    console.log('hi');
    
    return {
      salons: all_salons.data,
    };
  },
  components: {
    SalonAccordion,
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
