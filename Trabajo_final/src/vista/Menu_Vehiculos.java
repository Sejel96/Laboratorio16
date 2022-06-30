package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import datos.MantenimientoVehiculo;

public class Menu_Vehiculos extends JFrame {

	private JPanel contentPane;
	private JTextField textMarca;
	private JTextField textModelo;
	private JTextField textID_vehiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Vehiculos frame = new Menu_Vehiculos();
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
	public Menu_Vehiculos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 558, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(31, 99, 90, 23);
		contentPane.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(31, 135, 84, 23);
		contentPane.add(lblModelo);
		
		JLabel lblid_vehiculo = new JLabel("ID_vehiculo:");
		lblid_vehiculo.setBounds(31, 59, 90, 23);
		contentPane.add(lblid_vehiculo);
		
		textMarca = new JTextField();
		textMarca.setBounds(108, 100, 104, 20);
		contentPane.add(textMarca);
		textMarca.setColumns(10);
		
		textModelo = new JTextField();
		textModelo.setColumns(10);
		textModelo.setBounds(108, 136, 104, 20);
		contentPane.add(textModelo);
		
		textID_vehiculo = new JTextField();
		textID_vehiculo.setColumns(10);
		textID_vehiculo.setBounds(108, 60, 104, 20);
		contentPane.add(textID_vehiculo);
		
		JTextArea textMostrar = new JTextArea();
		textMostrar.setBounds(31, 268, 392, 148);
		contentPane.add(textMostrar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoVehiculo eli=new MantenimientoVehiculo();
				int cod = Integer.parseInt(textID_vehiculo.getText());
				eli.eliminar_vehiculos(cod);
			}
		});
		btnEliminar.setBounds(229, 216, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoVehiculo mode=new 	MantenimientoVehiculo();
				String mar = textMarca.getText();
				String mod = textModelo.getText();
				int cod = Integer.parseInt(textID_vehiculo.getText());
				mode.actualizar_vehiculos(mar, mod, cod);
				
			}
		});
		btnModificar.setBounds(130, 216, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoVehiculo mos=new 	MantenimientoVehiculo();
				textMostrar.setText("");
				mos.mostrar_vehiculos(textMostrar);
			}
		});
		btnMostrar.setBounds(427, 216, 89, 23);
		contentPane.add(btnMostrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoVehiculo bus=new 	MantenimientoVehiculo();
				textMostrar.setText("");
				int cod = Integer.parseInt(textID_vehiculo.getText());
				bus.buscar_vehiculos(cod, textMostrar);
			}
		});
		btnBuscar.setBounds(328, 216, 89, 23);
		contentPane.add(btnBuscar);
		
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoVehiculo agr=new 	MantenimientoVehiculo();
				String mar = textMarca.getText();
				String mod = textModelo.getText();
				agr.registro_vehiculos(mar, mod);
				}
		});
		btnAgregar.setBounds(31, 216, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblTitulo = new JLabel("Men\u00FA de Vehiculos");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(31, 11, 158, 23);
		contentPane.add(lblTitulo);
		
		JButton btnRegresar = new JButton("Regresar al Men\u00FA");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu r=new menu();
				r.setVisible(true);
				setVisible(false);
			}
		});
		btnRegresar.setBounds(387, 13, 145, 32);
		contentPane.add(btnRegresar);
	}
}
