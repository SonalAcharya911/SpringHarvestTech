<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Online Auction</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
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
        .valid {
            border: 2px solid green !important;
        }
        .invalid {
            border: 2px solid red !important;
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
                    <a class="nav-link active"  href="redirectToIndex">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="redirectToMemberRegistrationForm">Register</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- Content -->
<div class="content">
    <div class="card shadow-lg" style="width: 500px;">
        <div class="card-header bg-primary text-white text-center">
            <h4>Member Registration</h4>
        </div>
        ${message}
        <div class="card-body">
            <form action="save" method="post" onsubmit="return validateForm();">

                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" id="name" name="name" class="form-control">
                    <div id="nameError" class="error-msg"></div>

                </div>

                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" id="email" name="email" class="form-control" onchange="checkEmail()">
                    <div id="emailError" class="error-msg"></div>
                    <span id="emailerr" style="color: red"></span>
                </div>

                <div class="mb-3">
                    <label for="contact" class="form-label">Contact</label>
                    <input type="number" id="contact" name="contact" class="form-control" onchange="checkContact()">
                    <div id="contactError" class="error-msg"></div>
                </div>

                <div class="mb-3">
                    <label for="dob" class="form-label">Date of Birth</label>
                    <input type="date" id="dob" name="dob" class="form-control">
                    <div id="dobError" class="error-msg"></div>
                </div>

                <div class="mb-3">
                    <label for="gender" class="form-label">Gender</label>
                    <select id="gender" name="gender" class="form-select">
                        <option value="">--Select--</option>
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                        <option value="Other">Other</option>
                    </select>
                    <div id="genderError" class="error-msg"></div>
                </div>

                <div class="mb-3">
                    <label for="state" class="form-label">State</label>
                    <select id="state" name="state" class="form-select">
                        <option value="">--Select State--</option>
                        <option value="Karnataka">Karnataka</option>
                        <option value="Maharashtra">Maharashtra</option>
                        <option value="Tamil Nadu">Tamil Nadu</option>
                        <option value="Kerala">Kerala</option>
                        <option value="Andhra Pradesh">Andhra Pradesh</option>
                        <option value="Telangana">Telangana</option>
                        <option value="Gujarat">Gujarat</option>
                        <option value="Rajasthan">Rajasthan</option>
                        <option value="Uttar Pradesh">Uttar Pradesh</option>
                        <option value="West Bengal">West Bengal</option>
                    </select>
                    <div id="stateError" class="error-msg"></div>
                </div>

                <div class="mb-3">
                    <label for="address" class="form-label">Address</label>
                    <textarea id="address" name="address" rows="3" class="form-control"></textarea>
                    <div id="addressError" class="error-msg"></div>
                </div>

                <div class="mb-3">
                    <label for="password" class="form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control">
                    <div id="passwordError" class="error-msg"></div>
                </div>

                <div class="mb-3">
                    <label for="confirmPassword" class="form-label">Confirm Password</label>
                    <input type="password" id="confirmPassword" name="confirmPassword" class="form-control">
                    <div id="confirmPasswordError" class="error-msg"></div>
                </div>

                <div class="text-center">
                    <button type="submit" id="registerBtn" class="btn btn-success" disabled>Register</button>
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
        function validateName() {
            let name = document.getElementById("name");
            if (name.value.trim().length < 3) {
                setError(name, "Name must be at least 3 characters", "nameError");
                return false;
            } else {
                setSuccess(name, "nameError");
                return true;
            }
        }

        function validateEmail() {
            let email = document.getElementById("email");
            if (!email.value.includes("@")) {
                setError(email, "Email must contain @ symbol", "emailError");
                return false;
            } else {
                setSuccess(email, "emailError");
                return true;
            }
        }

        function validateContact() {
            let contact = document.getElementById("contact");
            let contactRegex = /^[6-9]\d{9}$/;
            if (!contactRegex.test(contact.value)) {
                setError(contact, "Enter a valid 10-digit number starting with 6,7,8,9", "contactError");
                return false;
            } else {
                setSuccess(contact, "contactError");
                return true;
            }
        }

        function validateDob() {
            let dob = document.getElementById("dob");
            if (!dob.value) {
                setError(dob, "Date of Birth is required", "dobError");
                return false;
            } else {
                setSuccess(dob, "dobError");
                return true;
            }
        }

        function validateGender() {
            let gender = document.getElementById("gender");
            if (!gender.value) {
                setError(gender, "Please select gender", "genderError");
                return false;
            } else {
                setSuccess(gender, "genderError");
                return true;
            }
        }

        function validateState() {
            let state = document.getElementById("state");
            if (!state.value) {
                setError(state, "Please select state", "stateError");
                return false;
            } else {
                setSuccess(state, "stateError");
                return true;
            }
        }

        function validateAddress() {
            let address = document.getElementById("address");
            if (address.value.trim() === "") {
                setError(address, "Address cannot be empty", "addressError");
                return false;
            } else {
                setSuccess(address, "addressError");
                return true;
            }
        }

        function validatePassword() {
            let password = document.getElementById("password");
            let passwordRegex = /^(?=.*[A-Z])(?=.*[\W_]).{8,15}$/;
            if (!passwordRegex.test(password.value)) {
                setError(password, "Password must be 8-15 chars, 1 uppercase & 1 symbol", "passwordError");
                return false;
            } else {
                setSuccess(password, "passwordError");
                return true;
            }
        }

        function validateConfirmPassword() {
            let password = document.getElementById("password");
            let confirmPassword = document.getElementById("confirmPassword");
            if (confirmPassword.value !== password.value || confirmPassword.value === "") {
                setError(confirmPassword, "Passwords do not match", "confirmPasswordError");
                return false;
            } else {
                setSuccess(confirmPassword, "confirmPasswordError");
                return true;
            }
        }

        function setError(element, message, errorId) {
            element.classList.add("invalid");
            element.classList.remove("valid");
            document.getElementById(errorId).innerText = message;
        }

        function setSuccess(element, errorId) {
            element.classList.add("valid");
            element.classList.remove("invalid");
            document.getElementById(errorId).innerText = "";
        }

        // Check overall form validity
        function checkFormValidity() {
            let isValid =
                validateName() &&
                validateEmail() &&
                validateContact() &&
                validateDob() &&
                validateGender() &&
                validateState() &&
                validateAddress() &&
                validatePassword() &&
                validateConfirmPassword();

            document.getElementById("registerBtn").disabled = !isValid;
        }

        window.onload = function () {
            document.getElementById("name").addEventListener("blur", function () { validateName(); checkFormValidity(); });
            document.getElementById("email").addEventListener("blur", function () { validateEmail(); checkFormValidity(); });
            document.getElementById("contact").addEventListener("blur", function () { validateContact(); checkFormValidity(); });
            document.getElementById("dob").addEventListener("blur", function () { validateDob(); checkFormValidity(); });
            document.getElementById("gender").addEventListener("blur", function () { validateGender(); checkFormValidity(); });
            document.getElementById("state").addEventListener("blur", function () { validateState(); checkFormValidity(); });
            document.getElementById("address").addEventListener("blur", function () { validateAddress(); checkFormValidity(); });
            document.getElementById("password").addEventListener("blur", function () { validatePassword(); checkFormValidity(); });
            document.getElementById("confirmPassword").addEventListener("blur", function () { validateConfirmPassword(); checkFormValidity(); });
        };

        function validateForm() {
            return !document.getElementById("registerBtn").disabled;
        }

        function checkContact(){
            const contact=document.getElementById('contact').value;
            if(contact!=0){
                var xhttp = new XMLHttpRequest();
                xhttp.open("GET","http://localhost:8080/online-auction-app/contactExist?contact="+contact);
                xhttp.send();

                xhttp.onload = function(){
                    document.getElementById("contacterror").innerHTML=this.responseText;
                }
            }
        }
        function checkEmail(){
            const email=document.getElementById('email').value;
            if(email!==""){
                var xhttp = new XMLHttpRequest();
                xhttp.open("GET","http://localhost:8080/online-auction-app/loginemail?email="+email);
                xhttp.send();

                xhttp.onload = function(){
                    document.getElementById("emailerr").innerHTML=this.responseText;
                }
            }
        }
    </script>

</body>
</html>
