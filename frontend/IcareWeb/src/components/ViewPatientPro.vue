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
                  <input
                    type="email"
                    class="form-control"
                    id="inputEmail"
                    v-model="patient.email"
                    placeholder="Email"
                    required
                    pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
                  />
                </div>
                <div class="mb-3">
                  <label for="inputPassword" class="form-label">Password</label>
                  <input
                    type="password"
                    class="form-control"
                    v-model="patient.password"
                    id="inputPassword"
                    placeholder="Password"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="inputFirstName" class="form-label"
                    >First Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.firstName"
                    id="inputFirstName"
                    placeholder="First Name"
                  />
                </div>
                <div class="mb-3">
                  <label for="inputLastName" class="form-label"
                    >Last Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.lastName"
                    id="inputLastName"
                    placeholder="Last Name"
                  />
                </div>
                <div class="mb-3">
                  <label for="inputUsername" class="form-label">Username</label>
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.uname"
                    id="inputUsername"
                    placeholder="Username"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="inputGender" class="form-label">Gender</label>
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.gender"
                    id="inputGender"
                    placeholder="Gender"
                  />
                </div>
                <div class="mb-3">
                  <label for="inputBloodGroup" class="form-label"
                    >Blood Group</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.bloodGroup"
                    id="inputBloodGroup"
                    placeholder="Blood Group"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="inputAge" class="form-label">Age</label>
                  <input
                    type="number"
                    class="form-control"
                    v-model="patient.age"
                    id="inputAge"
                    placeholder="Age"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="inputStreet" class="form-label">Street</label>
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.address.street"
                    id="inputStreet"
                    placeholder="Street"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="inputDistrict" class="form-label">District</label>
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.address.district"
                    id="inputDistrict"
                    placeholder="District"
                    required
                  />
                </div>
                <div class="mb-3">
                  <label for="inputProvince" class="form-label">Province</label>
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.address.province"
                    id="inputProvince"
                    placeholder="Province"
                    required
                  />
                </div>

                <div class="mb-3">
                  <label for="inputTelephone" class="form-label"
                    >Telephone</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    v-model="patient.tel"
                    id="inputTelephone"
                    placeholder="Telephone"
                    required
                  />
                </div>
                <button
                  type="submit"
                  class="btn btn-primary"
                  style="margin-right: 10px"
                >
                  Update
                </button>
                <button
                  type="button"
                  @click="deletePatient"
                  class="btn btn-primary"
                >
                  Delete
                </button>
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
import PatientService from "../services/PatientService";
import axios from "axios";

export default {
  data() {
    return {
      patient: {
        email: "",
        password: "",
        firstName: "",
        lastName: "",
        uname: "",
        gender: "",
        bloodGroup: "",
        age: "",
        address: {
          street: "",
          district: "",
          province: "",
        },
        date: "",
        tel: "",
      },
    };
  },
  created() {
    // Fetch patient data initially
    this.fetchPatientData();

    // Set up polling to fetch data every 5 seconds (adjust the interval as needed)
    setInterval(this.fetchPatientData, 15000); // Poll every 5 seconds
  },
  methods: {
    fetchPatientData() {
      const patientId = this.$route.params.patientId;

      // Fetch patient data by patientId from the database using PatientService
      PatientService.getPatientById(patientId)
        .then((response) => {
          // Update the patient data in your component
          this.patient = response.data;
        })
        .catch((error) => {
          console.error("Error fetching patient data:", error);
        });
    },
    submitForm() {
      // Send the updated patient data to the Spring Boot API using PUT request
      PatientService.updatePatient(this.patient)
        .then((response) => {
          // Handle success (e.g., show a success message)
          console.log("Patient data updated successfully:", response.data);
          Swal.fire("Data updated!");
        })
        .catch((error) => {
          // Handle errors (e.g., show an error message)
          console.error("Error updating patient data:", error);
          Swal.fire("Error Action!");

        });
    },

    deletePatient() {
      // Send a DELETE request to delete the patient using the same PatientService
      const patientId = this.$route.params.patientId;
      PatientService.deletePatient(patientId)
        .then((response) => {
          // Handle success (e.g., show a success message)
          console.log("Patient deleted successfully:", response.data);
          Swal.fire("Data Deleted!");
        })
        .catch((error) => {
          // Handle errors (e.g., show an error message)
          console.error("Error deleting patient:", error);
          Swal.fire("Error Action!");

        });
    },
  },
};
</script>
