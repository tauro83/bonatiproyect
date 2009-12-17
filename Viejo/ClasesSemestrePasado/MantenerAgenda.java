package Bonati;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.util.ArrayList;


public class MantenerAgenda {

        private String SQL="";
        private String host="db4free.net";
        private String user="bonatiii";
        private String pass="bonatiii";
        private String port="3306";
        private String bd="bonatiii";
        private Connection conn;
        private Statement s;

        public MantenerAgenda()throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            conn = (Connection) Mysql.connect("jdbc:mysql://"+host+":"+port+"/"+bd,user,pass,conn);
            s = (Statement) conn.createStatement();
        }

      
	public void addAgenda(Agenda a) throws SQLException {
            SQL = "INSERT INTO Agenda VALUES ('"+a.getIdAgenda()+"','"+a.getidDiaBloqueado()+"','"+a.getIdServicio()+"');";
            Mysql.insertSQL(conn, SQL);
	}

        public ArrayList<String> getAgendas(int numColumnas) throws SQLException{
            SQL = "SELECT * FROM Agenda;";
            return Mysql.selectSQL(conn, SQL,numColumnas);
        }

	public void editAgenda(Agenda a) {
            System.out.println("No implementado");
	}
	
	public void purgAgenda(int id) throws SQLException {
            SQL = "DELETE FROM Agenda WHERE Agenda.idAgenda = '"+id+"';";
            Mysql.insertSQL(conn, SQL);
	}
	
	public ArrayList<String> getAgenda(int id,int numColumnas) throws SQLException {
           SQL = "SELECT * FROM Agenda WHERE Agenda.idAgenda = '"+id+"';";
           return Mysql.selectSQL(conn, SQL,numColumnas);
	}

        public ArrayList<String> getDiasBloqueados(int idAgenda,int numColumnas) throws SQLException{
            SQL = "SELECT * FROM diaBloqueados";
            return Mysql.selectSQL(conn, SQL,numColumnas);
        }

        public void delDiaBloqueado(int idAgenda) throws SQLException{
            SQL = "DELETE FROM diaBloqueados WHERE diaBloqueados.idAgenda = '"+idAgenda+"';";
            Mysql.insertSQL(conn, SQL);
        }

        public void addDiaBloqueado(DiaBloqueado d) throws SQLException{          
           java.sql.Date sqlDate = new java.sql.Date(d.getDia().getTime());// convertir a DATE para SQL      
           SQL = "INSERT INTO diaBloqueados VALUES ('"+sqlDate+"','"+ d.getIdAgenda()+"');";
           Mysql.insertSQL(conn, SQL);

        }

       

}
