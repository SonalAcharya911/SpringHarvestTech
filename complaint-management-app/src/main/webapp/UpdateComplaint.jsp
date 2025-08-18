<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Complaint Form</title>
</head>
<body>

<center>
    <h2>Complaint Registration Form</h2>

    <form action="updateComplaint" method="post">
        Complaint ID: <input type="number" name="complaintID" value="${dto.complaintID}" readonly><br><br>
        Complainant Name: <input type="text" name="complainantName" value="${dto.complainantName}"><br><br>
        Email: <input type="email" name="email" value="${dto.email}"><br><br>
        Contact Number: <input type="number" name="contact" value="${dto.contact}"><br><br>
        Category: <input type="text" name="category" value="${dto.category}"><br><br>
        Description: <input type="text" name="description" value="${dto.description}"><br><br>
        Location: <input type="text" name="location" value="${dto.location}"><br><br>
        <input type="submit" value="Submit Complaint">
    </form>
    <a href="fetchAllComplaints">Go Back</a>
</center>

</body>
</html>
