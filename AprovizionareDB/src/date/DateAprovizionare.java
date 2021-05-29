package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Aprovizionare;
import model.Departament;

public class DateAprovizionare {

	public void delete(int idAprovizionare) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			stmt.executeUpdate("DELETE FROM aprovizionare WHERE id_aprovizionare = " + idAprovizionare);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void save(Aprovizionare aprovizionare) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			PreparedStatement pstmt = conexiune.prepareStatement(
					"INSERT INTO aprovizionare(descriere) VALUES(?)");

			pstmt.setString(1, aprovizionare.getDescriere());

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Aprovizionare aprovizionare) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			PreparedStatement pstmt = conexiune
					.prepareStatement("UPDATE aprovizionare SET descriere = ? WHERE id_aprovizionare = ?");
			
			pstmt.setString(1,  aprovizionare.getDescriere());
			pstmt.setInt(2, aprovizionare.getId());

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Aprovizionare findById(int idAprovizionare) {
		Aprovizionare aprovizionareGasita = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM aprovizionare where id_aprovizionare = " + idAprovizionare);
			
			while (randuri.next()) {
				aprovizionareGasita = new Aprovizionare();
				aprovizionareGasita.setId(randuri.getInt("id_aprovizionare"));
				aprovizionareGasita.setDescriere(randuri.getString("descriere"));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aprovizionareGasita;
	}

	public List<Aprovizionare> findAll() {

		List<Aprovizionare> aprovizionari = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			// SELECT * from angajat;
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM aprovizionare");

			while (randuri.next()) {
				Aprovizionare aprovizionareGasita = new Aprovizionare();
				aprovizionareGasita.setId(randuri.getInt("id_aprovizionare"));
				aprovizionareGasita.setDescriere(randuri.getString("descriere"));

				aprovizionari.add(aprovizionareGasita);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return aprovizionari;
	}

}
