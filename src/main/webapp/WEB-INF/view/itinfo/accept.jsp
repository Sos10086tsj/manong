<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../plugins/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../plugins/jPaginate/jquery.paginate.js"></script>
<link media="screen" rel="stylesheet" href="../plugins/jPaginate/css/style.css"/>
<script type="text/javascript" src="../resources/js/infoHelp.js"></script>
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${tougaoPage.content }" var="tougao">
		<div>${tougao.title }</div>
		<div><button onclick="infoHelp.acceptTougao(${tougao.id})">录用</button></div>
	</c:forEach>
	<div id="info_list_page_id" style="width:500px;"></div>
</body>
</html>