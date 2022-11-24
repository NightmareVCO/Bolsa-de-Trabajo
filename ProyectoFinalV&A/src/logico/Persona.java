package logico;

public abstract class Persona
{
	protected String cedula;
	protected String nombre;
	protected String telefono;
	protected String direccion;
	protected boolean contratado;

	public Persona(String cedula, String nombre, String telefono, String direccion, boolean contratado)
	{
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.contratado = contratado;
	}

	public String getId()
	{
		return cedula;
	}

	public void setId(String id)
	{
		this.cedula = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public String getTelefono()
	{
		return telefono;
	}

	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	public String getDireccion()
	{
		return direccion;
	}

	public void setDireccion(String direccion)
	{
		this.direccion = direccion;
	}

	public boolean isContratado()
	{
		return contratado;
	}

	public void setContratado(boolean contratado)
	{
		this.contratado = contratado;
	}
}