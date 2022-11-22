package logico;

import java.util.ArrayList;

public class SolPersona extends Solicitud
{
	private String cedula;
	private ArrayList<String> idiomas;

	public SolPersona(String codigo, boolean movilidad, String contrato, boolean licencia, String cuidad, float sueldo,
			boolean activa, String cedula, ArrayList<String> idiomas)
	{
		super(codigo, movilidad, contrato, licencia, cuidad, sueldo, activa);
		this.cedula = cedula;
		this.idiomas = idiomas;
	}

	public String getCedula()
	{
		return cedula;
	}

	public void setCedula(String cedula)
	{
		this.cedula = cedula;
	}

	public ArrayList<String> getIdiomas()
	{
		return idiomas;
	}

	public void setIdiomas(ArrayList<String> idiomas)
	{
		this.idiomas = idiomas;
	}

	@Override
	public boolean checkEstado()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
