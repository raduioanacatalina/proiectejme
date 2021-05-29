<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="date.DateProdus"%>
<%@ page import="model.Produs"%>
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
	<h2>Produse</h2>
	<%
		System.out.println("HELLO DIN JAVA");
		DateProdus date = new DateProdus();
		List<Produs> produse = date.findAll();

		String ordonare = request.getParameter("ordonare");
		if (ordonare != null) {

			String coloana = request.getParameter("coloana");

			if (coloana.equals("denumire")) {
				if (ordonare.equals("asc")) {
					//
					Collections.sort(produse, (a1, a2) -> a1.getDenumire().compareTo(a2.getDenumire()));
				} else {
					//
					Collections.sort(produse, (a1, a2) -> a2.getDenumire().compareTo(a1.getDenumire()));
				}
			}else if(coloana.equals("id")){
				if (ordonare.equals("asc")) {
					//
					Collections.sort(produse, (a1, a2) -> a1.getId() - a2.getId() );
				} else {
					//
					Collections.sort(produse, (a1, a2) -> a2.getId() - a1.getId());
				}
			}
			// 
		}
	%>
	
	<h3>Adaugare produs</h3>
		<form action="ProdusServlet" method="post" style="width: 50%">
		Denumire: 
		<input name="denumire" class="form-control"><br> Pret: <input
			class="form-control" name="pret"><br>  <input type="submit" value="Salveaza produs">
	</form>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id <a href="produse.jsp?ordonare=asc&coloana=id">Asc</a> <a
					href="produse.jsp?ordonare=desc&coloana=id">Desc</a>
				</th>
				<th>Denumire <a href="produse.jsp?ordonare=asc&coloana=denumire">Asc</a>
					<a href="produse.jsp?ordonare=desc&coloana=denumire">Desc</a>
				</th>
				<th>Pret</th>
				<th>Actiuni</th>
				
			</tr>
		</thead>
		<tbody>
			<%
				for (Produs a : produse) {
					out.println("<tr>");
					out.println("<td>" + a.getId() + "</td><td>" + a.getDenumire() + "</td><td>" + a.getPret() + "</td>");
					
					out.println("<td>");
					out.println("<a class='btn btn-danger' href='ProdusServlet?id-de-sters=" + a.getId() + "'>Sterge</a>");
					out.println("<a href='produs-edit.jsp?id-produs-editare="+a.getId()+"'>Editare</a>");
					out.println("</td>");

					out.println("</tr>");
				}
			%>

		</tbody>
	</table>



</body>
</html>