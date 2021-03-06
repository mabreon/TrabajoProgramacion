package BD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.Conexion;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class aņadirMedico extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Especialidad;
	private JTextField Fnacimiento;
	private JTextField Apellido;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aņadirMedico frame = new aņadirMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public aņadirMedico() throws SQLException {
		Conexion.conexion();
		setTitle("A\u00F1adir Medico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		Nombre = new JTextField();
		Nombre.setBounds(10, 87, 86, 20);
		panel.add(Nombre);
		Nombre.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(31, 48, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(121, 48, 46, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Especialidad");
		lblNewLabel_2.setBounds(210, 48, 75, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Fnacimiento");
		lblNewLabel_3.setBounds(306, 48, 75, 14);
		panel.add(lblNewLabel_3);

		Especialidad = new JTextField();
		Especialidad.setColumns(10);
		Especialidad.setBounds(210, 87, 86, 20);
		panel.add(Especialidad);

		Fnacimiento = new JTextField();
		Fnacimiento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (c < '0' || c > '9')
					arg0.consume();

			}
		});
		Fnacimiento.setColumns(10);
		Fnacimiento.setBounds(306, 87, 86, 20);
		panel.add(Fnacimiento);

		Apellido = new JTextField();
		Apellido.setColumns(10);
		Apellido.setBounds(106, 87, 86, 20);
		panel.add(Apellido);

		JButton btnAadir = new JButton("A\u00F1adir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Conexion.EjecutarUpdate(
							"INSERT INTO `medicos`(`IdMedico`, `Nombre`, `Apellido`, `Especialidad`, `fNacimiento`) VALUES("
									+ id.getText() + ",'" + Nombre.getText() + "','" + Apellido.getText() + "','"
									+ Especialidad.getText() + "'," + Fnacimiento.getText() + ")");
				
					menuMedicos q=new menuMedicos();
					dispose();
					q.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAadir.setBounds(306, 191, 89, 23);
		panel.add(btnAadir);

		JLabel IdMedico = new JLabel("IdMedico");
		IdMedico.setBounds(10, 131, 86, 14);
		panel.add(IdMedico);

		id = new JTextField();
		id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (c < '0' || c > '9')
					arg0.consume();

			}
		});
		id.setColumns(10);
		id.setBounds(10, 156, 86, 20);
		panel.add(id);
		
		JButton btnNewButton = new JButton("<");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuMedicos.main(null);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 11, 41, 26);
		panel.add(btnNewButton);
	}
}
