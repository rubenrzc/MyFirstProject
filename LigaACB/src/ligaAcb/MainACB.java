package ligaAcb;

import java.util.ArrayList;

public class MainACB {

	public static void main(String[] args) {
		int opc;
		ArrayList<Persona> personal = new ArrayList<Persona>();

		do {
			opc = menu();

			switch (opc) {
			case 1: {
				alta(personal);
				break;
			}
			case 2: {
				newPartido(personal);
				break;
			}
			case 3: {
				modificarTcnico(personal);
				break;
			}
			case 4: {
				listaJugador(personal);
				break;
			}
			case 5: {
				break;
			}
			}

		} while (opc != 6);
	}

	private static void listaJugador(ArrayList<Persona> personal) {
		String wequipo;
		wequipo=Util.introducirCadena("Introduce el nombre del equipo");
		for(Persona p:personal) {
			
		}
	}

	private static void modificarTcnico(ArrayList<Persona> personal) {
		String wdni,wnombre,wapellido;
		int agregar,buscar;
		boolean esta = false, estaNA=false;
		wdni = Util.introducirCadena("Introduce DNI del tecnico a buscar");
		for (Persona p : personal) {
			if (p instanceof Tecnico && p.getDni().equalsIgnoreCase(wdni)) {
				((Tecnico) p).getDatosTecnico();
				esta = true;
				agregar = Util.leerInt("Quieres modificar los datos del tecnico(1=SI,2=NO)", 1, 2);
				if (agregar == 1) {
					((Tecnico) p).setDatos();
					break;
				}
			
			}
		}
		if(!esta) {
			System.out.println("El tecnico no esta dado de alta en la base de datos de la liga con este dni");
		}
		buscar=Util.leerInt("Quieres buscarlo por nombre y apellidos(1=SI,2=NO", 1, 2);
		if(buscar==1) {
			wnombre=Util.introducirCadena("Introduce nombre a buscar");
			wapellido=Util.introducirCadena("Introduce apellido a buscar");
			for (Persona p : personal) {
				if (p instanceof Tecnico && p.getNombre().equalsIgnoreCase(wnombre)&&p.getApellido().equalsIgnoreCase(wapellido)) {
					((Tecnico) p).getDatosTecnico();
					estaNA = true;
					agregar = Util.leerInt("Quieres modificar los datos del tecnico(1=SI,2=NO)", 1, 2);
					if (agregar == 1) {
						((Tecnico) p).setDatos();
						break;
					}
				
				}
			}
			
		}
		if(!estaNA) {
			System.out.println("El tecnico no esta dado de alta en la base de datos de la liga DEFINITIVAMENTE!!!!");
		}
	}

	private static void newPartido(ArrayList<Persona> personal) {
		String wdni;
		int agregar;
		boolean esta = false;
		wdni = Util.introducirCadena("Introduce DNI del jugador a buscar");
		for (Persona p : personal) {
			if (p instanceof Jugador && p.getDni().equalsIgnoreCase(wdni)) {
				((Jugador) p).getDatosJug();
				esta = true;
				agregar = Util.leerInt("Quieres introducir un partido nuevo(1=SI,2=NO", 1, 2);
				if (agregar == 1) {
					((Jugador) p).anadirPartido();
					break;
				}
			}
		}
		if (!esta)
			System.out.println("El jugador no esta dado de alta en la base de datos de la liga");
	}

	private static void alta(ArrayList<Persona> personal) {
		String wdni;
		boolean esta = false;
		Persona aux = null;
		int opc;

		wdni = Util.introducirCadena("Introduce el dni de la persona a dar de alta");
		esta = comprobarEsta(wdni, personal);

		if (!esta) {
			opc = Util.leerInt("La persona a dar de alta es tecnico o jugador(1=tecnico,2=jugador)", 1, 2);
			if (opc == 1) {
				aux = new Tecnico(wdni);
			} else
				aux = new Jugador(wdni);
		}
		aux.setDatos();
		personal.add(aux);

	}

	private static boolean comprobarEsta(String wdni, ArrayList<Persona> personal) {
		boolean esta = false;
		for (Persona p : personal) {
			if (p.getDni().equals(wdni)) {
				esta = true;
			}
		}
		return esta;
	}

	private static int menu() {
		int opc;
		System.out.println("1.-Introducir personal de la ACB\r\n" + "2.-Añadir partido a un jugador\r\n"
				+ "3.-Cambiar de equipo,salario y/o cargo de un tecnico\r\n" + "4.-Lista de jugadores de un equipo\r\n"
				+ "5.-Estadistica de los caargos de cada equipo\r\n");
		opc = Util.leerInt("Introduce la opcion deseada", 1, 6);
		return opc;
	}

}
