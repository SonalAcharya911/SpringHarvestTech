<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>
        Online Auction
    </title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
    html, body {
           height: 100%;
           margin: 0;
       }
       body {
           display: flex;
           flex-direction: column;
       }
       .content {
           flex: 1;
       }
        footer {
            position: ;
            bottom: 0;
            width: 100%;
        }
</style>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

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
                    <a class="nav-link active"  href="redirectToIndex">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="redirectToMemberRegistrationForm">Register</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<center>
    <div class="container mt-4">
        <h3>Welcome to the Online Auction!</h3>
        <p>Bid, win, and make every purchase count.</p>
    </div>
    <div class="text-center mt-3">
        <a href="redirectToLogin" class="btn btn-primary">Login</a>
    </div>
    <a href="EmailVerification.jsp">Verify Email</a>

</center>



<footer class="bg-dark text-white text-center py-3"
        style="position: fixed; bottom: 0; left: 0; width: 100%;">
    <p class="mb-0">"Every bid tells a story, and every win finds a new home."</p>
    <small>&copy; 2025 Online Auction Platform</small>
</footer>

</body>
</html>
