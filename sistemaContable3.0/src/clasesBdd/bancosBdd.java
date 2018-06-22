package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.bancos;

public class bancosBdd {
	/*
	 * insertar registro en tabla Bancos
	 */
	public int insertar(Connection conn, bancos objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into bancos (ID_BANCO, DESCRIPCION_BANCO, TELEFONO_BANCO, CIUDAD_BANCO) values (?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdBanco());
			statement.setString(2, objeto.getDescripcionBanco());
			statement.setString(3, objeto.getTelefonoBanco());
			statement.setString(4, objeto.getCiudadBanco());
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
	 * Modifica un registro existente tipo banco
	 * 
	 * 
	 */

	public int modificar(Connection conn, bancos objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update bancos set DESCRIPCION_BANCO = ?, TELEFONO_BANCO = ?, CIUDAD_BANCO = ? where ID_BANCO = ?");
			statement.setString(1, objeto.getDescripcionBanco());
			statement.setString(2, objeto.getTelefonoBanco());
			statement.setString(3, objeto.getCiudadBanco());
			statement.setInt(4, objeto.getIdBanco());
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
	 * Eliminar un registro existente banco
	 * 
	 * 
	 */

	public int eliminar(Connection conn, bancos objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from bancos where ID_BANCO = ?");
			statement.setInt(1, objeto.getIdBanco());
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

	public bancos buscarInfoDeUnRegistro(Connection conn, bancos objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_BANCO, DESCRIPCION_BANCO, TELEFONO_BANCO, CIUDAD_BANCO from bancos where DESCRIPCION_BANCO='"
							+ objeto.getDescripcionBanco() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				// ID_BANCO DESCRIPCION_BANCO TELEFONO_BANCO CIUDAD_BANCO
				objeto.setIdBanco(rs.getInt("ID_BANCO"));
				objeto.setDescripcionBanco(rs.getString("DESCRIPCION_BANCO"));
				objeto.setTelefonoBanco(rs.getString("TELEFONO_BANCO"));
				objeto.setCiudadBanco(rs.getString("CIUDAD_BANCO"));
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
					.prepareStatement("select count(ID_BANCO) from bancos limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][6];
			PreparedStatement statement = conn
					.prepareStatement("select ID_BANCO, DESCRIPCION_BANCO from bancos limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("ID_BANCO");
				datos[cont][1] = rs.getString("DESCRIPCION_BANCO");
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
					.prepareStatement("select count(ID_BANCO) from bancos limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_BANCO,DESCRIPCION_BANCO from bancos limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont] = rs.getString("DESCRIPCION_BANCO");
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

	public Hashtable<Object, bancos> seleccionarDescripcionesPorElCodigoTablaHash(
			Connection conn) {
		int totalRows = 0;
		Hashtable<Object, bancos> cuentasBancosLista = new Hashtable<Object, bancos>();
		Object datos2[][] = null;

		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_BANCO) from bancos limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_BANCO,DESCRIPCION_BANCO from bancos limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getInt("ID_BANCO");
				datos[cont][1] = rs.getString("DESCRIPCION_BANCO");
				bancos bancoDp = new bancos(0, "", "", "");
				bancoDp.setDescripcionBanco("" + datos[cont][1]);
				bancoDp.setIdBanco(Integer.parseInt("" + datos[cont][0]));
				cuentasBancosLista.put(datos[cont][0], bancoDp);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return cuentasBancosLista;
	}// seleccionar

	/*
	 * 
	 * retorna un hashTable todos los objetos de la tabla para choice
	 * 
	 */

	public Hashtable<Object, Object> seleccionarCodigosPorElStringTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> cuentasBancosLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_BANCO) from bancos limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_BANCO,DESCRIPCION_BANCO from bancos limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION_BANCO");
				datos[cont][1] = rs.getString("ID_BANCO");
				cuentasBancosLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return cuentasBancosLista;
	}// seleccionar

}// end clase

