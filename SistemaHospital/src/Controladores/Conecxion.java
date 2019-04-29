package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Conecxion {

	public static Connection conexion() throws SQLException {
		
         Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistemahospital","root","");
         Statement consulta = (Statement) conexion.createStatement();
         
		return conexion;
		}
	
}


