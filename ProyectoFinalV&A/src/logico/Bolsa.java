package logico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

	public void cambiarRNC(String antiguo, String nuevo)
	{
		for (Solicitud solicitud : solicitudes)
			if (solicitud instanceof SoliEmpresa && ((SoliEmpresa) solicitud).getRnc().equalsIgnoreCase(antiguo))
				((SoliEmpresa) solicitud).setRnc(nuevo);
	}

	public boolean isLibreSoliPer(String cedula)
	{
		boolean libre = true;
		for (Solicitud solicitud : solicitudes)
			if (solicitud instanceof SoliPersona && ((SoliPersona) solicitud).getCedula().equalsIgnoreCase(cedula))
				libre = false;

		return libre;
	}

	public void cambiarCedula(String antiguo, String nuevo)
	{
		for (Solicitud solicitud : solicitudes)
			if (solicitud instanceof SoliPersona && ((SoliPersona) solicitud).getCedula().equalsIgnoreCase(antiguo))
				((SoliPersona) solicitud).setCedula(nuevo);
	}

	public float match(SoliEmpresa solicitudEmpresa, SoliPersona solicitudPersona)
	{
		float porcentaje = 21;
		return porcentaje;
	}
	
	public void guardarArchivo() throws IOException, ClassNotFoundException
	{
		FileOutputStream fPerOut = new FileOutputStream("C:/Personas.dat");
		ObjectOutputStream oosPer = new ObjectOutputStream(fPerOut);
		
		FileOutputStream fEmpOut = new FileOutputStream("C:/Empresas.dat");
		ObjectOutputStream oosEmp = new ObjectOutputStream(fEmpOut);
		
		FileOutputStream fSolOut = new FileOutputStream("C:/Solicitudes.dat");
		ObjectOutputStream oosSol = new ObjectOutputStream(fSolOut);
		
		int cantPer = personas.size();
		oosPer.writeInt(cantPer);
		for (Persona person : personas)
		{
			oosPer.writeObject(person);
		}
		fPerOut.close();
		
		int cantEmp = empresas.size();
		oosEmp.writeInt(cantEmp);
		for (Empresa emp : empresas)
		{
			oosEmp.writeObject(emp);
		}
		fEmpOut.close();
		
		int cantSol = solicitudes.size();
		oosSol.writeInt(cantSol);
		for (Solicitud soli : solicitudes)
		{
			oosSol.writeObject(soli);
		}
		fSolOut.close();
	}
	
	public void cargarArchivo() throws IOException, ClassNotFoundException
	{
		FileInputStream fPerIn = new FileInputStream("C:/FicherosJava/Personas.dat");
		ObjectInputStream oisPer = new ObjectInputStream(fPerIn);
		
		FileInputStream fEmpIn = new FileInputStream("C:/FicherosJava/Empresas.dat");
		ObjectInputStream oisEmp = new ObjectInputStream(fEmpIn);
		
		FileInputStream fSolIn = new FileInputStream("C:/FicherosJava/Solicitudes.dat");
		ObjectInputStream oisSol = new ObjectInputStream(fSolIn);
		
		int cantPer = oisPer.readInt();
		for(int i = 0; i < cantPer; i++)
		{
			Persona aux = (Persona)oisPer.readObject();
			personas.add(aux);
		}
		fPerIn.close();
		
		int cantEmp = oisEmp.readInt();
		for(int i = 0; i < cantEmp; i++)
		{
			Empresa aux = (Empresa)oisEmp.readObject();
			empresas.add(aux);
		}
		fEmpIn.close();
		
		int cantSol = oisSol.readInt();
		for(int i = 0; i < cantSol; i++)
		{
			Solicitud aux = (Solicitud)oisSol.readObject();
			solicitudes.add(aux);
		}
		fSolIn.close();
	}
}
