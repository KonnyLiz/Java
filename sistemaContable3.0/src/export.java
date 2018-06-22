

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class export{



public static void export(){






int BUFFER = 10485760;





String path="bin/ruta_backup.sql";
String dumpCommand = "mysqldump  --host=192.168.0.20 -u"+"sistema"+"  -p"+"200299"+"   "+" sistemamk";
FileWriter fw = null;
String tst = path;
try{
fw = new FileWriter(tst);
fw.close();
}catch(IOException ex){
ex.printStackTrace();}

Runtime rt = Runtime.getRuntime();
try{
Process proc = rt.exec(dumpCommand);
InputStream in = proc.getInputStream();
InputStreamReader read = new InputStreamReader(in,"latin1");





BufferedReader br = new BufferedReader(read);br = new BufferedReader(read);
BufferedWriter bw = new BufferedWriter(new FileWriter(tst,true));
StringBuffer buffer = new StringBuffer();
int count;
char[] cbuf = new char[BUFFER];
while ((count = br.read(cbuf, 0, BUFFER)) != -1)
buffer.append(cbuf, 0, count);
String toWrite = buffer.toString();
bw.write(toWrite);
bw.close();
}catch (IOException e){
	e.printStackTrace();
}
}


public static void main(String []args){
	try
    {
		export asdasd=new export();
		export.export();



    }
    catch( Exception e)
    {
        e.printStackTrace();
    }
}

}



