package Utilitarios;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class utilitarios {

	/**
	 * devuelve fecha actual
	 *
	 * @return
	 */

	public String fechaActual() {
		Date date = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String stringDate = s.format(date);
		return stringDate;

	}

	/*
	 * Devuelve un boolean true si la fecha 1 es menor que la fecha 2
	 */

	public boolean compararFechasString(String fecha1, String fecha2) {
		boolean resultado = true;
		DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fechaDate1 = formatoFecha.parse(fecha1.toString());
			Date fechaDate2 = formatoFecha.parse(fecha2.toString());
			if (fechaDate1.getTime() <= fechaDate2.getTime()) {
				resultado = true;
			} else {
				resultado = false;
			}// end else

		} catch (ParseException e) {
			e.printStackTrace();
		}// end catch
		return resultado;
	}// fin compararFechasString

	// metodo para validar si la fecha es correcta
	public boolean isDate(String fechax) {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			Date fecha = formatoFecha.parse(fechax);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	// metodo para validar correo electronio
	public boolean isEmail(String correo) {
		Pattern pat = null;
		Matcher mat = null;
		pat = Pattern
				.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
		mat = pat.matcher(correo);
		if (mat.find()) {
			System.out.println("[" + mat.group() + "]");
			return true;
		} else {
			return false;
		}
	}

	/*
	 * try { MaskFormatter mascara = new MaskFormatter("##.##");
	 * JFormattedTextField textField = new JFormattedTextField(mascara);
	 * textField.setValue(new Float("12.34")); } catch (Exception e) {
	 * e.printStackTrace(); }
	 *
	 */

	/**
	 * Verifica si se ingreso un caracter inválido solo letras
	 *
	 * @param e
	 */

	public void verificarTexto(KeyEvent e) {
		char c = e.getKeyChar();
		if (Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE
				|| Character.isSpaceChar(c))
			;
		else {
			e.consume();
		}
	}

	/**
	 * Permite el ingreso de solo números flotantes
	 *
	 * @param e
	 */
	public void verificar(KeyEvent e) {
		char c = e.getKeyChar();
		if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == '.')
			;
		else {
			e.consume();
		}
	}

	/**
	 * Verifica solo numeros ingresados
	 */
	public void soloNumerosInput(KeyEvent e) {
		char c = e.getKeyChar();
		if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == '.')
			;
		else {
			e.consume();
		}
	}

	/**
	 * Verifica que no se pase un string de una cantidad
	 */
	public String cortarCadenaString(String cadena, int longitud) {
		if (cadena.length() > longitud) {
			cadena = cadena.subSequence(0, longitud).toString();
		}
		return cadena;
		//
	}// cortarCadenaString

	/**
	 * Verifica si se ingreso un caracter inválido solo letras
	 *
	 * @param e
	 */

	public void soloLetras(KeyEvent e) {
		char c = e.getKeyChar();
		if (Character.isLetter(c))
			;
		else {
			e.consume();
		}
	}

	/**
	 * procesar Imagenes
	 *
	 */

	/*
	 * * Devuelve una imagen enviando el path
	 *
	 * uso: ImageIcon icono= createImageIcon("images/foto.png","desc"); jLabel =
	 * new JLabel("Image and Text", icono, JLabel.CENTER);
	 */
	public ImageIcon createImageIcon(String path, String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("No existe elarchivo: " + path);
			return null;
		}
	}

	/**
	 * redondear un numero ejm 2.78=2.79
	 */
	public float Redondear(String nD, int nDec) {
		return (float) (Math.round(Float.parseFloat(nD) * Math.pow(10, nDec)) / Math
				.pow(10, nDec));
	}

	/**
	 * Verifica que no se pase un string de tipo flotante y solo de una cantidad
	 */
	public String cortarCadenaFloat(String cadena) {
		if (cadena.length() > 0) {// verifica que sea un numero
			if (cadena.startsWith(".")) // lo escrito y no un espacio
				cadena = "0.";
			if (cadena.length() > 2) {
				boolean tienePunto = false;
				char[] temporal = cadena.toCharArray();
				if (cadena.startsWith("."))
					cadena = "0" + cadena;
				try {
					Double.parseDouble(cadena);
				} catch (Exception ex) {
					cadena = cadena.substring(0, (cadena.length() - 1));
				}
				int puntoPos = 0;
				try {
					puntoPos = cadena.lastIndexOf(".");
					tienePunto = true;
				} catch (Exception sinpunto) {
					puntoPos = 0;
					tienePunto = false;
				}
				int puntoPos1 = puntoPos + 2;// sirve de guia para saber si
				// las cadena tiene mas de 2 dígitos
				// despues del punto para dinero
				if (cadena.length() > puntoPos1 && puntoPos != -1) {
					cadena = cadena.substring(0, puntoPos);
					cadena = cadena + temporal[(puntoPos)]
							+ temporal[(puntoPos + 1)]
							+ temporal[(puntoPos + 2)];
				}// end if
			} else {
				try {
					Double.parseDouble(cadena);
				} catch (Exception ex) {
					cadena = cadena.substring(0, (cadena.length() - 1));
				}
			}
		}// no ejecuta lo anterior si la length es 0
		// return ""+Redondear(cadena,2);
		return "" + cadena;

	}// cortarCadenaFloat

	/**
	 * hacer esperar a un proceso
	 *
	 * @param n
	 */
	public static void wait(int n) {
		long t0, t1;
		t0 = System.currentTimeMillis();
		do {
			t1 = System.currentTimeMillis();
		} while (t1 - t0 < 1000);
	}

	/*
	 * Muestra menú para cargar un archivo
	 *
	 *
	 *
	 */

	public String cargarArchivoDiscoDuro() {

		String nombredelaImagen = null;
		Frame parent = new Frame();
		parent.setSize(new Dimension(129, 39));
		FileDialog fd = new FileDialog(parent, "Seleecione un archivo:",
				FileDialog.LOAD);
		fd.setVisible(true);
		String selectedItem = fd.getFile();
		if (selectedItem == null) {
			JOptionPane.showMessageDialog(null,
					"No se ha seleccionado un archivo!", "Aviso",
					JOptionPane.ERROR_MESSAGE);
		} else {
			File ffile = new File(fd.getDirectory() + File.separator
					+ fd.getFile());
			// read the file
			// JOptionPane.showMessageDialog(null, ""+"reading file " +
			// fd.getDirectory() +
			// File.separator + fd.getFile(), "Aviso",
			// JOptionPane.ERROR_MESSAGE);
			nombredelaImagen = fd.getFile();

		}
		return nombredelaImagen;
	}// end cargar foto

	/**
	 * Verifica solo numeros ingresados
	 */
	public void soloNumeros(KeyEvent e) {
		char c = e.getKeyChar();
		if (Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE)
			;
		else {
			e.consume();
		}
	}

	/**
	 * Verifica si se ingreso un caracter inválido solo letras
	 *
	 * @param e
	 */

	public void verificarTextoConEspacio(KeyEvent e) {
		char c = e.getKeyChar();
		if (Character.isLetter(c) || c == KeyEvent.VK_BACK_SPACE
				|| c == KeyEvent.VK_SPACE)
			;
		else {
			e.consume();
		}
	}

