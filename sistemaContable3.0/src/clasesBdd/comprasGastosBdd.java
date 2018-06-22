package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.arregloTempHash;
import clases.comprasGastos;
import clases.pagoGastoProvedoresClassModeloTabla;

public class comprasGastosBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, comprasGastos objeto) {
		String test = null;
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into compras_gastos ( COMPROBANTE, DESCRIPCION, TIPO_COMPROBANTE, IVA, SUBTOTAL, TOTAL_PAGADO, DESCRIPCIO_ADICIONAL, NUMERO_RETENCION, TOTAL_RETENCION,FECHA_COMPRA,ESTADO) values (  ?,?, ?, ?, ?, ?, ?, ?, ?, ?,?)");
			test = statement.toString();

			statement.setInt(1, objeto.getNumeroComprobante());// COMPROBANTE
			statement.setString(2, objeto.getDescripcion());// DESCRIPCION
			statement.setString(3, objeto.getTipoComprobante());// TIPO_COMPROBANTE
			statement.setFloat(4, objeto.getIva());// IVA
			statement.setFloat(5, objeto.getSubtotal());// SUBTOTAL
			statement.setFloat(6, objeto.getTotalPagado());// TOTAL_PAGADO
			statement.setString(7, objeto.getDescripcionAdicional());// DESCRIPCIO_ADICIONAL
			statement.setInt(8, objeto.getNumeroRetencion());// NUMERO_RETENCION
			statement.setFloat(9, objeto.getTotalRetencion());// TOTAL_RETENCION
			statement.setString(10, objeto.getFechaCompra());// FECHA_COMPRA
			statement.setString(11, "PENDIENTE");// ESTADO
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Ingresado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			System.out.print("statemen:" + test);
			return 0;
		}

	}// insertar

	/*
	 * 
	 * Modifica un registro existente tipo cliente
	 * 
	 * 
	 */

	public int modificar(Connection conn, comprasGastos objeto) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("update compras_gastos set COMPROBANTE = ?, DESCRIPCION = ?, TIPO_COMPROBANTE = ?, IVA = ?, SUBTOTAL = ?, TOTAL_PAGADO = ?, DESCRIPCIO_ADICIONAL = ?, NUMERO_RETENCION = ?, TOTAL_RETENCION = ?, FECHA_COMPRA = ?  where ID_COM_GAS = ?");
			statement.setInt(1, objeto.getNumeroComprobante());
			statement.setString(2, objeto.getDescripcion());
			statement.setString(3, objeto.getTipoComprobante());
			statement.setFloat(4, objeto.getIva());
			statement.setFloat(5, objeto.getSubtotal());
			statement.setFloat(6, objeto.getTotalPagado());
			statement.setString(7, objeto.getDescripcionAdicional());
			statement.setInt(8, objeto.getNumeroRetencion());
			statement.setFloat(9, objeto.getTotalRetencion());
			statement.setString(10, objeto.getFechaCompra());
			statement.setInt(11, objeto.getIdCompraGasto());
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

	public int eliminar(Connection conn, comprasGastos objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from compras_gastos where ID_COM_GAS = ?");
			statement.setInt(1, objeto.getIdCompraGasto());
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

	public comprasGastos buscarInfoDeUnRegistro(Connection conn,
			comprasGastos objeto) {

		try {

			PreparedStatement statement = conn.prepareStatement("select "
					+ "		COMPROBANTE, DESCRIPCION, TIPO_COMPROBANTE, "
					+ "		IVA, SUBTOTAL, TOTAL_PAGADO, DESCRIPCIO_ADICIONAL,"
					+ "		 NUMERO_RETENCION, TOTAL_RETENCION,FECHA_COMPRA "
					+ "		 from compras_gastos " + "		where ID_COM_GAS='"
					+ objeto.getIdCompraGasto() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				objeto.setNumeroComprobante(rs.getInt("COMPROBANTE"));
				objeto.setDescripcion(rs.getString("DESCRIPCION"));
				objeto.setTipoComprobante(rs.getString("TIPO_COMPROBANTE"));
				objeto.setIva(rs.getFloat("IVA"));
				objeto.setSubtotal(rs.getFloat("SUBTOTAL"));
				objeto.setTotalPagado(rs.getFloat("TOTAL_PAGADO"));
				objeto.setDescripcionAdicional(rs
						.getString("DESCRIPCIO_ADICIONAL"));
				objeto.setNumeroRetencion(rs.getInt("NUMERO_RETENCION"));
				objeto.setTotalRetencion(rs.getFloat("TOTAL_RETENCION"));
				objeto.setFechaCompra(rs.getString("FECHA_COMPRA"));
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
					.prepareStatement("select count(ID_COM_GAS) from compras_gastos limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][11];
			PreparedStatement statement = conn
					.prepareStatement("select * from compras_gastos limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_COM_GAS");
				datos[cont][1] = rs.getString("COMPROBANTE");
				datos[cont][2] = rs.getString("DESCRIPCION");
				datos[cont][3] = rs.getString("TIPO_COMPROBANTE");
				datos[cont][4] = rs.getString("IVA");
				datos[cont][5] = rs.getString("SUBTOTAL");
				datos[cont][6] = rs.getString("TOTAL_PAGADO");
				datos[cont][7] = rs.getString("DESCRIPCIO_ADICIONAL");
				datos[cont][8] = rs.getString("NUMERO_RETENCION");
				datos[cont][9] = rs.getString("TOTAL_RETENCION");
				datos[cont][10] = rs.getString("FECHA_COMPRA");

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
					.prepareStatement("select count(ID_COM_GAS) from compras_gastos limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_COM_GAS,DESCRIPCION from compras_gastos limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont] = rs.getString("ID_COM_GAS");
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

	public pagoGastoProvedoresClassModeloTabla[] seleccionarDescripciones(
			Connection conn) {
		int totalRows = 0;

		pagoGastoProvedoresClassModeloTabla datos2[] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_COM_GAS) from compras_gastos limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			pagoGastoProvedoresClassModeloTabla datos[] = new pagoGastoProvedoresClassModeloTabla[totalRows];
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " ID_COM_GAS," + " C.TIPO_COMPROBANTE,"
					+ " C.COMPROBANTE," + " C.FECHA_COMPRA,"
					+ " CONCAT(C.DESCRIPCIO_ADICIONAL,'--> "
					+ "			 TOTAL: ',C.TOTAL_PAGADO ), "
					+ " 			 C.DESCRIPCION,C.TOTAL_PAGADO"
					+ "	  FROM compras_gastos c "
					+ "     WHERE C.ESTADO='PENDIENTE'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				pagoGastoProvedoresClassModeloTabla claseTemporal = new pagoGastoProvedoresClassModeloTabla();

				claseTemporal = new pagoGastoProvedoresClassModeloTabla(rs
						.getString(1), rs.getString(2), rs.getString(3), rs
						.getString(4), rs.getString(5), rs.getString(6), true,
						rs.getString(7));

				datos[cont] = claseTemporal;// super descripcion
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

	// SELECT max(id_com_gas) FROM compras_gastos;
	/*
	 * 
	 * retorna un objeto todos los objetos de la tabla para choice
	 * 
	 */

	public String seleccionarMaxAutoIncrementTabla(Connection conn) {
		String totalRows = "0";
		try {
			PreparedStatement statement0 = conn
					.prepareStatement("SELECT max(id_com_gas) FROM compras_gastos");
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

	/*
	 * 
	 * retorna un hashTable con el código en String y el objeto con los datos
	 * 
	 */
	@Deprecated
	/**
	 * metodo viejo para la lista de deudas mejorado por una tabla y reducido el
	 * código 2010-09-27
	 * 
	 * @param conn
	 * @return
	 */
	public Hashtable seleccionarDescripcionesObjetoTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable comprasGastosLista = new Hashtable();
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
				PreparedStatement statement = conn.prepareStatement("SELECT "
						+ "concat('Numero de comprobante : ',C.COMPROBANTE,"
						+ "' Tipo Comprobante : ',C.TIPO_COMPROBANTE,' "
						+ "',C.DESCRIPCION,' realizado el: ',C.FECHA_COMPRA )"
						+ " ,C.ID_COM_GAS,C.TOTAL_PAGADO,C.TOTAL_RETENCION "
						+ " FROM compras_gastos c "
						+ "WHERE C.ESTADO='PENDIENTE'");

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					claseTemporal = new arregloTempHash(rs.getString(1), rs
							.getString(2), rs.getString(3), rs.getString(4), "");
					String clave = rs.getString(1);
					comprasGastosLista.put("" + clave, claseTemporal);// fixed

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

	/*
	 * 
	 * Modifica un registro existente cuando se elimina un pago Actualiza el
	 * campo Estado
	 * 
	 * 
	 */

	public int modificarEstadoCompra(Connection conn, comprasGastos objeto) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("update compras_gastos set"
							+ " ESTADO = 'PENDIENTE'" + "where ID_COM_GAS = ?");
			statement.setInt(1, objeto.getIdCompraGasto());

			statement.execute();
			statement.close();
			JOptionPane.showMessageDialog(null,
					"Estado de compra modificado! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);
			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Modificó Compra! :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// modificar

}// end clase

