package ligaAcb;

import java.util.ArrayList;

public class Jugador extends Persona{
	private int dorsal;
	private String equipo;
	private String posicion;
	private ArrayList<Partido>partidos=new ArrayList<Partido>();
	
	
	public Jugador() {
		super();
	}

	public Jugador(String dni) {
		super(dni);
	}
	
	public int getDorsal() {
		return dorsal;
	}


	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}
	public void anadirPartido() {
		Partido aux=new Partido();
		aux.setDatos();
		partidos.add(aux);
	}
	public void setDatos() {
		super.setDatos();
		dorsal=Util.leerInt("Introduce dorsal del jugador");
		equipo=Util.introducirCadena("Equipo al que pertenece");
		posicion=Util.introducirCadena("Posicion o posiciones que ocupa");
	}
	public void getDatosJug() {
		super.getDatos();
		System.out.println("Con dorsal "+dorsal+" juega en el equipo "+equipo+" en la posicion "+posicion);
	}


	

}
