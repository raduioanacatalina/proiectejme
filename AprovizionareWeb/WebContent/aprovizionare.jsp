<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Aprovizionare"%>
<%@ page import="date.DateAprovizionare"%>
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
	<h2>Aprovizionare</h2>
	<%
		DateAprovizionare date = new DateAprovizionare();
		List<Aprovizionare> aprovizionari = date.findAll();

		String ordonare = request.getParameter("ordonare");
		if (ordonare != null) {

			String coloana = request.getParameter("coloana");

			if (coloana.equals("nume")) {
				if (ordonare.equals("asc")) {
					//
					Collections.sort(aprovizionari, (a1, a2) -> a1.getDescriere().compareTo(a2.getDescriere()));
				} else {
					//
					Collections.sort(aprovizionari, (a1, a2) -> a2.getDescriere().compareTo(a1.getDescriere()));
				}
			}else if(coloana.equals("id")){
				if (ordonare.equals("asc")) {
					//
					Collections.sort(aprovizionari, (a1, a2) -> a1.getId() - a2.getId() );
				} else {
					//
					Collections.sort(aprovizionari, (a1, a2) -> a2.getId() - a1.getId());
				}
			}
			// 
		}
	%>
	
	<h3>Adaugare aprovizionare</h3>
		<form action="AprovizionareServlet" method="post" style="width: 50%">
		 
		 Descriere aprovizionare: <input class="form-control" name="descriere-aprovizionare"><br> <input type="submit" value="Salveaza aprovizionare">
	</form>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id <a href="aprovizionare.jsp?ordonare=asc&coloana=id">Asc</a> <a
					href="aprovizionare.jsp?ordonare=desc&coloana=id">Desc</a>
				</th>
				<th>Descriere <a href="aprovizionare.jsp?ordonare=asc&coloana=nume">Asc</a>
					<a href="aprovizionare.jsp?ordonare=desc&coloana=nume">Desc</a>
				</th>
				<th>Actiuni</th>
				
			</tr>
		</thead>
		<tbody>
			<%
				for (Aprovizionare a : aprovizionari) {
					out.println("<tr>");
					out.println("<td>" + a.getId() + "</td><td>" + a.getDescriere() + "</td>");
					
					out.println("<td>");
					out.println("<a class='btn btn-danger' href='AprovizionareServlet?id-de-sters=" + a.getId() + "'>Sterge</a>");
					out.println("<a href='aprovizionare-edit.jsp?id-aprovizionare-editare="+a.getId()+"'>Editare</a>");
					out.println("</td>");

					out.println("</tr>");
				}
			%>

		</tbody>
	</table>



</body>
</html>