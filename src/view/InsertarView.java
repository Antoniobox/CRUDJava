package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsertarView extends JFrame{

	private JTextField cajonNombre;
	private JTextField cajonApellidos;
	private JTextField cajonDni;


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
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		cajonNombre = new JTextField();
		cajonNombre.setBounds(191, 60, 86, 20);
		getContentPane().add(cajonNombre);
		cajonNombre.setColumns(10);
		
		cajonApellidos = new JTextField();
		cajonApellidos.setBounds(191, 91, 86, 20);
		getContentPane().add(cajonApellidos);
		cajonApellidos.setColumns(10);
		
		cajonDni = new JTextField();
		cajonDni.setBounds(191, 122, 86, 20);
		getContentPane().add(cajonDni);
		cajonDni.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(112, 63, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("DNI");
		lblNewLabel_1.setBounds(122, 125, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido_1");
		lblNewLabel_2.setBounds(112, 94, 56, 14);
		getContentPane().add(lblNewLabel_2);
		
		JButton btnEnviar = new JButton("INSERTAR");
		btnEnviar.setName("insertarRegistro");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviar.setBounds(91, 172, 131, 23);
		getContentPane().add(btnEnviar);
		
		JButton btnCerrar = new JButton("CERRAR");
		btnCerrar.setBounds(228, 172, 89, 23);
		getContentPane().add(btnCerrar);
		btnCerrar.setName("cerrar");
		
	}
}
