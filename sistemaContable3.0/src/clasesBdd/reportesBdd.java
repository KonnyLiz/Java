package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class reportesBdd {

/**
 * Devuelve un arreglo de descripciones desde la base de datos
 * @param conn
 * @return Object[][]
 */

	public Object[][] retornarDescripcionesTipoProd(Connection conn	) {
		int totalRows = 0;

		Object datos2[][] = null;

		Object datos[][];
		try {
			PreparedStatement statement = conn.prepareStatement(" " +
					" SELECT ID_TP, DESCRIPCION_TP " +
					"  FROM tipo_producto ");
			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			datos = new Object[totalRows][2];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				datos[cont][0] = rs.getString(1);
				datos[cont][1] = rs.getString(2);
				cont++;
			}
			rs.close();
			datos2 = datos;
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return datos2;
	}// seleccionar


}
