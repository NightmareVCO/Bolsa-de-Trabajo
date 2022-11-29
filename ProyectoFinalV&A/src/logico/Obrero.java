package logico;

import java.util.ArrayList;

@SuppressWarnings("serial")
public class Obrero extends Persona
{
	private ArrayList<String> oficios;

	public Obrero(String id, String nombre, String telefono, String direccion, ArrayList<String> oficios)
	{
		super(id, nombre, telefono, direccion);
		this.oficios = oficios;
	}

	public ArrayList<String> getOficios()
	{
		return oficios;
	}

	public void setOficios(ArrayList<String> oficios)
	{
		this.oficios = oficios;
	}
}
