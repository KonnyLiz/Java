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
import clases.proforma;
import clases.proformaDetalle;

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

public class impresionFacturaParametros extends JFrame {

	// Se obtiene el objeto PrintJob
	PrintJob pjob = this.getToolkit().getPrintJob(this, "Impresión Factura",
			null);

	public impresionFacturaParametros() {
		try {
			Init();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	private void Init() throws Exception {
		getContentPane().setLayout(null);

	}

	public void imprimir(proforma recibo, proformaDetalle reciboDet[],
			cliente cliente) {
		// datos_factura nueva_factura,int filasporimprimir[]){

		// Se obtiene el objeto graphics sobre el que pintar
		Graphics pg = pjob.getGraphics();
		// se carga los parametros para impresion
		int arr[] = getContents(new File("bin/ConfigImpresion/facturaparam.txt"));
		if (arr[25] > 1) {
			pg.setFont(new Font("SansSerif", Font.BOLD, Integer.parseInt(""
					+ arr[24])));
		} else {
			pg.setFont(new Font("SansSerif", Font.PLAIN, Integer.parseInt(""
					+ arr[24])));
		}
		// Se fija el font de caracteres con que se escribe

		// // Se escribe datos factura
		pg.drawString("" + recibo.getFecha(), arr[0], arr[1]);
		pg.drawString("" + cliente.getNombre(), arr[2], arr[3]);
		pg.drawString("" + cliente.getCiRuc(), arr[4], arr[5]);
		pg.drawString("" + cliente.getTelefono(), arr[6], arr[7]);
		pg.drawString("" + cliente.getDireccion(), arr[8], arr[9]);
		/**
		 * impresion de items
		 * 
		 */
		for (int i = 0; i < reciboDet.length; i++) {
			if (reciboDet[i].getCantidad() != 0) {
				pg.drawString("" + reciboDet[i].getCantidad(), arr[20],
						(arr[11] + (i * 16)));

				pg.drawString("" + reciboDet[i].getIdDescripcion() + " "
						+ reciboDet[i].getIdMedidaX() + "" + ""
						+ reciboDet[i].getIdMedidaY(), arr[21],
						(arr[11] + (i * 16)));

				pg.drawString("" + reciboDet[i].getIdPrecio(), arr[22],
						(arr[11] + (i * 16)));
				pg.drawString("" + reciboDet[i].getTotal(), arr[23],
						(arr[11] + (i * 16)));
			}
		}

		pg.drawString("" + recibo.getSubtotal(), arr[12], (arr[13]));
		pg.drawString("" + recibo.getIva(), arr[16], (arr[17]));
		pg.drawString("" + recibo.getTotal(), arr[18], (arr[19]));

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
		String arr[] = { "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
				"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0",
				"0", "0", "0" };
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
					if (cont != 25)
						arr[cont] = "" + line;

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
				0, 0, 0, 0, 0, 0, 0 };

		for (int i = 0; i < arr.length - 1; i++) {
			// System.out.print("\nitem DAto:"+arr[i]+":"+i);
			String temp = "" + (Float.parseFloat((arr[i]))) * 280;

			int puntoIndex = temp.lastIndexOf(".");
			if (temp.length() != 1)
				temp = temp.substring(0, puntoIndex - 1);

			arr2[i] = Integer.parseInt("" + temp);// 25 es el equivalente de
			// 1cm a pixeles
		}
		String temp = "" + Float.parseFloat(arr[24]);
		int puntoIndex = temp.lastIndexOf(".");
		if (puntoIndex > 1)
			temp = temp.substring(0, puntoIndex);
		else
			temp = temp.substring(0, 1);
		arr2[24] = Integer.parseInt(temp);

		return arr2;
	}

}
