package BMC;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionManager
{

	/**
	 * Metodo que obtiene una conexion cualquiera desde el POOL de conexiones para JBoss.
	 * @param connectTo: nombre de la referencia al recurso JNDI que apunta al pool de conexiones deseada.
	 * @return una conexion a una base de datos lista para utilizar. Null en caso de error.
	 * */
	public static Connection getConnection() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            String host="jdbc:postgresql://localhost:5432/postgres";
            String user="postgres";
            String pasw="postgres";
         try {

             Class.forName("org.postgresql.Driver").newInstance();

             Connection conn = DriverManager.getConnection(host,user,pasw);
             if (conn != null) {

                return conn;
             }
             else{
                 System.out.println("error de conexion");
                 return null;

             }
         }
         catch(SQLException ex) {
             System.out.println("error de conexion2");
             return null;
         }
    }

	
}
