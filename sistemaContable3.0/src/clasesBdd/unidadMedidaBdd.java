package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.unidadMedida;

;

public class unidadMedidaBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, unidadMedida objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into unidad_medida (ID_UNIDAD_MEDIDA, DESCRIPCION, NOMENCLATURA) values (?, ?, ?)");
			statement.setInt(1, objeto.getIdUnidadMedida());
			statement.setString(2, objeto.getDescripcion());
			statement.setString(3, objeto.getNomenclatura());
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

	public int modificar(Connection conn, unidadMedida objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update unidad_medida set DESCRIPCION = ?, NOMENCLATURA = ? where ID_UNIDAD_MEDIDA = ?");
			statement.setString(1, objeto.getDescripcion());
			statement.setString(2, objeto.getNomenclatura());
			statement.setInt(3, objeto.getIdUnidadMedida());
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

	public int eliminar(Connection conn, unidadMedida objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from unidad_medida where ID_UNIDAD_MEDIDA = ?");
			statement.setInt(1, objeto.getIdUnidadMedida());
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

	public unidadMedida buscarInfoDeUnRegistro(Connection conn,
			unidadMedida objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_UNIDAD_MEDIDA, DESCRIPCION, NOMENCLATURA from unidad_medida where DESCRIPCION='"
							+ objeto.getDescripcion() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdUnidadMedida(rs.getInt("ID_UNIDAD_MEDIDA"));
				objeto.setDescripcion(rs.getString("DESCRIPCION"));
				objeto.setNomenclatura(rs.getString("NOMENCLATURA"));

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
					.prepareStatement("select count(ID_UNIDAD_MEDIDA) from unidad_medida limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][3];
			PreparedStatement statement = conn
					.prepareStatement("select ID_UNIDAD_MEDIDA, DESCRIPCION, NOMENCLATURA from unidad_medida limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("ID_UNIDAD_MEDIDA");
				datos[cont][1] = rs.getString("DESCRIPCION");
				datos[cont][2] = rs.getString("NOMENCLATURA");
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
					.prepareStatement("select count(ID_UNIDAD_MEDIDA) from unidad_medida limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_UNIDAD_MEDIDA,DESCRIPCION from unidad_medida limit 200");
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
					.prepareStatement("select count(ID_UNIDAD_MEDIDA) from unidad_medida limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_UNIDAD_MEDIDA,DESCRIPCION from unidad_medida limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_UNIDAD_MEDIDA");
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
	 * retorna un hashTable todos los objetos de la tabla en id- descripcion
	 *
	 */

	public Hashtable<Object, Object> seleccionarIdTablaDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> proveedorLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_UNIDAD_MEDIDA) from unidad_medida limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_UNIDAD_MEDIDA,DESCRIPCION from unidad_medida limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_UNIDAD_MEDIDA");
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

}// end clase

