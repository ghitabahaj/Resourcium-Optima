<%@ page import="com.youcode.resourcium.Entities.Departement" %>
<%@ page import="java.util.List" %>


<section id="departements" class="ms-4">


    <h3  class="fw-bold mb-5 mycolor3" ><i class="uil uil-building me-2 fs-4" ></i>Departements</h3>
    <div class="w-100 d-flex justify-content-around m-3 align-items-center py-2 ">
        <div>
            <label >Search : </label>
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

                <%
            List<Departement> Departements = (List<Departement>) request.getAttribute("departments");
            for (Departement dep : Departements) {
              %>

            <tr>
                <td class="text-dark"><%= dep.getId() + 1 %></td>
                <td class="text-dark"><%= dep.getName() %></td>
                <td class="text-dark"><%= dep.getDescription() %></td>
                <td class="text-dark">
                    <button class="btn btn-warning text-white rounded-pill" data-bs-toggle="modal" data-bs-target="#update-dep" id="update-btn" onclick="redirectToUpdate(<%= dep.getId() %>)"><i class="text-white me-1 uil uil-pen"></i>Edit</button>
                    <button class="btn btn-light rounded-pill" data-bs-toggle="modal" data-bs-target="#view-dep"><i class="text-dark me-1 uil uil-eye"></i>view</button>
                    <button class="btn btn-danger rounded-pill" data-bs-toggle="modal" data-bs-target="#remove-dep" id="remove-btn"><i class="text-white me-1 uil uil-trash"></i>remove</button>
                </td>
            </tr>

                <% } %>

    <!-- add departement -->
<div class="modal fade" id="modal-dep">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="saveDep" method="POST" >
                <div class="modal-header">
                    <h5 class="modal-title" id="add-title">Add New Departement</h5>
                    <a href="#" class="btn-close" data-bs-dismiss="modal"></a>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="dep-id">
                    <div class="mb-3">
                        <label class="form-label">Departement Name</label>
                        <input type="text" name="nameDep" class="form-control" id="name"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Description</label>
                        <input type="text" name="descDep" class="form-control" id="description"/>
                    </div>

                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-light" data-bs-dismiss="modal">Cancel</a>
                    <button type="submit" name="saveDepartment" class="btn btn-primary" id="dep-save-btn">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>

            <!-- update departement -->

            <div class="modal fade" id="update-dep">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="" method="POST" enctype="multipart/form-data" >
                            <div class="modal-header">
                                <h5 class="modal-title">Update Department</h5>
                                <a href="#" class="btn-close" data-bs-dismiss="modal"></a>
                            </div>
                            <div class="modal-body">
                                <input type="hidden" id="depa-id">
                                <div class="mb-3">
                                    <label class="form-label">Department Name</label>
                                    <input type="text" name="name" class="form-control" id="name-dep" value=""/>
                                </div>
                                <div class="mb-3">
                                    <label class="form-label">Departement Description </label>
                                    <input type="text" name="name" class="form-control" id="desc-dep" value=""/>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <a href="#" class="btn btn-light" data-bs-dismiss="modal">Cancel</a>
                                <button type="submit" name="UpdateDep" class="btn btn-warning text-white" id="dep-update-btn">Update</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </table>
    </div>
</section>



            <!-- remove departement -->
            <div class="modal fade" id="remove-dep">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form action="" class="p-3">
                            <div class="d-flex align-items-center justify-content-center">
                                <i class="uil uil-exclamation-triangle fs-1 text-danger me-3"></i>
                                <p class="fw-bold pt-3">Are you sure that you want to remove this Department?</p>
                            </div>
                            <div class="d-flex justify-content-around w-75 m-auto">
                                <button type="submit" class="btn btn-white" data-bs-dismiss="modal">Cancel</button>
                                <button type="submit" class="btn text-white bg-danger" id="delete-btn"><a style=" text-decoration: none; color:white "  href="">remove</a></button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>


<!-- view pharmacy info -->

<div class="modal fade" id="view-dep">
    <div class="modal-dialog">
        <div class="d-flex justify-content-around align-items-center bg-white p-3 rounded">
            <div >
                <img class="rounded-circle" src="assets/img/dep.jpg" width="100px" height="100px">
            </div>
            <div>
                <p>Department Name : <span class="fw-bold"></span></p>
                <p>Description : <span class="fw-bold"></span></p>
            </div>
            <div>
                <p>Head Of Department: <span class="fw-bold"></span></p>
                <p>Number Phone : <span class="fw-bold"></span></p>
            </div>
        </div>
    </div>
</div>
