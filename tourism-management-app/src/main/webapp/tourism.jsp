<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Tourism Page</title>
</head>
<body>

<center>
    <h2 style="color: green">${success}</h2>
    <h2 style="color: red">${error}</h2>

    <form action="saveData" method="post">
        Destination: <input type="text" name="destination"><br><br>
        Start Point: <input type="text" name="startPoint"><br><br>
        Package price: <input type="number" name="packagePrice"><br><br>
        Vehicle: <input type="text" name="vehicle"><br><br>
        Vehicle Number: <input type="text" name="vehicleNumber"><br><br>
        Number of people: <input type="number" name="noOfPeople"><br><br>
        Start Date: <input type="date" name="startDate"><br><br>
        End Date: <input type="date" name="endDate"><br><br>
        <input type="submit" value="Save Data">
    </form>
</center>

</body>
</html>