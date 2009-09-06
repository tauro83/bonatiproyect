package Bonati;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MantenerServicio {
	private String SQL="";
        private String host="db4free.net";
        private String user="bonatiii";
        private String pass="bonatiii";
        private String port="3306";
        private String bd="bonatiii";
        private Connection conn;
        private Statement s;


        public MantenerServicio() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            conn = (Connection) Mysql.connect("jdbc:mysql://"+host+":"+port+"/"+bd,user,pass,conn);
            s = (Statement) conn.createStatement();
        }

	public void addServicio(Servicio s) throws SQLException {

            //idServicio, nombre, costo, Admistrador_idAdmistrador, descripcion
           SQL = "INSERT INTO Servicio VALUES ('"+s.getIdServicio()+"','"+ s.getNombre()+"','"+s.getCosto() +"','"+ s.getIdAdministrador()+"','"+s.getDescripcion()+");";
           Mysql.insertSQL(conn, SQL);

	}
	
	public void delServicio(int id) throws SQLException {
            SQL = "DELETE FROM Servicio WHERE Servicio.idServicio = '"+id+"';";
            Mysql.insertSQL(conn, SQL);
	}
	
	public void setServicio(Servicio s) throws SQLException {
             SQL = "UPDATE Servicio SET Servicio.descripcion = '"+s.getDescripcion()+"', Servicio.Admistrador_idAdmistrador='"+s.getAdministrador()+"';";
             Mysql.insertSQL(conn, SQL);
	}
	
	public ArrayList<String> getServicios(int numColumnas)throws SQLException{
            SQL = "SELECT * FROM Servicio";
            return Mysql.selectSQL(conn, SQL, numColumnas);
	}
        

}
