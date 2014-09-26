<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link media="screen" rel="stylesheet" href="../resources/css/homepage.css"/>

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
							<a class="title_item float_left ellipsis title_width" href="/itInfo/detail/${info.id}" target="mainFrame">${info.title}</a>
						</div>
						<div class="float_right title_item">
							<fmt:formatDate value="${info.acceptDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</div>
						<div class="float_clear"></div>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="content_right">
			<div>
				<div class="float_left title">名人堂</div>
				<div class="float_right title"><a href="/celebrity/acceptList" target="mainFrame">更多</a></div>
			</div>
			<div class="float_clear"></div>
			<div>
				<c:forEach items="${celebrities.content}" var="celebrity">
					<div class="title_margin">
						<div>
							<a class="title_item float_left ellipsis title_width" href="/celebrity/detail/${celebrity.id}" target="mainFrame">${celebrity.name}</a>
						</div>
						<div class="float_right title_item">
							<fmt:formatDate value="${celebrity.acceptDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
						</div>
						<div class="float_clear"></div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
