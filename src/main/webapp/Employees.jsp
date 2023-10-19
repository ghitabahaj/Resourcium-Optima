<section id="users" class="container-fluid">

    <h3  class="fw-bold mb-5" style="color: #007A69;"><i class="uil uil-users-alt me-2 fs-4" ></i>Employees</h3>
    <div class="w-100 d-flex justify-content-around m-3 align-items-center py-2 ">
        <div>
            <label >Search : </label>
            <input type="text" class="rounded border-0  px-4 ms-2" >
        </div>
    </div>

    <div class="d-flex justify-content-between">
        <p class="fs-5 ms-2 fw-bold">All Employees</p>
    </div>
    <form class="card-body table-responsive mt-2" style="height: 60vh; overflow: scroll;">
        <table class="table border-secondary text-center table-hover ">
            <thead>
            <td class="mycolor fw-bold ">Employee's First Name</td>
            <td class="mycolor fw-bold">Employee's Last Name </td>
            <td class="mycolor fw-bold">Employee's Email</td>
            <td class="mycolor fw-bold">Employee's Number Phone</td>
            <td class="mycolor fw-bold">Employee's Department</td>
            <td class="mycolor fw-bold">Employee's Reservations</td>
            <td class="mycolor fw-bold">Events</td>
            </thead>

            <tr>
                <td class="text-dark"></td>
                <td class="text-dark"></td>
                <td class="text-dark"></td>
                <td class="text-dark"></td>
                <td class="text-dark"></td>
                <td class="text-dark"></td>
                <td class="text-dark">
                    <button class="btn btn-warning text-white rounded-pill" data-bs-toggle="modal" data-bs-target="#update-user-role"><i class="text-white me-1 uil uil-pen"></i>Edit</button>
                    <button class="btn btn-primary text-white rounded-pill" data-bs-toggle="modal" data-bs-target="#assign-task"><i class="text-white me-1 uil uil-pen"></i>Assign Task(s)</button>
                    <button class="btn btn-danger rounded-pill" data-bs-toggle="modal" data-bs-target="#remove-user"><i class="text-white me-1 uil uil-trash"></i>remove</button>
                </td>
            </tr>
            </table>
            </form>

    <!-- remove user -->

    <div class="modal fade" id="remove-user">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="" class="p-3">
                    <div class="d-flex align-items-center justify-content-center">
                        <i class="uil uil-exclamation-triangle fs-1 text-danger me-3"></i>
                        <p class="fw-bold pt-3">Are you sure that you want to remove this <span class="text-danger">Employee</span>?</p>
                    </div>
                    <div class="d-flex justify-content-around w-75 m-auto">
                        <button type="submit" class="btn btn-white" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn text-white bg-danger" id="session-save-btn"><a style=" text-decoration: none; color:white "  href="">remove</a></button>
                    </div>
                </form>
            </div>
        </div>
    </div>


    <!-- update user -->



</section>