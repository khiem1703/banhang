<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloWorld</title>
<link href='<c:url value="/resouce/css/style.css"/>'>
</head>
<body>
	<p>${person.name}</p>
		<p>${person.age}</p>
	
</body>
</html>