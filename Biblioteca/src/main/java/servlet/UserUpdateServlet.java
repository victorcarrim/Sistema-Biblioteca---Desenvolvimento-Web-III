package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;
import repository.UserRepository;

@WebServlet("/userUpdate")
public class UserUpdateServlet extends HttpServlet{

	private static final long serialVersionUID = 4842688961636083066L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserRepository userRepository = new UserRepository();
		
		String idField = req.getParameter("field-id");
		String name = req.getParameter("field-name");
		String email = req.getParameter("field-email");
		String password = req.getParameter("field-password");
		String type = req.getParameter("field-type");
		String sendField = req.getParameter("field-send");
		
		
		
		try {
			if(idField.equals("") || name.equals("") || email.equals("") || password.equals("") || type.equals("")) {
				resp.sendRedirect("/Biblioteca/showUser");
			} else {
			
			Integer id = Integer.parseInt(idField);
			
			if(sendField.equals("Update")) {
			User userObject = new User(id, name, email, password, type);
			userRepository.update(userObject);
			resp.sendRedirect("/Biblioteca/showUser");
			} else {
				userRepository.deleteById(id);
				resp.sendRedirect("/Biblioteca/showUser");
			}
			}
			
		} catch (Exception e) {
			System.out.println("O erro é: " + e);
			resp.sendRedirect("/Biblioteca/showUser");
		}
	}
		
}
