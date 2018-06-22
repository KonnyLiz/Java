package ventanas;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class TablaModeloOdt extends AbstractTableModel {

	private String[] columnNames = { "Cantidad", "Descripcion", "Medidas",
			"Precio", "Opción" };
	private Object[][] data = {
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },
			{ 0, "", "", new Integer(5), new Boolean(false) },

	};

	public final Object[] longValues = { "", "", "", 0, Boolean.FALSE };

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	/*
	 * JTable uses this method to determine the default renderer/ editor for
	 * each cell. If we didn't implement this method, then the last column would
	 * contain text ("true"/"false"), rather than a check box.
	 */
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	@Override
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	@Override
	public void setValueAt(Object value, int row, int col) {
		if (DEBUG) {
			System.out.println("Setting value at " + row + "," + col + " to "
					+ value + " (an instance of " + value.getClass() + ")");
		}

		data[row][col] = value;
		fireTableCellUpdated(row, col);

		if (DEBUG) {
			System.out.println("New value of data:");
			printDebugData();
		}
	}

	/*
	 * This method picks good column sizes. If all column heads are wider than
	 * the column's cells' contents, then you can just use
	 * column.sizeWidthToFit().
	 */
	void initColumnSizes(JTable table) {
		TablaModeloOdt model = (TablaModeloOdt) table.getModel();
		TableColumn column = null;
		Component comp = null;
		int headerWidth = 0;
		int cellWidth = 0;
		Object[] longValues = model.longValues;
		TableCellRenderer headerRenderer = table.getTableHeader()
				.getDefaultRenderer();

		for (int i = 0; i < 5; i++) {
			column = table.getColumnModel().getColumn(i);

			comp = headerRenderer.getTableCellRendererComponent(null, column
					.getHeaderValue(), false, false, 0, 0);
			headerWidth = comp.getPreferredSize().width;

			comp = table.getDefaultRenderer(model.getColumnClass(i))
					.getTableCellRendererComponent(table, longValues[i], false,
							false, 0, i);
			cellWidth = comp.getPreferredSize().width;

			if (DEBUG) {
				System.out.println("Initializing width of column " + i + ". "
						+ "headerWidth = " + headerWidth + "; cellWidth = "
						+ cellWidth);
			}

			column.setPreferredWidth(Math.max(headerWidth, cellWidth));
		}
	}

	private boolean DEBUG = false;

	private void printDebugData() {
		int numRows = getRowCount();
		int numCols = getColumnCount();

		for (int i = 0; i < numRows; i++) {
			System.out.print("    row " + i + ":");
			for (int j = 0; j < numCols; j++) {
				System.out.print("  " + data[i][j]);
			}
			System.out.println();
		}
		System.out.println("--------------------------");
	}

	/*
	 * This method picks good column sizes. If all column heads are wider than
	 * the column's cells' contents, then you can just use
	 * column.sizeWidthToFit().
	 */
	public void remove(JTable table, TablaModeloOdt model) {
		TableColumn tcol = table.getColumnModel().getColumn(1);
		/*
		 * table.removeRowSelectionInterval(1, 3); table.setModel(model);
		 * 
		 */
		// table=new JTable(model1);
	}

}
