package BD;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import Controladores.Conexion;

import javax.swing.JTable;

public class listarPacientes extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					listarPacientes frame = new listarPacientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public listarPacientes() {
		setTitle("Listado de Pacientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JTable table = new JTable();
		table.setEnabled(false);
		table.setAutoCreateRowSorter(true);
		table.setBounds(-5, 253, 429, -255);
		panel.add(table);
		
		Object[][] datos = new Object[0][0];
		String[] titulo = {"Nombre", "Apellido", "Enfermedad", "fNacimiento"};	
		DefaultTableModel Pacientes = new DefaultTableModel(datos,titulo);
		
		table.setModel(Pacientes);
		String consulta = "SELECT Nombre, Apellido, Enfermedad, fNacimiento FROM `pacientes`";
		try {
			ResultSet rs= ((Controladores.Conexion) Conexion).ejecutarSentencia(consulta);
			while(rs.next()) {
			String Paciente1
			}
			PreparedStatement sentencia = (PreparedStatement) Conexion.conexion().prepareStatement(consulta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private ResultSet Conexion.ejecutar(String consulta) {
		// TODO Auto-generated method stub
		return null;
	}
}
