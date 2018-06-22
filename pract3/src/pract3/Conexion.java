package pract3;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Conexion {

	
	private Connection con;
	public Conexion()
	{
		ConfigurarConexion("localhost", "root", "1234", "practica3");
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

public void Editar(int id, String nombre, String numlic, String depto) throws SQLException
{
	String Seleccio= "UPDATE `practica3`.`usuario` SET `usuario`.`nombre`=?, `usuario`.`numlic`=?, `usuario`.`departamento`=?   WHERE `usuario`.`id`=?";
	PreparedStatement  pre = con.prepareStatement(Seleccio);
	pre.setString(1, nombre);
	pre.setString(2, numlic);
	pre.setString(3, depto);
	pre.setInt(4, id);
	pre.executeUpdate();
	}

	
public void Eliminar(int ide) throws SQLException
{
	String Seleccio= "DELETE FROM `practica3`.`usuario` WHERE `usuario`.`id` =?";
	PreparedStatement  pre = con.prepareStatement(Seleccio);
	pre.setInt(1, ide);
	pre.executeUpdate();
	}

public void insertar(String nom, String numlic, String depto) throws SQLException{

	String seleccion="INSERT INTO usuario(id, numlic, nombre, departamento)"+"VALUES (NULL,? ,?, ?)";
	PreparedStatement pre=con.prepareStatement(seleccion);
	                  pre.setString(1,numlic);
	                  pre.setString(2,nom);
	                  pre.setString(3,depto);
	                  pre.executeUpdate();             
}
public ArrayList<String> retornarusuarios() throws SQLException
{
	ArrayList<String> lista = new ArrayList<String>();
	PreparedStatement pre = con.prepareStatement("SELECT * FROM usuario");
	ResultSet rs = pre.executeQuery();
	while(rs.next())
	{
		lista.add(rs.getString("id")+","+rs.getString("numlic")+","+rs.getString("nombre")+","+rs.getString("departamento"));
		//Iterator<String> iteador = lista.iterator();
		//System.out.println(iteador.next());
	}
	rs.close();
	return lista;
}
  
}
