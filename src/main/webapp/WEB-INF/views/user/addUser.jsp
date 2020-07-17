<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="inner-block">
	<div class="signup-block bg">
		<h2 id="ha">Add User</h2>
		<c:url value="/admin/user/add" var="addUser"></c:url>
		<form:form action="${addUser}" method="post" id="ha"
			enctype="multipart/form-data" modelAttribute="user">
			
			<label>Name</label>
			<form:input type="text" path="name" />
			
			<label>Username</label>
			<form:input path="username"/>
			
			<label>Password</label>
			<form:password type="password" path="password"/>
			<form:errors path="password"/>
			
			<label>Avatar</label>
			<form:input type="file" path="avatarFile"/>
			
			<input type="submit" name="addUser" value="Submit">
		</form:form>
	</div>
</div>
