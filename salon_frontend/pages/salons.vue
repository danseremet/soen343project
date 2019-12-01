<template>
  <div id="main" class="container">
    <div class="title">All Available Salons</div>

    <div class="row">
      <div v-for="salon in salons" v-bind:key="salon.id" class="col-sm-6" style="padding:20px;">
        <div class="card">
          <div class="card-body">
            <h5 class="card-title">{{salon.name}}</h5>
            <p class="card-text">Owned by ownerID: {{salon.ownerId}}</p>
            <a :href="'salon/'+salon.id" class="button--grey">Go to {{salon.name}}'s Page</a>
          </div>
        </div>
      </div>
    </div>

    <!-- <AllSalonsTable /> -->
  </div>
</template>

<script>
import AllSalonsTable from "~/components/AllSalonsTable.vue";
import SalonAccordion from "~/components/SalonAccordion.vue";

export default {
  data() {
    return {
      salons: []
    };
  },
  async asyncData({ $axios }) {
    let all_salons = await $axios.get("/api/v1/salons");
    console.log("hi");

    return {
      salons: all_salons.data
    };
  },
  components: {
    SalonAccordion,
    AllSalonsTable
  }
};
</script>

<style>
.container {
  display: flex;
  flex-direction: column; /* or inline-flex */
}
.card {
  border-color: #35495e;
}
.button--grey--inverse {
  display: inline-block;
  border-radius: 4px;
  border: 1px solid #35495e;
  color: #fff;
  text-decoration: none;
  padding: 10px 30px;
  background-color: #35495e;
}

.button--grey--inverse:hover {
  color: #35495e;
  background-color: #fff;
}
</style>
