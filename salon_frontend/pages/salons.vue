<template>
  
<div id="main" class="container">
        
      <div class="title ">
        All Available Salons
      </div>


      <div class="row" >
  <div class="col-sm-6" style="padding:20px;">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Salon Name</h5>
        <p class="card-text">Owned by (salon.salonOwner).</p>
        <a href="#" class="btn btn-primary">Go to (Salon) Page</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6" style="padding:20px;">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Salon Name</h5>
        <p class="card-text">Owned by (salon.salonOwner).</p>
        <a href="#" class="btn btn-primary">Go to (Salon) Page</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6" style="padding:20px;">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Salon Name</h5>
        <p class="card-text">Owned by (salon.salonOwner).</p>
        <a href="#" class="btn btn-primary">Go to (Salon) Page</a>
      </div>
    </div>
  </div>
</div>
      


</div>




</template>

<script>
import AllSalonsTable from '~/components/AllSalonsTable.vue'
import SalonAccordion from '~/components/SalonAccordion.vue'

export default {
    data () {
    return { 
      showme: true 
      }
  },
  components: {
    SalonAccordion
  }
}
</script>

<style>
.container {
  display: flex;
  flex-direction: column; /* or inline-flex */
}
</style>
