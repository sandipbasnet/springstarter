<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<title>User Registration</title>
</head>
<body>
	<center>
		<form action="${pageContext.request.contextPath}/registration" method="post">
			<h1 class="heading">User Registration</h1>
			Username:<input type="text" placeholder="username" name="username" required value=${username}></input><br/>
			DOB:<input type="date" placeholder="DOB" name="dob" required value=${dob}></input><br/>
			Gender:
			<input type="radio" name="gender" id="male" Value="M" 
			<c:if test="${gender=='M'}"> checked </c:if> />Male
			
			<input type="radio" name="gender" id="female" Value="F"
			<c:if test="${gender=='M'}"> checked </c:if> />Female<br />
			
			E-mail:<input type="text" placeholder="email" name="email" required value=${email}></input> <br/>
			Password:<input type="password" placeholder="password" name="password"  required value=${password}></input> <br/>
			Re-enter Password:<input type="password" placeholder="Re-type password" name="repassword"  required value=${repassword}></input><br/>
			<input type="submit" value="Register"/>
		</form>
		<p>${errmsg}</p>
	</center>
</body>
</html>