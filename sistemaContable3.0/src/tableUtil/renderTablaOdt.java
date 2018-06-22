package tableUtil;

import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 */
public class renderTablaOdt extends JLabel implements TableCellRenderer {
	/**
	 * Constructor por defecto.
	 */
	public renderTablaOdt() {

	}

	/**
	 * Returns the component used for drawing the cell. This method is used to
	 * configure the renderer appropriately before drawing.
	 * 
	 * @param table
	 *            the <code>JTable</code> that is asking the renderer to draw;
	 *            can be <code>null</code>
	 * @param value
	 *            the value of the cell to be rendered. It is up to the specific
	 *            renderer to interpret and draw the value. For example, if
	 *            <code>value</code> is the string "true", it could be
	 *            rendered as a string or it could be rendered as a check box
	 *            that is checked. <code>null</code> is a valid value
	 * @param isSelected
	 *            true if the cell is to be rendered with the selection
	 *            highlighted; otherwise false
	 * @param hasFocus
	 *            if true, render cell appropriately. For example, put a special
	 *            border on the cell, if the cell can be edited, render in the
	 *            color used to indicate editing
	 * @param row
	 *            the row index of the cell being drawn. When drawing the
	 *            header, the value of <code>row</code> is -1
	 * @param column
	 *            the column index of the cell being drawn
	 * 
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		JLabel etiqueta = new JLabel();
		if (isSelected)
			etiqueta.setBackground(Color.YELLOW);

		else
			etiqueta.setBackground(Color.LIGHT_GRAY);

		if (value instanceof String) {
			etiqueta.setOpaque(true);
			etiqueta.setText((String) value);

		}

		if (value instanceof Boolean) {
			etiqueta.setIcon(new ImageIcon(getClass().getResource(
					"/frameIcons/delete.png")));

			if (column == 6)
				etiqueta.setIcon(new ImageIcon(getClass().getResource(
						"/frameIcons/entregar.png")));

			if (column == 7)
				etiqueta.setIcon(new ImageIcon(getClass().getResource(
						"/frameIcons/invoiceOdt.JPG")));
			if (column == 8)
				etiqueta.setIcon(new ImageIcon(getClass().getResource(
						"/frameIcons/ver.png")));

		}

		return etiqueta;
	}

}
