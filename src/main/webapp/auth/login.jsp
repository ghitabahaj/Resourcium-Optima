<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resourcium Optima | Login </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container h-100 mt-5" >
    <div class="row justify-content-center">
         <div class="card col-lg-5  col-md-6 col-11 m-auto shadow rounded py-4">
            <div class="w-100 my-3 mb-5">
                <h3 class="text-center">Welcome Back</h3>
                <p class="text-center text-secondary">login with your details to continue</p>
            </div>
            <form action="login" method="post">
                <div class="d-flex flex-column my-3 col-9 m-auto">
                    <label class="mb-2">Your Username</label>
                    <input type="text" name="username" class="form-control" placeholder="Enter Your UserName">
                </div>
                <div class="d-flex flex-column my-3 col-9 m-auto">
                    <label class="mb-2">Your Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter Your Password">
                </div>


                <div class="row mb-0">
                    <div class="text-center">
                        <button type="submit" style="width: 45%;" class="my-2 mb-4 text-center  border-0 rounded  py-1 m-auto btn btn-primary">
                           login
                        </button>
                        <button type="submit" style="width: 45%;" class="my-2 mb-4 text-center rounded py-1  m-auto btn btn-success text-white">
                            <a class="nav-link" >Register</a>
                        </button>

                        <a class="btn btn-link d-block text-center">
                            Forget password?
                        </a>

                    </div>
                </div>
            </form>
            </form>
        </div>
    </div>
</div>
</body>
</html>

