package clases;

import com.mysql.jdbc.Blob;

/**
 * Write a description of class pagoRealizado here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class pagoRealizado {
	// instance variables - replace the example below with your own
	private int idPagoRealizado;
	private String descripcion;
	private String nombreArchivoPagoBancario;
	private Blob nombreArchivoPagoBancarioData;
	private String documentosAduana;
	private Blob documentosAduanaData;
	private String archivoDocumentosImportacion;
	private Blob archivoDocumentosImportacionData;
	private String nombreArchivoFactura;
	private Blob nombreArchivoFacturaData;

	/**
	 * Constructor for objects of class pagoRealizado
	 */
	public pagoRealizado(int d1, String d2, String d3, Blob d4, String d5,
			Blob d6, String d7, Blob d8, String d9, Blob d10) {
		this.idPagoRealizado = d1;
		this.descripcion = d2;
		this.nombreArchivoPagoBancario = d3;
		this.nombreArchivoPagoBancarioData = d4;
		this.documentosAduana = d5;
		this.documentosAduanaData = d6;
		this.archivoDocumentosImportacion = d7;
		this.archivoDocumentosImportacionData = d8;
		this.nombreArchivoFactura = d9;
		this.nombreArchivoFacturaData = d10;
	}

	/**
	 * An example of a method - replace this comment with your own
	 * 
	 * @param y
	 *            a sample parameter for a method
	 * @return the sum of x and y
	 */
	public void setIdPagoRealizado(int value) {
		this.idPagoRealizado = value;
	}

	public void setDescripcion(String value) {
		this.descripcion = value;
	}

	public void setNombreArchivoPagoBancario(String value) {
		this.nombreArchivoPagoBancario = value;
	}

	public void setNombreArchivoPagoBancarioData(Blob value) {
		this.nombreArchivoPagoBancarioData = value;
	}

	public void setNombredocumentosAduana(String value) {
		this.documentosAduana = value;
	}

	public void setNombreDocumentosAduanaData(Blob value) {
		this.documentosAduanaData = value;
	}

	public void setNombreArchivoDocumentosImportacion(String value) {
		this.archivoDocumentosImportacion = value;
	}

	public void setNombreArchivoDocumentosImportacionData(Blob value) {
		this.archivoDocumentosImportacionData = value;
	}

	public void setNombreArchivoFactura(String value) {
		this.nombreArchivoFactura = value;
	}

	public void setNombreArchivoFacturaData(Blob value) {
		this.nombreArchivoFacturaData = value;
	}

	// Metodos get

	public int getIdPagoRealizado() {
		return this.idPagoRealizado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getNombreArchivoPagoBancario() {
		return this.nombreArchivoPagoBancario;
	}

	public Blob getNombreArchivoPagoBancarioData() {
		return this.nombreArchivoPagoBancarioData;
	}

	public String getNombredocumentosAduana() {
		return this.documentosAduana;
	}

	public Blob getNombreDocumentosAduanaData() {
		return this.documentosAduanaData;
	}

	public String getNombreArchivoDocumentosImportacion() {
		return this.archivoDocumentosImportacion;
	}

	public Blob getNombreArchivoDocumentosImportacionData() {
		return this.archivoDocumentosImportacionData;
	}

	public String getNombreArchivoFactura() {
		return this.nombreArchivoFactura;
	}

	public Blob getNombreArchivoFacturaData() {
		return this.nombreArchivoFacturaData;
	}

}
