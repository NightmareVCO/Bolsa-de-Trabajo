package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JTextField textField;

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
					lblNewLabel_4.setBounds(10, 35, 59, 14);
					PanelDatosSolicitud.add(lblNewLabel_4);
				}
				{
					JLabel lblNewLabel_5 = new JLabel("Salario:");
					lblNewLabel_5.setBounds(10, 84, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_5);
				}

				JSpinner spinner = new JSpinner();
				spinner.setModel(new SpinnerNumberModel(new Float(1000), new Float(0), null, new Float(500)));
				spinner.setBounds(66, 81, 93, 20);
				PanelDatosSolicitud.add(spinner);
				{
					JLabel lblNewLabel_6 = new JLabel("Tipo de Salario:");
					lblNewLabel_6.setBounds(286, 81, 127, 14);
					PanelDatosSolicitud.add(lblNewLabel_6);
				}
				{
					JLabel lblNewLabel_7 = new JLabel("Ciudad:");
					lblNewLabel_7.setBounds(10, 134, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_7);
				}
				{
					JLabel lblNewLabel_8 = new JLabel("Puede Mudarse:");
					lblNewLabel_8.setBounds(286, 134, 93, 14);
					PanelDatosSolicitud.add(lblNewLabel_8);
				}
				{
					JRadioButton rdbtnMudarseSi = new JRadioButton("Sí");
					rdbtnMudarseSi.setBounds(389, 130, 59, 23);
					PanelDatosSolicitud.add(rdbtnMudarseSi);
				}
				{
					JRadioButton rdbtnMudarseNo = new JRadioButton("No");
					rdbtnMudarseNo.setBounds(450, 130, 52, 23);
					PanelDatosSolicitud.add(rdbtnMudarseNo);
				}
				{
					JLabel lblNewLabel_9 = new JLabel("Licencia:");
					lblNewLabel_9.setBounds(10, 178, 59, 14);
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
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Santiago", "Santo Domingo",
							"Espallat", "La Vega", "San Francisco", "Licey", "Samana", "Higuey", "" }));
					comboBox.setBounds(66, 131, 147, 20);
					PanelDatosSolicitud.add(comboBox);
				}
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(
							new String[] { "<Selecionar>", "Jornada Completa", "Media Jornada", "Jornada Mixta" }));
					comboBox.setBounds(66, 32, 120, 20);
					PanelDatosSolicitud.add(comboBox);
				}
				{
					JComboBox comboBox = new JComboBox();
					comboBox.setModel(new DefaultComboBoxModel(
							new String[] { "<Selecionar>", "Quincenal", "Mensual", "Semanal", "Diario" }));
					comboBox.setBounds(379, 78, 123, 20);
					PanelDatosSolicitud.add(comboBox);
				}
				{
					JLabel lblNewLabel_10 = new JLabel("Código:");
					lblNewLabel_10.setBounds(286, 35, 46, 14);
					PanelDatosSolicitud.add(lblNewLabel_10);
				}
				{
					textField = new JTextField();
					textField.setEditable(false);
					textField.setBounds(379, 32, 123, 20);
					PanelDatosSolicitud.add(textField);
					textField.setColumns(10);
				}
				{
					JRadioButton rdbtnLicenciaSi = new JRadioButton("Sí");
					rdbtnLicenciaSi.setBounds(71, 174, 59, 23);
					PanelDatosSolicitud.add(rdbtnLicenciaSi);
				}
				{
					JRadioButton rdbtnLicenciaNo = new JRadioButton("No");
					rdbtnLicenciaNo.setBounds(132, 174, 52, 23);
					PanelDatosSolicitud.add(rdbtnLicenciaNo);
				}
			}
			{
				JPanel PanelTipoSolicitud = new JPanel();
				PanelTipoSolicitud.setBorder(
						new TitledBorder(null, "Tipo de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				PanelTipoSolicitud.setBounds(10, 429, 545, 72);
				panel.add(PanelTipoSolicitud);
				PanelTipoSolicitud.setLayout(null);

				JRadioButton rdbtnNewRadioButton = new JRadioButton("Universatario");
				rdbtnNewRadioButton.setBounds(71, 27, 108, 23);
				PanelTipoSolicitud.add(rdbtnNewRadioButton);

				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Técnico");
				rdbtnNewRadioButton_1.setBounds(250, 27, 81, 23);
				PanelTipoSolicitud.add(rdbtnNewRadioButton_1);

				JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Obrero");
				rdbtnNewRadioButton_2.setBounds(402, 27, 69, 23);
				PanelTipoSolicitud.add(rdbtnNewRadioButton_2);
			}

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Aptitudes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 512, 545, 186);
			panel.add(panel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton btnCancelar = new JButton("Cancelar");
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
