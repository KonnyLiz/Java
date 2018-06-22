package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.arregloTempHash2Items;
import clases.comprasGastos;
import clases.cuentasBancos;

public class cuentasBancosBdd {
	/*
	 * insertar registro en tabla cuentasBancos
	 */
	public int insertar(Connection conn, cuentasBancos objeto) {
		try {
			PreparedStatement statement = conn
					.prepareStatement("insert into cuentas_banco (ID_CUENTA_TABLA, ID_BANCO, NUMERO_CUENTA, TIPO, PROPIETARIO_CUENTA) values (?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdCuentaTabla());
			statement.setInt(2, objeto.getIdBanco());
			statement.setString(3, objeto.getNumeroCuenta());
			statement.setString(4, objeto.getTipoCuenta());
			statement.setString(5, objeto.getPropietarioCuenta());
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

	public int modificar(Connection conn, cuentasBancos objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update cuentas_banco set ID_BANCO = ?, NUMERO_CUENTA = ?, TIPO = ?, PROPIETARIO_CUENTA = ? where ID_CUENTA_TABLA = ?");
			statement.setInt(1, objeto.getIdBanco());
			statement.setString(2, objeto.getNumeroCuenta());
			statement.setString(3, objeto.getNumeroCuenta());
			statement.setString(4, objeto.getPropietarioCuenta());
			statement.setInt(5, objeto.getIdCuentaTabla());
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

	public int eliminar(Connection conn, cuentasBancos objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from cuentas_banco where ID_CUENTA_TABLA = ?");
			statement.setInt(1, objeto.getIdCuentaTabla());
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

	public cuentasBancos buscarInfoDeUnRegistro(Connection conn,
			cuentasBancos objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_CUENTA_TABLA, ID_BANCO,TIPO, PROPIETARIO_CUENTA from cuentas_banco where NUMERO_CUENTA='"
							+ objeto.getNumeroCuenta() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				// ID_BANCO DESCRIPCION_BANCO TELEFONO_BANCO CIUDAD_BANCO
				objeto.setIdCuentaTabla(rs.getInt("ID_CUENTA_TABLA"));
				objeto.setIdBanco(rs.getInt("ID_BANCO"));
				objeto.setTipoCuenta(rs.getString("TIPO"));
				objeto.setPropietarioCuenta(rs.getString("PROPIETARIO_CUENTA"));
				// Process data here

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return objeto;

	}// end cuentas bancos

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
					.prepareStatement("select count(ID_BANCO) from cuentas_banco limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][5];
			PreparedStatement statement = conn
					.prepareStatement("select * from cuentas_banco limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_CUENTA_TABLA");
				datos[cont][1] = rs.getString("ID_BANCO");
				datos[cont][2] = rs.getString("TIPO");
				datos[cont][3] = rs.getString("PROPIETARIO_CUENTA");
				datos[cont][4] = rs.getString("NUMERO_CUENTA");
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
					.prepareStatement("select count(ID_CUENTA_TABLA) from cuentas_banco limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_CUENTA_TABLA,NUMERO_CUENTA from cuentas_banco limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont] = rs.getString("NUMERO_CUENTA");
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
		Hashtable<Object, Object> cuentasBancosLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_CUENTA_TABLA) from cuentas_banco limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_CUENTA_TABLA,NUMERO_CUENTA from cuentas_banco limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("ID_CUENTA_TABLA");
				datos[cont][1] = rs.getString("NUMERO_CUENTA");
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

	/*
	 * 
	 * retorna un hashTable con el código en String y el objeto con los datos
	 * 
	 */

	public Hashtable seleccionarCuentasIdNumCuentaHash(Connection conn) {
		int totalRows = 0;
		Hashtable tiposPagoLista = new Hashtable();
		arregloTempHash2Items claseTemporal = new arregloTempHash2Items("", "");

		try {
			comprasGastos comprasGastosDp;
			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_CUENTA_TABLA) from cuentas_banco limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			if (totalRows == 0) {
				tiposPagoLista.put("Sin Registros", claseTemporal);
			} else {

				PreparedStatement statement = conn
						.prepareStatement("SELECT NUMERO_CUENTA,ID_CUENTA_TABLA FROM cuentas_banco");

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					claseTemporal = new arregloTempHash2Items(rs.getString(1),
							rs.getString(2));
					int clave = rs.getInt(2);
					tiposPagoLista.put(clave, claseTemporal);// fixed

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

	public Hashtable seleccionarCuentasNumCuentaIdHash(Connection conn) {
		int totalRows = 0;
		Hashtable tiposPagoLista = new Hashtable();

		try {
			comprasGastos comprasGastosDp;
			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_CUENTA_TABLA) from cuentas_banco limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			if (totalRows == 0) {
				tiposPagoLista.put("Sin Registros", 0);
			} else {

				PreparedStatement statement = conn
						.prepareStatement("SELECT NUMERO_CUENTA,ID_CUENTA_TABLA FROM cuentas_banco");

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {

					String clave = rs.getString(1);
					tiposPagoLista.put(clave, rs.getInt(2));// fixed

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

}// end clase

