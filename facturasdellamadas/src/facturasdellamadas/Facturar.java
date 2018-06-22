package facturasdellamadas;

public class Facturar {

    public Telefono Tel = new Telefono();
    public Tiempo time=new Tiempo();
    public Llamada Marcacion=new Llamada();

    public Float CostoLlamada;

    Facturar() {
    }
    public void RegistrarDatosLlamada(Float Tiempo) {
    	this.Marcacion.SetDuracionMinutos(Tiempo);
    }

    public float CalcularTotalLlamada(float t) {
    	
    	if(t==1)
    	{
    	System.out.println("No aplica a promocion -- cobrando tarifa a $0.15 por minuto");
    	return this.Marcacion.GetDuracionMinutos()*0.15f;
    	}
    
    	if(t==0)
    	{
    		
    		if(this.Marcacion.GetDuracionMinutos()>0 && this.Marcacion.GetDuracionMinutos()<=10)
    		{
    			System.out.println("No aplica a promocion -- cobrando tarifa a $0.15 por minuto");
    			return this.Marcacion.GetDuracionMinutos()*0.15f;
    			
    		}
    		
    		if(this.Marcacion.GetDuracionMinutos()>10 && this.Marcacion.GetDuracionMinutos()<=30)
    		{   
    			System.out.println("Aplica a promocion acumulable -- cobrando tarifa a $0.10");
    			float delta=this.Marcacion.GetDuracionMinutos()-10f;
    			return delta*0.1f +10*0.15f;
    			
    		}
    		
    		if(this.Marcacion.GetDuracionMinutos()>30 && this.Marcacion.GetDuracionMinutos()<60)
    		{   
    			System.out.println("Aplica a promocion acumulable  -- cobrando tarifa a $0.05");
    			float delta=this.Marcacion.GetDuracionMinutos()-30f;
    			return delta*0.05f +10*0.15f+20*0.1f;	
    		}
    		
    		if(this.Marcacion.GetDuracionMinutos()>60)
    		{   
    			System.out.println("Aplica a promocion acumulable -- cobrando tarifa a $0.01");
    			float delta=this.Marcacion.GetDuracionMinutos()-60f;
    			return delta*0.01f +10*0.15f+20*0.1f+30*0.05f;	
    		}
    		
    	}
    	System.out.println("tiene mala suerte joven");
    	return 0;
    
    }

	
}
