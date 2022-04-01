package Principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

import Principal.*;
import ClasesAdicionales.Animal;
import ClasesAdicionales.Clientes;
import ClasesAdicionales.Covento;
import ClasesAdicionales.Iglesia;
import ClasesAdicionales.Perro;
import ClasesAdicionales.SerVivo;
import ClasesAdicionales.Vaticano;

public class Principal { 
	public static   String  tipoEjemplo= "Consumer";
	public static 	String letras="";
	
	public static void main(String[] args) throws Exception {
		
		String[]  myarreglo =   {"d", "2"};
		List<String> atrreglo=Arrays.asList(myarreglo);
		
		//String [] arregloModificado=atrreglo.stream().toArray(String[] :: new);
		
		/*
		 ejemplo  Consumidor (permite recibir un elemento y no devuelve nada
		 */
	try {
		
		Vaticano c11 = new Covento() ; System.out.println(c11.plazas());
		String  nombre1 ="julian";
		Clientes  cli = new Clientes ();
		cli.setApellido("garcia");
		cli.setNombre("julian");
		
		Perro p1 = new Perro();
		p1.modificarReferencia(cli, nombre1);
		
		System.out.println("objetos: "+ cli.getNombre() + " " + cli.getApellido() + " " +  nombre1 );
		
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.US);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2009);
		c.set(Calendar.MONTH, 7);
		c.set(Calendar.DAY_OF_MONTH, 1);
		String formattedDate = df.format(c.getTime());
		System.out.println(formattedDate); 
		


	SerVivo n = new Perro();

		new Perro().metodoanumal();
		System.out.println(new Perro().getalgo());
		
		
		
		 String  tipoEjemplo= "Consumer";	Clientes  client= new Clientes("fox", "Garcia"); 
		Consumer<Clientes>  consumidor=  (cliente)->{System.out.println( new StringBuilder().append("ejemplo " )
					  	                                                                     .append(Principal.tipoEjemplo)
					  	                                                                     .append(":")
																							.append(cliente.getNombre())
																						    .append(" ")
																						    .append(cliente.getApellido())
																						    	);};
		consumidor.accept(client);

		
		
		/*
		  ejemplo supplier  admite  el tipo reretorno y retorna algo
		 * 
		 */

		Supplier<Clientes> suplie = ()->{ return  new  Clientes("Christian", "Guchubo");};
		Clientes  devolucion=suplie.get();
		Principal.tipoEjemplo="Supplier";
		consumidor.accept(devolucion);
		List <String>as = new ArrayList<String>();
		List asw = new ArrayList();
		
		
		/*
		 * 
		 ejemplo function: admite  dos tipo... uno es el de parametro y el otro es del retorno(mezcla consumer -supplier)
		 * 
		 * 
		 */
		Function<String , Clientes> funcion =  (nombre)->{return  new Clientes(nombre, "GarciaFijo");};
		
		Clientes  cFuncion= funcion.apply("Tommi");
		Principal.tipoEjemplo= "Function";
		consumidor.accept(cFuncion);
		
		// ejemplo fucntion con referencias 
		
		
		Function<String , Clientes> funcion1 =  Principal::devolverClientes;
		tipoEjemplo="Function Referencias";
		Clientes clienteRefe= funcion.apply("Miryitassss");
		consumidor.accept(clienteRefe);
		
		// ejemplo  stream funciones  findfirst(devuelve un optional y a ese le usa el  orelsethrow o culauqier otro orelse)
		
		System.out.println( "---------------------------Stream  FindFirst------------------------");
		String miStream = Stream.of("julina", "garcia", "pedro", "julian").peek(System.out::println).filter(objeto -> objeto.equals("julian")).findFirst().orElseThrow( () ->   new ExceppcionMia("no se pudo hacer nada"));
		
	System.out.println("Primer  elemento encontrado por el findFirst:"+ miStream);
	
	
	
	System.out.println( "---------------------------Stream  AnYmATCH------------------------");
	Stream <String> anyMatch =   Stream.of("lucas", "trama", "rata");
	Boolean  condicion= anyMatch.anyMatch(objeto -> objeto.equals("rata"));
	System.out.println("EL ELEMENTO EXISTE?:"+ condicion);
	
//StringBuilder  letras= new StringBuilder();
	
	System.out.println("--------------------Ejercicio 1 :-----------------------");

	List<String> arreglo = Arrays.asList("Abraham", "Carlos", "Daniel" , "Esteban", "Francisco","Gsutavo", "Hugo", "Ignacio");
	Stream<String> ccc =arreglo.stream().filter(objeto -> objeto.length() %2 ==0);//.forEach(System.out::println);;
	
