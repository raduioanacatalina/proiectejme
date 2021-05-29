package model;

import java.util.Date;

public class Raport {

	private String numeAngajat;
	private String prenumeAngajat;
	private String telefonAngajat;
	private Date data;
	private String detalii;
	private String denumireMagazin;
	private String denumireProdus;
	private Integer cantitate;
	private Double pret;
	public String getNumeAngajat() {
		return numeAngajat;
	}
	public void setNumeAngajat(String numeAngajat) {
		this.numeAngajat = numeAngajat;
	}
	public String getPrenumeAngajat() {
		return prenumeAngajat;
	}
	public void setPrenumeAngajat(String prenumeAngajat) {
		this.prenumeAngajat = prenumeAngajat;
	}
	public String getTelefonAngajat() {
		return telefonAngajat;
	}
	public void setTelefonAngajat(String telefonAngajat) {
		this.telefonAngajat = telefonAngajat;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDetalii() {
		return detalii;
	}
	public void setDetalii(String detalii) {
		this.detalii = detalii;
	}
	public String getDenumireMagazin() {
		return denumireMagazin;
	}
	public void setDenumireMagazin(String denumireMagazin) {
		this.denumireMagazin = denumireMagazin;
	}
	public String getDenumireProdus() {
		return denumireProdus;
	}
	public void setDenumireProdus(String denumireProdus) {
		this.denumireProdus = denumireProdus;
	}
	public Integer getCantitate() {
		return cantitate;
	}
	public void setCantitate(Integer cantitate) {
		this.cantitate = cantitate;
	}
	public Double getPret() {
		return pret;
	}
	public void setPret(Double pret) {
		this.pret = pret;
	}
	
	
}
