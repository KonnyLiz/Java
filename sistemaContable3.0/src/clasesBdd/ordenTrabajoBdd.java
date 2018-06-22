package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import clases.ordenDeTrabajo;
import clases.ordenTrabajoDetalle;

public class ordenTrabajoBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public void insertar(Connection conn, ordenDeTrabajo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into order_trabajo (ID_OT, ID_USER, ID_EMP, CI_RUC, OBSERVACION, NUMERO, FECHA, N_ARCHIVO, IMPRESION, PRECIO, ABONO, SALDO, ESTADO) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdOrdenDeTrabajo());
			statement.setInt(2, objeto.getIdUsuario());
			statement.setInt(3, objeto.getIdEmpleadoDiseñador());
			statement.setString(4, objeto.getCiRuc());
			statement.setString(5, objeto.getObservacion());
			statement.setInt(6, objeto.getNumeroOrdenTrabajo());
			statement.setString(7, objeto.getFecha());
			statement.setString(8, objeto.getNombredelArchivo());
			statement.setString(9, objeto.getImpresion());
			statement.setFloat(10, objeto.getPrecio());
			statement.setFloat(11, objeto.getAbono());
			statement.setFloat(12, objeto.getSaldo());
			statement.setString(13, objeto.getEstado());
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Ingresado Una Orden De Trabajo! ", "Aviso! ",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);

		}

	}// insertar

	/*
	 *
	 * Modifica un registro existente tipo cliente
	 *
	 *
	 */

	public int modificar(Connection conn, ordenDeTrabajo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update order_trabajo set"
							+ " ID_USER = ?," + " ID_EMP = ?, "
							+ "CI_RUC = ?, " + "OBSERVACION = ?, NUMERO = ?, "
							+ "FECHA = ?, N_ARCHIVO = ?, IMPRESION = ?,"
							+ " PRECIO = ?, ABONO = ?, SALDO = ?,"
							+ " ESTADO = ?" + "where ID_OT = ?");
			statement.setInt(1, objeto.getIdUsuario());
			statement.setInt(2, objeto.getIdEmpleadoDiseñador());
			statement.setString(3, objeto.getCiRuc());
			statement.setString(4, objeto.getObservacion());
			statement.setInt(5, objeto.getNumeroOrdenTrabajo());
			statement.setString(6, objeto.getFecha());
			statement.setString(7, objeto.getNombredelArchivo());
			statement.setString(8, objeto.getImpresion());
			statement.setFloat(9, objeto.getPrecio());
			statement.setFloat(10, objeto.getAbono());
			statement.setFloat(11, objeto.getSaldo());
			statement.setString(12, objeto.getEstado());
			statement.setInt(13, objeto.getIdOrdenDeTrabajo());
			// System.out.print(statement);
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Modificado la Orden De Trabajo! ", "Aviso! ",
					JOptionPane.INFORMATION_MESSAGE);

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
	 * Modifica un registro existente tipo cliente
	 *
	 *
	 */

	public int modificarEntregado(Connection conn, String id_ot) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update order_trabajo"
							+ " set	ESTADO = ?" + "where ID_OT = " + id_ot + "");
			statement.setString(1, "ENTREGADO");
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null, "Orden De trabajo entregada! ",
					"Aviso! ", JOptionPane.INFORMATION_MESSAGE);

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

	public int eliminar(Connection conn, ordenDeTrabajo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from order_trabajo where ID_OT = ?");
			statement.setInt(1, objeto.getIdOrdenDeTrabajo());
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

	public ordenDeTrabajo buscarInfoDeUnRegistro(Connection conn,
			ordenDeTrabajo objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_OT, ID_USER, ID_EMP, CI_RUC, OBSERVACION, FECHA, N_ARCHIVO, IMPRESION, PRECIO, ABONO, SALDO, ESTADO from order_trabajo where NUMERO="
							+ objeto.getNumeroOrdenTrabajo() + "");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				// ID_OT, ID_USER, ID_EMP, CI_RUC
				// OBSERVACION, FECHA, N_ARCHIVO, IMPRESION,
				// PRECIO, ABONO, SALDO, ESTADO
				objeto.setIdOrdenDeTrabajo(rs.getInt("ID_OT"));
				objeto.setIdUsuario(rs.getInt("ID_USER"));
				objeto.setIdEmpleadoDiseñador(rs.getInt("ID_EMP"));
				objeto.setCiRuc(rs.getString("CI_RUC"));
				objeto.setObservacion(rs.getString("OBSERVACION"));
				objeto.setFecha(rs.getString("FECHA"));
				objeto.setNombredelArchivo(rs.getString("N_ARCHIVO"));
				objeto.setImpresion(rs.getString("IMPRESION"));
				objeto.setPrecio(rs.getFloat("PRECIO"));
				objeto.setAbono(rs.getFloat("ABONO"));
				objeto.setPrecio(rs.getFloat("SALDO"));
				objeto.setEstado(rs.getString("ESTADO"));
				// Process data here

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return objeto;

	}// en eliminar

	/**
	 * deTalle de la Odt
	 *
	 * @param conn
	 * @return
	 */

	/*
	 * insertar registro en tabla Odt detalle
	 */
	public void insertarDetalle(Connection conn, ordenTrabajoDetalle objeto) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into orden_trabajo_detalle (ID_OT,  MEDIDA_X, MEDIDA_Y, PRECIO, DESCRIPCION) values (?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdOtNoUser());
			statement.setFloat(2, objeto.getMedidaX());
			statement.setFloat(3, objeto.getMedidaY());
			statement.setFloat(4, objeto.getPrecio());
			statement.setString(5, objeto.getDescripcion());
			statement.execute();
			statement.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);

		}

	}// insertar

	/*
	 * borrar detalle de registros de una Odt(detalle)
	 */
	public void eliminarDetalle(Connection conn, ordenTrabajoDetalle objeto) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("delete   FROM orden_trabajo_detalle where ID_OT="
							+ objeto.getIdOtNoUser() + " ");
			statement.execute();
			statement.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se elimino Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);

		}

	}// eliminar detalle

	/*
	 *
	 * retorna un objeto todos los objetos de la tabla
	 *
	 */

	/*public Object[][] seleccionarTodos(Connection conn) {
		int totalRows = 0;

		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_OT) from ordenDeTrabajo limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][11];
			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ "DISTINCT O.ID_OT, U.USERN, O.ID_EMP, C.NOMBRE, O.OBSERVACION,"
							+ " O.NUMERO, O.FECHA,  PRECIO, ABONO, SALDO, ESTADO "
							+ "" + "FROM Order_trabajo O,USER U,CLIENTE C"
							+ " WHERE O.ID_USER=U.ID_USER " + "GROUP BY   1");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getInt(1);
				datos[cont][1] = rs.getString(2);
				datos[cont][2] = rs.getInt(3);
				datos[cont][3] = rs.getString(4);
				datos[cont][4] = rs.getString(5);
				datos[cont][5] = rs.getInt(6);
				datos[cont][6] = rs.getString(7);
				datos[cont][7] = rs.getFloat(8);
				datos[cont][8] = rs.getFloat(9);
				datos[cont][9] = rs.getFloat(10);
				datos[cont][10] = rs.getFloat(11);
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
	}// seleccionar*/

	/*
	 *
	 * retorna un objeto todos los objetos de la tabla para choice
	 *
	 */

	/*public Hashtable RTRR(Connection conn) {
		int totalRows = 0;
		Hashtable arreglo = null;

		try {
			arregloTempOdT arreglotemp = new arregloTempOdT(0, 0, "", 0, "");
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_ordenDeTrabajo) from ordenDeTrabajo limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}

			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn.prepareStatement("SELECT"
					+ " ID_OT, NUMERO, FECHA, PRECIO " + " frOM order_trabajo");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				arreglotemp.id = rs.getInt("ID_OT");
				arreglotemp.numero = rs.getInt("NUMERO");
				arreglotemp.fecha = rs.getString("FECHA");
				arreglotemp.precio = rs.getFloat("PRECIO");
				arreglotemp.Adicional = "lleno";

				arreglo.put(rs.getInt("NUMERO"), arreglotemp);

			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return arreglo;
	}// seleccionar
/**/
	public int idParaNuevaOdt(Connection conn) {
		int siguiente = 0;

		try {
			PreparedStatement statement0 = conn
					.prepareStatement("SELECT max(id_ot)+1 FROM order_trabajo");
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

	// SELECT ID_OT, NUMERO, FECHA FROM order_trabajo where NUMERO=1

	/*
	 *
	 * devuelve una lista de ordenes segun criterio de busqueda
	 *
	 */

	public Object[][] seleccionarOdtLista(Connection conn, String numeroOdt) {
		int totalRows = 0;
		Object arreglo[][] = null;

		try {

			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_OT) from order_trabajo limit 20");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}

			Object arreglo2[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ "concat('Numero: ',NUMERO,'   Fecha: ',FECHA,'   Precio: $ ',PRECIO)"
							+ ", ID_OT,FECHA,PRECIO" + " FROM order_trabajo "
							+ "  where NUMERO='" + numeroOdt + "'");

			ResultSet rs = statement.executeQuery();
			int cont = 0;
			while (rs.next()) {
				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString("ID_OT");
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

	// SELECT ID_OT,MEDIDA_X, MEDIDA_Y, PRECIO, DESCRIPCION FROM
	// orden_trabajo_detalle where id_ot=1
	public Object[][] seleccionarOdtDetalle(Connection conn, String numeroOdt) {
		int totalRows = 0;
		Object arreglo[][] = null;

		try {

			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_OT) from order_trabajo limit 20");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}

			Object arreglo2[][] = new Object[totalRows][5];
			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ "count(id_ot),concat(MEDIDA_X,'x',MEDIDA_Y), PRECIO, DESCRIPCION "
							+ "FROM orden_trabajo_detalle " + "where id_ot="
							+ numeroOdt + "  group by DESCRIPCION,2");

			ResultSet rs = statement.executeQuery();
			int cont = 0;
			while (rs.next()) {
				float cantidad = rs.getFloat(1);
				float precioU = rs.getFloat(3);
				float total = cantidad * precioU;
				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(4);
				arreglo2[cont][2] = rs.getString(2);
				arreglo2[cont][3] = rs.getString(3);
				arreglo2[cont][4] = total;
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
	 * retorna un objeto todos los objetos de la tabla
	 *
	 */

	public ordenDeTrabajo seleccionarOdtEncabezado(Connection conn,
			int numeroOdtTabla) {
		int totalRows = 0;
		ordenDeTrabajo ordenDeTrabajoDp = new ordenDeTrabajo(0, 0, 0, null,
				null, 0, null, null, null, 0, 0, 0, null);
		try {

			PreparedStatement statement = conn.prepareStatement("select "
					+ "ID_OT, ID_USER, ID_EMP, CI_RUC, OBSERVACION, NUMERO,"
					+ " FECHA, N_ARCHIVO, IMPRESION, PRECIO, ABONO, SALDO,"
					+ " ESTADO " + "from order_trabajo " + "where ID_OT="
					+ numeroOdtTabla + "");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				ordenDeTrabajoDp.setIdOrdenDeTrabajo(rs.getInt("ID_OT"));
				ordenDeTrabajoDp.setIdUsuario(rs.getInt("ID_USER"));
				ordenDeTrabajoDp.setIdEmpleadoDiseñador(rs.getInt("ID_EMP"));
				ordenDeTrabajoDp.setCiRuc(rs.getString("CI_RUC"));
				ordenDeTrabajoDp.setObservacion(rs.getString("OBSERVACION"));
				ordenDeTrabajoDp.setNumeroOrdenTrabajo(rs.getInt("NUMERO"));
				ordenDeTrabajoDp.setFecha(rs.getString("FECHA"));
				ordenDeTrabajoDp.setNombredelArchivo(rs.getString("N_ARCHIVO"));
				ordenDeTrabajoDp.setImpresion(rs.getString("IMPRESION"));
				ordenDeTrabajoDp.setPrecio(rs.getFloat("PRECIO"));
				ordenDeTrabajoDp.setAbono(rs.getFloat("ABONO"));
				ordenDeTrabajoDp.setSaldo(rs.getFloat("SALDO"));
				ordenDeTrabajoDp.setEstado(rs.getString("ESTADO"));
				// Process data here
			}
			rs.close();

			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return ordenDeTrabajoDp;
	}// seleccionar

	/**
	 * selecciona el detalle de una orden de trabajo según el número
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
					+ " C.NOMBRE, O.NUMERO, O.FECHA,O.PRECIO,"
					+ " O.ABONO, O.SALDO,O.ID_OT,O.OBSERVACION "
					+ " FROM order_trabajo O, cliente C  "
					+ " where  ESTADO='PENDIENTE' "
					+ " AND C.CI_RUC=O.CI_RUC  order by 2");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(3);
				arreglo2[cont][2] = rs.getString(2);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);
				arreglo2[cont][7] = rs.getString(8);

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
	 * SELECT count(id_ot),
	 * concat(descripcion,MEDIDA_X,'x',MEDIDA_Y,'u'),precio,medida_y FROM
	 * orden_trabajo_detalle d where id_ot=(select id_ot from order_trabajo
	 * where numero='777' and estado='PENDIENTE' ) group by 2
	 *
	 *
	 *
	 *
	 */

	/**
	 * selecciona el detalle de una orden de trabajo según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] solicitarItems(Connection conn, int rowExistente,
			int rowMax, String odtNumero) {
		int totalRows = 0;
		Object arreglo[][] = null;

		try {

			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ "count(ID_OT), concat(DESCRIPCION,MEDIDA_X,'x',MEDIDA_Y)"
							+ ",PRECIO,MEDIDA_Y "
							+ "FROM orden_trabajo_detalle d "
							+ "where ID_OT=(select ID_OT from order_trabajo where NUMERO='"
							+ odtNumero + "' " + "and ESTADO='PENDIENTE'  limit 1 ) "
							+ "group by 2");

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
		if (totalRows > (rowMax - rowExistente))
			arreglo = null;

		return arreglo;
	}// seleccionar

	public float solicitarTotal(Connection conn,String odtNumero){
		float Total = 0;


		try {

			PreparedStatement statement = conn
					.prepareStatement("SELECT  PRECIO " +
							" FROM order_trabajo " +
							"  where  NUMERO="+odtNumero+" " +
							"  and ESTADO='PENDIENTE'");

			ResultSet rs = statement.executeQuery();

				for (int i = 0; i < 1; i++) {
				rs.next();
				Total =Float.parseFloat(rs.getString(1));


			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

  return Total;
	}


	/**
	 * selecciona el ruc de una orden de trabajo según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] solicitarRuc(Connection conn, String odtNumero) {
		int totalRows = 0;
		Object arreglo[][] = null;

		try {

			PreparedStatement statement = conn.prepareStatement("select  "
					+ "CI_RUC from order_trabajo" + " where NUMERO='"
					+ odtNumero + "' " + "and ESTADO='PENDIENTE'");

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
	 * Modifica un registro existente tipo cliente
	 *
	 *
	 */

	public int modificarEstado(Connection conn, String estado, String idOt,
			String numero) {
		try {

			PreparedStatement statement = conn.prepareStatement("update "
					+ "order_trabajo" + " set  ESTADO = '" + estado + "'"
					+ " where ID_OT = '" + idOt + "'");

			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Modificado la Orden De Trabajo : " + numero,
					"Aviso! ", JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Modificó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// modificar

	/**
	 * selecciona el ruc de una orden de trabajo según el número
	 *
	 * @param conn
	 * @param numeroOdt
	 * @return
	 */

	public Object[][] solicitarIdTablaOrdenTraajoPorNumero(Connection conn,
			String odtNumero) {
		int totalRows = 0;
		Object arreglo[][] = null;

		try {

			PreparedStatement statement = conn.prepareStatement("select  "
					+ "ID_OT from order_trabajo" + " where numero='"
					+ odtNumero + "' " + "and ESTADO='PENDIENTE'");

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

	/**
	 * consultas por parámetros
	 */

	/**
	 * Encabezados de ODT por fecha inicial y fecha final
	 */
	public Object[][] seleccionarOdtEncabezadosFechas(Connection conn,
			String fecha1, String fecha2) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " C.NOMBRE, O.NUMERO, O.FECHA,O.PRECIO,"
					+ " O.ABONO, O.SALDO,O.ID_OT,O.OBSERVACION "
					+ " FROM order_trabajo O, cliente C  " + " where "
					+ "  C.CI_RUC=O.CI_RUC " + "AND O.FECHA BETWEEN '" + fecha1
					+ "' AND '" + fecha2 + "'" + " 	ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(3);
				arreglo2[cont][2] = rs.getString(2);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);
				arreglo2[cont][7] = rs.getString(8);

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
	 * Encabezados de ODT por fecha inicial y fecha final y nombre
	 */
	public Object[][] seleccionarOdtEncabezadosFechasNombre(Connection conn,
			String fecha1, String fecha2, String Nombre) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ " C.NOMBRE, O.NUMERO, O.FECHA,O.PRECIO,"
							+ " O.ABONO, O.SALDO,O.ID_OT,O.OBSERVACION "
							+ " FROM order_trabajo O, cliente C  " + " where "
							+ "  C.CI_RUC=O.CI_RUC " + " AND O.FECHA BETWEEN '"
							+ fecha1 + "' AND '" + fecha2 + "'"
							+ " 	AND C.NOMBRE LIKE '%" + Nombre + "%'"
							+ " 	ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(3);
				arreglo2[cont][2] = rs.getString(2);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);
				arreglo2[cont][7] = rs.getString(8);

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
	 * Encabezados de ODT por fecha inicial y fecha final y numero de recibo
	 */
	public Object[][] seleccionarOdtEncabezadosFechasNumero(Connection conn,
			String fecha1, String fecha2, String numero) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " C.NOMBRE, O.NUMERO, O.FECHA,O.PRECIO,"
					+ " O.ABONO, O.SALDO,O.ID_OT,O.OBSERVACION "
					+ " FROM order_trabajo O, cliente C  " + " where "
					+ "  C.CI_RUC=O.CI_RUC " + " AND O.FECHA BETWEEN '"
					+ fecha1 + "' AND '" + fecha2 + "'" + " 	AND O.NUMERO = '"
					+ numero + "'" + " 	ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(3);
				arreglo2[cont][2] = rs.getString(2);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);
				arreglo2[cont][7] = rs.getString(8);

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
	 * Encabezados de ODT por fecha inicial y fecha final y ruc o cédula
	 */
	public Object[][] seleccionarOdtEncabezadosFechasRuc(Connection conn,
			String fecha1, String fecha2, String ruc) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " C.NOMBRE, O.NUMERO, O.FECHA,O.PRECIO,"
					+ " O.ABONO, O.SALDO,O.ID_OT,O.OBSERVACION "
					+ " FROM order_trabajo O, CLIENTE C  " + " where "
					+ "  C.CI_RUC=O.CI_RUC " + " AND O.FECHA BETWEEN '"
					+ fecha1 + "' AND '" + fecha2 + "'" + " 	AND C.CI_RUC = '"
					+ ruc + "'" + " 	ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(3);
				arreglo2[cont][2] = rs.getString(2);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);
				arreglo2[cont][6] = rs.getString(7);
				arreglo2[cont][7] = rs.getString(8);

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

}// end clase

