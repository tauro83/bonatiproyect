package Bonati;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MantenerCita {

        private String SQL="";
        private String host="db4free.net";
        private String user="bonatiii";
        private String pass="bonatiii";
        private String port="3306";
        private String bd="bonatiii";
        private Connection conn;
        private Statement s;

        public MantenerCita() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            conn = (Connection) Mysql.connect("jdbc:mysql://"+host+":"+port+"/"+bd,user,pass,conn);
            s = (Statement) conn.createStatement();

        }

	public void addCita(Cita c) throws SQLException {
           java.sql.Time sqlHoraFin = new java.sql.Time(c.getHoraFin().getTime());// convertir a DATE para SQL
           java.sql.Time sqlHoraIni = new java.sql.Time(c.getHoraInicio().getTime());// convertir a DATE para SQL
           java.sql.Date sqlDate = new java.sql.Date(c.getDia().getTime());

           SQL = "INSERT INTO Cita VALUES ('"+c.getIdCita()+"','"+sqlDate+"','"+sqlHoraIni +"','"+sqlHoraFin+"','"+c.getIdAgenda()+"','"+c.getRutCliente()+"','"+c.getIdMascota()+");";
           Mysql.insertSQL(conn, SQL);
	}
	
	public void setCita(Cita c) throws SQLException {
            java.sql.Time sqlHoraFin = new java.sql.Time(c.getHoraFin().getTime());// convertir a DATE para SQL
            java.sql.Time sqlHoraIni = new java.sql.Time(c.getHoraInicio().getTime());// convertir a DATE para SQL
            java.sql.Date sqlDate = new java.sql.Date(c.getDia().getTime());
            SQL = "UPDATE Cita SET Cita.fecha = '"+sqlDate+"', Cita.horaInicio='"+sqlHoraIni +"',Cita.horaFin='"+sqlHoraFin+ "' WHERE Cita.idCita = '"+c.getIdCita()+"';";
            Mysql.insertSQL(conn, SQL);
	}     
	
	public void purgCita(int id) throws SQLException {
            SQL = "DELETE FROM Cita WHERE Cita.idCita = '"+id+"';";
            Mysql.insertSQL(conn, SQL);
	}
	
	public ArrayList<String> getCita(int id,int numColumnas ) throws SQLException {
            SQL = "SELECT * FROM Cita WHERE Cita.idCita = '"+id+"';";
            return Mysql.selectSQL(conn, SQL, numColumnas);
	}

        public  ArrayList<String> getCitas(int numColumnas) throws SQLException{
            SQL = "SELECT * FROM Cita";
            return Mysql.selectSQL(conn, SQL, numColumnas);
        }

       
}
