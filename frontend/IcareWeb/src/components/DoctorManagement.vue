<template>
    <div className="body-wrapper ">
      <div className="container-fluid pt-4 pb-0">
      <div className="row">
          <div className="col-lg-12 d-flex align-items-stretch">
          <div className="card w-100">
              <div className="card-body p-3">
                <div className="mt-3 d-flex justify-content-between align-items-baseline ">
                  <h5 className="card-title fw-semibold mb-4">Doctors</h5>
                  <input
                    type="text"
                    placeholder="Search"
                    className="form-control w-auto"/>
                </div>


              
                <div className="table-responsive">
                  <DataTables searchQuery={searchQuery} />
                </div>
              </div>
            </div>
          </div>
        </div>
        
      </div>
    </div>
    <div className="body-wrapper ">
    <div className="container-fluid pt-4 pb-0">
      <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                Patient Count</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">40,000</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-calendar fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Annual) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                Inquaries</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">10</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Tasks Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">Tasks
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">50%</div>
                                                </div>
                                                <div class="col">
                                                    <div class="progress progress-sm mr-2">
                                                        <div class="progress-bar bg-info" role="progressbar"
                                                            style="width: 50%" aria-valuenow="50" aria-valuemin="0"
                                                            aria-valuemax="100"></div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pending Requests Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                Pending Requests</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">18</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-comments fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>


                  </div>

                  <div className="container-fluid pt-4 pb-0">
                  <div class="row">
                    <div class="col-12">
							<!-- modal of delivery starts -->
							<div class="modal fade " style="z-index: 99999;" id="modal-leave"
								tabindex="-1" role="dialog" aria-labelledby="modal-form"
								aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered modal-md"
									role="document">
									<div class="modal-content">
										<div class="modal-body p-0">
											<div class="card card-plain">
												<div class="card-header pb-0 text-left">
													<h4 class="font-weight-bolder  text-primary">Leaves</h4>
													<p class="mb-0">Enter Relevant Credentials</p>
												</div>
												<div class="card-body p-3">
													<form role="form text-left">
														<label>Coupon Name</label>
														<div class="input-group mb-3">
															<input type="text" class="form-control"
																placeholder="Email" aria-label="Email"
																aria-describedby="email-addon" onfocus="focused(this)"
																onfocusout="defocused(this)">
														</div>
														<label>Value</label>
														<div class="input-group mb-3">
															<input type="text" class="form-control"
																placeholder="Password" aria-label="Password"
																aria-describedby="password-addon"
																onfocus="focused(this)" onfocusout="defocused(this)">
														</div>

														<div class=" row text-center">
															<div class="col-6">
																<button type="button" data-bs-dismiss="modal"
																	class="btn  bg-gradient-primary btn-md w-100 mt-2 mb-0">
																	Cancel</button>
															</div>
															<div class="col-6">
																<button type="submit"
																	class="btn  btn-outline-primary btn-md w-100 mt-2 mb-0">Add</button>
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
							<div class="card ">
								<div class="card-header pb-0 p-3">
									<div class="row">
										<div class="col-6 d-flex align-items-center">
											<h6 class="mb-0">Doctor List</h6>
											
										</div>
									</div>
								</div>
								<div class="card-body p-3">
									<div class="d-sm-flex justify-content-between p-0">
										<!-- <div>
                                            <a href="javascript:;" class="btn btn-icon btn-outline-dark">
                                                New order
                                            </a>
                                        </div> -->
										<div class="d-flex">
											<div class="dropdown d-inline">
												<a href="javascript:;"
													class="btn btn-outline-dark dropdown-toggle "
													data-bs-toggle="dropdown" id="navbarDropdownMenuLink2">
													Filters </a>
												<ul class="dropdown-menu dropdown-menu-lg-start px-2 py-3"
													aria-labelledby="navbarDropdownMenuLink2"
													data-popper-placement="left-start">
													<li><a class="dropdown-item border-radius-md"
														href="javascript:;">Status: Paid</a></li>
													<li><a class="dropdown-item border-radius-md"
														href="javascript:;">Status: Refunded</a></li>
													<li><a class="dropdown-item border-radius-md"
														href="javascript:;">Status: Canceled</a></li>
													<li>
														<hr class="horizontal dark my-2">
													</li>
													<li><a
														class="dropdown-item  border-radius-md text-danger"
														href="javascript:;">Remove Filter</a></li>
												</ul>
											</div>

											<router-link to="/Dprofile" class="btn btn-icon btn-outline-dark ms-2 export">
   											 <span class="btn-inner--icon"><i class="ni ni-archive-2"></i></span>
    										<span class="btn-inner--text">Add Doctors</span>
 											 </router-link>



											<button class="btn btn-icon btn-outline-dark ms-2 export"
											@click="exportToCSV" type="button">
												<span class="btn-inner--icon"><i
													class="ni ni-archive-2"></i></span> <span class="btn-inner--text">Export
													CSV</span>
											</button>

								

	


										
											



										
										</div>
									</div>
									<div class="table-responsive" id="tbl_exporttable_to_xls_4">
										<table class="table table-flush" id="datatable-basic2">
											<thead class="thead-light">
												<tr>
													<th>Doctor id</th>
													<th>First Name</th>
													<th>E-mail</th>
													<th>Specialisation</th>
													<th>Venue</th>
													<th>Date</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<tr v-for="doctor in Doctors" :key="doctor.id">
													<td>
														<div class="d-flex align-items-center">

															<p class="text-xs font-weight-bold ms-2 mb-0">{{ doctor.id }}</p>
														</div>
													</td>
													<td class="font-weight-bold"><span
														class="my-2 text-xs">{{ doctor.firstName}}</span></td>
														<td class="font-weight-bold"><span
														class="my-2 text-xs">{{ doctor.email}}</span></td>
                            <td class="font-weight-bold"><span
														class="my-2 text-xs">{{ doctor.specializing}}</span></td>
													
													<td class="text-xs font-weight-bold"><span
														class="my-2 text-xs">{{ doctor.venue }}</span></td>
														<td class="text-xs font-weight-bold"><span
														class="my-2 text-xs">{{ doctor.edited }}</span></td>
														<td class="text-xs font-weight-bold p-0 pt-1">
  <button class="btn btn-outline-dark btn-xs p-1 mb-1 me-1" @click="deleteDoctors(doctor.id)">Remove</button>
	<router-link :to="{ name: 'docPro', params: { doctorid: doctor.id } }">
  <button class="btn btn-outline-dark btn-xs p-1 mb-1">View</button>
