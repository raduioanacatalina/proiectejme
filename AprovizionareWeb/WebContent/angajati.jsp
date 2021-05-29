<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateAngajat"%>
<%@ page import="model.Angajat"%>
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
	<h2>Angajati</h2>
	<%
		System.out.println("HELLO DIN JAVA");
		DateAngajat date = new DateAngajat();
		List<Angajat> angajati = date.findAll();

		String ordonare = request.getParameter("ordonare");
		if (ordonare != null) {

			String coloana = request.getParameter("coloana");

			if (coloana.equals("nume")) {
				if (ordonare.equals("asc")) {
					//
					Collections.sort(angajati, (a1, a2) -> a1.getNume().compareTo(a2.getNume()));
				} else {
					//
					Collections.sort(angajati, (a1, a2) -> a2.getNume().compareTo(a1.getNume()));
				}
			}else if(coloana.equals("id")){
				if (ordonare.equals("asc")) {
					//
					Collections.sort(angajati, (a1, a2) -> a1.getId() - a2.getId() );
				} else {
					//
					Collections.sort(angajati, (a1, a2) -> a2.getId() - a1.getId());
				}
			}
			// 
		}
	%>
	
	<h3>Adaugare angajat</h3>
		<form action="AngajatServlet" method="post" style="width: 50%">
		Nume: 
		<input name="nume-angajat" class="form-control"><br> Prenume: <input
			class="form-control" name="prenume-angajat"><br> Oras: <input
			class="form-control" name="oras-angajat"><br> Strada: <input
			class="form-control" name="strada-angajat"><br> Numar: <input
			class="form-control" name="numar-angajat"><br> Salariu: 
			<input type="number" class="form-control" name="salariu-angajat"><br> Telefon: <input
			class="form-control" name="telefon-angajat"><br> <input type="submit" value="Salveaza angajat">
	</form>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id <a href="angajati.jsp?ordonare=asc&coloana=id">Asc</a> <a
					href="angajati.jsp?ordonare=desc&coloana=id">Desc</a>
				</th>
				<th>Nume <a href="angajati.jsp?ordonare=asc&coloana=nume">Asc</a>
					<a href="angajati.jsp?ordonare=desc&coloana=nume">Desc</a>
				</th>
				<th>Prenume</th>
				<th>Oras</th>
				<th>Strada</th>
				<th>Telefon</th>
				<th>Salariu</th>
				<th>Actiuni</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Angajat a : angajati) {
					out.println("<tr>");
					out.println("<td>" + a.getId() + "</td><td>" + a.getNume() + "</td><td>" + a.getPrenume() + "</td>");
					out.println("<td>");
					out.println(a.getOras());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getStrada());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getTelefon());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getSalariu());
					out.println("</td>");
					out.println("<td>");
					out.println("<a class='btn btn-danger' href='AngajatServlet?id-de-sters=" + a.getId() + "'>Sterge</a>");
					out.println("<a href='angajati-edit.jsp?id-angajat-editare="+a.getId()+"'>Editare</a>");
					out.println("</td>");

					out.println("</tr>");
				}
			%>

		</tbody>
	</table>



</body>
</html>