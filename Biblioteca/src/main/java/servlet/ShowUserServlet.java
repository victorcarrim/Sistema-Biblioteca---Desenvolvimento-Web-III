package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.UserRepository;

@WebServlet("/showUser")
public class ShowUserServlet extends HttpServlet{
	
	private static final long serialVersionUID = 6278183440054854459L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserRepository repository = new UserRepository();
		
		req.setAttribute("listUsers",repository.findAll());
		RequestDispatcher listUserDispatcher = req.getRequestDispatcher("showUser.jsp");
		
		listUserDispatcher.forward(req, resp);
	}
}
