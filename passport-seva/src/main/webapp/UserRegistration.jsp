<html>
<body>
<h2>Welcome to Passport Seva</h2>
<br>

<center>
    <form action="register" method="post">
        Passport Office: <select class="form-select" aria-label="Default select example" name="passportOffice">
            <option selected>Select City</option>
            <option value="bengaluru">Bengaluru</option>
            <option value="cochin">Cochin</option>
            <option value="delhi">Delhi</option>
            <option value="goa">Goa</option>
            <option value="chennai">Chennai</option>
            <option value="kolkata">Kolkata</option>
        </select><br><br>

        Given Name: <input type="text" name="givenName"><br><br>
        Surname: <input type="text" name="surname"><br><br>
        Date of Birth: <input type="date" name="dob"><br><br>

        <span id="emailerror" style="color: red"></span><br>
        E-mail Id: <input type="email" name="email" onchange="loginemail()" id="email"><br><br>

        <span id="contacterror" style="color: red"></span><br>
        Contact: <input type="tel" name="contact" id="contact" onchange="checkContact()"><br><br>

        <span id="loginIDerror" style="color: red"></span><br>
        Login Id: <input type="email" name="loginID" id="loginID" onchange="checkLoginId()"><br><br>

        Password: <input type="password" name="password"><br><br>
        Confirm password: <input type="password" name="confirmPassword"><br><br>

        Hint Question: <select class="form-select" aria-label="Default select example" name="hintQuestion">
        <option selected>Select your hint question</option>
        <option value="What is your pet name?">What is your pet name?</option>
        <option value="What is the name of your first school?">What is the name of your first school?</option>
        <option value="What is your mother's childhood name?">What is your mother's childhood name?</option>

    </select><br><br>
        Hint Answer: <input type="text" name="hintAnswer"><br><br>

        <input type="submit" value="registerUser">
    </form>
    <br><br>
    <a href="getAll">View Passport list</a>
</center>
<script>
    function loginemail(){
        const email=document.getElementById('email').value;
        if(email!==""){
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET","http://localhost:8080/passport-seva/loginemail?email="+email);
            xhttp.send();

            xhttp.onload = function(){
                document.getElementById("emailerror").innerHTML=this.responseText;
            }
        }
    }

    function checkLoginId(){
        const loginID=document.getElementById('loginID').value;
        if(loginID!==""){
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET","http://localhost:8080/passport-seva/loginIdexist?loginID="+loginID);
            xhttp.send();

            xhttp.onload = function(){
                document.getElementById("loginIDerror").innerHTML=this.responseText;
            }
        }
    }

    function checkContact(){
        const contact=document.getElementById('contact').value;
        if(contact!==0){
            var xhttp = new XMLHttpRequest();
            xhttp.open("GET","http://localhost:8080/passport-seva/contactExist?contact="+contact);
            xhttp.send();

            xhttp.onLoad = function(){
                console.log("checking contact error before");
                document.getElementById("contacterror").innerHTML=this.responseText;
                console.log("checking after");
            }
        }

    }



</script>
</body>
</html>
