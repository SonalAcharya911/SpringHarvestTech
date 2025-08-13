<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored = "false" %>

<html>
<head>
    <title>All Data</title>
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

<h2>Complaints Data</h2>

<table>
    <tr>
        <th>Complaint ID</th>
        <th>Complainant Name</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Category</th>
        <th>Description</th>
        <th>Location</th>
        <th>View</th>

    </tr>
    <c:forEach var="item" items="${dtoList}">
        <tr>
            <td>${item.complaintID}</td>
            <td>${item.complainantName}</td>
            <td>${item.email}</td>
            <td>${item.contact}</td>
            <td>${item.category}</td>
            <td>${item.description}</td>
            <td>${item.location}</td>
            <td><a href="findByID?id=${item.complaintID}">view</a></td>

        </tr>
    </c:forEach>
    <tr>
        <td>${dto.complaintID}</td>
        <td>${dto.complainantName}</td>
        <td>${dto.email}</td>
        <td>${dto.contact}</td>
        <td>${dto.category}</td>
        <td>${dto.description}</td>
        <td>${dto.location}</td>


    </tr>


</table>

<a href="backToIndex">Go Back</a>

</body>
</html>