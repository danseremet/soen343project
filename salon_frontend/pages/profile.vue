<template>
  
<div id="main" class="container">
     <div class="title ">
        My Profile
      </div>

      
        <div class="row container-sub">
          <div class="col-lg-4 col-md-6 col-sm-12">
            <div class="card">
              <div class="card-header">
                Username
              </div>
              <div class="card-body">
                <h5 class="card-title">{{username}}</h5>
                <p class="card-text">Your username is how you can be uniquely distinguised when making a booking appointments.</p>
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
                <h5 class="card-title">{{first_name}} {{last_name}}</h5>
                <p class="card-text">This is your full name.</p>
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
                <h5 class="card-title">{{email}}</h5>
                <p class="card-text">This is the email address you will be contacted by for any appointments or receipts.</p>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#editEmail">Edit Email</button>
              </div>
            </div>
          </div>
      </div>
      <BookingsTable  v-bind:bookingstable="bookingslist"/>
      <EditModal id="editUsername" />
      <EditModal id="editName" />
      <EditModal id="editEmail"/>
      

</div>




</template>



<script>

import BookingsTable from '~/components/BookingsTable.vue';
import EditModal from '~/components/EditModal.vue';


export default {
    data () {
    return { 
        bookingslist: [],
        username: '',
        first_name: '',
        last_name: '',
        email:''
    }
  },
  components: {
    BookingsTable,
    EditModal
  },
    async asyncData(context) {
      let my_bookingslist = [
                    { 
                      "booking1":"description1", 
                      "booking2":"description2",
                      "booking3":"description3",
                    }
                        ];
      let temp_username = "MyUsername";
      let temp_first_name = "First";
      let temp_last_name = "Last";
      let temp_email = "test@gmail.com";
      return {
      bookingslist: my_bookingslist,
      username: temp_username,
      first_name: temp_first_name,
      last_name: temp_last_name,
      email: temp_email,
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



