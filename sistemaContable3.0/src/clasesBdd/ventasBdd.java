package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ventasBdd {

	/**
	 * ventas totales
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public Float ventasTotalODT(Connection conn, String fecha1, String fecha2) {
		Float respuesta = new Float(0);
		try {

			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " truncate(sum(PRECIO),2)" + " FROM order_trabajo"
					+ " where " + " FECHA between '" + fecha1 + "' and '"
					+ fecha2 + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respuesta = rs.getFloat(1);

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return respuesta;

	}// ventasTotalODT

	/**
	 * Saldo por cobrar en ODT
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public Float ventasSaldoPorCobrarODT(Connection conn, String fecha1,
			String fecha2) {
		Float respuesta = new Float(0);
		try {

			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " truncate(sum(SALDO),2)" + " FROM order_trabajo"
					+ " where " + " FECHA between '" + fecha1 + "' and '"
					+ fecha2 + "' and estado like 'PENDIENTE' ");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respuesta = rs.getFloat(1);

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return respuesta;

	}// ventasSaldoPorCobrarODT

	/**
	 * Ventas A Plazo
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */

	public Float VentasAPlazo(Connection conn, String fecha1, String fecha2) {
		Float respuesta = new Float(0);
		try {

			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " truncate(sum(CANTIDAD),2) " +
							" FROM tipo_pago_recibo " +
							" where ESTADO like 'Pendiente' AND " +
							"  PLAZO between '" + fecha1 + "'" + "  and '"
					           + fecha2 + "'" );
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respuesta = rs.getFloat(1);
			}

			rs.close();
			statement.close();

		} catch (Exception e) {
			respuesta = new Float(0);
		}
		return respuesta;

	}// VentasAPlazo

	/**
	 * Total de pagos realizados en el plazo indicado
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public Float pagosAPlazo(Connection conn, String fecha1, String fecha2) {
		Float respuesta = new Float(0);
		try {

			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " truncate(sum(TOTAL),2)" + " FROM pagos_por_gasto "
					+ " where PLAZO_PAGO" + " between '" + fecha1 + "' "
					+ " and '" + fecha2 + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respuesta = rs.getFloat(1);

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return respuesta;

	}//

	/**
	 * VENTAS EN FACTURAS
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */
	public Float ventasFacturas(Connection conn, String fecha1, String fecha2) {
		Float respuesta = new Float(0);
		try {

			PreparedStatement statement = conn.prepareStatement("SELECT " +
					" truncate(sum(TOTAL),2)" +
					" FROM recibo_venta" +
					" where FECHA  between'" + fecha1 + "' and '"
					+ fecha2 + "'  AND ID_TR=2");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respuesta = rs.getFloat(1);

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return respuesta;

	}//

	/**
	 * Iva Cobrado
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */

	public Float ivaCobrado(Connection conn, String fecha1, String fecha2) {
		Float respuesta = new Float(0);
		try {

			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " truncate(sum(IVA),2)" + " FROM recibo_venta"
					+ " where " + " FECHA between'" + fecha1 + "' and '"
					+ fecha2 + "' AND ID_TR=2 ");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respuesta = rs.getFloat(1);

			}
			rs.close();
			statement.close();

		} catch (Exception e) {
			respuesta = new Float(0);
		}
		return respuesta;

	}//

	/**
	 * Gastos Totales
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */

	public Float GastosTotales(Connection conn, String fecha1, String fecha2) {
		Float respuesta = new Float(0);
		try {

			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ " truncate(sum(TOTAL),2)" + " FROM pagos_por_gasto"
					+ " where " + " PLAZO_PAGO between'" + fecha1 + "' "
					+ "	  and '" + fecha2 + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respuesta = rs.getFloat(1);

			}
			rs.close();
			statement.close();

		} catch (Exception e) {
			respuesta = new Float(0);
		}
		return respuesta;

	}//

	/**
	 * iva Pagado por compras
	 *
	 * @param conn
	 * @param fecha1
	 * @param fecha2
	 * @return
	 */

	public Float ivaPagado(Connection conn, String fecha1, String fecha2) {
		Float respuesta = new Float(0);
		try {

			PreparedStatement statement = conn.prepareStatement("SELECT  " +
					" truncate(sum(c.IVA),2)" +
					" FROM compras_gastos C" +
					" WHERE FECHA_COMPRA BETWEEN '"+fecha1+"' and '"+fecha2+"'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				respuesta = rs.getFloat(1);

			}
			rs.close();
			statement.close();

		} catch (Exception e) {
			respuesta = new Float(0);
		}
		return respuesta;

	}//

}
