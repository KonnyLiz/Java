package clasesBdd;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.comprasGastos;
import clases.empleado;

public class empleadoBdd {
	/*
	 * insertar registro en tabla alertas
	 */
	public int insertar(Connection conn, empleado objeto) {
		try {

			File fichero = new File("bin/buffer.jpg");
			FileInputStream streamEntrada = new FileInputStream(fichero);

			PreparedStatement statement = conn
					.prepareStatement("insert into empleado (ID_EMP, ID_ROL, CI_RUC, FECHA_NACIMIENTO, NOMBRE, APELLIDO, FECHA_INGRESO, ESTADO, CARGO, SALARIO, DIRECCION, TELEFONO, SEXO, FOTO_DATA) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdEMp());
			statement.setInt(2, objeto.getIdRol());
			statement.setString(3, objeto.getRuc());
			statement.setString(4, objeto.getFechaNacimiento().toString());
			statement.setString(5, objeto.getNombre());
			statement.setString(6, objeto.getApellido());
			statement.setString(7, objeto.getFechaIngreso().toString());
			statement.setString(8, objeto.getEstado());
			statement.setString(9, objeto.getCargo());
			statement.setFloat(10, objeto.getSalario());
			statement.setString(11, objeto.getDireccion());
			statement.setString(12, objeto.getTelefono());
			statement.setString(13, objeto.getSexo());
			statement
					.setBinaryStream(14, streamEntrada, (int) fichero.length());
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

	public int modificar(Connection conn, empleado objeto) {
		try {

			File fichero = new File("bin/buffer.jpg");
			FileInputStream streamEntrada = new FileInputStream(fichero);
			PreparedStatement statement = conn
					.prepareStatement("update empleado set ID_ROL = ?, CI_RUC = ?, FECHA_NACIMIENTO = ?, NOMBRE = ?, APELLIDO = ?, FECHA_INGRESO = ?, ESTADO = ?, CARGO = ?, SALARIO = ?, DIRECCION = ?, TELEFONO = ?, SEXO = ?, FOTO_DATA = ? where ID_EMP = ?");
			statement.setInt(1, objeto.getIdRol());
			statement.setString(2, objeto.getRuc());
			statement.setString(3, objeto.getFechaNacimiento().toString());
			statement.setString(4, objeto.getNombre());
			statement.setString(5, objeto.getApellido());
			statement.setString(6, objeto.getFechaIngreso().toString());
			statement.setString(7, objeto.getEstado());
			statement.setString(8, objeto.getCargo());
			statement.setFloat(9, objeto.getSalario());
			statement.setString(10, objeto.getDireccion());
			statement.setString(11, objeto.getTelefono());
			statement.setString(12, objeto.getSexo());
			statement
					.setBinaryStream(13, streamEntrada, (int) fichero.length());
			statement.setInt(14, objeto.getIdEMp());
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

	public int eliminar(Connection conn, empleado objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from empleado where CI_RUC = ?");
			statement.setString(1, objeto.getRuc());
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

	public empleado buscarInfoDeUnRegistro(Connection conn, empleado objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_EMP, ID_ROL, CI_RUC, FECHA_NACIMIENTO, NOMBRE, APELLIDO, FECHA_INGRESO, ESTADO, CARGO, SALARIO, DIRECCION, TELEFONO, SEXO, FOTO_DATA from empleado where CI_RUC = '"
							+ objeto.getRuc() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdEMp(rs.getInt("ID_EMP"));
				objeto.setIdRol(rs.getInt("ID_ROL"));
				objeto.setRuc(rs.getString("CI_RUC"));
				objeto.setFechaNacimiento(rs.getString("FECHA_NACIMIENTO"));
				objeto.setNombre(rs.getString("NOMBRE"));
				objeto.setApellido(rs.getString("APELLIDO"));
				objeto.setFechaIngreso(rs.getString("FECHA_INGRESO"));
				objeto.setEstado(rs.getString("ESTADO"));
				objeto.setCargo(rs.getString("CARGO"));
				objeto.setSalario(rs.getFloat("SALARIO"));
				objeto.setDireccion(rs.getString("DIRECCION"));
				objeto.setTelefono(rs.getString("TELEFONO"));
				objeto.setSexo(rs.getString("SEXO"));
				// objeto.setFoto(rs.getBinaryStream(13));
				Blob campoImagen = rs.getBlob("FOTO_DATA");
				crearImagenDeDatoDeLaBDD(campoImagen);
			}
			rs.close();
			statement.close();

			// Process data here

		} catch (Exception e) {

			objeto.setDireccion("no existe");

		}
		return objeto;

	}

	/*
	 * close //de una imagen de la base de datos crea un archivo
	 */
	public void crearImagenDeDatoDeLaBDD(Blob blobImagen) {
		try {
			File fichero = new File("/buffer.jpg");
			BufferedInputStream in = new BufferedInputStream(blobImagen
					.getBinaryStream());
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(fichero));
			byte[] bytes = new byte[8096];
			int len = 0;

			while ((len = in.read(bytes)) > 0) {
				out.write(bytes, 0, len);
			}

			out.flush();
			out.close();
			in.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error al crear Archivo de Imagen", "Alerta!",
					JOptionPane.ERROR_MESSAGE);
		}

	}// crearImagenDeDatoDeLaBDD

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
					.prepareStatement("select count(CI_RUC) from empleado limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][10];
			PreparedStatement statement = conn
					.prepareStatement("select  CI_RUC,NOMBRE,FECHA_NACIMIENTO,"
							+ "FECHA_INGRESO,r.DESCRIPCION,"
							+ " CARGO, ESTADO,DIRECCION," + " TELEFONO, SEXO "
							+ "from empleado e,rol r"
							+ " where e.ID_ROL=r.ID_ROL");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("CI_RUC");
				datos[cont][1] = rs.getString("NOMBRE");
				datos[cont][2] = rs.getString("FECHA_NACIMIENTO");
				datos[cont][3] = rs.getString("FECHA_INGRESO");
				datos[cont][4] = rs.getString("DESCRIPCION");
				datos[cont][5] = rs.getString("CARGO");
				datos[cont][6] = rs.getString("ESTADO");
				datos[cont][7] = rs.getString("DIRECCION");
				datos[cont][8] = rs.getString("TELEFONO");
				datos[cont][9] = rs.getString("SEXO");
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
	 * *close //carga la imagen bajada de la base de datos a un archivo llamado
	 * buffer.jpg en el disco duro
	 */
	public void cargarImgFromBdd(Connection con, empleado objeto) {
		try {
			String consultaGenerada = "SELECT FOTO_DATA FROM empleado  where CI_RUC='"
					+ objeto.getRuc() + "'";
			java.sql.Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery(consultaGenerada);
			results.next();
			Blob campo = results.getBlob("FOTO_DATA");
			File fichero = new File("/buffer.jpg");
			BufferedInputStream in = new BufferedInputStream(campo
					.getBinaryStream());
			BufferedOutputStream out = new BufferedOutputStream(
					new FileOutputStream(fichero));
			byte[] bytes = new byte[8096];
			int len = 0;

			while ((len = in.read(bytes)) > 0) {
				out.write(bytes, 0, len);
			}

			out.flush();
			out.close();
			in.close();

			// jLabel1=jLabel1 = new JLabel("Image and Text", icono,
			// JLabel.CENTER);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Error al Cargar imagen desde la Base de Datos!",
					"Alerta!", JOptionPane.ERROR_MESSAGE);

		}

	}

	/*
	 *
	 * retorna un hashTable con el código en Integer y el objeto con los datos
	 * empleados
	 *
	 */

	public Hashtable seleccionarTablaHash(Connection conn, String Opcion) {
		int totalRows = 0;
		Hashtable tipoTrabajoHash = new Hashtable();

		try {
			comprasGastos comprasGastosDp;
			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_EMP) from empleado");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			if (totalRows == 0) {
				tipoTrabajoHash.put("Sin Registros", 0);
			} else {

				PreparedStatement statement = conn.prepareStatement("SELECT "
						+ "ID_EMP, NOMBRE" + " FROM empleado where estado like 'Activo'");

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



	/***************************************************************************
	 *
	 * Buscar nombre de empleado por id
	 *
	 *
	 **************************************************************************/

	public empleado buscarNombreEmpRegistro(Connection conn, empleado objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select  NOMBRE from empleado " +
							"where ID_EMP = '"
							+ objeto.getIdEMp() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				objeto.setNombre(rs.getString("NOMBRE"));

			}
			rs.close();
			statement.close();

			// Process data here

		} catch (Exception e) {

			objeto.setDireccion("no existe");

		}
		return objeto;

	}




}
