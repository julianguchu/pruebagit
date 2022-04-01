package Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import ClasesAdicionales.DBA;
import ClasesAdicionales.Empleados;
import ClasesAdicionales.Financer;

public class Main2 {

	public static void main(String[] args) {
	List<Empleados> listaEmpleados=  new ArrayList<>();

	listaEmpleados.add(new DBA("JUAN", "123123123", 70));
	listaEmpleados.add(new DBA("lucas", "12569845", 10));
	listaEmpleados.add(new DBA("christian garcia", "1069726541", 30));
	listaEmpleados.add(new Financer("juan", "13456", "module 27"));
	List<DBA> listDba= new ArrayList<>();
	List<Financer> listFinancer= new ArrayList<>();
	for(Object o : listaEmpleados) {
		
		if(o instanceof DBA) {
			DBA  aux=  (DBA)o;
			
			listDba.add(aux);
		}
		else if ( o instanceof  Financer)
		{		
		Financer f=(Financer)o;
		listFinancer.add(f);
		}
		
	}
	
	listDba.forEach(System.out::println);
	System.out.println("--------------------");
	listFinancer.forEach(System.out::println);
	
	System.out.println("----------stream-------");
	
	 listaEmpleados.stream().filter( obj -> obj instanceof DBA).map(objDba-> (DBA)objDba).forEach(System.out::println);
	}
}
