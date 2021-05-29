<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateMagazin"%>
<%@ page import="model.Magazin"%>
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
	<h2>Editare magazin</h2>
	
	<%
		Integer idMagazin = Integer.valueOf(request.getParameter("id-magazin-editare"));
		DateMagazin date = new DateMagazin();
		Magazin magazinGasit = date.findById(idMagazin);
	%>
	
	<div class="alert alert-success" role="alert">
	  Editam magazin <%= magazinGasit.getDenumire() %>
	</div>
	<form action="MagazinServlet" method="post" style="width: 50%">
		 <input class="form-control"  type="hidden" name="id-magazin" value="<%= magazinGasit.getId() %>">
		Denumire: <input class="form-control"  name="denumire" value="<%= magazinGasit.getDenumire() %>"><br>
		 Telefon:  <input class="form-control"  name="telefon" value="<%= magazinGasit.getTelefon() %>"><br>
		 Strada: <input class="form-control"  name="strada" value="<%= magazinGasit.getStrada() %>"><br>
		 Numar: <input class="form-control"  name=" numar" value="<%= magazinGasit.getNumar() %>"><br> 
		 Oras: <input class="form-control"  name=" oras" value="<%= magazinGasit.getOras() %>"><br>
		 Cod_postal: <input class="form-control"  name=" cod_postal" value="<%= magazinGasit.getCod_postal() %>"><br>
		  
		 <input type="submit">
	</form>
</body>
</html>