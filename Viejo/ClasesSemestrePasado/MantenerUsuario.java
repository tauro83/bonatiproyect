package Bonati;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MantenerUsuario {

        private String SQL="";        
        private String host="db4free.net";
        private String user="bonatiii";
        private String pass="bonatiii";
        private String port="3306";
        private String bd="bonatiii";
        private Connection conn;
        private Statement s;


        public MantenerUsuario() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            conn = (Connection) Mysql.connect("jdbc:mysql://"+host+":"+port+"/"+bd,user,pass,conn);
            s = (Statement) conn.createStatement();
        }

	public void addUsuario(Usuario u) throws SQLException {
            SQL = "INSERT INTO Usuario VALUES ('"+u.getNombre()+"','"+ u.getContraseña()+"','"+  u.getCargo()+"','"+ u.getidServicio()+"','"+ u.getidServicio()+"');";
            Mysql.insertSQL(conn, SQL);
	}
	
	public void setUsuario(Usuario u) throws SQLException {
            SQL = "UPDATE Usuario SET Usuario.contraseña = '"+u.getContraseña()+"' WHERE Usuario.nombre = '"+u.getNombre()+"';";
            Mysql.insertSQL(conn, SQL);
	}
        
	
	public void purgUsuario(String nombre) throws SQLException{
            SQL = "DELETE FROM Usuario WHERE Usuario.nombre = '"+nombre+"';";
            Mysql.insertSQL(conn, SQL);
	}
	
	public ArrayList<String> getUsuarios(int numColumnas) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            SQL = "SELECT * FROM Usuario;";          
            return Mysql.selectSQL(conn, SQL,numColumnas);
	}

        
}
