<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="model.Departament"%>
<%@ page import="date.DateDepartament"%>
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
	<h2>Departamente</h2>
	<%
	DateDepartament date = new DateDepartament();
		List<Departament> departamente = date.findAll();

		String ordonare = request.getParameter("ordonare");
		if (ordonare != null) {

			String coloana = request.getParameter("coloana");

			if (coloana.equals("nume")) {
				if (ordonare.equals("asc")) {
					//
					Collections.sort(departamente, (a1, a2) -> a1.getDenumire().compareTo(a2.getDenumire()));
				} else {
					//
					Collections.sort(departamente, (a1, a2) -> a2.getDenumire().compareTo(a1.getDenumire()));
				}
			}else if(coloana.equals("id")){
				if (ordonare.equals("asc")) {
					//
					Collections.sort(departamente, (a1, a2) -> a1.getId() - a2.getId() );
				} else {
					//
					Collections.sort(departamente, (a1, a2) -> a2.getId() - a1.getId());
				}
			}
			// 
		}
	%>
	
	<h3>Adaugare departament</h3>
		<form action="DepartamentServlet" method="post" style="width: 50%">
		 
		 Denumire: <input class="form-control" name="denumire-departament"><br> <input type="submit" value="Salveaza departament">
	</form>
	
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Id <a href="departament.jsp?ordonare=asc&coloana=id">Asc</a> <a
					href=departament.jsp?ordonare=desc&coloana=id">Desc</a>
				</th>
				<th>Denumire <a href="departament.jsp?ordonare=asc&coloana=nume">Asc</a>
					<a href="departament.jsp?ordonare=desc&coloana=nume">Desc</a>
				</th>
				<th>Actiuni</th>
				
			</tr>
		</thead>
		<tbody>
			<%
				for (Departament a : departamente) {
					out.println("<tr>");
					out.println("<td>" + a.getId() + "</td><td>" + a.getDenumire() + "</td>");
					
					out.println("<td>");
					out.println("<a class='btn btn-danger' href='DepartamentServlet?id-de-sters=" + a.getId() + "'>Sterge</a>");
					out.println("<a href='departament-edit.jsp?id-departament-editare="+a.getId()+"'>Editare</a>");
					out.println("</td>");

					out.println("</tr>");
				}
			%>

		</tbody>
	</table>



</body>
</html>