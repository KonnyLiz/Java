package facturasdellamadas;

public class Llamada {

	  public String NumeroTelefono;

	  public Float DuracionMinutos;

	 Llamada() {
	  }

	  public void SetNumeroTelefono(String NumeroTelefono) {
		  this.NumeroTelefono=NumeroTelefono;
	  }

	  public void SetDuracionMinutos(Float min) {
		  
		  this.DuracionMinutos=min;
	  }

	  public String GetNumeroTelefono() {
	  return this.NumeroTelefono;
	  }

	  public Float GetDuracionMinutos() {
	  return this.DuracionMinutos;
	  }


}
