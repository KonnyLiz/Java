/*
 * Ayuda.java
 *
 * Created on 27 de abril de 2006, 12:30 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package ayuda;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.JHelp;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Carlos
 */
public class Ayuda {

	private HelpBroker help_browser = null;
	private HelpSet helpset = null;
	private HelpSet.Presentation hsp = null;

	public Ayuda() {
		try {
			URL hsURL = this.getClass().getResource("/ayuda/sga.hs");
			
			helpset = new HelpSet(null, hsURL);
			
			JHelp help = new JHelp(helpset);
			JFrame frame = new JFrame("help");
			frame.doLayout();
			JPanel panel = new JPanel(new GridLayout());
			panel.add(help);
			frame.setContentPane(panel);
			help.setNavigatorDisplayed(true);
			frame.setTitle("Ayuda del sistema v 3.7");
			frame.pack();
			frame.setSize(800, 500);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(java.awt.event.WindowEvent evt) {
					System.exit(0);
				}
			});
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/** Creates a new instance of Ayuda */
	public Ayuda(Component component) {
		try {
			URL hsURL = this.getClass().getResource("/sga.hs");
			helpset = new HelpSet(null, hsURL);
			hsp = helpset.getPresentation("MainWin");
			help_browser = helpset.createHelpBroker();
			help_browser.setHelpSetPresentation(hsp);
			help_browser.enableHelpOnButton(component, "introduccion", helpset);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void showAyuda(String tema) {
		try {
			help_browser.setCurrentID(tema);
		} catch (Exception e) {
			help_browser.setCurrentID("Introduccion");
		}
		help_browser.setDisplayed(true);
	}

	public static void main(String args[]) {
		new Ayuda();
	}

}
