package model;

import java.io.Serializable;

public class Numeri implements Serializable{
	private int id_numeri;
	private String cognome;
	private String numero;
	
	
	public Numeri(int id_numeri, String cognome, String numero) {
		this.id_numeri = id_numeri;
		this.cognome = cognome;
		this.numero = numero;
	}
	
	public Numeri(String cognome, String numero) {
		this.cognome = cognome;
		this.numero = numero;
	}
	
	public Numeri() {}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getId_numeri() {
		return id_numeri;
	}

	public void setId_numeri(int id_numeri) {
		this.id_numeri = id_numeri;
	}
	
	
	
	
}
