package Bonati;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
public class MantenerPoliclinico {


public class MantenerPoliclínico {

    private String SQL="";
    private String host="db4free.net";
    private String user="bonatiii";
    private String pass="bonatiii";
    private String port="3306";
    private String bd="bonatiii";
    private Connection conn;
    private Statement s;

     public MantenerPoliclínico() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
            conn = (Connection) Mysql.connect("jdbc:mysql://"+host+":"+port+"/"+bd,user,pass,conn);
            s = (Statement) conn.createStatement();
        }

	public void addVacuna(Vacuna v) throws SQLException {
            SQL = "INSERT INTO Vacuna VALUES ('"+v.getNombre()+"','"+ v.getDescripcion()+"');";
            Mysql.insertSQL(conn, SQL);
	}

	public void setVacuna(Vacuna v) throws SQLException {
            SQL = "UPDATE Usuario SET Vacuna = '"+v.get()+"' WHERE Usuario.nombre = '"+v.getNombre()+"';";
            Mysql.insertSQL(conn, SQL);
	}



	public ArrayList<String> getVacunas(int numColumnas) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
            SQL = "SELECT * FROM Usuario;";
            return Mysql.selectSQL(conn, SQL,numColumnas);
	}

}
}

