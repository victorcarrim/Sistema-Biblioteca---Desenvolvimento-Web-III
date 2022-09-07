package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Author;
import repository.AuthorRepository;

@WebServlet("/authorUpdate")
public class AuthorUpdateServlet extends HttpServlet{
	
	
	private static final long serialVersionUID = 6943753733409343615L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthorRepository authorRepository = new AuthorRepository();
		
		String idField = req.getParameter("field-id");
		String name = req.getParameter("field-name");
		String sendField = req.getParameter("field-send");
		
		
		
		try {
			if(idField.equals("") || name.equals("")) {
				resp.sendRedirect("/Biblioteca/showAuthor");
			} else {
			Integer id = Integer.parseInt(idField);
			
			if(sendField.equals("Update")) {
			Author authorObject = new Author(id, name);
			authorRepository.update(authorObject);
			resp.sendRedirect("/Biblioteca/showAuthor");
			} else {
				authorRepository.deleteById(id);
				resp.sendRedirect("/Biblioteca/showAuthor");
			}
			}
			
			
		} catch (Exception e) {
			System.out.println("O erro é: " + e);
			resp.sendRedirect("/Biblioteca/showAuthor");
		}
	}
}
