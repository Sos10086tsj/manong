<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../resources/css/login.css" />
<title>码农——登录</title>
</head>
<body class="body">
	<div class="main">
		<div class = "company_logo"><img src="../resources/images/company_logo.png"></div>
		<div>
			<div class = "website_logo float_left"><img src="../resources/images/website-logo.png"></div>
			<div class="login float_left">
				<form  method="post">
					<div>
						<div><label class="float_left lable">用户名</label> </div>
						<div><input type="text" name="username"/></div>
					</div>
					<div style="margin-top:10px;">
						<div><label class="float_left lable">密&nbsp;&nbsp;码</label></div>
						<div><input type="password" name="password"/></div>
					</div>
					<div style="margin-top:10px;" >
						<button class="login_btn white button" type="submit">登录</button>
					</div>
				</form>
			</div>
		</div>
		<div class="info">
			<div><label class="float_left">更多信息请关注&nbsp;</label> </div>
			<div><a href="https://github.com/Sos10086tsj/manong" target="_blank">Paris Tao</a></div>
		</div>
	</div>
	
	
	
</body>
</html>