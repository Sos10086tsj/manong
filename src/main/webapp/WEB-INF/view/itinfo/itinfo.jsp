<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script type="text/javascript" src="../resources/js/infoHelp.js"></script>
<link media="screen" rel="stylesheet" href="../resources/css/info.css"/>

<div>
	<div >
		<div class="content_left">
			<div>
				<div class="float_left title">最新资讯</div>
				<div class="float_right title"><a href="/itInfo/accept/infos" target="mainFrame">更多</a></div>
			</div>
			<div class="float_clear"></div>
			<div >
				<c:forEach items="${infos.content}" var="info">
					<div class="title_margin">
						<div>
							<a class="title_item float_left ellipsis title_width" href="/itInfo/detail/${info.id}"
							 title="${info.title}" target="mainFrame">${info.title}</a>
						</div>
						<div>
							<a href="javascript:onClick=infoHelp.jump2EditPage(${info.id})"><img class="edit_size float_right edit_img" src="../resources/images/edit.png"></a>
						</div>
						<div class="float_right title_item">
							<fmt:formatDate value="${info.acceptDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</div>
						<div class="float_clear"></div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<div class="content_right">
		<button class="button gray" onclick="infoHelp.createTougao()">新    建</button>
	</div>
</div>
