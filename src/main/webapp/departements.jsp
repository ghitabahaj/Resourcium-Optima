
<section id="departements" class="ms-4">


    <h3  class="fw-bold mb-5 mycolor3" ><i class="uil uil-building me-2 fs-4" ></i>Departements</h3>
    <div class="w-100 d-flex justify-content-around m-3 align-items-center py-2 ">
        <div>
            <label for="">Search : </label>
            <input type="text" class="rounded border-0  px-4 ms-2" >
        </div>
    </div>

    <div class="d-flex justify-content-between">
        <p class="fs-5 ms-2 fw-bold" style="color: #183A37;"> All Departements</p>
        <button class="btn btn-dark rounded-pill" data-bs-toggle="modal" data-bs-target="#modal-dep" id="add-dep-btn"><i class="uil uil-plus text-white" ></i>&emsp; Add Departement</button>
    </div>

    <div class="card-body table-responsive mt-2" style="height: 60vh; overflow: hidden;">
        <table class="table border-secondary text-center table-hover ">
            <thead>
            <td class="mycolor fw-bold ">Departement Number</td>
            <td class="mycolor fw-bold">Departement Name</td>
            <td class="mycolor fw-bold">Description</td>
            <td class="mycolor fw-bold">Events</td>
            </thead>













    <!-- add departement -->
<div class="modal fade" id="modal-dep">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="save" method="POST" enctype="multipart/form-data">
                <div class="modal-header">
                    <h5 class="modal-title" id="add-title">Add New Departement</h5>
                    <a href="#" class="btn-close" data-bs-dismiss="modal"></a>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dep-id">
                    <div class="mb-3">
                        <label class="form-label">Departement Name</label>
                        <input type="text" name="name" class="form-control" id="name"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Description</label>
                        <input type="text" name="desc" class="form-control" id="description"/>
                    </div>

                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-light" data-bs-dismiss="modal">Cancel</a>
                    <button type="submit" name="saveDep" class="btn btn-primary" id="dep-save-btn">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>
</section>