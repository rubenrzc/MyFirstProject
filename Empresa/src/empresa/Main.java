package empresa;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		int opc;
		ArrayList<Empleado> emp = new ArrayList<Empleado>();

		do {
			opc = menu();

			switch (opc) {
			case 1: {
				alta(emp);
				break;
			}
			case 2: {
				lista(emp);
				break;
			}
			case 3: {
				listaOrd(emp);
				break;
			}
			case 4: {
				consultaMod(emp);
				break;
			}
			case 5: {
				borrar(emp);
				break;
			}
			case 6: {
				ordenEdad(emp);
				break;
			}
			case 7: {
				
			}
			case 8: {

			}
			case 9: {

			}
			case 10: {

			}
			}

		} while (opc != 11);
	}

	private static void ordenEdad(ArrayList<Empleado> emp) {
		Empleado aux;
		for(int i=0;i<emp.size();i++) {
			Period pi=Period.between(emp.get(i).getFechaNac(), LocalDate.now());
			for(int j=i+1;j<emp.size();j++) {
				Period pj=Period.between(emp.get(j).getFechaNac(), LocalDate.now());
				if(emp.get(i).getFechaNac().isBefore(emp.get(j).getFechaNac())) {
					aux=emp.get(i);
					emp.set(i, emp.get(j));
					emp.set(j, aux);
				}
			}
		}
		for(int i=0;i<emp.size();i++) {
			if(i==0)
				System.out.println("El empleado mas joven es:");
			if(i==emp.size()-1)
				System.out.println("El empleado mas mayor es:");
			emp.get(i).getDatos();
			}
	}

	private static void borrar(ArrayList<Empleado> emp) {
		String wdni=Util.introducirCadena("Introduce dni a eliminar");
		boolean esta=false;
		for(Empleado e:emp) {
			if(e.getDni().equalsIgnoreCase(wdni)) {
			esta=true;
			int borra=Util.leerInt("ELIMINAR empleado???1=SI,2=NO", 1, 2);
			if(borra==1) {
				emp.remove(e);
			}else
				System.out.println("Accion cancelada");
		}
		}
		if(!esta) {
			System.out.println("El DNI que busca no se encuentra en la base de datos");
		}
		
	}

	private static void consultaMod(ArrayList<Empleado> emp) {
		String wdni;
		wdni = Util.introducirCadena("Introduce el DNI a buscar");
		boolean esta = false;
		int opc,mod;
		DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy");

		for (Empleado e : emp) {
			if (e.getDni().equals(wdni)) {
				esta = true;
				opc = Util.leerInt("Desea modificar o consultar la informacion 1=Modificar,2=Consultar", 1, 2);
				if (opc == 2)
					e.getDatos();
				else {
					int menu=Util.leerInt(
							"MODIFICAR\r\n"+
							"1.-Nombre\r\n"+
							"2.-Apellido\r\n"+
							"3.-Fecha nacimiento\r\n"+
							"4.-Fecha alta",1,4);
					
					switch(menu) {
					case 1:{
						String newNombre=Util.introducirCadena("Introduce nuevo nombre:");
						e.setNombre(newNombre);
						System.out.println("Nombre modificado");
						break;
					}
					case 2:{
						String newApellido=Util.introducirCadena("Introduce nuevo apellido:");
						e.setApellido(newApellido);
						System.out.println("Apellido modificado");
						break;
					}
					case 3:{
						boolean error=false;
						do {
							error=false;
						String newFechaNac=Util.introducirCadena("Introduce nueva fecha de nacimiento(ej:14-03-1983)");
						try{
							e.setFechaNac(LocalDate.parse(newFechaNac, formato));
						}catch(DateTimeParseException t){
							error=true;
							System.out.println("Error la fecha introducida no cumple con el formato(ej:14-03-1983)");
						}
						}while(error);
						System.out.println("La fecha  de nacimiento se ha modificado");
						break;
					}
					case 4:{
						boolean error=false;
						do {
							error=false;
						String newFechaAlt=Util.introducirCadena("Introduce nueva fecha de alta(ej:14-03-1983)");
						try{
							e.setFechaNac(LocalDate.parse(newFechaAlt, formato));
						}catch(DateTimeParseException t){
							error=true;
							System.out.println("Error la fecha introducida no cumple con el formato(ej:14-03-1983)");
						}
						}while(error);
						System.out.println("La fecha de alta se ha modificado");
						break;
					}
					}
				}

			}
		}
		if(!esta)
			System.out.println("El dni no esta en nuestra base de datos");
	}

	private static void listaOrd(ArrayList<Empleado> emp) {
		Collections.sort(emp);
		for (Empleado e : emp) {
			e.getDatos();
		}

	}

	private static void lista(ArrayList<Empleado> emp) {
		for (Empleado aux : emp) {
			aux.getDatos();
		}

	}

	private static void alta(ArrayList<Empleado> emp) {
		Empleado aux = new Empleado();
		aux.setDatos();
		emp.add(aux);

	}

	private static int menu() {
		int opc;
		System.out.println("\r\n" + "1.-Introducir empleado\r\n" + "2.-Listado de empleado\r\n"
				+ "3.-Listado de empleados orden por apellido\r\n"
				+ "4.-Consultar/modificar datos del empleado a partir del DNI\r\n"
				+ "5.-Borrado de empleado por DNI\r\n"
				+ "6.-Listado de la edad de los empleados,se muestran el mas mayor y el menor\r\n"
				+ "7.-Edad de los empleados en el momento de su entrada a la empresa\r\n"
				+ "8.-Listado ordenado en descendente de la antigüedad de los empleados\r\n" 
				+"9.-Sorteo diario\r\n"
				+ "10.-Estadisticas\r\n");

		opc = Util.leerInt("Introduce la opcion que deseas", 1, 11);

		return opc;
	}

}
