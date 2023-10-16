<script>
import ChartCompo from "./ChartCompo.vue";
import GraphCompo from "./GraphCompo.vue";

export default {
  components: {
    ChartCompo,
    GraphCompo,
  },
};
</script>
<template>
  
  <div className="body-wrapper ">
    
    <div className="container-fluid pt-4 pb-0">
      <div class="row">
        <!-- Earnings (Monthly) Card Example -->
        <div class="col-xl-3 col-md-6 mb-4">
          <div class="card border-left-primary shadow-sm h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div
                    class="text-xs font-weight-bold text-primary text-uppercase mb-1"
                  >
                    Patient Count
                  </div>
                  <div class="h5 mb-0 font-weight-bold text-gray-800">
                    40,000
                  </div>
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
          <div class="card border-left-success shadow-sm h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div
                    class="text-xs font-weight-bold text-success text-uppercase mb-1"
                  >
                    Inquaries
                  </div>
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
          <div class="card border-left-info shadow-sm h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div
                    class="text-xs font-weight-bold text-info text-uppercase mb-1"
                  >
                    Tasks
                  </div>
                  <div class="row no-gutters align-items-center">
                    <div class="col-auto">
                      <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">
                        50%
                      </div>
                    </div>
                    <div class="col">
                      <div class="progress progress-sm mr-2">
                        <div
                          class="progress-bar bg-info"
                          role="progressbar"
                          style="width: 50%"
                          aria-valuenow="50"
                          aria-valuemin="0"
                          aria-valuemax="100"
                        ></div>
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
          <div class="card border-left-warning shadow-sm h-100 py-2">
            <div class="card-body">
              <div class="row no-gutters align-items-center">
                <div class="col mr-2">
                  <div
                    class="text-xs font-weight-bold text-warning text-uppercase mb-1"
                  >
                    Pending Requests
                  </div>
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
      <div className="row">
        <div className="col-lg-8 d-flex align-items-strech">
          <div className="card w-100">
            <div className="card-body">
              <div
                className="d-sm-flex d-block align-items-center justify-content-between mb-9"
              >
                <div className="mb-3 mb-sm-0">
                  <h5 className="card-title fw-semibold">Patient Overview</h5>
                </div>
                <div>
                  <select className="form-select">
                    <option value="1">March 2023</option>
                    <option value="2">April 2023</option>
                    <option value="3">May 2023</option>
                    <option value="4">June 2023</option>
                  </select>
                </div>
              </div>
              <ChartCompo />
            </div>
          </div>
        </div>

        <div className="col-lg-4 d-flex align-items-strech">
          <div className="card w-100">
            <div className="card-body">
              <div
                className="d-sm-flex d-block align-items-center justify-content-between mb-9"
              >
                <div className="mb-3 mb-sm-0">
                  <h5 className="card-title fw-semibold">Doctor Overview</h5>
                </div>
                <div>
                  <select className="form-select">
                    <option value="1">March 2023</option>
                    <option value="2">April 2023</option>
                    <option value="3">May 2023</option>
                    <option value="4">June 2023</option>
                  </select>
                </div>
              </div>
              <GraphCompo />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
