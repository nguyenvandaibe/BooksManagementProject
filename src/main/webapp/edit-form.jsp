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
        <div class="row justify-content-center">
            <div class="col-md-4">
                <form action="books?action=update&id=<c:out value='${book.id}' />" method="post">
                    <div class="form-group">
                        <label for="id">ID</label>
                        <input type="text" name="id" id="id" class="form-control" value="<c:out value='${book.id}' />" disabled>
                    </div>
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" name="name" id="name" class="form-control" value="<c:out value='${book.name}' />">
                    </div>
                    <div class="form-group">
                        <label for="publisher">Publisher</label>
                        <input type="text" name="publisher" id="publisher" class="form-control" value="<c:out value='${book.publisher}' />">
                    </div>
                    <div class="form-group">
                        <label for="price">Price</label>
                        <input type="text" name="price" id="price" class="form-control" value="<c:out value='${book.price}' />">
                    </div>
                    <div class="from-group">
                        <a href="javascript:history.back()" class="btn btn-secondary">Cancel</a>
                        <button type="submit" class="btn btn-primary ml-3">Save</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>