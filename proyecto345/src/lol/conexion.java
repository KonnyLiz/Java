package lol;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class conexion {

	
	private Connection con;
	public conexion()
	{
		ConfigurarConexion("localhost", "root", "1234", "proyecto34");
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

/*public void Editar(int id, String nombre, String apellido, String edad) throws SQLException
{
	String Seleccio= "UPDATE `proyecto34`.`usuario` SET `usuario`.`nombre`=?, `usuario`.`numlic`=?, `usuario`.`departamento`=?   WHERE `usuario`.`id`=?";
	PreparedStatement  pre = con.prepareStatement(Seleccio);
	pre.setString(1, nombre);
	pre.setString(2, numlic);
	pre.setString(3, depto);
	pre.setInt(4, id);
	pre.executeUpdate();
	}*/

	
public void Eliminar(int ide) throws SQLException
{
	String Seleccio= "DELETE FROM `practica3`.`usuario` WHERE `usuario`.`id` =?";
	PreparedStatement  pre = con.prepareStatement(Seleccio);
	pre.setInt(1, ide);
	pre.executeUpdate();
	}

public void insertar(String nom, String apel, int edad) throws SQLException{

	String seleccion="INSERT INTO cliente(ID, Nombre, Apellido, Edad)"+"VALUES (NULL,? ,?, ?)";
	PreparedStatement pre=con.prepareStatement(seleccion);
	                  pre.setString(1,nom);
	                  pre.setString(2,apel);
	                  pre.setInt(3,edad);
	                  pre.executeUpdate();             
}
public ArrayList<String> retornarusuarios() throws SQLException
{
	ArrayList<String> lista = new ArrayList<String>();
	PreparedStatement pre = con.prepareStatement("SELECT * FROM cliente");
	ResultSet rs = pre.executeQuery();
	while(rs.next())
	{
		lista.add(rs.getInt("ID")+","+rs.getString("Nombre")+","+rs.getString("Apellido")+","+rs.getInt("Edad"));
		//Iterator<String> iteador = lista.iterator();
		//System.out.println(iteador.next());
	}
	rs.close();
	return lista;
}
  
}
