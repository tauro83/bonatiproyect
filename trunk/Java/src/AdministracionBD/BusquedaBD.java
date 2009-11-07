//=======================================================================
// FECHA CREACIÓN: 6 Octubre
// AUTOR: Esteban Cruz
// Clase de busqueda del sistema, dentro de esta se pueden realizar 
// busquedas para: Mascota, Cliente, Atencion, Producto, Aviso, Usuario
// Hace la conexion con la BD
//=======================================================================

package AdministracionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TransferObjects.Producto;
import TransferObjects.Cliente;
import TransferObjects.Mascota;
import TransferObjects.Usuario;
import TransferObjects.Atencion;

public class BusquedaBD 
{
	PreparedStatement selectAllUsuarios;
	PreparedStatement selectAllClientes;
	PreparedStatement selectAllMascotas;
	PreparedStatement selectAllAtenciones;
	PreparedStatement selectAllProductos;
	/**
	 *  Se declaran las consultas hacia la base de datos
	 *  @author  "Esteban Cruz"
	 *  @param connection Conexión obtenida con la base de datos
	 **/
	public BusquedaBD(Connection connection)
	{
		try 
		{
			String query="";
			
			query = "SELECT nombre, aPaterno, aMaterno, cargo, servicio " +
					"FROM usuario;";
			selectAllUsuarios = connection.prepareStatement(query);
			
			query = "SELECT nombre, rut, telefono2, email, apellido, apellido2 " +
					"FROM clientepresencial;";
			selectAllClientes = connection.prepareStatement(query);
			
			query = "SELECT rut, nombre, claseanimal, raza, sexo " +
					"FROM mascota;";
			selectAllMascotas = connection.prepareStatement(query);
			
			query = "SELECT clienteRut, mascotaNombre, servicio, hora, fecha " +
					"FROM atencion;";
			selectAllAtenciones = connection.prepareStatement(query);
			
			query = "SELECT nombre, precio, categoria, codigo " +
					"FROM producto;";
			selectAllProductos = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
    
	/**
	 *  Trata de obtener todos los usuarios registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos los usuarios registrados
	 **/
    public List<Usuario> getAllUsuarios()
    {	
    	List<Usuario> usuarios = new ArrayList<Usuario>();
    	Usuario usuario;
    
    	try 
    	{
    		ResultSet result = selectAllUsuarios.executeQuery();
    		while(result.next())
    		{  
    			usuario = new Usuario();
    			
    			usuario.setNombre(result.getString(1).trim());
    			usuario.setApellidoPaterno(result.getString(2).trim());
    			usuario.setApellidoMaterno(result.getString(3).trim());
    			usuario.setCargo(result.getString(4).trim());
    			usuario.setServicio(result.getString(5).trim());
    			
    			usuarios.add(usuario);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return usuarios;
    }
    
    /**
     *  Trata de obtener todos los clientes registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos los clientes registrados
	 **/
    public List<Cliente> getAllClientes()
    {	
    	List<Cliente> clientes = new ArrayList<Cliente>();
    	Cliente cliente;
    
    	try 
    	{
    		ResultSet result = selectAllClientes.executeQuery();
    		while(result.next())
    		{  
    			cliente = new Cliente();
    			
    			cliente.setNombre(result.getString(1).trim());
    			cliente.setRut(result.getString(2).trim());
    			cliente.setTelefono2(result.getString(3).trim());
    			cliente.setEmail(result.getString(4).trim());
    			cliente.setApellido(result.getString(5).trim());
    			cliente.setApellido2(result.getString(6).trim());
    			
    			clientes.add(cliente);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return clientes;
    }
    
    /**
     *  Trata de obtener todos las mascotas registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos las moscotas registrados
	 **/
    public List<Mascota> getAllMascotas()
    {	
    	List<Mascota> mascotas = new ArrayList<Mascota>();
    	Mascota mascota;
    
    	try 
    	{
    		ResultSet result = selectAllMascotas.executeQuery();
    		while(result.next())
    		{  
    			mascota = new Mascota();
    			
    			mascota.setRutCliente(result.getString(1).trim());
    			mascota.setNombre(result.getString(2).trim());
    			mascota.setClaseAnimal(result.getString(3).trim());
    			mascota.setRaza(result.getString(4).trim());
    			mascota.setSexo(result.getString(5).trim());
    			
    			mascotas.add(mascota);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return mascotas;
    }
    
    /**
     *  Trata de obtener todos las atenciones registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos las atenciones registrados
	 **/
    public List<Atencion> getAllAtenciones()
    {	
    	List<Atencion> atenciones = new ArrayList<Atencion>();
    	Atencion atencion;
    
    	try 
    	{
    		ResultSet result = selectAllAtenciones.executeQuery();
    		while(result.next())
    		{  
    			atencion = new Atencion();
    			
    			atencion.setClienteRut(result.getString(1).trim());
    			atencion.setMascotaNombre(result.getString(2).trim());
    			atencion.setServicio(result.getString(3).trim());
    			atencion.setHora(result.getString(4).trim());
    			atencion.setSfecha(result.getString(5).trim());
    			
    			atenciones.add(atencion);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return atenciones;
    }
    
    /**
     *  Trata de obtener todos los productos registrados en la base de datos
	 *  @author  "Esteban Cruz"
	 *  @return Lista con todos los productos registrados
	 **/
    public List<Producto> getAllProductos()
    {	
    	List<Producto> productos = new ArrayList<Producto>();
    	Producto producto;
        
    	try 
    	{
    		ResultSet result = selectAllProductos.executeQuery();
    		while(result.next())
    		{  
    			producto = new Producto();
    			
    			producto.setNombre(result.getString(1).trim());
    			producto.setPrecio(result.getString(2).trim());
    			producto.setCategoria(result.getString(3).trim());
    			producto.setCodigo(result.getString(4).trim());
    			
    			productos.add(producto);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return productos;
    }
}
