package logico;

import java.util.ArrayList;

public class Bolsa
{
	private ArrayList<Persona> personas;
	private ArrayList<Solicitud> solicitudes;
	private ArrayList<Empresa> empresas;
	private static Bolsa bolsa = null;
	public static int genSol = 1;
	public static int genPer = 1;
	public static int genEmp = 1;

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

	public boolean addPersona(Persona person)
	{
		genPer++;
		return personas.add(person);
	}

	public boolean addSolicitud(Solicitud soli)
	{
		genSol++;
		return solicitudes.add(soli);
	}

	public boolean addEmpresa(Empresa empresa)
	{
		genEmp++;
		return empresas.add(empresa);
	}

	public Empresa buscarEmpresaByRNC(String rnc)
	{
		boolean encontrado = false;
		int i = 0;
		Empresa aux = null;

		while (!encontrado && i < empresas.size())
		{
			if (empresas.get(i).getRnc().equalsIgnoreCase(rnc))
			{
				encontrado = true;
				aux = empresas.get(i);
			}
			i++;
		}
		return aux;
	}

	public Persona buscarPersonaByCedula(String cedula)
	{
		boolean encontrado = false;
		int i = 0;
		Persona aux = null;

		while (!encontrado && i < personas.size())
		{
			if (personas.get(i).getId().equalsIgnoreCase(cedula))
			{
				encontrado = true;
				aux = personas.get(i);
			}
			i++;
		}
		return aux;
	}

	public Solicitud buscarSolicitudByCodigo(String codigo)
	{
		boolean encontrado = false;
		int i = 0;
		Solicitud aux = null;

		while (!encontrado && i < solicitudes.size())
		{
			if (solicitudes.get(i).getCodigo().equalsIgnoreCase(codigo))
			{
				encontrado = true;
				aux = solicitudes.get(i);
			}
			i++;
		}
		return aux;
	}

	public boolean eliminarSolicitud(Solicitud solicitud)
	{
		return solicitudes.remove(solicitud);
	}

	public boolean eliminarPersona(Persona person)
	{
		return personas.remove(person);
	}

	public boolean eliminarEmpresa(Empresa empresa)
	{
		return empresas.remove(empresa);
	}

	public boolean isLibreSoliEmp(String RNC)
	{
		boolean libre = true;
		for (Solicitud solicitud : solicitudes)
			if (solicitud instanceof SoliEmpresa && ((SoliEmpresa) solicitud).getRnc().equalsIgnoreCase(RNC))
				libre = false;

		return libre;
	}
}
