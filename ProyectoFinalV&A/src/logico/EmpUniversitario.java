package logico;

public class EmpUniversitario extends SolEmpresa
{
	private String carrera;
	private int agnos;

	public EmpUniversitario(String codigo, boolean movilidad, String contrato, boolean licencia, String cuidad,
			boolean activa, String rnc, float porcentajeMacth, String tipoSalario, float sueldo, int cantidad,
			String carrera, int agnos)
	{
		super(codigo, movilidad, contrato, licencia, cuidad, sueldo, activa, rnc, porcentajeMacth, tipoSalario, cantidad);
		this.carrera = carrera;
		this.agnos = agnos;
	}

	public String getCarrera()
	{
		return carrera;
	}

	public void setCarrera(String carrera)
	{
		this.carrera = carrera;
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
