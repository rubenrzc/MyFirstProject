package ligaAcb;

import java.time.LocalDate;
import java.time.Period;

public class Persona {
	protected String dni;
	protected String nombre;
	protected String apellido;
	protected LocalDate fechaNac;
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
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
	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public void setDatos(String dni) {
		this.dni=dni;
		nombre=Util.introducirCadena("Introduce nombre");
		apellido=Util.introducirCadena("Introduce apellido");
		fechaNac=Util.leerFecha("Introduce fecha de nacimiento(ejemplo:14/03/1983)");
	}
	public void getDatos() {
		System.out.println(apellido+" "+nombre+" con DNI "+dni+" nacido el "+fechaNac);
	}
	public int getEdad() {
		Period edad=Period.between(fechaNac, LocalDate.now());
		return edad.getYears();
	}
	public Persona() {
		super();
	}
	public Persona(String dni) {
		super();
		this.dni = dni;
	}
	public void setDatos() {
		nombre=Util.introducirCadena("Introduce nombre");
		apellido=Util.introducirCadena("Introduce apellido");
		fechaNac=Util.leerFecha("Introduce fecha de nacimiento(ejemplo:14/03/1983)");
	}


	
}