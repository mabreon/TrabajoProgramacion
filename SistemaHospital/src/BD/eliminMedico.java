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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class eliminMedico extends JFrame {

	private JPanel contentPane;
	private JTextField Nombre;
	private JTextField Apellido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eliminMedico frame = new eliminMedico();
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
	public eliminMedico() throws SQLException {
		Conexion.conexion();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 176);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		Nombre = new JTextField();
		Nombre.setBounds(45, 76, 86, 20);
		panel.add(Nombre);
		Nombre.setColumns(10);
		
		Apellido = new JTextField();
		Apellido.setBounds(183, 76, 86, 20);
		panel.add(Apellido);
		Apellido.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(63, 51, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(205, 51, 46, 14);
		panel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Eliminar");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Conexion.EjecutarUpdate(
							"delete from `medicos` where nombre = '"+Nombre.getText()+"' and apellido = '"+Apellido.getText()+"'");
					
					menuMedicos q=new menuMedicos();
					dispose();
					q.setVisible(true);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		);
		btnNewButton.setBounds(325, 75, 89, 23);
		panel.add(btnNewButton);
		
		JButton button = new JButton("<");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuMedicos.main(null);
				setVisible(false);
			}
		});
		button.setBounds(0, 0, 46, 23);
		panel.add(button);
	}
}
