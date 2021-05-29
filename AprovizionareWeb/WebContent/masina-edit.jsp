<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateMasina"%>
<%@ page import="model.Masina"%>
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
	<h2>Editare masina</h2>
	
	<%
		Integer idMasina = Integer.valueOf(request.getParameter("id-masina-editare"));
		DateMasina date = new DateMasina();
		Masina masinaGasit = date.findById(idMasina);
	%>
	
	<div class="alert alert-success" role="alert">
	  Editam masina <%= masinaGasit.getMarca() %>
	</div>
	<form action="MasinaServlet" method="post" style="width: 50%">
		 <input class="form-control"  type="hidden" name="id-masina" value="<%= masinaGasit.getId() %>">
		Marca: <input class="form-control"  name="marca" value="<%= masinaGasit.getMarca() %>"><br>
		 Model:  <input class="form-control"  name="model" value="<%= masinaGasit.getModel() %>"><br>
		 Capacitate: <input class="form-control"  name="capacitate" value="<%= masinaGasit.getCapacitate() %>"><br>
		 Nr_inmatriculare: <input class="form-control"  name=" nr_inmatriculare" value="<%= masinaGasit.getNr_inmatriculare() %>"><br> 
		  
		 <input type="submit">
	</form>
</body>
</html>