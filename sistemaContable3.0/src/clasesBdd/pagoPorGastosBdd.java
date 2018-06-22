package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.arregloTempHash;
import clases.comprasGastos;
import clases.comprobanteEgreso;
import clases.pagosPorGastos;

public class pagoPorGastosBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, pagosPorGastos objeto) {
		String a = null;
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into pagos_por_gasto (ID_PAGO_POR_GASTO, ID_COM_GAS, ID_TP, ID_CUENTA_TABLA, NUMERO_COMPROBANTE, TOTAL, FECHA_GENERACION, PLAZO_PAGO, BENEFICIARIO) values (?, ?, ?, ?, ?, ?,?, ?, ?)");

			statement.setInt(1, objeto.getIdPagoPorGasto());
			statement.setInt(2, objeto.getIdCompraGasto());
			statement.setInt(3, objeto.getIdTipoDePago());
			statement.setInt(4, objeto.getIdCuentaTablaBanco());
			statement.setInt(5, objeto.getNumeroComprobante());
			statement.setFloat(6, objeto.getTotal());
			statement.setString(7, objeto.getFechaGeneracionDeuda());
			statement.setString(8, objeto.getPlazoDePago());
			statement.setString(9, objeto.getBeneficiario());
			statement.execute();
			modificarComoPagado(conn, objeto);
			a = statement.toString();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Ingresado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage() + a, "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// insertar

	/*
	 *
	 * Modifica un registro existente tipo cliente
	 *
	 *
	 */

