package facturasdellamadas;

import javax.swing.*;
import java.awt.event.*;
 
public class Imagen extends JFrame
{
	
	ImageIcon imagen = new ImageIcon("src/Logo.jpg");
 	JLabel etiqueta = new JLabel(imagen);

 	public Imagen()
	{
 
		//Agregando etiqueta qur contendra la imagen
		getContentPane().add(etiqueta);
 
		//estableciendo tamaño del frame
		this.setSize(500, 500);
 
	}
 
 
	public static void main(String H[])
	{
		Imagen p = new Imagen();
		p.show();
		
		//COLOCAMOS EL CODIGO QUE PERMITE CERRAR LA VENTANA
		p.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				System.exit(0);
			}
		});
	}
	
}
 


