
<%-- TO-DO: CREATE A NAVIGATION BAR WHICH INCLUDES HYPERLINK TO ADD & EDIT USER FORM --%>
<nav class="navbar navbar-expand-sm bg-dark">
	<div class="container-fluid">
		<ul class="navbar-nav mr-auto">
			<li><a class="nav-link text-light"
				href='<%=request.getContextPath() + "/employees"%>'>Employee
					Management</a></li>
			<li><a class="nav-link text-light"
				href='<%=request.getContextPath() + "/providers"%>'>Provider
					Management</a></li>
			<li><a class="nav-link text-light"
				href='<%=request.getContextPath() + "/products"%>'>Product
					Management</a></li>
		</ul>
	</div>
</nav>