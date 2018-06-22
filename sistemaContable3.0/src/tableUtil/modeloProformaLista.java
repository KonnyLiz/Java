package tableUtil;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class modeloProformaLista implements TableModel {

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
		return 10;
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
		// Devuelve el número de items en el modelo, es decir, el número
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
		detalleProformaLista aux;

		// Se obtiene el item de la fila indicada
		aux = (datos.get(rowIndex));
		// /ID_PROFORMA, NOMBRE, FECHA, SUBTOTAL, TOTAL, IVA, ESTADO
		// Se obtiene el campo apropiado según el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return aux.getIdProforma();
		case 1:
			return aux.getNombre();
		case 2:
			return aux.getFecha();
		case 3:
			return aux.getSubtotal();
		case 4:
			return aux.getTotal();
		case 5:
			return aux.getIva();
		case 6:
			return aux.getEstado();
		case 7:
			return aux.getVer();
		case 8:
			return aux.getRecibo();
		case 9:
			return aux.getEliminar();
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
	public void nuevoItem(detalleProformaLista nuevoItem) {
		// Añade el item al modelo
		datos.add(nuevoItem);

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
		// /ID_PROFORMA, NOMBRE, FECHA, SUBTOTAL, TOTAL, IVA, ESTADO
		switch (columnIndex) {
		case 0:
			// contiene el nombre
			// un float
			return String.class;
		case 1:
			// contiene Descripcion
			// un String
			return String.class;
		case 2:
			// contiene Numero
			// un Integer
			return String.class;

		case 3:
			// contiene total
			// String
			return String.class;
		case 4:
			// contiene el Abono
			// String
			return String.class;
		case 5:
			// contiene el Saldo
			// String
			return String.class;
		case 6:
			// contiene las opcion de Entregar
			// String
			return String.class;
		case 7:
			// contiene las opcion de Facturar
			// String
			return Boolean.class;
		case 8:
			// contiene las opcion de eliminación
			// String
			return Boolean.class;
		case 9:
			// contiene las opcion de id_ot
			// String
			return Boolean.class;
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
		// cabecera de la tabla.
		// /ID_PROFORMA, NOMBRE, FECHA, SUBTOTAL, TOTAL, IVA, ESTADO
		switch (columnIndex) {
		case 0:
			return "NUMERO";
		case 1:
			return "CLIENTE";
		case 2:
			return "FECHA";
		case 3:
			return "SUBTOTAL";
		case 4:
			return "TOTAL";
		case 5:
			return "IVA";
		case 6:
			return "ESTADO";
		case 7:
			return "VER PROFORMA";
		case 8:
			return "GENERAR RECIBO";
		case 9:
			return "ELIMINAR";
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
		return (columnIndex > 6 && columnIndex <= 9);

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
		detalleProformaLista aux;
		aux = (datos.get(rowIndex));
		// /ID_PROFORMA, NOMBRE, FECHA, SUBTOTAL, TOTAL, IVA, ESTADO
		// Cambia el campo del item que indica columnIndex, poniendole el
		// aValue que se nos pasa.
		switch (columnIndex) {
		case 0:
			aux.setIdProforma((String) aValue);
			break;
		case 1:
			aux.setNombre((String) aValue);
			break;
		case 2:
			aux.setFecha((String) aValue);
			break;
		case 3:
			aux.setSubtotal((String) aValue);
			break;
		case 4:
			aux.setTotal((String) aValue);
			break;
		case 5:
			aux.setIva((String) aValue);
			break;
		case 6:
			aux.setEstado((String) aValue);
			break;
		case 7:
			aux.setVer((Boolean) aValue);
			break;
		case 8:
			aux.setRecibo((Boolean) aValue);
			break;
		case 9:
			aux.setEliminar((Boolean) aValue);
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
	public void nuevoItemEnPosicion(detalleProformaLista nuevoItem, int posicion) {
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
	private LinkedList<detalleProformaLista> datos = new LinkedList<detalleProformaLista>();

	/**
	 * Lista de suscriptores. El JTable será un suscriptor de este modelo de
	 * datos
	 */
	private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();
}
