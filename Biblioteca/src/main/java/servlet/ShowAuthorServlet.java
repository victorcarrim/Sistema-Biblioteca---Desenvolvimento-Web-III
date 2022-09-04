package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AuthorRepository;

@WebServlet("/showAuthor")
public class ShowAuthorServlet extends HttpServlet{

	
	private static final long serialVersionUID = -7582737115903896268L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthorRepository repository = new AuthorRepository();
		
		req.setAttribute("listAuthors", repository.findAll());
		RequestDispatcher listUserDispatcher = req.getRequestDispatcher("showAuthor.jsp");
		
		listUserDispatcher.forward(req, resp);
	}
}
