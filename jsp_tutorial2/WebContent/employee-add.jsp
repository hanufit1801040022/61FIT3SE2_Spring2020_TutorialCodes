<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	<%-- TO-DO: Include navigation bar (nav-bar.jsp)  --%>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<div class="container">
		<h3 class="text-center">ADD EMPLOYEE</h3>
		<br>
		<%-- TO-DO: CREATE A FORM FOR ADDING USER --%>
		<form action="add" method="post">
			<div class="form-group">
				<label for="name">Name</label> <input class="form-control"
					name="name" />
			</div>
			<div class="form-group">
				<label for="address">Address</label> <input class="form-control"
					name="address" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<a href="./" class="btn btn-secondary">Back</a>

		</form>
	</div>

</body>
</html>
