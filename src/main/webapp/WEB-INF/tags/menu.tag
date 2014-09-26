<%@ tag pageEncoding="UTF-8" description="导航栏"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="head-v3">
	<div class="navigation-up">
		<div class="navigation-inner">
			<div class="navigation-v3">
				<ul>
					<c:forEach items="${menuItems }" var="menuItem">
						<li class="" _t_nav="${menuItem.code}">
							<h2><a href="${menuItem.url}" target="mainFrame">${menuItem.name}</a></h2>
						</li>
					</c:forEach>
					<!-- 退出 -->
					<li>
						<h2><a href="/logout">退出</a></h2>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="navigation-down">
		<c:forEach items="${menuItems }" var="menuItem">
			<div id="${menuItem.code}" class = "nav-down-menu menu-3 menu-1" style="display: none;" _t_nav="${menuItem.code}">
				<div class="navigation-down-inner">
					<c:forEach items="${ menuItem.childItems}" var="childItem" varStatus="index">
						<dd>
							<a hotrep="hp.header.product.compute${index.index }" target="mainFrame" href="${childItem.url}">${childItem.name }</a>
						</dd>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	</div>
</div>
