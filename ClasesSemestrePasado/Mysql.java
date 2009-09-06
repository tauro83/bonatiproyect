/*
Camilo Verdugo 2008
*/
package Bonati;

import java.sql.*;
import java.util.ArrayList;

public class Mysql {
    static Connection connect(String host, String user, String pasw,Connection conn) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
         try {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             conn = DriverManager.getConnection(host,user,pasw);
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

    static void disconnect(Connection conn) throws SQLException{
        conn.close();
    }

    static void insertSQL(Connection conn,String sql) throws SQLException{
        Statement s = conn.createStatement();
        s.execute(sql);
    }

	static ArrayList<String> selectSQL(Connection conn, String sql, int numColumnas) throws SQLException{
        try {
            ArrayList <String> data= new ArrayList();
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            numColumnas++;
                while (rs.next())
                {
                    for(int i=1;i<numColumnas;i++)
                    data.add(rs.getString(i));
                }
                return data;
        }
        catch(SQLException ex) {
            System.out.println("error de conexion3");
            return null;
        }
    }

}
