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

	if(statusLogin == null || statusLogin == false)
		response.sendRedirect("index.jsp");
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<title>Cadastrar Livro</title>
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
	
  	<div class="card cardBook">
	<form method="post" action="bookRegistration">
	
		<div class="text-field-name-book">
			<label>Livro:</label>
			<input type="text" name="field-name">
		</div>
		
		<div class="text-field-author-date">
			<label>Data de Lan??amento: </label>
			<input type="date" name="field-date">
			<label>Autor: </label>
			<% if(authorList.isEmpty() || authorList == null) { %>
				<label>Nenhuma autor cadastrado</label>
			<% } else { %>
					<select name="field-author">
						<option value="">-- Selecione uma op????o --</option>
						<% for(Author authorObject : authorList) { %>
								
							<option value="<%= authorObject.getId() %>"> <%= authorObject.getName() %> </option>
						<% } %>
					</select>
				<% } %>
			</div>
			
		<div class="status-check">
			<label>Status:</label>
			<div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="field-status" id="AVAILABLE" value="0">
			  <label class="form-check-label" for="AVAILABLE"> Dispon??vel </label>
			 </div>
			 <div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name ="field-status"id="UNAVAILABLE" value="1">
			  <label class="form-check-label" for="UNAVAILABLE"> Indispon??vel </label>
			 </div>
			 <div class="form-check form-check-inline">
			  <input class="form-check-input" type="radio" name="field-status" id="BORROWED" value="2">
			  <label class="form-check-label" for="BORROWED"> Emprestado </label>
			</div>
		</div>
		
		<div class="buton-update-delete">
			<input type="submit" value="Cadastrar">
		</div>
		
		</form>
		</div>
</body>
	
</html>