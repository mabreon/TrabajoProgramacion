package Controladores;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import BD.Menu;

public class controladorLogin {
	public static boolean buttonLogin(String Usuario, String Password) {
		
		try {
			String consulta = "select * from usuarios";
			PreparedStatement consultaprep = (PreparedStatement) Conexion.conexion().prepareStatement(consulta);

			ResultSet rs=consultaprep.executeQuery();
			if(rs.next()) {
				
				if(Usuario.equals(rs.getString("Usuario"))) {
					if(Password.equals(rs.getString("Password"))) {
						Menu.main(null);
						return true;
						
					}else {
						JOptionPane.showMessageDialog(null, "contraseña erronea");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "usuario incorrecto");
				}
				
			}else {
				JOptionPane.showMessageDialog(null, "usuario incorrecto");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}