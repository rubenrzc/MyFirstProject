package ligaAcb;

import java.time.LocalDate;

public class Partido {
	private int puntos;
	private int tiros;
	private int anotados;
	private LocalDate fecha;
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getTiros() {
		return tiros;
	}
	public void setTiros(int tiros) {
		this.tiros = tiros;
	}
	public int getAnotados() {
		return anotados;
	}
	public void setAnotados(int anotados) {
		this.anotados = anotados;
	}
	public void setDatos() {
		fecha=Util.leerFecha("Introduce fecha del partido");
		puntos=Util.leerInt("Puntos anotados");
		tiros=Util.leerInt("Tiros de campo");
		anotados=Util.leerInt("Tiros anotados");
	}
	

}
