<template>
  
<div id="main" class="container">
     <div class="title ">
        {{this.$store.state.user.user.username}}
      </div>

      
        <div class="row container-sub">
          <div class="col-lg-4 col-md-6 col-sm-12">
            <div class="card">
              <div class="card-header">
                Usernames
              </div>
              <div class="card-body">
                <h5 class="card-title">{{this.$store.state.user.user.username}}</h5>
                <p class="card-text">Your username is how you can be uniquely distinguised when making appointments.</p>
               <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editUsername">Edit Username</button>
              </div>
            </div>
          </div>
           <div class="col-lg-4 col-md-6 col-sm-12">
            <div class="card">
              <div class="card-header">
                Full Name
              </div>
              <div class="card-body">
                <h5 class="card-title">{{this.$store.state.user.user.firstName}} {{this.$store.state.user.user.lastName}}</h5>
                <p class="card-text">This is your full name, if you somehow change identities you may use the button below to edit it.</p>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editName">Edit Full Name</button>
              </div>
            </div>
          </div>
           <div class="col-lg-4 col-md-12 col-sm12">
            <div class="card">
              <div class="card-header">
                Email
              </div>
              <div class="card-body">
                <h5 class="card-title">{{this.$store.state.user.user.email}}</h5>
                <p class="card-text">This is the email address you will be contacted by for any appointments or receipts.</p>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editEmail">Edit Email</button>
              </div>
            </div>
          </div>
      </div>
      

      <BookingsTable  v-bind:bookingstable="results"/>
      <EditModal id="editUsername" v-bind:test="username"/>
      <EditModal id="editName" :test="full_name"/>
      <EditModal id="editEmail" v-bind:test="email"/>
      

</div>




</template>



<script>

import axios from "axios";
import BookingsTable from '~/components/BookingsTable.vue';
import EditModal from '~/components/EditModal.vue';


export default {
  //middleware: 'authenticated',
  
    data () {
    return { 
        bookingslist: [],
        username: '',
        first_name: '',
        last_name: '',
        email:'',
        full_name: '',
        results: [],
    }
  },
  mounted(){
    this.$axios.get("/api/v1/bookings/customer/" + this.$store.state.user.user.id).then(response => {
            this.results = response.data
          })
  },
  components: {
    BookingsTable,
    EditModal
  },
    async asyncData({$store}) {
      let my_bookingslist = [
                    { 
                      "booking1":"description1", 
                      "booking2":"description2",
                      "booking3":"description3",
                    }
                        ];
      return {
      bookingslist: my_bookingslist,
    };
  }

}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column; /* or inline-flex */
}
.title{
  padding: 10px;
}
.container-sub{
  padding-top : 30px;
  padding-bottom : 30px;
}
.card{
  margin-top : 30px;
  margin-bottom : 30px;
}
</style>



