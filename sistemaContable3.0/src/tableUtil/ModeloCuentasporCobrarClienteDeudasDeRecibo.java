/**
 * Solo para uso de listaClientes.java
 */

package tableUtil;

import java.util.LinkedList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import clases.arregloClientesListaTempHash;

public class ModeloCuentasporCobrarClienteDeudasDeRecibo implements TableModel {

	/**
	 * * Returns the number of columns in the model. A <code>JTable</code>
	 * uses this method to determine how many columns it should create and
	 * display by default.
	 *
	 * @return the number of columns in the model
	 * @see #getRowCount
	 *
	 */
	public int getColumnCount() {
		// Devuelve el n�mero de columnas del modelo, que coincide con el
		// n�mero de datos que tenemos de cada persona.
		return 7;
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
		// Devuelve el n�mero de personas en el modelo, es decir, el n�mero
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
		arregloClientesListaTempHash aux;

		// Se obtiene el item de la fila indicada
		aux = (arregloClientesListaTempHash) (datos.get(rowIndex));

		// Se obtiene el campo apropiado seg�n el valor de columnIndex
		switch (columnIndex) {
		case 0:
			return aux.getTipo();
		case 1:
			return "" + aux.getNombre();
		case 2:
			return "" + aux.getRuc();
		case 3:
			return aux.getTelefono();
		case 4:
			return aux.getEditar();
		case 5:
			return aux.getAdicional();
		case 6:
			return aux.getAdicional2();
		default:
			return null;
		}
	}

	/**
	 * Borra del modelo el item en la fila indicada
	 */
	public void borraItem(int fila) {
		// Se borra la fila
		datos.remove(fila);

		// Y se avisa a los suscriptores, creando un TableModelEvent...
		TableModelEvent evento = new TableModelEvent(this, fila, fila,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);

		// ... y pas�ndoselo a los suscriptores
		avisaSuscriptores(evento);
	}

	/**
	 * A�ade una item al final de la tabla
	 */
	public void nuevoItem(arregloClientesListaTempHash item) {
		// A�ade el item al modelo
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
		// A�ade el suscriptor a la lista de suscriptores
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
			// contiene la tipo de cliente
			// un float
			return String.class;
		case 1:
			// contiene nombre
			// un String
			return String.class;
		case 2:
			// contiene RUC
			// String
			return String.class;
		case 3:
			// contiene telefono
			// String
			return String.class;

		case 4:
			// contiene editar
			// String
			return Boolean.class;
		case 5:
			// contiene telefono
			// String
			return String.class;
		case 6:
			// contiene telefono
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
		// Devuelve el nombre de cada columna. Este texto aparecer� en la
		// CANTIDAD", "DESCRIPCION","MEDIDAS", "PRECIO","ELIMINAR"
		// cabecera de la tabla.
		switch (columnIndex) {
		case 0:
			return "TOTAL";
		case 1:
			return "NOMBRE COMPLETO";
		case 2:
			return "R  U   C";
		case 3:
			return "TELEFONO";
		case 4:
			return "VER";
		case 5:
			return "RECIBO";
		case 6:
			return "TIPO";
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
		return (columnIndex != 0 && columnIndex != 1 && columnIndex != 2 && columnIndex != 3);

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
		arregloClientesListaTempHash aux;
		aux = (arregloClientesListaTempHash) (datos.get(rowIndex));

		// Cambia el campo del item que indica columnIndex, poniendole el
		// aValue que se nos pasa.
		switch (columnIndex) {
		case 0:
			aux.setTipo((String) aValue);
			break;
		case 1:
			aux.setNombre((String) aValue);
			break;
		case 2:
			aux.setRuc(((String) aValue));
			break;
		case 3:
			aux.setTelefono((String) aValue);
			break;
		case 4:
			aux.setEditar((Boolean) aValue);
			break;

		default:
			break;
		}

		// Avisa a los suscriptores del cambio, creando un TableModelEvent ...
		TableModelEvent evento = new TableModelEvent(this, rowIndex, rowIndex,
				columnIndex);

		// ... y pas�ndoselo a los suscriptores.
		avisaSuscriptores(evento);
	}

	/**
	 * A�ade una persona al final de la tabla
	 */
	public void nuevoItemEnPosicion(detalleInventario nuevoItem, int posicion) {
		// A�ade el item al modelo
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
		// tableChanged() de los mismos, pas�ndole el evento.
		for (i = 0; i < listeners.size(); i++)
			listeners.get(i).tableChanged(evento);
	}

	/**
	 * Lista con los datos. Cada elemento de la lista es una instancia de recibo
	 */
	private LinkedList<Object> datos = new LinkedList<Object>();

	/**
	 * Lista de suscriptores. El JTable ser� un suscriptor de este modelo de
	 * datos
	 */
	private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();
}
