<template>
  <div className="body-wrapper ">
    <div className="container-fluid pt-4 pb-0">
      <div class="row">
        <div class="col-12">
          <!-- modal of delivery starts -->
          <div
            class="modal fade"
            style="z-index: 99999"
            id="modal-leave"
            tabindex="-1"
            role="dialog"
            aria-labelledby="modal-form"
            aria-hidden="true"
          >
            <div
              class="modal-dialog modal-dialog-centered modal-md"
              role="document"
            >
              <div class="modal-content">
                <div class="modal-body p-0">
                  <div class="card card-plain">
                    <div class="card-header pb-0 text-left">
                      <h4 class="font-weight-bolder text-primary">Leaves</h4>
                      <p class="mb-0">Enter Relevant Credentials</p>
                    </div>
                    <div class="card-body p-3">
                      <form role="form text-left">
                        <label>Coupon Name</label>
                        <div class="input-group mb-3">
                          <input
                            type="text"
                            class="form-control"
                            placeholder="Email"
                            aria-label="Email"
                            aria-describedby="email-addon"
                            onfocus="focused(this)"
                            onfocusout="defocused(this)"
                          />
                        </div>
                        <label>Value</label>
                        <div class="input-group mb-3">
                          <input
                            type="text"
                            class="form-control"
                            placeholder="Password"
                            aria-label="Password"
                            aria-describedby="password-addon"
                            onfocus="focused(this)"
                            onfocusout="defocused(this)"
                          />
                        </div>

                        <div class="row text-center">
                          <div class="col-6">
                            <button
                              type="button"
                              data-bs-dismiss="modal"
                              class="btn bg-gradient-primary btn-md w-100 mt-2 mb-0"
                            >
                              Cancel
                            </button>
                          </div>
                          <div class="col-6">
                            <button
                              type="submit"
                              class="btn btn-outline-primary btn-md w-100 mt-2 mb-0"
                            >
                              Add
                            </button>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- modal of delivery  Ends -->
          <div class="card">
            <div class="card-body p-3">
              <div class="row">
                <div class="col-6 d-flex align-items-center">
                  <h4 class="mb-3">Patient List</h4>
                </div>

                <div class="d-flex">
                  <router-link
                    to="/Pprofile"
                    class="btn btn-icon btn-outline-dark ms-2 export"
                  >
                    <span class="btn-inner--icon"
                      ><i class="ni ni-archive-2"></i
                    ></span>
                    <span class="btn-inner--text">Add Patient</span>
                  </router-link>

                  <button
                    class="btn btn-icon btn-outline-dark ms-2 export"
                    @click="exportToCSV"
                    type="button"
                  >
                    <span class="btn-inner--icon"
                      ><i class="ni ni-archive-2"></i
                    ></span>
                    <span class="btn-inner--text">Export CSV</span>
                  </button>
                </div>
              </div>
              <div class="table-responsive" id="tbl_exporttable_to_xls_4">
                <table class="table table-flush" id="datatable-basic2">
                  <thead class="thead-light">
                    <tr>
                      <th>Patient_Id</th>
                      <th>Username</th>
                      <th>E-mail</th>
                      <th>Adress</th>
                      <th>Telephone</th>
                      <th>Blood Group</th>
                      <th></th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="patien in Patiens" :key="patien.id">
                      <td>
                        <div class="d-flex align-items-center">
                          <p class="text-xs font-weight-bold ms-2 mb-0">
                            {{ patien.id }}
                          </p>
                        </div>
                      </td>
                      <td class="font-weight-bold">
                        <span class="my-2 text-xs">{{ patien.uname }}</span>
                      </td>
                      <td class="font-weight-bold">
                        <span class="my-2 text-xs">{{ patien.email }}</span>
                      </td>
                      <td class="font-weight-bold">
                        <span class="my-2 text-xs">
                          Street:
                          {{ patien.address ? patien.address.street : "N/A"
                          }}<br />
                          District:
                          {{ patien.address ? patien.address.district : "N/A"
                          }}<br />
                          Province:
                          {{ patien.address ? patien.address.province : "N/A" }}
                        </span>
                      </td>
                      <td class="text-xs font-weight-bold">
                        <span class="my-2 text-xs">{{ patien.tel }}</span>
                      </td>
                      <td class="text-xs font-weight-bold">
                        <span class="my-2 text-xs">{{
                          patien.bloodGroup
                        }}</span>
                      </td>
                      <td class="text-xs font-weight-bold p-0 pt-1">
                        <button
                          class="btn btn-outline-dark btn-xs p-1 mb-1 me-1"
                          @click="deletePatient(patien.id)"
                        >
                          Remove
                        </button>
                        <router-link
                          :to="{
                            name: 'viewPro',
                            params: { patientId: patien.id },
                          }"
                        >
                          <button class="btn btn-outline-dark btn-xs p-1 mb-1">
                            View
                          </button>
                        </router-link>
                      </td>
                    </tr>
                  </tbody>
                </table>
                <!-- modal of delivery starts -->
                <div
                  class="modal fade"
                  style="z-index: 99999"
                  id="modal-delivery"
                  tabindex="-1"
                  role="dialog"
                  aria-labelledby="modal-form"
                  aria-hidden="true"
                >
                  <div
                    class="modal-dialog modal-dialog-centered modal-md"
                    role="document"
                  >
                    <div class="modal-content">
                      <div class="modal-body p-0">
                        <div class="card card-plain">
                          <div class="card-header pb-0 text-left">
                            <h4 class="font-weight-bolder text-primary">
                              Assign Delivery Person
                            </h4>
                            <p class="mb-0">Enter Relevant Credentials</p>
                          </div>
                          <div class="card-body p-3">
                            <form role="form text-left">
                              <label>Coupon Name</label>
                              <div class="input-group mb-3">
                                <input
                                  type="text"
                                  class="form-control"
                                  placeholder="Email"
                                  aria-label="Email"
                                  aria-describedby="email-addon"
                                  onfocus="focused(this)"
                                  onfocusout="defocused(this)"
                                />
                              </div>
                              <label>Value</label>
                              <div class="input-group mb-3">
                                <input
                                  type="text"
                                  class="form-control"
                                  placeholder="Password"
                                  aria-label="Password"
                                  aria-describedby="password-addon"
                                  onfocus="focused(this)"
                                  onfocusout="defocused(this)"
                                />
                              </div>

                              <div class="row text-center">
                                <div class="col-6">
                                  <button
                                    type="button"
                                    data-bs-dismiss="modal"
                                    class="btn bg-gradient-primary btn-md w-100 mt-2 mb-0"
                                  >
                                    Cancel
                                  </button>
                                </div>
                                <div class="col-6">
                                  <button
                                    type="submit"
                                    class="btn btn-outline-primary btn-md w-100 mt-2 mb-0"
                                  >
                                    Add
                                  </button>
                                </div>
                              </div>
                            </form>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- modal of delivery  Ends -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PatientService from "../services/PatientService";
