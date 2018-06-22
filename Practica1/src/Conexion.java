import java.sql.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;



public class Conexion {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	ResultSetMetaData rsm;
	DefaultTableModel dtm = null;
	Conexion(){}
	
	public void insertar(String nombre, String precio, String existencia){
	
		//driver de conexion
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//cadena de conexion
			String servidor = "jdbc:mysql://localhost/practica1";
			con=DriverManager.getConnection(servidor, "root", "1234");
			
			Statement estado= (Statement) con.createStatement();
			estado.execute("insert into producto values(NULL, '"+nombre+"', '"+precio+"', '"+existencia+"')");
			JOptionPane.showMessageDialog(null, "Guardado");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public void ordenar(JTable tab, String comc, String ord) throws ClassNotFoundException{
		try
		{
			String servidor = "jdbc:mysql://localhost/practica1";
			con=DriverManager.getConnection(servidor, "root", "1234");
			ps=(PreparedStatement) con.prepareStatement("select * from producto order by "+comc+" "+ord+"");
			JOptionPane.showMessageDialog(null, "Ordenando...");
		   rs = ps.executeQuery();
		   rsm = rs.getMetaData();
		   @SuppressWarnings({ "unchecked", "rawtypes" })
		
		   ArrayList<Object[]> data = new ArrayList();
			
			while(rs.next())
			{
				Object[] rows = new Object[rsm.getColumnCount()];
				for(int i = 0; i < rows.length; i++)
				{
					rows[i] = rs.getObject(i+1);
				}
				data.add(rows);
			}
			dtm = (DefaultTableModel)tab.getModel();
			
			for(int i = 0; i < data.size(); i++)
			{
				dtm.addRow(data.get(i));
			}
		   
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}
	
	public void u(JTable tab,String orden, String asde, int cont) throws ClassNotFoundException{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ResultSetMetaData rsm;
		DefaultTableModel dtm = null;
		try
		{
		   cont++;
		   Class.forName("com.mysql.jdbc.Driver");
		   con=DriverManager.getConnection("jdbc:mysql://localhost/departamentos","root","");
		 //  ps=con.prepareStatement("select * from productos order by "+orden+" "+asde);
		   rs = ps.executeQuery();
		   rsm = rs.getMetaData();
		   @SuppressWarnings({ "unchecked", "rawtypes" })
		ArrayList<Object[]> data = new ArrayList();
			
			while(rs.next())
			{
				Object[] rows = new Object[rsm.getColumnCount()];
				for(int i = 0; i < rows.length; i++)
				{
					rows[i] = rs.getObject(i+1);
				}
				data.add(rows);
			}
			dtm = (DefaultTableModel)tab.getModel();
			
			for(int i = 0; i < data.size(); i++)
			{
				dtm.addRow(data.get(i));
			}
		   
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
}
