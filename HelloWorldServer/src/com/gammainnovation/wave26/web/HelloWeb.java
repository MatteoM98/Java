package com.gammainnovation.wave26.web;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWeb
 */
@WebServlet("/HelloWeb")
public class HelloWeb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection conn = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWeb() {
        super();
        try {
			Class.forName("org.postgresql.Driver").newInstance();
			String url = "jdbc:postgresql://localhost:5432/biblioteca";
			conn = DriverManager.getConnection(url,"enigma","enigma");
			if(conn!=null) {
				System.out.println("Connection OK");
			} else {
				System.out.println("No connection");
			}
		} catch(Exception e) {
			System.out.println("ERRORE: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href=\"index.html\">Back</a>");
		out.close();*/
		response.sendRedirect("/HelloWorldServer/index.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Enumeration values = request.getParameterNames();
		HashMap<String,String> params = new HashMap<String,String>();
		while (values.hasMoreElements())
		{
			String name = (String) values.nextElement();
			String value = request.getParameter(name);
			if (name.compareTo("submit") != 0)
			{
				System.out.println(name + ":" + value);
				params.put(name, value);
			}
		}
		
		/*
		 * Bisogna distinguere le due casistiche di signin e signup
		 * questo può essere fatto analizzando il numero dei parametri
		 */
		try {
		if(params.size()==2) { //caso login
			boolean t = executeLogin(params);
			if(!t) 
				response.sendRedirect("/HelloWorldServer/index.html");
			else {
				System.out.println("Accesso eseguito!!");
				response.sendRedirect("/HelloWorldServer/pagina-iniziale.html");
			}
		} else if (params.size()==6){ //caso signUp
			executePreparedStatement(params);
			System.out.println("Registrazione avvenuta con successo!!");
			response.sendRedirect("/HelloWorldServer/pagina-iniziale.html");
		} else {
			boolean t = statementPrenotazione(params);
			if(t) response.sendRedirect("/HelloWorldServer/index.hmtl");
			else {
				System.out.println("Prenotazione fallita!");
				response.sendRedirect("/HelloWorldServer/prenotazione.html");
			}
		}
		} catch(Exception e) {
			System.out.println("ERRORE INSERIMENTO DATI: " + e.getMessage());
			response.sendRedirect("/HelloWorldServer/index.html");
		}
		
		/*
		try {
			executePreparedStatement(params);
		} catch (Exception e) {
			System.out.println("ERRORE INSERIMENTO DATI: " + e.getMessage());
			throw new ServletException();
		}
		
		System.out.println("Inserimento avvenuto con successo!");
		response.sendRedirect("/HelloWorldServer/end.html");*/
	}
	
	//Inserimento di una tupla
	public static void executePreparedStatement(HashMap<String,String> params) throws Exception {
		PreparedStatement pstm = conn.prepareStatement("INSERT INTO utente(nome,cognome,cf,mail,password,datadinascita)"
													 + " VALUES (?,?,?,?,?,?)");
			
		pstm.setString(1, params.get("nome"));
		pstm.setString(2, params.get("cognome"));
		pstm.setString(3, params.get("cf"));
		pstm.setString(4, params.get("email"));
		pstm.setString(5, params.get("password"));
		pstm.setDate(6, Date.valueOf(params.get("datadinascita")));
			
		pstm.execute();
		pstm.close();	
	}
	
	public boolean executeLogin(HashMap<String,String> params) throws Exception {
		PreparedStatement pstm = conn.prepareStatement("SELECT nome,cognome FROM utente WHERE mail=? AND password=?");
		
		pstm.setString(1, params.get("email"));
		pstm.setString(2, params.get("password"));
		
		ResultSet rs = pstm.executeQuery();
		boolean t = false;
		
		while(rs.next()) {
			System.out.println("Nome: " + rs.getString(1));
			System.out.println("Cognome: " + rs.getString(2));
			System.out.println("-----------------------------------");
			t = true;
		}
		
		return t;
			
		}
	
	  public boolean statementPrenotazione(HashMap<String,String> params) throws Exception {
		  PreparedStatement pstm = conn.prepareStatement("SELECT l.id as Libro\n"
		  												+ "FROM Autore as a\n"
		  												+ "JOIN Libro as l \n"
		  												+ "ON a.id = l.autore\n"
		  												+ "WHERE a.nome=? AND a.cognome=? AND l.titolo=?;");
		 
		  String s = params.get("autore");
		  StringTokenizer str = new StringTokenizer(s);
		  String nomeAutore = str.nextToken();
		  String cognomeAutore = str.nextToken();
		  

		  pstm.setString(1, nomeAutore);
		  pstm.setString(2, cognomeAutore);
		  pstm.setString(3, params.get("libro"));
		  
		  //id del libro 
		  ResultSet rs = pstm.executeQuery();
		  int libroID = -1;
		  if(rs.next()) {
	            libroID = rs.getInt(1);
	       } else return false;
	       
		  
		  PreparedStatement pstm2 = conn.prepareStatement("SELECT ID as Utente\n"
		  												+ "FROM Utente\n"
		  												+ "WHERE mail=?");
		  
		  pstm2.setString(1, params.get("mail"));
		  
		  //id dell'utente
		  ResultSet rs2 = pstm2.executeQuery();
		  int utenteID = -1;
		  if(rs2.next()) 
			  utenteID = rs2.getInt(1);
		  else return false;
		  
		  
		  PreparedStatement pstm3 = conn.prepareStatement("INSERT INTO prenotazionilibro(utente,libro) VALUES(?,?)");
		  
		  pstm3.setInt(1,utenteID);
		  pstm3.setInt(2,libroID);
		  
		  pstm3.execute();
		  
		  pstm.close();
		  pstm2.close();
		  pstm3.close();
		  
		  return true;
	  }
	}

