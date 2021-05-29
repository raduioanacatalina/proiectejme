package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Departament;

public class DateDepartament {

	public void delete(int idDepartament) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			stmt.executeUpdate("DELETE FROM departament WHERE id_departament = " + idDepartament);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// INSERT INTO angajati(...) VALUES(...)
	public void save(Departament dept) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			PreparedStatement pstmt = conexiune.prepareStatement(
					"INSERT INTO departament(denumire) VALUES(?)");

			pstmt.setString(1, dept.getDenumire());

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Departament departament) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
//			PreparedStatement pstmt = conexiune.prepareStatement(
//					"INSERT INTO angajat(nume, prenume,oras, strada, numar, salariu, telefon) VALUES(?, ?, ?,?,?,?,?)");
			PreparedStatement pstmt = conexiune
					.prepareStatement("UPDATE departament SET denumire = ? WHERE id_departament = ?");
			
			pstmt.setString(1,  departament.getDenumire());
			pstmt.setInt(2, departament.getId());

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Departament findById(int idDepartament) {
		Departament departamentGasit = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM departament where id_departament = " + idDepartament);
			
			while (randuri.next()) {
				departamentGasit = new Departament();
				departamentGasit.setId(randuri.getInt("id_departament"));
				departamentGasit.setDenumire(randuri.getString("denumire"));

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departamentGasit;
	}

	public List<Departament> findAll() {

		List<Departament> departamente = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			// SELECT * from angajat;
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM departament");

			while (randuri.next()) {
				Departament departamentGasit = new Departament();
				departamentGasit.setId(randuri.getInt("id_departament"));
				departamentGasit.setDenumire(randuri.getString("denumire"));

				departamente.add(departamentGasit);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return departamente;
	}

}
