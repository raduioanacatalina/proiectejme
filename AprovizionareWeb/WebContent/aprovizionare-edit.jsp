<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateAprovizionare"%>
<%@ page import="model.Aprovizionare"%>
<%@ page import="java.util.List"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body class="container">
<%@ include file="meniu.jsp" %>
	<h2>Editare aprovizionare</h2>
	
	<%
		Integer id = Integer.valueOf(request.getParameter("id-aprovizionare-editare"));
	DateAprovizionare date = new DateAprovizionare();
	Aprovizionare aprovizionare = date.findById(id);
	%>
	
	<div class="alert alert-success" role="alert">
	  Editam Aprovizionarea <%= aprovizionare.getDescriere() %>
	</div>
	<form action="AprovizionareServlet" method="post" style="width: 50%">
		 <input class="form-control"  type="hidden" name="id-aprovizionare" value="<%= aprovizionare.getId() %>">
		Nume: <input class="form-control"  name="descriere-aprovizionare" value="<%= aprovizionare.getDescriere() %>"><br>
		
		 <input type="submit">
	</form>
</body>
</html>