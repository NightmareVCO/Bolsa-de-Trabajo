package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
import logico.SolPersona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SoliPersona extends JDialog
{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCedula;
	private JTextField txtNom;
	private JButton btnBuscar;
	private JTextField txtDir;
	private JRadioButton rdbtnSiLic;
	private JRadioButton rdbtnNoLic;
	private JRadioButton rdbtnNoMud;
	private JRadioButton rdbtnSiMud;
	private JComboBox cbxArea;
	private JLabel lblCarrera;
	private JLabel lblArea;
	private JSpinner spnAgnos;
	private JComboBox cbxCotrato;
	private JSpinner spnSal;
	private JTextField txtCode;
	private JTextField txtIdiomas;
	private JButton btnAgregar;
	private JButton btnSolicitar;
	private JButton btnCancelar;
	private JButton btnValidar;
	private JTextField txtTelf;
	private JPanel PanelTipoSolicitud;
	private JRadioButton rdbtnUniver;
	private JRadioButton rdbtnTecnico;
	private JRadioButton rdbtnObrero;
	private JLabel label;
	private JComboBox cbxCiudad;
	private JComboBox cbxCarrera;
	private boolean mov = false;
	private boolean lic = false;

	public static void main(String[] args)
	{
		try
		{
			SoliPersona dialog = new SoliPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public SoliPersona()
	{
		setTitle("Registrar solicitud de persona");
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
			txtCedula.setBounds(80, 24, 163, 20);
			PanelDatos.add(txtCedula);
			txtCedula.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(10, 70, 56, 16);
			PanelDatos.add(lblNewLabel_1);

			txtNom = new JTextField();
			txtNom.setBounds(80, 68, 210, 20);
			PanelDatos.add(txtNom);
			txtNom.setColumns(10);

			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(454, 29, 97, 25);
			PanelDatos.add(btnBuscar);

			JLabel lblNewLabel_2 = new JLabel("Telefono:");
			lblNewLabel_2.setBounds(10, 113, 56, 16);
			PanelDatos.add(lblNewLabel_2);

			txtTelf = new JTextField();
			txtTelf.setBounds(80, 112, 178, 20);
			PanelDatos.add(txtTelf);
			txtTelf.setColumns(10);

			JLabel lblNewLabel_3 = new JLabel("Direccion:");
			lblNewLabel_3.setBounds(10, 156, 66, 16);
			PanelDatos.add(lblNewLabel_3);

			txtDir = new JTextField();
			txtDir.setBounds(80, 156, 300, 20);
			PanelDatos.add(txtDir);
			txtDir.setColumns(10);

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
							cbxCarrera.setModel(new DefaultComboBoxModel(
									new String[] { "<Selecionar>", "Ing. Ciencias de la Computacion" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias de la Salud"))
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Medicina" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias Administrativas"))
							cbxCarrera.setModel(
									new DefaultComboBoxModel(new String[] { "<Selecionar>", "Direccion Empresarial" }));
						else if (cbxArea.getSelectedItem().toString().equalsIgnoreCase("Ciencias Humanidades y Artes"))
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Derecho" }));
						else
							cbxCarrera.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>" }));
					}
				}
			});
			cbxArea.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Ciencias de la Salud",
					"Ciencias e Ingenieria", "Ciencias Administrativas", "Ciencias Humanidades y Artes" }));
			cbxArea.setBounds(72, 47, 208, 20);
			PanelAptitudes.add(cbxArea);

			JLabel lblNewLabel_6 = new JLabel("A\u00F1os:");
			lblNewLabel_6.setBounds(331, 50, 47, 16);
			PanelAptitudes.add(lblNewLabel_6);

			spnAgnos = new JSpinner();
			spnAgnos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnAgnos.setBounds(388, 49, 110, 20);
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

			cbxCotrato = new JComboBox();
			cbxCotrato.setModel(new DefaultComboBoxModel(
					new String[] { "<Selecionar>", "Jornada Completa", "Media Jornada", "Jornada Mixta" }));
			cbxCotrato.setBounds(78, 33, 147, 20);
			PanelDatosSolicitud.add(cbxCotrato);

			JLabel lblNewLabel_8 = new JLabel("Codigo:");
			lblNewLabel_8.setBounds(265, 51, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_8);

			txtCode = new JTextField();
			txtCode.setEnabled(false);
			txtCode.setBounds(331, 46, 116, 22);
			txtCode.setText("SOL-"+Bolsa.genSol);
			PanelDatosSolicitud.add(txtCode);
			txtCode.setColumns(10);

			JLabel lblNewLabel_9 = new JLabel("Salario:");
			lblNewLabel_9.setBounds(12, 92, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_9);

			spnSal = new JSpinner();
			spnSal.setModel(new SpinnerNumberModel(new Float(1000), new Float(1), null, new Float(500)));
			spnSal.setBounds(78, 86, 93, 20);
			PanelDatosSolicitud.add(spnSal);

			JLabel lblNewLabel_4 = new JLabel("Licencia:");
			lblNewLabel_4.setBounds(12, 198, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_4);

			rdbtnSiLic = new JRadioButton("Si");
			rdbtnSiLic.setBounds(78, 194, 48, 25);
			PanelDatosSolicitud.add(rdbtnSiLic);

			rdbtnNoLic = new JRadioButton("No");
			rdbtnNoLic.setBounds(128, 194, 48, 25);
			PanelDatosSolicitud.add(rdbtnNoLic);

			JLabel lblNewLabel_5 = new JLabel("Puede mudarse:");
			lblNewLabel_5.setBounds(265, 185, 97, 16);
			PanelDatosSolicitud.add(lblNewLabel_5);

			rdbtnSiMud = new JRadioButton("Si");
			rdbtnSiMud.setBounds(368, 180, 48, 25);
			PanelDatosSolicitud.add(rdbtnSiMud);

			rdbtnNoMud = new JRadioButton("No");
			rdbtnNoMud.setBounds(418, 181, 53, 25);
			PanelDatosSolicitud.add(rdbtnNoMud);

			JLabel lblNewLabel_11 = new JLabel("Idiomas:");
			lblNewLabel_11.setBounds(265, 118, 56, 16);
			PanelDatosSolicitud.add(lblNewLabel_11);

			txtIdiomas = new JTextField();
			txtIdiomas.setBounds(331, 114, 86, 20);
			PanelDatosSolicitud.add(txtIdiomas);
			txtIdiomas.setColumns(10);

			btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(442, 112, 97, 25);
			PanelDatosSolicitud.add(btnAgregar);

			label = new JLabel("Ciudad:");
			label.setBounds(12, 146, 46, 14);
			PanelDatosSolicitud.add(label);

			cbxCiudad = new JComboBox();
			cbxCiudad.setModel(new DefaultComboBoxModel(new String[] { "<Selecionar>", "Santiago", "Santo Domingo",
					"Espallat", "La Vega", "San Francisco", "Licey", "Samana", "Higuey" }));
			cbxCiudad.setBounds(78, 139, 147, 20);
			PanelDatosSolicitud.add(cbxCiudad);

			PanelTipoSolicitud = new JPanel();
			PanelTipoSolicitud.setBounds(12, 485, 561, 72);
			panel.add(PanelTipoSolicitud);
			PanelTipoSolicitud.setLayout(null);
			PanelTipoSolicitud.setBorder(
					new TitledBorder(null, "Tipo de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, null));

			rdbtnUniver = new JRadioButton("Universatario");
			rdbtnUniver.setSelected(true);
			rdbtnUniver.setBounds(75, 27, 108, 23);
			PanelTipoSolicitud.add(rdbtnUniver);

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
				btnSolicitar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(rdbtnSiMud.isSelected())
							mov = true;
						
						if(rdbtnSiLic.isSelected())
							lic = true;
						
						SolPersona soli = new SolPersona(txtCode.getText(), mov, cbxCotrato.getSelectedItem().toString(), lic, cbxCiudad.getSelectedItem().toString(), Float.valueOf(spnSal.getValue().toString()), true, txtCedula.getText());
						Bolsa.getInstance().addSolicitud(soli);
						JOptionPane.showMessageDialog(null, "Solicitud ingresada", "Informacion", JOptionPane.INFORMATION_MESSAGE);
						clean();
					}
				});
				btnSolicitar.setActionCommand("OK");
				buttonPane.add(btnSolicitar);
				getRootPane().setDefaultButton(btnSolicitar);
			}
			{
				btnCancelar = new JButton("Cancelar");
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}

	private void clean()
	{
		txtCedula.setText("");
		txtNom.setText("");
		txtTelf.setText("");
		txtDir.setText("");
		cbxCotrato.setSelectedIndex(0);
		txtCode.setText("SOL-"+Bolsa.genSol);
		spnSal.setValue(new Float("1000"));
		txtIdiomas.setText("");
		rdbtnNoLic.setSelected(false);
		rdbtnSiLic.setSelected(false);
		rdbtnSiMud.setSelected(false);
		rdbtnNoMud.setSelected(false);
		rdbtnTecnico.setSelected(false);
		rdbtnTecnico.setSelected(false);
		rdbtnUniver.setSelected(true);
		cbxArea.setSelectedIndex(0);
		cbxCarrera.setSelectedIndex(0);
		spnAgnos.setValue(new Integer("0"));
	}
}
