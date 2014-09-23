<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/itinfo/createTougao" method="post">
			标题<input name="title">
			内容<input name="content">
			类别<input name="category">
			类型<input name="type">
			url<input name="sourceUrl">
			<button type="submit">保存</button>
		</form>
	</div>
</body>
</html>