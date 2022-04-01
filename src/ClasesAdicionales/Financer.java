package ClasesAdicionales;

public class Financer extends Empleados {

	
	
	 private   String privateOffice;
	 
	 
	public Financer(String nombre, String cedula, String privateOfice) {
		super(nombre, cedula);
		this.privateOffice= privateOfice;
	}


	public String getPrivateOffice() {
		return privateOffice;
	}


	public void setPrivateOffice(String privateOffice) {
		this.privateOffice = privateOffice;
	}


	@Override
	public String toString() {
		return "Financer [privateOffice=" + privateOffice + ", getNombre()=" + getNombre() + ", getCedula()="
				+ getCedula() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
	
	
}
