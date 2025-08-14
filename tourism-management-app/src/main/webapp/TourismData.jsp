<%@ page isELIgnored="false" %>

<html>
<head>
    <title>
        Single Data
    </title>
</head>
<body>
<h2>Tourism Data </h2>
<center>
    <div>Tour ID: ${dto.tourID} <br><br>
        Destination: ${dto.destination} <br><br>
        Start Point: ${dto.startPoint} <br><br>
        Package Price: ${dto.packagePrice} <br><br>
        Vehicle: ${dto.vehicle} <br><br>
        Vehicle Number: ${dto.vehicleNumber} <br><br>
        Number of people: ${dto.noOfPeople}<br><br>
        Start Date: ${dto.startDate} <br><br>
        End Date: ${dto.endDate} <br><br>
        <a href="fetchAll">View All</a></div>
</center>
</body>
</html>