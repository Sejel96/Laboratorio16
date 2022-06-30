package datos;

import java.sql.*;

import javax.swing.JOptionPane;

public class MantenimientoClientes  extends Mantenimiento{
	
		
	public void  registro_clientes(String apellidos, String nombres, String direccion, String ciudad) {
		try {
			CallableStatement sp = conn.prepareCall("call sp_registro_clientes(?,?,?,?)");
			sp.setString("apellidos", apellidos);
			sp.setString("nombres", nombres);
			sp.setString("direccion", direccion);
			sp.setString("ciudad", ciudad);
			sp.execute();
			JOptionPane.showMessageDialog(null,"Agregado exitosamente");
			} catch (SQLException e3) {
				JOptionPane.showMessageDialog(null,"Error en el driver" + e3);
			}
	}
	
	
	public void actualizar_clientes(String ape, String nom, String dir, String ciu, int id) {
        try {
            CallableStatement sp = conn.prepareCall("call sp_actualizar_clientes(?,?,?,?,?)");
            sp.setString("ape", ape);
            sp.setString("nom", nom);
            sp.setString("dir", dir);
            sp.setString("ciu", ciu);
            sp.setInt("id", id);
            sp.execute();
            JOptionPane.showMessageDialog(null,"Actualizado exitosamente");
        } catch (SQLException e6) {
            JOptionPane.showMessageDialog(null,"Error en el driver" + e6);
        }
    }
	
	
	public void eliminar_clientes(int id) {
        try {
            CallableStatement sp = conn.prepareCall("call sp_eliminar_clientes(?)");
            sp.setInt("id", id);
            sp.execute();
            JOptionPane.showMessageDialog(null,"Eliminado exitosamente");
        } catch (SQLException e7) {
            JOptionPane.showMessageDialog(null,"Error en el driver" + e7);
        }
    }
	
	
	public void buscar_clientes(int id,javax.swing.JTextArea caja) {
        try {
            CallableStatement sp = conn.prepareCall("call sp_buscar_clientes(?)");
            sp.setInt("id", id);
            sp.execute();
            data = sp.getResultSet();
            try {
                while (data.next()) {
                    caja.append(data.getInt(1) + "  |  "  + data.getString(2) 
                            +  "  |  " + data.getString(3) +  "  |  " 
                            + data.getString(4)+ "  |  " + data.getString(5)+ "\n");
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }
        } catch (SQLException e8) {
            JOptionPane.showMessageDialog(null,"Error en el driver" + e8);
        }
    }
	
	
	public void mostrar_clientes(javax.swing.JTextArea caja) {
        try {
            CallableStatement sp = conn.prepareCall("call sp_mostrar_clientes()");
            sp.execute();
            data = sp.getResultSet();
            try {
                while (data.next()) {
                    caja.append(data.getInt(1) + "  |  " + data.getString(2)
                            + " |  " + data.getString(3) + " |  "
                            + data.getString(4)+" |  "+data.getString(5)+ "\n");
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }
        } catch (SQLException e9) {
            JOptionPane.showMessageDialog(null,"Error en el driver" + e9);
        }
    }
	
	
}
