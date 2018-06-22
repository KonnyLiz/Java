package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.arregloTempTipoTrabajo;
import clases.comprasGastos;
import clases.tipoTrabajo;

public class tipoTrabajoBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, tipoTrabajo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into tipo_trabajo (ID, DESCRIPCION, PRECIO, PRECIO_MIN) values (?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdTp());
			statement.setString(2, objeto.getDescripcion());
			statement.setFloat(3, objeto.getPrecio1());
			statement.setFloat(4, objeto.getPrecio2());
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

	public int modificar(Connection conn, tipoTrabajo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update tipo_trabajo set DESCRIPCION = ?, PRECIO = ?, PRECIO_MIN = ? where ID = ?");
			statement.setString(1, objeto.getDescripcion());
			statement.setFloat(2, objeto.getPrecio1());
			statement.setFloat(3, objeto.getPrecio2());
			statement.setInt(4, objeto.getIdTp());
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

	public int eliminar(Connection conn, tipoTrabajo objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from tipo_trabajo where ID = ?");
			statement.setInt(1, objeto.getIdTp());
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

	public tipoTrabajo buscarInfoDeUnRegistro(Connection conn,
			tipoTrabajo objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID, DESCRIPCION, PRECIO, PRECIO_MIN from tipo_trabajo where DESCRIPCION='"
							+ objeto.getDescripcion() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdTp(rs.getInt("ID"));
				objeto.setDescripcion(rs.getString("DESCRIPCION"));
				objeto.setPrecio1(rs.getFloat("PRECIO"));
				objeto.setPrecio2(rs.getFloat("PRECIO_MIN"));

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
					.prepareStatement("select count(ID) from tipo_trabajo limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][6];
			PreparedStatement statement = conn
					.prepareStatement("select * from tipo_trabajo limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("ID");
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
					.prepareStatement("select count(ID) from tipo_trabajo limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID,DESCRIPCION from tipo_trabajo limit 200");
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
	 * retorna un hashTable con el código en Integer y el objeto con los datos
	 *
	 */

	public Hashtable seleccionarTablaHash(Connection conn, String Opcion) {
		int totalRows = 0;
		Hashtable tipoTrabajoHash = new Hashtable();

		try {
			comprasGastos comprasGastosDp;
			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID) from tipo_trabajo");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			if (totalRows == 0) {
				tipoTrabajoHash.put("Sin Registros", 0);
			} else {

				PreparedStatement statement = conn.prepareStatement("SELECT "
						+ "ID, DESCRIPCION, PRECIO, PRECIO_MIN FROM "
						+ "tipo_trabajo");

				ResultSet rs = statement.executeQuery();

				while (rs.next()) {
					if (Opcion.compareTo("codigos") == 0) {
						String clave = rs.getString(1);
						tipoTrabajoHash.put(clave, new arregloTempTipoTrabajo(
								rs.getInt(1), rs.getString(2), rs.getFloat(3),
								rs.getFloat(4)));// fixed
					} else {
						String clave = rs.getString(2);
						tipoTrabajoHash.put(clave, new arregloTempTipoTrabajo(
								rs.getInt(1), rs.getString(2), rs.getFloat(3),
								rs.getFloat(4)));// fixed
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

}// end clase

