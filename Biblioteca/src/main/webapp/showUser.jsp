<%@page import="models.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	
	Boolean statusLogin = (Boolean) session.getAttribute("loginStatus");
	User userLogin = (User) session.getAttribute("loginUser");

	if(statusLogin == null || statusLogin == false)
		response.sendRedirect("index.jsp");
	
	if(userLogin.getType().ordinal() == 0)
		response.sendRedirect("index.jsp");

	List<User> usersList = (List<User>) request.getAttribute("listUsers"); 

%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<title>Gerenciar Usuarios</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/styleShowUser.css">
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
	<%for(User userShow : usersList) { %>
	
	  	<div class="card cardUser">
			<form method="post" action="userUpdate">
			
				<div class="text-field-id-user">
					<label> ID: </label>
					<input type="text" name="field-id" value="<%= userShow.getId() %>">
				</div>
				
				<div class="text-field-name-user">
					<label>Nome:</label>
					<input type="text" name="field-name" value="<%= userShow.getName() %>">
				</div>
				
				<div class="text-field-email-user">
					<label>Email:</label>
					<input type="text" name="field-email" value="<%= userShow.getEmail() %>">
				</div>
				
				<div class="text-field-password-user">
					<label>Senha:</label>
					<input type="text" name="field-password" value="<%= userShow.getPassword() %>">
				</div>
				
					<label>Status:</label>
					<% if (userShow.getTypeDAO().equals("CLIENT")) { %>
					<input type="radio" id="status-choice-1" name="field-type" value="ADMIN">
					<label for="status-choice-1">Admin</label>
					<input type="radio" id="status-choice-2" name="field-type" value="CLIENT" checked>
					<label for="status-choice-2">Cliente</label>
				<% } else { %>
					<input type="radio" id="status-choice-1" name="field-type" value="ADMIN" checked>
					<label for="status-choice-1">Admin</label>
					<input type="radio" id="status-choice-2" name="field-type" value="CLIENT">
					<label for="status-choice-2">Cliente</label>
				<% } %>
				
				<div class="buton-update-delete">
					<input type="submit" name="field-send" value="Update">
					<input type="submit" name="field-send"value="Delete">
				</div>
			</form>
		</div>
	<% } %>
	
	</div>
</body>
</html>