<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Login - Online Auction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          crossorigin="anonymous">
    <style>
        body {
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        .content {
            flex: 1;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 30px 0;
        }
        footer {
            background-color: #212529;
            color: white;
            text-align: center;
            padding: 10px;
        }
        .error-msg {
            color: red;
            font-size: 0.85em;
        }
    </style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="redirectToIndex">
            <img src="<c:url value='/images/xworkz_logo.png'/>"
                 alt="Logo"
                 style="max-height: 60px;">
        </a>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" href="redirectToIndex">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="redirectToMemberRegistrationForm">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="redirectToLoginForm">Login</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Content -->
<div class="content">
    <div class="card shadow-lg" style="width: 400px;">
        <div class="card-header bg-primary text-white text-center">
            <h4>Email Verification</h4>
        </div>
        <div class="card-body">
            <form action="verify" method="post" onsubmit="return validateLogin();">

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" onchange="loginemail()" id="email" name="email" class="form-control" value="${dto.email}">
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control">
                    <div id="passwordError" class="error-msg"></div>
                </div>

                <div class="text-center">
                    <button type="submit" id="loginBtn" class="btn btn-primary">Login</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Footer -->
<footer>
    <p class="mb-0">"Every bid tells a story, and every win finds a new home."</p>
    <small>&copy; 2025 Online Auction Platform</small>
</footer>

<script>
    function loginemail(){
        const email=document.getElementById('email').value;
        if(email!==""){
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET","http://localhost:8080/online-auction-app/loginemail?email="+email);
            xhttp.send();

            xhttp.onload = function(){
                document.getElementById("emailerror").innerHTML=this.responseText;
            }
        }
    }
</script>
</body>
</html>
