package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import clases.alertas;

public class alertasBdd {

	/*
	 * insertar registro en tabla alertas
	 */
	public int insertar(Connection conn, alertas objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into alertas ( DESCRIPCION, FECHA_INI, FECHA_FIN, ESTADO, DESCRIPCION2) values ( ?, ?, ?, ?, ?)");

			statement.setString(1, objeto.getDescripcion());
			statement.setString(2, objeto.getFechaInicio().toString());
			statement.setString(3, objeto.getFechaDinalizacion().toString());
			statement.setString(4, objeto.getEstado());
			statement.setString(5, objeto.getDescripcion2());
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

	public int modificar(Connection conn, alertas objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update alertas set DESCRIPCION = ?, FECHA_INI = ?, FECHA_FIN = ?, ESTADO = ?, DESCRIPCION2 = ? where ID_ALERTA = ?");
			statement.setString(1, objeto.getDescripcion());
			statement.setString(2, objeto.getFechaInicio());
			statement.setString(3, objeto.getFechaDinalizacion());
			statement.setString(4, objeto.getEstado());
			statement.setString(5, objeto.getDescripcion2());
			statement.setInt(6, objeto.getAlerta());
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

	public int eliminar(Connection conn, alertas objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from alertas where ID_ALERTA = ?");
			statement.setInt(1, objeto.getAlerta());
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

	public alertas buscarInfoDeUnRegistro(Connection conn, alertas objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_ALERTA, FECHA_INI, FECHA_FIN, ESTADO, DESCRIPCION2 from alertas where DESCRIPCION='"
							+ objeto.getDescripcion() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setAlerta(rs.getInt("ID_ALERTA"));
				objeto.setFechaInicio(rs.getString("FECHA_INI"));
				objeto.setFechaDinalizacion(rs.getString("FECHA_FIN"));
				objeto.setEstado(rs.getString("ESTADO"));
				objeto.setDescripcion2(rs.getString("DESCRIPCION2"));
				// Process data here

			}
			rs.close();
			statement.close();

		} catch (Exception e) {
			// JOptionPane.showMessageDialog(null, "Alerta!",
			// ":"+e.getMessage(), JOptionPane.ERROR_MESSAGE);
			objeto.setDescripcion("null");

		}
		return objeto;

	}

	/*
	 * 
	 * retorna un objeto de datos seleccionados en el mes actual
	 * 
	 * 
	 */

	public Object[][] seleccionarEventosMes(Connection conn) {
		int totalRows = 0;

		Object datos2[][] = null;
		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_ALERTA, DESCRIPCION, FECHA_INI, FECHA_FIN, ESTADO, DESCRIPCION2 from alertas  where  month(FECHA_INI)  = (select month(curdate())) and estado!= 'Desactivado'");
			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			rs.beforeFirst();
			int cont = 0;
			Object datos[][] = new Object[totalRows][6];

			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_ALERTA");
				datos[cont][1] = rs.getString("DESCRIPCION");
				datos[cont][2] = rs.getDate("FECHA_INI");
				datos[cont][3] = rs.getDate("FECHA_FIN");
				datos[cont][4] = rs.getString("ESTADO");
				datos[cont][5] = rs.getString("DESCRIPCION2");
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			// jTextArea.append("\n:problema : "+e.getMessage());

			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return datos2;

	}// seleccionar los del mes

	/*
	 * 
	 * retorna un objeto todos los objetos de la tabla
	 * 
	 */

	public Object[][] seleccionarEventosTodos(Connection conn) {
		int totalRows = 0;

		Object datos2[][] = null;
		try {

			int cont = 0;

			PreparedStatement statement = conn
					.prepareStatement("select ID_ALERTA, DESCRIPCION, FECHA_INI, FECHA_FIN, ESTADO, DESCRIPCION2 from alertas limit 200");
			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			rs.beforeFirst();
			Object datos[][] = new Object[totalRows][6];

			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_ALERTA");
				datos[cont][1] = rs.getString("DESCRIPCION");
				datos[cont][2] = rs.getDate("FECHA_INI");
				datos[cont][3] = rs.getDate("FECHA_FIN");
				datos[cont][4] = rs.getString("ESTADO");
				datos[cont][5] = rs.getString("DESCRIPCION2");
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

	/**
	 * Devuelve la cantidad de alertas del sistema con un rango de 8 dias de
	 * caducidad
	 * 
	 * @param conn
	 * @return int
	 */
	public int ultimasAlertasDelSistema(Connection conn) {
		int cantidad = 0;
		try {

			PreparedStatement statement = conn
					.prepareStatement("select"
							+ " count(ID_ALERTA)"
							+ " from alertas "
							+ " where fecha_fin "
							+ " BETWEEN  DATE_SUB(CURRENT_DATE(), INTERVAL 8 DAY) AND  CURRENT_DATE+3 "
							+ " and ESTADO != 'Desactivado'");

			ResultSet rs = statement.executeQuery();

			cantidad = 0;
			for (int i = 0; i < 1; i++) {
				rs.next();
				cantidad = Integer.parseInt("" + rs.getString(1));
			}

			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}

		return cantidad;
	}// seleccionar

}