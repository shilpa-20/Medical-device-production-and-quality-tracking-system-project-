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
<title>Defect Entry</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>

<div class="container">

<h2>Defect Entry</h2>

<form action="DefectTrackingServlet" method="post">

<label>Batch ID</label>
<input type="text" name="batchId" required>

<label>Defect Type</label>
<input type="text" name="defectType" required>

<label>Root Cause</label>
<input type="text" name="rootCause" required>

<label>Action Taken</label>
<input type="text" name="actionTaken" required>

<button type="submit">Save Defect</button>

</form>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>

</div>

</body>
</html>