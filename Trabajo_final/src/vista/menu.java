package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import datos.Mantenimiento;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class menu extends JFrame {

	private JPanel contentPane;
	private JTextField textcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					menu frame = new menu();
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
	public menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnclientes = new JButton("Clientes");
		btnclientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				Menu_Clientes mc=new Menu_Clientes();
				mc.setVisible(true);
				setVisible(false);
			}
		});
		btnclientes.setBounds(28, 104, 109, 23);
		contentPane.add(btnclientes);
		
		JButton btnVehiculos = new JButton("Veh\u00EDculos");
		btnVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu_Vehiculos mv=new Menu_Vehiculos();
				mv.setVisible(true);
				setVisible(false);
			}
		});
		btnVehiculos.setBounds(160, 104, 109, 23);
		contentPane.add(btnVehiculos);
		
		JButton btnMatricula = new JButton("Matricula");
		btnMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Menu_Matricula mm=new Menu_Matricula();
				mm.setVisible(true);
				setVisible(false);
			}
		});
		btnMatricula.setBounds(298, 104, 109, 23);
		contentPane.add(btnMatricula);
		
		JLabel lblNewLabel = new JLabel("Men\u00FA Principal");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(28, 11, 142, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione a que tabla desea realizar un mantenimiento:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(28, 66, 379, 23);
		contentPane.add(lblNewLabel_1);
		
		textcodigo = new JTextField();
		textcodigo.setBounds(193, 252, 86, 20);
		contentPane.add(textcodigo);
		textcodigo.setColumns(10);
		
		JButton btnNewButton = new JButton("Mostrar Reporte");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mantenimiento r=new Mantenimiento();
				r.reporte1("Informe1", "SELECT apellidos, nombres, direccion, ciudad, marca, modelo, codigo_matricula  FROM matricula  INNER JOIN clientes ON matricula.id_cliente =clientes.id_cliente INNER JOIN vehiculos ON matricula.id_vehiculo = vehiculos.id_vehiculo ORDER BY apellidos");
			}
		});
		btnNewButton.setBounds(28, 193, 142, 23);
		contentPane.add(btnNewButton);
		
		JButton btnBusqueda = new JButton("Busqueda en Reporte");
		btnBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mantenimiento b=new Mantenimiento();
				int cod = Integer.parseInt(textcodigo.getText());
				b.reporte2("Informe2", "SELECT apellidos, nombres, direccion, ciudad, marca, modelo, codigo_matricula \r\n"
						+ "	FROM carros.matricula \r\n"
						+ "	INNER JOIN carros.clientes ON matricula.id_cliente =clientes.id_cliente\r\n"
						+ "	INNER JOIN carros.vehiculos ON matricula.id_vehiculo = vehiculos.id_vehiculo where clientes.id_cliente = $P{id}" ,cod);
			}
		});
		btnBusqueda.setBounds(298, 251, 197, 23);
		contentPane.add(btnBusqueda);
		
		JLabel lblBuscar = new JLabel("Ingrese el codigo del cliente: ");
		lblBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBuscar.setBounds(23, 255, 179, 19);
		contentPane.add(lblBuscar);
		
	}
}
