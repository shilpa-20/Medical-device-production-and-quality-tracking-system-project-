
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
<title>Production Entry</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

	<div class="container">

		<h2>Production Entry</h2>

		<form action="ProductionServlet" method="post">

<label>Product Name</label>
<input type="text" name="productName" required>

<label>Batch Number</label>
<input type="text" name="batchNumber" required>

<label>Production Date</label>
<input type="date" name="productionDate" required>

<label>Quantity Produced</label>
<input type="number" name="quantity" required>

<button type="submit">Save Production</button>

</form>

		<br> <a href="dashboard.jsp">Back to Dashboard</a>

	</div>

</body>
</html>