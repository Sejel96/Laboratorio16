package datos;

import java.sql.*;

import javax.swing.JOptionPane;

public class MantenimientoVehiculo  extends Mantenimiento{
	public void  registro_vehiculos(String  marca, String modelo) {
		try {
			CallableStatement sp = conn.prepareCall("call sp_registro_vehiculos(?,?)");
			sp.setString("marca", marca);
			sp.setString("modelo", modelo);
			sp.execute();
			JOptionPane.showMessageDialog(null,"Agregado exitosamente");
			} catch (SQLException e4) {
				JOptionPane.showMessageDialog(null,"Error en el driver" + e4);
			}
	}
	
	public void actualizar_vehiculos(String mar, String model, int id) {
        try {
            CallableStatement sp = conn.prepareCall("call sp_actualizar_vehiculos(?,?,?)");
            sp.setString("mar", mar);
            sp.setString("model", model);
            sp.setInt("id", id);
            sp.execute();
            JOptionPane.showMessageDialog(null,"Actualizado exitosamente");
        } catch (SQLException e5) {
            JOptionPane.showMessageDialog(null, "Error en el driver" + e5);
        }
    }
	
	
    public void eliminar_vehiculos(int id) {
        try {
            CallableStatement sp = conn.prepareCall("call sp_eliminar_vehiculos(?)");
            sp.setInt("id", id);
            sp.execute();
            JOptionPane.showMessageDialog(null,"Eliminado exitosamente");
        } catch (SQLException e6) {
            JOptionPane.showMessageDialog(null, "Error en el driver" + e6);
        }
    }
    
    
public void buscar_vehiculos(int id, javax.swing.JTextArea caja) {
        try {
            CallableStatement sp = conn.prepareCall("call sp_buscar_vehiculos(?)");
            sp.setInt("id", id);
            data = sp.executeQuery();
            try {
                while (data.next()) {
                    caja.append(data.getInt("id_vehiculo") + " | "
                            + data.getString("marca") + " | " + data.getString("modelo") + "\n");
                }
            } catch (SQLException e7) {
                JOptionPane.showMessageDialog(null, "Error en el driver" + e7);
            }
        } catch (SQLException e7) {
            JOptionPane.showMessageDialog(null, "Error en el driver" + e7);
        }
    }


    public void mostrar_vehiculos(javax.swing.JTextArea caja) {
        try {
            CallableStatement sp = conn.prepareCall("call sp_mostrar_vehiculos()");
            data = sp.executeQuery();
            try {
                while (data.next()) {
                    caja.append(data.getInt("id_vehiculo") + " | "
                            + data.getString("marca") +" | " + data.getString("modelo") + "\n");
                }
            } catch (SQLException e8) {
                JOptionPane.showMessageDialog(null, "Error en el driver" + e8);
            }
        } catch (SQLException e8) {
            JOptionPane.showMessageDialog(null, "Error en el driver" + e8);
        }
    }
    
    
}
