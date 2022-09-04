<%@page import="models.User"%>
<%@page import="models.Book"%>
<%@page import="models.Author"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	Boolean statusLogin = (Boolean) session.getAttribute("loginStatus");
	User userLogin = (User) session.getAttribute("loginUser");
	List<Author> authorList = (List<Author>) request.getAttribute("listAuthors"); 
	List<Book> bookList = (List<Book>) request.getAttribute("listBooks"); 

	if(statusLogin == null || statusLogin == false)
		response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<title>Home - Biblioteca</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/styleShowBook.css">
	<link rel="shortcut icon" href="assets/book.png" >
</head>
<body>
	<nav class="navbar navbar-expand-lg">
  		<div class="container-fluid">
    		<a class="navbar-brand" href="/Biblioteca/showBooks">
      			<img src="assets/book.png" alt="bookIcon" width="50" height="40">
    		</a>
  		
  		<div class="collapse navbar-collapse" id="navbarNav">
      		<ul class="navbar-nav">
        		<li class="nav-item">
          			<a class="nav-link" aria-current="page" href="/Biblioteca/showBooks">Home</a>
       			</li>
		       	<li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Cadastros </a>
		          	<ul class="dropdown-menu">
		           		<li class="nav-item">
		          			<a class="nav-link" aria-current="page" href="/Biblioteca/authorRegistration.jsp">Cadastro de Autores</a>
		       			</li>
		       			<li class="nav-item">
		          			<a class="nav-link" aria-current="page" href="/Biblioteca/bookRegistration">Cadastro de Livros</a>
		       			</li>
		       			<% if(userLogin.getType().ordinal() == 1) { %>
		       			<li class="nav-item">
		          			<a class="nav-link" aria-current="page" href="/Biblioteca/userRegistration.jsp">Cadastro de Usuarios</a>
		       			</li>
		       			<% } %>
		          	</ul>
		        </li>
		        
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Gerenciar </a>
		          	<ul class="dropdown-menu">
		           		<li class="nav-item">
		          			<a class="nav-link" aria-current="page" href="/Biblioteca/showAuthor">Gerenciar Autores</a>
		       			</li>
		       			<% if(userLogin.getType().ordinal() == 1) { %>
		       			<li class="nav-item">
		          			<a class="nav-link" aria-current="page" href="/Biblioteca/showUser">Gerenciar Usuarios</a>
		       			</li>
		       			<% } %>
		          	</ul>
		        </li>
		        
       	</div>
       	</div>
       	<a class="nav-link" href="/Biblioteca/logout">Sair</a>
	</nav>
	
	<div class="container text-center card cardPrincipal">
	<%for(Book bookObject : bookList) { %>
	
  	<div class="card cardBook">
	<form method="post" action="bookUpdate">
	
		<div class="text-field-id-book">
			<label> ID: </label>
			<input type="text" name="field-id" value="<%= bookObject.getId() %>">
		</div>
		
		<div class="text-field-name-book">
			<label>Livro:</label>
			<input type="text" name="field-name" value="<%= bookObject.getName() %>">
		</div>
		
		<div class="text-field-author-date">
			<label>Data de Lançamento: </label>
			<input type="date" name="field-date" value="<%= bookObject.getDateDAO() %>">
			<label>Autor: </label>
			<% if(authorList.isEmpty() || authorList == null) { %>
				<label>Nenhuma autor cadastrado</label>
			<% } else { %>
					<select name="field-author">
						<option value="">-- Selecione uma opção --</option>
						<% for(Author authorObject : authorList) { 
								if(authorObject.getId() == bookObject.getAuthor().getId()) { %>
									<option value="<%= authorObject.getId() %>" selected="selected"> <%= authorObject.getName() %> </option>
								<%} %>
						<option value="<%= authorObject.getId() %>"> <%= authorObject.getName() %> </option>
						<% } %>
					</select>
				<% } %>
			</div>
			
		<div class="status-check">
			<label>Status:</label>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="field-status" id="AVAILABLE" value="0" <% if(bookObject.getStatus().ordinal() == 0) { %> checked <% } %>>
			  <label class="form-check-label" for="AVAILABLE"> Disponível </label>
			 </div>
			 <div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name ="field-status"id="UNAVAILABLE" value="1" <% if(bookObject.getStatus().ordinal() == 1) { %> checked <% } %>>
			  <label class="form-check-label" for="UNAVAILABLE"> Indisponível </label>
			 </div>
			 <div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="field-status" id="BORROWED" value="2" <% if(bookObject.getStatus().ordinal() == 2) { %> checked <% } %>>
			  <label class="form-check-label" for="BORROWED"> Emprestado </label>
			</div>
		</div>
		
		<div class="buton-update-delete">
			<input type="submit" name="field-send" value="Update">
			<input type="submit" name="field-send"value="Delete">
		</div>
		
		</form>
		</div>
		<% } %>
	  
</body>
	
</html>