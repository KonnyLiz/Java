package ventanas;

import impresion.configurarParametrosdeImpresionRecibos;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.net.URL;

import javax.help.HelpSet;
import javax.help.JHelp;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultEditorKit;

import Dialog.mostrarReporteProductosDialog;
import clasesBdd.alertasBdd;
import clasesBdd.conexionBdd;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu menuArchivo = null;
	private JMenuItem menuSlrItem = null;
	private JMenu menuAdm = null;
	private JMenu Contabilidad = null;
	private JMenu menuReportes = null; // @jve:decl-index=0:visual-constraint="777,68"
	private JMenu menuAyuda = null;
	private JMenuItem itemAcercaDe = null;
	private JMenu menuInventario = null;
	private JMenuItem menuProveedor = null;
	private JMenu menuClntItem = null;
	private JMenuItem menuTClntItem = null;
	private JMenuItem menuClntIItem = null;
	private JMenu menuEmp = null;
	private JMenuItem menuEmpItem = null;
	private JMenu menuUsuarios = null;
	private JMenu menulistas = null;
	private JMenu menuPagoFctr = null;
	private JMenu menuOdt = null;
	private JMenu menuRcdtrAltr = null;
	private JMenuItem menuAltrLista = null;
	private JMenuItem menuAdmUsrItem = null;
	private JMenuItem menuCambiarUsuario = null;
	private JMenuItem manualUsr = null;
	private JMenuItem jMenuItmCrearRecboVentana = null;
	private JMenuItem jMenuItemTipoTrabajo = null;
	private JMenuItem jMenuItemOrdenDeTranajo = null;
	private JMenuItem jMenuItemUnidadDeMedida = null;
	private JMenuItem jMenuItemTipoProducto = null;
	private JMenuItem jMenuItemProducto = null;
	private JMenuItem jMenuItemPagoRealizadoCompra = null;
	private JMenuItem jMenuItemSetup = null;
	private JMenu jMenuProforma = null;
	private JMenuItem jMenuItemCrearProforma = null;
	private JMenuItem jMenuItemCrearAlerta = null;
	private JMenuItem jMenuItemtipoDePago = null;
	/**
	 * Variables de usuario en el sistema
	 */
	private String userName = null; // @jve:decl-index=0:
	private String RolUsuarioSistema = null; // @jve:decl-index=0:
	private JLabel jLabelUsuario = null;
	private JToolBar jToolBarAccesosRapidos = null;
	private JButton jButton = null;
	private JMenuItem jMenuItem = null;
	private JButton jButton1 = null;
	private JButton jButton2 = null;
	private JMenuItem jMenuOrdenesTrabajo = null;
	private JMenuItem jMenuProveedores = null;
	private JMenuItem jMenuListaEmpleados = null;
	private JMenuItem jMenuItemListaProductos = null;
	private JMenu jMenuListasProducto = null;
	private JMenu jMenuConsultas = null;
	private JMenuItem jMenuListaClientes = null;
	private JMenuItem jMenuBancos = null;
	private JMenuItem jMenuItemBodega = null;
	private JMenuItem jMenuItemREciboCompra = null;
	private JMenu jMenuBanco = null;
	private JMenuItem jMenuItemCuentas = null;
	private JMenu jMenuPagoProveedor = null;
	private JMenuItem jMenuItem1 = null;
	private JMenuItem jMenuItemTipoREcibo = null;
	private JMenuItem jMenuItemParamImpresion = null;
	private JLabel jLabel = null;
	private JLabel jLabeBlanco3 = null;
	private JMenuItem jMenuItemRol = null; // @jve:decl-index=0:visual-constraint="787,16"
	private JButton jButtonCopy = null;
	private JButton jButtonPaste = null;
	private JButton jButtonCortar = null;
	private JLabel jLabeBlanco31 = null;
	private JButton jButtonUsuario = null;
	private JMenu jMenuReportePersonalizado = null;
	private JMenuItem jMenuItemConsultaPersonalizada = null;
	private JMenuItem jMenuItemReporteProductos = null;
	private JMenuItem jMenuItemPersonalizarReporte = null;
	private JDesktopPane jDesktopPane = null;
	private JScrollPane jScrollPane = null;
	private JMenuItem jMenuItemConsultaReciboCompra = null;
	private JMenuItem jMenuItemConsultarCompras = null;
	private JMenuItem jMenuItemCuentasCobrar = null;  //  @jve:decl-index=0:visual-constraint="765,138"
	private JMenuItem jMenuItemRespaldarInformaciom = null;

	/**
	 * fin variables del usuario en el sistema
	 */
	/**
	 * This method initializes jJMenuBar
	 *
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getMenuAdm());
			jJMenuBar.add(getMenuInventario());
			jJMenuBar.add(getMenulistas());
			jJMenuBar.add(getJMenuConsultas());
			jJMenuBar.add(getContabilidad());
			jJMenuBar.add(getMenuReportes());
			jJMenuBar.add(getMenuRcdtrAltr());
			jJMenuBar.add(getMenuArchivo());
			jJMenuBar.add(getMenuAyuda());
		}
		return jJMenuBar;
	}

	// ////////////////////////////////////////
	/**
	 * This method initializes menuOpciones
	 *
	 * @return javax.swing.JMenuBar
	 */

	/**
	 * This method initializes menuArchivo
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuArchivo() {
		if (menuArchivo == null) {
			menuArchivo = new JMenu();
			menuArchivo.setText("Opciones Del Sistema");
			menuArchivo.setMnemonic(KeyEvent.VK_R);

			if (RolUsuarioSistema.compareToIgnoreCase("ADMIN") == 0) {
				menuArchivo.add(getJMenuItemSetup());
				menuArchivo.add(getJMenuItem());
				menuArchivo.add(getJMenuItemParamImpresion());
				menuArchivo.add(getMenuSlrItem());
			}
			if (RolUsuarioSistema.compareToIgnoreCase("CONTABILIDAD") == 0) {
				menuArchivo.add(getJMenuItem());
				menuArchivo.add(getMenuSlrItem());
			}
			menuArchivo.add(getJMenuItem());
			menuArchivo.add(getMenuSlrItem());
		}
		return menuArchivo;
	}

	/**
	 * This method initializes menuSlrItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuSlrItem() {
		if (menuSlrItem == null) {
			menuSlrItem = new JMenuItem();
			menuSlrItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_X,
					java.awt.event.InputEvent.ALT_MASK
							| java.awt.event.InputEvent.CTRL_MASK));
			menuSlrItem.setText("Salir");

			menuSlrItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.exit(1);
				}
			});
		}
		return menuSlrItem;
	}

	/**
	 * This method initializes menuAdm
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuAdm() {
		if (menuAdm == null) {
			menuAdm = new JMenu();
			menuAdm.setMnemonic(KeyEvent.VK_A);
			menuAdm.setText("Administración");
			menuAdm.setEnabled(false);
			if (RolUsuarioSistema.compareToIgnoreCase("ADMIN") == 0) {
				menuAdm.add(getMenuClntItem());
				menuAdm.add(getMenuProveedor());
				menuAdm.add(getMenuEmp());
				menuAdm.add(getMenuUsuarios());
				menuAdm.add(getJMenuItemRespaldarInformaciom());
				menuAdm.setEnabled(true);
			}
			if (RolUsuarioSistema.compareToIgnoreCase("CONTABILIDAD") == 0) {
				menuAdm.add(getMenuEmp());
				menuAdm.setEnabled(true);

			}

		}
		return menuAdm;
	}

	/**
	 * This method initializes Contabilidad
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getContabilidad() {
		if (Contabilidad == null) {
			Contabilidad = new JMenu();
			Contabilidad.setText("Contabilidad");
			Contabilidad.setMnemonic(KeyEvent.VK_C);
			Contabilidad.setEnabled(false);
			if (RolUsuarioSistema.compareToIgnoreCase("ADMIN") == 0) {
				Contabilidad.add(getJMenuItemREciboCompra());
				Contabilidad.add(getJMenuItemPagoRealizadoCompra());
				Contabilidad.add(getJMenuBanco());
				Contabilidad.add(getJMenuPagoProveedor());
				Contabilidad.add(getJMenuItemCuentasCobrar());
				Contabilidad.setEnabled(true);
			}
			if (RolUsuarioSistema.compareToIgnoreCase("CONTABILIDAD") == 0) {
				Contabilidad.add(getJMenuItemREciboCompra());
				Contabilidad.add(getJMenuItemPagoRealizadoCompra());
				Contabilidad.add(getJMenuBanco());
				Contabilidad.add(getJMenuPagoProveedor());
				Contabilidad.setEnabled(true);
			}
		}
		return Contabilidad;
	}

	/**
	 * This method initializes menuReportes
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuReportes() {
		if (menuReportes == null) {

			menuReportes = new JMenu();
			menuReportes.setMnemonic(KeyEvent.VK_R);
			menuReportes.setText("Reportes");
			menuReportes.add(getJMenuItemReporteProductos());
//mostrarReporteProductosDialog
			menuReportes.add(getJMenuItemPersonalizarReporte());
			if (RolUsuarioSistema.compareToIgnoreCase("ADMIN") == 0) {

				//menuReportes.add(getJMenuItemPersonalizarReporte());
			}

		}
		return menuReportes;
	}

	/**
	 * This method initializes menuAyuda
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setText("Ayuda");
			menuAyuda.setMnemonic(KeyEvent.VK_U);
			menuAyuda.add(getItemAcercaDe());
			menuAyuda.add(getManualUsr());
		}
		return menuAyuda;
	}

	/**
	 * This method initializes itemAcercaDe
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getItemAcercaDe() {
		if (itemAcercaDe == null) {
			itemAcercaDe = new JMenuItem();
			itemAcercaDe.setText("Acerca de");
			itemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					acercaDe acercaDe1 = new acercaDe();
					acercaDe1.setBounds(0, 0, acercaDe1
							.getWidth(), acercaDe1.getHeight());
					acercaDe1.pack();
					Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
					Dimension ventana = acercaDe1.getSize();
					acercaDe1.setLocation(
				            (pantalla.width - ventana.width) /4,
				            (pantalla.height - ventana.height) / 4);
							acercaDe1.setSize(459, 229);


					jDesktopPane.add(acercaDe1);

					acercaDe1.setVisible(true);
				}
			});
		}
		return itemAcercaDe;
	}

	/**
	 * This method initializes menuInventario
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuInventario() {
		if (menuInventario == null) {
			menuInventario = new JMenu();
			menuInventario.setMnemonic(KeyEvent.VK_I);
			menuInventario.setText("Inventarios");

			if (RolUsuarioSistema.compareToIgnoreCase("ADMIN") == 0) {
				menuInventario.add(getJMenuItemBodega());
				menuInventario.add(getJMenuItemUnidadDeMedida());
				menuInventario.add(getJMenuItemTipoProducto());
				menuInventario.add(getJMenuItemProducto());
				menuInventario.setEnabled(true);
			}
			if (RolUsuarioSistema.compareToIgnoreCase("CONTABILIDAD") == 0) {
				menuInventario.setEnabled(true);
			}
			menuInventario.add(getJMenuListasProducto());
		}
		return menuInventario;
	}

	/**
	 * This method initializes menuProveedor
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuProveedor() {
		if (menuProveedor == null) {
			menuProveedor = new JMenuItem();
			menuProveedor.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_P,
					java.awt.event.InputEvent.ALT_MASK
							| java.awt.event.InputEvent.CTRL_MASK));
			menuProveedor.setText("Proveedores");
			menuProveedor
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							proveedorVentana proveedorVentana1 = new proveedorVentana();
							proveedorVentana1.setBounds(0, 0, proveedorVentana1
									.getWidth(), proveedorVentana1.getHeight());
							jDesktopPane.add(proveedorVentana1);
							proveedorVentana1.setVisible(true);
						}
					});
		}
		return menuProveedor;
	}

	/**
	 * This method initializes menuClntItem
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuClntItem() {
		if (menuClntItem == null) {
			menuClntItem = new JMenu();
			menuClntItem.setText("Clientes");
			menuClntItem.setMnemonic(KeyEvent.VK_C);
			// menuClntItem.add(getMenuTClntItem());
			menuClntItem.add(getMenuTClntItem());
			menuClntItem.add(getMenuClntIItem());
			// menuClntItem.add(getMenuClntIItem());

		}
		return menuClntItem;
	}

	/**
	 * This method initializes menuTClntItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuTClntItem() {
		if (menuTClntItem == null) {
			menuTClntItem = new JMenuItem();
			menuTClntItem.setText("Tipo de Cliente");
			menuTClntItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_T,
					java.awt.event.InputEvent.ALT_MASK
							| java.awt.event.InputEvent.CTRL_MASK));
			menuTClntItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							tipoClienteVentanaAdm tpClienteVentana = new tipoClienteVentanaAdm();
							tpClienteVentana.setBounds(0, 0, tpClienteVentana
									.getWidth(), tpClienteVentana.getHeight());
							jDesktopPane.add(tpClienteVentana);
							tpClienteVentana.setVisible(true);
						}
					});
		}
		return menuTClntItem;
	}

	/**
	 * This method initializes menuClntIItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuClntIItem() {
		if (menuClntIItem == null) {
			menuClntIItem = new JMenuItem();
			menuClntIItem.setText("Cliente");
			menuClntIItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_C,
					java.awt.event.InputEvent.ALT_MASK
							| java.awt.event.InputEvent.CTRL_MASK));
			menuClntIItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							clienteVentanaAdm ClienteVentana = new clienteVentanaAdm();
							ClienteVentana.setBounds(0, 0, ClienteVentana
									.getWidth(), ClienteVentana.getHeight());
							jDesktopPane.add(ClienteVentana);
							ClienteVentana.setVisible(true);
						}
					});
		}
		return menuClntIItem;
	}

	/**
	 * This method initializes menuEmp
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuEmp() {
		if (menuEmp == null) {
			menuEmp = new JMenu();
			menuEmp.setMnemonic(KeyEvent.VK_M);
			menuEmp.setText("Empleados");
			// menuEmp.add(getMenuEmpItem());

			menuEmp.add(getMenuEmpItem());
			menuEmp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("actionPerformed()"); // TODO
					// Auto-generated
					// Event stub
					// actionPerformed()
				}
			});
		}
		return menuEmp;
	}

	/**
	 * This method initializes menuEmpItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuEmpItem() {
		if (menuEmpItem == null) {
			menuEmpItem = new JMenuItem();
			menuEmpItem.setText("Empleados");
			menuEmpItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_M,
					java.awt.event.InputEvent.ALT_MASK
							| java.awt.event.InputEvent.CTRL_MASK));
			menuEmpItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					empleadoVentanaAdm empleadoVentanaAdm1 = new empleadoVentanaAdm();
					empleadoVentanaAdm1.setBounds(0, 0, empleadoVentanaAdm1
							.getWidth(), empleadoVentanaAdm1.getHeight());
					jDesktopPane.add(empleadoVentanaAdm1);
					empleadoVentanaAdm1.setVisible(true);
				}
			});
		}
		return menuEmpItem;
	}

	/**
	 * This method initializes menuUsuarios
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuUsuarios() {
		if (menuUsuarios == null) {
			menuUsuarios = new JMenu();
			menuUsuarios.setMnemonic(KeyEvent.VK_U);
			menuUsuarios.setText("Usuarios");
			// menuUsuarios.add(getMenuAdmUsrItem());
			menuUsuarios.add(getMenuAdmUsrItem());
			menuUsuarios.add(getJMenuItemRol());

		}
		return menuUsuarios;
	}

	/**
	 * This method initializes menulistas
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenulistas() {
		if (menulistas == null) {
			menulistas = new JMenu();
			menulistas.setText("Ventas");
			// menulistas.setEnabled(false);
			menulistas.setMnemonic(KeyEvent.VK_N);
			menulistas.add(getJMenuItmCrearRecboVentana());
			if (RolUsuarioSistema.compareToIgnoreCase("ADMIN") == 0) {
				menulistas.add(getMenuPagoFctr());
				menulistas.add(getMenuOdt());
				menulistas.add(getJMenuItemTipoREcibo());
				menulistas.setEnabled(true);

			}
			if (RolUsuarioSistema.compareToIgnoreCase("CONTABILIDAD") == 0) {
				// menulistas.add(getMenuPagoFctr());
				menulistas.add(getJMenuProforma());
				menulistas.add(getMenuOdt());
				menulistas.setEnabled(true);
			}
			menulistas.add(getJMenuItmCrearRecboVentana());
			menulistas.add(getJMenuProforma());
		}
		return menulistas;
	}

	/**
	 * This method initializes menuPagoFctr
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuPagoFctr() {
		if (menuPagoFctr == null) {
			menuPagoFctr = new JMenu();
			menuPagoFctr.setText("Cobro de Factura");
			menuPagoFctr.add(getJMenuItemtipoDePago());
			// menuPagoFctr.add(getMenuPagoFctrItem());

		}
		return menuPagoFctr;
	}

	/**
	 * This method initializes menuOdt
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuOdt() {
		if (menuOdt == null) {
			menuOdt = new JMenu();
			menuOdt.setMnemonic(KeyEvent.VK_O);
			menuOdt.setText("Ordenes de Trabajo");
			menuOdt.add(getJMenuItemTipoTrabajo());
			menuOdt.add(getJMenuItemOrdenDeTranajo());

		}
		return menuOdt;
	}

	/**
	 * This method initializes menuRcdtrAltr
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuRcdtrAltr() {
		if (menuRcdtrAltr == null) {
			menuRcdtrAltr = new JMenu();
			menuRcdtrAltr.setText("Recordatorios Y Alertas");
			menuRcdtrAltr.add(getJMenuItemCrearAlerta());
			menuRcdtrAltr.add(getMenuAltrLista());

		}
		return menuRcdtrAltr;
	}

	/**
	 * This method initializes menuAltrLista
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuAltrLista() {
		if (menuAltrLista == null) {
			menuAltrLista = new JMenuItem();
			menuAltrLista.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_L,
					java.awt.event.InputEvent.ALT_MASK
							| java.awt.event.InputEvent.CTRL_MASK));
			menuAltrLista.setText("Lista de Alertas Existentes");
			menuAltrLista
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {

							ListaDeAlertasVentana ListaDeAlertasVentana1 = new ListaDeAlertasVentana();
							ListaDeAlertasVentana1.setBounds(0, 0,
									ListaDeAlertasVentana1.getWidth(),
									ListaDeAlertasVentana1.getHeight());
							jDesktopPane.add(ListaDeAlertasVentana1);
							ListaDeAlertasVentana1.setVisible(true);
						}
					});
		}
		return menuAltrLista;
	}

	/**
	 * This method initializes menuAdmUsrItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuAdmUsrItem() {
		if (menuAdmUsrItem == null) {
			menuAdmUsrItem = new JMenuItem();
			menuAdmUsrItem.setText("Usuarios del Sistema");
			menuAdmUsrItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_U,
					java.awt.event.InputEvent.ALT_MASK
							| java.awt.event.InputEvent.CTRL_MASK));
			menuAdmUsrItem
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							usuariosDelSistemaVentana usuariosDelSistemaVentana1 = new usuariosDelSistemaVentana();
							usuariosDelSistemaVentana1.setBounds(0, 0,
									usuariosDelSistemaVentana1.getWidth(),
									usuariosDelSistemaVentana1.getHeight());
							jDesktopPane.add(usuariosDelSistemaVentana1);
							usuariosDelSistemaVentana1.setVisible(true);
						}
					});
		}
		return menuAdmUsrItem;
	}

	/**
	 * This method initializes manualUsr
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getManualUsr() {
		if (manualUsr == null) {
			manualUsr = new JMenuItem();
			manualUsr.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
					java.awt.event.KeyEvent.VK_H,
					java.awt.event.InputEvent.ALT_MASK
							| java.awt.event.InputEvent.CTRL_MASK));
			manualUsr.setText("Manual de Usuario");
			manualUsr.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					try {
						URL hsURL = this.getClass().getResource(
								"/ayuda/sga.hs");
						HelpSet helpset = null;
						helpset = new HelpSet(null, hsURL);

						JHelp help = new JHelp(helpset);
						final JFrame frame = new JFrame("Ayuda del sistema v 3.7");
						JPanel panel = new JPanel(new GridLayout());
						panel.add(help);
						frame.setContentPane(panel);
						help.setNavigatorDisplayed(true);
						frame.setTitle("Ayuda del sistema");
						frame.setLocation(getLocation());
						frame.pack();
						frame.setVisible(true);
						frame.addWindowListener(new WindowAdapter() {
							@Override
							public void windowClosing(
									java.awt.event.WindowEvent evt) {
								frame.setVisible(false);
							}
						});
					} catch (Exception ex) {
						ex.printStackTrace();
					}

				}
			});
		}
		return manualUsr;
	}

	/**
	 * This method initializes jMenuItmCrearRecboVentana
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItmCrearRecboVentana() {
		if (jMenuItmCrearRecboVentana == null) {
			jMenuItmCrearRecboVentana = new JMenuItem();
			jMenuItmCrearRecboVentana.setText("Crear Recibo de Venta");
			jMenuItmCrearRecboVentana.setAccelerator(javax.swing.KeyStroke
					.getKeyStroke(java.awt.event.KeyEvent.VK_R,
							java.awt.event.InputEvent.ALT_MASK
									| java.awt.event.InputEvent.CTRL_MASK));
			jMenuItmCrearRecboVentana
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							reciboVentana reciboVentanaW = new reciboVentana(
									"", false, "", false, userName,
									jDesktopPane, new Float(0));
							reciboVentanaW.getPreferredSize();
							jDesktopPane.add(reciboVentanaW);
							reciboVentanaW.setVisible(true);

						}
					});
		}
		return jMenuItmCrearRecboVentana;
	}

	/**
	 * This method initializes jMenuItemTipoTrabajo
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemTipoTrabajo() {
		if (jMenuItemTipoTrabajo == null) {
			jMenuItemTipoTrabajo = new JMenuItem();
			jMenuItemTipoTrabajo.setText("Tipo De Trabajo");
			jMenuItemTipoTrabajo.setAccelerator(javax.swing.KeyStroke
					.getKeyStroke(java.awt.event.KeyEvent.VK_I,
							java.awt.event.InputEvent.ALT_MASK
									| java.awt.event.InputEvent.CTRL_MASK));
			jMenuItemTipoTrabajo
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							tipoTrabajoVentana tipoTrabajoVentana1 = new tipoTrabajoVentana();
							tipoTrabajoVentana1.setBounds(0, 0,
									tipoTrabajoVentana1.getWidth(),
									tipoTrabajoVentana1.getHeight());
							jDesktopPane.add(tipoTrabajoVentana1);
							tipoTrabajoVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemTipoTrabajo;
	}

	/**
	 * This method initializes jMenuItemOrdenDeTranajo
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemOrdenDeTranajo() {
		if (jMenuItemOrdenDeTranajo == null) {
			jMenuItemOrdenDeTranajo = new JMenuItem();
			jMenuItemOrdenDeTranajo.setText("Crear Orden de Trabajo");
			jMenuItemOrdenDeTranajo.setAccelerator(javax.swing.KeyStroke
					.getKeyStroke(java.awt.event.KeyEvent.VK_E,
							java.awt.event.InputEvent.ALT_MASK
									| java.awt.event.InputEvent.CTRL_MASK));
			jMenuItemOrdenDeTranajo
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ordenDetrabajoVentana ordenDetrabajoVentana1 = new ordenDetrabajoVentana(
									userName);
							ordenDetrabajoVentana1.setBounds(0, 0,
									ordenDetrabajoVentana1.getWidth(),
									ordenDetrabajoVentana1.getHeight());
							jDesktopPane.add(ordenDetrabajoVentana1);
							ordenDetrabajoVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemOrdenDeTranajo;
	}

	/**
	 * This method initializes jMenuItemUnidadDeMedida
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemUnidadDeMedida() {
		if (jMenuItemUnidadDeMedida == null) {
			jMenuItemUnidadDeMedida = new JMenuItem();
			jMenuItemUnidadDeMedida.setAccelerator(javax.swing.KeyStroke
					.getKeyStroke(java.awt.event.KeyEvent.VK_S,
							java.awt.event.InputEvent.ALT_MASK
									| java.awt.event.InputEvent.CTRL_MASK));
			jMenuItemUnidadDeMedida.setText("Unidad de Medida");
			jMenuItemUnidadDeMedida
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							unidadMedidaVentana unidadMedidaVentana1 = new unidadMedidaVentana();
							unidadMedidaVentana1.setBounds(0, 0,
									unidadMedidaVentana1.getWidth(),
									unidadMedidaVentana1.getHeight());
							jDesktopPane.add(unidadMedidaVentana1);
							unidadMedidaVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemUnidadDeMedida;
	}

	/**
	 * This method initializes jMenuItemTipoProducto
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemTipoProducto() {
		if (jMenuItemTipoProducto == null) {
			jMenuItemTipoProducto = new JMenuItem();
			jMenuItemTipoProducto.setAccelerator(javax.swing.KeyStroke
					.getKeyStroke(java.awt.event.KeyEvent.VK_A,
							java.awt.event.InputEvent.ALT_MASK
									| java.awt.event.InputEvent.CTRL_MASK));
			jMenuItemTipoProducto.setText("Tipo De Producto");
			jMenuItemTipoProducto
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							tipoProductoVentana tipoDeProductoVentana1 = new tipoProductoVentana();
							tipoDeProductoVentana1.setBounds(0, 0,
									tipoDeProductoVentana1.getWidth(),
									tipoDeProductoVentana1.getHeight());
							jDesktopPane.add(tipoDeProductoVentana1);
							tipoDeProductoVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemTipoProducto;
	}

	/**
	 * This method initializes jMenuItemProducto
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemProducto() {
		if (jMenuItemProducto == null) {
			jMenuItemProducto = new JMenuItem();
			jMenuItemProducto.setMnemonic(KeyEvent.VK_B);
			jMenuItemProducto.setText("Producto");
			jMenuItemProducto
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							inventarioVentana productoVentana1 = new inventarioVentana(
									userName, false, null, jDesktopPane);
							productoVentana1.setBounds(0, 0, productoVentana1
									.getWidth(), productoVentana1.getHeight());
							jDesktopPane.add(productoVentana1);
							productoVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemProducto;
	}

	/**
	 * This method initializes jMenuItemPagoRealizadoCompra
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemPagoRealizadoCompra() {
		if (jMenuItemPagoRealizadoCompra == null) {
			jMenuItemPagoRealizadoCompra = new JMenuItem();
			// jMenuItemCobrodefactura.setMnemonic(KeyEvent.VK_P);
			jMenuItemPagoRealizadoCompra
					.setText("Registrar documento de Importación");
			jMenuItemPagoRealizadoCompra
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							pagoRealizadoCompraVentana pagoRealizadoCompraVentana1 = new pagoRealizadoCompraVentana();
							pagoRealizadoCompraVentana1.setBounds(0, 0,
									pagoRealizadoCompraVentana1.getWidth(),
									pagoRealizadoCompraVentana1.getHeight());
							jDesktopPane.add(pagoRealizadoCompraVentana1);
							pagoRealizadoCompraVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemPagoRealizadoCompra;
	}

	/**
	 * This method initializes jMenuItemSetup
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemSetup() {
		if (jMenuItemSetup == null) {
			jMenuItemSetup = new JMenuItem();
			// jMenuItemCobrodefactura.setMnemonic(KeyEvent.VK_S);
			jMenuItemSetup.setText("Configurar Software");
			jMenuItemSetup
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							setupVentana setupVentana1 = new setupVentana();
							setupVentana1.setBounds(0, 0, setupVentana1
									.getWidth(), setupVentana1.getHeight());
							jDesktopPane.add(setupVentana1);
							setupVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemSetup;
	}

	/**
	 * This method initializes jMenuProforma
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuProforma() {
		if (jMenuProforma == null) {
			jMenuProforma = new JMenu();
			jMenuProforma.setText("Proformas");
			// jMenuProforma.add(getJMenuItemCrearProforma());
			jMenuProforma.add(getJMenuItemCrearProforma());
		}
		return jMenuProforma;
	}

	/**
	 * This method initializes jMenuItemCrearProforma
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCrearProforma() {
		if (jMenuItemCrearProforma == null) {
			jMenuItemCrearProforma = new JMenuItem();
			jMenuItemCrearProforma.setText("Crear Proforma");
			jMenuItemCrearProforma
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							proformaVentana proformaVentanaW = new proformaVentana();
							proformaVentanaW.getPreferredSize();
							jDesktopPane.add(proformaVentanaW);
							proformaVentanaW.setVisible(true);
						}
					});
		}
		return jMenuItemCrearProforma;
	}

	/**
	 * This method initializes jMenuItemCrearAlerta
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCrearAlerta() {
		if (jMenuItemCrearAlerta == null) {
			jMenuItemCrearAlerta = new JMenuItem();
			jMenuItemCrearAlerta.setMnemonic(KeyEvent.VK_R);
			jMenuItemCrearAlerta.setText("Crear una Alerta y/o Recordatorio");
			jMenuItemCrearAlerta
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							alertaRecordatorioVentana alertaRecordatorioVentana1 = new alertaRecordatorioVentana();
							alertaRecordatorioVentana1.setBounds(0, 0,
									alertaRecordatorioVentana1.getWidth(),
									alertaRecordatorioVentana1.getHeight());
							jDesktopPane.add(alertaRecordatorioVentana1);
							alertaRecordatorioVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemCrearAlerta;
	}

	/**
	 * This method initializes jMenuItemtipoDePago
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemtipoDePago() {
		if (jMenuItemtipoDePago == null) {
			jMenuItemtipoDePago = new JMenuItem();
			jMenuItemtipoDePago.setText("Tipo De Pago");
			jMenuItemtipoDePago
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							tipoPagoVentana tipoPagoVentana1 = new tipoPagoVentana();
							tipoPagoVentana1.setBounds(0, 0, tipoPagoVentana1
									.getWidth(), tipoPagoVentana1.getHeight());
							jDesktopPane.add(tipoPagoVentana1);
							tipoPagoVentana1.setVisible(true);
						}
					});
		}
		return jMenuItemtipoDePago;
	}

	/**
	 * This method initializes jToolBarAccesosRapidos
	 *
	 * @return javax.swing.JToolBar
	 */
	private JToolBar getJToolBarAccesosRapidos() {
		if (jToolBarAccesosRapidos == null) {
			jLabeBlanco31 = new JLabel();
			jLabeBlanco31.setText("         ");
			jLabeBlanco3 = new JLabel();
			jLabeBlanco3.setText("         ");
			jToolBarAccesosRapidos = new JToolBar();
			jToolBarAccesosRapidos.setName("Barra de Herramientas");
			jToolBarAccesosRapidos.setToolTipText("Barra de herramientas");
			jToolBarAccesosRapidos.setOrientation(JToolBar.HORIZONTAL);
			jToolBarAccesosRapidos.add(getJButton2());
			jToolBarAccesosRapidos.add(getJButton1());
			jToolBarAccesosRapidos.add(getJButton());
			jToolBarAccesosRapidos.add(jLabeBlanco31);
			jToolBarAccesosRapidos.add(getJButtonCortar());
			jToolBarAccesosRapidos.add(getJButtonCopy());
			jToolBarAccesosRapidos.add(getJButtonPaste());
			jToolBarAccesosRapidos.add(jLabeBlanco3);
			jToolBarAccesosRapidos.add(getJButtonUsuario());
			jToolBarAccesosRapidos.add(getJLabel());
		}
		return jToolBarAccesosRapidos;
	}

	/**
	 * This method initializes jButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setBounds(new Rectangle(28, 1, 80, 80));
			jButton.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/PPico3.png")));
			jButton
					.setToolTipText("Muestra la Administración de recibos de venta");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					reciboVentana ventana2 = new reciboVentana("", false, "",
							false, userName, jDesktopPane, new Float(0));
					ventana2.getPreferredSize();
					jDesktopPane.add(ventana2);
					ventana2.setVisible(true);
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jMenuItem
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem() {
		if (menuCambiarUsuario == null) {
			menuCambiarUsuario = new JMenuItem();
			menuCambiarUsuario.setText("Cambiar De Usuario");
			// menuRprtFctrItem.setMnemonic(KeyEvent.VK_A);
			menuCambiarUsuario.setActionCommand("");
			menuCambiarUsuario
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cerrarPadre();
							DialogUsuario dialogoUsuarios = new DialogUsuario();
							dialogoUsuarios.getPreferredSize();
							dialogoUsuarios.setLocationRelativeTo(null);
							dialogoUsuarios.setVisible(true);
						}
					});
		}
		return menuCambiarUsuario;
	}

	/**
	 * This method initializes jButton1
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton1() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/PPico2.png")));
			jButton1.setToolTipText("Muestra la lista de productos");
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					listaInventarioVentana ventana = new listaInventarioVentana(
							userName, RolUsuarioSistema, jDesktopPane);
					jDesktopPane.add(ventana);
					ventana.getPreferredSize();
					ventana.setVisible(true);
				}
			});
		}
		return jButton1;
	}

	/**
	 * This method initializes jButton2
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButton2() {
		if (jButton2 == null) {
			jButton2 = new JButton();
			jButton2.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/PPico1.png")));
			jButton2
					.setToolTipText("Muesta la pantalla de recibos, proformas y ODT del sistema");
			jButton2.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					listaProformasVentana listaProformasVentanaw = new listaProformasVentana(
							userName, jDesktopPane);
					listaProformasVentanaw.getPreferredSize();
					jDesktopPane.add(listaProformasVentanaw);
					listaProformasVentanaw.setVisible(true);
				}
			});
		}
		return jButton2;
	}

	/**
	 * This method initializes jMenuOrdenesTrabajo
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuOrdenesTrabajo() {
		if (jMenuOrdenesTrabajo == null) {
			jMenuOrdenesTrabajo = new JMenuItem();
			jMenuOrdenesTrabajo.setText("Lista de Recibos");
			jMenuOrdenesTrabajo
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							listaProformasVentana listaProformasVentanaW = new listaProformasVentana(
									userName, jDesktopPane);
							listaProformasVentanaW.getPreferredSize();
							jDesktopPane.add(listaProformasVentanaW);
							listaProformasVentanaW.setVisible(true);
						}
					});
		}
		return jMenuOrdenesTrabajo;
	}

	/**
	 * This method initializes jMenuProveedores
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuProveedores() {
		if (jMenuProveedores == null) {
			jMenuProveedores = new JMenuItem();
			jMenuProveedores.setText("Listar Proveedores");
			jMenuProveedores
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							listaProveedoresVentana listaProveedoresVentanaW = new listaProveedoresVentana();
							listaProveedoresVentanaW.getPreferredSize();
							jDesktopPane.add(listaProveedoresVentanaW);
							listaProveedoresVentanaW.setVisible(true);
						}
					});
		}
		return jMenuProveedores;
	}

	/**
	 * This method initializes jMenuListaEmpleados
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuListaEmpleados() {
		if (jMenuListaEmpleados == null) {
			jMenuListaEmpleados = new JMenuItem();
			jMenuListaEmpleados.setText("Listar Empleados");
			jMenuListaEmpleados
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							listaEmpVentana listaEmpVentanaW = new listaEmpVentana();
							listaEmpVentanaW.getPreferredSize();
							jDesktopPane.add(listaEmpVentanaW);
							listaEmpVentanaW.setVisible(true);
						}
					});
		}
		return jMenuListaEmpleados;
	}

	/**
	 * This method initializes jMenuItemListaProductos
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemListaProductos() {
		if (jMenuItemListaProductos == null) {
			jMenuItemListaProductos = new JMenuItem();
			jMenuItemListaProductos.setText("Lista de Productos de inventario");
			jMenuItemListaProductos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							listaInventarioVentana listaInventarioVentanaW = new listaInventarioVentana(
									userName, RolUsuarioSistema, jDesktopPane);
							listaInventarioVentanaW.getPreferredSize();
							jDesktopPane.add(listaInventarioVentanaW);
							listaInventarioVentanaW.setVisible(true);
						}
					});
		}
		return jMenuItemListaProductos;
	}

	/**
	 * This method initializes jMenuListasProducto
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuListasProducto() {
		if (jMenuListasProducto == null) {
			jMenuListasProducto = new JMenu();
			jMenuListasProducto.setText("Lista de productos");
			jMenuListasProducto.add(getJMenuItemListaProductos());
		}
		return jMenuListasProducto;
	}

	/**
	 * This method initializes jMenuConsultas
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuConsultas() {
		if (jMenuConsultas == null) {
			jMenuConsultas = new JMenu();
			jMenuConsultas.setText("Consultas");

			if (RolUsuarioSistema.compareToIgnoreCase("ADMIN") == 0) {
				jMenuConsultas.add(getJMenuListaClientes());
				jMenuConsultas.add(getJMenuListaEmpleados());
				jMenuConsultas.add(getJMenuProveedores());
				jMenuConsultas.add(getJMenuReportePersonalizado());
				jMenuConsultas.setEnabled(true);
				jMenuConsultas.add(getJMenuItemConsultaReciboCompra());
				jMenuConsultas.add(getJMenuItemConsultarCompras());


			}
			if (RolUsuarioSistema.compareToIgnoreCase("CONTABILIDAD") == 0) {
				jMenuConsultas.add(getJMenuListaEmpleados());
				jMenuConsultas.add(getJMenuItemConsultaReciboCompra());
				jMenuConsultas.setEnabled(true);
			}
			jMenuConsultas.add(getJMenuOrdenesTrabajo());


		}
		return jMenuConsultas;
	}

	/**
	 * This method initializes jMenuListaClientes
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuListaClientes() {
		if (jMenuListaClientes == null) {
			jMenuListaClientes = new JMenuItem();
			jMenuListaClientes.setText("Lista de Clientes");
			jMenuListaClientes
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {

							listaClientesVentana listaClientesVentanaW = new listaClientesVentana(
									jDesktopPane);
							listaClientesVentanaW.getPreferredSize();
							jDesktopPane.add(listaClientesVentanaW);
							listaClientesVentanaW.setVisible(true);
						}
					});
		}
		return jMenuListaClientes;
	}

	/**
	 * This method initializes jMenuBancos
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuBancos() {
		if (jMenuBancos == null) {
			jMenuBancos = new JMenuItem();
			jMenuBancos.setText("Bancos");
			jMenuBancos.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					bancosVentana bancosVentanaW = new bancosVentana();
					bancosVentanaW.getPreferredSize();
					jDesktopPane.add(bancosVentanaW);

					bancosVentanaW.setVisible(true);
				}
			});
		}
		return jMenuBancos;
	}

	/**
	 * This method initializes jMenuItemBodega
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemBodega() {
		if (jMenuItemBodega == null) {
			jMenuItemBodega = new JMenuItem();
			jMenuItemBodega.setText("Bodega");
			jMenuItemBodega
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							bodegaVentana bodegaVentanaW = new bodegaVentana();
							jDesktopPane.add(bodegaVentanaW);
							bodegaVentanaW.getPreferredSize();
							bodegaVentanaW.setVisible(true);
						}
					});
		}
		return jMenuItemBodega;
	}

	/**
	 * This method initializes jMenuItemREciboCompra
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemREciboCompra() {
		if (jMenuItemREciboCompra == null) {
			jMenuItemREciboCompra = new JMenuItem();
			jMenuItemREciboCompra.setText("Compras y Gastos");
			jMenuItemREciboCompra
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							comprasGastosVentana comprasGastosVentanaW = new comprasGastosVentana();
							comprasGastosVentanaW.getPreferredSize();
							jDesktopPane.add(comprasGastosVentanaW);
							comprasGastosVentanaW.setVisible(true);
						}
					});
		}
		return jMenuItemREciboCompra;
	}

	/**
	 * This method initializes jMenuBanco
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuBanco() {
		if (jMenuBanco == null) {
			jMenuBanco = new JMenu();
			jMenuBanco.setText("Bancos");
			jMenuBanco.add(getJMenuBancos());
			jMenuBanco.add(getJMenuItemCuentas());
		}
		return jMenuBanco;
	}

	/**
	 * This method initializes jMenuItemCuentas
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCuentas() {
		if (jMenuItemCuentas == null) {
			jMenuItemCuentas = new JMenuItem();
			jMenuItemCuentas.setText("Cuentas Bancarias");
			jMenuItemCuentas
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							cuentasBancosVentana cuentasBancosVentanaW = new cuentasBancosVentana();
							cuentasBancosVentanaW.getPreferredSize();
							jDesktopPane.add(cuentasBancosVentanaW);
							cuentasBancosVentanaW.setVisible(true);

						}
					});
		}
		return jMenuItemCuentas;
	}

	/**
	 * This method initializes jMenuPagoProveedor
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuPagoProveedor() {
		if (jMenuPagoProveedor == null) {
			jMenuPagoProveedor = new JMenu();
			jMenuPagoProveedor.setText("Proveedores");
			jMenuPagoProveedor.add(getJMenuItem1());
		}
		return jMenuPagoProveedor;
	}

	/**
	 * This method initializes jMenuItem1
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItem1() {
		if (jMenuItem1 == null) {
			jMenuItem1 = new JMenuItem();
			jMenuItem1.setText("Pago a Proveedor");
			jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					pagoPorGastoVentanaAdm pagoPorGastoVentanaAdmW = new pagoPorGastoVentanaAdm(
							jDesktopPane);
					pagoPorGastoVentanaAdmW.getPreferredSize();
					jDesktopPane.add(pagoPorGastoVentanaAdmW);
					pagoPorGastoVentanaAdmW.setVisible(true);

				}
			});
		}
		return jMenuItem1;
	}

	/**
	 * This method initializes jMenuItemTipoREcibo
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemTipoREcibo() {
		if (jMenuItemTipoREcibo == null) {
			jMenuItemTipoREcibo = new JMenuItem();
			jMenuItemTipoREcibo.setText("Tipo de Recibo");
			jMenuItemTipoREcibo
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							tipoReciboVentana tipoReciboVentanaW = new tipoReciboVentana();
							tipoReciboVentanaW.getPreferredSize();
							jDesktopPane.add(tipoReciboVentanaW);
							tipoReciboVentanaW.setVisible(true);

						}
					});
		}
		return jMenuItemTipoREcibo;
	}

	/**
	 * This method initializes jMenuItemParamImpresion
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemParamImpresion() {
		if (jMenuItemParamImpresion == null) {
			jMenuItemParamImpresion = new JMenuItem();
			jMenuItemParamImpresion.setText("Parametros de Impresión");
			jMenuItemParamImpresion
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							configurarParametrosdeImpresionRecibos configurarParametrosdeImpresionRecibosW = new configurarParametrosdeImpresionRecibos();
							configurarParametrosdeImpresionRecibosW
									.getPreferredSize();
							jDesktopPane
									.add(configurarParametrosdeImpresionRecibosW);
							configurarParametrosdeImpresionRecibosW
									.setVisible(true);
						}
					});
		}
		return jMenuItemParamImpresion;
	}

	/**
	 * This method initializes jLabel
	 *
	 * @return javax.swing.JLabel
	 */
	private JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new JLabel();
			jLabel.setText("No hay Mensajes pendientes ");
			jLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			jLabel.setToolTipText("Hacer Click para actualizar los mensajes");
			jLabel.setForeground(Color.blue);
			jLabel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseExited(java.awt.event.MouseEvent e) {
					jLabel.setForeground(Color.blue);
				}

				public void mouseEntered(java.awt.event.MouseEvent e) {
					jLabel.setForeground(Color.red);
				}

				public void mouseClicked(java.awt.event.MouseEvent e) {
					actualizarMensajes();
					if (pedirConfirmacion() == 0) {
						ListaDeAlertasVentana ListaDeAlertasVentanaW = new ListaDeAlertasVentana();
						ListaDeAlertasVentanaW.getPreferredSize();
						jDesktopPane.add(ListaDeAlertasVentanaW);
						ListaDeAlertasVentanaW.setVisible(true);
					}
				}
			});
		}
		return jLabel;
	}

	/**
	 * This method initializes jMenuItemRol
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemRol() {
		if (jMenuItemRol == null) {
			jMenuItemRol = new JMenuItem();
			jMenuItemRol.setSize(new Dimension(77, 20));
			jMenuItemRol.setText("Rol de Usuario");
			jMenuItemRol.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					rolVentanaAdm rolVentanaAdmW = new rolVentanaAdm();
					rolVentanaAdmW.getPreferredSize();
					jDesktopPane.add(rolVentanaAdmW);
					rolVentanaAdmW.setVisible(true);
				}
			});
		}
		return jMenuItemRol;
	}

	/**
	 * This method initializes jButtonCopy
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCopy() {
		if (jButtonCopy == null) {
			jButtonCopy = new JButton(new DefaultEditorKit.CopyAction());
			jButtonCopy.setText("");

			jButtonCopy.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/copyicon.gif")));
		}
		return jButtonCopy;
	}

	/**
	 * This method initializes jButtonPaste
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonPaste() {
		if (jButtonPaste == null) {
			jButtonPaste = new JButton(new DefaultEditorKit.PasteAction());
			jButtonPaste.setText("");
			jButtonPaste.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/pasteicon.gif")));
		}
		return jButtonPaste;
	}

	/**
	 * This method initializes jButtonCortar
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonCortar() {
		if (jButtonCortar == null) {
			jButtonCortar = new JButton(new DefaultEditorKit.CutAction());
			jButtonCortar.setText("");
			jButtonCortar.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/cuticon.gif")));
		}
		return jButtonCortar;
	}

	/**
	 * This method initializes jButtonUsuario
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getJButtonUsuario() {
		if (jButtonUsuario == null) {
			jButtonUsuario = new JButton();
			jButtonUsuario.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/usuario.png")));
			jButtonUsuario.setToolTipText("Cambiar de Usuario");
			jButtonUsuario.setBounds(new Rectangle(277, 1, 39, 36));
			jButtonUsuario.setHorizontalTextPosition(SwingConstants.CENTER);
			jButtonUsuario
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							DialogUsuario dialogoUsuarios = new DialogUsuario();
							dialogoUsuarios.getPreferredSize();
							dialogoUsuarios.setLocationRelativeTo(null);
							dialogoUsuarios.setVisible(true);
						}
					});
		}
		return jButtonUsuario;
	}

	/**
	 * This method initializes jMenuReportePersonalizado
	 *
	 * @return javax.swing.JMenu
	 */
	private JMenu getJMenuReportePersonalizado() {
		if (jMenuReportePersonalizado == null) {
			jMenuReportePersonalizado = new JMenu();
			jMenuReportePersonalizado.setText("Consulta Personalizadas");
			jMenuReportePersonalizado.add(getJMenuItemConsultaPersonalizada());
		}
		return jMenuReportePersonalizado;
	}

	/**
	 * This method initializes jMenuItemConsultaPersonalizada
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaPersonalizada() {
		if (jMenuItemConsultaPersonalizada == null) {
			jMenuItemConsultaPersonalizada = new JMenuItem();
			jMenuItemConsultaPersonalizada
					.setText("Consultas Personalizadas de ODT y Proformas");
			jMenuItemConsultaPersonalizada
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ConsultaPorParametros ConsultaPorParametrosW = new ConsultaPorParametros(
									userName, jDesktopPane);
							ConsultaPorParametrosW.getPreferredSize();
							jDesktopPane.add(ConsultaPorParametrosW);
							jDesktopPane.doLayout();
							ConsultaPorParametrosW.setVisible(true);
						}
					});
		}
		return jMenuItemConsultaPersonalizada;
	}

	/**
	 * This method initializes jMenuItemReporteProductos
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemReporteProductos() {
		if (jMenuItemReporteProductos == null) {
			jMenuItemReporteProductos = new JMenuItem();
			jMenuItemReporteProductos.setText("Reporte de Productos");
			jMenuItemReporteProductos
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							mostrarReporteProductosDialog mostrarReporteProductosDialogDialog = new mostrarReporteProductosDialog();
							mostrarReporteProductosDialogDialog
									.getPreferredSize();
							mostrarReporteProductosDialogDialog.setLocation(
									getX() / 2, getY() / 2);
							// jDesktopPane.add(mostrarReporteProductosDialogDialog);
							mostrarReporteProductosDialogDialog
									.setVisible(true);
						}
					});
		}
		return jMenuItemReporteProductos;
	}

	/**
	 * This method initializes jMenuItemPersonalizarReporte
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemPersonalizarReporte() {
		if (jMenuItemPersonalizarReporte == null) {
			jMenuItemPersonalizarReporte = new JMenuItem();
			jMenuItemPersonalizarReporte.setText("Personalizar reporte");
			jMenuItemPersonalizarReporte
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							personalizarReporte personalizarReporteW = new personalizarReporte();
							personalizarReporteW.getPreferredSize();
							personalizarReporteW.setLocation(100, 100);
							personalizarReporteW.setVisible(true);
						}
					});
		}
		return jMenuItemPersonalizarReporte;
	}

	/**
	 * This method initializes jDesktopPane
	 *
	 * @return javax.swing.JDesktopPane
	 */
	private JDesktopPane getJDesktopPane() {
		if (jDesktopPane == null) {
			jDesktopPane = new JDesktopPane();
		}
		return jDesktopPane;
	}

	/**
	 * This method initializes jScrollPane
	 *
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane
					.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jScrollPane
					.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jScrollPane.setViewportView(getJDesktopPane());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jMenuItemConsultaReciboCompra
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultaReciboCompra() {
		if (jMenuItemConsultaReciboCompra == null) {
			jMenuItemConsultaReciboCompra = new JMenuItem();
			jMenuItemConsultaReciboCompra
					.setText("Pagos realizados por gastos");
			jMenuItemConsultaReciboCompra
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							VentanaConsultaPagos VentanaFacuraCompra = new VentanaConsultaPagos(
									userName, jDesktopPane);
							VentanaFacuraCompra.getPreferredSize();
							jDesktopPane.add(VentanaFacuraCompra);
							VentanaFacuraCompra.setVisible(true);
						}
					});
		}
		return jMenuItemConsultaReciboCompra;
	}

	/**
	 * This method initializes jMenuItemConsultarCompras
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemConsultarCompras() {
		if (jMenuItemConsultarCompras == null) {
			jMenuItemConsultarCompras = new JMenuItem();
			jMenuItemConsultarCompras.setText("Consultar Pagos según la compra ");
			jMenuItemConsultarCompras
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							ConsultaPagosporCompras ConsultaPagosporComprasVentana = new ConsultaPagosporCompras(
									userName, jDesktopPane);
							ConsultaPagosporComprasVentana.getPreferredSize();
							jDesktopPane.add(ConsultaPagosporComprasVentana);
							ConsultaPagosporComprasVentana.setVisible(true);
						}
					});
		}
		return jMenuItemConsultarCompras;
	}

	/**
	 * This method initializes jMenuItemCuentasCobrar
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemCuentasCobrar() {
		if (jMenuItemCuentasCobrar == null) {
			jMenuItemCuentasCobrar = new JMenuItem();
			jMenuItemCuentasCobrar.setSize(new Dimension(78, 19));
			jMenuItemCuentasCobrar.setText("Cuentas por cobrar");
			jMenuItemCuentasCobrar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					CuentasPorCobrarVentana AdmCuentasPorCobrarVentana = new CuentasPorCobrarVentana();
					AdmCuentasPorCobrarVentana.getPreferredSize();
					jDesktopPane.add(AdmCuentasPorCobrarVentana);
					AdmCuentasPorCobrarVentana.setVisible(true);
				}
			});
		}
		return jMenuItemCuentasCobrar;
	}

	/**
	 * This method initializes jMenuItemRespaldarInformaciom
	 *
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getJMenuItemRespaldarInformaciom() {
		if (jMenuItemRespaldarInformaciom == null) {
			jMenuItemRespaldarInformaciom = new JMenuItem();
			jMenuItemRespaldarInformaciom.setText("Respaldar");
			jMenuItemRespaldarInformaciom
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							RespaldarInformacion RespaldarInformacion1 = new RespaldarInformacion();
							RespaldarInformacion1.getPreferredSize();
							jDesktopPane.add(RespaldarInformacion1);
							RespaldarInformacion1.setVisible(true);
						}
					});
		}
		return jMenuItemRespaldarInformaciom;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				/*
				 * PantallaPrincipal thisClass = new
				 * PantallaPrincipal("asda","");
				 * thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 * thisClass.setViible(true);
				 */
				DialogUsuario dialogoUsuarios = new DialogUsuario();
				dialogoUsuarios.getPreferredSize();
				dialogoUsuarios.setLocationRelativeTo(null);
				dialogoUsuarios.setVisible(true);

			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public PantallaPrincipal(String usuario, String rolUsuario) {
		super();
		initialize(usuario, rolUsuario);
		actualizarMensajes();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize);

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				cerrar();
			}
		});
		// validarUsuario(userName,RolUsuarioSistema);
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize(String usuario, String RolUsuario1) {
		this.setSize(757, 430);
		userName = usuario;// recibe el nombre de usuario
		RolUsuarioSistema = RolUsuario1;
		this.setLocale(null);
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				getClass().getResource("/images/logoLogin.JPG")));
		this.setJMenuBar(getJJMenuBar());
		this.setContentPane(getJContentPane());
		this.setTitle("Sistema Contable 4.4 MakroVentas");
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(4);
			borderLayout.setVgap(4);
			jLabelUsuario = new JLabel();
			jLabelUsuario
					.setText("Bienvenido :"+userName+"                                     Tipo de Sesión : "+RolUsuarioSistema+"          ");
			jLabelUsuario.setDisplayedMnemonic(KeyEvent.VK_UNDEFINED);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout);
			jContentPane.add(jLabelUsuario, BorderLayout.SOUTH);
			jContentPane.add(getJToolBarAccesosRapidos(), BorderLayout.NORTH);
			// jContentPane.add(getJDesktopPane(), BorderLayout.CENTER);
			jContentPane.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	public void cerrarPadre() {
		this.dispose();
	}

	/**
	 * Actualiza los mensajes y alertas del sistema
	 */
	public void actualizarMensajes() {
		conexionBdd con = new conexionBdd();
		alertasBdd alertasMd = new alertasBdd();
		int cant = alertasMd.ultimasAlertasDelSistema(con.getConexion());
		if (cant == 0)
			jLabel.setText("No hay Mensajes pendientes ");
		else
			jLabel.setText("Mensajes pendientes : " + cant);
	}

	/**
	 * ç muestra mensaje de confirmación para ingresar a la lista de alertas
	 *
	 * @return
	 */

	int pedirConfirmacion() {
		int res = 1;
		res = JOptionPane.showConfirmDialog(this,
				"Desea Revisar el panel de Mensajes y alertas?",
				"Confirmar acción", JOptionPane.YES_NO_OPTION);
		if (res == 0) {
			res = 0;

		}

		return res;
	}

	public int getX() {
		int x = this.getWidth();
		return x;
	}

	/**
	 * cierra la ventana
	 */
	public void cerrar() {
		this.setVisible(false);
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dispose();
	}

	public int getY() {
		int y = this.getHeight();
		return y;
	}

} // @jve:decl-index=0:visual-constraint="-3,0"
