package Dialog;

import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class error extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTextArea jTextAreaError = null;
	private JLabel jLabeletiqueta = null;
	private JScrollPane jScrollPane = null;
	String texto="";  //  @jve:decl-index=0:
	String clase="";
	private JLabel jLabeletiqueta1 = null;
	/**
	 * This is the default constructor
	 */
	public error(String texto1,String clase1) {
		super();
		initialize(texto1,clase1);

	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize(String texto1,String clase1) {
		this.setSize(460, 370);
		this.setContentPane(getJContentPane());
		this.setTitle("Problema del sistema");
	   cargarTexto(texto1,clase1);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				try {
					cerrar();
				} catch (Throwable e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabeletiqueta1 = new JLabel();
			jLabeletiqueta1.setBounds(new Rectangle(20, 40, 385, 29));
			jLabeletiqueta1.setText("Por favor informar esto a : carlos_va55@hotmail.com");
			jLabeletiqueta1.setHorizontalAlignment(SwingConstants.LEFT);
			jLabeletiqueta = new JLabel();
			jLabeletiqueta.setBounds(new Rectangle(22, 7, 269, 27));
			jLabeletiqueta.setHorizontalAlignment(SwingConstants.LEFT);
			jLabeletiqueta.setText("Se detectó un problema en el sistema.");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabeletiqueta, null);
			jContentPane.add(getJScrollPane(), null);
			jContentPane.add(jLabeletiqueta1, null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTextAreaError
	 *
	 * @return javax.swing.JTextArea
	 */
	private JTextArea getJTextAreaError() {
		if (jTextAreaError == null) {
			jTextAreaError = new JTextArea();
			jTextAreaError.setEditable(false);

		}
		return jTextAreaError;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(19, 106, 410, 186));
			jScrollPane.setViewportView(getJTextAreaError());
		}
		return jScrollPane;
	}

	public void cerrar(){
	this.dispose();
}

public void cargarTexto(String texto1,String clase1){
	texto=texto1;
	clase=clase1;
	jTextAreaError.append("Clase:"+clase);
	jTextAreaError.append("\n");
	jTextAreaError.append(texto);


}
}  //  @jve:decl-index=0:visual-constraint="10,10"
