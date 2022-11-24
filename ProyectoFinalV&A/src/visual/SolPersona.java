package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.DefaultComboBoxModel;

public class SolPersona extends JDialog
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
	private JRadioButton rdbtnObrero;
	private JRadioButton rdbtnUniversitario;
	private JRadioButton rdbtnTecnico;
	private JComboBox cbxArea;
	private JLabel lblCarrera;
	private JLabel lblArea;
	private JSpinner spnAgnos;
	private JComboBox cbxCotrato;
	private JSpinner spnSal;
	private JTextField txtCode;
	private JComboBox cbxTipoSal;
	private JTextField txtIdiomas;
	private JButton btnAgregar;
	private JButton btnSolicitar;
	private JButton btnCancelar;
	private JButton btnValidar;
	private JTextField txtTelf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			SolPersona dialog = new SolPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SolPersona()
	{
		setTitle("Registrar solicitud de persona");
		setBounds(100, 100, 613, 830);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Datos:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(12, 13, 561, 349);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Cedula:");
			lblNewLabel.setBounds(12, 33, 56, 16);
			panel_1.add(lblNewLabel);
			
			txtCedula = new JTextField();
			txtCedula.setBounds(80, 30, 165, 22);
			panel_1.add(txtCedula);
			txtCedula.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nombre:");
			lblNewLabel_1.setBounds(12, 76, 56, 16);
			panel_1.add(lblNewLabel_1);
			
			txtNom = new JTextField();
			txtNom.setBounds(82, 73, 219, 22);
			panel_1.add(txtNom);
			txtNom.setColumns(10);
			
			btnBuscar = new JButton("Buscar");
			btnBuscar.setBounds(401, 29, 97, 25);
			panel_1.add(btnBuscar);
			
			JLabel lblNewLabel_2 = new JLabel("Telefono:");
			lblNewLabel_2.setBounds(12, 122, 56, 16);
			panel_1.add(lblNewLabel_2);
			
			txtTelf = new JTextField();
			txtTelf.setBounds(82, 119, 178, 22);
			panel_1.add(txtTelf);
			txtTelf.setColumns(10);
			
			JLabel lblNewLabel_3 = new JLabel("Direccion:");
			lblNewLabel_3.setBounds(12, 164, 66, 16);
			panel_1.add(lblNewLabel_3);
			
			txtDir = new JTextField();
			txtDir.setBounds(82, 161, 274, 22);
			panel_1.add(txtDir);
			txtDir.setColumns(10);
			
			JLabel lblNewLabel_4 = new JLabel("Licencia:");
			lblNewLabel_4.setBounds(12, 265, 56, 16);
			panel_1.add(lblNewLabel_4);
			
			rdbtnSiLic = new JRadioButton("Si");
			rdbtnSiLic.setBounds(68, 261, 48, 25);
			panel_1.add(rdbtnSiLic);
			
			rdbtnNoLic = new JRadioButton("No");
			rdbtnNoLic.setBounds(120, 261, 48, 25);
			panel_1.add(rdbtnNoLic);
			
			JLabel lblNewLabel_5 = new JLabel("Puede mudarse:");
			lblNewLabel_5.setBounds(327, 265, 97, 16);
			panel_1.add(lblNewLabel_5);
			
			rdbtnSiMud = new JRadioButton("Si");
			rdbtnSiMud.setBounds(428, 261, 48, 25);
			panel_1.add(rdbtnSiMud);
			
			rdbtnNoMud = new JRadioButton("No");
			rdbtnNoMud.setBounds(480, 261, 53, 25);
			panel_1.add(rdbtnNoMud);
			
			rdbtnUniversitario = new JRadioButton("Universitario");
			rdbtnUniversitario.setSelected(true);
			rdbtnUniversitario.setBounds(41, 303, 104, 25);
			panel_1.add(rdbtnUniversitario);
			
			rdbtnTecnico = new JRadioButton("Tecnico");
			rdbtnTecnico.setBounds(228, 303, 73, 25);
			panel_1.add(rdbtnTecnico);
			
			rdbtnObrero = new JRadioButton("Obrero");
			rdbtnObrero.setBounds(376, 303, 73, 25);
			panel_1.add(rdbtnObrero);
			
			JLabel lblNewLabel_11 = new JLabel("Idiomas:");
			lblNewLabel_11.setBounds(12, 212, 56, 16);
			panel_1.add(lblNewLabel_11);
			
			txtIdiomas = new JTextField();
			txtIdiomas.setBounds(80, 209, 116, 22);
			panel_1.add(txtIdiomas);
			txtIdiomas.setColumns(10);
			
			btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(228, 208, 97, 25);
			panel_1.add(btnAgregar);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new TitledBorder(null, "Aptitudes:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(12, 375, 561, 166);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			lblCarrera = new JLabel("Carrera:");
			lblCarrera.setBounds(12, 41, 56, 16);
			panel_2.add(lblCarrera);
			
			JComboBox cbxCarrera = new JComboBox();
			cbxCarrera.setBounds(72, 38, 183, 22);
			panel_2.add(cbxCarrera);
			
			lblArea = new JLabel("Area:");
			lblArea.setBounds(12, 113, 56, 16);
			panel_2.add(lblArea);
			
			cbxArea = new JComboBox();
			cbxArea.setModel(new DefaultComboBoxModel(new String[] {"<Selecionar>", "Ciencias de la Salud", "Ciencias e Ingenier\u00C3\u00ADa", "Ciencias Administrativas", "Ciencias Humanidades y Artes"}));
			cbxArea.setBounds(72, 110, 183, 22);
			panel_2.add(cbxArea);
			
			JLabel lblNewLabel_6 = new JLabel("A\u00F1os:");
			lblNewLabel_6.setBounds(310, 41, 47, 16);
			panel_2.add(lblNewLabel_6);
			
			spnAgnos = new JSpinner();
			spnAgnos.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			spnAgnos.setBounds(358, 38, 118, 22);
			panel_2.add(spnAgnos);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new TitledBorder(null, "Datos de Solicitud:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_3.setBounds(12, 554, 561, 166);
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel_7 = new JLabel("Contrato:");
			lblNewLabel_7.setBounds(12, 26, 56, 16);
			panel_3.add(lblNewLabel_7);
			
			cbxCotrato = new JComboBox();
			cbxCotrato.setModel(new DefaultComboBoxModel(new String[] {"<Selecionar>", "Jornada Completa", "Media Jornada", "Jornada Mixta"}));
			cbxCotrato.setBounds(80, 23, 128, 22);
			panel_3.add(cbxCotrato);
			
			JLabel lblNewLabel_8 = new JLabel("Codigo:");
			lblNewLabel_8.setBounds(268, 26, 56, 16);
			panel_3.add(lblNewLabel_8);
			
			txtCode = new JTextField();
			txtCode.setEnabled(false);
			txtCode.setBounds(325, 23, 116, 22);
			panel_3.add(txtCode);
			txtCode.setColumns(10);
			
			JLabel lblNewLabel_9 = new JLabel("Salario:");
			lblNewLabel_9.setBounds(12, 90, 56, 16);
			panel_3.add(lblNewLabel_9);
			
			spnSal = new JSpinner();
			spnSal.setModel(new SpinnerNumberModel(new Float(1000), new Float(1), null, new Float(1)));
			spnSal.setBounds(80, 87, 116, 22);
			panel_3.add(spnSal);
			
			JLabel lblNewLabel_10 = new JLabel("Tipo de Salario:");
			lblNewLabel_10.setBounds(268, 90, 92, 16);
			panel_3.add(lblNewLabel_10);
			
			cbxTipoSal = new JComboBox();
			cbxTipoSal.setModel(new DefaultComboBoxModel(new String[] {"<Selecionar>", "Quincenal", "Mensual", "Semanal", "Diario"}));
			cbxTipoSal.setBounds(372, 87, 105, 22);
			panel_3.add(cbxTipoSal);
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
}
