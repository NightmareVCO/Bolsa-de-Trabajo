package logico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Bolsa implements Serializable
{
	private static final long serialVersionUID = 1L;
	private ArrayList<Persona> personas;
	private ArrayList<Solicitud> solicitudes;
	private ArrayList<Empresa> empresas;
	private ArrayList<Usuario> usuarios;
	private static Bolsa bolsa = null;
	private static Usuario loginUser;
	public int genSol;

	private Bolsa()
	{
		super();
		personas = new ArrayList<>();
		solicitudes = new ArrayList<>();
		empresas = new ArrayList<>();
		usuarios = new ArrayList<>();
		genSol = 1;
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

	public ArrayList<Usuario> getUsuarios()
	{
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios)
	{
		this.usuarios = usuarios;
	}

	public static Usuario getLoginUser()
	{
		return loginUser;
	}

	public static void setLoginUser(Usuario loginUser)
	{
		Bolsa.loginUser = loginUser;
	}

	public int getGenSol()
	{
		return genSol;
	}

	public void setGenSol(int genSol)
	{
		this.genSol = genSol;
	}

	public boolean addPersona(Persona person)
	{
		return personas.add(person);
	}

	public boolean addSolicitud(Solicitud soli)
	{
		genSol++;
		return solicitudes.add(soli);
	}

	public boolean addEmpresa(Empresa empresa)
	{
		return empresas.add(empresa);
	}

	public boolean addUsuario(Usuario usuario)
	{
		return usuarios.add(usuario);
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

	public boolean elimianrUsuarios(Usuario usuario)
	{
		return usuarios.remove(usuario);
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

		FileOutputStream fBolsa = new FileOutputStream("C:\\JAVA\\Bolsa.dat");
		ObjectOutputStream oosBolsa = new ObjectOutputStream(fBolsa);
		oosBolsa.writeObject(bolsa);
		fBolsa.close();

	}

	public void cargarArchivo() throws IOException, ClassNotFoundException
	{
		try
		{
			FileInputStream fBolsa = new FileInputStream("C:\\JAVA\\Bolsa.dat");
			ObjectInputStream oosBolsa = new ObjectInputStream(fBolsa);
			bolsa = (Bolsa) oosBolsa.readObject();
			fBolsa.close();
			oosBolsa.close();
		}
		catch (FileNotFoundException e)
		{
			try
			{
				FileOutputStream fBolsa2 = new FileOutputStream("C:\\JAVA\\Bolsa.dat");
				ObjectOutputStream oosBolsa2 = new ObjectOutputStream(fBolsa2);
				Usuario usuario = new Usuario("administrador", "admin", "Administrador");
				Bolsa.getInstance().addUsuario(usuario);
				oosBolsa2.writeObject(bolsa);
				fBolsa2.close();
				oosBolsa2.close();
			}
			catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public boolean confirmarLogin(String username, String password)
	{
		boolean login = false;
		for (Usuario user : usuarios)
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
			{
				setLoginUser(user);
				login = true;
			}
		return login;
	}
	
	public float compararIdiomas(ArrayList<String> idiomasRequeridos, ArrayList<String> idiomaHablados)
	{
		float porcentaje = 0;
		float total = 10;
		int cantidadIdiomas = idiomasRequeridos.size();
		int cantidadEncontrados = 0;
		
		for (String idR : idiomasRequeridos)
		{
			for (String idH : idiomaHablados)
			{
				if(idH.equalsIgnoreCase(idR))
					cantidadEncontrados++;
			}
		}
		
		porcentaje = (cantidadEncontrados * 100) / cantidadIdiomas;
		
		return total * (porcentaje/100);
	}
	
	public float compararActividades (ArrayList<String> actividadesRequeridas, ArrayList<String> actividadesQueRealiza)
	{
		float porcentaje = 0;
		float total = 10;
		int cantidadOficios = actividadesRequeridas.size();
		int cantidadEncontrados = 0;
		
		for (String actReq : actividadesRequeridas)
		{
			for (String actRea : actividadesQueRealiza)
			{
				if(actReq.equalsIgnoreCase(actRea))
					cantidadEncontrados++;
			}
		}
		
		porcentaje = (cantidadEncontrados * 100) / cantidadOficios;
		
		return total * (porcentaje/100);
	}
	
	public float compararContratos (String contratoOfrecido, String contratoDeseado)
	{
		float total = 0;
		boolean coiciden = false;
		
		if(contratoOfrecido.equalsIgnoreCase(contratoDeseado))
			coiciden = true;
		
		else if(contratoOfrecido == "Jornada Completa" && contratoDeseado == "Jornada Mixta")
			coiciden = true;
		
		else if(contratoOfrecido == "Media Jornada" && contratoDeseado == "Jornada Mixta")
			coiciden = true;
		
		if(coiciden)
			total = 15;
		
		return total;
	}
	
	public float comprarSueldo (float sueldoQuePagan, float sueldoQueQuieren)
	{
		float porcentaje = 0;
		float total = 15;
		
		/*
			100% = 15%
			15/100
		*/
		
		if (sueldoQuePagan <= sueldoQueQuieren)
			porcentaje = 100;
		
		else
		{
			float diferencia = (sueldoQueQuieren - sueldoQuePagan) / sueldoQuePagan;
			float diffPorcentaje = diferencia * 100;
			
			if(diffPorcentaje == 100)
				porcentaje = 0;
			
			else if(diffPorcentaje >= 90)
				porcentaje = 10;
			
			else if(diffPorcentaje >= 80)
				porcentaje = 20;
			
			else if(diffPorcentaje >= 70)
				porcentaje = 30;
			
			else if(diffPorcentaje >= 60)
				porcentaje = 40;
			
			else if(diffPorcentaje >= 50)
				porcentaje = 50;
			
			else if(diffPorcentaje >= 40)
				porcentaje = 60;
			
			else if(diffPorcentaje >= 30)
				porcentaje = 70;
			
			else if(diffPorcentaje >= 20)
				porcentaje = 80;
			
			else if(diffPorcentaje >= 10)
				porcentaje = 90;
		}

	/*
	25% >, 75%
	50% >, 50%
	75% >, 25%
	100% >, 0%
	*/
		return total * (porcentaje/100);
	}
}
