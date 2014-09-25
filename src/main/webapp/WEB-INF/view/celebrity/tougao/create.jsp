<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../plugins/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../resources/js/celebrityHelp.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="/celebrity/submitTougao" method="post">
			荣誉称号<input name="honorTitle">
			姓名<input name="name">
			简介<input name="profile">
			生平<input name="zhuanji">
			资源<input name="resourceUrl">
			<button type="submit">保存</button>
		</form>
	</div>
</body>
</html>