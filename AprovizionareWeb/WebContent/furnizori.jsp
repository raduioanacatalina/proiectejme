<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateFurnizor"%>
<%@ page import="model.Furnizor"%>
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
	<h2>Furnizori</h2>
	<%
		System.out.println("HELLO DIN JAVA");
		DateFurnizor date = new DateFurnizor();
		List<Furnizor> furnizori = date.findAll();

		String ordonare = request.getParameter("ordonare");
		if (ordonare != null) {

			String coloana = request.getParameter("coloana");

			if (coloana.equals("nume")) {
				if (ordonare.equals("asc")) {
					//
					Collections.sort(furnizori, (a1, a2) -> a1.getDenumire().compareTo(a2.getDenumire()));
				} else {
					//
					Collections.sort(furnizori, (a1, a2) -> a2.getDenumire().compareTo(a1.getDenumire()));
				}
			}else if(coloana.equals("id")){
				if (ordonare.equals("asc")) {
					//
					Collections.sort(furnizori, (a1, a2) -> a1.getId() - a2.getId() );
				} else {
					//
					Collections.sort(furnizori, (a1, a2) -> a2.getId() - a1.getId());
				}
			}
			// 
		}
	%>
	
	<h3>Adaugare furnizor</h3>
		<form action="FurnizorServlet" method="post" style="width: 50%">
		Denumire: 
		<input name="denumire" class="form-control"><br> Nume_strada: <input
			class="form-control" name="nume_strada"><br> Numar_strada: <input
			class="form-control" name="numar_strada"><br> Oras: <input
			class="form-control" name="oras"><br> Telefon: <input
			class="form-control" name="telefon"><br> <input type="submit" value="Salveaza furnizor">
	</form>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id <a href="furnizori.jsp?ordonare=asc&coloana=id">Asc</a> <a
					href="furnizori.jsp?ordonare=desc&coloana=id">Desc</a>
				</th>
				<th>Denumire <a href="furnizori.jsp?ordonare=asc&coloana=nume">Asc</a>
					<a href="furnizori.jsp?ordonare=desc&coloana=nume">Desc</a>
				</th>
				<th>Nume_strada</th>
				<th>Numar_strada</th>
				<th>Oras</th>
				<th>Telefon</th>
				
				<th>Actiuni</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Furnizor a : furnizori) {
					out.println("<tr>");
					out.println("<td>" + a.getId() + "</td><td>" + a.getDenumire() + "</td><td>" + a.getNume_strada() + "</td>");
					out.println("<td>");
					out.println(a.getNumar_strada());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getOras());
					out.println("</td>");
					out.println("<td>");
					out.println(a.getTelefon());
					out.println("</td>");
					
					out.println("<td>");
					out.println("<a class='btn btn-danger' href='FurnizorServlet?id-de-sters=" + a.getId() + "'>Sterge</a>");
					out.println("<a href='furnizori-edit.jsp?id-furnizor-editare="+a.getId()+"'>Editare</a>");
					out.println("</td>");

					out.println("</tr>");
				}
			%>

		</tbody>
	</table>



</body>
</html>