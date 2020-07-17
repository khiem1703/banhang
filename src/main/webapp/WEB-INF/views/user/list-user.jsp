<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="inner-block">
	<div class="chit-chat-layer1 bg">
		<div class="work-progres">
			<div class="chit-chat-heading">List User</div>

			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>Name</th>
							<th>PhoneNumber</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="u">
							<tr>
								<td>${u.id }</td>
								<td>${u.name }</td>
								<td>${u.phoneNumber}</td>
								
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>
		<div class="clearfix"></div>

	</div>
</div>
