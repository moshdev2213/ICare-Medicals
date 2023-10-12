<template>
    <div class="body-wrapper">
      <div class="container-fluid pt-4 pb-4">
        <div class="row">
          <div class="col-lg-8">
            <div class="card">
              <div class="card-body">
                <form @submit.prevent="submitForm">
                  <h3>Doctor Profile</h3>
                  <div class="mb-3">
                    <label for="inputEmail" class="form-label">Email</label>
                    <input type="email" class="form-control" id="inputEmail" v-model="doctor.email" placeholder="Enter Email" />
                  </div>
                  <div class="mb-3">
                    <label for="inputFirstName" class="form-label">First Name</label>
                    <input type="text" class="form-control" id="inputFirstName" v-model="doctor.firstName" placeholder="Enter First Name" />
                  </div>
                  <div class="mb-3">
                    <label for ="inputLastName" class="form-label">Last Name</label>
                    <input type="text" class="form-control" id="inputLastName" v-model="doctor.lastName" placeholder="Enter Last Name" />
                  </div>
                  <div class="mb-3">
                    <label for="inputUsername" class="form-label">Time available</label>
                    <input type="text" class="form-control" id="inputUsername" v-model="doctor.timeAvailabe" placeholder="Enter Time Available" />
                  </div>
                  <div class="mb-3">
                    <label for="inputGender" class="form-label">Description</label>
                    <input type="text" class="form-control" id="inputGender" v-model="doctor.description" placeholder="Enter Description" />
                  </div>
                  <div class="mb-3">
                    <label for="inputBloodGroup" class="form-label">Specialization</label>
                    <input type="text" class="form-control" id="inputBloodGroup" v-model="doctor.specializing" placeholder="Enter Specialization" />
                  </div>
                  <div class="mb-3">
                    <label for="inputAge" class="form-label">Status</label>
                    <input type="number" class="form-control" id="inputAge" v-model="doctor.status" placeholder="Enter Status" />
                  </div>
                  <div class="mb-3">
                    <label for="inputAmount" class="form-label">Amount</label>
                    <input type="number" class="form-control" id="inputAmount" v-model="doctor.amount" placeholder="Enter Amount" />
                  </div>
                  <div class="mb-3">
                    <label for="inputDistrict" class="form-label">Cured</label>
                    <input type="number" class="form-control" id="inputDistrict" v-model="doctor.cured" placeholder="Enter Cured" />
                  </div>
                  <div class="mb-3">
                    <label for="inputProvince" class="form-label">Venue</label>
                    <input type="text" class="form-control" id="inputProvince" v-model="doctor.venue" placeholder="Enter Venue" />
                  </div>
                  <div class="mb-3">
                    <label for="inputDate" class="form-label">Edited</label>
                    <input type="date" class="form-control" id="inputDate" v-model="doctor.edited" />
                  </div>
                  <div class="mb-3">
                    <label for="inputTelephone" class="form-label">Added</label>
                    <input type="text" class="form-control" id="inputTelephone" v-model="doctor.added" placeholder="Enter Telephone" />
                  </div>
                  <button type="submit" class="btn btn-primary">Update Details</button>
                </form>
              </div>
            </div>
          </div>
  
          <!-- ... -->
        </div>
      </div>
    </div>
  </template>
  
  
  
  <script>
  
  import axios from 'axios';
  export default {
    data() {
      return {
        doctor: {
        email: '',
        firstName: '',
        lastName: '',
        timeAvailabe: '',
        description: '',
        specializing: '',
        status: '',
        amount: '',
        cured: '',
        venue: '',
        added: '',
        edited: ''
        },

      };
    },
    methods: {
      submitForm() {
        // Send a POST request to your Spring Boot API
        axios
          .post('http://localhost:8083/api/v1/doctor/save', this.doctor)
          .then((response) => {
            console.log('doctor data sent successfully:', response.data);
            // Optionally, you can reset the form fields here
            this.doctor.email = '';
            this.doctor.firstName = '';
            this.doctor.lastName = '';
            this.doctor.timeAvailabe = '';
            this.doctor.description = '';
            this.doctor.specializing = '';
            this.doctor.status = '';
            this.doctor.amount = '';
            this.doctor.cured = '';
            this.doctor.venue = '';
            this.doctor.added = '';
            this.doctor.edited = '';

            
          })
          .catch((error) => {
            console.error('Error sending user data:', error);
          });
      },
    },
  };
  </script>
    