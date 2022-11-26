package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
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
import logico.Empresa;
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
	private Solicitud selected = null;
	Persona persona = null;
	Empresa empresa = null;
	private JButton btnMostrar;

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
					table.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							int rowSelected = -1;
							rowSelected = table.getSelectedRow();
							if (rowSelected >= 0)
							{
								btnEliminar.setEnabled(true);
								btnMostrar.setEnabled(true);
								selected = Bolsa.getInstance()
										.buscarSolicitudByCodigo(table.getValueAt(rowSelected, 0).toString());
							}
						}
					});
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
				btnMostrar = new JButton("Mostrar");
				btnMostrar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
					}
				});
				btnMostrar.setEnabled(false);
				buttonPane.add(btnMostrar);
			}
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int option;
						if (selected != null)
						{
							option = JOptionPane.showConfirmDialog(null,
									"Está seguro que desea eliminar la solicitud con código: " + selected.getCodigo(),
									"Confirmación", JOptionPane.YES_NO_OPTION);
							if (option == JOptionPane.OK_OPTION)
							{
								Bolsa.getInstance().eliminarSolicitud(selected);
								loadSolicitudes();
							}
						}
					}
				});
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
			}
		}
		loadSolicitudes();
	}

	private void loadSolicitudes()
	{
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];
		for (Solicitud solicitud : Bolsa.getInstance().getSolicitudes())
		{
			if (solicitud instanceof SoliPersona)
				persona = Bolsa.getInstance().buscarPersonaByCedula(((SoliPersona) solicitud).getCedula());
			if (solicitud instanceof SoliEmpresa)
				empresa = Bolsa.getInstance().buscarEmpresaByRNC(((SoliEmpresa) solicitud).getRnc());

			rows[0] = solicitud.getCodigo();

			if (solicitud instanceof SoliEmpresa)
				rows[1] = "Empresa";
			else if (solicitud instanceof SoliPersona)
				rows[1] = "Persona";

			if (solicitud instanceof SoliEmpresa)
				rows[2] = ((SoliEmpresa) solicitud).getRnc();
			else if (solicitud instanceof SoliPersona)
				rows[2] = ((SoliPersona) solicitud).getCedula();

			if (solicitud instanceof SoliEmpresa)
				rows[3] = empresa.getNombre();
			else if (solicitud instanceof SoliPersona)
				rows[3] = persona.getNombre();

			if (solicitud instanceof SoliPersona)
			{
				if (persona instanceof Universitario)
					rows[4] = "Universatario";
				else if (persona instanceof Tecnico)
					rows[4] = "Tecnico";
				if (persona instanceof Obrero)
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

			persona = null;
			empresa = null;

			model.addRow(rows);
		}
	}
}
