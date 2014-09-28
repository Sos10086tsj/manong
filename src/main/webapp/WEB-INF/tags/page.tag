<%@ tag pageEncoding="UTF-8" description="分页"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="page" type="org.springframework.data.domain.Page" required="true" description="分页" %>
<%@ attribute name="componentId" type="java.lang.String" required="true" description="绑定id" %>
<%@ attribute name="url" type="java.lang.String" required="true" description="数据url" %>
<%@ attribute name="prePath" type="java.lang.String" required="false" description="前缀" %>

<script type="text/javascript" src="${prePath }../plugins/jPaginate/jquery.paginate.js"></script>
<script type="text/javascript" src="${prePath }../resources/js/pageHelp.js"></script>
<link media="screen" rel="stylesheet" href="${prePath }../plugins/jPaginate/css/style.css"/>

<div id="${componentId}" style="margin:0 auto;width:300px;"></div>

<script>
var jPageCount = ${page.totalElements};
var jPageStart = ${page.number + 1};
var jPageDisplay = ${page.totalPages > 10 ? 10 : page.totalPages};
var jPageId = '${componentId}';
var jPageUrl = '${url}';
</script>