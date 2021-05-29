<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateAngajat"%>
<%@ page import="model.Angajat"%>
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
	<h2>Editare angajat</h2>
	
	<%
		Integer idAngajat = Integer.valueOf(request.getParameter("id-angajat-editare"));
		DateAngajat date = new DateAngajat();
		Angajat angajatGasit = date.findById(idAngajat);
	%>
	
	<div class="alert alert-success" role="alert">
	  Editam angajatul <%= angajatGasit.getNume() %>
	</div>
	<form action="AngajatServlet" method="post" style="width: 50%">
		 <input class="form-control"  type="hidden" name="id-angajat" value="<%= angajatGasit.getId() %>">
		Nume: <input class="form-control"  name="nume-angajat" value="<%= angajatGasit.getNume() %>"><br>
		 Prenume:  <input class="form-control"  name="prenume-angajat" value="<%= angajatGasit.getPrenume() %>"><br>
		 Oras: <input class="form-control"  name="oras-angajat" value="<%= angajatGasit.getOras() %>"><br>
		 Strada: <input class="form-control"  name="strada-angajat" value="<%= angajatGasit.getStrada() %>"><br> 
		 Numar: <input class="form-control"  name="numar-angajat" value="<%= angajatGasit.getNumar() %>"><br> 
		 Salariu:	  <input class="form-control" type="number" name="salariu-angajat" value="<%= angajatGasit.getSalariu() %>"><br>
		 Telefon: <input class="form-control"  name="telefon-angajat" value="<%= angajatGasit.getTelefon() %>"><br> 
		 <input type="submit">
	</form>
</body>
</html>