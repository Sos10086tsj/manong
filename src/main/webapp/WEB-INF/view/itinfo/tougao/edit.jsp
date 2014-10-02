<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../../plugins/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="../../plugins/jQuery-Validation-Engine/js/jquery.validationEngine.js?1"></script>
<script type="text/javascript" src="../../plugins/jQuery-Validation-Engine/js/languages/jquery.validationEngine-zh_CN.js?1"></script>
<link media="screen" rel="stylesheet" href="../../plugins/jQuery-Validation-Engine/css/validationEngine.jquery.css?1"/>
<link media="screen" rel="stylesheet" href="../../../resources/css/info.css"/>

<link rel="stylesheet" type="text/css" href="../../plugins/kindeditor/themes/default/default.css" />
<script type="text/javascript" src="../../plugins/kindeditor/kindeditor-min.js"></script>
<script type="text/javascript" src="../../plugins/kindeditor/zh_CN.js"></script>


<div class="create title">
	<form action="/itInfo/createTougao" method="post" id="create_tougao_form">
		<div>
			<div >
				<div class="title_label float_left">标题</div>
				<div ><input type="text" placeholder="请输入标题" value="${itTougao.title }" name="title" class="title_input float_left validate[required]" data-promptPosition="bottomRight"></div>
			</div>
			<div class="float_clear"></div>
		</div>
		<div style="margin:20px 0 0 75px;">
			<div>
				<div class="float_left category_label">分类</div>
				<div class="float_left">
					<select class="select" name="category">
						<c:forEach items="${categories }" var="cat">
							<c:choose>
								<c:when test="${ cat.category == itTougao.category.category }">
									<option value="${cat.category }" selected='selected'>${cat.description}</option>
								</c:when>
								<c:otherwise>
									<option value="${cat.category }">${cat.description}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div >
				<div class="float_left category_label" style="margin-left:10px;">类型</div>
				<div class="float_left">
					<select class="select" name="type">
						<c:forEach items="${types }" var="type">
							<c:choose>
								<c:when test="${ type.type == itTougao.type.type }">
									<option value="${type.type }" selected='selected'>${type.description}</option>
								</c:when>
								<c:otherwise>
									<option value="${type.type }">${type.description}</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div >
				<div  class="float_left category_label" style="margin-left:10px;width:70px;">原文地址</div>
				<div><input name="sourceUrl" class="float_left url_input" value="${itTougao.sourceUrl }"></div>
			</div>
			<div class="float_clear"></div>
		</div>
		<div style="margin-top:10px;" class="content">
			<textarea class="content" name="content" id="content" placeholder="请输入文章内容">${itTougao.content }</textarea>
		</div>
		<div style="margin-top:10px;">
			<button class="submit_btn submit_btn_white">保存</button>
		</div>
	</form>
</div>

<script>
	$('#create_tougao_form').validationEngine(); 
	 KindEditor.ready(function(K) {
		window.editor = K.create('#content',{
			allowFileManager : true ,
			uploadJson: '/kindeditor/upload'
		});
     });
</script>