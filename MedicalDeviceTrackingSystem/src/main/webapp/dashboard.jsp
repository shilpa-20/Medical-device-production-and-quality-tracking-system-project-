
<%
String user = (String) session.getAttribute("username");

if(user == null){
    response.sendRedirect("login.jsp");
    return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="container">
		<h2>Dashboard</h2>

		<a href="production.jsp">Production Entry</a><br>
		<br> <a href="quality.jsp">Quality Check</a><br>
		<br> <a href="defect.jsp">Defect Entry</a><br>
		<br> <a href="ReportServlet">View Reports</a><br>
		<br> <a href="LogoutServlet">Logout</a>
	</div>

</body>
</html>