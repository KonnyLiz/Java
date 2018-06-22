package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.arregloClientesTempHash;
import clases.cliente;

public class clientesBdd {
	/*
	 * insertar registro en tabla alertas
	 */
	public int insertar(Connection conn, cliente objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into cliente (ID_TC, CI_RUC, NOMBRE, TELEFONO, CLIENTE_DESDE, DIRECCION, SEXO, EMAIL) values (?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdTc());
			statement.setString(2, objeto.getCiRuc());
			statement.setString(3, objeto.getNombre());
			statement.setString(4, objeto.getTelefono());
			statement.setString(5, objeto.getClienteDesde().toString());
			statement.setString(6, objeto.getDireccion());
			statement.setString(7, objeto.getSexo());
			statement.setString(8, objeto.getEmail());
			System.out.print(statement);
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Ingresado un Nuevo Cliente! ", "Aviso! ",
					JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {
			// jTextArea.append("\n:problema : "+e.getMessage());

			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// insertar

	/*
	 *
	 * Modifica un registro existente
	 *
	 *
	 */

	public int modificar(Connection conn, cliente objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update cliente " + "set ID_TC = ?,"
							+ " NOMBRE = ?," + " TELEFONO = ?,"
							+ " CLIENTE_DESDE = ?," + " DIRECCION = ?, "
							+ "SEXO = ?, " + "EMAIL = ?" + " where CI_RUC = ?");
			statement.setInt(1, objeto.getIdTc());
			statement.setString(2, objeto.getNombre());
			statement.setString(3, objeto.getTelefono());
			statement.setString(4, objeto.getClienteDesde().toString());
			statement.setString(5, objeto.getDireccion());
			statement.setString(6, objeto.getSexo());
			statement.setString(7, objeto.getEmail());
			statement.setString(8, objeto.getCiRuc());
			statement.execute();
			statement.close();
			JOptionPane.showMessageDialog(null,
					"Se ha Modificado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);
			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Modificó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// modificar

	/*
	 *
	 * Eliminar un registro existente
	 *
	 *
	 */

	public int eliminar(Connection conn, cliente objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from cliente where CI_RUC = ?");
			statement.setString(1, objeto.getCiRuc());
			statement.execute();
			statement.close();
			JOptionPane.showMessageDialog(null,
					"Se ha Eliminado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);
			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Eliminó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// modificar

	/***************************************************************************
	 *
	 * Buscar un registro existente en la Bdd
	 *
	 *
	 **************************************************************************/

	public cliente buscarInfoDeUnRegistro(Connection conn, cliente objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_TC, CI_RUC, NOMBRE, TELEFONO, CLIENTE_DESDE, DIRECCION, SEXO, EMAIL from cliente where CI_RUC='"
							+ objeto.getCiRuc() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdTc(rs.getInt("ID_TC"));
				objeto.setCiRuc(rs.getString("CI_RUC"));
				objeto.setNombre(rs.getString("NOMBRE"));
				objeto.setTelefono(rs.getString("TELEFONO"));
				objeto
						.setClienteDesde(rs.getString("CLIENTE_DESDE")
								.toString());
				objeto.setDireccion(rs.getString("DIRECCION"));
				objeto.setSexo(rs.getString("SEXO"));
				objeto.setEmail(rs.getString("EMAIL"));
				// Process data here

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

			objeto.setDireccion("no existe");

		}
		return objeto;

	}

	/***************************************************************************
	 *
	 * Buscar un registro existente en la Bdd por nombre
	 *
	 *
	 **************************************************************************/

	public cliente buscarInfoDeUnRegistroPorNombre(Connection conn,
			cliente objeto) {

		try {

			PreparedStatement statement = conn
					.prepareStatement("select ID_TC, CI_RUC, NOMBRE, TELEFONO, CLIENTE_DESDE, DIRECCION, SEXO, EMAIL from cliente where NOMBRE='"
							+ objeto.getNombre() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdTc(rs.getInt("ID_TC"));
				objeto.setCiRuc(rs.getString("CI_RUC"));
				objeto.setNombre(rs.getString("NOMBRE"));
				objeto.setTelefono(rs.getString("TELEFONO"));
				objeto
						.setClienteDesde(rs.getString("CLIENTE_DESDE")
								.toString());
				objeto.setDireccion(rs.getString("DIRECCION"));
				objeto.setSexo(rs.getString("SEXO"));
				objeto.setEmail(rs.getString("EMAIL"));
				// Process data here

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

			objeto.setDireccion("no existe");

		}
		return objeto;

	}

	/*
	 *
	 * retorna un objeto todos los objetos de la tabla
	 *
	 */

	public Object[][] seleccionarTodos(Connection conn) {
		int totalRows = 0;

		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(CI_RUC) from cliente ");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][8];
			PreparedStatement statement = conn
					.prepareStatement("SELECT tc.DESCRIPCION, CI_RUC, NOMBRE, TELEFONO, CLIENTE_DESDE, DIRECCION, SEXO, EMAIL FROM cliente c ,tipo_cliente tc where TC.ID_TC=C.ID_TC");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				datos[cont][0] = rs.getString("DESCRIPCION");
				datos[cont][1] = rs.getString("CI_RUC");
				datos[cont][2] = rs.getString("NOMBRE");
				datos[cont][3] = rs.getString("TELEFONO");
				datos[cont][4] = rs.getString("CLIENTE_DESDE");
				datos[cont][5] = rs.getString("DIRECCION");
				datos[cont][6] = rs.getString("SEXO");
				datos[cont][7] = rs.getString("EMAIL");

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
	}// seleccionar los del mes

	/*
	 *
	 * retorna un objeto todos los objetos de la tabla
	 *
	 */

	public Hashtable<String, arregloClientesTempHash> seleccionarDatosClientesHashOdt(Connection conn) {
		int totalRows = 0;
		arregloClientesTempHash arreglo = new arregloClientesTempHash("", "",
				"", "");
		Hashtable<String, arregloClientesTempHash> clientesLista = new Hashtable<String, arregloClientesTempHash>();
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(CI_RUC) from cliente  ");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][8];
			PreparedStatement statement = conn
					.prepareStatement("SELECT tc.DESCRIPCION, CI_RUC,"
							+ " NOMBRE, TELEFONO,DIRECCION FROM cliente c ,tipo_cliente tc "
							+ "where c.id_tc=tc.id_tc " + "order by 1");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				arreglo.ciRuc = rs.getString("CI_RUC");
				arreglo.nombre = rs.getString("NOMBRE");
				arreglo.telefono = rs.getString("TELEFONO");
				arreglo.direccion = rs.getString("DIRECCION");
				clientesLista.put(rs.getString("CI_RUC"), arreglo);

				cont++;
			}
			rs.close();
			statement.close();
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return clientesLista;
	}// seleccionar los del mes

	/*
	 *
	 * retorna clientes todos los objetos de la tabla buscados por ruc
	 */

	public Object[][] seleccionarClientesBuscados(Connection conn,
			String busqueda) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ "DESCRIPCION,NOMBRE, CI_RUC , TELEFONO"
					+ " FROM cliente C,tipo_cliente t"
					+ "  where c.ID_TC=t.ID_TC" + "  and CI_RUC like '%"
					+ busqueda + "%' order by NOMBRE");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][4];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(3);
				arreglo2[cont][2] = rs.getString(2);
				arreglo2[cont][3] = rs.getString(4);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;

	}// seleccionar

	/*
	 *
	 * retorna un objeto todos los objetos de la tabla
	 *
	 */

	public Object[][] seleccionarClientesBuscadosNombre(Connection conn,
			String busqueda) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement("SELECT "
					+ "DESCRIPCION,NOMBRE, CI_RUC , TELEFONO"
					+ " FROM cliente C,tipo_cliente t"
					+ "  where c.ID_TC=t.ID_TC" + "  and NOMBRE like '%"
					+ busqueda + "%' order by NOMBRE");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][4];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(3);
				arreglo2[cont][2] = rs.getString(2);
				arreglo2[cont][3] = rs.getString(4);

				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;

	}// seleccionar

	/**
	 * retorna en un objeto los clientes que tienen deudas
	 * @param conn
	 * @return Object
	 */

	public Object[][] seleccionarClientesConDeudas(Connection conn
			) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement(" SELECT" +
					" DISTINCT C.NOMBRE,C.CI_RUC,C.TELEFONO," +
					" R.TOTAL,R.NUMERO_RECIBO,T.TIPO_RECIBO  FROM cliente C ,recibo_venta R," +
					" tipo_pago_recibo T" +
					" WHERE  R.NUMERO_RECIBO=T.ID_RECIBO " +
					" AND C.CI_RUC=R.CI_RUC" +
					" AND T.ESTADO='Pendiente'  " +
					" AND  R.ID_TR=T.TIPO_RECIBO" +
					" ORDER BY 1");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][7];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);
				arreglo2[cont][5] = rs.getString(6);


				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;

	}// end

	/**
	 * retorna los pagos realizados por un cliente
	 * según el recibo
	 * @param conn
	 * @param tipo
	 * @param numero
	 * @return
	 */
	public Object[][] seleccionarDeudasPorClientesyRecibo(Connection conn,String tipo, String numero
			) {
		int totalRows = 0;
		Object arreglo[][] = null;
		try {
			PreparedStatement statement = conn.prepareStatement(" SELECT " +
					" T.ID_RECIBO," +
					" (SELECT DESCRIPCION FROM TIPO_PAGO P WHERE P.ID_TP= T.ID_TP)," +
					" CANTIDAD,DETALLE,PLAZO " +
					"  FROM Tipo_pago_recibo T " +
					" WHERE   T.TIPO_RECIBO="+tipo+"" +
							" AND  T.ID_RECIBO="+numero+"");

			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			Object arreglo2[][] = new Object[totalRows][5];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				arreglo2[cont][0] = rs.getString(1);
				arreglo2[cont][1] = rs.getString(2);
				arreglo2[cont][2] = rs.getString(3);
				arreglo2[cont][3] = rs.getString(4);
				arreglo2[cont][4] = rs.getString(5);



				cont++;

			}
			arreglo = arreglo2;
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return arreglo;

	}// seleccionar


}
