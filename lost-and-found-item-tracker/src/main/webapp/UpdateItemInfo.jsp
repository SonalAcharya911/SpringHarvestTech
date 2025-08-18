<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Lost and Found Item</title>
</head>
<body>

<center>
    <h2>Lost and Found Item Form</h2>

    <form action="update" method="post">
        Item ID: <input type="number" name="itemID" value="${dto.itemID}" readonly><br><br>
        Holder Name: <input type="text" name="holderName" value="${dto.holderName}"><br><br>
        Item Name: <input type="text" name="itemName" value="${dto.itemName}"><br><br>
        Item Description: <input type="text" name="itemDescription" value="${dto.itemDescription}"><br><br>
        Lost or Found: <input type="text" name="lostOrFound" value="${dto.lostOrFound}"><br><br>
        Location: <input type="text" name="location" value="${dto.location}"><br><br>
        Date (Lost/Found): <input type="date" name="lostOrFoundDate" value="${dto.lostOrFoundDate}"><br><br>
        Email: <input type="email" name="email" value="${dto.email}"><br><br>
        Contact Number: <input type="number" name="contact" value="${dto.contact}"><br><br>
        <input type="submit" value="Save">
    </form>
    <a href="fetchAllItems">Go Back</a>
</center>

</body>
</html>
