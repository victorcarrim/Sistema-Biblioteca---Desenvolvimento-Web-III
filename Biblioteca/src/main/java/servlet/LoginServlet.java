package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import repository.UserRepository;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -154176561953216931L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserRepository login = new UserRepository();
		String email = req.getParameter("field-email");
		String password = req.getParameter("field-password");
		
		User userObject = login.findByEmail(email, password);
		
		if(userObject != null) {
			HttpSession sessao = req.getSession(true);
			sessao.setAttribute("loginStatus", true);
			sessao.setAttribute("loginUser", userObject);
			resp.sendRedirect("/Biblioteca/showBooks");
		} else {
			resp.sendRedirect("index.jsp");
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.sendRedirect("index.jsp");
	}
}
