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

import clases.pagoRealizado;

public class pagoRealizadoBdd {
	/*
	 * insertar registro en tabla alertas
	 */
	public int insertar(Connection conn, pagoRealizado objeto) {
		try {

			File fichero = new File("bin/imagesBuff/bufferBank.jpg");
			FileInputStream streamEntrada = new FileInputStream(fichero);
			File fichero2 = new File("bin/imagesBuff/bufferDocAduana.jpg");
			FileInputStream streamEntrada2 = new FileInputStream(fichero2);
			File fichero3 = new File("bin/imagesBuff/bufferDocImport.jpg");
			FileInputStream streamEntrada3 = new FileInputStream(fichero3);
			File fichero4 = new File("bin/imagesBuff/bufferDocFact.jpg");
			FileInputStream streamEntrada4 = new FileInputStream(fichero4);

			PreparedStatement statement = conn
					.prepareStatement("insert into pago_realizado ( DESCRIPCION, NOMBRE_ARCHIVO_PAGO_BANCARIO, NOMBRE_ARCHIVO_PAGO_BANCARIO_DATA, NOMBRE_ARCHIVO_DOCUMENTOS_ADUANA, NOMBRE_ARCHIVO_DOCUMENTOS_ADUANA_DATA, NOMBRE_ARCHIVO_DOCUMENTOS_IMPORTACION, NOMBRE_ARCHIVO_DOCUMENTOS_IMPORTACION_DATA, NOMBRE_ARCHIVO_FACTURA, NOMBRE_ARCHIVO_FACTURA_DATA) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setString(1, objeto.getDescripcion());
			statement.setString(2, objeto.getNombreArchivoPagoBancario());
			statement.setBinaryStream(3, streamEntrada, (int) fichero.length());
			statement.setString(4, objeto.getNombredocumentosAduana());
			statement.setBinaryStream(5, streamEntrada2, (int) fichero2
					.length());
			statement.setString(6, objeto
					.getNombreArchivoDocumentosImportacion());
			statement.setBinaryStream(7, streamEntrada3, (int) fichero3
					.length());
			statement.setString(8, objeto.getNombreArchivoFactura());
			statement.setBinaryStream(9, streamEntrada4, (int) fichero4
					.length());
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

	public int modificar(Connection conn, pagoRealizado objeto) {
		try {

			File fichero = new File("bin/imagesBuff/bufferBank.jpg");
			FileInputStream streamEntrada = new FileInputStream(fichero);
			File fichero2 = new File("bin/imagesBuff/bufferDocAduana.jpg");
			FileInputStream streamEntrada2 = new FileInputStream(fichero2);
			File fichero3 = new File("bin/imagesBuff/bufferDocImport.jpg");
			FileInputStream streamEntrada3 = new FileInputStream(fichero3);
			File fichero4 = new File("bin/imagesBuff/bufferDocFact.jpg");
			FileInputStream streamEntrada4 = new FileInputStream(fichero4);

			PreparedStatement statement = conn
					.prepareStatement("update pago_realizado set DESCRIPCION = ?, NOMBRE_ARCHIVO_PAGO_BANCARIO = ?, NOMBRE_ARCHIVO_PAGO_BANCARIO_DATA = ?, NOMBRE_ARCHIVO_DOCUMENTOS_ADUANA = ?, NOMBRE_ARCHIVO_DOCUMENTOS_ADUANA_DATA = ?, NOMBRE_ARCHIVO_DOCUMENTOS_IMPORTACION = ?, NOMBRE_ARCHIVO_DOCUMENTOS_IMPORTACION_DATA = ?, NOMBRE_ARCHIVO_FACTURA = ?, NOMBRE_ARCHIVO_FACTURA_DATA = ? where ID_PR = ?");
			statement.setString(1, objeto.getDescripcion());
			statement.setString(2, objeto.getNombreArchivoPagoBancario());
			statement.setBinaryStream(3, streamEntrada, (int) fichero.length());

			statement.setString(4, objeto.getNombredocumentosAduana());
			statement.setBinaryStream(5, streamEntrada2, (int) fichero2
					.length());

			statement.setString(6, objeto
					.getNombreArchivoDocumentosImportacion());
			statement.setBinaryStream(7, streamEntrada3, (int) fichero3
					.length());

			statement.setString(8, objeto.getNombreArchivoFactura());
			statement.setBinaryStream(9, streamEntrada4, (int) fichero4
					.length());
			statement.setInt(10, objeto.getIdPagoRealizado());
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

	public int eliminar(Connection conn, pagoRealizado objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from pago_realizado where ID_PR = ?");
			statement.setInt(1, objeto.getIdPagoRealizado());
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

	public pagoRealizado buscarInfoDeUnRegistro(Connection conn,
			pagoRealizado objeto) {

		try {

			PreparedStatement statement = conn.prepareStatement("select "
					+ "ID_PR," + "DESCRIPCION,"
					+ "NOMBRE_ARCHIVO_PAGO_BANCARIO,"
					+ "NOMBRE_ARCHIVO_PAGO_BANCARIO_DATA,"
					+ "NOMBRE_ARCHIVO_DOCUMENTOS_ADUANA,"
					+ "NOMBRE_ARCHIVO_DOCUMENTOS_ADUANA_DATA,"
					+ "NOMBRE_ARCHIVO_DOCUMENTOS_IMPORTACION,"
					+ "NOMBRE_ARCHIVO_DOCUMENTOS_IMPORTACION_DATA, "
					+ "NOMBRE_ARCHIVO_FACTURA, "
					+ "NOMBRE_ARCHIVO_FACTURA_DATA "
					+ " from pago_Realizado where DESCRIPCION = '"
					+ objeto.getDescripcion() + "'");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdPagoRealizado(rs.getInt("ID_PR"));
				objeto.setDescripcion(rs.getString("DESCRIPCION"));
				objeto.setNombreArchivoPagoBancario(rs
						.getString("NOMBRE_ARCHIVO_PAGO_BANCARIO"));
				objeto.setNombredocumentosAduana(rs
						.getString("NOMBRE_ARCHIVO_DOCUMENTOS_ADUANA"));
				objeto.setNombreArchivoDocumentosImportacion(rs
						.getString("NOMBRE_ARCHIVO_DOCUMENTOS_IMPORTACION"));
				objeto.setNombreArchivoFactura(rs
						.getString("NOMBRE_ARCHIVO_FACTURA"));

				Blob campoImagen = rs
						.getBlob("NOMBRE_ARCHIVO_PAGO_BANCARIO_DATA");
				crearImagenDeDatoDeLaBDD(campoImagen,
						"bin/imagesBuff/bufferBank.jpg");

				Blob campoImagen2 = rs
						.getBlob("NOMBRE_ARCHIVO_DOCUMENTOS_ADUANA_DATA");
				crearImagenDeDatoDeLaBDD(campoImagen2,
						"bin/imagesBuff/bufferDocAduana.jpg");

				Blob campoImagen3 = rs
						.getBlob("NOMBRE_ARCHIVO_DOCUMENTOS_IMPORTACION_DATA");
				crearImagenDeDatoDeLaBDD(campoImagen3,
						"bin/imagesBuff/bufferDocImport.jpg");

				Blob campoImagen4 = rs.getBlob("NOMBRE_ARCHIVO_FACTURA_DATA");
				crearImagenDeDatoDeLaBDD(campoImagen4,
						"bin/imagesBuff/bufferDocFact.jpg");
			}
			rs.close();
			statement.close();

			// Process data here

		} catch (Exception e) {

		}
		return objeto;

	}

	/*
	 * close //de una imagen de la base de datos crea un archivo
	 */
	public void crearImagenDeDatoDeLaBDD(Blob blobImagen, String URLArch) {
		try {
			File fichero = new File(URLArch);
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
			// JOptionPane.showMessageDialog(null,
			// "Error al crear Archivo de Imagen", "Alerta!",
			// JOptionPane.ERROR_MESSAGE);
		}

	}// crearImagenDeDatoDeLaBDD

	/*
	 * 
	 * retorna un objeto todos los objetos de la tabla para choice
	 */

	public Object[] seleccionarDescripcionesTabla(Connection conn) {
		int totalRows = 0;

		Object datos2[] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_PR) from pago_realizado limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select DESCRIPCION from pago_realizado limit 200");
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
					.prepareStatement("select count(ID_PR) from pago_realizado limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_PR,DESCRIPCION from pago_realizado limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_PR");
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

	public Hashtable<Object, Object> seleccionarIdTablaDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<Object, Object> proveedorLista = new Hashtable<Object, Object>();
		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_PR) from pago_realizado limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][2];
			PreparedStatement statement = conn
					.prepareStatement("select ID_PR,DESCRIPCION from pago_realizado limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("ID_PR");
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

}
