package logico;

public class Universitario extends Persona
{
	private String carrera;
	private int agnos;
	
	public Universitario(String id, String nombre, String telefono, String direccion, boolean contratado, String carrera,
			int agnos)
	{
		super(id, nombre, telefono, direccion, contratado);
		this.carrera = carrera;
		this.agnos = agnos;
	}

	public String getCarrera()
	{
		return carrera;
	}

	public void setCarrera(String carrera)
	{
		this.carrera = carrera;
	}

	public int getAgnos()
	{
		return agnos;
	}

	public void setAgnos(int agnos)
	{
		this.agnos = agnos;
	}
}
