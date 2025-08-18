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

<h2>Artwork Data</h2>
${message}
<table>
    <tr>
        <th>Art ID</th>
        <th>Artist Name</th>
        <th>Artwork Title</th>
        <th>Length(cm)</th>
        <th>Width(cm)</th>
        <th>Price</th>
        <th>Artist Email</th>
        <th>Artist Contact</th>
        <th>Action</th>

    </tr>
    <c:forEach var="item" items="${dtoList}">
        <tr>
            <td>${item.artID}</td>
            <td>${item.artistName}</td>
            <td>${item.artworkTitle}</td>
            <td>${item.lengthInCm}</td>
            <td>${item.widthInCm}</td>
            <td>${item.price}</td>
            <td>${item.artistEmail}</td>
            <td>${item.artistContact}</td>
            <td><a href="findByID?id=${item.artID}">view</a> / <a href="edit?id=${item.artID}">update</a> / <a href="delete?id=${item.artID}">delete</a> </td>
        </tr>
    </c:forEach>
    <tr>
        <td>${dto.artID}</td>
        <td>${dto.artistName}</td>
        <td>${dto.artworkTitle}</td>
        <td>${dto.lengthInCm}</td>
        <td>${dto.widthInCm}</td>
        <td>${dto.price}</td>
        <td>${dto.artistEmail}</td>
        <td>${dto.artistContact}</td>
        <td><a href="getAllArtworks">view all</a></td>
    </tr>


</table>
<a href="backToIndex">Go Back</a>


</body>
</html>