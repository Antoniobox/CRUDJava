package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexion.ConexionSingleton;

public class Medicos {
	//Atributos
	
	private String id;
	private String dni;
	private String nombre;
	private String apellido1;
	private static ResultSet rs;
	private int pagina;
	
	//Inicializar ResultSet
	static {
		try {
			rs = ConexionSingleton.getConexion().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE).executeQuery("select * from medicos");
		}catch(Exception e) {
			rs = null;
		}
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getId() {
		return id;
	}
	
	public String getDNI() {
		return dni;
	}
	
	public String getApellido1() {
		return apellido1;
	}
	
	
	//Constructor
	
	public Medicos() {
		
	}
	
	public Medicos(String dni, String nombre, String apellido1) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}
	
	public Medicos(String id,String dni, String nombre , String apellido1){
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
	}
	
	
	//Metodos
	public ArrayList<Medicos> getMedicos(int pag) throws SQLException{
		ArrayList<Medicos> medicos = new ArrayList<>();
		int registros = 30;
		int pagina = pag;
		int numeroRegistros = registros * (pagina -1);
		int contador = 0;
		rs.absolute(numeroRegistros);
		try{
			//rs.beforeFirst();
			while(rs.next() && contador < registros) {
				contador ++;
				medicos.add(new Medicos(rs.getString("id"), rs.getString("dni"),rs.getString("nombre"),rs.getString("apellido1")));
			}
			
		}catch(Exception e) {
			return null;
		}
		return medicos;
	}
	
	public void insertar() throws SQLException {
		rs.moveToInsertRow();
		rs.updateString("dni", dni);
		rs.updateString("nombre", nombre);
		rs.updateString("apellido1", apellido1);
		rs.insertRow();
		rs.moveToCurrentRow();
	}
}
