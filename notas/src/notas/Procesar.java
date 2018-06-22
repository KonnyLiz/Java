package notas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Procesar
 */
@WebServlet("/Procesar")
public class Procesar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Conexion c = new Conexion();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Procesar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		PrintWriter salida = response.getWriter();
		String nom, apel;
		nom=request.getParameter("nom");
		apel=request.getParameter("apel");
		
		try {
			c.insertar(nom, apel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<String> datos= new ArrayList<String>();
		try {
			datos= c.retornarusuarios();
			Iterator<String> iterador = datos.iterator();
			salida.println("<table border=1>");
			while(iterador.hasNext()){
				String[] parte=iterador.next().split(",");
					salida.println("<tr>");
					salida.println("<td>"+parte[0]+"</td>");
					salida.println("<td>"+parte[1]+"</td>");
					salida.println("<td>"+parte[2]+"</td>");
					
					salida.println("<td><form method=post action='Procesar?eli=1&id="+parte[0]+"'><input type=submit value=eliminar></form></td>");
							salida.println("</tr>");
			}
				salida.println("</table>");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		
		String eliminar, id;
		eliminar=request.getParameter("eli");
		id=request.getParameter("id");
		
		salida.print(id);
		if(eliminar.equals("1")){
			
		try {
			System.out.print("entro");
			c.Eliminar(Integer.parseInt(id));
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
	}
}
