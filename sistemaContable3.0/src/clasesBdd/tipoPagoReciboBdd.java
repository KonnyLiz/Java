package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.tipoPagoRecibo;

public class tipoPagoReciboBdd {
	/*
	 * insertar registro en tabla tipo de pago recibo
	 * 
	 */
	public int insertar(Connection conn, tipoPagoRecibo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into tipo_pago_recibo ( ID_RECIBO, ID_TP, CANTIDAD, FECHA, DETALLE, PLAZO, ESTADO,TIPO_RECIBO) values (?, ?, ?, ?, ?, ?, ?,?)");

			statement.setInt(1, objeto.getIdRecibo());
			statement.setInt(2, objeto.getIdTipoPago());
			statement.setString(3, objeto.getCantidad());
			statement.setString(4, objeto.getFecha());
			statement.setString(5, objeto.getDetalle());
			statement.setString(6, objeto.getPlazo());
			statement.setString(7, objeto.getEstado());
			statement.setInt(8, objeto.getTipoRecibo());
			statement.execute();
			statement.close();

			/*
			 * JOptionPane.showMessageDialog(null, "Se ha Ingresado un Registro! ",
			 * "Aviso!", JOptionPane.INFORMATION_MESSAGE);
			 */

			return 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// insertar

	/*
	 * 
	 * Modifica un registro tipo de pago realizado
	 * 
	 * 
	 */

	public int modificar(Connection conn, tipoPagoRecibo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update tipo_pago_recibo set ID_RECIBO = ?, ID_TP = ?, CANTIDAD = ?, FECHA = ?, DETALLE = ?, PLAZO = ?, ESTADO = ? where ID_TP_RE = ?");
			statement.setInt(1, objeto.getIdRecibo());
			statement.setInt(2, objeto.getIdTipoPago());
			statement.setString(3, objeto.getCantidad());
			statement.setString(4, objeto.getFecha());
			statement.setString(5, objeto.getDetalle());
			statement.setString(6, objeto.getPlazo());
			statement.setString(7, objeto.getEstado());
			statement.setInt(8, objeto.getIdTipoPagoReciboPK());
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
	 * Modifica un registro tipo de pago realizado
	 * 
	 * 
	 */

	public int eliminar(Connection conn, tipoPagoRecibo objeto) {
		try {

			PreparedStatement statement = conn.prepareStatement("	delete "
					+ " FROM tipo_pago_recibo" + "	where ID_RECIBO="
					+ objeto.getIdRecibo() + "");

			statement.execute();
			statement.close();

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

	public tipoPagoRecibo[] buscarInfoDeUnRegistro(Connection conn,
			tipoPagoRecibo objeto) {
		tipoPagoRecibo arr[] = null;
		try {

			PreparedStatement statement = conn.prepareStatement("select"
					+ " ID_TP_RE, ID_RECIBO, "
					+ " ID_TP, CANTIDAD, FECHA, DETALLE,"
					+ " PLAZO, ESTADO,TIPO_RECIBO " + " from tipo_pago_recibo"
					+ " where ID_RECIBO = " + objeto.getIdRecibo() + "");

			ResultSet rs = statement.executeQuery();
			rs.last();
			int totalRows = rs.getRow();
			rs.beforeFirst();
			int cont = 0;

			arr = new tipoPagoRecibo[totalRows];
			while (rs.next()) {
				arr[cont] = new tipoPagoRecibo();
				arr[cont].setIdTipoPagoReciboPK(rs.getInt("ID_TP_RE"));
				arr[cont].setIdRecibo(rs.getInt("ID_RECIBO"));
				arr[cont].setIdTipoPago(rs.getInt("ID_TP"));
				arr[cont].setCantidad(rs.getString("CANTIDAD"));
				arr[cont].setFecha(rs.getString("FECHA"));
				arr[cont].setDetalle(rs.getString("DETALLE"));
				arr[cont].setPlazo(rs.getString("PLAZO"));
				arr[cont].setEstado(rs.getString("ESTADO"));
				arr[cont].setTipoRecibo(rs.getInt("TIPO_RECIBO"));
				cont++;
			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return arr;

	}// en eliminar

	// //////////////////////////////////////////////////////////

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

	/*
	 * 
	 * retorna un hashTable todos los objetos de la tabla para choice
	 * 
	 */

	public Object[][] seleccionarTipoPagoTotal(Connection conn,
			int idTablaRecibo, int tipoRecibo) {
		int totalRows = 0;

		Object arreglo2[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("select "
					+ "CANTIDAD,DETALLE,FECHA,ID_TP,PLAZO,ESTADO,TIPO_RECIBO "
					+ "from tipo_pago_recibo " + "   where ID_RECIBO="
					+ idTablaRecibo + " and TIPO_RECIBO=" + tipoRecibo + "");
			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			arreglo2 = new Object[totalRows][7];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {
				arreglo2[cont][0] = rs.getString("CANTIDAD");
				arreglo2[cont][1] = rs.getString("DETALLE");
				arreglo2[cont][2] = rs.getString("FECHA");
				arreglo2[cont][3] = rs.getString("PLAZO");
				arreglo2[cont][4] = rs.getString("ID_TP");
				arreglo2[cont][5] = rs.getString("ESTADO");
				arreglo2[cont][6] = rs.getString("TIPO_RECIBO");

				cont++;
			}
			rs.close();

			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return arreglo2;
	}// seleccionar

}// end clase