	public int modificar(Connection conn, pagosPorGastos objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update pagos_por_gasto set ID_COM_GAS = ?, ID_TP = ?, ID_CUENTA_TABLA = ?, NUMERO_COMPROBANTE = ?, TOTAL = ?, FECHA_GENERACION = ?, PLAZO_PAGO = ?, BENEFICIARIO = ? where ID_PAGO_POR_GASTO = ?");
			statement.setInt(1, objeto.getIdCompraGasto());
			statement.setInt(2, objeto.getIdTipoDePago());
			statement.setInt(3, objeto.getIdCuentaTablaBanco());
			statement.setInt(4, objeto.getNumeroComprobante());
			statement.setFloat(5, objeto.getTotal());
			statement.setString(6, objeto.getFechaGeneracionDeuda());
			statement.setString(7, objeto.getPlazoDePago());
			statement.setString(8, objeto.getBeneficiario());
			statement.setInt(9, objeto.getIdPagoPorGasto());
			statement.execute();
			modificarComoPagado(conn, objeto);
			// statement.close();
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

	public int eliminar(Connection conn, pagosPorGastos objeto) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("delete from pagos_por_gasto where ID_PAGO_POR_GASTO = ?");
			statement.setInt(1, objeto.getIdPagoPorGasto());
			statement.execute();
			modificarComoPagado(conn, objeto);
			// statement.close();
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

	public pagosPorGastos buscarInfoDeUnRegistro(Connection conn,
			pagosPorGastos objeto) {

		try {

			PreparedStatement statement = conn.prepareStatement(""
					+ "		select  ID_COM_GAS, ID_TP,"
					+ " 				ID_CUENTA_TABLA, NUMERO_COMPROBANTE,"
					+ "				TOTAL, FECHA_GENERACION, PLAZO_PAGO,"
					+ "				BENEFICIARIO " + "		from pagos_por_gasto"
					+ "		 where ID_PAGO_POR_GASTO='"
					+ objeto.getIdPagoPorGasto() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdCompraPago(rs.getInt("ID_COM_GAS"));
				objeto.setIdTipoDePago(rs.getInt("ID_TP"));
				objeto.setIdCuentaTablaBanco(rs.getInt("ID_CUENTA_TABLA"));
				objeto.setNumeroComprobante(rs.getInt("NUMERO_COMPROBANTE"));
				objeto.setTotal(rs.getInt("TOTAL"));
				objeto
						.setFechaGeneracionDeuda(rs
								.getString("FECHA_GENERACION"));
				objeto.setPlazoDePago(rs.getString("PLAZO_PAGO"));
				objeto.setBeneficiario(rs.getString("BENEFICIARIO"));

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
					.prepareStatement("select count(ID_PAGO_POR_GASTO) from pagos_por_gasto limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][8];
			PreparedStatement statement = conn.prepareStatement("" + ""
					+ "SELECT ID_PAGO_POR_GASTO, "
					+ "C.DESCRIPCION,T.DESCRIPCION, "
					+ "NUMERO_CUENTA, TOTAL, FECHA_GENERACION, "
					+ "PLAZO_PAGO, BENEFICIARIO" + "FROM pagos_por_gasto"
					+ "	  p,compras_gastos" + "     c, tipo_pago T,"
					+ "      cuentas_banco B"
					+ "where p.ID_COM_GAS=c.ID_COM_GAS"
					+ "AND   T.ID_TP=P.ID_TP"
					+ "AND P.ID_CUENTA_TABLA=B.ID_CUENTA_TABLA" + "");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString(1);
				datos[cont][1] = rs.getString(2);
				datos[cont][2] = rs.getString(3);
				datos[cont][3] = rs.getString(4);
				datos[cont][4] = rs.getString(5);
				datos[cont][5] = rs.getString(6);
				datos[cont][6] = rs.getString(7);
				datos[cont][7] = rs.getString(8);

				// ID_PAGO_POR_GASTO
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
	 * retorna el siguiente numero de la secuencia
	 *
	 */

	public String seleccionarMaxAutoIncrementTabla(Connection conn) {
		String totalRows = "0";
		try {
			PreparedStatement statement0 = conn
					.prepareStatement("SELECT max(ID_PAGO_POR_GASTO) FROM pagos_por_gasto");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = "" + (rs1.getInt(1) + 1);
			}
			if (totalRows == null)
				totalRows = "" + 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return totalRows;
	}// seleccionar

	/**
	 * hash de totales pagados recibe llave id_com_gas bdd
	 *
	 * @param conn
	 * @return
	 */

	public Hashtable<String, arregloTempHash> seleccionarTotalesPagadosDeudasObjetoTablaHash(
			Connection conn) {
		int totalRows = 0;
		Hashtable<String, arregloTempHash> comprasGastosLista = new Hashtable<String, arregloTempHash>();
		arregloTempHash claseTemporal = new arregloTempHash("", "", "", "", "");

		try {
			comprasGastos comprasGastosDp;
			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_COM_GAS) from compras_gastos limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			if (totalRows == 0) {
				comprasGastosLista.put("Sin Registros", claseTemporal);
			} else {

				PreparedStatement statement = conn.prepareStatement("select "
						+ " p.ID_COM_GAS,  SUM(p.TOTAL),"
						+ " c.estado FROM pagos_por_gasto p,"
						+ " compras_gastos c "
						+ " where p.ID_COM_GAS=c.ID_COM_GAS "
						+ "  and  c.ESTADO='pendiente' " + "  GROUP BY 1");

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					claseTemporal = new arregloTempHash("", rs.getString(1), rs
							.getString(2), "", "");

					String clave = rs.getString(1);
					comprasGastosLista.put(clave, claseTemporal);// fixed

					cont++;

				}
				rs.close();

				statement.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return comprasGastosLista;
	}// seleccionar

	/**
	 * Setear como pagado una deuda
	 *
	 * @param conn
	 * @param objeto
	 * @return
	 */

	public void modificarComoPagado(Connection conn, pagosPorGastos objeto) {
		float sumaPagos = 0;
		String estado;
		float totalAPagarRestadoRetencion = 0;

		try {
			PreparedStatement statement0 = conn
					.prepareStatement("select  SUM(TOTAL) "
							+ "FROM pagos_por_gasto " + "where ID_COM_GAS="
							+ objeto.getIdCompraGasto() + "");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				sumaPagos = rs1.getFloat(1);
				statement0 = conn.prepareStatement("SELECT ID_COM_GAS, "
						+ "TOTAL_PAGADO-TOTAL_RETENCION "
						+ "FROM compras_gastos " + "where id_com_gas="
						+ objeto.getIdCompraGasto() + "");
				rs1 = statement0.executeQuery();
				while (rs1.next()) {
					totalAPagarRestadoRetencion = rs1.getFloat(2);
				}

				if (sumaPagos == totalAPagarRestadoRetencion) {
					estado = "PAGADO";
				} else {
					estado = "PENDIENTE";
				}

				PreparedStatement statement = conn.prepareStatement("update "
						+ "					compras_gastos" + "					set ESTADO='" + estado
						+ "' " + "					WHERE ID_COM_GAS="
						+ objeto.getIdCompraGasto() + "");
				statement.execute();
				// statement.close();
				// statement0.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}

	}// modificar

	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertarComEgreso(Connection conn, comprobanteEgreso objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into comprobante_egreso ( TIPO_COMPROBANTE, TOTAL, DESCRIPCION, FECHA, NUMERO_COMPROBANTE) values ( ?, ?, ?, ?, ?)");

			statement.setString(1, objeto.getTipoComprobante());
			statement.setFloat(2, objeto.getTotal());
			statement.setString(3, objeto.getDescripcion());
			statement.setString(4, objeto.getFecha());
			statement.setInt(5, objeto.getNumeroRecibo());
			statement.execute();
			statement.close();
			// JOptionPane.showMessageDialog(null, "Se ha Ingresado un Registro!
			// ", "Aviso!", JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// insertar

	/*
	 *
	 * Eliminar un registro existente tipo cliente
	 *
	 *
	 */

	public int eliminarComEgreso(Connection conn, comprobanteEgreso objeto) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("delete from comprobante_egreso where ID_COMPROBANTE = ?  and TOTAL = ?");
			statement.setInt(1, objeto.getNumeroRecibo());
			statement.setFloat(2, objeto.getTotal());
			statement.execute();
			statement.close();
			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Eliminó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// eliminar

	public int seleccionarMaxAutoIncrementTablaComprobanteEgreso(Connection conn) {
		String totalRows = "0";
		try {
			PreparedStatement statement0 = conn
					.prepareStatement("SELECT max(ID_COMPROBANTE) FROM comprobante_egreso");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = "" + (rs1.getInt(1) + 1);
			}
			if (totalRows == null)
				totalRows = "" + 0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		int salida = 0;
		try {
			salida = Integer.parseInt(totalRows);
		} catch (Exception noNum) {

		}

		return salida;
	}// seleccionar

	/**
	 * Encabezados de PAGOS por fecha inicial y fecha final Y BENEFICIARIO
	 */
	public Object[][] seleccionarOdtEncabezadosBeneficiario(Connection conn,
			String fecha1, String fecha2, String criterioBusqueda) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ " ID_COM_GAS, "
							+ " (Select DESCRIPCION from tipo_pago where ID_TP=p.ID_TP)"
							+ ",(SELECT NUMERO_CUENTA FROM cuentas_banco WHERE ID_CUENTA_TABLA = P.ID_CUENTA_TABLA),"
							+ "  NUMERO_COMPROBANTE," + " TOTAL, "
							+ " FECHA_GENERACION, " + " PLAZO_PAGO, "
							+ " BENEFICIARIO " + "	FROM pagos_por_gasto p "
							+ " where " + "	BENEFICIARIO like '%"
							+ criterioBusqueda + "%' "
							+ "AND  FECHA_GENERACION " + "	BETWEEN '" + fecha1
							+ "'" + "		AND '" + fecha2 + "'"
							+ " ORDER BY FECHA_GENERACION");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
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
	 * Encabezados de PAGOS por fecha inicial y fecha final
	 */
	public Object[][] seleccionarOdtEncabezadosFechas(Connection conn,
			String fecha1, String fecha2) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ " ID_COM_GAS, "
							+ " (Select DESCRIPCION from tipo_pago where ID_TP=p.ID_TP)"
							+ ",(SELECT NUMERO_CUENTA FROM cuentas_banco WHERE ID_CUENTA_TABLA = P.ID_CUENTA_TABLA),"
							+ "  NUMERO_COMPROBANTE," + " TOTAL, "
							+ " FECHA_GENERACION, " + " PLAZO_PAGO, "
							+ " BENEFICIARIO " + "	FROM pagos_por_gasto p "
							+ " where " + " FECHA_GENERACION " + "	BETWEEN '"
							+ fecha1 + "'" + "		AND '" + fecha2 + "'"
							+ " ORDER BY FECHA_GENERACION");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
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
	 * devuelve los pagos por las fechas indicadas mas el parámetro adicional
	 * del número de comprobante de pago
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @param numero
	 * @return
	 */
	public Object[][] seleccionarOdtEncabezadosFechasNumero(Connection conn,
			String fecha1, String fecha2, String numero) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ " ID_COM_GAS,"
							+ " (Select DESCRIPCION from tipo_pago where ID_TP=p.ID_TP)"
							+ " ,(SELECT NUMERO_CUENTA FROM CUENTAS_BANCO"
							+ "  WHERE ID_CUENTA_TABLA = P.ID_CUENTA_TABLA), "
							+ "  NUMERO_COMPROBANTE, " + "  TOTAL, "
							+ "  FECHA_GENERACION, "
							+ "  PLAZO_PAGO,  BENEFICIARIO"
							+ "  	FROM pagos_por_gasto p "
							+ "    where  NUMERO_COMPROBANTE = " + numero + ""
							+ "   AND FECHA_GENERACION " + "		    BETWEEN '"
							+ fecha1 + "'" + "				AND '" + fecha2 + "'"
							+ "    ORDER BY FECHA_GENERACION");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
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



	/** módulo consultaPagosporCompras.java
	 * Encabezados de compras
	 *  por fecha inicial y fecha final
	 */
	public Object[][] seleccionarComprasPorFecha(Connection conn,
			String fecha1, String fecha2) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT " +
							" ID_COM_GAS, COMPROBANTE, DESCRIPCION," +
							" TIPO_COMPROBANTE, TOTAL_PAGADO, DESCRIPCIO_ADICIONAL," +
							" FECHA_COMPRA, ESTADO" +
							" FROM compras_gastos c " +
							" where FECHA_COMPRA " +
							"		BETWEEN '"+fecha1+"'	AND '"+fecha2+"'" +
							" ORDER BY FECHA_COMPRA");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
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


	/** módulo consultaPagosporCompras.java
	 * Encabezados de compras
	 * por fecha inicial y fecha final y nombre
	 *  módulo consultaPagosporCompras.java
	 */
	public Object[][] seleccionarComprasPorNombre(Connection conn,
			String fecha1, String fecha2,String Nombre) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT " +
							" ID_COM_GAS, COMPROBANTE, DESCRIPCION," +
							" TIPO_COMPROBANTE, TOTAL_PAGADO, DESCRIPCIO_ADICIONAL," +
							" FECHA_COMPRA, ESTADO" +
							" FROM compras_gastos c " +
							" where FECHA_COMPRA " +
							"		BETWEEN '"+fecha1+"'	AND '"+fecha2+"'" +
							"  and DESCRIPCION like'"+Nombre+"%'   " +
							"     " +
							" ORDER BY FECHA_COMPRA");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
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

	/** módulo consultaPagosporCompras.java
	 * Encabezados de compras
	 *   por fecha inicial y fecha final y número de recibo
	 */
	public Object[][] seleccionarComprasPorNumeroReciboCompra(Connection conn,
			String fecha1, String fecha2,String Nombre) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn
					.prepareStatement("SELECT " +
							" ID_COM_GAS, COMPROBANTE, DESCRIPCION," +
							" TIPO_COMPROBANTE, TOTAL_PAGADO, DESCRIPCIO_ADICIONAL," +
							" FECHA_COMPRA, ESTADO" +
							" FROM compras_gastos c " +
							" where FECHA_COMPRA " +
							"		BETWEEN '"+fecha1+"' AND '"+fecha2+"'" +
							"  and COMPROBANTE like '"+Nombre+"%'   " +
							"     " +
							" ORDER BY FECHA_COMPRA");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][8];
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


}