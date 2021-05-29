package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import date.DateProdus;
import model.Produs;


@WebServlet("/ProdusServlet")
public class ProdusServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("HELLO DIN SERVLET - doGet");
		Integer idProdus = Integer.valueOf(request.getParameter("id-de-sters"));
		System.out.println("Stergem produsul: " + idProdus);
		DateProdus date = new DateProdus();
		date.delete(idProdus);
		response.sendRedirect("produse.jsp");

	
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
System.out.println("HELLO DIN SERVLET - doPost");
		
		
		String denumireProdus = request.getParameter("denumire");
		Double pret = Double.valueOf(request.getParameter("pret"));
		
		
		Produs prod = new Produs();
		prod.setDenumire(denumireProdus);
		prod.setPret(pret);
		
		
		DateProdus date = new DateProdus();
		
		if(request.getParameter("id-angajat") != null) {
			// editare
			prod.setId(Integer.valueOf(request.getParameter("id-produs")));
			date.update(prod);
		}else {
			// inserare
			date.save(prod);
		}
		
		
		
		
		
		response.sendRedirect("produse.jsp");
	}
		
	}