import axios from "axios";
import Swal from "sweetalert2";

export default {
  name: "PatientList",

  data() {
    return {
      Patiens: [],
    };
  },

  methods: {
    getPatients() {
      PatientService.getPatients().then((response) => {
        this.Patiens = response.data;
      });
    },

    deletePatient(patientId) {
      Swal.fire({
        title: "Are you sure?",
        text: "You won't be able to revert this!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!",
      }).then((result) => {
        if (result.isConfirmed) {
          // Send a DELETE request to delete the patient using the same PatientService
          PatientService.deletePatient(patientId)
            .then((response) => {
              // Handle success (e.g., show a success message)
              console.log("Patient deleted successfully:", response.data);

              // After deleting, update the Patiens array by removing the deleted patient
              this.Patiens = this.Patiens.filter(
                (patient) => patient.patientId !== patientId
              );

              // Navigate to the desired route (if needed)
              this.$router.push({ name: "Pman" });
            })
            .catch((error) => {
              // Handle errors (e.g., show an error message)
              console.error("Error deleting patient:", error);
            });
          Swal.fire("Deleted!", "Your file has been deleted.", "success");
        }
      });
    },

    exportToCSV() {
      const Patiens = this.Patiens;

      // Create a worksheet and add data
      const ws = XLSX.utils.json_to_sheet(Patiens);

      // Create a new workbook and add the worksheet
      const wb = XLSX.utils.book_new();
      XLSX.utils.book_append_sheet(wb, ws, "Patiens");

      // Save the workbook as a CSV file
      XLSX.writeFile(wb, "Patiens.csv");
    },
  },

  created() {
    this.getPatients();
    setInterval(this.getPatients, 1000);
  },
};
</script>
