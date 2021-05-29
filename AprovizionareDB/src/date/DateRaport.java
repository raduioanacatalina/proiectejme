package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Raport;
import model.TotalVanzare;

public class DateRaport {

	public List<TotalVanzare> findTotalVanzariCuVanzariMinimeX(int vanzareMinima){
		List<TotalVanzare> totalVanzari = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("select view_total_vanzari.id_magazin, sum(TOTAL) TOTAL_VANZARI, m.denumire from view_total_vanzari " + 
					"    inner join magazin m on view_total_vanzari.id_magazin = m.id_magazin group by id_magazin having sum(TOTAL) > " + vanzareMinima);
			while(randuri.next()) {
				TotalVanzare tv = new TotalVanzare();
				
				tv.setDenumireMagazin(randuri.getString("denumire"));
				tv.setIdMagazin(randuri.getInt("id_magazin"));
				tv.setTotalVanzari(randuri.getInt("TOTAL_VANZARI"));
				
				totalVanzari.add(tv);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return totalVanzari;
	}
	
	public List<TotalVanzare> findTotalVanzari(){
		List<TotalVanzare> totalVanzari = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("select view_total_vanzari.id_magazin, sum(TOTAL) TOTAL_VANZARI, m.denumire from view_total_vanzari\r\n" + 
					"    inner join magazin m on view_total_vanzari.id_magazin = m.id_magazin group by id_magazin");
			while(randuri.next()) {
				TotalVanzare tv = new TotalVanzare();
				
				tv.setDenumireMagazin(randuri.getString("denumire"));
				tv.setIdMagazin(randuri.getInt("id_magazin"));
				tv.setTotalVanzari(randuri.getInt("TOTAL_VANZARI"));
				
				totalVanzari.add(tv);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return totalVanzari;
	}
	
	public List<Raport> findAllSearchAdvancedNumeMagazinSiData(String nume, String dataStart, String dataEnd) {

		List<Raport> rapoarte = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			// SELECT * from angajat;
			Statement stmt = conexiune.createStatement();
			String comanda = "select a.nume, a.prenume, a.telefon, l.data, l.detalii, m.denumire DENUMIRE_MAGAZIN, p.denumire DENUMIRE_PRODUS, pl.cantitate, p.pret from angajat a inner join livrare l " + 
					"	on a.id_angajat = l.id_angajat" + 
					"    inner join magazin m on m.id_magazin = l.id_magazin" + 
					"    inner join produs_livrat pl on pl.id_livrare = l.id_livrare" + 
					"    inner join produs p on p.id_produs = pl.id_produs WHERE m.denumire LIKE '%"+nume+"%' AND l.data BETWEEN '" + dataStart + "' AND '" + dataEnd+"'";
			System.out.println("COMANDA SQL SEARCH AVANSAT: " + comanda);
			ResultSet randuri = stmt.executeQuery(comanda);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			while (randuri.next()) {
				Raport raport = new Raport();
				raport.setNumeAngajat(randuri.getString("nume"));
				raport.setPrenumeAngajat(randuri.getString("prenume"));
				raport.setTelefonAngajat(randuri.getString("telefon"));
				raport.setData(sdf.parse(randuri.getString("data")));
				raport.setDetalii(randuri.getString("detalii"));
				raport.setDenumireMagazin(randuri.getString("DENUMIRE_MAGAZIN"));
				raport.setDenumireProdus(randuri.getString("DENUMIRE_PRODUS"));
				raport.setCantitate(randuri.getInt("cantitate"));
				raport.setPret(randuri.getDouble("pret"));
				rapoarte.add(raport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rapoarte;
	}
	
	
	public List<Raport> findAllSearchNumeMagazin(String nume) {

		List<Raport> rapoarte = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			// SELECT * from angajat;
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("select a.nume, a.prenume, a.telefon, l.data, l.detalii, m.denumire DENUMIRE_MAGAZIN, p.denumire DENUMIRE_PRODUS, pl.cantitate, p.pret from angajat a inner join livrare l " + 
					"	on a.id_angajat = l.id_angajat" + 
					"    inner join magazin m on m.id_magazin = l.id_magazin" + 
					"    inner join produs_livrat pl on pl.id_livrare = l.id_livrare" + 
					"    inner join produs p on p.id_produs = pl.id_produs WHERE m.denumire LIKE '%"+nume+"%'");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			while (randuri.next()) {
				Raport raport = new Raport();
				raport.setNumeAngajat(randuri.getString("nume"));
				raport.setPrenumeAngajat(randuri.getString("prenume"));
				raport.setTelefonAngajat(randuri.getString("telefon"));
				raport.setData(sdf.parse(randuri.getString("data")));
				raport.setDetalii(randuri.getString("detalii"));
				raport.setDenumireMagazin(randuri.getString("DENUMIRE_MAGAZIN"));
				raport.setDenumireProdus(randuri.getString("DENUMIRE_PRODUS"));
				raport.setCantitate(randuri.getInt("cantitate"));
				raport.setPret(randuri.getDouble("pret"));
				rapoarte.add(raport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rapoarte;
	}
	
	public List<Raport> findAll() {

		List<Raport> rapoarte = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			// SELECT * from angajat;
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("select * from raport");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			while (randuri.next()) {
				Raport raport = new Raport();
				raport.setNumeAngajat(randuri.getString("nume"));
				raport.setPrenumeAngajat(randuri.getString("prenume"));
				raport.setTelefonAngajat(randuri.getString("telefon"));
				raport.setData(sdf.parse(randuri.getString("data")));
				raport.setDetalii(randuri.getString("detalii"));
				raport.setDenumireMagazin(randuri.getString("DENUMIRE_MAGAZIN"));
				raport.setDenumireProdus(randuri.getString("DENUMIRE_PRODUS"));
				raport.setCantitate(randuri.getInt("cantitate"));
				raport.setPret(randuri.getDouble("pret"));
				rapoarte.add(raport);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rapoarte;
	}
}
