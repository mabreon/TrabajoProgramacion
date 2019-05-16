package Controladores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Conexion {
	 private static Statement consulta;
	
	public static Connection conexion() throws SQLException {
		
         Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/sistemahospital","root","");
          consulta = (Statement) conexion.createStatement();
         
		return conexion;
		}
	public static ResultSet ejecutarSentencia(String Sentencia) {
		ResultSet resultado = null;
		try {
			java.sql.Statement consulta = null;
			resultado = consulta.executeQuery(Sentencia);
		}catch (Exception e) {
			
		}
		return resultado;
		}
	public static void EjecutarUpdate(String Sentencia) throws SQLException{
		try {
			consulta.executeUpdate(Sentencia);
		}catch (Exception e) {
			
		}
		
	}
	
	
	
	
	
}


