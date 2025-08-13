<%@ page isELIgnored = "false" %>
<html>
<body>
<h2>Welcome to Passport Seva</h2>

${message}
<form action="checkEmail" method="post">
    <input type="email" name="email">
    <input type="submit" value="check">
</form>
</body>
</html>
