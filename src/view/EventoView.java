package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import model.Medicos;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controler.EventoController;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Font;
import java.sql.SQLException;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class EventoView extends JFrame {

	private JPanel borderLayout;
	private JTable table;
	private JTextField textField;
	private JTextField cuadroPagina;
	private JPanel panelCentral;
	private JScrollPane scrollPane;

	
	public static void main(String[] args) throws SQLException {
		EventoView frame = new EventoView();
		frame.setSize(1500,900);
		frame.setVisible(true);
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventoView frame = new EventoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		*/
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public EventoView() throws SQLException {
		
		//Panel Central
		JPanel panelCentral = new JPanel();
		scrollPane = new JScrollPane();
		
		//Panel Principal
		borderLayout = new JPanel();
		borderLayout.setBackground(Color.black);
	
		//Panel Arriba
		JLabel label = new JLabel();
		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(192, 192, 192));
		panelTop.setLayout(new BorderLayout());
		panelTop.setPreferredSize(new Dimension(200,100));
		
		//PanelBajo
		JPanel panelBajo = new JPanel();
		panelBajo.setBackground(new Color(192, 192, 192));
		panelBajo.setPreferredSize(new Dimension(100,50));
		
		
		
		borderLayout.setPreferredSize(new Dimension(1000, 1000));
		panelCentral.setBackground(new Color(192, 192, 192));
		panelCentral.setLayout(new BorderLayout());
		panelCentral.setPreferredSize(new Dimension(200, 200));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 984, 551);
		borderLayout.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(borderLayout);
		
		
		
		JTextArea textArea_1 = new JTextArea();
		borderLayout.setLayout(new BorderLayout(0, 0));
		borderLayout.add(panelTop, BorderLayout.NORTH);
		
		JLabel textoHeader = new JLabel();
		ImageIcon icono = new ImageIcon("C:\\Users\\Lorenzo\\Downloads\\hospital.png");
		textoHeader.setBackground(new Color(192, 192, 192));
		textoHeader.setFont(new Font("Arial", Font.BOLD, 25));
		
		label.setIcon(icono);
        // Añadir el JLabel en la región BorderLayout.CENTER del frame
        panelTop.add(label, BorderLayout.CENTER);
        // Hacer visible el 
        panelTop.setVisible(true);
		
		textoHeader.setText("CRUD");
		textoHeader.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelTop.add(textoHeader, BorderLayout.EAST);
		
		
		borderLayout.add(panelBajo, BorderLayout.SOUTH);
		panelBajo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//Instancias de los botones
		JButton btnPrimero = new JButton("<<");
		JButton btnAtras = new JButton("<");
		JButton btnBuscar = new JButton("Ir");
		JButton btnDelante = new JButton(">");
		JButton btnUltimo = new JButton(">>");
		
		//Asignación de nombres identificadores a los botones
		btnPrimero.setName("primero");
		btnAtras.setName("atras");
		btnBuscar.setName("botonIr");
		btnDelante.setName("delante");
		btnUltimo.setName("ultimo");
		
		
		cuadroPagina = new JTextField();
		cuadroPagina.setHorizontalAlignment(SwingConstants.CENTER);
		cuadroPagina.setColumns(10);
		cuadroPagina.setText("1");
		
		EventoController controlador =  new EventoController(this);
		
		
		btnBuscar.addActionListener(controlador);
		btnPrimero.addActionListener(controlador);
		btnAtras.addActionListener(controlador);
		btnDelante.addActionListener(controlador);
		btnUltimo.addActionListener(controlador);
		
		panelBajo.add(btnPrimero);
		panelBajo.add(btnAtras);
		panelBajo.add(cuadroPagina);
		panelBajo.add(btnBuscar);
		panelBajo.add(btnDelante);
		panelBajo.add(btnUltimo);
		
		
		
		panelCentral.add(scrollPane, BorderLayout.CENTER);
		
		
		
		
		borderLayout.add(panelCentral, BorderLayout.CENTER);
		/*
		String medicosString = "";
		String medicosInt = "";
		for(Medicos mc : medicos) {
			medicosString+=mc.getId()+"\n";
			medicosString+=mc.getNombre()+"\n";
		}
		*/
		
	}
	
	public void rellenarTabla(ArrayList<Medicos> lista) {
		
		String[] cabeceras = {"ID","Numero colegiado","DNI","Nombre", "Apellido1"};
		
		DefaultTableModel modelo = new DefaultTableModel(cabeceras, 0);
		
		//ArrayList<Medicos> listaMedicos = lista;
		
		for(Medicos m : lista) {
			Object[] datosTabla = new Object[] {m.getId(), m.getNumColeg(), m.getDNI(), m.getNombre(), m.getApellido1()};
			modelo.addRow(datosTabla);
		}
		table = new JTable(modelo);
		scrollPane.add(table);
		scrollPane.setViewportView(table);
	}
	
	public JTextField getCuadroPagina() {
		return this.cuadroPagina;
	}
	
	
}