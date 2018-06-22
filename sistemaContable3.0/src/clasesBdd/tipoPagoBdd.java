package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.arregloTempHash2Items;
import clases.comprasGastos;
import clases.tipoPago;

public class tipoPagoBdd {
	/*
	 * insertar registro en tabla alertas
	 */
	public int insertar(Connection conn, tipoPago objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into tipo_pago (ID_TP, DESCRIPCION) values (?, ?)");
			statement.setInt(1, objeto.getIdTp());
			statement.setString(2, objeto.getDescripcionTp());
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Ingresado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {
			// jTextArea.append("\n:problema : "+e.getMessage());

			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// insertar

	/*
	 *
	 * Modifica un registro existente
	 *
	 *
	 */

	public int modificar(Connection conn, tipoPago objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update tipo_pago set DESCRIPCION = ? where ID_TP = ?");
			statement.setString(1, objeto.getDescripcionTp());
			statement.setInt(2, objeto.getIdTp());
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
	 * Eliminar un registro existente
	 *
	 *
	 */

	public int eliminar(Connection conn, tipoPago objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from tipo_pago where ID_TP = ?");
			statement.setInt(1, objeto.getIdTp());
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

	}// modificar

	/***************************************************************************
	 *
	 * Buscar un registro existente en la Bdd
	 *
	 *
	 **************************************************************************/

	public tipoPago buscarInfoDeUnRegistro(Connection conn, tipoPago objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select * from tipo_pago where DESCRIPCION='"
							+ objeto.getDescripcionTp() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdTp(rs.getInt("ID_TP"));
				objeto.setDescripcionTp(rs.getString("DESCRIPCION"));
			}
			rs.close();
			statement.close();

		} catch (Exception e) {

			objeto.setDescripcionTp("DESCRIPCION");

		}
		return objeto;

	}

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
					.prepareStatement("select count(ID_TP) from tipo_pago limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][8];
			PreparedStatement statement = conn
					.prepareStatement("SELECT ID_TP, DESCRIPCION from tipo_pago");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getInt("ID_TP");
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
	}// seleccionar los del mes

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
					.prepareStatement("select count(ID_TP) from tipo_pago limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("SELECT ID_TP, DESCRIPCION from tipo_pago");
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
	 * retorna un hashTable con el código en String y el objeto con los datos
	 *
	 */

	public Hashtable seleccionarCodigoObjetoCodigoDesripcionTablaHash(
			Connection conn) {
		int totalRows = 0;
		Hashtable tiposPagoLista = new Hashtable();
		arregloTempHash2Items claseTemporal = new arregloTempHash2Items("", "");

		try {
			comprasGastos comprasGastosDp;
			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_TP) from tipo_pago limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			if (totalRows == 0) {
				tiposPagoLista.put("Sin Registros", claseTemporal);
			} else {

				PreparedStatement statement = conn
						.prepareStatement("SELECT DESCRIPCION,ID_TP FROM tipo_pago");

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					claseTemporal = new arregloTempHash2Items(rs.getString(1),
							rs.getString(2));
					String clave = rs.getString(2);
					tiposPagoLista.put("" + clave, claseTemporal);// fixed

					cont++;

				}
				rs.close();

				statement.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return tiposPagoLista;
	}// seleccionar

	/*
	 *
	 * retorna un hashTable con el código en String y el objeto con los datos
	 *
	 */

	public Hashtable seleccionarCodigoObjetoDesripcionCodigoTablaHash(
			Connection conn) {
		int totalRows = 0;
		Hashtable tiposPagoLista = new Hashtable();

		try {
			comprasGastos comprasGastosDp;
			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_TP) from tipo_pago limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			if (totalRows == 0) {
				tiposPagoLista.put("Sin Registros", 0);
			} else {

				PreparedStatement statement = conn
						.prepareStatement("SELECT DESCRIPCION,ID_TP FROM tipo_pago");

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {

					String clave = rs.getString(1);
					tiposPagoLista.put("" + clave, rs.getString(2));// fixed

					cont++;

				}
				rs.close();

				statement.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return tiposPagoLista;
	}// seleccionar

	/*
	 *
	 * retorna un hashTable con el código en String y el objeto con los datos
	 *
	 */

	public Object[][] seleccionarVectorDescripcionesCodigo(Connection conn) {
		int totalRows = 0;
		Object[][] tiposPagoLista1 = new Object[50][2];

		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT DESCRIPCION,ID_TP FROM tipo_pago");

			ResultSet rs = statement.executeQuery();
			int cont = 0;
			while (rs.next()) {

				String clave = rs.getString(1);
				tiposPagoLista1[cont][0] = clave;// fixed
				tiposPagoLista1[cont][1] = rs.getString(2);
				cont++;
			}

			rs.close();
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return tiposPagoLista1;
	}// seleccionar

}
