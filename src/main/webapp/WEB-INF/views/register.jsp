<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>User Registration</title>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath}/registration" method="post">
			<h1 class="heading">User Registration</h1>
			Username:<input type="text" placeholder="username" name="username" required/><br/>
			E-mail:<input type="text" placeholder="email" name="email" required/><br/>
			Password:<input type="password" placeholder="password" name="password" required/><br/>
			<input type="submit" value="Register"/>
		</form>
		<p>${errmsg}</p>
	</center>
</body>
</html>