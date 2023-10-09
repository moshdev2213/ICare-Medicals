<template>
  <div class="body-wrapper">
    <div class="container-fluid pt-4 pb-4">
      <div class="row">
        <div class="col-lg-8">
          <div class="card">
            <div class="card-body">
              <form @submit.prevent="submitForm">
                <h3>Patient Profile</h3>
                <div class="mb-3">
                  <label for="inputEmail" class="form-label">Email</label>
                  <input type="email" class="form-control" id="inputEmail" v-model="patient.email" placeholder="Email" />
                </div>
                <div class="mb-3">
                  <label for="inputPassword" class="form-label">Password</label>
                  <input type="password" class="form-control" v-model="patient.password" id="inputPassword" placeholder="Password" />
                </div>
                <div class="mb-3">
                  <label for="inputFirstName" class="form-label">First Name</label>
                  <input type="text" class="form-control" v-model="patient.firstName" id="inputFirstName" placeholder="First Name" />
                </div>
                <div class="mb-3">
                  <label for="inputLastName" class="form-label">Last Name</label>
                  <input type="text" class="form-control" v-model="patient.lastName" id="inputLastName" placeholder="Last Name" />
                </div>
                <div class="mb-3">
                  <label for="inputUsername" class="form-label">Username</label>
                  <input type="text" class="form-control" v-model="patient.uname" id="inputUsername" placeholder="Username" />
                </div>
                <div class="mb-3">
                  <label for="inputGender" class="form-label">Gender</label>
                  <input type="text" class="form-control" v-model="patient.gender" id="inputGender" placeholder="Gender" />
                </div>
                <div class="mb-3">
                  <label for="inputBloodGroup" class="form-label">Blood Group</label>
                  <input type="text" class="form-control" v-model="patient.bloodGroup" id="inputBloodGroup" placeholder="Blood Group" />
                </div>
                <div class="mb-3">
                  <label for="inputAge" class="form-label">Age</label>
                  <input type="number" class="form-control" v-model="patient.age" id="inputAge" placeholder="Age" />
                </div>
                <div class="mb-3">
                  <label for="inputStreet" class="form-label">Street</label>
                  <input type="text" class="form-control" v-model="patient.address.street" id="inputStreet" placeholder="Street" />
                </div>
                <div class="mb-3">
                  <label for="inputDistrict" class="form-label">District</label>
                  <input type="text" class="form-control" v-model="patient.address.district" id="inputDistrict" placeholder="District" />
                </div>
                <div class="mb-3">
                  <label for="inputProvince" class="form-label">Province</label>
                  <input type="text" class="form-control" v-model="patient.address.province" id="inputProvince" placeholder="Province" />
                </div>
                <div class="mb-3">
                  <label for="inputDate" class="form-label">Date</label>
                  <input type="date" class="form-control" v-model="patient.date" id="inputDate" />
                </div>
                <div class="mb-3">
                  <label for="inputTelephone" class="form-label">Telephone</label>
                  <input type="text" class="form-control" v-model="patient.tel" id="inputTelephone" placeholder="Telephone" />
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
      patient: {
      email: '',
      password: '',
      firstName: '',
      lastName: '',
      uname: '',
      gender: '',
      bloodGroup: '',
      age: '',
      address: {
          "street": '',
          "district": '',
          "province": ''
      },
      date: '',
      tel: ''
      },
    };
  },
  methods: {
    submitForm() {
      // Send a POST request to your Spring Boot API
      axios
        .post('http://localhost:8083/patient', this.patient)
        .then((response) => {
          console.log('User data sent successfully:', response.data);
          // Optionally, you can reset the form fields here
          this.patient.firstName = '';
          this.patient.lastName = '';
          this.patient.email = '';
          this.patient.uname = '';
          this.patient.gender = '';
          this.patient.bloodGroup = '';
          this.patient.age = '';
          this.patient.address = '';
          this.patient.date = '';
          this.patient.tel = '';
          this.patient.password = '';
          
        })
        .catch((error) => {
          console.error('Error sending user data:', error);
        });
    },
  },
};
</script>
  