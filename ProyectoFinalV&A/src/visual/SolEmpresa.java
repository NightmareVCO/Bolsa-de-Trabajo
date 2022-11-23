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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class SolEmpresa extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtRNC;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCodigo;
	private JTextField txtIdioma;
	private JComboBox cbxArea;
	private JComboBox cbxCarrea;
	private JComboBox cbxCiudad;
	private JComboBox cbxTipoSalario;
	private JSpinner spnSalario;
	private JComboBox cbxContrato;
	private JRadioButton rdbtnLicenciaSi;
	private JRadioButton rdbtnLicenciaNo;
	private JRadioButton rdbtnMudarseSi;
	private JRadioButton rdbtnMudarseNo;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	private ArrayList<String> idiomasAux;
	private JButton btnValidar;
	private JButton btnRegistrar;
	private JButton btnCancelar;

	public static void main(String[] args)
	{
		try
		{
			SolEmpresa dialog = new SolEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SolEmpresa()
	{
		idiomasAux = new ArrayList<>();
		setResizable(false);
		setTitle("Registrar Solicitud de Empresa");
		setBounds(100, 100, 582, 776);
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
			PanelDatos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos:",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PanelDatos.setBounds(10, 11, 545, 178);
			panel.add(PanelDatos);
			PanelDatos.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("RNC:");
				lblNewLabel.setBounds(10, 24, 46, 14);
				PanelDatos.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setBounds(10, 62, 65, 14);
				PanelDatos.add(lblNewLabel_1);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Teléfono:");
				lblNewLabel_2.setBounds(10, 100, 65, 14);
				PanelDatos.add(lblNewLabel_2);
			}
			{
				JLabel lblNewLabel_3 = new JLabel("Dirección:");
				lblNewLabel_3.setBounds(10, 138, 65, 14);
				PanelDatos.add(lblNewLabel_3);
			}

			txtRNC = new JTextField();
			txtRNC.addKeyListener(new KeyAdapter()
			{
				@Override
				public void keyTyped(KeyEvent e)
				{
					char c = e.getKeyChar();
					if ((!Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE))
						e.consume();
				}
			});
			txtRNC.setBounds(76, 21, 163, 20);
			PanelDatos.add(txtRNC);
			txtRNC.setColumns(10);
			{
				txtNombre = new JTextField();
				txtNombre.addKeyListener(new KeyAdapter()
				{
					@Override
					public void keyTyped(KeyEvent e)
					{
						char c = e.getKeyChar();
						if ((!Character.isAlphabetic(c) && !(Character.isDigit(c))) && (c != KeyEvent.VK_BACK_SPACE)
								&& (c != KeyEvent.VK_SPACE))
							e.consume();
					}
				});
				txtNombre.setBounds(76, 59, 210, 20);
				PanelDatos.add(txtNombre);
				txtNombre.setColumns(10);
			}
			{
				txtTelefono = new JTextField();
				txtTelefono.addKeyListener(new KeyAdapter()
				{
					@Override
					public void keyTyped(KeyEvent e)
					{
						char c = e.getKeyChar();
						if ((!Character.isDigit(c)) && (c != KeyEvent.VK_BACK_SPACE))
							e.consume();
					}
				});
				txtTelefono.setBounds(76, 97, 163, 20);
				PanelDatos.add(txtTelefono);
				txtTelefono.setColumns(10);
			}
			{
				txtDireccion = new JTextField();
				txtDireccion.setBounds(76, 135, 300, 20);
				PanelDatos.add(txtDireccion);
				txtDireccion.setColumns(10);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(439, 20, 89, 23);
				PanelDatos.add(btnBuscar);
			}
			{
				JPanel PanelDatosSolicitud = new JPanel();
				PanelDatosSolicitud.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
						"Datos de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
				PanelDatosSolicitud.setBounds(10, 200, 545, 218);
				panel.add(PanelDatosSolicitud);
				PanelDatosSolicitud.setLayout(null);
				{
					JLabel lblNewLabel_4 = new JLabel("Contrato:");
					lblNewLabel_4.setBounds(10, 32, 59, 14);
					PanelDatosSolicitud.add(lblNewLabel_4);
				}
				{
					JLabel lblNewLabel_5 = new JLabel("Salario:");
					lblNewLabel_5.setBounds(10, 78, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_5);
				}

				spnSalario = new JSpinner();
				spnSalario.setModel(new SpinnerNumberModel(new Float(1000), new Float(0), null, new Float(500)));
				spnSalario.setBounds(66, 75, 93, 20);
				PanelDatosSolicitud.add(spnSalario);
				{
					JLabel lblNewLabel_6 = new JLabel("Tipo de Salario:");
					lblNewLabel_6.setBounds(286, 78, 127, 14);
					PanelDatosSolicitud.add(lblNewLabel_6);
				}
				{
					JLabel lblNewLabel_7 = new JLabel("Ciudad:");
					lblNewLabel_7.setBounds(10, 124, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_7);
				}
				{
					JLabel lblNewLabel_8 = new JLabel("Puede Mudarse:");
					lblNewLabel_8.setBounds(286, 170, 93, 14);
					PanelDatosSolicitud.add(lblNewLabel_8);
				}
				{
					rdbtnMudarseSi = new JRadioButton("Sí");
					rdbtnMudarseSi.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							rdbtnMudarseNo.setSelected(false);
						}
					});
					rdbtnMudarseSi.setBounds(385, 166, 59, 23);
					PanelDatosSolicitud.add(rdbtnMudarseSi);
				}
				{
					rdbtnMudarseNo = new JRadioButton("No");
					rdbtnMudarseNo.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							rdbtnMudarseSi.setSelected(false);
						}
					});
					rdbtnMudarseNo.setBounds(450, 166, 52, 23);
					PanelDatosSolicitud.add(rdbtnMudarseNo);
				}
				{
					JLabel lblNewLabel_9 = new JLabel("Licencia:");
					lblNewLabel_9.setBounds(10, 170, 59, 14);
					PanelDatosSolicitud.add(lblNewLabel_9);
				}
				{
					JRadioButton radioButton = new JRadioButton("Sí");
					radioButton.setBounds(6, 347, 52, 23);
					PanelDatosSolicitud.add(radioButton);
				}
				{
					JRadioButton radioButton = new JRadioButton("No");
					radioButton.setBounds(60, 347, 52, 23);
					PanelDatosSolicitud.add(radioButton);
				}
				{
					cbxCiudad = new JComboBox();
					cbxCiudad.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Santiago", "Santo Domingo",
							"Espallat", "La Vega", "San Francisco", "Licey", "Samana", "Higuey" }));
					cbxCiudad.setBounds(66, 121, 147, 20);
					PanelDatosSolicitud.add(cbxCiudad);
				}
				{
					cbxContrato = new JComboBox();
					cbxContrato.setModel(new DefaultComboBoxModel(
							new String[] { "<Selecionar>", "Jornada Completa", "Media Jornada", "Jornada Mixta" }));
					cbxContrato.setBounds(66, 29, 147, 20);
					PanelDatosSolicitud.add(cbxContrato);
				}
				{
					cbxTipoSalario = new JComboBox();
					cbxTipoSalario.setModel(new DefaultComboBoxModel(
							new String[] { "<Selecionar>", "Quincenal", "Mensual", "Semanal", "Diario" }));
					cbxTipoSalario.setBounds(379, 75, 123, 20);
					PanelDatosSolicitud.add(cbxTipoSalario);
				}
				{
					JLabel lblNewLabel_10 = new JLabel("Código:");
					lblNewLabel_10.setBounds(286, 32, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_10);
				}
				{
					txtCodigo = new JTextField();
					txtCodigo.setEditable(false);
					txtCodigo.setBounds(379, 29, 123, 20);
					PanelDatosSolicitud.add(txtCodigo);
					txtCodigo.setColumns(10);
				}
				{
					rdbtnLicenciaSi = new JRadioButton("Sí");
					rdbtnLicenciaSi.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							rdbtnLicenciaNo.setSelected(false);
						}
					});
					rdbtnLicenciaSi.setBounds(66, 166, 59, 23);
					PanelDatosSolicitud.add(rdbtnLicenciaSi);
				}
				{
					rdbtnLicenciaNo = new JRadioButton("No");
					rdbtnLicenciaNo.addMouseListener(new MouseAdapter()
					{
						@Override
						public void mouseClicked(MouseEvent e)
						{
							rdbtnLicenciaSi.setSelected(false);
						}
					});
					rdbtnLicenciaNo.setBounds(134, 166, 52, 23);
					PanelDatosSolicitud.add(rdbtnLicenciaNo);
				}
				{
					JLabel lblNewLabel_12 = new JLabel("Idiomas:");
					lblNewLabel_12.setBounds(286, 124, 59, 14);
					PanelDatosSolicitud.add(lblNewLabel_12);
				}
				{
					txtIdioma = new JTextField();
					txtIdioma.setBounds(342, 121, 86, 20);
					PanelDatosSolicitud.add(txtIdioma);
					txtIdioma.setColumns(10);
				}

				JButton btnAgregarIdioma = new JButton("Agregar");
				btnAgregarIdioma.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						idiomasAux.add(txtIdioma.getText());
						txtIdioma.setText("");
					}
				});
				btnAgregarIdioma.setBounds(438, 120, 86, 23);
				PanelDatosSolicitud.add(btnAgregarIdioma);
			}
			{
				JPanel PanelTipoSolicitud = new JPanel();
				PanelTipoSolicitud.setBorder(
						new TitledBorder(null, "Tipo de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				PanelTipoSolicitud.setBounds(10, 429, 545, 72);
				panel.add(PanelTipoSolicitud);
				PanelTipoSolicitud.setLayout(null);

				rdbtnUniversitario = new JRadioButton("Universatario");
				rdbtnUniversitario.setSelected(true);
				rdbtnUniversitario.setBounds(71, 27, 108, 23);
				PanelTipoSolicitud.add(rdbtnUniversitario);

				rdbtnTecnico = new JRadioButton("Técnico");
				rdbtnTecnico.setBounds(250, 27, 81, 23);
				PanelTipoSolicitud.add(rdbtnTecnico);

				rdbtnObrero = new JRadioButton("Obrero");
				rdbtnObrero.setBounds(402, 27, 69, 23);
				PanelTipoSolicitud.add(rdbtnObrero);
			}

			JPanel PanelAptidutes = new JPanel();
			PanelAptidutes.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Aptitudes:",
					TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			PanelAptidutes.setBounds(10, 512, 545, 186);
			panel.add(PanelAptidutes);
			PanelAptidutes.setLayout(null);

			JLabel lblNewLabel_11 = new JLabel("Carrera:");
			lblNewLabel_11.setBounds(11, 118, 58, 14);
			PanelAptidutes.add(lblNewLabel_11);
			{
				JLabel lblNewLabel_13 = new JLabel("Área:");
				lblNewLabel_13.setBounds(10, 52, 46, 14);
				PanelAptidutes.add(lblNewLabel_13);
			}

			cbxArea = new JComboBox();
			cbxArea.addItemListener(new ItemListener()
			{
				public void itemStateChanged(ItemEvent e)
				{
					if (!cbxArea.getSelectedItem().toString().equalsIgnoreCase("<Selecionar>"))
					{
						cbxCarrea.setEditable(true);
						cbxCarrea.setEnabled(true);

						if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias e Ingeniería"))
							cbxCarrea.setModel(new DefaultComboBoxModel(
									new String[] { "<Selecionar>", "Ing. Ciencias de la Computacíon" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias de la Salud"))
							cbxCarrea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Medicina" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias Administrativas"))
							cbxCarrea.setModel(
									new DefaultComboBoxModel(new String[] { "<Selecionar>", "Direccíon Empresarial" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias Humanidades y Artes"))
							cbxCarrea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Derecho" }));
						else
							cbxCarrea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>" }));
					}

				}
			});
			cbxArea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Ciencias de la Salud",
					"Ciencias e Ingeniería", "Ciencias Administrativas", "Ciencias Humanidades y Artes" }));
			cbxArea.setBounds(67, 48, 208, 20);
			PanelAptidutes.add(cbxArea);
			{
				cbxCarrea = new JComboBox();
				cbxCarrea.setEnabled(false);
				cbxCarrea.setBounds(67, 116, 208, 20);
				PanelAptidutes.add(cbxCarrea);
			}

			JLabel lblNewLabel_14 = new JLabel("Años:");
			lblNewLabel_14.setBounds(328, 52, 46, 14);
			PanelAptidutes.add(lblNewLabel_14);

			JSpinner spinner = new JSpinner();
			spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
			spinner.setBounds(384, 49, 110, 20);
			PanelAptidutes.add(spinner);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnValidar = new JButton("Validar");
			buttonPane.add(btnValidar);
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
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
	}
}
