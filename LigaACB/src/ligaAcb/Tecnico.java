package ligaAcb;

public class Tecnico extends Persona{
	private String equipo;
	private float salario;
	private String cargo;


	public Tecnico() {
		super();
	}

	public Tecnico(String dni) {
		super(dni);
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public void setDatos(String dni) {
		super.setDatos(dni);
		equipo=Util.introducirCadena("Introduce equipo");
		salario=Util.leerFloat("Introduce e salario");
		cargo=Util.introducirCadena("Introduce cargo que ostenta");
	}
	public void setDatos() {
		super.setDatos();
		equipo=Util.introducirCadena("Introduce equipo");
		salario=Util.leerFloat("Introduce e salario");
		cargo=Util.introducirCadena("Introduce cargo que ostenta");
	}
	public void getDatosTecnico() {
		super.getDatos();
		System.out.println("Perteenece al equipo "+equipo+" y tiene el cargo de "+cargo+" con un salario de "+salario+"€");
	}

	

	

	
}
