
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.sql.Date;

public class RegistroHoteleria extends Servicio {
	private Date fechaEntrada;
	private int idMascota;
	private Date fechaSalida;
	private String comentarios;
	private ArrayList <Servicio> serviciosPedidos;

    public RegistroHoteleria(int id){
        this.setId(id);
        this.comentarios = new String();
        this.serviciosPedidos = new ArrayList();
    }

	public Date getHoraEntrada() {
        return this.fechaEntrada;
	}
	
	public Date getHoraSalida() {
        return this.fechaSalida;
	}
	
	public String getComentarios() {
        return this.comentarios;
	}
	
	public void setHoraEntrada(java.util.Date e) {
        this.fechaEntrada =new java.sql.Date(e.getTime());
	}
	
	public void setHoraSalida(java.util.Date e) {
        this.fechaSalida = new java.sql.Date(e.getTime());
	}
	
	public void addServicio(Servicio s) {
        this.serviciosPedidos.add(s);
	}
	
	public void delServicio(Servicio s) {
        for(int i=0;i<serviciosPedidos.size();i++){
            if(serviciosPedidos.get(i).getId()==s.getId())
                serviciosPedidos.remove(i);
        }
    }
	
    public ArrayList <Servicio> getServiciosPedidos() {
        return this.serviciosPedidos;
    }

    public int getIdMascota(){
        return this.idMascota;
    }

    public void addComentario(String s){
        this.comentarios=this.comentarios.concat(s).concat("\n");

    }

    public void setIdMascota(int id){
        this.idMascota = id;
    }
    public void registrar() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        String SQL="";

        String host="db4free.net";
        String user="bonatiii";
        String pass="bonatiii";
        String port="3306";
        String bd="bonatiii";
        Connection conn = null;
        Statement s;
        conn = (Connection) Mysql.connect("jdbc:mysql://"+host+":"+port+"/"+bd,user,pass,conn);
        s = (Statement) conn.createStatement();

        int idHospedar = this.getId();
        Date fechaEntrada = this.fechaEntrada;
        Date fechaSalida = this.fechaSalida;
        String comentario = this.comentarios;
        int idMascota = this.idMascota;
        SQL = "INSERT INTO `Hospedar` VALUES ('"+idHospedar+"','"+ fechaEntrada+"','"+fechaSalida+"','"+ comentario+"','"+ idMascota+"');";
        //SQL = "INSERT INTO Usuario VALUES ('NarcisoRQL','peipa','secretario','1','1');";
        Mysql.insertSQL(conn, SQL);
}
}
