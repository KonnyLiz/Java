package tableUtil;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import clases.pagoGastoProvedoresClassModeloTabla;

public class modeloTablaPagosProveedor implements TableModel {

	/**
	 * Returns the number of columns in the model. A <code>JTable</code> uses
	 * this method to determine how many columns it should create and display by
	 * default.
	 * 
	 * @return the number of columns in the model
	 * @see #getRowCount
	 * 
	 */
	public int getColumnCount() {
		// Devuelve el número de columnas del modelo, que coincide con el
		// número de datos que tenemos de cada persona.
		return 8;
	}

	/**
	 * Returns the number of rows in the model. A <code>JTable</code> uses
	 * this method to determine how many rows it should display. This method
	 * should be quick, as it is called frequently during rendering.
	 * 
	 * @return the number of rows in the model
	 * @see #getColumnCount
	 * 
	 */
	public int getRowCount() {
		// Devuelve el número de personas en el modelo, es decir, el número
		// de filas en la tabla.
		return datos.size();
	}

	/**
	 * Returns the value for the cell at <code>columnIndex</code> and
	 * <code>rowIndex</code>.
	 * 
	 * @param rowIndex
	 *            the row whose value is to be queried
	 * @param columnIndex
	 *            the column whose value is to be queried
	 * @return the value Object at the specified cell
	 * 
	 */
	public Object getValueAt(int rowIndex, int columnIndex) {
		pagoGastoProvedoresClassModeloTabla aux;

		// Se obtiene el item de la fila indicada
		aux = (datos.get(rowIndex));

		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return aux.getIdTabla();
		case 1:
			return aux.getTipo();
		case 2:
			return "" + aux.getNumeroComprobante();
		case 3:
			return aux.getFecha();
		case 4:
			return aux.getDetalle();
		case 5:
			return aux.getProveedor();
		case 6:
			return aux.isEditarPago();
		case 7:
			return aux.getTotalFacturado();
		default:
			return null;
		}
	}

	/**
	 * Borra del modelo la persona en la fila indicada
	 */
	public void borraItem(int fila) {
		// Se borra la fila
		datos.remove(fila);

		// Y se avisa a los suscriptores, creando un TableModelEvent...
		TableModelEvent evento = new TableModelEvent(this, fila, fila,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);

		// ... y pasándoselo a los suscriptores
		avisaSuscriptores(evento);
	}

	/**
	 * Añade una item al final de la tabla
	 */
	public void nuevoItem(pagoGastoProvedoresClassModeloTabla item) {
		// Añade el item al modelo
		datos.add(item);

		// Avisa a los suscriptores creando un TableModelEvent...
		TableModelEvent evento;
		evento = new TableModelEvent(this, this.getRowCount() - 1, this
				.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,
				TableModelEvent.INSERT);

		// ... y avisando a los suscriptores
		avisaSuscriptores(evento);
	}

	/**
	 * Adds a listener to the list that is notified each time a change to the
	 * data model occurs.
	 * 
	 * @param l
	 *            the TableModelListener
	 * 
	 */
	public void addTableModelListener(TableModelListener l) {
		// Añade el suscriptor a la lista de suscriptores
		listeners.add(l);
	}

	/**
	 * Returns the most specific superclass for all the cell values in the
	 * column. This is used by the <code>JTable</code> to set up a default
	 * renderer and editor for the column.
	 * 
	 * @param columnIndex
	 *            the index of the column
	 * @return the common ancestor class of the object values in the model.
	 * 
	 */
	public Class getColumnClass(int columnIndex) {
		// Devuelve la clase que hay en cada columna.
		switch (columnIndex) {
		case 0:
			// contiene la
			// un float
			return String.class;
		case 1:
			// contiene
			// un String
			return String.class;
		case 2:
			// contiene las
			// String
			return String.class;
		case 3:
			// contiene el
			// String
			return String.class;
		case 4:
			// contiene el SUBTOTAL
			// String
			return String.class;
		case 5:
			// contiene las opcion
			// String
			return String.class;
		case 6:
			// contiene las opcion de pagar
			// String
			return Boolean.class;
		case 7:
			// contiene el total pagado
			// String
			return String.class;
		default:
			// Devuelve una clase Object por defecto.
			return Object.class;
		}
	}

	/**
	 * Returns the name of the column at <code>columnIndex</code>. This is
	 * used to initialize the table's column header name. Note: this name does
	 * not need to be unique; two columns in a table can have the same name.
	 * 
	 * @param columnIndex
	 *            the index of the column
	 * @return the name of the column
	 * 
	 */
	public String getColumnName(int columnIndex) {
		// Devuelve el nombre de cada columna. Este texto aparecerá en la
		// CANTIDAD", "DESCRIPCION","MEDIDAS", "PRECIO","ELIMINAR"
		// cabecera de la tabla.
		switch (columnIndex) {
		case 0:
			return "ID";
		case 1:
			return "TIPO";
		case 2:
			return "NUMERO";
		case 3:
			return "FECHA";
		case 4:
			return "DETALLE";
		case 5:
			return "PROVEEDOR";
		case 6:
			return "PAGAR";
		case 7:
			return "_";
		default:
			return null;
		}
	}

	/**
	 * Returns true if the cell at <code>rowIndex</code> and
	 * <code>columnIndex</code> is editable. Otherwise,
	 * <code>setValueAt</code> on the cell will not change the value of that
	 * cell.
	 * 
	 * @param rowIndex
	 *            the row whose value to be queried
	 * @param columnIndex
	 *            the column whose value to be queried
	 * @return true if the cell is editable
	 * @see #setValueAt
	 * 
	 */
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// Permite que la celda sea editable.
		return (columnIndex > 5);

	}// && columnIndex != 0)

	/**
	 * Removes a listener from the list that is notified each time a change to
	 * the data model occurs.
	 * 
	 * @param l
	 *            the TableModelListener
	 * 
	 */
	public void removeTableModelListener(TableModelListener l) {
		// Elimina los suscriptores.
		listeners.remove(l);
	}

	/**
	 * Sets the value in the cell at <code>columnIndex</code> and
	 * <code>rowIndex</code> to <code>aValue</code>.
	 * 
	 * @param aValue
	 *            the new value
	 * @param rowIndex
	 *            the row whose value is to be changed
	 * @param columnIndex
	 *            the column whose value is to be changed
	 * @see #getValueAt
	 * @see #isCellEditable
	 * 
	 */
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Obtiene la persona de la fila indicada
		pagoGastoProvedoresClassModeloTabla aux;
		aux = (datos.get(rowIndex));

		// Cambia el campo del item que indica columnIndex, poniendole el
		// aValue que se nos pasa.
		switch (columnIndex) {
		case 0:
			aux.setIdTabla((String) aValue);
			break;
		case 1:
			aux.setTipo((String) aValue);
			break;
		case 2:
			aux.setNumeroComprobante(((String) aValue));
			break;
		case 3:
			aux.setFecha((String) aValue);
			break;
		case 4:
			aux.setDetalle((String) aValue);
			break;
		case 5:
			aux.setProveedor((String) aValue);
			break;
		case 6:
			aux.setEditarPago((Boolean) aValue);
			break;
		case 7:
			aux.setTotalFacturado((String) aValue);
			break;
		default:
			break;
		}

		// Avisa a los suscriptores del cambio, creando un TableModelEvent ...
		TableModelEvent evento = new TableModelEvent(this, rowIndex, rowIndex,
				columnIndex);

		// ... y pasándoselo a los suscriptores.
		avisaSuscriptores(evento);
	}

	/**
	 * Añade una persona al final de la tabla
	 */
	public void nuevoItemEnPosicion(
			pagoGastoProvedoresClassModeloTabla nuevoItem, int posicion) {
		// Añade el item al modelo
		datos.add(posicion, nuevoItem);

		// Avisa a los suscriptores creando un TableModelEvent...
		TableModelEvent evento;
		evento = new TableModelEvent(this, this.getRowCount() - 1, this
				.getRowCount() - 1, TableModelEvent.ALL_COLUMNS,
				TableModelEvent.INSERT);

		// ... y avisando a los suscriptores
		avisaSuscriptores(evento);
	}

	/**
	 * Pasa a los suscriptores el evento.
	 */
	private void avisaSuscriptores(TableModelEvent evento) {
		int i;

		// Bucle para todos los suscriptores en la lista, se llama al metodo
		// tableChanged() de los mismos, pasándole el evento.
		for (i = 0; i < listeners.size(); i++)
			listeners.get(i).tableChanged(evento);
	}

	/**
	 * Lista con los datos. Cada elemento de la lista es una instancia de recibo
	 */
	private LinkedList<pagoGastoProvedoresClassModeloTabla> datos = new LinkedList<pagoGastoProvedoresClassModeloTabla>();

	/**
	 * Lista de suscriptores. El JTable será un suscriptor de este modelo de
	 * datos
	 */
	private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();
}
