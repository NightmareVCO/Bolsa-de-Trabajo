package logico;

public class EmpTecnico extends SolEmpresa
{
	private String area;
	private int agnos;

	public EmpTecnico(String codigo, boolean movilidad, String contrato, boolean licencia, String cuidad, boolean activa,
			String rnc, float porcentajeMacth, String tipoSalario, float sueldo, int cantidad, String area, int agnos)
	{
		super(codigo, movilidad, contrato, licencia, cuidad, sueldo, activa, rnc, porcentajeMacth, tipoSalario, cantidad);
		this.area = area;
		this.agnos = agnos;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public int getAgnos()
	{
		return agnos;
	}

	public void setAgnos(int agnos)
	{
		this.agnos = agnos;
	}
}