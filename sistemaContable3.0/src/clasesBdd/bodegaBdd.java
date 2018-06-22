package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.bodega;

public class bodegaBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, bodega objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into bodega (ID_BODEGA, DESCRIPCION, DATO_ADICIONAL) values (?, ?, ?)");
			statement.setInt(1, objeto.getIdBodega());
			statement.setString(2, objeto.getDescripcionBodega());
			statement.setString(3, objeto.getDatoAdicional());
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

	public int modificar(Connection conn, bodega objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update bodega set DESCRIPCION = ?, DATO_ADICIONAL = ? where ID_BODEGA = ?");
			statement.setString(1, objeto.getDescripcionBodega());
			statement.setString(2, objeto.getDatoAdicional());
			statement.setInt(3, objeto.getIdBodega());
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

	public int eliminar(Connection conn, bodega objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from bodega where ID_BODEGA = ?");
			statement.setInt(1, objeto.getIdBodega());
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

	public bodega buscarInfoDeUnRegistro(Connection conn, bodega objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_bodega, DESCRIPCION,DATO_ADICIONAL from bodega where DESCRIPCION='"
							+ objeto.getDescripcionBodega() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdBodega(rs.getInt("ID_BODEGA"));
				objeto.setDescripcionBodega(rs.getString("DESCRIPCION"));
				objeto.setDatoAdicional(rs.getString("DATO_ADICIONAL"));
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
					.prepareStatement("select count(ID_bodega) from bodega limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][3];
			PreparedStatement statement = conn
					.prepareStatement("select * from bodega limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_bodega");
				datos[cont][1] = rs.getString("DESCRIPCION");
				datos[cont][2] = rs.getString("DATO_ADICIONAL");
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
					.prepareStatement("select count(ID_bodega) from bodega limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_bodega,DESCRIPCION from bodega limit 200");
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
		Hashtable<Object, Object> bodegaLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_bodega) from bodega limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_bodega,DESCRIPCION from bodega limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_bodega");
				bodegaLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return bodegaLista;
	}// seleccionar

	/*
	 * 
	 * retorna un hashTable todos los objetos de la tabla id_tabla- descripcion
	 * 
	 */

	public Hashtable<Object, Object> seleccionarIdTablaDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> bodegaLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_bodega) from bodega limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_bodega,DESCRIPCION from bodega limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_bodega");
				bodegaLista.put(datos[cont][1], datos[cont][0]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return bodegaLista;
	}// seleccionar

}// end clase

