<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
    <title>All Passport Data</title>
    <style>
        table {
          font-family: arial, sans-serif;
          border-collapse: collapse;
          width: 100%;
        }

        td, th {
          border: 1px solid #dddddd;
          text-align: left;
          padding: 8px;
        }

        tr:nth-child(even) {
          background-color: #dddddd;
        }
    </style>
</head>
<body>

<h2>Users Data</h2>
<h4>${message}</h4>
<table>
    <tr>
        <th>User-ID</th>
        <th>Passport Office</th>
        <th>Given Name</th>
        <th>Surname</th>
        <th>DOB</th>
        <th>E-mail</th>
        <th>Contact</th>
        <th>Login-ID</th>
        <th>Password</th>
        <th>Confirm Password</th>
        <th>Hint Question</th>
        <th>Hint Answer</th>
        <th>Action</th>
    </tr>

    <c:forEach var="item" items="${DTOList}">
        <tr>
            <td>${item.userID}</td>
            <td>${item.passportOffice}</td>
            <td>${item.givenName}</td>
            <td>${item.surname}</td>
            <td>${item.dob}</td>
            <td>${item.email}</td>
            <td>${item.contact}</td>
            <td>${item.loginID}</td>
            <td>${item.password}</td>
            <td>${item.confirmPassword}</td>
            <td>${item.hintQuestion}</td>
            <td>${item.hintAnswer}</td>
            <td><a href="getByID?id=${item.userID}">View</a> / <a href="edit?id=${item.userID}">Edit</a> / <a href="delete?id=${item.userID}">Delete</a></td>
        </tr>
    </c:forEach>

    <tr>
        <td>${dto.userID}</td>
        <td>${dto.passportOffice}</td>
        <td>${dto.givenName}</td>
        <td>${dto.surname}</td>
        <td>${dto.dob}</td>
        <td>${dto.email}</td>
        <td>${dto.contact}</td>
        <td>${dto.loginID}</td>
        <td>${dto.password}</td>
        <td>${dto.confirmPassword}</td>
        <td>${dto.hintQuestion}</td>
        <td>${dto.hintAnswer}</td>
        <td><a href="getAll">View All</a></td>
    </tr>


</table>
<a href="backToIndex">Go Back</a>


</body>
</html>