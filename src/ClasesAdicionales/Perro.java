package ClasesAdicionales;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Perro extends Animal {
  public int  p =12;
	
	public void  metodoanumal() {
		
		System.out.println("metodo animal");
		String  al[] =   {"e","e"};
		
		
		for (String d : al) {
			
			System.out.println(d);
			
		}
	}
	
	
	public Collection<String> getalgo(){
		int p =1;
		 HashMap<String, Integer> d= new HashMap<>();
		 d.put("algo", 1);
		 
		 p+=1;
		 System.out.println(p++);
		 
		return   d.keySet();
		
	}
	public void  modificarReferencia(Clientes c, String  nombre ) {
		c.setNombre("christian");
		c.setApellido("guchubo");
		
		nombre="pedro";
		
		
	}
	
}
