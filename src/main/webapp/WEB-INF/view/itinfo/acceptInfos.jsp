<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="manong" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../plugins/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../../resources/js/infoHelp.js"></script>
<link media="screen" rel="stylesheet" href="../../resources/css/info.css"/>
</head>
<body >
	<div >
		<table class="title zebra infolist_table" >
			<thead>
				<tr>
					<th width="5%">#</th>
					<th width="60%">标题</th>
					<th width="25%">投稿时间</th>
					<th width="15%">操作</th>
			</tr>
			</thead>
			<tbody >
			<c:forEach items="${tougaoPage.content }" var="tougao" varStatus="index">
				<tr>
					<td>${index.index + 1}</td>
					<td ><a class="ellipsis title_width infolist_td" href="/itInfo/detail/${tougao.id}"
							 title="${tougao.title}" target="mainFrame">${tougao.title}</a></td>
					<td style="text-align:center"><fmt:formatDate value="${tougao.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
					<td style="text-align:center">
						<a href="javascript:onClick=infoHelp.jump2EditPage(${tougao.id})">
							<img class="edit_size" src="../../resources/images/edit.png">
						</a>
						<a href="javascript:onClick=infoHelp.cancelAcceptTougao(${tougao.id})">
							<img class="edit_size" src="../../resources/images/cancel.png">
						</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<manong:page url="/itInfo/accept/infos?pageNum=" componentId="info_cancel_page_id" page="${tougaoPage }"
	prePath="../"></manong:page>

</body>
</html>