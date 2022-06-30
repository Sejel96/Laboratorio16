package datos;

import java.sql.*;

import javax.swing.JOptionPane;

public class MantenimientoMatricula  extends Mantenimiento{
	public void  registro_matricula(int id_cliente, int id_vehiculo, String codigo_matricula) {
		try {
			CallableStatement sp = conn.prepareCall("call sp_registro_matricula(?,?,?)");
			sp.setInt("id_cliente", id_cliente);
			sp.setInt("id_vehiculo", id_vehiculo);
			sp.setString("codigo_matricula", codigo_matricula);
			sp.execute();
			JOptionPane.showMessageDialog(null,"Agregado exitosamente");
			} catch (SQLException e5) {
				JOptionPane.showMessageDialog(null,"Error en el driver" + e5);
			}
	}
	
	 public void actualizar_matricula(int id_c, int id_v, String cod, int id) {
	        try {
	            CallableStatement sp = conn.prepareCall("call sp_actualizar_matricula(?,?,?,?)");
	            sp.setInt("id_c", id_c);
	            sp.setInt("id_v", id_v);
	            sp.setString("cod", cod);
	            sp.setInt("id", id);
	            sp.execute();
	            JOptionPane.showMessageDialog(null,"Actualizado exitosamente");
	        } catch (SQLException e5) {
	            JOptionPane.showMessageDialog(null,"Error en el driver" + e5);
	        }
	    }
	    public void eliminar_matricula(int id) {
	        try {
	            CallableStatement sp = conn.prepareCall("call sp_eliminar_matricula(?)");
	            sp.setInt("id", id);
	            sp.execute();
	            JOptionPane.showMessageDialog(null,"Eliminado exitosamente");
	        } catch (SQLException e5) {
	            JOptionPane.showMessageDialog(null,"Error en el driver" + e5);
	        }
	    }
	    
	    public void buscar_matricula(int id, javax.swing.JTextArea caja) {
	        try {
	            CallableStatement sp = conn.prepareCall("call sp_buscar_matricula(?)");
	            sp.setInt("id", id);
	            sp.execute();
	            data = sp.getResultSet();
	            try {
	                while (data.next()) {
	                    caja.append(data.getInt("id_matricula") + " | "
	                            + data.getInt("id_cliente") + " | " + data.getInt("id_vehiculo") + 
	                            " | " +  data.getString("codigo_matricula")+"\n");
	                }
	            } catch (SQLException e7) {
	                JOptionPane.showMessageDialog(null, "Error en el driver" + e7);
	            }
	        } catch (SQLException e5) {
	            JOptionPane.showMessageDialog(null,"Error en el driver" + e5);
	        }
	    }
	    
	    public void mostrar_matricula(javax.swing.JTextArea caja) {
	        try {
	            CallableStatement sp = conn.prepareCall("call sp_mostrar_matricula()");
	            sp.execute();
	            data = sp.getResultSet();
	            try {
	                while (data.next()) {
	                    caja.append(data.getInt("id_matricula") + " | "
	                            + data.getInt("id_cliente") + " | " + data.getInt("id_vehiculo") + 
	                            " | " +  data.getString("codigo_matricula")+"\n");
	                }
	            } catch (SQLException e7) {
	                JOptionPane.showMessageDialog(null, "Error en el driver" + e7);
	            }
	        } catch (SQLException e5) {
	            JOptionPane.showMessageDialog(null,"Error en el driver" + e5);
	        }
	    }
}
