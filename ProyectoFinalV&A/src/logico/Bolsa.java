package logico;

import java.util.ArrayList;

public class Bolsa
{
	private ArrayList<Persona> personas;
	private ArrayList<Solicitud> solicitudes;
	private ArrayList<Empresa> empresas;
	private static Bolsa bolsa = null;

	private Bolsa()
	{
		super();
		personas = new ArrayList<>();
		solicitudes = new ArrayList<>();
		empresas = new ArrayList<>();
	}

	public static Bolsa getInstance()
	{
		if (bolsa == null)
			bolsa = new Bolsa();

		return bolsa;
	}

	public ArrayList<Persona> getPersonas()
	{
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas)
	{
		this.personas = personas;
	}

	public ArrayList<Solicitud> getSolicitudes()
	{
		return solicitudes;
	}

	public void setSolicitudes(ArrayList<Solicitud> solicitudes)
	{
		this.solicitudes = solicitudes;
	}

	public ArrayList<Empresa> getEmpresas()
	{
		return empresas;
	}

	public void setEmpresas(ArrayList<Empresa> empresas)
	{
		this.empresas = empresas;
	}
}