/*	public float cortarA2Decimales(Float cifra) {
		char []cifraChar=cifra.toString().toCharArray();
		int i = cifra.toString().lastIndexOf('.');

		try{
			int num=Integer.parseInt(cifraChar[i+3]+"".trim());
			if(num>=5){
				cifra=Float.parseFloat(cifra.toString().substring(0, (i+3)));
				//cifra=(cifra+Float.parseFloat(""+0.01));
          		}
		}catch(Exception noNumero){
		//	noNumero.printStackTrace();
		System.out.println("problema de conversión");
		}


	return cifra;
	}*/

/**
 * Permite redondear y truncar un valor
 *  a 2 cifras
 * @param cifra
 * @return float
 */

	public float TruncarRedondear(Float cifra){

		char []cifraChar=cifra.toString().toCharArray();
		int i = cifra.toString().lastIndexOf('.');

		try{
			int num=Integer.parseInt(cifraChar[i+3]+"".trim());
			if(num>=5){

				cifra=Float.parseFloat(cifra.toString().substring(0, (i+3)));
				cifra=(cifra+Float.parseFloat(""+0.01));
				cifra=Float.parseFloat(cifra.toString().substring(0, (i+3)));

          		}
		}catch(Exception decimal2){

		}
		  try{
		  if((cifraChar.length-i)>2)
			   cifra=Float.parseFloat(cifra.toString().substring(0, (i+3)));
		     }catch(Exception NoAplica1Dig){

		     }

	return cifra;
	}
}
