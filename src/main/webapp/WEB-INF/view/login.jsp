<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/login.css" />
<title>码农——登录</title>
</head>
<body>
	<div class = "company_logo"><img src="../resources/images/company_logo.png"></div>
	<div>
		<div class = "website_logo float_left login"><img src="../resources/images/website-logo.png"></div>
		<div>
			<form class="float_left" method="post">
				<input type="text" name="username"/> <br/>
				<input type="password" name="password"/>
   				<input type="checkbox" name="rememberMe" value="true"/>
   				<button type="submit">登录</button>
			</form>
		</div>
	</div>
	
</body>
</html>