package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Magazin;

public class DateMagazin {
	
	public void delete(int idMagazin) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			stmt.executeUpdate("DELETE FROM magazin WHERE id_magazin = " + idMagazin);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	public void update(Magazin anou) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			PreparedStatement pstmt = conexiune
					.prepareStatement("UPDATE magazin SET denumire = ?, telefon, strada = ?, numar = ?, oras=?, cod_postal = ? WHERE id_magazin = ?");
			pstmt.setString(1, anou.getDenumire());
			pstmt.setString(2, anou.getTelefon());
			pstmt.setString(3, anou.getStrada());
			pstmt.setString(4, anou.getNumar());
			pstmt.setString(5, anou.getOras());
			pstmt.setString(6, anou.getCod_postal());

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Magazin findById(int idMagazin) {
		Magazin magazinGasit = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM magazin where id_magazin = " + idMagazin);
			
			while (randuri.next()) {
				magazinGasit = new Magazin();
				magazinGasit.setId(randuri.getInt("id_magazin"));
				magazinGasit.setDenumire(randuri.getString("denumire"));
				magazinGasit.setTelefon(randuri.getString("telefon"));
				magazinGasit.setStrada(randuri.getString("strada"));
				magazinGasit.setNumar(randuri.getString("numar"));
				magazinGasit.setOras(randuri.getString("oras"));
				magazinGasit.setCod_postal(randuri.getString("cod_postal"));
				

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return magazinGasit;
	}

	
	public List<Magazin> findAll(){
		

		List<Magazin> magazinDb = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root", "1234");
			
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM magazin");
			
			while(randuri.next()) {
				Magazin magazin = new Magazin();
				magazin.setId(randuri.getInt("id_magazin"));
				magazin.setDenumire(randuri.getString("denumire"));
				magazin.setTelefon(randuri.getString("telefon"));
				magazin.setStrada(randuri.getString("strada"));
				magazin.setNumar(randuri.getString("numar"));
				magazin.setOras(randuri.getString("oras"));
				magazin.setCod_postal(randuri.getString("cod_postal"));
				
				magazinDb.add(magazin);
			}
		}catch(Exception e) {
			e.printStackTrace();
	}
		
		return magazinDb;
	}
	
	public void save(Magazin magazinNou) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root", "1234");
			PreparedStatement pstmt = conexiune.prepareStatement("INSERT INTO magazin (denumire,telefon, strada, numar, oras, cod_postal) VALUES(?, ?, ?,?,?,?)");
			
			pstmt.setString(1, magazinNou.getDenumire());
			pstmt.setString(2, magazinNou.getTelefon());
			pstmt.setString(3, magazinNou.getStrada());
			pstmt.setString(4, magazinNou.getNumar());
			pstmt.setString(5, magazinNou.getOras());
			pstmt.setString(6, magazinNou.getCod_postal());
			
			
			
			pstmt.executeUpdate(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
