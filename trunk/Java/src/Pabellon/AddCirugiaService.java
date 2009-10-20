package Pabellon;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import AdministracionBD.AddMascotaBD;
import PabellonBD.AddCirugiaBD;
import AdministracionBD.UsuarioEditBD;
import AdministracionBD.UsuarioElimBD;
import TransferObjects.Mascota;
import TransferObjects.Usuario;
import Bd.DBConnectionManager;
import TransferObjects.tiposCir;
import TransferObjects.Cirugia;

public class AddCirugiaService {
	public List<Usuario> persons;
	/**
	 * Autor: Jimmy Muñoz
	 * Metodo que llama a la funcion con el mismo nombre que se encuentra en la 
	 * clase que se conecta con la base de datos.
	 * @param Usuario contiene los datos de la persona que se quiere editar.
	 * @return 1 si ha insertado correctamente, -1 o 0 si la inserción ha fallado
	 */
	public int AddCirugia(Cirugia nuevaCir)
    {
		
		/*System.out.println("ayudante: "+nuevaCir.getAyudante());
		System.out.println("veterinario: "+nuevaCir.getVeterinario());
		System.out.println("fecha: "+nuevaCir.getFecha());
		System.out.println("diagnostico: "+nuevaCir.getDiagnostico());
		System.out.println("rut cliente: "+nuevaCir.getClienteRut());
		System.out.println("nombre mascota: "+nuevaCir.getMascotaNombre());
		
		List<tiposCir> ltc = nuevaCir.getTiposCirugias();
		
		
		
		int n2 = ltc.size();
		for(int i=0;i<n2;i++){
			tiposCir tc = (tiposCir)ltc.get(i);
			if(tc != null){
				System.out.println("Tipo de cirugia"+i+": "+tc.getCirugias());
			}
			
		}
		*/
		
		this.getAllUsuariosE();
		String nombreVet = nuevaCir.getVeterinario();
		String nombres[] = nombreVet.split(" ");
		String nombreAyu = nuevaCir.getAyudante();
		String nombresa[] = nombreAyu.split(" ");
		
		
		int n = persons.size();
		
		for(int i=0;i<n;i++){
			Usuario u = persons.get(i); 
			String nombre = u.getNombre().trim();
			String nombre2 = u.getApellidoPaterno().trim();
			if(nombre.equals(nombres[0]) && nombre2.equals(nombres[1])){
				nuevaCir.setVeterinario(u.getUsuario().trim());
			}
		}
		
		for(int i=0;i<n;i++){
			Usuario u = persons.get(i); 
			String nombre = u.getNombre().trim();
			String nombre2 = u.getApellidoPaterno().trim();
			if(nombre.equals(nombresa[0]) && nombre2.equals(nombresa[1])){
				nuevaCir.setAyudante(u.getUsuario().trim());
			}
		}

		int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD cirugiaBd = new AddCirugiaBD(connection);
			result = cirugiaBd.addCirugia(nuevaCir);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;

		/*int result=0;
		try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditBD personDB= new UsuarioEditBD(connection);
			result= personDB.insertUsuarioE(person);		
			connection.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return result;*/
    }
	
	
	public String getCliente(String rutCliente){
    	String cliente = null;
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD addCirugiaBD = new AddCirugiaBD(connection);
			cliente = addCirugiaBD.getCliente(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return cliente;
	}
	
	/**
	 * Crea la conexion a la base de datos para retornar todas las mascotas
	 * @return Lista de todas las mascotas
	 */
	public List<Mascota> getAllMascotas(){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD cirugiaBD = new AddCirugiaBD(connection);
			mascotas= cirugiaBD.getAllMascotas();		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
    
	/**
	 * Crea la conexion a la base de datos para retornar las mascotas de @param
	 * @param rutCliente Rut de Cliente que se quiere retornar sus mascotas
	 * @return Lista de mascotas
	 */
	public List<Mascota> getMascotas(String rutCliente){
    	List<Mascota> mascotas=new ArrayList<Mascota>();
    	try {
			Connection connection=DBConnectionManager.getConnection();
			AddCirugiaBD cirugiaBD= new AddCirugiaBD(connection);
			mascotas= cirugiaBD.getMascotas(rutCliente);		
			connection.close();
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
		return mascotas;
    }
	
	public List<tiposCir> getTiposCirugias(){
		List<String> cirus=new ArrayList<String>();
		List<tiposCir> tiposcirus=new ArrayList<tiposCir>();
		
		cirus.add("Amputación");
		cirus.add("De Apéndice");
		cirus.add("De los aparatos respiratorio");
		cirus.add("De los aparatos cardiovascular");
		cirus.add("De ojo");
		cirus.add("De todo tipo de fractura");
		cirus.add("Del sistema digestivo");
		cirus.add("Del sistema tegumentario");
		cirus.add("Del sistema reproductor");
		cirus.add("Del sistema urinario");
		cirus.add("Dental");
		cirus.add("Estenosis traqueal");
		cirus.add("Ortopédica");
		cirus.add("Partos y cesaria");
		cirus.add("Tiroidectomía (por tumores)");
		cirus.add("De tumor");
		
		for(int i=0;i<cirus.size();i++){
			tiposCir tc = new tiposCir();
			tc.setCirugias(cirus.get(i));
			tiposcirus.add(tc);
		}

		return tiposcirus;	
	}
	
	
	public List<String> getTiposVeterinarios(){
		List<String> cirus=new ArrayList<String>();
		
		this.getAllUsuariosE();
		cirus.add("");
		int n = persons.size();
		
		for(int i=0;i<n;i++){
			Usuario u = persons.get(i); 
			String cargo = u.getCargo().trim();
			if(cargo.equals("Veterinario")){
				String nombre = u.getNombre().trim();
				String apellido = u.getApellidoPaterno().trim();
				String nombFinal = nombre.concat(" "+apellido);
				cirus.add(nombFinal);
			}
		}

		return cirus;	
	}
	
	public List<String> getTiposAyudantes(){
		List<String> cirus=new ArrayList<String>();
		
		this.getAllUsuariosE();
		cirus.add("");
		int n = persons.size();
		for(int i=0;i<n;i++){
			Usuario u = persons.get(i); 
			String cargo = u.getCargo().trim();
			if(cargo.equals("Veterinario") || cargo.equals("Ayudante")){
				String nombre = u.getNombre().trim();
				String apellido = u.getApellidoPaterno().trim();
				String nombFinal = nombre.concat(" "+apellido);
				cirus.add(nombFinal);
			}
		}
		
		return cirus;	
	}
	
	
	/**
	 * Autor: Jimmy Muñoz
	 * Solicita a la clase que se conecta con la base de datos, los datos de cada usuario.
	 * @param
	 * @return Lista con objetos de la clase Usuario
	 */
    public void getAllUsuariosE()
    {
    	persons=new ArrayList<Usuario>();
    	try 
		{
			Connection connection=DBConnectionManager.getConnection();
			UsuarioEditBD personDB= new UsuarioEditBD(connection);
			persons= personDB.getAllUsuariosE();		
			connection.close();
		} 
    	catch (SQLException e) 
		{
			e.printStackTrace();
		}
    }
}
