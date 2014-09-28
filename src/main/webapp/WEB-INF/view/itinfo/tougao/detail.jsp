<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div>
		<table border="1px solid #ccc;">
			<thead>
				<tr>
					<th>【${itTougao.category.description}】</th>
					<th>${itTougao.title}</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>类型</td>
					<td>${itTougao.type.description}</td>
					<td>原文网址</td>
					<td>${itTougao.sourceUrl}</td>
				</tr>
				<tr>
					<td>文章内容</td>
					<td colspan="3">${itTougao.content}</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>