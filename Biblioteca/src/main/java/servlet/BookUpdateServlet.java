package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Author;
import models.Book;
import repository.AuthorRepository;
import repository.BookRepository;

@WebServlet("/bookUpdate")
public class BookUpdateServlet  extends HttpServlet{
	
	private static final long serialVersionUID = -6227720678180345548L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthorRepository authorFind = new AuthorRepository();
		BookRepository bookRepository = new BookRepository();
		
		String idField = req.getParameter("field-id");
		String name = req.getParameter("field-name");
		String date = req.getParameter("field-date");
		String authorField = req.getParameter("field-author");
		String statusField = req.getParameter("field-status");
		String sendField = req.getParameter("field-send");
		
		
		
		try {
			if(idField.equals("") || name.equals("") || date.equals("") || authorField.equals("") || statusField.equals("")) {
				resp.sendRedirect("/Biblioteca/showBooks");
			} else {
			
			Integer id = Integer.parseInt(idField);
			Integer author = Integer.parseInt(authorField);
			Integer status = Integer.parseInt(statusField);
			
			if(sendField.equals("Update")) {
				Author authorObject = authorFind.findById(author);
				Book bookObject = new Book(id, name, date, authorObject, status);
				bookRepository.update(bookObject);
				resp.sendRedirect("/Biblioteca/showBooks");
			} else {
				bookRepository.deleteById(id);
				resp.sendRedirect("/Biblioteca/showBooks");
			}
			}
			
		} catch (Exception e) {
			System.out.println("O erro é: " + e);
			resp.sendRedirect("/Biblioteca/showBooks");
		}
		
		
		
		}
}
