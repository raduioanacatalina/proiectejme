package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import date.DateAngajat;
import model.Angajat;


@WebServlet("/AngajatServlet")
public class AngajatServlet extends HttpServlet {
	
	
	// delete un angajat
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HELLO DIN SERVLET - doGet");
		Integer idAngajat = Integer.valueOf(request.getParameter("id-de-sters"));
		System.out.println("Stergem angajatul: " + idAngajat);
		DateAngajat date = new DateAngajat();
		date.delete(idAngajat);
		response.sendRedirect("angajati.jsp");

	}

	
	// save un angajat
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HELLO DIN SERVLET - doPost");
		
		
		String numeAngajat = request.getParameter("nume-angajat");
		String prenumeAngajat = request.getParameter("prenume-angajat");
		String oras = request.getParameter("oras-angajat");
		String strada = request.getParameter("strada-angajat");
		String numar = request.getParameter("numar-angajat");
		Double salariu = Double.valueOf(request.getParameter("salariu-angajat"));
		String telefon = request.getParameter("telefon-angajat");
		
		Angajat ang = new Angajat();
		ang.setNume(numeAngajat);
		ang.setPrenume(prenumeAngajat);
		ang.setNumar(numar);
		ang.setStrada(strada);
		ang.setTelefon(telefon);
		ang.setSalariu(salariu);
		ang.setOras(oras);
		
		DateAngajat date = new DateAngajat();
		
		if(request.getParameter("id-angajat") != null) {
			// editare
			ang.setId(Integer.valueOf(request.getParameter("id-angajat")));
			date.update(ang);
		}else {
			// inserare
			date.save(ang);
		}
		
		
		
		
		
		response.sendRedirect("angajati.jsp");
	}

}
