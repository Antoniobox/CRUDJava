package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;

import controler.EventoController;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertarView extends JFrame{
	private JTextField cajonApellidos;
	private JTextField cajonDni;
	private JTextField textField;
	private EventoController controlador;


	/**
	 * Create the application.
	 */
	public InsertarView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controlador = EventoView.getControlador();
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		cajonApellidos = new JTextField();
		cajonApellidos.setBounds(173, 125, 86, 20);
		getContentPane().add(cajonApellidos);
		cajonApellidos.setColumns(10);
		
		cajonDni = new JTextField();
		cajonDni.setBounds(173, 60, 86, 20);
		getContentPane().add(cajonDni);
		cajonDni.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(33, 63, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido_1");
		lblNewLabel_2.setBounds(33, 128, 56, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnEnviar = new JButton("INSERTAR");
		btnEnviar.setName("insertarRegistro");
		btnEnviar.setBounds(49, 212, 102, 23);
		getContentPane().add(btnEnviar);
		btnEnviar.addActionListener(controlador);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.setBounds(170, 212, 89, 23);
		getContentPane().add(btnCerrar);
		btnCerrar.setName("cerrar");
		btnCerrar.addActionListener(controlador);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(33, 94, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(173, 91, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		
	}
	

    public String getDni() {
        return cajonDni.getText();
    }

    public String getApellido1() {
        return cajonApellidos.getText();
    }

    public String getNombre() {
        return textField.getText();
    }
	
}
