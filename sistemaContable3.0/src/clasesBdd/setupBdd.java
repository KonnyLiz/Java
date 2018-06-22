package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import clases.setup;

public class setupBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, setup objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into setup (IVA, CLAVE_ADMINISTRACION, IMPRESORA) values (?, ?, ?)");
			statement.setFloat(1, objeto.getIva());
			statement.setString(2, objeto.getClaveAdministracion());
			statement.setString(3, objeto.getImpresoraNombre());
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

	public int modificar(Connection conn, setup objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update setup set IVA = ?, CLAVE_ADMINISTRACION = ?, IMPRESORA = ?   where IVA ="
							+ objeto.getIva() + "");
			statement.setFloat(1, objeto.getIva());
			statement.setString(2, objeto.getClaveAdministracion());
			statement.setString(3, objeto.getImpresoraNombre());
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

	/***************************************************************************
	 * 
	 * Buscar un registro existente en la Bdd
	 * 
	 * 
	 **************************************************************************/

	public setup buscarInfoDeUnRegistro(Connection conn, setup objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select IVA , CLAVE_ADMINISTRACION , IMPRESORA   from setup limit 1");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIva(rs.getFloat("IVA"));
				objeto.setClaveAdministracion(rs
						.getString("CLAVE_ADMINISTRACION"));
				objeto.setImpresoraNombre(rs.getString("IMPRESORA"));
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
	 * retorna un hashTable de la impresora y el porcentaje del iva
	 * 
	 */

	public Object[][] seleccionarIvaImpresoraSetupTablaHash(Connection conn) {

		Object datos2[][] = null;
		try {

			int cont = 0;
			Object datos[][] = new Object[1][2];
			PreparedStatement statement = conn
					.prepareStatement("SELECT IVA,IMPRESORA FROM setup");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("IVA");
				datos[cont][1] = rs.getString("IMPRESORA");
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

}// end clase

