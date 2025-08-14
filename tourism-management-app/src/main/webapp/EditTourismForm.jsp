<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tourism Page</title>
</head>
<body>

<center>
    <h2>Update Tourism Data</h2>

    <form action="update" method="post">
        Tour ID: <input type="number" name="tourID" value="${dto.tourID}" readonly><br><br>
        Destination: <input type="text" name="destination" value="${dto.destination}"><br><br>
        Start Point: <input type="text" name="startPoint" value="${dto.startPoint}"><br><br>
        Package price: <input type="number" name="packagePrice" value="${dto.packagePrice}"><br><br>
        Vehicle: <input type="text" name="vehicle" value="${dto.vehicle}"><br><br>
        Vehicle Number: <input type="text" name="vehicleNumber" value="${dto.vehicleNumber}"><br><br>
        Number of people: <input type="number" name="noOfPeople" value="${dto.noOfPeople}"><br><br>
        Start Date: <input type="date" name="startDate" value="${dto.startDate}"><br><br>
        End Date: <input type="date" name="endDate" value="${dto.endDate}"><br><br>
        <input type="submit" value="Update">
    </form>
    <a href="fetchAll">Go Back</a>
</center>

</body>
</html>