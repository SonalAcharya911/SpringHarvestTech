<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Complaint Submission</title>
</head>
<body>
<h2>Submit a Complaint</h2>

<form action="complain" method="post">
    <label>Name:</label><br>
    <input type="text" name="complainantName"><br><br>

    <label>Email:</label><br>
    <input type="email" name="email"><br><br>

    <label>Contact Number:</label><br>
    <input type="number" name="contact"><br><br>

    <label>Category:</label><br>
    <select name="category">
        <option value="Road Issue">Road Issue</option>
        <option value="Electricity">Electricity</option>
        <option value="Water Supply">Water Supply</option>
        <option value="Product Defect">Product Defect</option>
    </select><br><br>

    <label>Description:</label><br>
    <textarea name="description"></textarea><br><br>

    <label>Location:</label><br>
    <input type="text" name="location"><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
