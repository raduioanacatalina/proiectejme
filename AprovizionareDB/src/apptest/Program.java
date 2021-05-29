package apptest;

import java.util.List;

import date.DateAngajat;
import model.Angajat;

public class Program {

	
	public static void main(String[] args) {
		
		
		DateAngajat date = new DateAngajat();
//		List<Angajat> angajatii = date.findAll();
//		for(Angajat a : angajatii) {
//			System.out.println("ANGAJAT: " + a);
//		}
		Angajat a = new Angajat();
		a.setNume("Testescu");
		a.setPrenume("Test");
		a.setTelefon("071111222");
		
		date.save(a);
	}
	
}
