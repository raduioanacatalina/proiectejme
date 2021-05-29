package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import date.DateMasina;
import model.Masina;


@WebServlet("/MasinaServlet")
public class MasinaServlet extends HttpServlet {
	

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			System.out.println("HELLO DIN SERVLET - doGet");
			Integer idMasina = Integer.valueOf(request.getParameter("id-de-sters"));
			System.out.println("Stergem masina: " + idMasina);
			DateMasina date = new DateMasina();
			date.delete(idMasina);
			response.sendRedirect("masina.jsp");

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
System.out.println("HELLO DIN SERVLET - doPost");
		
		
		String marca = request.getParameter("marca");
		String model = request.getParameter("model");
		String capacitate = request.getParameter("capacitate");
		String nr_inmatriculare = request.getParameter("nr_inmatriculare");
		
		
		
		Masina ang = new Masina();
		ang.setMarca(marca);
		ang.setModel(model);
		ang.setCapacitate(capacitate);
		ang.setNr_inmatriculare(nr_inmatriculare);
		
		DateMasina date = new DateMasina();
		
		if(request.getParameter("id-masina") != null) {
			// editare
			ang.setId(Integer.valueOf(request.getParameter("id-masina")));
			date.update(ang);
		}else {
			// inserare
			date.save(ang);
		}
		
		
		
		
		
		response.sendRedirect("masina.jsp");
	}


		
		
	}


