<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<%-- TO-DO: Include navigation bar (nav-bar.jsp)  --%>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<h2>ADD NEW USER</h2>
	<br>
	<%-- TO-DO: CREATE A FORM FOR ADDING USER --%>
	<form action="add" method="post">
		<div class="form-group">
			<label for="name">Name</label>
			<input class="form-control" name="name" />
		</div>
		<div class="form-group">
			<label for="address">Address</label>
			<input class="form-control" name="address" />
		</div>
		<div class="form-group">
			<label for="mobile">Mobile</label>
			<input class="form-control" name="mobile" />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>
