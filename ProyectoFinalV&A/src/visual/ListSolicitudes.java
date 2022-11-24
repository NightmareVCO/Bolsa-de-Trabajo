package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bolsa;
import logico.EmpObrero;
import logico.EmpTecnico;
import logico.EmpUniversitario;
import logico.Obrero;
import logico.Persona;
import logico.SoliEmpresa;
import logico.SoliPersona;
import logico.Solicitud;
import logico.Tecnico;
import logico.Universitario;

public class ListSolicitudes extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnEliminar;
	private JButton btnSalir;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Solicitud solicitud = null;

	public ListSolicitudes()
	{
		setTitle("Lista de Solicitudes");
		setBounds(100, 100, 683, 505);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					String[] columnas = { "Codigo", "Cliente", "Cedula/RNC", "Nombre", "Tipo" };
					model.setColumnIdentifiers(columnas);
					table = new JTable();
					table.setModel(model);
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		loadSolicitudes();
	}

	private void loadSolicitudes()
	{
		Persona aux = null;
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Solicitud solicitud : Bolsa.getInstance().getSolicitudes())
		{
			rows[0] = solicitud.getCodigo();

			if (solicitud instanceof SoliEmpresa)
				rows[1] = "Empresa";
			else if (solicitud instanceof SoliPersona)
				rows[1] = "Persona";

			if (solicitud instanceof SoliEmpresa)
				rows[2] = ((SoliEmpresa) solicitud).getRnc();
			else if (solicitud instanceof SoliPersona)
				rows[2] = ((SoliPersona) solicitud).getCedula();

			rows[3] = "Nombre del Cliente";

			if (solicitud instanceof SoliPersona)
			{
				//buscar la persona
				if (aux instanceof Universitario)
					rows[4] = "Universatario";
				else if (aux instanceof Tecnico)
					rows[4] = "Tecnico";
				if (aux instanceof Obrero)
					rows[4] = "Obrero";
			}
			else if (solicitud instanceof SoliEmpresa)
			{
				if (solicitud instanceof EmpUniversitario)
					rows[4] = "Universatario";
				else if (solicitud instanceof EmpTecnico)
					rows[4] = "Tecnico";
				else if (solicitud instanceof EmpObrero)
					rows[4] = "Obrero";
			}

			model.addRow(rows);
		}
	}
}
