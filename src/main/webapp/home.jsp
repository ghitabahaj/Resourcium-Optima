<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*,javax.servlet.*" %>
<%

    if (session == null || session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }

       String ThePage = (String) request.getAttribute("url");
%>
<html>
<head>
    <title>Resourcium Optima | DashBoard</title>
    <link rel="dns-prefetch" href="//fonts.gstatic.com">
    <link href="https://fonts.bunny.net/css?family=Nunito" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css" rel="stylesheet"/>
    <link href="css/dash.css" rel="stylesheet" />
</head>

<body style="
    width: 100vw;
    height: 100vh;
">

<div id="app" class="w-100 h-100">
    <div class="d-flex shadow-sm bg-light d-flex w-100 h-100" id="wrapper">
        <jsp:include page="sidebar.jsp" />
        <div id="page-content-wrapper" style="height: 100vh; overflow-y: scroll; overflow-x: hidden; flex:1;">
            <jsp:include page="navbar.jsp" />
            <% if(ThePage != null && ThePage.equals("dashboard")) { %>
            <jsp:include page="top.jsp" />
            <%} else if(ThePage != null && ThePage.equals("departements")){%>
            <jsp:include page="departements.jsp" />
            <%} else if(ThePage != null && ThePage.equals("UpdateAccount")){%>
            <jsp:include page="UpdateAccount.jsp" />
            <%} else if(ThePage != null && ThePage.equals("users")){%>
            <jsp:include page="users.jsp" />
            <%} else if(ThePage != null && ThePage.equals("equipements")){%>
            <jsp:include page="equipements.jsp" />
            <%} else{ %>
            <jsp:include page="top.jsp" />
            <%} %>
        </div>
    </div>

</div>

</body>

<script src="js/scripts.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<script>
        function setDepId(id) {
            document.getElementById('depId').value = id;
        }
        function setEmpId(id) {
            document.getElementById('EmpId').value = id;
        }

        function getAttributes(id,name,desc){
            document.getElementById('depa-id').value = id;
            document.getElementById('name-dep').value = name;
            document.getElementById('desc-dep').value = desc;
        }


        function setAttributesEmp(id,first,last,username,email,number,departement){
            document.getElementById('UpdateId').value = id ;
            document.getElementById('updateFName').value = first;
            document.getElementById('updateLName').value =last ;
            document.getElementById('updateUsername').value = username;
            document.getElementById('UpdateEmail').value = email;
            document.getElementById('Update-number').value = number;
            document.getElementById('password_update').value = "password";
            document.getElementById('dep-id').value = departement;
        }

        function setIdTask(id){
            document.getElementById('AssignId').value = id;
        }
        function setEmpIdView(id){
            document.getElementById('employeeId').value = id;
        }

        function setEquId(id){
            document.getElementById('equipmentId').value = id ;
        }

        function ChangeEmail(id,email,first,last,username){
            document.getElementById('UpdateAccountId').value = id ;
            document.getElementById('UpdateAccountFirst').value = first ;
            document.getElementById('UpdateAccountLast').value = last ;
            document.getElementById('UpdateAccountEmail').value = email ;
            document.getElementById('UpdateAccountUsername').value = username ;
        }

        function myFunction1() {
            var x = document.getElementById("myInput");

            if (x.type === "password" ) {
                x.type = "text";
            } else {
                x.type = "password";
            }
        }

        function myFunction2() {
            var y = document.getElementById("myInput1");

            if (y.type === "password" ) {
                y.type = "text";
            } else {
                y.type = "password";
            }
        }

        function myFunction3() {
            var z = document.getElementById("confirm_password");

            if (z.type === "password" ) {
                z.type = "text";
            } else {
                z.type = "password";
            }
        }

        $('#confirm_password').on('keyup', function() {
            checkPassword();
        });

        function checkPassword() {
            var newPassword = $('#myInput1').val();
            var confirmPassword = $('#confirm_password').val();
            if (newPassword !== confirmPassword) {
                $('#error').html('Passwords do not match');
                $('#pass-update-btn').attr('disabled', true);
            } else {
                $('#error').html('');
                $('#pass-update-btn').attr('disabled', false);
            }
        }

</script>

</html>
