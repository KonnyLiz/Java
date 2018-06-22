package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import clases.InventarioDetalle;
import clases.arregloProductosTempHash;
import clases.inventario;

public class inventarioBdd {
	/*
	 * insertar registro en tabla tipo cliente
	 */
	public int insertar(Connection conn, inventario objeto) {
		String cx = null;
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into producto (ID_PRO, ID_PROV, ID_UNIDAD_MEDIDA, ID_TP, ID_PR, ID_BODEGA, DESCRIPCION, PVP, PVSOCIO, EQ_UNIDAD) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			statement.setInt(1, objeto.getIdProducto());
			statement.setInt(2, objeto.getIdProveedor());
			statement.setInt(3, objeto.getUnidadDeMedida());
			statement.setInt(4, objeto.getIdTipoProducto());
			statement.setInt(5, objeto.getIdPagoRealizado());
			statement.setInt(6, objeto.getIdBodega());
			statement.setString(7, objeto.getDescripcion());
			statement.setFloat(8, objeto.getPvp());
			statement.setFloat(9, objeto.getPvpSocio());
			statement.setFloat(10, objeto.getEquivalente());
			statement.execute();
			statement.close();
			JOptionPane.showMessageDialog(null,
					"Se ha Ingresado un Registro! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			System.out.print(cx);
			return 0;
		}

	}// insertar

	/*
	 * 
	 * Modifica un registro existente tipo cliente
	 * 
	 * 
	 */

	public int modificar(Connection conn, inventario objeto) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("update producto set ID_PROV = ?, ID_UNIDAD_MEDIDA = ?, ID_TP = ?, ID_PR = ?, ID_BODEGA = ?, DESCRIPCION = ?, PVP = ?, PVSOCIO = ?, EQ_UNIDAD = ? where ID_PRO = ?");
			statement.setInt(1, objeto.getIdProveedor());
			statement.setInt(2, objeto.getUnidadDeMedida());
			statement.setInt(3, objeto.getIdTipoProducto());
			statement.setInt(4, objeto.getIdPagoRealizado());
			statement.setInt(5, objeto.getIdBodega());
			statement.setString(6, objeto.getDescripcion());
			statement.setFloat(7, objeto.getPvp());
			statement.setFloat(8, objeto.getPvpSocio());
			statement.setFloat(9, objeto.getEquivalente());
			statement.setInt(10, objeto.getIdProducto());
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

	/***************************************************************************
	 * 
	 * Buscar un registro existente en la Bdd
	 * 
	 * 
	 **************************************************************************/

