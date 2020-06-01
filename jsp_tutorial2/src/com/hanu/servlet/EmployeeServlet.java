package com.hanu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanu.base.Repository;
import com.hanu.model.Employee;
import com.hanu.repository.EmployeeRepository;

@WebServlet(name="employees", urlPatterns="/employees/*")
public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = -454061803766733007L;
	
private Repository<Employee, Integer> repository;
	
	public EmployeeServlet() {
		repository = new EmployeeRepository();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("UTF-8");
		//TO-DO: Implement switch-case structure for page navigation with req-resp
		try {
			String pathInfo = req.getPathInfo();
			pathInfo = pathInfo != null ? pathInfo : "";
			log(pathInfo);
			
			switch (pathInfo) {
				case "":
					resp.sendRedirect("employees/");
					break;
				case "/":
					listEmployee(req, resp);
					break;
				case "/add":
					showNewForm(req, resp);
					break;
				case "/edit":
					showEditForm(req, resp);
					break;
				case "/delete":
					deleteEmployee(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("UTF-8");
		String pathInfo = req.getPathInfo();
		pathInfo = pathInfo != null ? pathInfo : "";
		switch (pathInfo) {
		case "/add":
			insertEmployee(req, resp);
			break;
		case "/update":
			updateEmployee(req, resp);
			break;
		default:
			break;
		}
	}
	
	private void listEmployee(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Employee> listItems = repository.findAll();
		request.setAttribute("listItems", listItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/employee-list.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showNewForm() method which navigates to ADD USER view
	// (add-employee.jsp)
	private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/employee-add.jsp").forward(req, resp);
	}

	// TO-DO: Implement showEditForm() method which navigates to UPDATE USER view
	// (edit-employee.jsp)
	private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Employee employee = repository.findById(id);
		
		req.setAttribute("item", employee);
		req.getRequestDispatcher("/employee-edit.jsp").forward(req, resp);
	}

	// TO-DO: Implement insertEmployee() method for adding new employee
	private void insertEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Employee employee = new Employee(req.getParameter("name"), req.getParameter("address"));
		repository.add(employee);
		resp.sendRedirect(".");
	}

	// TO-DO: Implement updateEmployee() method for updating existing employee
	private void updateEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Employee employee = new Employee(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("address"));
		repository.save(employee);
		resp.sendRedirect(".");
	}

	// TO-DO: Implement deleteEmployee() method for deleting existing employee
	// Note: There is no view for DELETE function
	private void deleteEmployee(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean updated = repository.remove(id) != 0;
		if (!updated) {
			resp.setStatus(500);
		}
		resp.sendRedirect(".");
	}
}
