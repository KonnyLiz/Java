package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.tipoProducto;

public class tipoProductoBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, tipoProducto objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into tipo_producto (ID_TP, DESCRIPCION_TP) values (?, ?)");
			statement.setInt(1, objeto.getIdTipoProducto());
			statement.setString(2, objeto.getDescripcionTipoProducto());
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

	public int modificar(Connection conn, tipoProducto objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update tipo_producto set DESCRIPCION_TP = ? where ID_TP = ?");
			statement.setString(1, objeto.getDescripcionTipoProducto());
			statement.setInt(2, objeto.getIdTipoProducto());
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

	public int eliminar(Connection conn, tipoProducto objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from tipo_producto where ID_TP = ?");
			statement.setInt(1, objeto.getIdTipoProducto());
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

	public tipoProducto buscarInfoDeUnRegistro(Connection conn,
			tipoProducto objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_TP, DESCRIPCION_TP from tipo_producto where DESCRIPCION_TP='"
							+ objeto.getDescripcionTipoProducto() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdTipoProducto(rs.getInt("ID_TP"));
				objeto.setDescripcionTipoProducto(rs
						.getString("DESCRIPCION_TP"));

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
					.prepareStatement("select count(ID_TP) from tipo_producto limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][6];
			PreparedStatement statement = conn
					.prepareStatement("select * from tipo_producto limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_TP");
				datos[cont][1] = rs.getString("DESCRIPCION_TP");
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
					.prepareStatement("select count(ID_TP) from tipo_producto limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_TP,DESCRIPCION_TP from tipo_producto limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont] = rs.getString("DESCRIPCION_TP");
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
	 * retorna un hashTable todos los tipoa de productos de la tabla para choice
	 * 
	 */

	public Hashtable<Object, Object> seleccionarDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> proveedorLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_TP) from tipo_producto limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_TP,DESCRIPCION_TP from tipo_producto limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION_TP");
				datos[cont][1] = rs.getString("ID_TP");
				proveedorLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return proveedorLista;
	}// seleccionar

	/*
	 * 
	 * retorna un hashTable todos los tipoa de productos de la tabla para choice
	 * 
	 */

	public Hashtable<Object, Object> seleccionarIdTAblaDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> proveedorLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_TP) from tipo_producto limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_TP,DESCRIPCION_TP from tipo_producto limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION_TP");
				datos[cont][1] = rs.getString("ID_TP");
				proveedorLista.put(datos[cont][1], datos[cont][0]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return proveedorLista;
	}// seleccionar

}// end clase

