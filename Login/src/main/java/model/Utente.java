package model;

import java.io.Serializable;

public class Utente implements Serializable {
	
	private static final long serialVersionUID = 2253695220410934438L;
	private int id;
	private String user;
	private String password;

	public Utente(int id, String user, String password) {
		this.id= id;
		this.user = user;
		this.password = password;
	}

	public Utente(int id) {
		this.id= id;
	}
	public Utente() {
	}
	
	public int getId() {
		return id;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
