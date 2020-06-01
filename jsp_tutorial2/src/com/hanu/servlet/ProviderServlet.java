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
import com.hanu.model.Provider;
import com.hanu.repository.ProviderRepository;

@WebServlet(name = "providers", urlPatterns = "/providers/*")
public class ProviderServlet extends HttpServlet {

	private static final long serialVersionUID = -6728002420753944924L;
	
	private Repository<Provider, Integer> repository;
	
	public ProviderServlet() {
		repository = new ProviderRepository();
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
					resp.sendRedirect("providers/");
					break;
				case "/":
					listProvider(req, resp);
					break;
				case "/add":
					showNewForm(req, resp);
					break;
				case "/edit":
					showEditForm(req, resp);
					break;
				case "/delete":
					deleteProvider(req, resp);
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
			insertProvider(req, resp);
			break;
		case "/update":
			updateProvider(req, resp);
			break;
		default:
			break;
		}
	}
	
	private void listProvider(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Provider> listItems = repository.findAll();
		request.setAttribute("listItems", listItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/provider-list.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showNewForm() method which navigates to ADD USER view
	// (add-provider.jsp)
	private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/provider-add.jsp").forward(req, resp);
	}

	// TO-DO: Implement showEditForm() method which navigates to UPDATE USER view
	// (edit-provider.jsp)
	private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Provider provider = repository.findById(id);
		
		req.setAttribute("item", provider);
		req.getRequestDispatcher("/provider-edit.jsp").forward(req, resp);
	}

	// TO-DO: Implement insertProvider() method for adding new provider
	private void insertProvider(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Provider provider = new Provider(req.getParameter("name"));
		repository.add(provider);
		resp.sendRedirect(".");
	}

	// TO-DO: Implement updateProvider() method for updating existing provider
	private void updateProvider(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Provider provider = new Provider(Integer.parseInt(req.getParameter("id")), req.getParameter("name"));
		repository.save(provider);
		resp.sendRedirect(".");
	}

	// TO-DO: Implement deleteProvider() method for deleting existing provider
	// Note: There is no view for DELETE function
	private void deleteProvider(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean updated = repository.remove(id) != 0;
		if (!updated) {
			resp.setStatus(500);
		}
		resp.sendRedirect(".");
	}
}
