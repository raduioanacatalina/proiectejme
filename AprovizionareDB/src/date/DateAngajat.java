package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Angajat;

public class DateAngajat {

	public void delete(int idAngajat) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			stmt.executeUpdate("DELETE FROM angajat WHERE id_angajat = " + idAngajat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// INSERT INTO angajati(...) VALUES(...)
	public void save(Angajat anou) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			PreparedStatement pstmt = conexiune.prepareStatement(
					"INSERT INTO angajat(nume, prenume,oras, strada, numar, salariu, telefon) VALUES(?, ?, ?,?,?,?,?)");

			pstmt.setString(1, anou.getNume());
			pstmt.setString(2, anou.getPrenume());
			pstmt.setString(3, anou.getOras());
			pstmt.setString(4, anou.getStrada());
			pstmt.setString(5, anou.getNumar());
			pstmt.setDouble(6, anou.getSalariu());
			pstmt.setString(7, anou.getTelefon());

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Angajat anou) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
//			PreparedStatement pstmt = conexiune.prepareStatement(
//					"INSERT INTO angajat(nume, prenume,oras, strada, numar, salariu, telefon) VALUES(?, ?, ?,?,?,?,?)");
			PreparedStatement pstmt = conexiune
					.prepareStatement("UPDATE angajat SET nume = ?, prenume = ?, oras = ?, strada = ?, numar = ?, salariu = ?, telefon = ? WHERE id_angajat = ?");
			pstmt.setString(1, anou.getNume());
			pstmt.setString(2, anou.getPrenume());
			pstmt.setString(3, anou.getOras());
			pstmt.setString(4, anou.getStrada());
			pstmt.setString(5, anou.getNumar());
			pstmt.setDouble(6, anou.getSalariu());
			pstmt.setString(7, anou.getTelefon());
			pstmt.setInt(8, anou.getId());

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Angajat findById(int idAngajat) {
		Angajat angajatGasit = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM angajat where id_angajat = " + idAngajat);
			
			while (randuri.next()) {
				angajatGasit = new Angajat();
				angajatGasit.setId(randuri.getInt("id_angajat"));
				angajatGasit.setNume(randuri.getString("nume"));
				angajatGasit.setPrenume(randuri.getString("prenume"));
				angajatGasit.setOras(randuri.getString("oras"));
				angajatGasit.setStrada(randuri.getString("strada"));
				angajatGasit.setNumar(randuri.getString("numar"));
				angajatGasit.setSalariu(randuri.getDouble("salariu"));
				angajatGasit.setTelefon(randuri.getString("telefon"));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return angajatGasit;
	}

	public List<Angajat> findAll() {

		List<Angajat> angajatiDb = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			// SELECT * from angajat;
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM angajat");

			while (randuri.next()) {
				Angajat angajat = new Angajat();
				angajat.setId(randuri.getInt("id_angajat"));
				angajat.setNume(randuri.getString("nume"));
				angajat.setPrenume(randuri.getString("prenume"));
				angajat.setOras(randuri.getString("oras"));
				angajat.setStrada(randuri.getString("strada"));
				angajat.setNumar(randuri.getString("numar"));
				angajat.setSalariu(randuri.getDouble("salariu"));
				angajat.setTelefon(randuri.getString("telefon"));

				angajatiDb.add(angajat);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return angajatiDb;
	}

}
