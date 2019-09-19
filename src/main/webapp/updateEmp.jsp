<%@page isELIgnored="false" %>
<%@page import="com.wp.Emp" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Employee</h1>
<hr>
<form action="update">

Emp No  :<input type="text" name="eno" value="${e.eno}" /><br><br><br>
Emp Name :<input type="text" name="ename" value="${e.ename}" /><br><br><br>
Emp  Sal :<input type="text" name="sal" value="${e.sal}" /><br><br><br>
<input type="submit" value="Save"/><br><br><br>

</form>
<hr>
	<a href="index.jsp">Home</a>

</body>
</html>