package bd;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;

public class DBConnectionManager{

	private static  String JNDINAME = "java:postgresConnection";
	
	/**
	 * Metodo que obtiene una conexion cualquiera desde el POOL de conexiones para JBoss.
	 * @param connectTo: nombre de la referencia al recurso JNDI que apunta al pool de conexiones deseada.
	 * @return una conexion a una base de datos lista para utilizar. Null en caso de error.
	 * */
	public static Connection getConnection(){			
	    Context ctx = null;
	    DataSource ds = null;
	    Connection conn = null; 
		
		try{
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup(DBConnectionManager.JNDINAME);
		} 
		catch (NamingException e){e.printStackTrace();}	
		
		try{
			conn= ds.getConnection();
			//System.out.println("Conexion obtenida del POOL de conexiones a BD");
		} 
		catch (SQLException e) {e.printStackTrace();}
		return conn;
    }

	
}
