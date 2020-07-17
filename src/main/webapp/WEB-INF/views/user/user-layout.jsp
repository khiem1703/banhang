<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<div class="page-container">
		<div class="left-content">
			<div class="mother-grid-inner">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="body" />
				<tiles:insertAttribute name="copyright" />
			</div>
		</div>
		<tiles:insertAttribute name="menu" />
		<div class="clearfix"></div>
	</div>
	<tiles:insertAttribute name="script" />
</body>
</html>