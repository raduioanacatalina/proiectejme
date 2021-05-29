package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import date.DateAngajat;
import date.DateFurnizor;
import model.Angajat;
import model.Furnizor;

@WebServlet("/FurnizorServlet")
public class FurnizorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FurnizorServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("HELLO DIN SERVLET - doGet");
		Integer idFurnizor = Integer.valueOf(request.getParameter("id-de-sters"));
		System.out.println("Stergem furnizorul: " + idFurnizor);
		DateFurnizor date = new DateFurnizor();
		date.delete(idFurnizor);
		response.sendRedirect("furnizori.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("HELLO DIN SERVLET - doPost");

		String denumire = request.getParameter("denumire");
		String nume_strada = request.getParameter("nume_strada");
		String numar_strada = request.getParameter("numar_strada");
		String oras = request.getParameter("oras");
		String telefon = request.getParameter("telefon");

		Furnizor ang = new Furnizor();
		ang.setDenumire(denumire);
		ang.setNumar_strada(numar_strada);
		ang.setNume_strada(nume_strada);
		ang.setOras(oras);
		ang.setTelefon(telefon);

		DateFurnizor date = new DateFurnizor();

		if (request.getParameter("id-furnizor") != null) {
			// editare
			ang.setId(Integer.valueOf(request.getParameter("id-furnizor")));
			date.update(ang);
		} else {
			// inserare
			date.save(ang);
		}

		response.sendRedirect("furnizori.jsp");
	}

}