	public inventario buscarInfoDeUnRegistro(Connection conn, inventario objeto) {

		try {

			PreparedStatement statement = conn.prepareStatement("SELECT"
					+ " ID_PRO, ID_PROV, ID_UNIDAD_MEDIDA, ID_TP, ID_PR, "
					+ "ID_BODEGA, DESCRIPCION, PVP, PVSOCIO, EQ_UNIDAD"
					+ " FROM producto" + " where DESCRIPCION='"
					+ objeto.getDescripcion() + "'");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				objeto.setIdProducto(rs.getInt("ID_PRO"));
				objeto.setIdProveedor(rs.getInt("ID_PROV"));
				objeto.setUnidadDeMedida(rs.getInt("ID_UNIDAD_MEDIDA"));
				objeto.setIdTipoProducto(rs.getInt("ID_TP"));
				objeto.setIdPagoRealizado(rs.getInt("ID_PR"));
				objeto.setIdBodega(rs.getInt("ID_BODEGA"));
				objeto.setDescripcion(rs.getString("DESCRIPCION"));
				objeto.setPvp(rs.getFloat("PVP"));
				objeto.setPvpSocio(rs.getFloat("PVSOCIO"));
				objeto.setEquivalente(rs.getFloat("EQ_UNIDAD"));
				// Process data here

			}
			rs.close();
			statement.close();

		} catch (Exception e) {

		}
		return objeto;

	}//

	/**
	 * Retorna un arreglo con los detalles de un producto
	 * 
	 * @param conn
	 * @param idProducto
	 * @return arr[][]
	 */
	public Object[][] seleccionarDetalleProducto(Connection conn, int idProducto) {
		int totalRows = 0;

		Object datos2[][] = null;

		Object datos[][];
		try {
			PreparedStatement statement = conn.prepareStatement(" SELECT "
					+ "ID_INVENTARIO, ID_PRO, PRECIO_COMPRA,"
					+ " TOTAL_BRUTO, FECHA_ING, FECHA_CAD "
					+ "FROM inventario " + "where ID_PRO=" + idProducto + "");
			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			datos = new Object[totalRows][6];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				datos[cont][0] = rs.getString(1);
				datos[cont][1] = rs.getString(2);
				datos[cont][2] = rs.getString(3);
				datos[cont][3] = rs.getString(4);
				datos[cont][4] = rs.getString(5);
				datos[cont][5] = rs.getString(6);

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

	/*
	 * 
	 * retorna un objeto todos los objetos de la tabla
	 * 
	 */

	public Object[][] seleccionarProductos(Connection conn) {
		int totalRows = 0;

		Object datos2[][] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_PRO) from producto ");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[][] = new Object[totalRows][5];
			PreparedStatement statement = conn
					.prepareStatement("SELECT "
							+ " t.DESCRIPCION_TP,P.DESCRIPCION,"
							+ " U.NOMENCLATURA , B.DESCRIPCION, P.PVP"
							+ " FROM producto p,tipo_producto t,UNIDAD_MEDIDA U,BODEGA B "
							+ "where t.ID_TP=p.ID_TP "
							+ " AND   U.ID_UNIDAD_MEDIDA=P.ID_UNIDAD_MEDIDA "
							+ " AND   B.ID_BODEGA=P.ID_BODEGA " + " GROUP BY 2"
							+ " order by  p.DESCRIPCION ");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont][0] = rs.getString(1);
				datos[cont][1] = rs.getString(2);
				datos[cont][2] = rs.getString(3);
				datos[cont][3] = rs.getString(4);
				datos[cont][4] = rs.getString(5);
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

	/*
	 * 
	 * retorna un objeto todos los objetos de la tabla para choice
	 * 
	 */

	public Object[] seleccionarDescripcionesTabla(Connection conn) {
		int totalRows = 0;

		Object datos2[] = null;
		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_PRO) from inventario limit 300");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}
			Object datos[] = new Object[totalRows];
			PreparedStatement statement = conn
					.prepareStatement("select ID_PRO,DESCRIPCION from inventario limit 200");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				datos[cont] = rs.getString("DESCRIPCION");
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

	/**
	 * Devuelve las descripciones y los pk
	 * 
	 * @param conn
	 * @return
	 */

	public Hashtable<String, arregloProductosTempHash> seleccionarDescripcionesTablaHash(Connection conn) {
		int totalRows = 0;
		Hashtable<String, arregloProductosTempHash> proveedorLista = new Hashtable<String, arregloProductosTempHash>();

		try {

			int cont = 0;
			PreparedStatement statement = conn
					.prepareStatement(" SELECT  p.ID_PRO, p.ID_TP, p.DESCRIPCION,"
							+ "  p.PVP, p.EQ_UNIDAD, sum(i.TOTAL_BRUTO),"
							+ " u.Nomenclatura  "
							+ " FROM producto p,unidad_medida u, inventario i"
							+ " where p.ID_UNIDAD_MEDIDA=u.ID_UNIDAD_MEDIDA  "
							+ " and p.ID_PRO=i.ID_PRO " + " group by 1");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				arregloProductosTempHash datos = new arregloProductosTempHash();
				datos.setIdProd(rs.getInt(1));
				datos.setTipoProducto(rs.getInt(2));
				datos.setDescripcion(rs.getString(3));
				datos.setPvp(rs.getFloat(4));
				datos.setEquivalenteUnidad(rs.getFloat(5));
				datos.setTotalBruto(rs.getFloat(6));
				datos.setUmedida(rs.getString(7));
				proveedorLista.put(datos.getDescripcion(), datos);
				cont++;
			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(),
					"Aleraasdasdta!", JOptionPane.ERROR_MESSAGE);

		}
		return proveedorLista;
	}// seleccionar

	public Hashtable<String, arregloProductosTempHash> seleccionarDescripcionesPorTipoProductoTablaHash(
			Connection conn, String tipoProd) {
		int totalRows = 0;
		Hashtable<String, arregloProductosTempHash> proveedorLista = new Hashtable<String, arregloProductosTempHash>();

		try {

			int cont = 0;
			PreparedStatement statement0 = conn
					.prepareStatement("select count(ID_TP) from tipo_producto limit 200");
			ResultSet rs1 = statement0.executeQuery();
			while (rs1.next()) {
				totalRows = rs1.getInt(1);

			}

			PreparedStatement statement = conn
					.prepareStatement("SELECT p.ID_PRO,p.ID_TP, p.DESCRIPCION,p.PVP,"
							+ " p.EQ_UNIDAD, sum(i.TOTAL_BRUTO),u.Nomenclatura "
							+ " FROM producto p,unidad_medida u, inventario i "
							+ " where p.id_tp="
							+ "(select id_tp from tipo_producto where descripcion_tp like '"
							+ tipoProd
							+ "')"
							+ " and p.ID_UNIDAD_MEDIDA=u.ID_UNIDAD_MEDIDA "
							+ "  and p.ID_PRO=i.ID_PRO " + " group by 1 ");

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				arregloProductosTempHash datos = new arregloProductosTempHash();
				datos.setUmedida(rs.getString(7));
				datos.setIdProd(rs.getInt(1));
				datos.setTipoProducto(rs.getInt(2));
				datos.setDescripcion(rs.getString(3));
				datos.setPvp(rs.getFloat(4));
				datos.setEquivalenteUnidad(rs.getFloat(5));
				datos.setTotalBruto(rs.getFloat(6));

				proveedorLista.put(datos.getDescripcion(), datos);

			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(),
					"Alerta!2", JOptionPane.ERROR_MESSAGE);

		}
		return proveedorLista;
	}// seleccionar

	/**
	 * Ingresa un nuevo lote al sistema
	 */

	public int insertarLote(Connection conn, InventarioDetalle objeto,
			String User) {
		try {

			PreparedStatement statement = conn
					.prepareStatement("insert into inventario ( ID_PRO, PRECIO_COMPRA, TOTAL_BRUTO, FECHA_ING, FECHA_CAD) values (?, ?, ?, ?, ?)");

			statement.setInt(1, objeto.getIdProducto());
			statement.setFloat(2, objeto.getPrecioCompra());
			statement.setFloat(3, objeto.getTotalBruto());
			statement.setString(4, objeto.getFechaIngreso());
			statement.setString(5, objeto.getFechaCaducidad());
			voidHistorialEliminaInsertaUser(conn, statement.toString(), User);
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Insertado un nuevo Lote de producto! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);
			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Modificó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// ingresar

	/**
	 * 
	 * 
	 * elimina lote de un producto existente
	 * 
	 * 
	 */

	public int eliminarLote(Connection conn, InventarioDetalle objeto,
			String User) {
		String Query1 = null;
		try {

			PreparedStatement statement = conn
					.prepareStatement("delete from inventario"
							+ " where  ID_PRO=" + objeto.getIdProducto() + ""
							+ " and PRECIO_COMPRA=" + objeto.getPrecioCompra()
							+ "" + " and    TOTAL_BRUTO="
							+ objeto.getTotalBruto() + " " + " and FECHA_ING='"
							+ objeto.getFechaIngreso() + "' "
							+ " and FECHA_CAD='" + objeto.getFechaCaducidad()
							+ "'");

			voidHistorialEliminaInsertaUser(conn, statement.toString(), User);
			statement.execute();
			statement.close();

			JOptionPane.showMessageDialog(null,
					"Se ha Eliminado un Lote de producto! ", "Aviso!",
					JOptionPane.INFORMATION_MESSAGE);

			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "No se Modificó Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// eliminar

	/**
	 * Ingresa un nuevo lote al sistema
	 */

	public int modificarLote(Connection conn, InventarioDetalle objeto) {
		try {
		//	id:inv276
		//	id pro0
		//	id total1.0
			PreparedStatement statement = conn.prepareStatement(""
					+ "						update inventario" + " 						set"
					+ " 						TOTAL_BRUTO = ?"
					+ "						where ID_INVENTARIO = ?");
			statement.setFloat(1, objeto.getTotalBruto());
			statement.setInt(2, objeto.getIdInventario());

			statement.execute();
			statement.close();

			return 1;

		} catch (Exception e) {

			JOptionPane.showMessageDialog(null,
					"No se Modificó cantidad en lote de producto!:"
							+ e.getMessage(), "Alerta!1",
					JOptionPane.ERROR_MESSAGE);
			return 0;
		}

	}// modificar

	/**
	 * crea un registro de historial si se hace una modificación en el stock del
	 * producto
	 * 
	 * @param Query1
	 * @param User
	 */
	public int voidHistorialEliminaInsertaUser(Connection conn, String Query1,
			String User) {

		try {
			Query1 = Query1.replace("'", " ");
			PreparedStatement statement = conn.prepareStatement(""
					+ "insert into historial values('" + User + "',curdate(),'"
					+ Query1 + "', localtime())");

			statement.execute();
			statement.close();

			return 1;

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
					+ e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);

			return 0;
		}

	}

	/**
	 * Entrega un arreglo de productos con cantidades
	 * 
	 * @param conn
	 * @param idproducto
	 * @return
	 */

	public Object[][] retornarCantidadLoteItemsInventario(Connection conn,
			int idproducto) {
		int totalRows = 0;

		Object datos2[][] = null;

		Object datos[][];
		try {
			PreparedStatement statement = conn.prepareStatement(" SELECT "
					+ " ID_INVENTARIO, ID_PRO,  TOTAL_BRUTO,  FECHA_CAD "
					+ " FROM inventario " + " where total_bruto>0 and ID_PRO="
					+ idproducto + " " + " order by FECHA_CAD " + " ");
			ResultSet rs = statement.executeQuery();
			rs.last();
			totalRows = rs.getRow();
			datos = new Object[totalRows][4];
			rs.beforeFirst();
			int cont = 0;
			while (rs.next()) {

				datos[cont][0] = rs.getString(1);
				datos[cont][1] = rs.getString(2);
				datos[cont][2] = rs.getString(3);
				datos[cont][3] = rs.getString(4);

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

	/**
	 * devuelve el ultimo id de producto del sistema
	 * 
	 * @param conn
	 * @return
	 */
	public int maxIdProducto(Connection conn) {
		int totalRows = 0;

		try {
			PreparedStatement statement = conn.prepareStatement("select"
					+ " max(id_pro)" + " from producto");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {

				totalRows = Integer.parseInt(rs.getString(1));

			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
					JOptionPane.ERROR_MESSAGE);

		}
		return totalRows;

	}

}// end clase

