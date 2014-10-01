<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
				<div ><input type="text" placeholder="请输入标题" name="title" class="title_input float_left validate[required]" data-promptPosition="bottomRight"></div>
			</div>
			<div class="float_clear"></div>
		</div>
		<div style="margin:20px 0 0 75px;">
			<div>
				<div class="float_left category_label">分类</div>
				<div class="float_left">
					<select class="select" name="category">
						<option value="INFO">资讯</option>
						<option value="MANAGE">经验管理</option>
						<option value="TECHNIC">技术分享</option>
					</select>
				</div>
			</div>
			<div >
				<div class="float_left category_label" style="margin-left:10px;">类型</div>
				<div class="float_left">
					<select class="select" name="type">
						<option value="ORIGIN">原创</option>
						<option value="REPRINT">转载</option>
						<option value="TRANSLATE">翻译</option>
					</select>
				</div>
			</div>
			<div >
				<div  class="float_left category_label" style="margin-left:10px;width:70px;">原文地址</div>
				<div><input name="sourceUrl" class="float_left url_input"></div>
			</div>
			<div class="float_clear"></div>
		</div>
		<div style="margin-top:10px;" class="content">
			<textarea class="content" name="content" id="content" placeholder="请输入文章内容"></textarea>
		</div>
		<div style="margin-top:10px;">
			<button>保存</button>
		</div>
	</form>
</div>

<script>
	$('#create_tougao_form').validationEngine(); 
	 KindEditor.ready(function(K) {
                window.editor = K.create('#content');
        });
</script>