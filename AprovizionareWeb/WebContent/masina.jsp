<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateMasina"%>
<%@ page import="model.Masina"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Collections"%>
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
	<h2>Masina</h2>
	<%
		System.out.println("HELLO DIN JAVA");
		DateMasina date = new DateMasina();
		List<Masina> masina = date.findAll();

		String ordonare = request.getParameter("ordonare");
		if (ordonare != null) {

			String coloana = request.getParameter("coloana");

			if (coloana.equals("marca")) {
				if (ordonare.equals("asc")) {
					//
					Collections.sort(masina, (a1, a2) -> a1.getMarca().compareTo(a2.getMarca()));
				} else {
					//
					Collections.sort(masina, (a1, a2) -> a2.getMarca().compareTo(a1.getMarca()));
				}
			}else if(coloana.equals("id")){
				if (ordonare.equals("asc")) {
					//
					Collections.sort(masina, (a1, a2) -> a1.getId() - a2.getId() );
				} else {
					//
					Collections.sort(masina, (a1, a2) -> a2.getId() - a1.getId());
				}
			}
			// 
		}
	%>
	
	<h3>Adaugare masina</h3>
		<form action="MasinaServlet" method="post" style="width: 50%">
		Marca: 
		<input name="marca" class="form-control"><br> Model: <input
			class="form-control" name="model"><br> Capacitate: <input
			class="form-control" name="capacitate"><br> Nr_inmatriculare: <input
			class="form-control" name="nr_inmatriculare"><br>
			<input type="submit" value="Salveaza masina">
	</form>	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id <a href="masina.jsp?ordonare=asc&coloana=id">Asc</a> <a
					href="masina.jsp?ordonare=desc&coloana=id">Desc</a>
				</th>
				<th>Marca <a href="masina.jsp?ordonare=asc&coloana=nume">Asc</a>
					<a href="masina.jsp?ordonare=desc&coloana=nume">Desc</a>
				</th>
				<th>Model</th>
				<th>Capacitate</th>
				<th>Nr_inmatriculare</th>
				<th>Actiuni</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Masina a : masina) {
					out.println("<tr>");
					out.println("<td>" + a.getId() + "</td><td>" + a.getMarca() + "</td><td>" + a.getModel() + "</td>");
					out.println("<td>");
					out.println(a.getCapacitate());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getNr_inmatriculare());
					out.println("</td>");
					
					out.println("<td>");
					out.println("<a class='btn btn-danger' href='MasinaServlet?id-de-sters=" + a.getId() + "'>Sterge</a>");
					out.println("<a href='masina-edit.jsp?id-masina-editare="+a.getId()+"'>Editare</a>");
					out.println("</td>");

					out.println("</tr>");
				}
			%>

		</tbody>
	</table>



</body>
</html>