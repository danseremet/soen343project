<template>

<div class="row" >
       
  <div v-for="salon in all_salons" v-bind:key="salon.id" class="col-sm-6" style="padding:20px;">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Salon Name</h5>
        <p class="card-text">Owned by (salon.salonOwner).</p>
        <a href="#" class="btn btn-primary">Go to (Salon) Page</a>
      </div>
    </div>
  </div>

</div>



</template>

<script>
export default {
  name: "AllSalonsTable",
  props:{
      
  },
  methods: {
  },
  data() {
    return {
      all_salons: []
    };
  },
  async mounted() {
    var all_salons_response = this.$axios.get("/api/v1/salons").then(function(response){
        console.log(response.data);
        let salons = response.data;
        this.all_salons = salons;
    }).catch(function(error){
      console.log(error);
    }

    );
    
    
   
  }

}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column; /* or inline-flex */
}
</style>