package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Angajat;
import model.Masina;

public class DateMasina {
	
	public void delete(int idMasina) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			stmt.executeUpdate("DELETE FROM masina WHERE id_masina = " + idMasina);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void save(Masina anou) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			PreparedStatement pstmt = conexiune.prepareStatement(
					"INSERT INTO masina(marca, model,capacitate, nr_inmatriculare) VALUES(?, ?, ?,?)");

			pstmt.setString(1, anou.getMarca());
			pstmt.setString(2, anou.getModel());
			pstmt.setString(3, anou.getCapacitate());
			pstmt.setString(4, anou.getNr_inmatriculare());
			

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Masina anou) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			
			PreparedStatement pstmt = conexiune
					.prepareStatement("UPDATE masina SET marca = ?, model = ?, capacitate = ?, nr_inmatriculare = ? WHERE id_masina = ?");
			pstmt.setString(1, anou.getMarca());
			pstmt.setString(2, anou.getModel());
			pstmt.setString(3, anou.getCapacitate());
			pstmt.setString(4, anou.getNr_inmatriculare());
			

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Masina findById(int idMasina) {
		Masina masinaGasit = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM masina where id_masina = " + idMasina);
			
			while (randuri.next()) {
				masinaGasit = new Masina();
				masinaGasit.setId(randuri.getInt("id_masina"));
				masinaGasit.setMarca(randuri.getString("marca"));
				masinaGasit.setModel(randuri.getString("model"));
				masinaGasit.setCapacitate(randuri.getString("capacitate"));
				masinaGasit.setNr_inmatriculare(randuri.getString("nr_inmatriculare"));
				

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return masinaGasit;
	}


	public List<Masina> findAll() {

		List<Masina> masinaDb = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM masina");

			while (randuri.next()) {
				Masina masina = new Masina();
				masina.setId(randuri.getInt("id_masina"));
				masina.setMarca(randuri.getString("marca"));
				masina.setModel(randuri.getString("model"));
				masina.setCapacitate(randuri.getString("capacitate"));
				masina.setNr_inmatriculare(randuri.getString("nr_inmatriculare"));

				masinaDb.add(masina);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return masinaDb;
	}

}
