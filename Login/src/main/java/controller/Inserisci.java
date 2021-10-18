package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UtenteDAO;
import model.Numeri;
import model.Rubrica;
import model.Utente;

@WebServlet("/inserimento")
public class Inserisci extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtenteDAO utenteDAO = new UtenteDAO();
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cognome = request.getParameter("cognome");
		String num = request.getParameter("numero");
		String id = request.getParameter("utente");
		int id_int = Integer.parseInt(id); //id utente
		Utente utente = new Utente(id_int);
		
		ArrayList<Rubrica> rubrica = null; 
		Numeri numero = new Numeri(cognome, num);
		
		try {
			utenteDAO.inserimento(numero, id_int);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		
		
		try {
			rubrica = utenteDAO.selectAllByIdUtenti(id_int);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
		ArrayList<Numeri> contatti = new ArrayList<Numeri>();
		if (rubrica != null) {
			for(Rubrica r: rubrica) {
				Numeri numeri;
				try {
					numeri = utenteDAO.doRetrieveByIdNumeri(r.getId_numeri());
					contatti.add(numeri);
				} catch (NamingException e) {
					e.printStackTrace();
				}
				
			}
			
			
			request.setAttribute("contatti", contatti);
			request.setAttribute("utente", utente);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		}

	
	}
}
