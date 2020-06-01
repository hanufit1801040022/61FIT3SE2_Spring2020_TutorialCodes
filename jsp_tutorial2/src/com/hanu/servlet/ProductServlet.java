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
import com.hanu.model.Product;
import com.hanu.repository.ProductRepository;

@WebServlet(name="products", urlPatterns="/products/*")
public class ProductServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1073499164870644149L;
	
	private Repository<Product, Integer> repository;
	
	public ProductServlet() {
		repository = new ProductRepository();
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
					resp.sendRedirect("products/");
					break;
				case "/":
					listProduct(req, resp);
					break;
				case "/add":
					showNewForm(req, resp);
					break;
				case "/edit":
					showEditForm(req, resp);
					break;
				case "/delete":
					deleteProduct(req, resp);
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
			insertProduct(req, resp);
			break;
		case "/update":
			updateProduct(req, resp);
			break;
		default:
			break;
		}
	}
	
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Product> listItems = repository.findAll();
		request.setAttribute("listItems", listItems);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product-list.jsp");
		dispatcher.forward(request, response);
	}

	// TO-DO: Implement showNewForm() method which navigates to ADD USER view
	// (add-product.jsp)
	private void showNewForm(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/product-add.jsp").forward(req, resp);
	}

	// TO-DO: Implement showEditForm() method which navigates to UPDATE USER view
	// (edit-product.jsp)
	private void showEditForm(HttpServletRequest req, HttpServletResponse resp)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = repository.findById(id);
		
		req.setAttribute("item", product);
		req.getRequestDispatcher("/product-edit.jsp").forward(req, resp);
	}

	// TO-DO: Implement insertProduct() method for adding new product
	private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Product product = new Product(req.getParameter("name"), Long.parseLong(req.getParameter("listPrice")));
		repository.add(product);
		resp.sendRedirect(".");
	}

	// TO-DO: Implement updateProduct() method for updating existing product
	private void updateProduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Product product = new Product(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), Long.parseLong(req.getParameter("listPrice")));
		repository.save(product);
		resp.sendRedirect(".");
	}

	// TO-DO: Implement deleteProduct() method for deleting existing product
	// Note: There is no view for DELETE function
	private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		boolean updated = repository.remove(id) != 0;
		if (!updated) {
			resp.setStatus(500);
		}
		resp.sendRedirect(".");
	}
}
