package lol;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class conectarhtml
 */
@WebServlet("/conectarhtml")
public class conectarhtml extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private conexion c = new conexion();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public conectarhtml() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//PrintWriter salida = response.getWriter();
		String nom, apel, edad;
		nom=request.getParameter("nombre");
		apel=request.getParameter("apel");
		edad=request.getParameter("edad");
		int ed= Integer.parseInt(edad); 
		
		try {
			c.insertar(nom, apel, ed);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter salida = response.getWriter();
		salida.println("<table>");
		ArrayList<String> datos = new ArrayList<String>();
		try {
			datos= c.retornarusuarios();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Iterator<String> itr = datos.iterator();
		while (itr.hasNext())
		{
			String elemento = itr.next();
			String [] parts = elemento.split(",");
			salida.println("<tr><td>" + parts[0] + "</td></tr>");
			salida.println("</table>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
