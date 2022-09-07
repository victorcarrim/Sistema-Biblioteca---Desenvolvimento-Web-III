package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Author;
import repository.AuthorRepository;

@WebServlet("/authorRegistration")
public class AuthorRegistration extends HttpServlet{

	private static final long serialVersionUID = 1457263710730626773L;

		@Override
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("field-name");
			AuthorRepository repository = new AuthorRepository();
			
			try {
				if(name.equals("")) {
					resp.sendRedirect("/Biblioteca/authorRegistration.jsp");
				} else {
				Author authorObject = new Author(name);
				repository.insert(authorObject);
				
				resp.sendRedirect("/Biblioteca/showAuthor");
				}
			} catch (Exception e) {
				System.out.println("O erro é: " + e);
				resp.sendRedirect("/Biblioteca/showAuthor");
			}
			
			
		}
}
