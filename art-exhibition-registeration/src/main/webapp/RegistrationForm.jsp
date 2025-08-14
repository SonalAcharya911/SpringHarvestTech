
<html>
<head>

    <title>Artwork Submission</title>
</head>
<body>
<h1>Artwork Submission</h1>

<center>
<form action="register" method="post">
    <div>
        <label for="artistName">Artist Name</label><br />
        <input id="artistName" name="artistName" type="text" required />
    </div>

    <br>
    <div>
        <label for="artworkTitle">Artwork Title</label><br />
        <input id="artworkTitle" name="artworkTitle" type="text" required />
    </div>
    <br>
    <div>
        <label for="lengthInCm">Length (cm)</label><br />
        <input id="lengthInCm" name="lengthInCm" type="number" min="0" step="1" required />
    </div>
    <br>
    <div>
        <label for="widthInCm">Width (cm)</label><br />
        <input id="widthInCm" name="widthInCm" type="number" min="0" step="1" required />
    </div>
    <br>
    <div>
        <label for="price">Price</label><br />
        <input id="price" name="price" type="number" min="0" step="0.01" required />
    </div>
    <br>
    <div>
        <label for="artistEmail">Artist Email</label><br />
        <input id="artistEmail" name="artistEmail" type="email" required />
    </div>
    <br>
    <div>
        <label for="artistContact">Artist Contact</label><br />
        <input id="artistContact" name="artistContact" type="tel" required />
    </div>
    <br>
    <div>
        <input type="submit" value="Register">
    </div>
</form>
</center>
</body>
</html>
