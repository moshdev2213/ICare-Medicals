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
                    <label for="inputTelephone" class="form-label">Added</label>
                    <input type="text" class="form-control" id="inputTelephone" v-model="doctor.added" placeholder="Enter Telephone" />
                  </div>
                  
  <button type="submit" class="btn btn-primary" style="margin-right: 10px;">Update</button>
  <button type="button" @click="deleteDoctor" class="btn btn-primary">Delete</button>
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
import DoctorService from '../services/DoctorService';
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
  created() {
    // Fetch patient data initially
    this.fetchDoctorData();

    // Set up polling to fetch data every 5 seconds (adjust the interval as needed)
    setInterval(this.fetchDoctorData, 15000); // Poll every 5 seconds
  },
  methods: {
    fetchDoctorData() {
      const doctorid = this.$route.params.doctorid;

      // Fetch patient data by patientId from the database using PatientService
      DoctorService.getDoctorById(doctorid)
        .then((response) => {
          // Update the patient data in your component
          this.doctor = response.data;
        })
        .catch((error) => {
          console.error('Error fetching doctor data:', error);
        });
    },
    submitForm() {
      // Send the updated patient data to the Spring Boot API using PUT request
      DoctorService.updateDoctor(this.doctor)
        .then((response) => {
          // Handle success (e.g., show a success message)
          console.log('Doctor data updated successfully:', response.data);
        })
        .catch((error) => {
          // Handle errors (e.g., show an error message)
          console.error('Error updating doctor data:', error);
        });
    },

          deleteDoctor() {
      // Send a DELETE request to delete the patient using the same PatientService
      const doctorid = this.$route.params.doctorid;
      DoctorService.deleteDoctor(doctorid)
        .then((response) => {
          // Handle success (e.g., show a success message)
          console.log('doctor deleted successfully:', response.data);
        })
        .catch((error) => {
          // Handle errors (e.g., show an error message)
          console.error('Error deleting doctor:', error);
        });
    },




  },
};
</script>
