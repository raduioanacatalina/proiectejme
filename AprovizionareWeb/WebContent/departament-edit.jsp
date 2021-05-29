<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Departament"%>
<%@ page import="date.DateDepartament"%>
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
	<h2>Editare departament</h2>
	
	<%
		Integer id = Integer.valueOf(request.getParameter("id-departament-editare"));
	DateDepartament date = new DateDepartament();
	Departament departamentGasit = date.findById(id);
	%>
	
	<div class="alert alert-success" role="alert">
	  Editam Departamentul <%= departamentGasit.getDenumire() %>
	</div>
	<form action="DepartamentServlet" method="post" style="width: 50%">
		 <input class="form-control"  type="hidden" name="id-departament" value="<%= departamentGasit.getId() %>">
		Denumire: <input class="form-control"  name="denumire-departament" value="<%= departamentGasit.getDenumire() %>"><br>
		
		 <input type="submit">
	</form>
</body>
</html>