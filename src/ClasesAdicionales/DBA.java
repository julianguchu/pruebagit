package ClasesAdicionales;

public class DBA  extends Empleados{

	private  Integer porcentageAumentoSalario;
	
	
	public DBA(String nombre, String cedula,  Integer porcentageAumentoSalario ) {
		super(nombre, cedula);
		this.porcentageAumentoSalario=porcentageAumentoSalario;
		
	}


	public Integer getPorcentageAumentoSalario() {
		return porcentageAumentoSalario;
	}


	public void setPorcentageAumentoSalario(Integer porcentageAumentoSalario) {
		this.porcentageAumentoSalario = porcentageAumentoSalario;
	}


	@Override
	public String toString() {
		return "DBA [porcentageAumentoSalario=" + porcentageAumentoSalario + ", getNombre()=" + getNombre()
				+ ", getCedula()=" + getCedula() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
	
}