</router-link>

</td>


												</tr>
												
											</tbody>
										</table>
										<!-- modal of delivery starts -->
										<div class="modal fade " style="z-index: 99999;"
											id="modal-delivery" tabindex="-1" role="dialog"
											aria-labelledby="modal-form" aria-hidden="true">
											<div class="modal-dialog modal-dialog-centered modal-md"
												role="document">
												<div class="modal-content">
													<div class="modal-body p-0">
														<div class="card card-plain">
															<div class="card-header pb-0 text-left">
																<h4 class="font-weight-bolder  text-primary">Assign
																	Delivery Person</h4>
																<p class="mb-0">Enter Relevant Credentials</p>
															</div>
															<div class="card-body p-3">
																<form role="form text-left">
																	<label>Coupon Name</label>
																	<div class="input-group mb-3">
																		<input type="text" class="form-control"
																			placeholder="Email" aria-label="Email"
																			aria-describedby="email-addon"
																			onfocus="focused(this)" onfocusout="defocused(this)">
																	</div>
																	<label>Value</label>
																	<div class="input-group mb-3">
																		<input type="text" class="form-control"
																			placeholder="Password" aria-label="Password"
																			aria-describedby="password-addon"
																			onfocus="focused(this)" onfocusout="defocused(this)">
																	</div>

																	<div class=" row text-center">
																		<div class="col-6">
																			<button type="button" data-bs-dismiss="modal"
																				class="btn  bg-gradient-primary btn-md w-100 mt-2 mb-0">
																				Cancel</button>
																		</div>
																		<div class="col-6">
																			<button type="submit"
																				class="btn  btn-outline-primary btn-md w-100 mt-2 mb-0">Add</button>
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

import axios from 'axios';
import DoctorService from '../services/DoctorService';

export default {
  name: 'Doctorlist',

  data() {
    return {
      Doctors: [],
    };
  },

  methods: {
    getDoctors() {
      DoctorService.getDoctors()
        .then((response) => {
          this.Doctors = response.data;
        });
    },

    deleteDoctors(docid) {
      // Send a DELETE request to delete the patient using the same PatientService
      DoctorService.deleteDoctor(docid)
        .then((response) => {
          // Handle success (e.g., show a success message)
          console.log('Doctor deleted successfully:', response.data);

          // After deleting, update the Patiens array by removing the deleted patient
          this.Doctors = this.Doctors.filter((doctor) => doctor.docid !== docid);

          // Navigate to the desired route (if needed)
          this.$router.push({ name: 'Dman' });
        })
        .catch((error) => {
          // Handle errors (e.g., show an error message)
          console.error('Error deleting patient:', error);
        });
    },

    exportToCSV() {
      const Doctors = this.Doctors;

      // Create a worksheet and add data
      const ws = XLSX.utils.json_to_sheet(Doctors);

      // Create a new workbook and add the worksheet
      const wb = XLSX.utils.book_new();
      XLSX.utils.book_append_sheet(wb, ws, 'Doctors');

      // Save the workbook as a CSV file
      XLSX.writeFile(wb, 'Doctors.csv');
    },
  },

  created() {
    this.getDoctors();
  },
};
</script>
