package datos;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Mantenimiento {
	
	public String driver="com.mysql.cj.jdbc.Driver";
	public String cadena="jdbc:mysql://localhost:3306/carros";
	public String usuario="root";
	public String clave="";
	public Connection conn;
	public ResultSet data;
	public PreparedStatement PreSta;
	
	
	
	public Mantenimiento() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(cadena,usuario,clave);
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(null,"Error en el driver" + e1);
			} catch (SQLException e2){
				JOptionPane.showMessageDialog(null,"Error en el driver" + e2);
		}
	}
	
	public void reporte1 (String reportes,String consulta) {
		try {
			
			String sql=consulta;
			String ruta = "src/reportes/"+reportes+".jrxml";
			JasperDesign jd=JRXmlLoader.load(ruta);
			JRDesignQuery jrdq=new  JRDesignQuery();
			jrdq.setText(sql);
			jd.setQuery(jrdq);
			JasperReport jr=JasperCompileManager.compileReport(jd);
			JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
			JasperViewer.viewReport(jp,false);
		} catch (JRException e) {
			JOptionPane.showMessageDialog(null,"Error al generar reporte" );
		}
		
}
	
	public void reporte2 (String reportes,String consulta, int id) {
		try {
	
			String sql=consulta;
			String ruta = "src/reportes/"+reportes+".jrxml";
			JasperDesign jd=JRXmlLoader.load(ruta);
			Map <String,Object> map =new HashMap<String,Object>();
			map.clear();
			map.put("id",id);
			
			JRDesignQuery jrdq=new  JRDesignQuery();
			jrdq.setText(sql);
			jd.setQuery(jrdq);
			JasperReport jr=JasperCompileManager.compileReport(jd);
			JasperPrint jp=JasperFillManager.fillReport(jr,map,conn);
			JasperViewer.viewReport(jp,false);
		} catch (JRException e) {
			JOptionPane.showMessageDialog(null,"Error al generar reporte" );
		}
		
	}
}
