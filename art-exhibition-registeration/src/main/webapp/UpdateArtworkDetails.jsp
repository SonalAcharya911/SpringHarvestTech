<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Artwork Entry</title>
</head>
<body>

<center>
    <h2>Artwork Entry Form</h2>

    <form action="updateArtwork" method="post">
        Art ID: <input type="number" name="artID" value="${dto.artID}" readonly><br><br>
        Artist Name: <input type="text" name="artistName" value="${dto.artistName}"><br><br>
        Artwork Title: <input type="text" name="artworkTitle" value="${dto.artworkTitle}"><br><br>
        Length (cm): <input type="number" name="lengthInCm" value="${dto.lengthInCm}"><br><br>
        Width (cm): <input type="number" name="widthInCm" value="${dto.widthInCm}"><br><br>
        Price: <input type="number" step="0.01" name="price" value="${dto.price}"><br><br>
        Artist Email: <input type="email" name="artistEmail" value="${dto.artistEmail}"><br><br>
        Artist Contact: <input type="number" name="artistContact" value="${dto.artistContact}"><br><br>
        <input type="submit" value="Update">
    </form>
    <a href="getAllArtworks">Go Back</a>
</center>

</body>
</html>
