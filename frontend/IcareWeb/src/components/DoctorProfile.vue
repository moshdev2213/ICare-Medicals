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
                  <input
                    type="email"
                    class="form-control"
                    id="inputEmail"
                    v-model="doctor.email"
                    placeholder="Enter Email"
                  />
                  <p class="text-danger" v-if="!isValidEmail">
                    Please enter a valid email address.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputFirstName" class="form-label"
                    >First Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="inputFirstName"
                    v-model="doctor.firstName"
                    placeholder="Enter First Name"
                  />
                  <p class="text-danger" v-if="!isValidFirstName">
                    Please enter a valid first name.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputLastName" class="form-label"
                    >Last Name</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="inputLastName"
                    v-model="doctor.lastName"
                    placeholder="Enter Last Name"
                  />
                  <p class="text-danger" v-if="!isValidLastName">
                    Please enter a valid last name.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputUsername" class="form-label"
                    >Time available</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="inputUsername"
                    v-model="doctor.timeAvailabe"
                    placeholder="Enter Time Available"
                  />
                  <p class="text-danger" v-if="!isValidTimeAvailable">
                    Please enter a valid time available.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputGender" class="form-label"
                    >Description</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="inputGender"
                    v-model="doctor.description"
                    placeholder="Enter Description"
                  />
                  <p class="text-danger" v-if="!isValidDescription">
                    Please enter a valid description.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputBloodGroup" class="form-label"
                    >Specialization</label
                  >
                  <input
                    type="text"
                    class="form-control"
                    id="inputBloodGroup"
                    v-model="doctor.specializing"
                    placeholder="Enter Specialization"
                  />
                  <p class="text-danger" v-if="!isValidSpecialization">
                    Please enter a valid specialization.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputAge" class="form-label">Status</label>
                  <input
                    type="number"
                    class="form-control"
                    id="inputAge"
                    v-model="doctor.status"
                    placeholder="Enter Status"
                  />
                  <p class="text-danger" v-if="!isValidStatus">
                    Please enter a valid status.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputAmount" class="form-label">Amount</label>
                  <input
                    type="number"
                    class="form-control"
                    id="inputAmount"
                    v-model="doctor.amount"
                    placeholder="Enter Amount"
                  />
                  <p class="text-danger" v-if="!isValidAmount">
                    Please enter a valid amount.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputDistrict" class="form-label">Cured</label>
                  <input
                    type="number"
                    class="form-control"
                    id="inputDistrict"
                    v-model="doctor.cured"
                    placeholder="Enter Cured"
                  />
                  <p class="text-danger" v-if="!isValidCured">
                    Please enter a valid number of cured cases.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputProvince" class="form-label">Venue</label>
                  <input
                    type="text"
                    class="form-control"
                    id="inputProvince"
                    v-model="doctor.venue"
                    placeholder="Enter Venue"
                  />
                  <p class="text-danger" v-if="!isValidVenue">
                    Please enter a valid venue.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputDate" class="form-label">Edited</label>
                  <input
                    type="date"
                    class="form-control"
                    id="inputDate"
                    v-model="doctor.edited"
                  />
                  <p class="text-danger" v-if="!isValidEdited">
                    Please enter a valid date.
                  </p>
                </div>
                <div class="mb-3">
                  <label for="inputTelephone" class="form-label">Added</label>
                  <input
                    type="text"
                    class="form-control"
                    id="inputTelephone"
                    v-model="doctor.added"
                    placeholder="Enter Added"
                  />
                  <p class="text-danger" v-if="!isValidAdded">
                    Please enter a valid added value.
                  </p>
                </div>
                <button type="submit" class="btn btn-primary">Add</button>
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
import axios from "axios";
import Swal from "sweetalert2";

export default {
  data() {
    return {
      doctor: {
        email: "",
        firstName: "",
        lastName: "",
        timeAvailabe: "",
        description: "",
        specializing: "",
        status: "",
        amount: "",
        cured: "",
        venue: "",
        added: "",
        edited: "",
      },
      isValidEmail: true,
      isValidFirstName: true,
      isValidLastName: true,
      isValidTimeAvailable: true,
      isValidDescription: true,
      isValidSpecialization: true,
      isValidStatus: true,
      isValidAmount: true,
      isValidCured: true,
      isValidVenue: true,
      isValidAdded: true,
      isValidEdited: true,
      isFormValid: true,
    };
  },
  methods: {
    submitForm() {
      this.validateForm();

      if (this.isFormValid) {
        // Send a POST request to your Spring Boot API
        axios
          .post("http://localhost:8090/api/v1/doctor/save", this.doctor)
          .then((response) => {
            console.log("Doctor data sent successfully:", response.data);

            // Optionally, you can reset the form fields here
            this.doctor.email = "";
            this.doctor.firstName = "";
            this.doctor.lastName = "";
            this.doctor.timeAvailabe = "";
            this.doctor.description = "";
            this.doctor.specializing = "";
            this.doctor.status = "";
            this.doctor.amount = "";
            this.doctor.cured = "";
            this.doctor.venue = "";
            this.doctor.added = "";
            this.doctor.edited = "";
            Swal.fire("Data Inserted!");
          })
          .catch((error) => {
            console.error("Error sending doctor data:", error);
          });
      }
    },
    validateForm() {
      this.isValidEmail = this.isValidEmailFormat(this.doctor.email);
      this.isValidFirstName = this.isValidField(this.doctor.firstName);
      this.isValidLastName = this.isValidField(this.doctor.lastName);
      this.isValidTimeAvailable = this.isValidField(this.doctor.timeAvailabe);
      this.isValidDescription = this.isValidField(this.doctor.description);
      this.isValidSpecialization = this.isValidField(this.doctor.specializing);
      // this.isValidStatus = this.isValidField(this.doctor.status);
      // this.isValidAmount = this.isValidField(this.doctor.amount);
      // this.isValidCured = this.isValidField(this.doctor.cured);
      this.isValidVenue = this.isValidField(this.doctor.venue);
      this.isValidAdded = this.isValidField(this.doctor.added);
      this.isValidEdited = this.isValidField(this.doctor.edited);

      this.isFormValid =
        this.isValidEmail &&
        this.isValidFirstName &&
        this.isValidLastName &&
        this.isValidTimeAvailable &&
        this.isValidDescription &&
        this.isValidSpecialization &&
        this.isValidStatus &&
        this.isValidAmount &&
        this.isValidCured &&
        this.isValidVenue &&
        this.isValidAdded &&
        this.isValidEdited;
      Swal.fire("Data Updated!");
    },
    isValidEmailFormat(email) {
      // Add your email validation logic here (e.g., regex)
      // Return true if valid, false otherwise
      return /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email);
    },
    isValidField(value) {
      return typeof value === "string" && value.trim() !== "";
    },
  },
};
</script>
