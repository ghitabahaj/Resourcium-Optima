<%@ page import="com.youcode.resourcium.Entities.Equipement" %>
<%@ page import="java.util.List" %>


<section id="equipements" class="ms-4">


    <h3  class="fw-bold mb-5 mycolor3" ><i class="uil uil-building me-2 fs-4" ></i>Equipments</h3>
    <div class="w-100 d-flex justify-content-around m-3 align-items-center py-2 ">
        <div>
            <label >Search : </label>
            <input type="text" class="rounded border-0  px-4 ms-2" >
        </div>
    </div>

    <div class="d-flex justify-content-between">
        <p class="fs-5 ms-2 fw-bold" style="color: #183A37;"> All Equipments </p>
        <button class="btn btn-dark rounded-pill" data-bs-toggle="modal" data-bs-target="#modal-dep" id="add-dep-btn"><i class="uil uil-plus text-white" ></i>&emsp; Add Equipment</button>
    </div>

    <div class="card-body table-responsive mt-2" style="height: 60vh; overflow: hidden;">
        <table class="table border-secondary text-center table-hover ">
            <thead>
            <td class="mycolor fw-bold ">Equipment Number</td>
            <td class="mycolor fw-bold">Equipment Name</td>
            <td class="mycolor fw-bold">Status</td>
            <td class="mycolor fw-bold">Events</td>
            </thead>

            <tr>
                <td class="text-dark"></td>
                <td class="text-dark"></td>
                <td class="text-dark"></td>
                <td class="text-dark">
                    <button class="btn btn-warning text-white rounded-pill" data-bs-toggle="modal" data-bs-target="#reserve-equi" id="reserve-btn" ><i class="text-white me-1 uil uil-pen"></i>Reserve Equipment</button>
                    <button class="btn btn-light rounded-pill" data-bs-toggle="modal" data-bs-target="#cancel-reserve"><i class="text-dark me-1 uil uil-eye"></i>Cancel Reservation</button>
                </td>
            </tr>
        </table>
    </div>
</section>