	System.out.println("--------------------Ejercicio 2 :-----------------------");
	arreglo.stream().map(objeto ->{
	return 	objeto.charAt(0);
	}).forEach(objeto ->{
		
	//letras.append(objeto);
		letras = letras+objeto;
		
	});;
	System.out.println(letras);
	System.out.println("--------------------Ejercicio 3 :-----------------------");
	Stream<String>arregloModificado=arreglo.stream().map(String::toUpperCase);
	arregloModificado.forEach(System.out::println);
	
	
	
	System.out.println("--------------------Ejercicio 4 :-----------------------");
	

	List<Integer>  numeros =  Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	new 	Thread(()-> numeros.forEach(System.out::println)).start();
	System.out.println("----------------------");
	
	
	Integer resultado= 11000;
	// resultado inicia como valor pasado a a y b como el valor del array, despues  el return a+b pasa a ser a y b sigue siendo el next del array
	
	System.out.println(numeros.stream().reduce(resultado, (a,b)-> a+b)); /* o 
	System.out.println(numeros.stream().reduce(resultado, Integer::sum));*/
	
	//comprobado que si en el flujo hay conjuntos hace el recorrido por conjuntos en el foreach
FileReader f =	new FileReader("D:\\algo.txt");
	BufferedReader w = new BufferedReader(f);
	w.lines().peek(System.out::println).flatMap(linea ->  Arrays.asList(linea.split(" ")).stream()   ).forEach(System.out::println);;
	
	Clientes c1= new  Clientes("Julian", "Garcia");
	c1.getTelefonos().add("123456789");
	c1.getTelefonos().add("0123456789");
	c1.getTelefonos().add("789456123");
	Clientes c2= new  Clientes("Raul", "Perez");
	c2.getTelefonos().add("111000111");
	c2.getTelefonos().add(null);
	c2.getTelefonos().add("000000000");
	Clientes c3= new  Clientes("Julian", "Guchubo");
	c3.getTelefonos().add("555555555");
	c3.getTelefonos().add("111111111");
	c3.getTelefonos().add("222222222");
	        Stream <Clientes>  sClientes= Stream.of( c1,c2,c3);                
	sClientes.forEach(objetog->{
		
	objetog.getTelefonos().stream().forEach(e->{
		System.out.println(objetog.getNombre() + " " + objetog.getApellido());
		System.out.println(e);
	});
		
	});
	

	List<Clientes> a= Arrays.asList(c1,c2,c3);
	a.stream().forEach(System.out::println);
	c1.setNombre("sdasdasd");
	a.stream().forEach(System.out::println);
	List<Clientes> b = new ArrayList<>();
	b.add(c1);
	b.add(c2);
	b.add(c3);
	b.stream().forEach(System.out::println);
	
	c1.setNombre("sdasdasd");
	
	b.stream().forEach(System.out::println);
	
	
	Stream <List<String>>  p  =Stream.of( c1,c2,c3).flatMap(x->{return Stream.of(x.getTelefonos());}); 
Stream.of( c1,c2,c3).filter(nombre  ->  nombre.getNombre().length()>0 ).peek(System.out::println).flatMap(ob -> ob.getTelefonos().stream()).forEach(System.out::println);
	
	System.out.println("dsad--------------------------d");
	//c.forEach(System.out::println);
	
	
	int i =0;
	List lista =  new ArrayList();
			lista.add(i);
			lista.add(new Integer(2));
			
			
			for (Object o : lista) {System.out.println(o);}
			 String d ="Hola;bienvenido;a;la;aplicación;";
			  String [] ps =d.split("\\;");
			  System.out.println(ps.length);
			  
			  System.out.println("---------------------------0");
			  
			  int[]   areglito= ordenar(new int[] {2,4,5,1,6,3,9,7,8,0,1});
	
			  for(int aaa: areglito) {System.out.println(aaa);}
			  System.out.println(factorial(6));
			  
	}
	catch(Exception e ) { System.out.println("resultado excepcion personalizada orelsethrow"+ ":"+ e.getMessage());}
		
		 
	}
	
	
	private  static  Clientes  devolverClientes(String nombre) {
		
		return  new Clientes(nombre, "peep");
		
	}
	
	
	public static int []  ordenar(int []  arreglo) {
		int[] ordenado =  new  int [arreglo.length-1];
		int temporal =0;
		int temporal2 =0;
	
		for (int i=0; i < arreglo.length;i++) {

			for(int p=i+1; p< arreglo.length;p++) {
	
			if(arreglo[i]>arreglo[p]) {
		   temporal= arreglo[i];
		  temporal2=arreglo[p];
		  arreglo[p]=temporal;
		  arreglo[i]=temporal2;
			}
			}
		}
		return arreglo;
	}
	
	public static  int factorial (int n ) {
		int total=1;
		if(n==0 || n==1) return 1;
		for(int i=1; i <=n; i++) {
			
			total*=i;
			
			
		}
		
		return total;
		
	}

}
