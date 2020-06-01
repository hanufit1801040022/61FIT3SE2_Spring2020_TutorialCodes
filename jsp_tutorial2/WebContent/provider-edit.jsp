<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Provider Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<%-- TO-DO: Include navigation bar (nav-bar.jsp)  --%>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<h2>UPDATE PROVIDER</h2>
	<br>
	<%-- TO-DO: CREATE A FORM FOR UPDATING USER --%>
	<form action="update?id=<c:out value='${item.id}' />" method="post">
		<div class="form-group">
			<label for="name">Name</label> <input class="form-control"
				name="name" value=<c:out value='${item.name}' /> />
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
		<a href="./" class="btn btn-secondary">Back</a>

	</form>
</body>
</html>
