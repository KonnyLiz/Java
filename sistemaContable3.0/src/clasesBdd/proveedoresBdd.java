package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.proveedor;

public class proveedoresBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, proveedor objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into proveedor (DESCRIPCION, TELEFONO1, TELEFONO2, PAIS, CIUDAD, CONTACTO, RUC) values ( ?, ?, ?, ?, ?, ?, ?)");

			statement.setString(1, objeto.getDescripcion());
			statement.setString(2, objeto.getTelefono());
			statement.setString(3, objeto.getTelefono2());
			statement.setString(4, objeto.getPais());
			statement.setString(5, objeto.getCiudad());
			statement.setString(6, objeto.getContacto());
			statement.setString(7, objeto.getRuc());
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

	public int modificar(Connection conn, proveedor objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update proveedor set DESCRIPCION = ?, TELEFONO1 = ?, TELEFONO2 = ?, PAIS = ?, CIUDAD = ?, CONTACTO = ?, RUC = ? where ID_PROV = ?");
			statement.setString(1, objeto.getDescripcion());
			statement.setString(2, objeto.getTelefono());
			statement.setString(3, objeto.getTelefono2());
			statement.setString(4, objeto.getPais());
			statement.setString(5, objeto.getCiudad());
			statement.setString(6, objeto.getContacto());
			statement.setString(7, objeto.getRuc());
			statement.setInt(8, objeto.getIdProveedor());
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

	public int eliminar(Connection conn, proveedor objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from proveedor where ID_PROV = ?");
			statement.setInt(1, objeto.getIdProveedor());
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

	public proveedor buscarInfoDeUnRegistro(Connection conn, proveedor objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_PROV, DESCRIPCION,TELEFONO1, TELEFONO2, PAIS, CIUDAD, CONTACTO, RUC"
							+ " 											from proveedor"
							+ "											where DESCRIPCION='"
							+ objeto.getDescripcion() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdProveedor(rs.getInt("ID_PROV"));
				objeto.setDescripcion(rs.getString("DESCRIPCION"));
				objeto.setTelefono(rs.getString("TELEFONO1"));
				objeto.setTelefono2(rs.getString("TELEFONO2"));
				objeto.setPais(rs.getString("PAIS"));
				objeto.setCiudad(rs.getString("CIUDAD"));
				objeto.setContacto(rs.getString("CONTACTO"));
				objeto.setRuc(rs.getString("RUC"));

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
					.prepareStatement("select count(ID_PROV) from proveedor ");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][8];
			PreparedStatement statement = conn
					.prepareStatement("select * from proveedor limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("TELEFONO1");
				datos[cont][2] = rs.getString("TELEFONO2");
				datos[cont][3] = rs.getString("PAIS");
				datos[cont][4] = rs.getString("CIUDAD");
				datos[cont][5] = rs.getString("CONTACTO");
				datos[cont][6] = rs.getString("RUC");
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
					.prepareStatement("select count(ID_PROV) from proveedor limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_PROV,DESCRIPCION from proveedor limit 200");
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
	 * retorna un hashTable todos los objetos de la tabla para choice
	 *
	 */

	public Hashtable<Object, Object> seleccionarDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> proveedorLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_PROV) from proveedor limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_PROV,DESCRIPCION from proveedor limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_PROV");
				proveedorLista.put(datos[cont][0], datos[cont][1]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return proveedorLista;
	}// seleccionar

	/*
	 *
	 * retorna un hashTable todos los objetos de la tabla para choice
	 *
	 */

	public Hashtable<Object, Object> seleccionarIdTablaDescripcionTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> proveedorLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_PROV) from proveedor limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_PROV,DESCRIPCION from proveedor limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_PROV");
				proveedorLista.put(datos[cont][1], datos[cont][0]);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return proveedorLista;
	}// seleccionar


	/******************************************************
	 *  Sección de busquedas para proveedores
	 *******************************************************/


/**
 * seleccionarProveedoresBuscados
 * @param conn
 * @param busqueda
 * @return Object[][]
 */
	/*
	 *
	 * retorna proveedores todos los objetos de la tabla buscados por ruc
	 */

	public Object[][] seleccionarProveedoresBuscadosRUC(Connection conn,
			String busqueda) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT " +
					" DESCRIPCION,CONTACTO, RUC  " +
					" FROM proveedor P " +
					" where  RUC like '%"+busqueda+"%' order by DESCRIPCION");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][3];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);


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
	 * proveedores de la tabla
	 * por descripción
	 */

	public Object[][] seleccionarProveedoresBuscadosDescripcion(Connection conn,
			String busqueda) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT " +
					" DESCRIPCION,CONTACTO, RUC  " +
					" FROM proveedor P " +
					" where  DESCRIPCION like '%"+busqueda+"%' order by DESCRIPCION");


			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][3];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);


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

