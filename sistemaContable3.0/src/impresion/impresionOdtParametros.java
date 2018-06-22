package impresion;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;

import clases.cliente;
import clases.ordenDeTrabajo;
import clases.ordenTrabajoDetalle;

/**
 * <p>
 * Title:
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2005
 * </p>
 * 
 * <p>
 * Company:
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class impresionOdtParametros extends JFrame {

	// Se obtiene el objeto PrintJob
	PrintJob pjob = this.getToolkit().getPrintJob(this,
			"Impresión Orden de Trabajo", null);

	public impresionOdtParametros() {
		try {
			Init();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void Init() throws Exception {
		getContentPane().setLayout(null);

	}

	public void imprimir(ordenDeTrabajo odt, ordenTrabajoDetalle odtDet[],
			cliente cliente) {
		// datos_factura nueva_factura,int filasporimprimir[]){

		// Se obtiene el objeto graphics sobre el que pintar
		Graphics pg = pjob.getGraphics();
		// se carga los parametros para impresion
		int arr[] = getContents(new File("bin/ConfigImpresion/odtparam.txt"));
		if (arr[21] > 1) {
			pg.setFont(new Font("SansSerif", Font.BOLD, Integer.parseInt(""
					+ arr[20])));
		} else {
			pg.setFont(new Font("SansSerif", Font.PLAIN, Integer.parseInt(""
					+ arr[20])));
		}
		// Se fija el font de caracteres con que se escribe

		// // Se escribe datos factura
		pg.drawString("" + cliente.getNombre() + "  " + cliente.getCiRuc(),
				arr[0], arr[1]);
		pg.drawString("" + odt.getFecha(), arr[2], arr[3]);
		pg.drawString("" + cliente.getTelefono(), arr[4], arr[5]);
		pg.drawString("" + odt.getNombredelArchivo(), arr[6], arr[7]);
		pg.drawString("" + odt.getImpresion(), arr[8], arr[9]);
		pg.drawString("" + odt.getPrecio(), arr[12], arr[13]);
		pg.drawString("" + odt.getAbono(), arr[14], arr[15]);
		pg.drawString("" + odt.getSaldo(), arr[16], arr[17]);
		/**
		 * impresion de items
		 * 
		 */
		for (int i = 0; i < odtDet.length; i++) {
			pg.drawString("" + odtDet[i].getCantidad() + "   " + "		"
					+ odtDet[i].getDescripcion() + "   "
					+ odtDet[i].getMedidaX() + "x" + odtDet[i].getMedidaY()
					+ "" + "    " + odtDet[i].getPrecio() + "  ", arr[10],
					(arr[11] + (i * 12)));
		}

		char arrObs[] = odt.getObservacion().toCharArray();
		if (arrObs.length < 40)
			pg.drawString(
					"" + odt.getObservacion().substring(0, arrObs.length),
					arr[18], arr[19]);
		if (arrObs.length < 80 && arrObs.length > 40) {
			pg.drawString("" + odt.getObservacion().substring(0, 40), arr[18],
					arr[19]);
			pg.drawString(""
					+ odt.getObservacion().substring(40, arrObs.length),
					arr[18], (arr[19] + 10));
		}
		if (arrObs.length > 160 && arrObs.length > 80) {
			pg.drawString("" + odt.getObservacion().substring(0, 40), arr[18],
					arr[19]);
			pg.drawString("" + odt.getObservacion().substring(40, 80), arr[18],
					(arr[19] + 10));
			pg.drawString("" + odt.getObservacion().substring(80, 120),
					arr[18], (arr[19] + 20));
			pg.drawString(""
					+ odt.getObservacion().substring(120, arrObs.length),
					arr[18], (arr[19] + 30));
		}
		// /columna1

		// Se finaliza la página
		pg.dispose();

		pjob.end();

		this.dispose();
	}

	/**
	 * cargar parametros de impresion
	 * 
	 * @param aFile
	 * @return
	 */

	static int[] getContents(File aFile) {
		// ...checks on aFile are elided
		StringBuilder contents = new StringBuilder();
		String arr[] = { "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "" };
		try {
			// use buffering, reading one line at a time
			// FileReader always assumes default encoding is OK!

			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null; // not declared within while loop
				int cont = 0;
				/*
				 * readLine is a bit quirky : it returns the content of a line
				 * MINUS the newline. it returns null only for the END of the
				 * stream. it returns an empty String if two newlines appear in
				 * a row.
				 */
				while ((line = input.readLine()) != null) {
					arr[cont] = "" + line;
					// contents.append(line);
					contents.append(System.getProperty("line.separator"));
					cont++;
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		int arr2[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		;
		for (int i = 0; i < arr.length - 1; i++) {
			String temp = "" + (Float.parseFloat((arr[i]))) * 280;

			int puntoIndex = temp.lastIndexOf(".");
			temp = temp.substring(0, puntoIndex - 1);
			arr2[i] = Integer.parseInt("" + temp);// 25 es el equivalente de
			// 1cm a pixeles
		}
		String temp = "" + Float.parseFloat(arr[20]);
		int puntoIndex = temp.lastIndexOf(".");

		if (puntoIndex > 1)
			temp = temp.substring(0, puntoIndex);
		else
			temp = temp.substring(0, 1);
		arr2[20] = Integer.parseInt(temp);

		return arr2;
	}

}
