<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - Medical Device Tracking</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="container">
    <h2>Medical Device Tracking System</h2>

  <form action="LoginServlet" method="post">
        <label>Username</label>
        <input type="text" name="username" required>

        <label>Password</label>
        <input type="password" name="password" required>
        
        <button type="submit">Login</button>
    </form>
</div>

</body>
</html>