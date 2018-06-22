package facturasdellamadas;

	import java.util.Date;
	import java.util.TimerTask;
	public   class Tiempo {
	final java.util.Timer tmr = new java.util.Timer();
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("hh:mm:ss");

	public String iniciarTiempo()
		 {
		    tmr.scheduleAtFixedRate(new TimerTask()
		    {
		      public void run()
		      {    	 
		        System.out.print("\r"+sdf.format(new Date()));
		      }
		    },0,1000);
		    
		    return sdf.format(new Date());
		    
		  }

	public String detener() throws InterruptedException
		
		{
		tmr.cancel();
	   	 return sdf.format(new Date());
		}
	
}
