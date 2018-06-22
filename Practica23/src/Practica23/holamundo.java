package Practica23;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class holamundo
 */
@WebServlet("/holamundo")
public class holamundo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public holamundo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    //sirve para formularios del metodo get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter salida = response.getWriter();
		salida.println("<html>");
		salida.println("<head></head>");
		salida.println("<body>");
		salida.println("usuario:");
		String usu = request.getParameter("usuario");
		salida.println(usu);
		String fa = request.getParameter("fa");
		int fila=Integer.parseInt(fa);
		salida.println("<table border=1>");
		for (int i=0; i<fila; i++)
		{
			salida.println("<tr><td>"+i+"</td></tr>");
		}
		salida.println("</table>");
		salida.println("</body>");
		salida.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//sirve para formularios del metodo post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
