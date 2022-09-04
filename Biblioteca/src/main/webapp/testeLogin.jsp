<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	
	Boolean statusLogin = (Boolean) session.getAttribute("loginStatus");

	if(statusLogin == null || statusLogin == false)
		response.sendRedirect("login.jsp");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>TESTA LOGIN</h1>
</body>
</html>