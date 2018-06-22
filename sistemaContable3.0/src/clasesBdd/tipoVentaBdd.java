package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import clases.tipoVenta;

public class tipoVentaBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, tipoVenta objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into tipo_venta (ID_TV, DESCRIPCION) values (?, ?)");
			statement.setInt(1, objeto.getIdTipoVenta());
			statement.setString(2, objeto.getDescripcionTipoDeVenta());
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

	public int modificar(Connection conn, tipoVenta objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update tipo_venta set DESCRIPCION = ? where ID_TV = ?");
			statement.setString(1, objeto.getDescripcionTipoDeVenta());
			statement.setInt(2, objeto.getIdTipoVenta());
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

	public int eliminar(Connection conn, tipoVenta objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from tipo_venta where ID_TV = ?");
			statement.setInt(1, objeto.getIdTipoVenta());
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

	public tipoVenta buscarInfoDeUnRegistro(Connection conn, tipoVenta objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_TV, DESCRIPCION from tipo_venta where DESCRIPCION='"
							+ objeto.getDescripcionTipoDeVenta() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdTipoVenta(rs.getInt("ID_TV"));
				objeto.setDescripcionTipoDeVenta(rs.getString("DESCRIPCION"));

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
					.prepareStatement("select count(ID_TV)   from tipo_venta limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][6];
			PreparedStatement statement = conn
					.prepareStatement("select *  from tipo_venta limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_TV");
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
					.prepareStatement("select count(ID_TV) from tipo_venta limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_TV,DESCRIPCION from tipo_venta limit 200");
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
}// end clase

