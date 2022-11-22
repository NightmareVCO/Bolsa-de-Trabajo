package logico;

import java.util.ArrayList;

public class EmpObrero extends SolEmpresa
{
	private ArrayList<String> oficios;

	public EmpObrero(String codigo, boolean movilidad, String contrato, boolean licencia, String cuidad, boolean activa,
			String rnc, float porcentajeMacth, String tipoSalario, float sueldo, int cantidad, ArrayList<String> oficios)
	{
		super(codigo, movilidad, contrato, licencia, cuidad, sueldo, activa, rnc, porcentajeMacth, tipoSalario, cantidad);
		oficios = new ArrayList<String>();
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
