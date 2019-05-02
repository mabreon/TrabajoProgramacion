package BD;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Menu Medicos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			//Al pulsar nos llevara al menu medicos y volvera el menu invisible
			public void mouseClicked(MouseEvent arg0) {
				menuMedicos.main(null);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(10, 26, 153, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Menu Pacientes");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			//Al pulsar nos llevara al menu pacientes y volvera el menu invisible
			public void mouseClicked(MouseEvent e) {
				menuPacientes.main(null);
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(261, 26, 153, 23);
		panel.add(btnNewButton_2);
	}
}
