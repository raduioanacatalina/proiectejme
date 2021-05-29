<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateMagazin"%>
<%@ page import="model.Magazin"%>
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
	<h2>Magazine</h2>
	<%
		System.out.println("HELLO DIN JAVA");
		DateMagazin date = new DateMagazin();
		List<Magazin> magazine = date.findAll();

		String ordonare = request.getParameter("ordonare");
		if (ordonare != null) {

			String coloana = request.getParameter("coloana");

			if (coloana.equals("denumire")) {
				if (ordonare.equals("asc")) {
					//
					Collections.sort(magazine, (a1, a2) -> a1.getDenumire().compareTo(a2.getDenumire()));
				} else {
					//
					Collections.sort(magazine, (a1, a2) -> a2.getDenumire().compareTo(a1.getDenumire()));
				}
			}else if(coloana.equals("id")){
				if (ordonare.equals("asc")) {
					//
					Collections.sort(magazine, (a1, a2) -> a1.getId() - a2.getId() );
				} else {
					//
					Collections.sort(magazine, (a1, a2) -> a2.getId() - a1.getId());
				}
			}
			// 
		}
	%>
	
	<h3>Adaugare magazin</h3>
		<form action="MagazinServlet" method="post" style="width: 50%">
		Denumire: 
		<input name="denumire" class="form-control"><br> Telefon: <input
			class="form-control" name="telefon"><br> Strada: <input
			class="form-control" name="strada"><br> Numar: <input
			class="form-control" name="numar"><br> Oras: <input
			class="form-control" name="oras"><br> Cod_postal: 
			<input type="number" class="form-control" name="cod_postal"><br> 
			<input type="submit" value="Salveaza magazin">
	</form>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id <a href="magazine.jsp?ordonare=asc&coloana=id">Asc</a> <a
					href="magazine.jsp?ordonare=desc&coloana=id">Desc</a>
				</th>
				<th>Denumire <a href="magazine.jsp?ordonare=asc&coloana=nume">Asc</a>
					<a href="magazine.jsp?ordonare=desc&coloana=nume">Desc</a>
				</th>
				<th>Telefon</th>
				<th>Strada</th>
				<th>Numar</th>
				<th>Oras</th>
				<th>Cod_postal</th>
				<th>Actiuni</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Magazin a : magazine) {
					out.println("<tr>");
					out.println("<td>" + a.getId() + "</td><td>" + a.getDenumire() + "</td><td>" + a.getTelefon() + "</td>");
					out.println("<td>");
					out.println(a.getStrada());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getNumar());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getOras());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getCod_postal());
					out.println("</td>");
					out.println("<td>");
					out.println("<a class='btn btn-danger' href='MagazinServlet?id-de-sters=" + a.getId() + "'>Sterge</a>");
					out.println("<a href='magazin-edit.jsp?id-magazin-editare="+a.getId()+"'>Editare</a>");
					out.println("</td>");

					out.println("</tr>");
				}
			%>

		</tbody>
	</table>



</body>
</html>