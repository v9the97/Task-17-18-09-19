<%@page import="java.util.List"%>
<%@page import="com.wp.Emp" %>
<%
List<Emp> empList=(List<Emp>)request.getAttribute("empList");
%>

<html>
<body>
<h3>Employees LIST</h3>
<hr>
<table border="2">
	<tr>
		<th>Employee No</th><th>Employee Name</th><th>Employee Salary</th>
	<tr>

<%
	for(Emp emp:empList){
%>
<tr>
	<td><%=emp.getEno()%></td>
	<td><%=emp.getEname()%></td>
	<td><%=emp.getSal()%></td>

</tr>
<%
	}
%>
</table>
<hr>
<a href="index.jsp">Home</a>
</body>
</html>