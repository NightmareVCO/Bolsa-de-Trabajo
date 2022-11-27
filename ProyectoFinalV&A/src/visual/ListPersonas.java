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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import logico.Bolsa;
import logico.Obrero;
import logico.Persona;
import logico.Tecnico;
import logico.Universitario;

@SuppressWarnings("serial")
public class ListPersonas extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnCancelar;
	private JButton btnEliminar;
	private static DefaultTableModel model;
	private static Object[] rows;
	private Persona selected = null;

	public ListPersonas()
	{
		setTitle("Lista de personas");
		setBounds(100, 100, 683, 505);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
					String[] columnas = { "Cedula", "Nombre", "Tipo", "Telefono", "Direccion" };
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
								selected = Bolsa.getInstance()
										.buscarPersonaByCedula(table.getValueAt(rowSelected, 0).toString());
							}
						}
					});
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						int option;
						option = JOptionPane.showConfirmDialog(null,
								"Esta seguro que desea eliminar a: " + selected.getNombre(), "Confirmacion",
								JOptionPane.YES_NO_OPTION);
						if (option == JOptionPane.OK_OPTION)
						{
							Bolsa.getInstance().eliminarPersona(selected);
							loadPersons();
							btnEliminar.setEnabled(false);
						}
					}
				});
				btnEliminar.setEnabled(false);
				btnEliminar.setActionCommand("OK");
				buttonPane.add(btnEliminar);
				getRootPane().setDefaultButton(btnEliminar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		loadPersons();
	}

	private void loadPersons()
	{
		model.setRowCount(0);
		rows = new Object[model.getColumnCount()];

		for (Persona person : Bolsa.getInstance().getPersonas())
		{
			rows[0] = person.getId();
			rows[1] = person.getNombre();

			if (person instanceof Universitario)
				rows[2] = "Universitario";

			else if (person instanceof Tecnico)
				rows[2] = "Tecnico";

			else if (person instanceof Obrero)
				rows[2] = "Obrero";

			rows[3] = person.getTelefono();
			rows[4] = person.getDireccion();

			model.addRow(rows);
		}

	}

}
