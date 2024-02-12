package controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.Medicos;
import view.EventoView;
import view.InsertarView;

public class EventoController implements ActionListener {
	
	JLabel info;
	EventoView vista;
	Medicos medico;
	public ArrayList<Medicos> lista;
	InsertarView formularioView;

	public EventoController(EventoView vista) throws SQLException {
		super();
		this.vista = vista;
		medico = new Medicos();
		lista = new ArrayList<Medicos>();
		lista = medico.getMedicos(1);
		vista.rellenarTabla(lista);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String textoObtenido = vista.getCuadroPagina().getText();
		int numero = Integer.parseInt(textoObtenido);
		
		JButton boton = (JButton) e.getSource();
		InsertarView insertView = new InsertarView();
		
		if(numero >= 1) {
		
			switch (boton.getName()) {
				case "botonIr":
					try {
						lista = medico.getMedicos(numero);
						vista.rellenarTabla(lista);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					vista.getCuadroPagina().setText(numero + "");
						break;
				case "primero":
					try {
						numero = 1;
						lista = medico.getMedicos(numero);
						vista.rellenarTabla(lista);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					vista.getCuadroPagina().setText(numero + "");
						break;
				case "delante":
					try {
						numero++;
						lista = medico.getMedicos(numero);
						vista.rellenarTabla(lista);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					vista.getCuadroPagina().setText(numero + "");
					break;
					
				case "atras":
					try {
						if(numero >= 2) {
							numero--;
							lista = medico.getMedicos(numero);
							vista.rellenarTabla(lista);
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					vista.getCuadroPagina().setText(numero + "");
					break;
					
				case "ultimo":
					try {
						lista = medico.getMedicos(numero);
						vista.rellenarTabla(lista);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					break;
				case "insertar":
					try {
						insertView.setVisible(true);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				break;
		
				case "cerrar":
						try {
							insertView.dispose();;
						} catch (Exception e2) {
							e2.printStackTrace();
						}
				break;
				
				case"insertarRegistro":
					try {
	                    String numeroColegiado = formularioView.getNumeroColegiado();
	                    String dni = formularioView.getDni();
	                    String nombre = formularioView.getNombre();
	                    String apellido1 = formularioView.getApellido1();
	                    
	                    
	                    Medicos nuevoMedico = new Medicos(numeroColegiado, dni, nombre, apellido1);
	                    
	                    nuevoMedico.insertar();
	                    
	                    lista = medico.getMedicos(1);
	                    vista.rellenarTabla(lista);
	                    insertView.dispose();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
				break;
			}
		}
	}
}
