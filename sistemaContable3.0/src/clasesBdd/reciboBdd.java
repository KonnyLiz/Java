package clasesBdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import clases.recibo;
import clases.reciboDetalle;

public class reciboBdd {

    /*
     * insertar registro en tabla recibo
     */
    public int insertar(Connection conn, recibo objeto) {
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into recibo_venta "
                            + "( NUMERO_RECIBO, ID_USER, ID_OT, CI_RUC, ID_TR, FECHA, CIUDAD, SUBTOTAL, TOTAL, IVA)"
                            + " values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            statement.setInt(1, objeto.getNumeroRecibo());
            statement.setInt(2, objeto.getIdUser());
            statement.setInt(3, objeto.getIdOrdenTrabajo());
            statement.setString(4, objeto.getCiRuc());
            statement.setInt(5, objeto.getIdTipoRecibo());
            statement.setString(6, objeto.getFecha());
            statement.setString(7, objeto.getCiudad());
            statement.setFloat(8, objeto.getSubtotal());
            statement.setFloat(9, objeto.getTotal());
            statement.setFloat(10, objeto.getIva());
            statement.execute();
            statement.close();

            JOptionPane.showMessageDialog(null,
                    "Se ha Ingresado un Nuevo Recibo! ", "Aviso! ",
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
     * Eliminar un registro existente
     *
     *
     */

    public int eliminar(Connection conn, recibo objeto) {
        try {

            PreparedStatement statement = conn
                    .prepareStatement("delete from recibo_venta where ID_RECIBO = ?");
            statement.setInt(1, objeto.getIdRecibo());
            statement.execute();
            statement.close();

            return 1;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "No se Eliminó Registro :"
                    + e.getMessage(), "Alerta!", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

    }// modificar

    public int insertarDetalle(Connection conn, reciboDetalle objeto) {
        try {
            PreparedStatement statement = conn
                    .prepareStatement("insert into recibo_detalle (ID_RECIBO, ID_PRO, DESCRIPCION, MEDIDA_X, MEDIDA_Y, PRECIO) values (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, objeto.getIdRecibo());
            statement.setInt(2, objeto.getIdProducto());
            statement.setString(3, objeto.getIdDescripcion());
            statement.setFloat(4, objeto.getIdMedidaX());
            statement.setFloat(5, objeto.getIdMedidaY());
            statement.setFloat(6, objeto.getPrecio());// sin iva
            // System.out.print(statement);
            statement.execute();
            statement.close();

            return 1;

        } catch (Exception e) {
            // jTextArea.append("\n:problema : "+e.getMessage());

            JOptionPane.showMessageDialog(null, "No se ingreso Registro :"
                    + e.getMessage(), "Alerta!2", JOptionPane.ERROR_MESSAGE);
            return 0;
        }

    }// insertar

    /*
     *
     * retorna el número que debe tener la factura siguiente
     *
     */

    public String seleccionarFactura(Connection conn) {
        String totalRows = "0";

        try {

            PreparedStatement statement0 = conn
                    .prepareStatement("select max(NUMERO_RECIBO)+1"
                            + " from recibo_venta " + " where ID_TR=1");
            ResultSet rs1 = statement0.executeQuery();
            while (rs1.next()) {
                totalRows = rs1.getString(1);
            }
            if (totalRows == null)
                totalRows = "1";

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
                    JOptionPane.ERROR_MESSAGE);

        }

        return totalRows;
    }// seleccionar los del mes

    /*
     *
     * retorna el número que debe tener la siguiente nota de venta
     *
     */

    public String seleccionarNotaVenta(Connection conn) {
        String totalRows = "0";

        try {

            PreparedStatement statement0 = conn
                    .prepareStatement("select max(NUMERO_RECIBO)+1"
                            + " from recibo_venta " + " where ID_TR=1");
            ResultSet rs1 = statement0.executeQuery();
            while (rs1.next()) {
                totalRows = rs1.getString(1);
            }
            if (totalRows == null)
                totalRows = "1";

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "" + e.getMessage(),
                    "Alerta3!", JOptionPane.ERROR_MESSAGE);

        }

        return totalRows;
    }// seleccionar los del mes

    /*
     *
     * retorna el siguiente numero de recibo para la tabla
     *
     */

    public String seleccionarSigRecibo(Connection conn) {
        String totalRows = "0";

        try {

            PreparedStatement statement0 = conn
                    .prepareStatement("select max(NUMERO_RECIBO)+1"
                            + " from recibo_venta " + " ");
            ResultSet rs1 = statement0.executeQuery();
            while (rs1.next()) {
                totalRows = rs1.getString(1);
            }
            if (totalRows == null)
                totalRows = "1";

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
                    JOptionPane.ERROR_MESSAGE);

        }

        return totalRows;
    }// seleccionar los del mes

    /**
     * devuelve los registros para la tabla recibo
     *
     * @param conn
     * @param Query
     *
     * @return Array[][]
     */
    // public String RegistrosPorFiltro(
    public Object[][] RegistrosPorFiltro(Connection conn, String Query) {
        int totalRows = 0;
        Object arreglo[][] = null;
        try {

            PreparedStatement statement = conn.prepareStatement("" + Query);

            ResultSet rs = statement.executeQuery();

            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            int cont = 0;

            Object arreglo2[][] = new Object[totalRows][6];
            for (int i = 0; i < totalRows; i++) {
                rs.next();
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
    }// registros por filtro

    public Object[][] ultimos40DiasRegistros(Connection conn, String Tipo) {
        int totalRows = 0;
        Object arreglo[][] = null;
        if (Tipo.compareToIgnoreCase("Facturas") == 0)
            Tipo = "" + 2;
        else
            Tipo = "" + 1;
        try {

            PreparedStatement statement = conn
                    .prepareStatement("SELECT "
                            + "  ID_RECIBO, NUMERO_RECIBO, ID_OT, c.NOMBRE,TOTAL,FECHA"
                            + " FROM recibo_venta r,cliente c "
                            + " where r.CI_RUC=c.CI_RUC "
                            + "  AND ID_TR = "
                            + Tipo
                            + ""
                            + "  and  FECHA  BETWEEN  DATE_SUB(CURRENT_DATE(), INTERVAL 50 DAY) AND  CURRENT_DATE "
                            + "   order by 2 and 5");

            ResultSet rs = statement.executeQuery();

            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            int cont = 0;

            Object arreglo2[][] = new Object[totalRows][6];
            for (int i = 0; i < totalRows; i++) {
                rs.next();
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
    }// seleccionar

    public String devolverSiRegistroDetalle(Connection conn) {
        String totalRows = "0";

        try {

            PreparedStatement statement0 = conn
                    .prepareStatement("select max(ID_RECIBO) +1"
                            + " from recibo_venta " + " ");
            ResultSet rs1 = statement0.executeQuery();
            while (rs1.next()) {
                totalRows = rs1.getString(1);
            }
            if (totalRows == null)
                totalRows = "1";

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
                    JOptionPane.ERROR_MESSAGE);

        }

        return totalRows;
    }// seleccionar los del mes


    /**
     * Verifica si el recibo existe
     * @param conn
     * @param tipo
     * @param numero
     * @return
     */
    public String ChecarExistenciaRecibo(Connection conn,int tipo, int numero) {

        String totalRows = "0";

        try {

            PreparedStatement statement0 = conn
                    .prepareStatement("SELECT numero_recibo " +
                            " FROM recibo_venta " +
                            " where ID_TR="+tipo+" " +
                            " and " +
                            " NUMERO_RECIBO="+numero+ " ");
            ResultSet rs1 = statement0.executeQuery();
            while (rs1.next()) {
                totalRows = rs1.getString(1);
            }




        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "" + e.getMessage(), "Alerta!",
                    JOptionPane.ERROR_MESSAGE);

        }

        return totalRows;

    }

}
