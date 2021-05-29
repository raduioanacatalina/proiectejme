package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import date.DateMagazin;
import model.Magazin;

@WebServlet("/MagazinServlet")
public class MagazinServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("HELLO DIN SERVLET - doGet");
		Integer idMagazin = Integer.valueOf(request.getParameter("id-de-sters"));
		System.out.println("Stergem magazinul: " + idMagazin);
		DateMagazin date = new DateMagazin();
		date.delete(idMagazin);
		response.sendRedirect("magazine.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("HELLO DIN SERVLET - doPost");

		String denumire = request.getParameter("denumire");
		String telefon = request.getParameter("telefon");
		String strada = request.getParameter("strada");
		String numar = request.getParameter("numar");
		String oras = request.getParameter("oras");
		String cod_postal = request.getParameter("cod_postal");

		Magazin ang = new Magazin();
		ang.setDenumire(denumire);
		ang.setTelefon(telefon);
		ang.setStrada(strada);
		ang.setNumar(numar);
		ang.setOras(oras);
		ang.setCod_postal(cod_postal);

		DateMagazin date = new DateMagazin();

		if (request.getParameter("id-magazin") != null) {
			// editare
			ang.setId(Integer.valueOf(request.getParameter("id-magazin")));
			date.update(ang);
		} else {
			// inserare
			date.save(ang);
		}

		response.sendRedirect("magazine.jsp");
	}

}
