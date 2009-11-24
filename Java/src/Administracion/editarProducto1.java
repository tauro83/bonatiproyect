package Administracion;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import AdministracionBD.editarProductoBD;
import Bd.DBConnectionManager;
import HoteleriaBD.EditHoteleriaBD;
import TransferObjects.Hoteleria;
import TransferObjects.Producto;

public class editarProducto1 {
	
	public List<Producto> getAllVacunaciones()
    {
		List<Producto> vacunaciones = new ArrayList<Producto>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			editarProductoBD vacunacionBD= new editarProductoBD(connection);
			vacunaciones = vacunacionBD.getAllVacunaciones();	
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return vacunaciones;
    }
	
	public int modificarProducto(String nombre,String descripcion,String precio,String categoria,String codigo)
    {
		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			editarProductoBD hBD = new editarProductoBD(connection);
			result= hBD.modificarProducto(nombre,descripcion,precio,categoria,codigo);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;
    }
}
