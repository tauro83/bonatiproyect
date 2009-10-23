package ClinicaBD;
//=======================================================================
// AUTOR: Andres Garrido Rojas
// Descripcion: Clase que recolecta estadisticas para clinica,
//				referentes a la frecuencia de atenciones en una determinada
//				área de clinica.
//=======================================================================
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Bd.DBConnectionManager;
import TransferObjects.EstadisticasClinica;

public class GetEstadisticasClinicaBD {
	Connection connection;
	PreparedStatement selectAll;
	ResultSet result;
	
	public GetEstadisticasClinicaBD(Connection conn) throws SQLException{
		this.connection = conn;
		String result = null;
		
		String query="";		
	}
	/**
	 * Metodo que obtiene la cantidad de atenciones para todos los servicios y 
	 * retorna un objecto que representa la frecuencia de ellas
	 * @author  Andres Garrido
	 * @version 1.0, 06/10/09
	 * @param tipo tipo de estadistica 1:Pabellon, 2:Policlinico
	 * @param inicio Fecha de inicio de estadistica
	 * @param fin Fecha de fin de estadistica
	 */
	public List<EstadisticasClinica> getEstadisticasBD(int tipo, String inicio,String fin) throws SQLException
    {
    	List<EstadisticasClinica> atenciones=new ArrayList<EstadisticasClinica>();
    	if(tipo==1){
    		String queryPreOperatorio =  "select count(*) from atencionpreoperatorio where fecha between '"+inicio+"' and '"+fin+"'";
    		String queryPostOperatorio =  "select count(*) from atencionpostoperatorio where fecha between '"+inicio+"' and '"+fin+"'";
    		String queryClinica =  "select count(*) from atencioncirugia where fecha between '"+inicio+"' and '"+fin+"'";	
    		EstadisticasClinica  pre = new EstadisticasClinica();
    		EstadisticasClinica  post = new EstadisticasClinica();
    		EstadisticasClinica  clinica= new EstadisticasClinica();
    		pre.setTipo("Pre-Operatorio");
    		post.setTipo("Post-Operatorio");
    		clinica.setTipo("Cirugía");
    		
    		//Obteniendo Pre Operatorios
    		selectAll = connection.prepareStatement(queryPreOperatorio);
    		result = selectAll.executeQuery();
    		
    		while(result.next()){
    			pre.setNumAtenciones(result.getInt(1));
    		}
    		
    		//Obteniendo Post Operatorios
    		selectAll = connection.prepareStatement(queryPostOperatorio);
    		result = selectAll.executeQuery();
    		
    		while(result.next()){
    			post.setNumAtenciones(result.getInt(1));
    		}
    		
    		//Obteniendo Clinica
    		selectAll = connection.prepareStatement(queryClinica);
    		result = selectAll.executeQuery();
    		
    		while(result.next()){
    			clinica.setNumAtenciones(result.getInt(1));
    		}
    		
    		atenciones.add(pre);
    		atenciones.add(post);
    		atenciones.add(clinica);
    	}
    	if(tipo==2){
    		String queryConsulta =  "select count(*) from atencionconsulta where fecha between '"+inicio+"' and '"+fin+"'";
    		String queryControl =  "select count(*) from atencioncontrol where fecha between '"+inicio+"' and '"+fin+"'";
    		String queryVacuna =  "select count(*) from atencionvacuna where fecha between '"+inicio+"' and '"+fin+"'";	
    		EstadisticasClinica  consulta = new EstadisticasClinica();
    		EstadisticasClinica  control = new EstadisticasClinica();
    		EstadisticasClinica  vacuna = new EstadisticasClinica();
    		consulta.setTipo("Consulta");
    		control.setTipo("Control");
    		vacuna.setTipo("Vacuna");
    		
    		//Obteniendo Consultas
    		selectAll = connection.prepareStatement(queryConsulta);
    		result = selectAll.executeQuery();
    		
    		while(result.next()){
    			consulta.setNumAtenciones(result.getInt(1));
    		}
    		
    		//Obteniendo Controles
    		selectAll = connection.prepareStatement(queryControl);
    		result = selectAll.executeQuery();
    		
    		while(result.next()){
    			control.setNumAtenciones(result.getInt(1));
    		}
    		
    		//Obteniendo Vacunas
    		selectAll = connection.prepareStatement(queryVacuna);
    		result = selectAll.executeQuery();
    		
    		while(result.next()){
    			vacuna.setNumAtenciones(result.getInt(1));
    		}
    		
    		atenciones.add(consulta);
    		atenciones.add(control);
    		atenciones.add(vacuna);
    	}
		
		
    	
    	return atenciones;
    }
}
