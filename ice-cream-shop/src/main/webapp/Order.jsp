<html>
<body>
<h2>It's Ice Cream world</h2>
<form action="order" method="post" enctype="multipart/form-data">
${error}
    <br><br>
    Name: <input type="text" name="name"><br>
    Flavour:
    <select name="flavour">
        <option>Vanilla</option>
        <option>Chocolate</option>
        <option>Strawberry</option>
        <option>BlackCurrent</option>
        <option>Pineapple</option>
    </select><br>
    Quantity: <input type="number" name="quantity"><br>
    Take Away: <input type="checkbox" name="takeAway"><br>
    Add Ons: <input type="text" name="addOns"><br>
    Coupon: <input type="text" name="coupon"><br>
    Profile:
    <input type="file" name="multipartFile" > <br><br>
    <input type="submit" value="ORDER">
</form>
</body>
</html>