package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import date.DateAngajat;
import date.DateAprovizionare;
import model.Angajat;
import model.Aprovizionare;

/**
 * Servlet implementation class AprovizionareServlet
 */
@WebServlet("/AprovizionareServlet")
public class AprovizionareServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer idAprovizionare = Integer.valueOf(request.getParameter("id-de-sters"));
		System.out.println("Stergem aprovizionarea: " + idAprovizionare);
		DateAprovizionare date = new DateAprovizionare();
		date.delete(idAprovizionare);
		response.sendRedirect("aprovizionare.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String descriere = request.getParameter("descriere-aprovizionare");
		
		Aprovizionare aprov = new Aprovizionare();
		aprov.setDescriere(descriere);
		DateAprovizionare date = new DateAprovizionare();
		
		if(request.getParameter("id-aprovizionare") != null) {
			// editare
			aprov.setId(Integer.valueOf(request.getParameter("id-aprovizionare")));
			date.update(aprov);
		}else {
			// inserare
			date.save(aprov);
		}
		
		
		
		
		
		response.sendRedirect("aprovizionare.jsp");
	}

}
