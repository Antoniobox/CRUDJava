package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSingleton {
	
	//Atributos
	
	private static Connection conexion = null;
	private static String database = "hospital";
	private String driver;
	private String url;
	private String user;
	private String password;
	
	//Constructor
	private ConexionSingleton(){
		url = "jdbc:mariadb://localhost/";
		driver = "org.mariadb.jdbc.Driver";
		user = "root";
		password = "";
		try {
			Class.forName(driver);
			conexion = (Connection) DriverManager.getConnection(url + database, user, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Metodos
	
	public static Connection getConexion() {
		if(conexion ==null) {
			new ConexionSingleton();
		}
		return conexion;
	}
}
