<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Passport Registration</title>
</head>
<body>

<center>
    <h2>Passport User Registration</h2>

    <form action="updatePassport" method="post">
        User ID: <input type="number" name="userID" value="${dto.userID}" readonly><br><br>
        Passport Office: <input type="text" name="passportOffice" value="${dto.passportOffice}"><br><br>
        Given Name: <input type="text" name="givenName" value="${dto.givenName}"><br><br>
        Surname: <input type="text" name="surname" value="${dto.surname}"><br><br>
        Date of Birth: <input type="date" name="dob" value="${dto.dob}"><br><br>
        Email: <input type="email" name="email" value="${dto.email}"><br><br>
        Contact Number: <input type="number" name="contact" value="${dto.contact}"><br><br>
        Login ID: <input type="text" name="loginID" value="${dto.loginID}"><br><br>
        Password: <input type="password" name="password" value="${dto.password}"><br><br>
        Confirm Password: <input type="password" name="confirmPassword" value="${dto.confirmPassword}"><br><br>
        Hint Question: <input type="text" name="hintQuestion" value="${dto.hintQuestion}"><br><br>
        Hint Answer: <input type="text" name="hintAnswer" value="${dto.hintAnswer}"><br><br>
        <input type="submit" value="Update">
    </form>
    <a href="fetchAllUsers">Go Back</a>
</center>

</body>
</html>
