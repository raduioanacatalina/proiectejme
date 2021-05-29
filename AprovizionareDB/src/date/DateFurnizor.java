package date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Furnizor;

public class DateFurnizor {

	public void delete(int idFurnizor) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");

			Statement stmt = conexiune.createStatement();
			stmt.executeUpdate("DELETE FROM furnizor WHERE id_furnizor = " + idFurnizor);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// INSERT INTO angajati(...) VALUES(...)
	public void save(Furnizor anou) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			PreparedStatement pstmt = conexiune.prepareStatement(
					"INSERT INTO furnizor(denumire, nume_strada,numar_strada, oras, telefon) VALUES(?, ?, ?,?,?)");

			pstmt.setString(1, anou.getDenumire());
			pstmt.setString(2, anou.getNume_strada());
			pstmt.setString(3, anou.getNumar_strada());
			pstmt.setString(4, anou.getOras());
			pstmt.setString(5, anou.getTelefon());
			

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Furnizor anou) {

		try {

			Class.forName("com.mysql.jdbc.Driver");

			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
//			PreparedStatement pstmt = conexiune.prepareStatement(
//					"INSERT INTO angajat(nume, prenume,oras, strada, numar, salariu, telefon) VALUES(?, ?, ?,?,?,?,?)");
			PreparedStatement pstmt = conexiune
					.prepareStatement("UPDATE Furnizor SET denumire = ?, nume_strada = ?, numar_strada = ?, oras = ?, telefon = ? WHERE id_furnizor = ?");
			pstmt.setString(1, anou.getDenumire());
			pstmt.setString(2, anou.getNume_strada());
			pstmt.setString(3, anou.getNumar_strada());
			pstmt.setString(4, anou.getOras());
			pstmt.setString(5, anou.getTelefon());
			
			pstmt.setInt(6, anou.getId());

			pstmt.executeUpdate(); // INSERT / UPDATE / DELETE

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Furnizor findById(int idFurnizor) {
		Furnizor furnizorGasit = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM furnizor where id_furnizor = " + idFurnizor);
			
			while (randuri.next()) {
				furnizorGasit = new Furnizor();
				furnizorGasit.setId(randuri.getInt("id_furnizor"));
				furnizorGasit.setDenumire(randuri.getString("denumire"));
				furnizorGasit.setNume_strada(randuri.getString("nume_strada"));
				furnizorGasit.setNumar_strada(randuri.getString("numar_strada"));
				furnizorGasit.setOras(randuri.getString("oras"));
				furnizorGasit.setTelefon(randuri.getString("telefon"));
				

				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return furnizorGasit;
	}

	public List<Furnizor> findAll() {

		List<Furnizor> furnizoriDb = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexiune = DriverManager.getConnection("jdbc:mysql://localhost:3306/aprovizionare", "root",
					"1234");
			// SELECT * from angajat;
			Statement stmt = conexiune.createStatement();
			ResultSet randuri = stmt.executeQuery("SELECT * FROM furnizor");

			while (randuri.next()) {
				System.out.println("GETTING FURNIZOR");
				Furnizor furnizor = new Furnizor();
				furnizor.setId(randuri.getInt("id_furnizor"));
				furnizor.setDenumire(randuri.getString("denumire"));
				furnizor.setNume_strada(randuri.getString("nume_strada"));
				furnizor.setNumar_strada(randuri.getString("numar_strada"));
				furnizor.setOras(randuri.getString("oras"));
				furnizor.setTelefon(randuri.getString("telefon"));
			
				furnizoriDb.add(furnizor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return furnizoriDb;
	}

	
}
