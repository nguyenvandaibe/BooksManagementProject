<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<form action="login" method="post">
					<div class="font-weight-bold text-center">SEARCH BOOK</div>
					<div class="form-group my-6">
						<input type="text" name="bookName" id="bookName" class="form-control" placeholder="Type book's name...">
					</div>
					<div class="form-group">
						<button type="submit"
							class="btn btn-primary form-control text-center">Search</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>