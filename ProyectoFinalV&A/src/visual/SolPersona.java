package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.TitledBorder;

import logico.Bolsa;
import logico.SoliPersona;

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
	private JComboBox cbxArea;
	private JLabel lblCarrera;
	private JLabel lblArea;
	private JSpinner spnAgnos;
	private JComboBox cbxContrato;
	private JSpinner spnSalario;
	private JTextField txtCodigo;
	private JTextField txtIdiomas;
	private JButton btnAgregar;
	private JButton btnSolicitar;
	private JButton btnCancelar;
	private JButton btnValidar;
	private JTextField txtTelefono;
	private JPanel PanelTipoSolicitud;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	private JComboBox cbxCiudad;
	private JComboBox cbxCarrera;
	private JLabel lblNewLabel_6;
	private boolean mov = false;
	private boolean lic = false;

	public SolPersona()
	{
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
			txtNombre.setBounds(80, 68, 210, 20);
			PanelDatos.add(txtNombre);
			txtNombre.setColumns(10);

			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(454, 23, 97, 25);
			PanelDatos.add(btnBuscar);

			JLabel lblNewLabel_2 = new JLabel("Telefono:");
			lblNewLabel_2.setBounds(10, 113, 56, 16);
			PanelDatos.add(lblNewLabel_2);

			txtTelefono = new JTextField();
			txtTelefono.setBounds(80, 111, 178, 20);
			PanelDatos.add(txtTelefono);
			txtTelefono.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("Direccion:");
			lblNewLabel_3.setBounds(10, 156, 66, 16);
			PanelDatos.add(lblNewLabel_3);

			txtDireccion = new JTextField();
			txtDireccion.setBounds(80, 154, 300, 20);
			PanelDatos.add(txtDireccion);
			txtDireccion.setColumns(10);

			JPanel PanelAptitudes = new JPanel();
			PanelAptitudes
					.setBorder(new TitledBorder(null, "Aptitudes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			PanelAptitudes.setBounds(12, 568, 561, 186);
			panel.add(PanelAptitudes);
			PanelAptitudes.setLayout(null);

			lblCarrera = new JLabel("Carrera:");
			lblCarrera.setBounds(12, 118, 56, 16);
			PanelAptitudes.add(lblCarrera);

			cbxCarrera = new JComboBox();
			cbxCarrera.setEnabled(false);
			cbxCarrera.setBounds(72, 116, 208, 20);
			PanelAptitudes.add(cbxCarrera);

			lblArea = new JLabel("Area:");
			lblArea.setBounds(12, 51, 56, 16);
			PanelAptitudes.add(lblArea);

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
			cbxArea.setBounds(72, 49, 208, 20);
			PanelAptitudes.add(cbxArea);

			lblNewLabel_6 = new JLabel("A\u00F1os:");
			lblNewLabel_6.setBounds(331, 50, 47, 16);
			PanelAptitudes.add(lblNewLabel_6);

			spnAgnos = new JSpinner();
			spnAgnos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnAgnos.setBounds(388, 48, 110, 20);
			PanelAptitudes.add(spnAgnos);

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
			rdbtnLicenciaSi.setBounds(78, 194, 48, 25);
			PanelDatosSolicitud.add(rdbtnLicenciaSi);

			rdbtnLicenciaNo = new JRadioButton("No");
			rdbtnLicenciaNo.setBounds(128, 194, 48, 25);
			PanelDatosSolicitud.add(rdbtnLicenciaNo);

			JLabel lblNewLabel_5 = new JLabel("Puede mudarse:");
			lblNewLabel_5.setBounds(265, 185, 97, 16);
			PanelDatosSolicitud.add(lblNewLabel_5);

			rdbtnMudarseSi = new JRadioButton("Si");
			rdbtnMudarseSi.setBounds(368, 181, 48, 25);
			PanelDatosSolicitud.add(rdbtnMudarseSi);

			rdbtnMudarseNo = new JRadioButton("No");
			rdbtnMudarseNo.setBounds(418, 181, 53, 25);
			PanelDatosSolicitud.add(rdbtnMudarseNo);

			JLabel lblNewLabel_11 = new JLabel("Idiomas:");
			lblNewLabel_11.setBounds(265, 118, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_11);

			txtIdiomas = new JTextField();
			txtIdiomas.setBounds(331, 116, 86, 20);
			PanelDatosSolicitud.add(txtIdiomas);
			txtIdiomas.setColumns(10);

			btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(442, 114, 97, 25);
			PanelDatosSolicitud.add(btnAgregar);

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
			rdbtnUniversitario.setSelected(true);
			rdbtnUniversitario.setBounds(75, 27, 108, 23);
			PanelTipoSolicitud.add(rdbtnUniversitario);

			rdbtnTecnico = new JRadioButton("Tecnico");
			rdbtnTecnico.setBounds(258, 27, 81, 23);
			PanelTipoSolicitud.add(rdbtnTecnico);

			rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.setBounds(414, 27, 69, 23);
			PanelTipoSolicitud.add(rdbtnObrero);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			btnValidar = new JButton("Validar");
			buttonPane.add(btnValidar);
			{
				btnSolicitar = new JButton("Solicitar");
				btnSolicitar.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (rdbtnMudarseSi.isSelected())
							mov = true;

						if (rdbtnLicenciaSi.isSelected())
							lic = true;

						SoliPersona soli = new SoliPersona(txtCodigo.getText(), mov, cbxContrato.getSelectedItem().toString(),
								lic, cbxCiudad.getSelectedItem().toString(), Float.valueOf(spnSalario.getValue().toString()),
								txtCedula.getText());
						Bolsa.getInstance().addSolicitud(soli);
						JOptionPane.showMessageDialog(null, "Solicitud ingresada", "Informacion",
								JOptionPane.INFORMATION_MESSAGE);
						System.out.println(Bolsa.getInstance().getSolicitudes().get(0).getCodigo());
						clean();
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
	}

	private void clean()
	{
		txtCedula.setText("");
		txtNombre.setText("");
		txtTelefono.setText("");
		txtDireccion.setText("");
		cbxContrato.setSelectedIndex(0);
		txtCodigo.setText("SOL-" + Bolsa.genSol);
		spnSalario.setValue(new Float("1000"));
		txtIdiomas.setText("");
		rdbtnLicenciaNo.setSelected(false);
		rdbtnLicenciaSi.setSelected(false);
		rdbtnMudarseSi.setSelected(false);
		rdbtnMudarseNo.setSelected(false);
		rdbtnTecnico.setSelected(false);
		rdbtnTecnico.setSelected(false);
		rdbtnUniversitario.setSelected(true);
		cbxArea.setSelectedIndex(0);
		cbxCarrera.setSelectedIndex(0);
		spnAgnos.setValue(new Integer("0"));
	}
}
