package logico;

public class SolEmpresa extends Solicitud
{
	protected String rnc;
	protected float porcentajeMacth;
	protected String tipoSalario;
	protected float sueldo;
	protected int cantidad;

	public SolEmpresa(String codigo, boolean movilidad, String contrato, boolean licencia, String cuidad, boolean activa,
			String rnc, float porcentajeMacth, String tipoSalario, float sueldo, int cantidad)
	{
		super(codigo, movilidad, contrato, licencia, cuidad, activa);
		this.rnc = rnc;
		this.porcentajeMacth = porcentajeMacth;
		this.tipoSalario = tipoSalario;
		this.sueldo = sueldo;
		this.cantidad = cantidad;
	}

	public String getRnc()
	{
		return rnc;
	}

	public void setRnc(String rnc)
	{
		this.rnc = rnc;
	}

	public float getPorcentajeMacth()
	{
		return porcentajeMacth;
	}

	public void setPorcentajeMacth(float porcentajeMacth)
	{
		this.porcentajeMacth = porcentajeMacth;
	}

	public String getTipoSalario()
	{
		return tipoSalario;
	}

	public void setTipoSalario(String tipoSalario)
	{
		this.tipoSalario = tipoSalario;
	}

	public float getSueldo()
	{
		return sueldo;
	}

	public void setSueldo(float sueldo)
	{
		this.sueldo = sueldo;
	}

	public int getCantidad()
	{
		return cantidad;
	}

	public void setCantidad(int cantidad)
	{
		this.cantidad = cantidad;
	}

	@Override
	public boolean checkEstado()
	{
		// TODO Auto-generated method stub
		return false;
	}

}
