package clasesBdd;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

import javax.swing.JOptionPane;



//**
/*
 *Permite conectar a una base de datos retornando el estado de la conexion o un mensaje de error
 *
 * */
public class conexionBdd {
	int contarIntentosConexion = 0;
	private String user="sistema";
	private String pass="200299";
	private String database="sistemamk";
	private String server="192.168.0.20";



/*
 * CONEXION BDD
 */
	public Connection getConexion() {
		Connection con = null;

		try {
			Driver d = (Driver) Class.forName("com.mysql.jdbc.Driver")
					.newInstance();

			con = DriverManager.getConnection(

				"jdbc:mysql://"+server+"/"+database+"", ""+user+"", ""+pass+"");

		//con = DriverManager.getConnection(
		 //"jdbc:mysql://127.0.0.1/sistemamk", "sistema", "bkxgui123");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"No se ha Podido Establecer Conexiòn con el servidor!",
					"Aviso", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
			if (contarIntentosConexion == 2) {
				JOptionPane.showMessageDialog(null,
						"Intento de Conexión fallido, Saliendo del Sistema!",
						"Aviso", JOptionPane.ERROR_MESSAGE);

				System.exit(1);
			}
			contarIntentosConexion++;
			return null;

		} finally {

			/*
			 * try { con.close(); } catch (SQLException e) { // TODO
			 * Auto-generated catch block e.printStackTrace(); }
			 */
		}

		return con;

	}

	/*
	 * Permite conocer el estado de la conexion con la Base de datos
	 */

	void TestConn() {
		Connection con = getConexion();
		JOptionPane.showMessageDialog(null, "Estado BDD: " + con.toString(),
				"Aviso", JOptionPane.ERROR_MESSAGE);

	}




	/**
	 * 2012-01-03
	 */





/**
 * Función que permite respaldar bases de datos mysql
 * del sistema
 *
 *  user
 *  pass
 *  database
 *  server
 *  nombreArchivo
 * @return boolean
 */
public boolean respaldarInformacion(String nombreArchivo){
        boolean estado=false;


		int BUFFER = 10485760;
		/**
		 * Guarda la ubicación para el archivo
		 */
		String path="bin/respaldos/"+nombreArchivo+".sql";
		String dumpCommand = "mysqldump --host="+server+" -u"+""+user+""+"  -p"+""+pass+""+"   "+" "+database+"";
		FileWriter fw = null;
		String tst = path;
		try{
		fw = new FileWriter(tst);
		fw.close();
		}catch(IOException ex){
		ex.printStackTrace();
		estado=false;
		}

		Runtime rt = Runtime.getRuntime();
		try{
		Process proc = rt.exec(dumpCommand);
		InputStream in = proc.getInputStream();
		/**
		 * si tienes otro tipo de caracteres en tu bdd puedes cambiarlo abajo
		 */
		InputStreamReader read = new InputStreamReader(in,"latin1");





		BufferedReader br = new BufferedReader(read);
		br = new BufferedReader(read);
		BufferedWriter bw = new BufferedWriter(new FileWriter(tst,true));
		StringBuffer buffer = new StringBuffer();
		int count;
		char[] cbuf = new char[BUFFER];
		while ((count = br.read(cbuf, 0, BUFFER)) != -1)
		buffer.append(cbuf, 0, count);
		String toWrite = buffer.toString();
		bw.write(toWrite);
		bw.close();
		estado=true;
		}catch (IOException e){
			e.printStackTrace();
		}
return estado;
}//fin de la funcion



}
