package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Author;
import models.Book;
import repository.AuthorRepository;
import repository.BookRepository;

@WebServlet("/bookRegistration")
public class BookRegistrationServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthorRepository authorList = new AuthorRepository();
		
		req.setAttribute("listAuthors", authorList.findAll());
		RequestDispatcher listUserDispatcher = req.getRequestDispatcher("bookRegistration.jsp");
		
		listUserDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AuthorRepository authorFind = new AuthorRepository();
		BookRepository bookRepository = new BookRepository();
		
		String name = req.getParameter("field-name");
		String date = req.getParameter("field-date");
		String authorField = req.getParameter("field-author");
		String statusField = req.getParameter("field-status");
		
		System.out.println(name + date + authorField + statusField);
		
		if( name.equals("") || date.equals("") || authorField.equals("") || statusField.equals("")) {
			resp.sendRedirect("/Biblioteca/bookRegistration");
		}
		
		try {
			Integer author = Integer.parseInt(authorField);
			Integer status = Integer.parseInt(statusField);
			
			Author authorObject = authorFind.findById(author);
			Book bookObject = new Book(0, name, date, authorObject, status);
			bookRepository.insert(bookObject);
			resp.sendRedirect("/Biblioteca/showBooks");
			
			
		} catch (Exception e) {
			System.out.println("O erro é: " + e);
			resp.sendRedirect("/Biblioteca/bookRegistration");
		}
		
		
		
		}
	
}
