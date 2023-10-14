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
                  <p class="text-danger" v-if="!isValidEmail">Please enter a valid email address.</p>
                </div>
                <div class="mb-3">
                  <label for="inputPassword" class="form-label">Password</label>
                  <input type="password" class="form-control" v-model="patient.password" id="inputPassword" placeholder="Password" />
                  <p class="text-danger" v-if="!isValidPassword">Password must be at least 8 characters long.</p>
                </div>
                <div class="mb-3">
                  <label for="inputFirstName" class="form-label">First Name</label>
                  <input type="text" class ="form-control" id="inputFirstName" v-model="patient.firstName" placeholder="First Name" />
                  <p class="text-danger" v-if="!isValidFirstName">Please enter a valid first name.</p>
                </div>
                <div class="mb-3">
                  <label for="inputLastName" class="form-label">Last Name</label>
                  <input type="text" class="form-control" id="inputLastName" v-model="patient.lastName" placeholder="Last Name" />
                  <p class="text-danger" v-if="!isValidLastName">Please enter a valid last name.</p>
                </div>
                <div class="mb-3">
                  <label for="inputUsername" class="form-label">Username</label>
                  <input type="text" class="form-control" id="inputUsername" v-model="patient.uname" placeholder="Username" />
                  <p class="text-danger" v-if="!isValidUsername">Please enter a valid username.</p>
                </div>
                <div class="mb-3">
                  <label for="inputGender" class="form-label">Gender</label>
                  <input type="text" class="form-control" id="inputGender" v-model="patient.gender" placeholder="Gender" />
                  <p class="text-danger" v-if="!isValidGender">Please enter a valid gender.</p>
                </div>
                <div class="mb-3">
                  <label for="inputBloodGroup" class="form-label">Blood Group</label>
                  <input type="text" class="form-control" id="inputBloodGroup" v-model="patient.bloodGroup" placeholder="Blood Group" />
                  <p class="text-danger" v-if="!isValidBloodGroup">Please enter a valid blood group.</p>
                </div>
                <div class="mb-3">
                  <label for="inputAge" class="form-label">Age</label>
                  <input type="number" class="form-control" id="inputAge" v-model="patient.age" placeholder="Age" />
                  <p class="text-danger" v-if="!isValidAge">Please enter a valid age.</p>
                </div>
                <div class="mb-3">
                  <label for="inputStreet" class="form-label">Street</label>
                  <input type="text" class="form-control" id="inputStreet" v-model="patient.address.street" placeholder="Street" />
                  <p class="text-danger" v-if="!isValidStreet">Please enter a valid street address.</p>
                </div>
                <div class="mb-3">
                  <label for="inputDistrict" class="form-label">District</label>
                  <input type="text" class="form-control" id="inputDistrict" v-model="patient.address.district" placeholder="District" />
                  <p class="text-danger" v-if="!isValidDistrict">Please enter a valid district.</p>
                </div>
                <div class="mb-3">
                  <label for="inputProvince" class="form-label">Province</label>
                  <input type="text" class="form-control" id="inputProvince" v-model="patient.address.province" placeholder="Province" />
                  <p class="text-danger" v-if="!isValidProvince">Please enter a valid province.</p>
                </div>
                <div class="mb-3">
                  <label for="inputDate" class="form-label">Date</label>
                  <input type="date" class="form-control" id="inputDate" v-model="patient.date" />
                  <p class="text-danger" v-if="!isValidDate">Please enter a valid date.</p>
                </div>
                <div class="mb-3">
                  <label for="inputTelephone" class="form-label">Telephone</label>
                  <input type="text" class="form-control" id="inputTelephone" v-model="patient.tel" placeholder="Telephone" />
                  <p class="text-danger" v-if="!isValidTelephone">Please enter a valid telephone number.</p>
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
import Swal from 'sweetalert2'

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
          street: '',
          district: '',
          province: '',
        },
        date: '',
        tel: '',
      },
      isValidEmail: true,
      isValidPassword: true,
      isValidFirstName: true,
      isValidLastName: true,
      isValidUsername: true,
      isValidGender: true,
      isValidBloodGroup: true,
      isValidAge: true,
      isValidStreet: true,
      isValidDistrict: true,
      isValidProvince: true,
      isValidDate: true,
      isValidTelephone: true,
      isFormValid: true,
    };
  },
  methods: {
    submitForm() {
      this.validateForm();

      if (this.isFormValid) {

        // Send a POST request to your Spring Boot API
        axios
          .post('http://localhost:8083/patient', this.patient)
          .then((response) => {
            console.log('User data sent successfully:', response.data);

            // Optionally, you can reset the form fields here
            this.patient.email = '';
            this.patient.password = '';
            this.patient.firstName = '';
            this.patient.lastName = '';
            this.patient.uname = '';
            this.patient.gender = '';
            this.patient.bloodGroup = '';
            this.patient.age = '';
            this.patient.address.street = '';
            this.patient.address.district = '';
            this.patient.address.province = '';
            this.patient.date = '';
            this.patient.tel = '';
            Swal.fire('Data Inserted!')
          })
          .catch((error) => {
            console.error('Error sending user data:', error);
          });
      }
    },
    validateForm() {
      // Validate email
      this.isValidEmail = this.isValidEmailFormat(this.patient.email);

      // Validate password (add your own validation logic)
      this.isValidPassword = this.isValidPasswordFormat(this.patient.password);

      // Validate first name, last name, username, gender, blood group, age, street, district, province, date, and telephone
      this.isValidFirstName = this.isValidField(this.patient.firstName);
      this.isValidLastName = this.isValidField(this.patient.lastName);
      this.isValidUsername = this.isValidField(this.patient.uname);
      this.isValidGender = this.isValidField(this.patient.gender);
      this.isValidBloodGroup = this.isValidField(this.patient.bloodGroup);
    //  this.isValidAge = this.isValidField(this.patient.age);
      this.isValidStreet = this.isValidField(this.patient.address.street);
      this.isValidDistrict = this.isValidField(this.patient.address.district);
      this.isValidProvince = this.isValidField(this.patient.address.province);
      this.isValidDate = this.isValidField(this.patient.date);
      this.isValidTelephone = this.isValidField(this.patient.tel);

      // Check if the entire form is valid
      this.isFormValid =
        this.isValidEmail &&
        this.isValidPassword &&
        this.isValidFirstName &&
        this.isValidLastName &&
        this.isValidUsername &&
        this.isValidGender &&
        this.isValidBloodGroup &&
        this.isValidAge &&
        this.isValidStreet &&
        this.isValidDistrict &&
        this.isValidProvince &&
        this.isValidDate &&
        this.isValidTelephone;
    },
    isValidEmailFormat(email) {
      // Add your email validation logic here (e.g., regex)
      // Return true if valid, false otherwise
      return /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email);
    },
    isValidPasswordFormat(password) {
      // Add your password validation logic here
      // Return true if valid, false otherwise
      return password.length >= 8;
    },
    isValidField(value) {
      // Add your validation logic for fields (e.g., checking if they are not empty)
      // Return true if valid, false otherwise
      return typeof value === 'string' && value.trim() !== '';
    },
  },
};
</script>

  