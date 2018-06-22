
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Conexion {

	
	private Connection con;
	public Conexion()
	{
		ConfigurarConexion("localhost", "root", "1234", "parcial2");
		}
	
	public void ConfigurarConexion(String host,String user,String pass,String dbase){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String nuevaconexion="jdbc:mysql://"+host+"/"+dbase+"?"+"user="+user+"&password="+pass;
		    con=DriverManager.getConnection(nuevaconexion);
		}
		catch(Exception e){JOptionPane.showMessageDialog(null, e);}	
	}

public void CloseConexion()
{
	try {
		con.close();
	}
	catch (Exception e)
	{
		System.out.println("error de cierre de conexion");
	}
}

public void Editar(int id, String nom, String apel, String fecha, String dui, String email, String depto, String dir) throws SQLException
{
	String Seleccio= "UPDATE `parcial2`.`clientes` SET `clientes`.`DUI`=?, `clientes`.`Nombre`=?, `clientes`.`Apellido`=?, `clientes`.`Fecha`=?, `clientes`.`Email`=?, `clientes`.`Departamento`=?, `clientes`.`Direccion`=?   WHERE `clientes`.`id`=?";
	PreparedStatement  pre = con.prepareStatement(Seleccio);
	pre.setString(1, dui);
	pre.setString(2, nom);
	pre.setString(3, apel);
	 pre.setString(4,fecha);
     pre.setString(5, email);
     pre.setString(6, depto);
     pre.setString(7, dir);
	pre.setInt(8, id);
	pre.executeUpdate();
	}

	
public void Eliminar(int ide) throws SQLException
{
	String Seleccio= "DELETE FROM `parcial2`.`clientes` WHERE `clientes`.`id` =?";
	PreparedStatement  pre = con.prepareStatement(Seleccio);
	pre.setInt(1, ide);
	pre.executeUpdate();
	}

public void insertar(String nom, String apel, String fecha, String dui, String email, String depto, String dir) throws SQLException{

	String seleccion="INSERT INTO clientes(id, DUI, Nombre, Apellido, Fecha, Email, Departamento, Direccion)"+"VALUES (NULL,? ,?, ?, ?, ?, ?, ?)";
	PreparedStatement pre=con.prepareStatement(seleccion);
	                  pre.setString(1,dui);
	                  pre.setString(2,nom);
	                  pre.setString(3,apel);
	                  pre.setString(4,fecha);
	                  pre.setString(5, email);
	                  pre.setString(6, depto);
	                  pre.setString(7, dir);
	                  pre.executeUpdate();             
}
public ArrayList<String> retorna() throws SQLException
{
	ArrayList<String> lista = new ArrayList<String>();
	PreparedStatement pre = con.prepareStatement("SELECT * FROM `clientes`");
	ResultSet rs = pre.executeQuery();
	while(rs.next())
	{
		lista.add(rs.getString("id")+","+rs.getString("DUI")+","+rs.getString("Nombre")+","+rs.getString("Apellido")+","+rs.getString("Fecha")+","+rs.getString("Email")+","+rs.getString("Departamento")+","+rs.getString("Direccion"));
	}
	rs.close();
	return lista;
}
}
