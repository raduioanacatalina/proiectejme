<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateFurnizor"%>
<%@ page import="model.Furnizor"%>
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
	<h2>Editare furnizor</h2>
	
	<%
		Integer idFurnizor = Integer.valueOf(request.getParameter("id-furnizor-editare"));
		DateFurnizor date = new DateFurnizor();
		Furnizor furnizorGasit = date.findById(idFurnizor);
	%>
	
	<div class="alert alert-success" role="alert">
	  Editam furnizor <%= furnizorGasit.getDenumire() %>
	</div>
	<form action="FurnizorServlet" method="post" style="width: 50%">
		 <input class="form-control"  type="hidden" name="id-furnizor" value="<%= furnizorGasit.getId() %>">
		Denumire: <input class="form-control"  name="denumire" value="<%= furnizorGasit.getDenumire() %>"><br>
		 Telefon:  <input class="form-control"  name="telefon" value="<%= furnizorGasit.getTelefon() %>"><br>
		 Nume_strada: <input class="form-control"  name="strada" value="<%= furnizorGasit.getNume_strada() %>"><br>
		 Numar_strada: <input class="form-control"  name=" numar" value="<%= furnizorGasit.getNumar_strada() %>"><br> 
		 Oras: <input class="form-control"  name=" oras" value="<%= furnizorGasit.getOras() %>"><br>
		 
		  
		 <input type="submit">
	</form>
</body>
</html>