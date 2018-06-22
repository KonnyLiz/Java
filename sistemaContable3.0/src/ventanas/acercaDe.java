package ventanas;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class acercaDe extends JInternalFrame {

	private JPanel jContentPane = null;
	private JLabel jLabelRealizadoPor = null;
	private JLabel jLabelRealizadoPor1 = null;
	private JLabel jLabelFecha = null;
	private JLabel jLabelSoporte = null;
	private JLabel jLabelSoporte1 = null;
	/**
	 * This is the xxx default constructor
	 */
	public acercaDe() {
		super();
		initialize();
		this.setClosable(true);
		
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(459, 229);
		this.setTitle("Acerca de");
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jLabelSoporte1 = new JLabel();
			jLabelSoporte1.setBounds(new Rectangle(-2, -1, 471, 15));
			jLabelSoporte1.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelSoporte1.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelSoporte1.setText("Desarrollado por: Carlangas11   ");
			jLabelSoporte1.setToolTipText("Soporte Técnico ");
			jLabelSoporte = new JLabel();
			jLabelSoporte.setBounds(new Rectangle(38, 44, 254, 16));
			jLabelSoporte.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelSoporte.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelSoporte.setToolTipText("Soporte Técnico ");
			jLabelSoporte.setText("Soporte Técnico : carlos_va55@hotmail.com");
			jLabelFecha = new JLabel();
			jLabelFecha.setBounds(new Rectangle(340, 180, 109, 16));
			jLabelFecha.setText("May 2009/Nov 2010");

			jLabelRealizadoPor1 = new JLabel();
			jLabelRealizadoPor1.setBounds(new Rectangle(-2, 62, 453, 117));
			jLabelRealizadoPor1.setIcon(new ImageIcon(getClass().getResource("/reportes/logo.jpg")));
			jLabelRealizadoPor1.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelRealizadoPor1.setText("");
			jLabelRealizadoPor = new JLabel();
			jLabelRealizadoPor.setBounds(new Rectangle(40, 25, 139, 16));
			jLabelRealizadoPor.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelRealizadoPor.setHorizontalTextPosition(SwingConstants.CENTER);
			jLabelRealizadoPor.setText("Ver: 3.7   Compilación 79");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(jLabelRealizadoPor1, null);
			jContentPane.add(jLabelFecha, null);
			jContentPane.add(jLabelRealizadoPor, null);
			jContentPane.add(jLabelSoporte, null);
			jContentPane.add(jLabelSoporte1, null);
		}
		return jContentPane;
	}

}  //  @jve:decl-index=0:visual-constraint="5,-28"
