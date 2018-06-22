package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import clases.proforma;
import clases.proformaDetalle;

public class proformaBdd {
	/*
	 * insertar registroen proforma
	 */
	public void insertar(Connection conn, proforma objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into proforma (ID_PROFORMA, CI_RUC, FECHA, CIUDAD, SUBTOTAL, TOTAL, IVA, ESTADO) values (?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdProforma());
			statement.setString(2, objeto.getCiRuc());
			statement.setString(3, objeto.getFecha());
			statement.setString(4, objeto.getCiudad());
			statement.setFloat(5, objeto.getSubtotal());
			statement.setFloat(6, objeto.getTotal());
			statement.setFloat(7, objeto.getIva());
			statement.setString(8, objeto.getEstado());
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Ingresado Una Proforma! ", "Aviso! ",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);

		}

	}// insertar

	/*
	 *
	 * Eliminar un registro existente tipo cliente
	 *
	 *
	 */

	public int eliminar(Connection conn, proforma objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from proforma where ID_PROFORMA = ?");
			statement.setInt(1, objeto.getIdProforma());
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

	/**
	 * deTalle de la proforma
	 *
	 * @param conn
	 * @return
	 */

	/*
	 * insertar registro en tabla Odt detalle
	 */
	public int insertarDetalle(Connection conn, proformaDetalle objeto) {
		int salida = 0;
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into proforma_detalle (ID_PROFORMA,  ID_PRO, DESCRIPCION, MEDIDA_X, MEDIDA_Y, PRECIO) values (?, ?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdProforma());
			statement.setInt(2, objeto.getIdPro());
			statement.setString(3, objeto.getIdDescripcion());
			statement.setFloat(4, objeto.getIdMedidaX());
			statement.setFloat(5, objeto.getIdMedidaY());
			statement.setFloat(6, objeto.getIdPrecio());
			statement.execute();
			statement.close();

			salida = 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);

			salida = 0;
		}
		return salida;
	}// insertar

	/*
	 * borrar detalle de registros de una Odt(detalle)
	 */
	public void eliminarDetalleProforma(Connection conn, proformaDetalle objeto) {
		try {
			PreparedStatement statement = conn.prepareStatement("delete "
					+ "from proforma_detalle " + "where ID_PROFORMA='"
					+ objeto.getIdProforma() + "'");
			statement.execute();
			statement.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se elimino Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);

		}

	}// eliminar detalle

	/**
	 * devuelve el numero suguerido para proforma
	 *
	 * @param conn
	 * @return
	 */
	public int idParaNuevaProforma(Connection conn) {
		int siguiente = 0;

		try {
			PreparedStatement statement0 = conn
					.prepareStatement("SELECT max(ID_PROFORMA)+1 FROM proforma");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				siguiente = rs1.getInt(1);

			}
			rs1.close();
			statement0.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return siguiente;
	}// seleccionar

	/**
	 * selecciona el detalle de una proforma según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] seleccionarOdtEncabezadosTodos(Connection conn) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ "P.ID_PROFORMA, C.NOMBRE, P.FECHA,"
					+ " P.SUBTOTAL, P.TOTAL, P.IVA, P.ESTADO"
					+ " FROM proforma P,cliente C "
					+ "WHERE P.CI_RUC=C.CI_RUC " + "ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][7];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;
	}// seleccionar

	/**
	 * selecciona el detalle de una orden de una proforma según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] solicitarItems(Connection conn, String proformaNumero) {
		int totalRows = 0;
		Object arreglo[][] = null;

		try {

			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ " count(id_proforma), concat( DESCRIPCION ,MEDIDA_X,'x',MEDIDA_Y),precio,medida_y "
							+ "FROM proforma_detalle p " + "where ID_PROFORMA="
							+ "	(select ID_PROFORMA from proforma "
							+ "	  where ID_PROFORMA='" + proformaNumero + "' "
							+ "	  and estado='PENDIENTE' )" + " group by 2");

			ResultSet rs = statement.executeQuery();

			rs.last();
			totalRows = rs.getRow();
			rs.beforeFirst();
			int cont = 0;

			Object arreglo2[][] = new Object[totalRows][4];
			for (int i = 0; i < totalRows; i++) {
				rs.next();
				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = 0;
				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return arreglo;
	}// seleccionar

	/**
	 * selecciona el ruc de una proforma según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] solicitarRuc(Connection conn, String proformaNumero) {
		int totalRows = 0;
		Object arreglo[][] = null;

		try {

			PreparedStatement statement = conn.prepareStatement("select "
					+ " ci_ruc from proforma" + " where id_proforma='"
					+ proformaNumero + "'" + "");

			ResultSet rs = statement.executeQuery();

			rs.last();
			totalRows = rs.getRow();
			rs.beforeFirst();
			int cont = 0;

			Object arreglo2[][] = new Object[totalRows][1];
			for (int i = 0; i < totalRows; i++) {
				rs.next();
				arreglo2[cont][0] = rs.getString(1);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return arreglo;
	}// seleccionar

	/*
	 *
	 * Modifica un registro existente
	 *
	 */

	public int modificarEstado(Connection conn, proforma objeto, String detalle) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("update proforma set  ESTADO = ? where ID_PROFORMA = ?");

			statement.setString(1, detalle);
			statement.setInt(2, objeto.getIdProforma());

			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Modificado la proforma: ", "Aviso! ",
					JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Modificó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// modificar

	/**
	 * selecciona el detalle de una proforma según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] seleccionarOdtEncabezadosNombre(Connection conn,
			String Nombre) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " P.ID_PROFORMA, C.NOMBRE, P.FECHA, P.SUBTOTAL, "
					+ " P.TOTAL, P.IVA, P.ESTADO "
					+ "  FROM proforma P,cliente C"
					+ "  WHERE P.CI_RUC=C.CI_RUC " + "  AND C.NOMBRE LIKE '%"
					+ Nombre + "%'" + "  ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][7];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;
	}// seleccionar

	/**
	 * selecciona el detalle de una proforma según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] seleccionarOdtEncabezadosFecha(Connection conn,
			String Nombre) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " P.ID_PROFORMA, C.NOMBRE, P.FECHA, P.SUBTOTAL, "
					+ " P.TOTAL, P.IVA, P.ESTADO "
					+ "  FROM proforma P,cliente C"
					+ "  WHERE P.CI_RUC=C.CI_RUC " + "  AND C.NOMBRE LIKE '%"
					+ Nombre + "%'" + "  ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][7];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;
	}// seleccionar

	/**
	 * selecciona el detalle de una proforma según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] seleccionarOdtEncabezadosFecha1Fecha2(Connection conn,
			String fecha1, String Fecha2) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT"
					+ " P.ID_PROFORMA, C.NOMBRE, P.FECHA, P.SUBTOTAL, "
					+ " P.TOTAL, P.IVA, P.ESTADO "
					+ "   FROM proforma P,cliente C "
					+ " WHERE P.CI_RUC=C.CI_RUC" + "  AND P.FECHA BETWEEN '"
					+ fecha1 + "' AND '" + Fecha2 + "'" + " 	ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][7];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;
	}// seleccionar

	public Object[][] seleccionarOdtEncabezadosNumero(Connection conn,
			String Numero) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT"
					+ " P.ID_PROFORMA, C.NOMBRE, P.FECHA, P.SUBTOTAL,"
					+ "  P.TOTAL, P.IVA, P.ESTADO"
					+ "   FROM proforma P,cliente C "
					+ "     WHERE P.CI_RUC=C.CI_RUC "
					+ "     AND  P.ID_PROFORMA='" + Numero + "' "
					+ "  	ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][7];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;
	}// seleccionar

	//

	public String seleccionarOdtEncabezadosFecha1Fecha22(Connection conn,
			String fecha1, String Fecha2) {
		int totalRows = 0;
		String a = null;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT"
					+ " P.ID_PROFORMA, C.NOMBRE, P.FECHA, P.SUBTOTAL, "
					+ " P.TOTAL, P.IVA, P.ESTADO "
					+ "   FROM proforma P,cliente C "
					+ " WHERE P.CI_RUC=C.CI_RUC" + "  AND P.FECHA BETWEEN '"
					+ fecha1 + "' AND '" + Fecha2 + "'" + " 	ORDER BY 1");
			a = statement.toString();
			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][7];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return a;
	}// seleccionar

}// end clase

