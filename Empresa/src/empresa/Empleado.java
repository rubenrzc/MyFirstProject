package empresa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
//prueba repositorio ruben fran
public class Empleado implements Comparable<Empleado>{
	private String nombre,apellido,dni;
	private int numSorteo;
	private LocalDate fechaNac,fechaAlt;
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getNumSorteo() {
		return numSorteo;
	}
	public void setNumSorteo(int numSorteo) {
		this.numSorteo = numSorteo;
	}
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public LocalDate getFechaAlt() {
		return fechaAlt;
	}
	public void setFechaAlt(LocalDate fechaAlt) {
		this.fechaAlt = fechaAlt;
	}
	public void setDatos() {
		dni=Util.introducirCadena("Introduce DNI del empleado");
		nombre=Util.introducirCadena("Introduce nombre del empleado");
		apellido=Util.introducirCadena("Introduce apellido del puto empleado");
		numSorteo=(int)(Math.random()*100)+1;
		DateTimeFormatter formato=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		boolean error=false;
		do {
			error=false;
		String fechaN=Util.introducirCadena("Introduce fecha de nacimiento(ej:14-03-1983)");
		try{
			fechaNac=LocalDate.parse(fechaN, formato);
		}catch(DateTimeParseException e){
			error=true;
			System.out.println("Error la fecha introducida no cumple con el formato(ej:14-03-1983)");
		}
		}while(error);
		int opc = Util.leerInt("Introduce fecha de alta, para introducir la fecha actual pulse 1, para introducir otra fecha 0", 0, 1);
		if(opc==1) {
			fechaAlt=LocalDate.now();
		}else {
			do {
				error=false;
			String fechaA=Util.introducirCadena("Introduce la fecha de alta(ej:14-03-1983)");
			try{
				fechaAlt=LocalDate.parse(fechaA, formato);
			}catch(DateTimeParseException e){
				System.out.println("Error la fecha introducida no cumple con el formato(ej:14-03-1983)");
			}
		
		}while(error);
	}
	
	}
	public void getDatos() {
		System.out.println(nombre+" "+apellido+" fecha de nacimiento: "+fechaNac+" fecha de alta: "+fechaAlt+"con DNI "+dni);
	}
	@Override
	public int compareTo(Empleado emple) {
		return this.apellido.compareToIgnoreCase(emple.apellido);
	}
	
}
