<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="model.Raport"%>
<%@ page import="date.DateRaport"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="model.TotalVanzare"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Raport</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body class="container">
<%@ include file="meniu.jsp" %>
	

	<form>
		Cautare simple: <input name="denumire-magazin"
			placeholder="Denumire magazin"><br> <input type="submit"
			value="Cauta">
	</form>

	<form>
		Cautare advanced: <input name="denumire-magazin"
			placeholder="Denumire magazin"><br> <input
			id="data-start" name="data-start" placeholder="Data start"><br>
		<input id="data-end" name="data-end" placeholder="Data sfarsit"><br>

		<input type="submit" value="Cauta">
	</form>

	<%
		DateRaport date = new DateRaport();
		List<Raport> rapoarte = null;
		String denumireMagazin = request.getParameter("denumire-magazin");
		if (denumireMagazin != null) {

			if (request.getParameter("data-start") != null) {
				// cautare avansata
				String dataStart = request.getParameter("data-start");
				String dataEnd = request.getParameter("data-end");
				rapoarte = date.findAllSearchAdvancedNumeMagazinSiData(denumireMagazin, dataStart, dataEnd);
			} else {
				// cautare simpla
				rapoarte = date.findAllSearchNumeMagazin(denumireMagazin);
			}

		} else {
			rapoarte = date.findAll();
		}
	%>

	<table class="table table-bordered" style="margin-top: 30px;">
		<thead>
			<tr>
				<th>Denumire Magazin</th>
				<th>Denumire Produs</th>
				<th>Detalii</th>
				<th>Nume Angajat</th>
				<th>Prenume Angajat</th>
				<th>Telefon Angajat</th>
				<th>Cantitate</th>
				<th>Data livrare</th>
				<th>Pret produs</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Raport r : rapoarte) {
					out.println("<tr>");

					out.println("<td>");
					out.println(r.getDenumireMagazin());
					out.println("</td>");
					out.println("<td>");
					out.println(r.getDenumireProdus());
					out.println("</td>");
					out.println("<td>");
					out.println(r.getDetalii());
					out.println("</td>");
					out.println("<td>");
					out.println(r.getNumeAngajat());
					out.println("</td>");
					out.println("<td>");
					out.println(r.getPrenumeAngajat());
					out.println("</td>");
					out.println("<td>");
					out.println(r.getTelefonAngajat());
					out.println("</td>");
					out.println("<td>");
					out.println(r.getCantitate());
					out.println("</td>");
					out.println("<td>");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

					out.println(sdf.format(r.getData()));
					out.println("</td>");
					out.println("<td>");
					out.println(r.getPret());
					out.println("</td>");

					out.println("</tr>");
				}
			%>

		</tbody>
	</table>


	<form>
		Cantitate minima total vanzari: <input placeholder="Vanzari minime"
			name="vanzari-minime"> <input type="submit" value="Afisare">
	</form>

	<%
		List<TotalVanzare> totalVanzari = null;
		if (request.getParameter("vanzari-minime") == null) {
			totalVanzari = date.findTotalVanzari();
		}else{
			totalVanzari = date.findTotalVanzariCuVanzariMinimeX(Integer.valueOf(request.getParameter("vanzari-minime")));
		}
	%>

	<table class="table table-bordered"
		style="margin-top: 30px; width: 50%">
		<thead>
			<tr>
				<th>Id magazin</th>
				<th>Denumire Magazin</th>
				<th>Total vanzari</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (TotalVanzare tv : totalVanzari) {
			%>
			<tr>
				<td><%=tv.getIdMagazin()%></td>
				<td><%=tv.getDenumireMagazin()%></td>
				<td><%=tv.getTotalVanzari()%></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>

	<script>
		$('#data-start').datepicker({
			dateFormat : 'yy-mm-dd'
		});
		$('#data-end').datepicker({
			dateFormat : 'yy-mm-dd'
		});
	</script>
</body>
</html>