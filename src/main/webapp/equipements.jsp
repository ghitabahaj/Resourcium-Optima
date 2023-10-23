<%@ page import="com.youcode.resourcium.Entities.Equipement" %>
<%@ page import="java.util.List" %>
<%@ page import="com.youcode.resourcium.Entities.Departement" %>


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
        <button class="btn btn-dark rounded-pill" data-bs-toggle="modal" data-bs-target="#modal-equ" id="add-equ-btn"><i class="uil uil-plus text-white" ></i>&emsp; Add Equipment</button>
    </div>

    <div class="card-body table-responsive mt-2" style="height: 60vh; overflow: hidden;">
        <table class="table border-secondary text-center table-hover ">
            <thead>
            <td class="mycolor fw-bold ">Equipment Number</td>
            <td class="mycolor fw-bold">Equipment Name</td>
            <td class="mycolor fw-bold">Status</td>
            <td class="mycolor fw-bold">Departement</td>
            <td class="mycolor fw-bold">Date Of Purchase</td>
            <td class="mycolor fw-bold">Events</td>
            </thead>
            <%
                List<Equipement> equipements = (List<Equipement>) request.getAttribute("equipements");
                for (Equipement e : equipements) {
            %>
            <tr>
                <td class="text-dark"><%= e.getId() %></td>
                <td class="text-dark"><%= e.getName() %></td>
                <td class="text-dark"><%= e.getState() %></td>
                <td class="text-dark"><%= e.getDepartment().getName() %></td>
                <td class="text-dark"><%= e.getDateOfPurchase() %></td>
                <td class="text-dark">
                    <button class="btn btn-warning text-white rounded-pill" data-bs-toggle="modal" data-bs-target="#reserve-equipment-modal" id="reserve-btn" onclick="setEquId('<%= e.getId() %>');" ><i class="text-white me-1 uil uil-pen"></i>Reserve Equipment</button>
                    <button class="btn btn-light rounded-pill" data-bs-toggle="modal" data-bs-target="#cancel-reserve"><i class="text-dark me-1 uil uil-eye"></i>Cancel Reservation</button>
                </td>
            </tr>
            <% } %>
        </table>
    </div>



    <!-- Modal for reserving equipment -->
    <div class="modal fade" id="reserve-equipment-modal" tabindex="-1" role="dialog" aria-labelledby="reserve-equipment-modal-label" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="reserve-equipment-modal-label">Reserve Equipment</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Form for reserving equipment -->
                    <form action="reserveEquipment" method="POST">
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="employeeId" name="employeeId" value="<%= request.getSession().getAttribute("id") %>
">
                        </div>
                        <div class="form-group">
                            <input type="hidden" class="form-control" id="equipmentId" name="equipmentId" value="">
                        </div>
                        <div class="d-flex align-items-center justify-content-center">
                            <i class="uil uil-exclamation-triangle fs-1 text-danger me-3"></i>
                            <p class="fw-bold pt-3">Are you sure that you want to reserve this Equipment?</p>
                        </div>
                        <!-- Add more form elements here as needed -->
                        <div class="d-flex justify-content-around w-75 m-auto">
                            <button type="button" class="btn btn-white" data-bs-dismiss="modal">Cancel</button>
                            <button type="submit" class="btn text-white bg-primary" id="delete-btn">reserve</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>



<%--    Add equipement--%>

    <div class="modal fade" id="modal-equ">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="addEquipment" method="POST">
                    <div class="modal-header">
                        <h5 class="modal-title" id="add-title">Add new Equipment</h5>
                        <a href="#" class="btn-close" data-bs-dismiss="modal"></a>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">Equipment's Name</label>
                            <input type="text" name="name-add" class="form-control" id="name"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Equipment's Status</label>
                            <input type="text" name="status-name" class="form-control"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Equipment's type</label>
                            <input type="text" name="type-add" class="form-control"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Equipment's Department</label>
                            <select class="form-select" name="dep-id" required>

                                <option id="dep_id_update" name="id-dep-up" value="" selected> </option>
                                <%
                                    List<Departement> Departements = (List<Departement>) request.getAttribute("departments");
                                    for (Departement dep : Departements) {
                                %>
                                <option value="<%= dep.getId()%>"><%= dep.getName()%></option>

                                <% } %>
                            </select>

                        </div>
                        <div class="mb-3">
                            <label class="form-label">Equipment's Password</label>
                            <input type="text" name="password-add" class="form-control"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-light" data-bs-dismiss="modal">Cancel</a>
                        <button type="submit" name="add-equipment" class="btn btn-primary text-white" >Add</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
