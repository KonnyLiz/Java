package ventanas;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class mostrarImagen extends JDialog {

	private static final long serialVersionUID = 1L;
	String NombreArchivo; // @jve:decl-index=0:
	private JLabel jLabelImg = null;
	ImageIcon imgNombre = null; // @jve:decl-index=0:

	/**
	 * @param owner
	 */
	public mostrarImagen(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabelImg = new JLabel();
		jLabelImg.setHorizontalTextPosition(SwingConstants.CENTER);
		jLabelImg.setHorizontalAlignment(SwingConstants.CENTER);
		this.setSize(315, 349);
		this.setTitle("Imagen");
		this.add(jLabelImg, BorderLayout.CENTER);
	}

	public void setNombreImagen(String value) {
		this.NombreArchivo = value;
	}

	public String getNombreImagen() {
		return this.NombreArchivo;
	}

	public void actualizaImagen(final String nombreArchivo1) {
		new Thread(new Runnable() {
			public void run() {
				setNewImage(nombreArchivo1);
			}
		}).start();
	}

	public void setNewImage(String nombreArchivo) {
		ImageIcon imagen = new ImageIcon("bin/images/null.png");
		jLabelImg.setIcon(imagen);
		imagen = new ImageIcon(nombreArchivo);
		jLabelImg.setIcon(imagen);

	}

} // @jve:decl-index=0:visual-constraint="10,10"
