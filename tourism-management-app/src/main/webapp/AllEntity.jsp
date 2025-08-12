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

<h2>Tourism Table</h2>

<table>
    <tr>
        <th>TourID</th>
        <th>Destination</th>
        <th>Start Point</th>
        <th>Package Price</th>
        <th>Vehicle</th>
        <th>Vehicle Number</th>
        <th>No Of People</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th> View </th>
    </tr>

    <c:forEach var="item" items="${tourismDTOList}">
        <tr>
            <td>${item.tourID}</td>
            <td>${item.destination}</td>
            <td>${item.startPoint}</td>
            <td>${item.packagePrice}</td>
            <td>${item.vehicle}</td>
            <td>${item.vehicleNumber}</td>
            <td>${item.noOfPeople}</td>
            <td>${item.startDate}</td>
            <td>${item.endDate}</td>
            <td><a href="getByID?id=${item.tourID}">View</a></td>
        </tr>
    </c:forEach>

    <tr>
        <td>${dto.tourID}</td>
        <td>${dto.destination}</td>
        <td>${dto.startPoint}</td>
        <td>${dto.packagePrice}</td>
        <td>${dto.vehicle}</td>
        <td>${dto.vehicleNumber}</td>
        <td>${dto.noOfPeople}</td>
        <td>${dto.startDate}</td>
        <td>${dto.endDate}</td>
        <td><a href="fetchAll">View All</a></td>
    </tr>


</table>
<a href="backToIndex">Go Back</a>


</body>
</html>