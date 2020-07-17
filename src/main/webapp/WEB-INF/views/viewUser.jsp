<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>HelloWorld</title>
<link href='<c:url value="/resouce/css/style.css"/>'>
</head>
<body>
	<p>thong tin nguoi dung</p>
	<p>ten :${user.id}</p>
	<p>ten :${user.name}</p>
	<p>ten :${user.phone}</p>

</body>
</html>