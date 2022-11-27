package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import logico.Bolsa;
import logico.Obrero;
import logico.Persona;
import logico.SoliPersona;
import logico.Tecnico;
import logico.Universitario;

@SuppressWarnings("serial")
public class SolPersona extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNombre;
	private JButton btnBuscar;
	private JTextField txtDireccion;
	private JRadioButton rdbtnLicenciaSi;
	private JRadioButton rdbtnLicenciaNo;
	private JRadioButton rdbtnMudarseNo;
	private JRadioButton rdbtnMudarseSi;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxArea;
	private JLabel lblcarrera;
	private JLabel lblarea;
	private JSpinner spnAgnos;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxContrato;
	private JSpinner spnSalario;
	private JTextField txtCodigo;
	private JTextField txtIdiomas;
	private JButton btnAgregarIdioma;
	private JButton btnSolicitar;
	private JButton btnCancelar;
	private JTextField txtTelefono;
	private JPanel PanelTipoSolicitud;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxCiudad;
	@SuppressWarnings("rawtypes")
	private JComboBox cbxCarrera;
	private JLabel lblagnos;
	private boolean mov = false;
	private boolean lic = false;
	private ArrayList<String> idiomasAux;
	private ArrayList<String> actividades;
	private int selected = -1;
	private DefaultListModel<String> ModelActividades;
	private JTextField txtActividades;
	private JPanel PanelAptitudes;
	private JLabel lblActividades;
	private JButton btnAgregarAct;
	@SuppressWarnings("rawtypes")
	private JList ListaActividades;
	private JButton btnEliminar;
	private JPanel PanelListaDeActividades;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SolPersona()
	{
		idiomasAux = new ArrayList<>();
		actividades = new ArrayList<>();
		setTitle("Registrar Solicitud de Persona");
		setBounds(100, 100, 613, 830);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			JPanel PanelDatos = new JPanel();
			PanelDatos.setBorder(new TitledBorder(null, "Datos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PanelDatos.setBounds(10, 11, 561, 203);
			panel.add(PanelDatos);
			PanelDatos.setLayout(null);

			JLabel lblNewLabel = new JLabel("Cedula:");
			lblNewLabel.setBounds(10, 27, 56, 16);
			PanelDatos.add(lblNewLabel);

			txtCedula = new JTextField();
			txtCedula.setBounds(80, 25, 163, 20);
			PanelDatos.add(txtCedula);
			txtCedula.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 70, 56, 16);
			PanelDatos.add(lblNewLabel_1);

			txtNombre = new JTextField();
			txtNombre.setEditable(false);
			txtNombre.setBounds(80, 68, 210, 20);
			PanelDatos.add(txtNombre);
			txtNombre.setColumns(10);

			btnBuscar = new JButton("Buscar");
			btnBuscar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Persona aux = Bolsa.getInstance().buscarPersonaByCedula(txtCedula.getText());
					if (aux != null)
					{
						txtNombre.setText(aux.getNombre());
						txtTelefono.setText(aux.getTelefono());
						txtDireccion.setText(aux.getDireccion());
					}
					else
					{
						txtNombre.setEditable(true);
						txtTelefono.setEditable(true);
						txtDireccion.setEditable(true);
					}
				}
			});
			btnBuscar.setBounds(454, 23, 97, 25);
			PanelDatos.add(btnBuscar);

			JLabel lblNewLabel_2 = new JLabel("Telefono:");
			lblNewLabel_2.setBounds(10, 113, 56, 16);
			PanelDatos.add(lblNewLabel_2);

			txtTelefono = new JTextField();
			txtTelefono.setEditable(false);
			txtTelefono.setBounds(80, 111, 178, 20);
			PanelDatos.add(txtTelefono);
			txtTelefono.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("Direccion:");
			lblNewLabel_3.setBounds(10, 156, 66, 16);
			PanelDatos.add(lblNewLabel_3);

			txtDireccion = new JTextField();
			txtDireccion.setEditable(false);
			txtDireccion.setBounds(80, 154, 300, 20);
			PanelDatos.add(txtDireccion);
			txtDireccion.setColumns(10);

			PanelAptitudes = new JPanel();
			PanelAptitudes
					.setBorder(new TitledBorder(null, "Aptitudes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PanelAptitudes.setBounds(12, 568, 561, 186);
			panel.add(PanelAptitudes);
			PanelAptitudes.setLayout(null);

			lblcarrera = new JLabel("Carrera:");
			lblcarrera.setBounds(12, 118, 56, 16);
			PanelAptitudes.add(lblcarrera);

			cbxCarrera = new JComboBox();
			cbxCarrera.setEnabled(false);
			cbxCarrera.setBounds(72, 116, 208, 20);
			PanelAptitudes.add(cbxCarrera);

			lblarea = new JLabel("Area:");
			lblarea.setBounds(12, 48, 56, 16);
			PanelAptitudes.add(lblarea);

			cbxArea = new JComboBox();
			cbxArea.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					if (!cbxArea.getSelectedItem().toString().equalsIgnoreCase("<Selecionar>"))
					{
						cbxCarrera.setEditable(true);
						cbxCarrera.setEnabled(true);

						if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias e Ingenieria"))
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Ing. Civil",
									"Ing. Mecanica", "Ing. Electrica", "Ing. Industrial y de Sistemas", "Ing. Mecatronica",
									"Ing. Ciencias de la Computacion", "Ing. Telematica", "Ing. Ambiental" }));

						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias de la Salud"))
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Estomatologia",
									"Medicina", "Nutricion y Dietetica", "Terapia Fisica" }));

						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias Administrativas"))
							cbxCarrera.setModel(new DefaultComboBoxModel(
									new String[] { "<Selecionar>", "Direccion Empresarial", "Administracion Hotelera",
											"Economia", "Gesttion Financiera y Adutoria", "Marketing", "Hospitalida y Turismo" }));

						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias Humanidades y Artes"))
							cbxCarrera.setModel(new DefaultComboBoxModel(
									new String[] { "<Selecionar>", "Arquitectura", "Comunicacion Social", "Derecho",
											"Diseño e Interiorismo", "Educacion", "Filosofia", "Trabajo Social" }));

						else
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>" }));
					}
				}
			});
			cbxArea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Ciencias de la Salud",
					"Ciencias e Ingenieria", "Ciencias Administrativas", "Ciencias Humanidades y Artes" }));
			cbxArea.setBounds(72, 46, 208, 20);
			PanelAptitudes.add(cbxArea);

			lblagnos = new JLabel("A\u00F1os:");
			lblagnos.setBounds(328, 52, 46, 14);
			PanelAptitudes.add(lblagnos);

			spnAgnos = new JSpinner();
			spnAgnos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnAgnos.setBounds(384, 49, 110, 20);
			PanelAptitudes.add(spnAgnos);

			lblActividades = new JLabel("Actividades:");
			lblActividades.setBounds(11, 84, 86, 14);
			PanelAptitudes.add(lblActividades);

			txtActividades = new JTextField();
			txtActividades.addKeyListener(new KeyAdapter()
			{
				@Override
				public void keyTyped(KeyEvent e)
				{
					if (txtActividades.getText().length() > 0)
						btnAgregarAct.setEnabled(true);
					else if (txtActividades.getText().length() < 1)
						btnAgregarAct.setEnabled(false);
				}
			});
			txtActividades.setBounds(90, 81, 185, 20);
			PanelAptitudes.add(txtActividades);
			txtActividades.setColumns(10);

			PanelListaDeActividades = new JPanel();
			PanelListaDeActividades.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Actividades:",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PanelListaDeActividades.setBounds(328, 31, 208, 130);
			PanelAptitudes.add(PanelListaDeActividades);
			PanelListaDeActividades.setLayout(new BorderLayout(0, 0));

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			PanelListaDeActividades.add(scrollPane, BorderLayout.CENTER);

			ModelActividades = new DefaultListModel<String>();
			ListaActividades = new JList();
			ListaActividades.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					selected = ListaActividades.getSelectedIndex();
					if (selected >= 0)
					{
						btnEliminar.setEnabled(true);
					}
				}
			});
			ListaActividades.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ListaActividades.setModel(ModelActividades);
			scrollPane.setViewportView(ListaActividades);

			btnAgregarAct = new JButton("Agregar");
			btnAgregarAct.setEnabled(false);
			btnAgregarAct.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					actividades.add(txtActividades.getText());
					txtActividades.setText("");
					ModelActividades.addElement(txtActividades.getText());
					btnAgregarAct.setEnabled(false);
					recargarActividades();
				}
			});
			btnAgregarAct.setBounds(90, 138, 86, 23);
			PanelAptitudes.add(btnAgregarAct);

			btnEliminar = new JButton("Eliminar");
			btnEliminar.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					actividades.remove(selected);
					recargarActividades();
					btnEliminar.setEnabled(false);
				}
			});
			btnEliminar.setEnabled(false);
			btnEliminar.setBounds(186, 138, 89, 23);
			PanelAptitudes.add(btnEliminar);

			JPanel PanelDatosSolicitud = new JPanel();
			PanelDatosSolicitud.setBorder(
					new TitledBorder(null, "Datos de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PanelDatosSolicitud.setBounds(10, 225, 561, 252);
			panel.add(PanelDatosSolicitud);
			PanelDatosSolicitud.setLayout(null);

			JLabel lblNewLabel_7 = new JLabel("Contrato:");
			lblNewLabel_7.setBounds(12, 38, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_7);

			cbxContrato = new JComboBox();
			cbxContrato.setModel(new DefaultComboBoxModel(
					new String[] { "<Selecionar>", "Jornada Completa", "Media Jornada", "Jornada Mixta" }));
			cbxContrato.setBounds(78, 36, 147, 20);
			PanelDatosSolicitud.add(cbxContrato);

			JLabel lblNewLabel_8 = new JLabel("Codigo:");
			lblNewLabel_8.setBounds(265, 51, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_8);

			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(331, 48, 116, 22);
			txtCodigo.setText("SOL-" + Bolsa.genSol);
			PanelDatosSolicitud.add(txtCodigo);
			txtCodigo.setColumns(10);

			JLabel lblNewLabel_9 = new JLabel("Salario:");
			lblNewLabel_9.setBounds(12, 92, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_9);

			spnSalario = new JSpinner();
			spnSalario.setModel(new SpinnerNumberModel(new Float(1000), new Float(1), null, new Float(500)));
			spnSalario.setBounds(78, 90, 93, 20);
			PanelDatosSolicitud.add(spnSalario);

			JLabel lblNewLabel_4 = new JLabel("Licencia:");
			lblNewLabel_4.setBounds(12, 198, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_4);

			rdbtnLicenciaSi = new JRadioButton("Si");
			rdbtnLicenciaSi.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					rdbtnLicenciaNo.setSelected(false);
				}
			});
			rdbtnLicenciaSi.setBounds(78, 194, 48, 25);
			PanelDatosSolicitud.add(rdbtnLicenciaSi);

			rdbtnLicenciaNo = new JRadioButton("No");
			rdbtnLicenciaNo.setSelected(true);
			rdbtnLicenciaNo.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					rdbtnLicenciaSi.setSelected(false);
				}
			});
			rdbtnLicenciaNo.setBounds(128, 194, 48, 25);
			PanelDatosSolicitud.add(rdbtnLicenciaNo);

			JLabel lblNewLabel_5 = new JLabel("Puede mudarse:");
			lblNewLabel_5.setBounds(265, 185, 97, 16);
			PanelDatosSolicitud.add(lblNewLabel_5);

			rdbtnMudarseSi = new JRadioButton("Si");
			rdbtnMudarseSi.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					rdbtnMudarseNo.setSelected(false);
				}
			});
			rdbtnMudarseSi.setBounds(368, 181, 48, 25);
			PanelDatosSolicitud.add(rdbtnMudarseSi);

			rdbtnMudarseNo = new JRadioButton("No");
			rdbtnMudarseNo.setSelected(true);
			rdbtnMudarseNo.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					rdbtnMudarseSi.setSelected(false);
				}
			});
			rdbtnMudarseNo.setBounds(418, 181, 53, 25);
			PanelDatosSolicitud.add(rdbtnMudarseNo);

			JLabel lblNewLabel_11 = new JLabel("Idiomas:");
			lblNewLabel_11.setBounds(265, 118, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_11);

			txtIdiomas = new JTextField();
			txtIdiomas.addKeyListener(new KeyAdapter()
			{
				@Override
				public void keyTyped(KeyEvent e)
				{
					char c = e.getKeyChar();
					if (!Character.isAlphabetic(c) && (c != KeyEvent.VK_BACK_SPACE) && (c != KeyEvent.VK_SPACE))
						e.consume();

					if (txtIdiomas.getText().length() > 1)
						btnAgregarIdioma.setEnabled(true);
				}
			});
			txtIdiomas.setBounds(331, 116, 86, 20);
			PanelDatosSolicitud.add(txtIdiomas);
			txtIdiomas.setColumns(10);

			btnAgregarIdioma = new JButton("Agregar");
			btnAgregarIdioma.setEnabled(false);
			btnAgregarIdioma.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					idiomasAux.add(txtIdiomas.getText());
					txtIdiomas.setText("");
					btnAgregarIdioma.setEnabled(false);
				}
			});
			btnAgregarIdioma.setBounds(442, 114, 97, 25);
			PanelDatosSolicitud.add(btnAgregarIdioma);

			JLabel label = new JLabel("Ciudad:");
			label.setBounds(12, 146, 46, 14);
			PanelDatosSolicitud.add(label);

			cbxCiudad = new JComboBox();
			cbxCiudad.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Azua", "Bahoruco", "Barahona",
					"Dajabon", "Distrito Nacional", "Duarte", "El Seybo", "Elias Piña", "Espaillat", "Hato Mayor",
					"Hermanas Mirabal", "Independencia", "La Altagracia", "La Romana", "La Vega", "Maria Trinidad Sanchez",
					"Monseñor Nouel", "Monte Plata", "Montecristi", "Pedernales", "Peravia", "Puerto Plata", "Samana",
					"San Cristobal", "San Jose De Ocoa", "San Juan", "San Pedro De Macoris", "Sanchez Ramirez", "Santiago",
					"Santiago Rodriguez", "Santo Domingo", "Valverde" }));
			cbxCiudad.setBounds(78, 143, 147, 20);
			PanelDatosSolicitud.add(cbxCiudad);

			PanelTipoSolicitud = new JPanel();
			PanelTipoSolicitud.setBounds(12, 485, 561, 72);
			panel.add(PanelTipoSolicitud);
			PanelTipoSolicitud.setLayout(null);
			PanelTipoSolicitud.setBorder(
					new TitledBorder(null, "Tipo de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

			rdbtnUniversitario = new JRadioButton("Universatario");
			rdbtnUniversitario.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					rdbtnObrero.setSelected(false);
					rdbtnTecnico.setSelected(false);
					lblarea.setVisible(true);
					cbxArea.setVisible(true);
					lblcarrera.setVisible(true);
					cbxCarrera.setVisible(true);
					lblagnos.setVisible(true);
					spnAgnos.setVisible(true);
					cbxArea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Ciencias de la Salud",
							"Ciencias e Ingenieria", "Ciencias Administrativas", "Ciencias Humanidades y Artes" }));
					lblActividades.setVisible(false);
					txtActividades.setVisible(false);
					btnAgregarAct.setVisible(false);
					PanelListaDeActividades.setVisible(false);
					btnEliminar.setVisible(false);
				}
			});
			rdbtnUniversitario.setSelected(true);
			rdbtnUniversitario.setBounds(75, 27, 108, 23);
			PanelTipoSolicitud.add(rdbtnUniversitario);

			rdbtnTecnico = new JRadioButton("Tecnico");
			rdbtnTecnico.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					rdbtnObrero.setSelected(false);
					rdbtnUniversitario.setSelected(false);
					lblcarrera.setVisible(false);
					cbxCarrera.setVisible(false);
					cbxArea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Amd. de Peq. Empresas",
							"Artes Culinarias", "Automatizacion", "Dise�o Grafico", "Enfermeria", "Gestion Social", "Mercadeo",
							"Microfinanzas", "Publicidad y Medios Digistales", "Redes de Datos", }));
					lblActividades.setVisible(false);
					txtActividades.setVisible(false);
					btnAgregarAct.setVisible(false);
					PanelListaDeActividades.setVisible(false);
					btnEliminar.setVisible(false);
				}
			});
			rdbtnTecnico.setBounds(258, 27, 81, 23);
			PanelTipoSolicitud.add(rdbtnTecnico);

			rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.addMouseListener(new MouseAdapter()
			{
				@Override
				public void mouseClicked(MouseEvent e)
				{
					rdbtnUniversitario.setSelected(false);
					rdbtnTecnico.setSelected(false);
					lblarea.setVisible(false);
					cbxArea.setVisible(false);
					lblcarrera.setVisible(false);
					cbxCarrera.setVisible(false);
					lblagnos.setVisible(false);
					spnAgnos.setVisible(false);
					lblActividades.setVisible(true);
					txtActividades.setVisible(true);
					btnAgregarAct.setVisible(true);
					PanelListaDeActividades.setVisible(true);
					btnEliminar.setVisible(true);
				}
			});
			rdbtnObrero.setBounds(414, 27, 69, 23);
			PanelTipoSolicitud.add(rdbtnObrero);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnSolicitar = new JButton("Solicitar");
				btnSolicitar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (validar())
						{
							Persona person = Bolsa.getInstance().buscarPersonaByCedula(txtCedula.getText());
							if (person == null)
							{
								if (rdbtnUniversitario.isSelected())
								{
									person = new Universitario(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(),
											txtDireccion.getText(), cbxCarrera.getSelectedItem().toString(),
											Integer.valueOf(spnAgnos.getValue().toString()));
								}

								else if (rdbtnTecnico.isSelected())
								{
									person = new Tecnico(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(),
											txtDireccion.getText(), cbxArea.getSelectedItem().toString(),
											Integer.valueOf(spnAgnos.getValue().toString()));
								}

								else if (rdbtnObrero.isSelected())
								{
									person = new Obrero(txtCedula.getText(), txtNombre.getText(), txtTelefono.getText(),
											txtDireccion.getText(), actividades);
								}

								Bolsa.getInstance().addPersona(person);
							}

							if (rdbtnMudarseSi.isSelected())
								mov = true;

							if (rdbtnLicenciaSi.isSelected())
								lic = true;

							SoliPersona soli = new SoliPersona(txtCodigo.getText(), mov,
									cbxContrato.getSelectedItem().toString(), lic, cbxCiudad.getSelectedItem().toString(),
									Float.valueOf(spnSalario.getValue().toString()), idiomasAux, txtCedula.getText());
							Bolsa.getInstance().addSolicitud(soli);

							JOptionPane.showMessageDialog(null, "Solicitud Ingresada", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);

							clean();
						}
						else
							JOptionPane.showMessageDialog(null, "Solicitud Incompleta", "Informacion",
									JOptionPane.INFORMATION_MESSAGE);
					}
				});
				btnSolicitar.setActionCommand("OK");
				buttonPane.add(btnSolicitar);
				getRootPane().setDefaultButton(btnSolicitar);
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
		lblActividades.setVisible(false);
		txtActividades.setVisible(false);
		btnAgregarAct.setVisible(false);
		PanelListaDeActividades.setVisible(false);
		btnEliminar.setVisible(false);
		cargarActividades();
	}

	private void clean()
	{
		txtCedula.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		txtNombre.setEditable(false);
		txtTelefono.setEditable(false);
		txtDireccion.setEditable(false);
		cbxContrato.setSelectedIndex(0);
		txtCodigo.setText("SOL-" + Bolsa.genSol);
		spnSalario.setValue(new Float("1000"));
		txtIdiomas.setText("");
		rdbtnLicenciaNo.setSelected(true);
		rdbtnLicenciaSi.setSelected(false);
		rdbtnMudarseSi.setSelected(false);
		rdbtnMudarseNo.setSelected(true);
		btnAgregarIdioma.setEnabled(false);
		rdbtnTecnico.setSelected(false);
		rdbtnTecnico.setSelected(false);
		rdbtnUniversitario.setSelected(true);
		if (rdbtnUniversitario.isSelected() || rdbtnTecnico.isSelected())
			cbxArea.setSelectedIndex(0);
		if (rdbtnUniversitario.isSelected())
			cbxCarrera.setSelectedIndex(0);
		cbxCiudad.setSelectedIndex(0);
		spnAgnos.setValue(new Integer("0"));
		actividades.removeAll(actividades);
		idiomasAux.removeAll(idiomasAux);
		ModelActividades.removeAllElements();
	}

	private void cargarActividades()
	{
		ModelActividades.removeAllElements();
	}

	private void recargarActividades()
	{
		ModelActividades.removeAllElements();
		String aux = "";
		for (int i = 0; i < actividades.size(); i++)
		{
			aux = actividades.get(i);
			ModelActividades.addElement(aux);
		}
	}

	private boolean validar()
	{

		boolean validado = false;

		if (rdbtnUniversitario.isSelected() && (((txtCedula.getText().length() > 1) && (txtNombre.getText().length() > 1)
				&& (txtTelefono.getText().length() > 1) && (txtDireccion.getText().length() > 1)
				&& (cbxContrato.getSelectedIndex() > 0)) && (idiomasAux.size() > 0) && (cbxArea.getSelectedIndex() > 0)
				&& (cbxCarrera.getSelectedIndex() > 0) && (cbxCiudad.getSelectedIndex() > 0)))
			validado = true;
		else if (rdbtnTecnico.isSelected() && (((txtCedula.getText().length() > 1) && (txtNombre.getText().length() > 1)
				&& (txtTelefono.getText().length() > 1) && (txtDireccion.getText().length() > 1)
				&& (cbxContrato.getSelectedIndex() > 0) && (idiomasAux.size() > 0) && (cbxArea.getSelectedIndex() > 0)
				&& (cbxCiudad.getSelectedIndex() > 0))))
			validado = true;
		else if (rdbtnObrero.isSelected() && (((txtCedula.getText().length() > 1) && (txtNombre.getText().length() > 1)
				&& (txtTelefono.getText().length() > 1) && (txtDireccion.getText().length() > 1)
				&& (cbxContrato.getSelectedIndex() > 0) && (idiomasAux.size() > 0) && (cbxCiudad.getSelectedIndex() > 0)
				&& actividades.size() > 0)))
			validado = true;

		return validado;
	}
}
