<%@page isELIgnored="false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Delete Employee</h1>
<hr>
<form action="delete">
<br>
Employee No : <input type="text" name="eno"/><br><br><br>
<input type="submit" value="Delete"/><br><br><br>
</form>

<hr>
<h2>${deleteErr}</h2><br>
  <a href="index.jsp">Home</a>

</body>
</html>