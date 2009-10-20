package PeluqueriaBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import TransferObjects.EstadisticasPeluqueria;


public class GetEstadisticasAtencionesBD {
	PreparedStatement selectAll;
	Connection connection;
	ResultSet result;
	
	public GetEstadisticasAtencionesBD(Connection connection)
	{
		this.connection = connection;
		
	}
	
	public List<EstadisticasPeluqueria> getEstadisticasBD(String inicio,String fin) throws SQLException
    {
    	List<EstadisticasPeluqueria> atenciones=new ArrayList<EstadisticasPeluqueria>();
    
    	String queryCorte		=  "select count(*) from corte where fecha between '"+inicio+"' and '"+fin+"'";
		String queryPedicure 	=  "select count(*) from atencionpedicure where fecha between '"+inicio+"' and '"+fin+"'";
		String queryBanio 		=  "select count(*) from atencionbanio where fecha between '"+inicio+"' and '"+fin+"'";	
		
		EstadisticasPeluqueria  corte = new EstadisticasPeluqueria();
		EstadisticasPeluqueria  banio= new EstadisticasPeluqueria();
		EstadisticasPeluqueria  pedicure= new EstadisticasPeluqueria();
		corte.setTipo("Corte");
		banio.setTipo("Baño");
		pedicure.setTipo("Pedicura");
				//Obteniendo cortes
		selectAll = connection.prepareStatement(queryCorte);
		result = selectAll.executeQuery();
		
		while(result.next())
		{
			corte.setNumAtenciones(result.getInt(1));
		}
		
		//Obteniendo Pedicures
		selectAll = connection.prepareStatement(queryPedicure);
		result = selectAll.executeQuery();
		
		while(result.next())
		{
			pedicure.setNumAtenciones(result.getInt(1));
		}
		
		//Obteniendo baños
		selectAll = connection.prepareStatement(queryBanio);
		result = selectAll.executeQuery();
		
		while(result.next())
		{
			banio.setNumAtenciones(result.getInt(1));
		}
		
		atenciones.add(corte);
		atenciones.add(banio);
		atenciones.add(pedicure);
    	
    	return atenciones;
    }
}
