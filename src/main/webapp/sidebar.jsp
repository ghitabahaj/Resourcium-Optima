<div class="d-flex shadow-sm bg-light" id="wrapper">
    <div class="bg-white" id="sidebar-wrapper">
        <div class="sidebar-heading text-center d-flex flex-column py-4 fs-5 border-bottom mt-5">
            <div class="d-flex align-items-center">
                <img src="assets/img/user.png" width="40px" class="rounded-circle me-3">
                <div>
                    <p style="margin:-5px;" class="fs-6"> <%= request.getSession().getAttribute("username") %>!</p>
                    <p class="text-secondary fs-6"> admin123@gmail.com</p>
                </div>
            </div>
            <div>
                <a class="btn w-100 btn-light my-3 fs-6 mycolor3" > Log out</a>
                <form id="logout-form" action="" method="POST" class="d-none">
                </form>
            </div>
        </div>
        <form class="list-group list-group-flush">
            <button class="list-group-item list-group-item-action text-secondary "><i class="uil uil-chart-bar fs-4 p-2"></i><a class="text-secondary" style="text-decoration: none;" href="">Dashboard</a></button>
            <button class="list-group-item list-group-item-action text-success fw-bold"><i class=" me-2 fs-4 p-2 mycolor3"></i> <a class="mycolor3" style="text-decoration: none;" href="">Department</a></button>
            <button class="list-group-item list-group-item-action fw-bold "><i class=" me-2 fs-4 p-2 mycolor2"></i><a class="mycolor2" style="text-decoration: none; " href="">Equipements</a></button>
            <button class="list-group-item list-group-item-action fw-bold text-primary"><i class="uil uil-user-square me-2 fs-4 p-2 mycolor"></i><a class="mycolor" style="text-decoration: none;" href="">Update Account</a></button>
            <button class="list-group-item list-group-item-action fw-bold text-danger"><i class="uil uil-users-alt fs-4 me-2 p-2 mycolor1"></i><a class="mycolor1" style="text-decoration: none;" href="">Assign Roles</a></button>
        </form>
    </div>
    <div id="page-content-wrapper" style="height: 100vh; overflow: scroll; overflow-x: hidden;">
        <nav class="navbar navbar-expand-lg navbar-light bg-transparent p-4 pt-1 justify-content-between">
            <div class="d-flex align-items-center">
                <i class="fas fa-align-left  fs-2 mt-3" id="menu-toggle"></i>
            </div>
            <div class="d-flex align-items-center ms-auto">
                <div class="pt-3 me-3">
                    <p class="fs-6 text-secondary" style="margin-bottom: -5px;">Today's date</p>
                    <p class="fs-6 text-black fw-bold ms-1" id="current-date"></p>
                </div>
                <i class="uil uil-calendar-alt fs-2 mt-1 box rounded p-2"></i>
            </div>
        </nav>
    </div>
</div>
