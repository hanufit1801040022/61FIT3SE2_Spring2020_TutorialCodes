<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<%-- TO-DO: CREATE A NAVIGATION BAR WHICH INCLUDES HYPERLINK TO ADD & EDIT USER FORM --%>
	<nav class="navbar nav-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>">USER LIST</a></li>
				<li><a href="add">ADD USER</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>