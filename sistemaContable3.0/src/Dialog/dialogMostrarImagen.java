package Dialog;

import java.awt.Rectangle;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import org.jdesktop.swingworker.SwingWorker;

import ventanas.mostrarImagen;

public class dialogMostrarImagen extends JFrame {

	private JPanel jContentPane = null;
	private JButton btnStartWorker = null;
	private JLabel jLabel = null;
	private JLabel lblCompletado = null;
	private JLabel lblFinish = null;
	private MiWorker trabajador;
	private JProgressBar bar = null;

	/**
	 * This method initializes btnStartWorker
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getBtnStartWorker() {
		if (btnStartWorker == null) {
			btnStartWorker = new JButton();
			btnStartWorker.setBounds(new Rectangle(89, 105, 117, 29));
			btnStartWorker.setText("Empezar");
			btnStartWorker
					.addActionListener(new java.awt.event.ActionListener() {
						public void actionPerformed(java.awt.event.ActionEvent e) {
							if (trabajador == null) {
								trabajador = new MiWorker();

								// Agrego un Listener para el cambio de la
								// propiedad "progress"
								trabajador
										.addPropertyChangeListener(new PropertyChangeListener() {
											public void propertyChange(
													PropertyChangeEvent evt) {
												if ("progress".equals(evt
														.getPropertyName())) {
													lblCompletado.setText(evt
															.getNewValue()
															+ " %");
												}
											}
										});
							}
							trabajador.execute();
						}
					});
		}
		return btnStartWorker;
	}

	/**
	 * This method initializes bar
	 * 
	 * @return javax.swing.JProgressBar
	 */
	private JProgressBar getBar() {
		if (bar == null) {
			bar = new JProgressBar();
			bar.setMinimum(0);
			bar.setIndeterminate(true);
			bar.setMaximum(100);
			bar.setStringPainted(false);
			bar.setBounds(new Rectangle(18, 48, 266, 21));
		}
		return bar;
	}

	/**
	 * @param args
	 */
	/*
	 * public static void main(String[] args) { (new
	 * ProgressBarTest()).setVisible(true); }
	 */

	/**
	 * This is the default constructor
	 */
	public dialogMostrarImagen() {
		super();
		initialize();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnStartWorker.doClick();
		btnStartWorker.setVisible(false);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(312, 191);
		this.setContentPane(getJContentPane());
		this.setTitle("Espere por favor");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			lblFinish = new JLabel();
			lblFinish.setBounds(new Rectangle(73, 13, 153, 28));
			lblFinish.setText("");
			lblCompletado = new JLabel();
			lblCompletado.setBounds(new Rectangle(96, 73, 39, 20));
			lblCompletado
					.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
			lblCompletado.setText("0%");
			jLabel = new JLabel();
			jLabel.setBounds(new Rectangle(19, 72, 74, 19));
			jLabel.setText("Completado:");
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getBtnStartWorker(), null);
			jContentPane.add(jLabel, null);
			jContentPane.add(lblCompletado, null);
			jContentPane.add(lblFinish, null);
			jContentPane.add(getBar(), null);
		}
		return jContentPane;
	}

	/*
	 * Esta es mi inner class "MiWorker", si se fijan, estoy instrumentando
	 * Generics para decirle a esta clase, que deberá retornar del
	 * "doInBackGround" un String, y que los demás métodos no deben retornar
	 * nada (void)
	 */
	class MiWorker extends SwingWorker<String, Void> {

		@Override
		protected String doInBackground() throws Exception {
			int i = 0;

			while (i <= 100 && !isCancelled()) {

				bar.setValue(i);
				setProgress(i);
				i++;
				Thread.sleep(25);

			}
			final mostrarImagen mostrarImagenW = new mostrarImagen(null);
			mostrarImagenW.actualizaImagen("/buffer.jpg");
			mostrarImagenW.getPreferredSize();
			mostrarImagenW.setVisible(true);
			mostrarImagenW.addFocusListener(new java.awt.event.FocusAdapter() {
				@Override
				public void focusLost(java.awt.event.FocusEvent e) {
					mostrarImagenW.setVisible(false);
					cerrarFrameImagen(mostrarImagenW);

				}
			});
			cerrar();
			return "Operacion finalizada";
		}

		@Override
		public void done() {
			try {
				lblFinish.setText(get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void cerrar() {
		this.dispose();
	}

	public void cerrarFrameImagen(mostrarImagen frame) {
		frame.dispose();
	}
} // @jve:decl-index=0:visual-constraint="10,10"
