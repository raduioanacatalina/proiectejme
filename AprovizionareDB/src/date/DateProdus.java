package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Angajat;
import model.Produs;

public class DateProdus {

	public List<Produs> findAll() {

		List<Produs> produsDb = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM produs");

			while (randuri.next()) {
				Produs produs = new Produs();
				produs.setId(randuri.getInt("id_produs"));
				produs.setDenumire(randuri.getString("denumire"));
				produs.setPret(randuri.getDouble("pret"));

				produsDb.add(produs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return produsDb;
	}

	public void save(Produs produsNou) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			PreparedStatement pstmt = conexiune.prepareStatement("INSERT INTO produs (denumire, pret) VALUES(?, ?)");

			pstmt.setString(1, produsNou.getDenumire());
			pstmt.setDouble(2, produsNou.getPret());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(Integer idProdus) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			stmt.executeUpdate("DELETE FROM produs WHERE id_produs = " + idProdus);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void update(Produs prod) {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			PreparedStatement pstmt = conexiune
					.prepareStatement("UPDATE produs SET denumire = ?, pret = ? WHERE id_produs = ?");
			pstmt.setString(1, prod.getDenumire());
			pstmt.setDouble(2, prod.getPret());
			
			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Produs findById(int idProdus) {
		Produs produsGasit = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM produs where id_produs = " + idProdus);
			
			while (randuri.next()) {
				produsGasit = new Produs();
				produsGasit.setId(randuri.getInt("id_produs"));
				produsGasit.setDenumire(randuri.getString("denumire"));
				produsGasit.setPret(randuri.getDouble("pret"));
				

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produsGasit;
	}

}
