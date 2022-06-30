package vista;
import datos.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class Menu_Clientes extends JFrame {

	private JPanel contentClientes;
	private JTextField textApellidos;
	private JTextField textNombres;
	private JTextField textDireccion;
	private JTextField textCiudad;
	private JTextField textCodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Clientes frame = new Menu_Clientes();
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
	public Menu_Clientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 511);
		contentClientes = new JPanel();
		contentClientes.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentClientes);
		contentClientes.setLayout(null);
		
		JLabel lblApellidos = new JLabel("Apellidos: ");
		lblApellidos.setBounds(40, 100, 74, 14);
		contentClientes.add(lblApellidos);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(40, 133, 57, 14);
		contentClientes.add(lblNombres);
		
		JLabel lblDireccion = new JLabel("Direccion: ");
		lblDireccion.setBounds(40, 168, 57, 14);
		contentClientes.add(lblDireccion);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(40, 210, 57, 14);
		contentClientes.add(lblCiudad);
		
		textApellidos = new JTextField();
		textApellidos.setBounds(107, 97, 155, 20);
		contentClientes.add(textApellidos);
		textApellidos.setColumns(10);
		
		textNombres = new JTextField();
		textNombres.setColumns(10);
		textNombres.setBounds(107, 130, 155, 20);
		contentClientes.add(textNombres);
		
		textDireccion = new JTextField();
		textDireccion.setColumns(10);
		textDireccion.setBounds(107, 165, 155, 20);
		contentClientes.add(textDireccion);
		
		textCiudad = new JTextField();
		textCiudad.setColumns(10);
		textCiudad.setBounds(107, 207, 155, 20);
		contentClientes.add(textCiudad);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoClientes  a=new MantenimientoClientes();
				String ape = textApellidos.getText();
				String nom = textNombres.getText();
				String dir = textDireccion.getText();
				String ciu = textCiudad.getText();
				a.registro_clientes(ape, nom, dir, ciu);
			}
		});
		btnAgregar.setBounds(25, 278, 89, 23);
		contentClientes.add(btnAgregar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoClientes  eli=new MantenimientoClientes();
				int id= Integer.parseInt(textCodigo.getText());
				eli.eliminar_clientes(id);
			}
		});
		btnEliminar.setBounds(235, 278, 89, 23);
		contentClientes.add(btnEliminar);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(40, 64, 57, 14);
		contentClientes.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setBounds(107, 61, 114, 20);
		contentClientes.add(textCodigo);
		textCodigo.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoClientes b=new MantenimientoClientes();
				String ape = textApellidos.getText();
				String nom = textNombres.getText();
				String dir = textDireccion.getText();
				String ciu = textCiudad.getText();
				int id= Integer.parseInt(textCodigo.getText());
				b.actualizar_clientes(ape, nom, dir, ciu, id);
				
			}
		});
		btnModificar.setBounds(136, 278, 89, 23);
		contentClientes.add(btnModificar);
		
		JTextArea textMostrar = new JTextArea();
		textMostrar.setBounds(40, 325, 421, 124);
		contentClientes.add(textMostrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoClientes bus=new MantenimientoClientes();
				textMostrar.setText("");
				int id= Integer.parseInt(textCodigo.getText());
				bus.buscar_clientes(id, textMostrar);
			}
		});
		btnBuscar.setBounds(334, 278, 89, 23);
		contentClientes.add(btnBuscar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoClientes m=new MantenimientoClientes();
				textMostrar.setText("");
				m.mostrar_clientes(textMostrar);
			}
		});
		btnMostrar.setBounds(441, 278, 89, 23);
		contentClientes.add(btnMostrar);
		
		JButton btnRegresar = new JButton("Regresar al Men\u00FA");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu r=new menu();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnRegresar.setBounds(336, 11, 152, 35);
		contentClientes.add(btnRegresar);
		
		JLabel lblTitulo = new JLabel("Men\u00FA de Clientes");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(40, 11, 144, 20);
		contentClientes.add(lblTitulo);
	}
}
