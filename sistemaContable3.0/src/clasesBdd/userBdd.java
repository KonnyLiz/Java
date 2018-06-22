package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.comprasGastos;
import clases.user;

public class userBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, user objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into user (ID_USER, ID_ROL, NOMBRE_COMPLETO, USERN, CONTRASENA) values (?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdUser());
			statement.setInt(2, objeto.getIdRol());
			statement.setString(3, objeto.getNombreCompleto());
			statement.setString(4, objeto.getUserName());
			statement.setString(5, objeto.getContrasena());
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
	 * Modifica un registro existente tipo cliente
	 *
	 *
	 */

	public int modificar(Connection conn, user objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update user set ID_ROL = ?, NOMBRE_COMPLETO = ?, USERN = ?, CONTRASENA = ? where ID_USER = ?");
			statement.setInt(1, objeto.getIdRol());
			statement.setString(2, objeto.getNombreCompleto());
			statement.setString(3, objeto.getUserName());
			statement.setString(4, objeto.getContrasena());
			statement.setInt(5, objeto.getIdUser());
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

	public int eliminar(Connection conn, user objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from user where ID_USER = ?");
			statement.setInt(1, objeto.getIdUser());
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

	public user buscarInfoDeUnRegistro(Connection conn, user objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_USER, ID_ROL, NOMBRE_COMPLETO, USERN, CONTRASENA from user where USERN='"
							+ objeto.getUserName() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdUser(rs.getInt("ID_USER"));
				objeto.setIdRol(rs.getInt("ID_ROL"));
				objeto.setNombreCompleto(rs.getString("NOMBRE_COMPLETO"));
				objeto.setUserName(rs.getString("USERN"));
				objeto.setContrasena(rs.getString("CONTRASENA"));

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
					.prepareStatement("select count(ID_USER) from user limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][6];
			PreparedStatement statement = conn
					.prepareStatement("select ID_USER, ID_ROL, NOMBRE_COMPLETO, USERN, CONTRASENA from user limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_USER");
				datos[cont][1] = rs.getString("ID_ROL");
				datos[cont][2] = rs.getString("ID_USER");
				datos[cont][3] = rs.getString("NOMBRE_COMPLETO");
				datos[cont][4] = rs.getString("USERN");
				datos[cont][5] = rs.getString("CONTRASENA");
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
		Hashtable<Object, Object> userLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_USER) from user limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_USER,USERN from user limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("USERN");
				datos[cont][1] = rs.getString("ID_USER");
				userLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return userLista;
	}// seleccionar

	/*
	 *
	 * retorna un hashTable Descripcion y rol de user para choice
	 *
	 */

	public Hashtable<Object, Object> seleccionarDatosDescripcionIdRolTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> userLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_ROL) from rol limit 100");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select DESCRIPCION,"
							+ "													ID_ROL " + "											 from rol ");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID_ROL");
				datos[cont][1] = rs.getString("DESCRIPCION");

				userLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return userLista;
	}// seleccionar

	/*
	 *
	 * retorna un hashTable IdRol y UserName para una tabla hash *
	 */

	public Hashtable<Object, Object> seleccionarDatosIDRolUserUnameConTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> userLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(USERN) from user limit 100");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn.prepareStatement("select USERN,"
					+ "													CONTRASENA " + "											 from user ");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("USERN");
				datos[cont][1] = rs.getString("CONTRASENA");

				userLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return userLista;
	}// seleccionar

	/*
	 *
	 * retorna un hashTable todos los username,contraseña,rol para choice
	 *
	 */

	public Hashtable<Object, Object> seleccionarUserNameIdRolTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> userLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_ROL) from user limit 100");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select  USERN," + "													ID_ROL "
							+ "											 from user ");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("USERN");
				datos[cont][1] = rs.getString("ID_ROL");

				userLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return userLista;
	}// seleccionar

	/*
	 *
	 * retorna un hashTable con el código en Integer y el objeto con los datos
	 * empleados
	 *
	 */

	public Hashtable seleccionarUserNameIdTablaHash(Connection conn,
			String Opcion) {
		int totalRows = 0;
		Hashtable tipoTrabajoHash = new Hashtable();

		try {
			comprasGastos comprasGastosDp;
			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_USER) from user");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			if (totalRows == 0) {
				tipoTrabajoHash.put("Sin Registros", 0);
			} else {

				PreparedStatement statement = conn.prepareStatement("SELECT "
						+ "ID_USER,USERN " + "FROM user");

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					if (Opcion.compareTo("codigos") == 0) {
						String clave = rs.getString(1);
						tipoTrabajoHash.put(clave, rs.getString(2));// fixed
					} else {
						String clave = rs.getString(2);
						tipoTrabajoHash.put(clave, rs.getInt(1));// fixed
					}

					cont++;

				}
				rs.close();

				statement.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return tipoTrabajoHash;
	}// seleccionar

}
