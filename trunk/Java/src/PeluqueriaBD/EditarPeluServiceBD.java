package PeluqueriaBD;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import TransferObjects.CatPeluqueria;
import TransferObjects.Peluqueria;

public class EditarPeluServiceBD 
{
	PreparedStatement insert;
	PreparedStatement deletete;
	PreparedStatement selectAll;
	PreparedStatement selectOne;
	Connection conn;
	String rutillo;
	String rut;
	
	
	public EditarPeluServiceBD(Connection connection)
	{
		
		conn = connection;
		try 
		{
			String query="";
			
			query = "INSERT INTO serviciospeluqueria(servicio, nombre, clienterut, mascotanombre, hora, responsable, fecha, nuevafecha, nuevahora, costo, descripcion) "+
			"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";			
			
			insert = connection.prepareStatement(query);
			
			
			query = "SELECT clienterut, mascotanombre, hora, responsable, fecha "+
			"FROM atencionpeluqueria;";

			selectAll = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * Ingresa a una nueva persona a la base de datos
	 * @param person contiene los datos de la persona que se quiere ingresar
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
    @SuppressWarnings("deprecation")
	public int editarPeluqueria(Peluqueria pelu, ArrayList<CatPeluqueria> catalogos)
    {
    	int result=0;
    	try{
    		Calendar c = Calendar.getInstance();
    		int hora = c.get(Calendar.HOUR_OF_DAY);
    		int minutos = c.get(Calendar.MINUTE);
    		int segundos = c.get(Calendar.SECOND);
    		
    		String s11, s22, s33;
    		s11 = pelu.getHoraAntigua().substring(0,2);
    		s22 = pelu.getHoraAntigua().substring(3,5);
    		s33 = pelu.getHoraAntigua().substring(6);
    		System.out.println("s1: "+s11+" s2: "+s22+" s3: "+s33);
    		int hora2 = (Integer)Integer.parseInt(s11);
    		int minu2 = (Integer)Integer.parseInt(s22);
    		int seg2 = (Integer)Integer.parseInt(s33);
    		System.out.println("hora: "+hora2+". minu: "+minu2+". seg: "+seg2);
    		Time t = new Time(hora, minutos, segundos);
			
			List<String> ltN = pelu.getTiposNombres();
			List<String> ltS = pelu.getTiposServicios();
			
			int n = ltS.size();
			for(int i=0;i<n;i++){
				String tipPel = ltS.get(i);
				String tipNom = ltN.get(i);
				
				hora = c.get(Calendar.HOUR_OF_DAY);
	    		minutos = c.get(Calendar.MINUTE);
	    		segundos = c.get(Calendar.SECOND);
	    		
	    		Time t2 = new Time(hora, minutos, segundos);
				
				if(tipPel != null){
					
					String costo = getCosto(tipPel,tipNom,catalogos);
					insert.setString(1, tipPel);
					insert.setString(2, tipNom);
					insert.setString(3, pelu.getRutCliente());
					insert.setString(4, pelu.getNombreMascota());
					insert.setTime(5, t);
					insert.setString(6, pelu.getResponsable());
					insert.setDate(7, pelu.getFechaAntigua());
					insert.setDate(8, pelu.getFecha());
					insert.setTime(9, t2);
					insert.setString(10, costo);
					insert.setString(11, pelu.getDescripcion());

					result= insert.executeUpdate();
				}
				
			}
		} 
    	
    	/*int result=0;
    	try 
    	{
    		insert.setString(1, pelu.getRutCliente());
    		insert.setString(2, pelu.getNombreMascota());
    		insert.setString(3, pelu.getResponsable());
    		insert.setString(4, pelu.getServicio());
    		insert.setDate(5, pelu.getFecha());
			insert.setString(6, pelu.getCosto());
    		insert.setString(7, pelu.getDescripcion());
    	
			
			result= insert.executeUpdate();
			System.out.println(+result);
			
			
			result= insert.executeUpdate();
			
		} */
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    
    /**
	 * Metodo que obtiene el costo que tiene una determinada vacuna. Y asigna el valor de caducidad 
	 * para posteriormente generar el date que se almacenara.
	 * @autor  Jimmy Muñoz
	 * @param tc: el nombre de la vacuna que se quiere registrar. vacunas: listado de vacunas 
	 * registradas en el sistema.
	 * @return El costo de la vacuna, en formato String.
	 */
    public String getCosto(String tc,String tc2, ArrayList<CatPeluqueria> catalogos){
    	int largo = catalogos.size();
    	String costo = "0";
    	for(int i=0;i<largo;i++){
    		
    		if(tc2.equals(catalogos.get(i).getNombre().trim()) && tc.equals(catalogos.get(i).getServicio().trim())){
    			return catalogos.get(i).getPrecio();
    		}
    	}
    	
    	return costo;
    }    
    
    
    @SuppressWarnings("deprecation")
	public List<Peluqueria> getAllPeluquerias(String rutCliente, String nombreMascota)
    {
    	List<Peluqueria> peluquerias=new ArrayList<Peluqueria>();
    	try 
    	{
    		
    		ResultSet result = selectAll.executeQuery();
    		while(result.next())
    		{	
    			if(rutCliente.equals(result.getString(1).substring(0, 8)) && nombreMascota.equals(result.getString(2)) ){
    				
    				//clienterut, mascotanombre, hora, responsable, fecha 
    				Date fecha;
    				Peluqueria pelu= new Peluqueria();
    				pelu.setRutCliente(result.getString(1));
    				pelu.setNombreMascota(result.getString(2));
    				pelu.setHora(result.getString(3));
    				pelu.setResponsable(result.getString(4));
    				fecha = result.getDate(5);
    				pelu.setFecha(fecha);
    				String fechas;
    				int diaN, mesN, anoN;
    				diaN = fecha.getDate();
    				mesN = fecha.getMonth()+1;
    				anoN = fecha.getYear()+1900;
    				
    				if(diaN<10){
    					if(mesN<10){
    						fechas = "0"+diaN+"/0"+mesN+"/"+anoN;
    					}
    					else{
    						fechas = "0"+diaN+"/"+mesN+"/"+anoN;
    					}
    					
    				}
    				else{
    					if(mesN<10){
    						fechas = ""+diaN+"/0"+mesN+"/"+anoN;
    					}
    					else{
    						fechas = ""+diaN+"/"+mesN+"/"+anoN;
    					}
    				}
    				pelu.setFechaS(fechas);
    				peluquerias.add(pelu);
    			}
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return peluquerias;
    }
    
    
    
   
}
