<%@ page import="com.youcode.resourcium.Entities.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.youcode.resourcium.Entities.Departement" %>
<%@ page import="com.youcode.resourcium.Entities.Tache" %>
<section id="users" class="container-fluid">

    <h3  class="fw-bold mb-5 mycolor2" ><i class="uil uil-users-alt me-2 fs-4" ></i>Employees</h3>
    <div class="w-100 d-flex justify-content-around m-3 align-items-center py-2 ">
        <div>
            <label >Search : </label>
            <input type="text" class="rounded border-0  px-4 ms-2" >
        </div>
    </div>

    <div class="d-flex justify-content-between">
        <p class="fs-5 ms-2 fw-bold">All Employees(<%= ((List<User>) request.getAttribute("employees")).size() %>)</p>
        <button class="btn btn-dark rounded-pill" data-bs-toggle="modal" data-bs-target="#modal-emp" id="add-emp-btn"><i class="uil uil-plus text-white" ></i>&emsp; Add Employee</button>
    </div>
    <div class="card-body table-responsive mt-2" style="height: 60vh; overflow: hidden;">
        <table class="table border-secondary text-center table-hover ">
            <thead>
            <td class="mycolor fw-bold ">Employee's Username</td>
            <td class="mycolor fw-bold ">Employee's First Name</td>
            <td class="mycolor fw-bold">Employee's Last Name </td>
            <td class="mycolor fw-bold">Employee's Email</td>
            <td class="mycolor fw-bold">Employee's Number Phone</td>
            <td class="mycolor fw-bold">Employee's Department</td>
            <td class="mycolor fw-bold">Employee's Reservations</td>
            <td class="mycolor fw-bold">Events</td>
            </thead>
            <%
                List<User> Employees = (List<User>) request.getAttribute("employees");
                for (User emp : Employees) {
            %>
            <tr>
                <td class="text-dark"><%= emp.getUsername() %></td>
                <td class="text-dark"><%= emp.getFirstName() %></td>
                <td class="text-dark"><%= emp.getLastName() %></td>
                <td class="text-dark"><%= emp.getEmail() %></td>
                <td class="text-dark"><%= emp.getNumberPhone() %></td>
                <td class="text-dark"><%= emp.getDepartement() != null ? emp.getDepartement().getName() : "No Departemnt" %></td>
                <td class="text-dark">0</td>
                <td class="text-dark">
                    <button class="btn btn-warning text-white rounded-pill" data-bs-toggle="modal" data-bs-target="#update-user" id="update-btn" onclick="setAttributesEmp(`<%= emp.getId()%>`, `<%= emp.getFirstName()%>`, `<%= emp.getLastName()%>`, `<%= emp.getUsername()%>`, `<%= emp.getEmail()%>`, `<%= emp.getNumberPhone()%>`, `<%= emp.getDepartement().getId()%>`)"><i class="text-white me-1 uil uil-pen"></i>Edit</button>
                    <button class="btn btn-primary text-white rounded-pill" data-bs-toggle="modal" data-bs-target="#assign-task-modal" onclick="setIdTask('<%= emp.getId()%>')"><i class="text-white me-1 uil uil-pen"></i>Assign Task(s)</button>
                    <button class="btn btn-danger rounded-pill" data-bs-toggle="modal" data-bs-target="#remove-Employee" id="remove-btn" onclick="setEmpId(<%= emp.getId() %>)"><i class="text-white me-1 uil uil-trash"></i>remove</button>
                    <button class="btn btn-light rounded-pill" data-bs-toggle="modal" data-bs-target="#view-tasks" id="view-btn" onclick="setEmpIdView(<%= emp.getId() %>)"><i class="text-dark me-1 uil uil-eye"></i>Tasks Information</button>
                </td>
            </tr>
            <% } %>
        </table>
    </div>

    <!-- remove user -->

<div class="modal fade" id="remove-Employee">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="removeUser"  method="POST" class="p-3">
                <input type="hidden" id="EmpId" name="EmpId" value="" />
                <div class="d-flex align-items-center justify-content-center">
                    <i class="uil uil-exclamation-triangle fs-1 text-danger me-3"></i>
                    <p class="fw-bold pt-3">Are you sure that you want to remove this<span class="text-danger"> Employee</span>?</p>
                </div>
                <div class="d-flex justify-content-around w-75 m-auto">
                    <button type="button" class="btn btn-white" data-bs-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn text-white bg-danger" id="delete-btn">remove</button>
                </div>
            </form>
        </div>
    </div>
</div>

    <!-- add user -->

