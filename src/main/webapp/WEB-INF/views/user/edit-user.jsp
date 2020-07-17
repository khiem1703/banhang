<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="inner-block">
	<div class="signup-block bg">
		<h2 id="ha">Add User</h2>
		<c:url value="/admin/user/edit" var="addUser"></c:url>
		<form action="${addUser}" method="post" id="ha"
			enctype="multipart/form-data">
			<input type="text" readonly="readonly" name="id" value="${user.id }">

			<label>Name</label> <input type="text" name="name" placeholder="Name"
				required value="${user.name }"> <label>Username</label> <input
				type="text" name="username" placeholder="Username" required=""
				value="${user.username }"> <label>Password</label> <input
				type="password" name="password" class="lock"
				value="${user.password }" placeholder="Password"> <label>Avatar</label>
			<input type="file" name="avatar"> <img height="150"
				src='<c:url value="/image?fname=${user.avatar }"/>' /> </br> <input
				type="submit" value="Submit"> </br>
			<p>${errMsg}</p>
		</form>
	</div>
</div>