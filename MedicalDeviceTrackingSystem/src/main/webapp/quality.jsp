
<%
String user = (String) session.getAttribute("username");

if (user == null) {
	response.sendRedirect("login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quality Check</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="container">
		<h2>Quality Check Entry</h2>

		<form action="QualityCheckServlet" method="post">

			<label>Batch Number</label> <input type="text" name="batch" required>

			<label>Units Passed</label><input type="number" name="passed"required>
			
			 <label>Units Failed</label><input type="number" name="failed" required>

			<button type="submit">Save Quality Data</button>
		</form>

		<br> <a href="dashboard.jsp">Back to Dashboard</a>
	</div>

</body>
</html>