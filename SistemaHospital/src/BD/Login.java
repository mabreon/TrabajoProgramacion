package BD;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controladores.Conexion;
import Controladores.controladorLogin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2310846797885094754L;
	private JPanel contentPane;
	private int o;
	private JTextField textUser;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() throws SQLException {
		Conexion.conexion();
		setTitle("Ingreso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salir();
			}
		});
		btnNewButton.setBounds(10, 102, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ingresar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Usuario = textUser.getText();
				String Password = textPassword.getText();
				if(controladorLogin.buttonLogin(Usuario, Password)) {
					setVisible(false);
				}
				
			}
		});
		btnNewButton_1.setBounds(325, 102, 89, 23);
		panel.add(btnNewButton_1);
		
		textUser = new JTextField();
		textUser.setBounds(158, 25, 100, 20);
		panel.add(textUser);
		textUser.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(158, 54, 100, 20);
		panel.add(textPassword);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(50, 28, 86, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(50, 57, 86, 14);
		panel.add(lblNewLabel_1);
	}

	protected void salir(){
		System.exit(o);
		
	}
}
