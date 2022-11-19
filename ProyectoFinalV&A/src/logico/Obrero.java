package logico;

import java.util.ArrayList;

public class Obrero extends Persona
{
	private ArrayList<String> oficios;

	public Obrero(String id, String nombre, String telefono, String direccion, boolean contratado)
	{
		super(id, nombre, telefono, direccion, contratado);
		oficios = new ArrayList<>();
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
