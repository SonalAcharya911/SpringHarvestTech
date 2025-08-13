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

<h2>Lost and Found Item Data</h2>

<table>
    <tr>
        <th>Item Id</th>
        <th>Holder Name</th>
        <th>Item Name</th>
        <th>Item Description</th>
        <th>Lost or Found</th>
        <th>Location</th>
        <th>Lost or Found Date</th>
        <th>Email</th>
        <th>Contact</th>

    </tr>
    <c:forEach var="item" items="${dtoList}">
        <tr>
            <td>${item.itemID}</td>
            <td>${item.holderName}</td>
            <td>${item.itemName}</td>
            <td>${item.itemDescription}</td>
            <td>${item.lostOrFound}</td>
            <td>${item.location}</td>
            <td>${item.lostOrFoundDate}</td>
            <td>${item.email}</td>
            <td>${item.contact}</td>
            <td><a href="findByID?id=${item.itemID}">view</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td>${dto.itemID}</td>
        <td>${dto.holderName}</td>
        <td>${dto.itemName}</td>
        <td>${dto.itemDescription}</td>
        <td>${dto.lostOrFound}</td>
        <td>${dto.location}</td>
        <td>${dto.lostOrFoundDate}</td>
        <td>${dto.email}</td>
        <td>${dto.contact}</td>
        <td><a href="getAllItems">view all</a></td>
    </tr>

</table>

<a href="backToIndex">Go Back</a>

</body>
</html>