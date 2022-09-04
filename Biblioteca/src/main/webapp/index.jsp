<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Biblioteca</title>
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="assets/book.png" >
</head>
<body>

	<div class="main-login">
		<div class="left-login"> 
			<h1> A melhor biblioteca virtual do<br> mundo está aqui!</h1>
			<img alt="booklover1" class="left-login-img" src="assets/booklover1.svg">
		</div>
		<div class="right-login">
				<form action="login" method="post" class="card-login">
					<h1>LOGIN</h1>
					<div class="textfield">
						<label for="email">Email</label> <input type="email" name="field-email"
							placeholder="Email">
					</div>
					<div class="textfield">
						<label for="senha">Senha</label> <input type="password"
							name="field-password" placeholder="Senha">
					</div>
					<button class="btn-login" type="submit">Login</button>
				</form>
			</div>
		</div>


</body>
</html>