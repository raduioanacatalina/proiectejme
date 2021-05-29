package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import date.DateDepartament;
import model.Departament;


@WebServlet("/DepartamentServlet")
public class DepartamentServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id-de-sters"));
		System.out.println("Stergem dept: " + id);
		DateDepartament date = new DateDepartament();
		date.delete(id);
		response.sendRedirect("departament.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String denumire = request.getParameter("denumire-departament");
		
		Departament departament = new Departament();
		departament.setDenumire(denumire);
		DateDepartament date = new DateDepartament();
		
		if(request.getParameter("id-departament") != null) {
			// editare
			departament.setId(Integer.valueOf(request.getParameter("id-departament")));
			date.update(departament);
		}else {
			// inserare
			date.save(departament);
		}
		
		
		
		
		
		response.sendRedirect("departament.jsp");
	}

}
