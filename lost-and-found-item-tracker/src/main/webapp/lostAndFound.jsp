<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Lost & Found Form</title>
</head>
<body>

<h2>Lost & Found Item Submission</h2>

<center>


<form action="onSubmit" method="post">
    ${success}
    ${error}
    <label for="holderName">Holder Name:</label><br>
    <input type="text" id="holderName" name="holderName"><br><br>

    <label for="itemName">Item Name:</label><br>
    <input type="text" id="itemName" name="itemName"><br><br>

    <label for="itemDescription">Item Description:</label><br>
    <textarea id="itemDescription" name="itemDescription"></textarea><br><br>

    <label for="lostOrFound">Lost or Found:</label><br>
    <select id="lostOrFound" name="lostOrFound">
        <option value="Lost">Lost</option>
        <option value="Found">Found</option>
    </select><br><br>

    <label for="location">Location:</label><br>
    <input type="text" id="location" name="location"><br><br>

    <label for="lostOrFoundDate">Lost/Found Date:</label><br>
    <input type="date" id="lostOrFoundDate" name="lostOrFoundDate"><br><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" name="email"><br><br>

    <label for="contact">Contact Number:</label><br>
    <input type="number" id="contact" name="contact"><br><br>

    <input type="submit" value="Submit">
</form>
</center>

</body>
</html>
