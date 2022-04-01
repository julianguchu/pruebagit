package Principal;

public class ExceppcionMia  extends  Exception{
	
	private String mensaje ;
	
	ExceppcionMia(String mensaje ){
	
		super(mensaje);
		this.mensaje=mensaje;
		
	
	}
	
	
	
	public String  getMensaje () {
		
		return this.mensaje;
		
	}
	
	
	
	public void  setMensaje(String mensaje) {
		
		this.mensaje=mensaje;
		
		
	}
}
