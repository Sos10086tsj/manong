<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link media="screen" rel="stylesheet" href="../../../resources/css/info.css"/>
<link rel="stylesheet" type="text/css" href="../../plugins/kindeditor/themes/default/default.css" />
<script type="text/javascript" src="../../plugins/kindeditor/kindeditor-min.js"></script>
<script type="text/javascript" src="../../plugins/kindeditor/zh_CN.js"></script>

<div class="detail_container title">
		<div>
			<div class="detail_title">【${itTougao.category.description }】${itTougao.title }</div>
			<div class="float_clear"></div>
		</div>
		<div style="margin-top:20px;">
			<div class="float_left" style="width:40px;margin-left:300px;">${itTougao.type.description }</div>
			<c:if test="${itTougao.sourceUrl != null && itTougao.sourceUrl.length() > 0}">
				<div style="widht:260px;text-align:left !important;"><a class="ellipsis"  href="${itTougao.sourceUrl }" target="_blank">${itTougao.sourceUrl }</a></div>
			</c:if>
			<div class="float_clear"></div>
		</div>
		<div style="margin-top:10px;">
			<textarea class="content" style="width:800px;height:400px;" name="content" id="content" >${itTougao.content }</textarea>
		</div>
		<div style="margin-top:10px;">
			<button class="submit_btn delete_red" onclick="window.location = '/itInfo/delete/${itTougao.id}'">删除</button>
		</div>
</div>

<script>
	 KindEditor.ready(function(K) {
		window.editor = K.create('#content');
     });
</script>