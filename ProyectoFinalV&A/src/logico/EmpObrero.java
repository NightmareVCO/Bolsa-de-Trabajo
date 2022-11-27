package logico;

import java.util.ArrayList;

public class EmpObrero extends SoliEmpresa
{
	private ArrayList<String> oficios;

	public EmpObrero(String codigo, boolean movilidad, String contrato, boolean licencia, String cuidad, String rnc,
			float porcentajeMacth, String tipoSalario, float sueldo, ArrayList<String> idiomas, int cantidad,
			ArrayList<String> oficios)
	{
		super(codigo, movilidad, contrato, licencia, cuidad, sueldo, idiomas, rnc, porcentajeMacth, tipoSalario,
				cantidad);
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
