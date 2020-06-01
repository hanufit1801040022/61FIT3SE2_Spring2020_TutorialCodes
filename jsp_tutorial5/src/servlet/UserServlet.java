package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User;

/**
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 */

@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	
	public void init() {
		userDAO = new UserDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		String pathInfo = request.getServletPath();
		switch (pathInfo) {
		case "/add":
			insertUser(request, response);
			break;
		case "/update":
			updateUser(request, response);
			break;
		default:
			break;
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		//TO-DO: Implement switch-case structure for page navigation with request-response
		try {
			String pathInfo = request.getServletPath();
			
			switch (pathInfo) {
				case "/":
					listUser(request, response);
					break;
				case "/add":
					showNewForm(request, response);
					break;
				case "/edit":
					showEditForm(request, response);
					break;
				case "/delete":
					deleteUser(request, response);
				default:
					throw new IllegalStateException();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	//TO-DO: Implement showNewForm() method which navigates to ADD USER view (add-user.jsp)
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("add-user.jsp").forward(request, response);
	}

	//TO-DO: Implement showEditForm() method which navigates to UPDATE USER view (edit-user.jsp)
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User user = userDAO.selectUser(id);
		log(user.toString());
		request.setAttribute("user", user);
		request.getRequestDispatcher("edit-user.jsp").forward(request, response);
	}

	//TO-DO: Implement insertUser() method for adding new user
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		try {
			User user = new User(request.getParameter("name"),
								request.getParameter("address"),
								request.getParameter("mobile"));
			userDAO.insertUser(user);
			response.sendRedirect("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//TO-DO: Implement updateUser() method for updating existing user
	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		try {
			User user = new User(Integer.parseInt(request.getParameter("id")),
								request.getParameter("name"),
								request.getParameter("address"),
								request.getParameter("mobile"));
			userDAO.updateUser(user);
			response.sendRedirect("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//TO-DO: Implement deleteUser() method for deleting existing user
	//Note: There is no view for DELETE function
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean updated = userDAO.deleteUser(id);
			if (!updated) {
				response.setStatus(500);
			}
			response.sendRedirect("");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

