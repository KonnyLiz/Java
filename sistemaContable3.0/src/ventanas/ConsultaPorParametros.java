package ventanas;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.Rectangle;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import paneles.OrdenesDeTrabajoPorParametros;
import paneles.ProformasPorParametros;

public class ConsultaPorParametros extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JTabbedPane jTabbedPanePrincipal = null;
	public ProformasPorParametros ProformasPorParametrosPanel = null;
	public OrdenesDeTrabajoPorParametros OrdenesDeTrabajoPorParametrosPanel = null;
	private JPanel jPanelProforma = null;
	private JPanel jPanelODT = null;
	private String User = null;
	private JPanel jPanel = null;
	JDesktopPane desktopPane1;

	/**
	 * This is the default constructor
	 */
	// public ConsultaPorParametros() {
	public ConsultaPorParametros(String User1, JDesktopPane desktopPane2) {
		super();
		User = User1;
		desktopPane1 = desktopPane2;
		initialize();
		this.setClosable(true);
		this.setIconifiable(true);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {

		this.setSize(752, 484);
		this.setIconifiable(true);
		this.setContentPane(getJContentPane());
		this.setTitle("Consultas Personalizadas");

		// ProformaListaConsultaParam ProformaListaConsultaParamPanel= new
		// ProformaListaConsultaParam("ADMIN");
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
			jContentPane.add(getJTabbedPanePrincipal(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jTabbedPanePrincipal
	 * 
	 * @return javax.swing.JTabbedPane
	 */
	private JTabbedPane getJTabbedPanePrincipal() {
		if (jTabbedPanePrincipal == null) {
			jTabbedPanePrincipal = new JTabbedPane();
			jTabbedPanePrincipal.setBounds(new Rectangle(28, 8, 695, 427));
			jTabbedPanePrincipal.setBackground(new Color(238, 238, 238));
			jTabbedPanePrincipal.addTab("Proformas", null, getJPanelProforma(),
					null);
			jTabbedPanePrincipal.addTab("Ordenes de Trabajo", null,
					getJPanelOrdenTrabajo(), null);
			// jTabbedPanePrincipal.addTab(null, null, getJPanel(), null);
		}
		return jTabbedPanePrincipal;
	}

	/**
	 * This method initializes jPanelProforma
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelProforma() {
		if (jPanelProforma == null) {
			jPanelProforma = new ProformasPorParametros(User, desktopPane1);

		}
		return jPanelProforma;
	}

	/**
	 * This method initializes jPanelProforma
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanelOrdenTrabajo() {
		if (jPanelODT == null) {
			jPanelODT = new OrdenesDeTrabajoPorParametros(User, desktopPane1);

		}
		return jPanelODT;
	}

	/**
	 * This method initializes jPanel
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
		}
		return jPanel;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
