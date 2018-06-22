package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import clases.tipoRecibo;

public class tipoReciboBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, tipoRecibo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into tipo_recibo (ID_TR, DESCRIPCION_TR) values (?, ?)");
			statement.setInt(1, objeto.getIdTipoDeRecibo());
			statement.setString(2, objeto.getDescripcion());
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

	public int modificar(Connection conn, tipoRecibo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update tipo_recibo set DESCRIPCION_TR = ? where ID_TR = ?");
			statement.setString(1, objeto.getDescripcion());
			statement.setInt(2, objeto.getIdTipoDeRecibo());
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

	public int eliminar(Connection conn, tipoRecibo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from tipo_recibo where ID_TR = ?");
			statement.setInt(1, objeto.getIdTipoDeRecibo());
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

	public tipoRecibo buscarInfoDeUnRegistro(Connection conn, tipoRecibo objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_TR , DESCRIPCION_TR from tipo_recibo where DESCRIPCION_TR='"
							+ objeto.getDescripcion() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdTipoDeRecibo(rs.getInt("ID_TR"));
				objeto.setDesTipoDeRecibo(rs.getString("DESCRIPCION_TR"));

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
	 * retorna un objeto todos los objetos de la tabla para choice
	 * 
	 */

	public Object[] seleccionarDescripcionesTabla(Connection conn) {
		int totalRows = 0;

		Object datos2[] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select  ID_TR from tipo_recibo limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt("ID_TR");

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select   DESCRIPCION_TR from tipo_recibo limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont] = rs.getString("DESCRIPCION_TR");
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

