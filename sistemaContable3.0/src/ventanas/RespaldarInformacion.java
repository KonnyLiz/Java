package ventanas;

import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Dialog.dialogRespaldarDatos;
import Utilitarios.utilitarios;

public class RespaldarInformacion extends  JInternalFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanelDerecha = null;
	private JLabel jLabelFechaActual = null;
	private utilitarios util = null;  //  @jve:decl-index=0:
	private JTextField jTextFieldNombreArchivo = null;
	private JTextField jTextFieldUbicación = null;
	private JLabel jLabelNada14 = null;
	private JPanel jPanelIzquierda = null;
	private JLabel jLabelFechaRespaldo = null;
	private JLabel jLabelNombreArchivo = null;
	private JLabel jLabelUbicacion = null;
	private JLabel jLabelFechaRespaldo1 = null;
	private JPanel jPanelBoton = null;
	private utilitarios util1 = null;
	private JLabel jLabelNada111 = null;
	private JLabel jLabelNada141 = null;
	private JButton jButtonAceptar = null;

	/**
	 * This is the default constructor
	 */
	public RespaldarInformacion() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(490, 286);
		this.setContentPane(getJContentPane());
		this.setTitle("Respaldo de información");
		this.setClosable(true);
		this.setIconifiable(true);
		this.setResizable(false);
		}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPanelDerecha(), null);
			jContentPane.add(getJPanelIzquierda(), null);
			jContentPane.add(getJPanelBoton(), null);

		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanelDerecha
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelDerecha() {
		if (jPanelDerecha == null) {
			jLabelNada14 = new JLabel();
			jLabelNada14.setText(" ");
			String string = "" + getUtil().fechaActual();
			jLabelFechaActual = new JLabel();
			jLabelFechaActual.setText(string);
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(4);
			gridLayout1.setHgap(13);
			gridLayout1.setVgap(10);
			gridLayout1.setColumns(2);
			jPanelDerecha = new JPanel();
			jPanelDerecha.setLayout(gridLayout1);
			jPanelDerecha.setBounds(new Rectangle(164, 15, 281, 180));
			jPanelDerecha.add(jLabelFechaActual, null);
			jPanelDerecha.add(getJTextFieldNombreArchivo(), null);
			jPanelDerecha.add(getJTextFieldUbicación(), null);
			jPanelDerecha.add(jLabelNada14, null);
		}
		return jPanelDerecha;
	}

	/**
	 * This method initializes util
	 *
	 * @return Utilitarios.utilitarios
	 */
	private utilitarios getUtil() {
		if (util == null) {
			util = new utilitarios();
		}
		return util;
	}

	/**
	 * This method initializes jTextFieldNombreArchivo
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldNombreArchivo() {
		if (jTextFieldNombreArchivo == null) {
			jTextFieldNombreArchivo = new JTextField();
			jTextFieldNombreArchivo.setText("Respaldo" + getUtil().fechaActual() + ".sql");
		}
		return jTextFieldNombreArchivo;
	}

	/**
	 * This method initializes jTextFieldUbicación
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTextFieldUbicación() {
		if (jTextFieldUbicación == null) {
			jTextFieldUbicación = new JTextField();
			jTextFieldUbicación.setText("/respaldos/");
			jTextFieldUbicación.setEditable(false);
		}
		return jTextFieldUbicación;
	}

	/**
	 * This method initializes jPanelIzquierda
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelIzquierda() {
		if (jPanelIzquierda == null) {
			jLabelFechaRespaldo1 = new JLabel();
			jLabelFechaRespaldo1.setText(" ");
			jLabelUbicacion = new JLabel();
			jLabelUbicacion.setText("Ubicación :");
			jLabelNombreArchivo = new JLabel();
			jLabelNombreArchivo.setText("Nombre del archivo :");
			jLabelFechaRespaldo = new JLabel();
			jLabelFechaRespaldo.setText("Fecha :");
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(5);
			gridLayout.setHgap(5);
			gridLayout.setVgap(11);
			gridLayout.setColumns(2);
			jPanelIzquierda = new JPanel();
			jPanelIzquierda.setLayout(gridLayout);
			jPanelIzquierda.setBounds(new Rectangle(15, 15, 140, 226));
			jPanelIzquierda.add(jLabelFechaRespaldo, null);
			jPanelIzquierda.add(jLabelNombreArchivo, null);
			jPanelIzquierda.add(jLabelUbicacion, null);
			jPanelIzquierda.add(jLabelFechaRespaldo1, null);
		}
		return jPanelIzquierda;
	}

	/**
	 * This method initializes jPanelBoton
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelBoton() {
		if (jPanelBoton == null) {
			jLabelNada141 = new JLabel();
			jLabelNada141.setText(" ");
			jLabelNada111 = new JLabel();
			jLabelNada111.setText(" ");
			GridLayout gridLayout11 = new GridLayout();
			gridLayout11.setRows(1);
			gridLayout11.setHgap(13);
			gridLayout11.setVgap(5);
			gridLayout11.setColumns(3);
			jPanelBoton = new JPanel();
			jPanelBoton.setLayout(gridLayout11);
			jPanelBoton.setBounds(new Rectangle(98, 209, 308, 25));
			jPanelBoton.add(jLabelNada111, null);
			jPanelBoton.add(getJButtonAceptar(), null);
			jPanelBoton.add(jLabelNada141, null);
		}
		return jPanelBoton;
	}

	/**
	 * This method initializes util1
	 *
	 * @return Utilitarios.utilitarios
	 */
	private utilitarios getUtil1() {
		if (util1 == null) {
			util1 = new utilitarios();
		}
		return util1;
	}

	/**
	 * This method initializes jButtonAceptar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonAceptar() {
		if (jButtonAceptar == null) {
			jButtonAceptar = new JButton("Aceptar");
			jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				 respaldar();
				}
			});
		}
		return jButtonAceptar;
	}

public void respaldar(){

    String nombreArchivo=jTextFieldNombreArchivo.getText();
	if(nombreArchivo.compareTo("")==0)
		nombreArchivo="Respaldo creado el"+util.fechaActual();
	dialogRespaldarDatos dialogRespaldarDatos1 = new dialogRespaldarDatos(nombreArchivo );
	dialogRespaldarDatos1.getPreferredSize();
	dialogRespaldarDatos1.setLocation(
			this.getHeight() / 2, this.getWidth() / 2);
	dialogRespaldarDatos1.setVisible(true);

}

}  //  @jve:decl-index=0:visual-constraint="10,10"
