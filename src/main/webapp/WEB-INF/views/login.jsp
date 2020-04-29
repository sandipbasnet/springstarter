<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>Login</title>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath}/home" method="post">
			<h1 class="heading">User Login</h1>
			Username:<input type="text" placeholder="username" name="username"/><br/>
			Password:<input type="password" placeholder="password" name="password"/><br/>
			<input type="submit" value="Login"/>
		</form>
		<p>${errmsg}</p>
	</center>
</body>
</html>