<div class="modal fade" id="modal-emp">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="addEmployee" method="POST">
                <div class="modal-header">
                    <h5 class="modal-title" id="add-title">Add new Employee</h5>
                    <a href="#" class="btn-close" data-bs-dismiss="modal"></a>
                </div>
                <div class="modal-body">
                    <div class="mb-3">
                        <label class="form-label">Employee's First Name</label>
                        <input type="text" name="first-name" class="form-control" id="name"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Employee's Last Name</label>
                        <input type="text" name="last-name" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Employee's Username</label>
                        <input type="text" name="username-add" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Employee's Phone Number</label>
                        <input type="text" name="phone-add" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Employee's Department</label>
                        <select class="form-select" name="dep_id" required>
                            <option value="">SELECT THE EMPLOYEE'S DEPARTMENT</option>
                            <%
                                List<Departement> departments = (List<Departement>) request.getAttribute("departments");
                                for (Departement dep : departments) {
                            %>
                            <option value="<%= dep.getId()%>"><%= dep.getName()%></option>
                            <% } %>
                        </select>

                    </div>
                    <div class="mb-3">
                        <label class="form-label">Employee's email</label>
                        <input type="text" name="email-add" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Employee's Password</label>
                        <input type="text" name="password-add" class="form-control"/>
                    </div>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-light" data-bs-dismiss="modal">Cancel</a>
                    <button type="submit" name="add-employee" class="btn btn-primary text-white" >Add</button>
                </div>
            </form>
        </div>
    </div>
</div>


    <!-- update user -->

    <div class="modal fade" id="update-user">
        <div class="modal-dialog">
            <div class="modal-content">
                <form action="updateEmployee" method="POST">
                    <input type="hidden" id="UpdateId" name="EmpIdUpdate" value="" />
                    <div class="modal-header">
                        <h5 class="modal-title">Update Existing Employee</h5>
                        <a href="#" class="btn-close" data-bs-dismiss="modal"></a>
                    </div>
                    <div class="modal-body">
                        <div class="mb-3">
                            <label class="form-label">Employee's First Name</label>
                            <input type="text" name="first-name-update" class="form-control" id="updateFName" value=""/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Employee's Last Name</label>
                            <input type="text" name="last-name-update" id="updateLName" class="form-control" value=""/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Employee's Username</label>
                            <input type="text" name="username-update" id="updateUsername"  class="form-control" value=""/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Employee's Department</label>

                            <select class="form-select" id="dep-id" name="dep-id" required>

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
                            <label class="form-label">Employee's number Phone</label>
                            <input type="text" name="number-update" id="Update-number" class="form-control" value=""/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Employee's email</label>
                            <input type="text" name="email-update" id="UpdateEmail" class="form-control" value=""/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Employee's Password</label>
                            <input type="password" id="password_update" name="password-update" class="form-control" disabled/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-light" data-bs-dismiss="modal">Cancel</a>
                        <button type="submit" name="update-employee" class="btn btn-warning text-white" >Update</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <%-- Assign Task  --%>

    <!-- Modal for Assigning Task to Employee -->
    <div class="modal fade" id="assign-task-modal" tabindex="-1" role="dialog" aria-labelledby="assign-task-modal-label" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="assign-task-modal-label">Assign Task to Employee</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Add form elements here for assigning the task to the employee -->
                    <form action="assignTaskToEmployee" method="POST">
                        <input type="hidden" id="AssignId" name="assignTask" value="" />

                        <div class="form-group">
                            <label for="task-title">Task Title:</label>
                            <input type="text" class="form-control" id="task-title" name="task-title">
                        </div>
                        <div class="form-group">
                            <label for="task-description">Task Description:</label>
                            <input type="text" class="form-control" id="task-description" name="task-description">
                        </div>
                        <div class="form-group">
                            <label for="task-status">Task Status:</label>
                            <select class="form-control" id="task-status" name="task-status">
                                <option value="pending">Pending</option>
                                <option value="in_progress">In Progress</option>
                                <option value="completed">Completed</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="task-deadline">Task Deadline:</label>
                            <input type="date" class="form-control" id="task-deadline" name="task-deadline">
                        </div>
                        <div class="form-group">
                            <label for="task-priority">Task Priority:</label>
                            <select class="form-control" id="task-priority" name="task-priority">
                                <option value="low">Low</option>
                                <option value="medium">Medium</option>
                                <option value="high">High</option>
                            </select>
                        </div>
                        <!-- Add more form elements here as needed -->
                        <div class="form-group">
                            <label for="employee-id">Employee ID:</label>
                            <input type="text" class="form-control" id="employee-id" name="employee-id">
                        </div>
                        <button type="submit" class="btn btn-primary">Assign Task</button>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>


    <div class="modal fade" id="view-tasks" tabindex="-1" role="dialog" aria-labelledby="assign-task-modal-label" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <!-- Add form elements here for assigning the task to the employee -->

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>





</section>
