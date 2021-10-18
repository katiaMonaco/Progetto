package model;

import java.io.Serializable;

public class Rubrica implements Serializable{
	private int id_utenti;
	private int id_numeri;
	
	public Rubrica(int id_utenti, int id_numeri) {
		this.id_utenti = id_utenti;
		this.id_numeri = id_numeri;
	}
	
	public Rubrica() {	}
	
	public int getId_utenti() {
		return id_utenti;
	}
	public void setId_utenti(int id_utenti) {
		this.id_utenti = id_utenti;
	}
	public int getId_numeri() {
		return id_numeri;
	}
	public void setId_numeri(int id_numeri) {
		this.id_numeri = id_numeri;
	}
	
	

}
