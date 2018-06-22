package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.rol;

public class rolBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, rol objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into rol (DESCRIPCION) values (?)");
			statement.setString(1, objeto.getDescripcion());
			statement.execute();
			statement.close();
			JOptionPane.showMessageDialog(null,
					"Se ha Ingresado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// insertar

	/*
	 * 
	 * Modifica un registro existente tipo cliente
	 * 
	 * 
	 */

	public int modificar(Connection conn, rol objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update rol set DESCRIPCION = ? where ID_ROL = ?");
			statement.setString(1, objeto.getDescripcion());
			statement.setInt(2, objeto.getId());
			statement.execute();
			statement.close();
			JOptionPane.showMessageDialog(null,
					"Se ha Modificado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);
			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Modificó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// modificar

	/*
	 * 
	 * Eliminar un registro existente tipo cliente
	 * 
	 * 
	 */

	public int eliminar(Connection conn, rol objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from rol where ID_ROL = ?");
			statement.setInt(1, objeto.getId());
			statement.execute();
			statement.close();
			JOptionPane.showMessageDialog(null,
					"Se ha Eliminado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);
			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Eliminó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// eliminar

	/***************************************************************************
	 * 
	 * Buscar un registro existente en la Bdd
	 * 
	 * 
	 **************************************************************************/

	public rol buscarInfoDeUnRegistro(Connection conn, rol objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_ROL, DESCRIPCION from rol where DESCRIPCION='"
							+ objeto.getDescripcion() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setId(rs.getInt("ID_ROL"));
				objeto.setDescripcion(rs.getString("DESCRIPCION"));

				// Process data here

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return objeto;

	}// en eliminar

	/*
	 * 
	 * retorna un objeto todos los objetos de la tabla
	 * 
	 */

	public Object[][] seleccionarTodos(Connection conn) {
		int totalRows = 0;

		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_ROL) from rol limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][6];
			PreparedStatement statement = conn
					.prepareStatement("select * from rol limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_ROL");
				datos[cont][1] = rs.getString("DESCRIPCION");
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return datos2;
	}// seleccionar

	/*
	 * 
	 * retorna un objeto todos los objetos de la tabla para choice
	 * 
	 */

	public Object[] seleccionarDescripcionesTabla(Connection conn) {
		int totalRows = 0;

		Object datos2[] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_ROL) from rol limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_ROL,DESCRIPCION from rol limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont] = rs.getString("DESCRIPCION");
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return datos2;
	}// seleccionar

	/*
	 * 
	 * retorna un hashTable todos los objetos de la tabla para choice
	 * 
	 */

	public Hashtable<Object, Object> seleccionarDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> rolLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_ROL) from rol limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_ROL,DESCRIPCION from rol limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_ROL");
				rolLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return rolLista;
	}// seleccionar

	/*
	 * 
	 * retorna un hashTable todos los objetos de la tabla para choice
	 * 
	 */

	public Hashtable seleccionarClaveDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable rolLista = new Hashtable();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_ROL) from rol limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_ROL,DESCRIPCION from rol limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getInt("ID_ROL");
				datos[cont][1] = rs.getString("DESCRIPCION");
				rolLista.put(rs.getInt("ID_ROL"), datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return rolLista;
	}// seleccionar

}// end clase

