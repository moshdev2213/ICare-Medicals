<template>
    <div className="body-wrapper ">
      <div className="container-fluid pt-4 pb-0">
      <div className="row">
          <div className="col-lg-12 d-flex align-items-stretch">
          <div className="card w-100">
              <div className="card-body p-3">
                <div className="mt-3 d-flex justify-content-between align-items-baseline ">
                  <h5 className="card-title fw-semibold mb-4">Transactions</h5>
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
</template>