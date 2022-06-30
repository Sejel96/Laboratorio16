package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.MantenimientoMatricula;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Matricula extends JFrame {

	private JPanel contentPane;
	private JTextField textIDMatricula;
	private JTextField textIDCliente;
	private JTextField textIDVehiculo;
	private JTextField textMatricula;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Matricula frame = new Menu_Matricula();
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
	public Menu_Matricula() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Men\u00FA de Matricula");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(20, 11, 166, 31);
		contentPane.add(lblTitulo);
		
		JLabel lblID_Matricula = new JLabel("ID Matricula:");
		lblID_Matricula.setBounds(20, 67, 101, 25);
		contentPane.add(lblID_Matricula);
		
		JLabel lblID_cliente = new JLabel("ID Cliente:");
		lblID_cliente.setBounds(20, 123, 101, 25);
		contentPane.add(lblID_cliente);
		
		JLabel lblID_vehiculo = new JLabel("ID Veh\u00EDculo:");
		lblID_vehiculo.setBounds(20, 173, 101, 25);
		contentPane.add(lblID_vehiculo);
		
		JLabel lblMatricula = new JLabel(" Matricula:");
		lblMatricula.setBounds(20, 223, 101, 25);
		contentPane.add(lblMatricula);
		
		textIDMatricula = new JTextField();
		textIDMatricula.setBounds(107, 69, 145, 23);
		contentPane.add(textIDMatricula);
		textIDMatricula.setColumns(10);
		
		textIDCliente = new JTextField();
		textIDCliente.setColumns(10);
		textIDCliente.setBounds(107, 125, 145, 23);
		contentPane.add(textIDCliente);
		
		textIDVehiculo = new JTextField();
		textIDVehiculo.setColumns(10);
		textIDVehiculo.setBounds(107, 175, 145, 23);
		contentPane.add(textIDVehiculo);
		
		textMatricula = new JTextField();
		textMatricula.setColumns(10);
		textMatricula.setBounds(107, 225, 145, 23);
		contentPane.add(textMatricula);
		
		JTextArea textMostrar = new JTextArea();
		textMostrar.setBounds(20, 307, 360, 128);
		contentPane.add(textMostrar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoMatricula agr=new MantenimientoMatricula();
				int idc = Integer.parseInt(textIDCliente.getText());
				int idv = Integer.parseInt(textIDVehiculo.getText());
				String mat = textMatricula.getText();
				agr.registro_matricula(idc, idv, mat);
			}
		});
		btnAgregar.setBounds(10, 273, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoMatricula mod=new MantenimientoMatricula();
				int idc = Integer.parseInt(textIDCliente.getText());
				int idv = Integer.parseInt(textIDVehiculo.getText());
				String mat = textMatricula.getText();
				int id = Integer.parseInt(textIDMatricula.getText());
				mod.actualizar_matricula(idc, idv, mat, id);
			}
		});
		btnModificar.setBounds(116, 273, 89, 23);
		contentPane.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoMatricula eli = new MantenimientoMatricula();
				int id = Integer.parseInt(textIDMatricula.getText());
				eli.eliminar_matricula(id);
			}
		});
		btnEliminar.setBounds(223, 273, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoMatricula bus=new MantenimientoMatricula();
				textMostrar.setText("");
				int id = Integer.parseInt(textIDMatricula.getText());
				bus.buscar_matricula(id, textMostrar);
			}
		});
		btnBuscar.setBounds(329, 273, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoMatricula mos=new MantenimientoMatricula();
				textMostrar.setText("");
				mos.mostrar_matricula(textMostrar);
			}
		});
		btnMostrar.setBounds(431, 273, 89, 23);
		contentPane.add(btnMostrar);
		
		JButton btnRegresar = new JButton("Regresar al Men\u00FA");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu m=new menu();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnRegresar.setBounds(329, 17, 166, 31);
		contentPane.add(btnRegresar);
	}
}
