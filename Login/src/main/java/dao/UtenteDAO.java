package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Numeri;
import model.Rubrica;
import model.Utente;

public class UtenteDAO {
	
	Context ctx = null;
	Connection con = null;

	public Utente autenticazione(String user, String pass) throws NamingException {
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try{
			con = ottieniConnessione();
			stmt = con.prepareStatement("select id_utenti, username from utenti where username=? and password=? ");
			stmt.setString(1, user);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Utente u = new Utente();
				u.setId(rs.getInt(1));
				u.setUser(rs.getString(2));
				return u;
			}else {
				return null;
			}
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	

	public void inserimento(Numeri numero, int id_utente) throws NamingException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ottieniConnessione();
			stmt = con.prepareStatement("insert into numeri (cognome, numero) values (?,?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, numero.getCognome());
			stmt.setString(2, numero.getNumero());

			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted != 1) {
				throw new RuntimeException("INSERT error.");
			}
			rs = stmt.getGeneratedKeys();
			rs.next();
			numero.setId_numeri(rs.getInt(1));
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		inserimentoRubrica(id_utente,numero.getId_numeri());
		
	}

	public ArrayList<Rubrica> selectAllByIdUtenti(int id) throws NamingException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ottieniConnessione();
			stmt = con.prepareStatement(
					"SELECT r.id_utenti, r.id_numeri FROM rubrica r, utenti u, numeri n WHERE r.id_utenti=? AND r.id_utenti = u.id_utenti AND r.id_numeri = n.id_numeri");	
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			ArrayList<Rubrica> rubrica = new ArrayList<Rubrica>();
			while(rs.next()) {
				Rubrica rub = new Rubrica();
				rub.setId_utenti(rs.getInt(1));
				rub.setId_numeri(rs.getInt(2));
				rubrica.add(rub);
			}
			return rubrica; 
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Numeri doRetrieveByIdNumeri(int id_numeri) throws NamingException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ottieniConnessione();
			stmt = con.prepareStatement(
					"SELECT cognome, numero FROM numeri WHERE id_numeri = ?");	
			stmt.setInt(1, id_numeri);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Numeri n = new Numeri();
				n.setCognome(rs.getString(1));
				n.setNumero(rs.getString(2));
				return n;
			}
			return null;
		}catch (SQLException e) {
				throw new RuntimeException(e);
			}

	}
	
	
	public void inserimentoRubrica(int id_utente,int id_numero) throws NamingException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = ottieniConnessione();
			stmt = con.prepareStatement("insert into rubrica (id_utenti, id_numeri) values (?,?)");
			stmt.setInt(1, id_utente);
			stmt.setInt(2, id_numero);

			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted != 1) {
				throw new RuntimeException("INSERT error.");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	private Connection ottieniConnessione() throws SQLException, NamingException {
		if (null == con) {
			DataSource ds;
			ctx = new InitialContext();
			try {
				ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/MyLocalDB");
				con = ds.getConnection();
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	
	
	
}
