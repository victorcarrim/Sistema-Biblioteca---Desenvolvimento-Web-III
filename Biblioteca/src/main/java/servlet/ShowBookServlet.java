package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.AuthorRepository;
import repository.BookRepository;

@WebServlet("/showBooks")
public class ShowBookServlet extends HttpServlet{

	private static final long serialVersionUID = -7678076961953778801L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthorRepository authorList = new AuthorRepository();
		BookRepository bookList = new BookRepository();
		
		req.setAttribute("listAuthors", authorList.findAll());
		req.setAttribute("listBooks", bookList.findAll());
		RequestDispatcher listUserDispatcher = req.getRequestDispatcher("showBook.jsp");
		
		listUserDispatcher.forward(req, resp);
	}
}
