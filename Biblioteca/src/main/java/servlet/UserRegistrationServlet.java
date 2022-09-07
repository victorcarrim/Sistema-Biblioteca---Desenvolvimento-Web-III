package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import repository.UserRepository;

@WebServlet("/cadastro")
public class UserRegistrationServlet extends HttpServlet{
	
	private static final long serialVersionUID = 419141099763019071L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserRepository repository = new UserRepository();
		String name = req.getParameter("field-name");
		String email = req.getParameter("field-email");
		String password = req.getParameter("field-password");
		String type = req.getParameter("field-type");
		
		
		
		try {
			if(name.equals("") || email.equals("") || password.equals("") || type == null) {
				resp.sendRedirect("userRegistration.jsp");
			} else {
			
			if(repository.findByEmail(email, password) != null) {
				resp.sendRedirect("/Biblioteca/showUser");
			}
			
			User userObject = new User(name, email, password, type);
			
			if(repository.insert(userObject) != 1) {
				resp.sendRedirect("userRegistration.jsp");
			} else {
				resp.sendRedirect("/Biblioteca/showUser");
			}
			}
		} catch (Exception e) {
			System.out.println(e);
			resp.sendRedirect("userRegistration.jsp");
		}
	
	}

}
