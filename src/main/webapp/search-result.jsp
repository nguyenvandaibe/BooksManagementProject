<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Search book</title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>
	<div class="container">
		<div class="font-weight-bold text-center">SEARCH RESULT FOR
			INPUT</div>
		<div class="text-center fst-italic">
			<%

			%>
		</div>
		<div class="row justify-content-center">
			<div class="col-md-8">
				<table class="table">
					<thead>
						<th>ID</th>
						<th>Name</th>
						<th>Publisher</th>
						<th>Price</th>
						<th>Actions</th>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td><c:out value="${book.id}"></c:out></td>
								<td><c:out value="${book.name}"></c:out></td>
								<td><c:out value="${book.publisher}"></c:out></td>
								<td><c:out value="${book.price}"></c:out></td>
								<td class="d-flex justify-content-between"><a
									href="books?action=edit&id=<c:out value='${book.id}' />"
									class="btn btn-primary mx-3">Edit</a> <a
									href="books?action=remove&id=<c:out value='${book.id}' />"
									class="btn btn-danger mx-3">Remove</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<div class="mt-3 float-left">
					<a href="javascript:history.back()">Quay lại</a>
				</div>
			</div>
		</div>
	</div>
</body>

</html>