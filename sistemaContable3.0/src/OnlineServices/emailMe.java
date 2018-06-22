/*package OnlineServices;
import java.util.*;
/*
public class emailMe {
  public static void main(String[] args) {
    try {
      // Se debe crear un archivo de propiedades que
      // contenga el nombre del servidor SMTP
      Properties props = new Properties();
      props.put("mail.host", "mail.servidorcorreo.com");

      // se crea un objeto de sesion
      Session conexionCorreo = Session.getInstance(props, null);
      // este objeto representa el mensaje a enviar
      Message mensaje = new MimeMessage(conexionCorreo);

      // los objetos Adress contienen informacion de recipientes de correo
      Address desde = new InternetAddress("tucorreo@servidorcorreo.biz",
          "Pepito Perez");
      Address para = new InternetAddress("destinatario@otroservidor.com");

      // asignamos el contenido. En este caso usamos 'text/plain' pero
      // es posible usar 'text/html' para enviar correos con contenido
      // HTML
      mensaje.setContent("Este es un mensaje de texto plano!",
          "text/plain");
      // asignar el origen del correo
      mensaje.setFrom(desde);
      // asignar un destinatario
      mensaje.setRecipient(Message.RecipientType.TO, para);
      // asignar el asunto del correo
      mensaje.setSubject("Hola, Java Mail!");

      Transport.send(mensaje);

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}*/