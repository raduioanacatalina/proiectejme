package model;

public class Angajat {

	private Integer id;
	private String nume;
	private String prenume;
	private String telefon;
	private String strada;
	private String numar;
	private String oras;
	private Double salariu;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getPrenume() {
		return prenume;
	}
	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getStrada() {
		return strada;
	}
	public void setStrada(String strada) {
		this.strada = strada;
	}
	public String getNumar() {
		return numar;
	}
	public void setNumar(String numar) {
		this.numar = numar;
	}
	public String getOras() {
		return oras;
	}
	public void setOras(String oras) {
		this.oras = oras;
	}
	public Double getSalariu() {
		return salariu;
	}
	public void setSalariu(Double salariu) {
		this.salariu = salariu;
	}
	
	@Override
	public String toString() {
		return "Angajat [id=" + id + ", nume=" + nume + ", prenume=" + prenume + ", telefon=" + telefon + ", strada="
				+ strada + ", numar=" + numar + ", oras=" + oras + ", salariu=" + salariu + "]";
	}
	
	
}
