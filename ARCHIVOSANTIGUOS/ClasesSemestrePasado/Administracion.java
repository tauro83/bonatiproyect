package Bonati;

import java.sql.SQLException;
import java.util.ArrayList;

public class Administracion {

        private MantenerUsuario  mu;
        private MantenerAgenda ma ;
        private MantenerCita mc;

        public Administracion() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
            mu = new MantenerUsuario();
            ma = new MantenerAgenda();
            mc = new MantenerCita();
        }

	public ArrayList<String> getUsuarios(int numColumnas) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
           return mu.getUsuarios(numColumnas);
	}
	
	public void addUsuario(String nombre, String contraseña, String cargo, int privilegio, int idServicio) throws SQLException {
            mu.addUsuario(new Usuario(nombre,contraseña,cargo,privilegio,idServicio));
	}
	
	public void setUsuario(String nombre, String contraseña, String cargo, int privilegio, int idServicio) throws SQLException {
            mu.setUsuario(new Usuario(nombre,contraseña,cargo,privilegio,idServicio));
	}
	
	public void delUsuario(String nombre) throws SQLException {
            mu.purgUsuario(nombre);
	}

       
	public ArrayList<String> getAgendas(int numColumnas) throws SQLException {
            return ma.getAgendas(numColumnas);
	}
	
	public void addAgenda(Agenda a) throws SQLException {
            ma.addAgenda(a);
	}
	
	public void delAgenda(int id) throws SQLException {
            ma.purgAgenda(id);
	}
	
	public ArrayList<String> getCitas(int agendaId) throws SQLException {
            return mc.getCitas(agendaId);
	}
	
	public void addCita(Cita c) throws SQLException {
            mc.addCita(c);
	}
	
	public void delCita(int idCita) throws SQLException {
            mc.purgCita(idCita);
	}

        public void setCita( Cita c) throws SQLException{
            mc.setCita(c);
        }

        public void addDiaBloqueado(DiaBloqueado db) throws SQLException{
            ma.addDiaBloqueado(db);
        }


        public void delDiaBloqueado(int idDiaBloqueado) throws SQLException{
            ma.delDiaBloqueado(idDiaBloqueado);
        }

        /*
	public void getClientes() {
	
	}
	
	public void addCliente(Object Cliente c) {
	
	}
	
	public void delCliente(Object int rut) {
	
	}
	
	public void setCliente(Object Cliente c) {
	
	}
	
	public void getMascotas() {
	
	}
	
	public void addMascota(Object int rut, Object  Mascota m) {
	
	}
	
	public void delMacosta(Object int id) {
	
	}
	
	public void setMascota(Object Mascota m, Object int rut) {
	
	}
	
	public void getFichas() {
	
	}
	
	public void addFicha(Object Ficha f, Object int idMascota) {
	
	}
	
	public void setFicha(Object Ficha f, Object int idMascota) {
	
	}
	
	public void delFicha(Object int id) {
	
	}
	
	public void getAvisos() {
	
	}
	
	public void addAviso(Object Aviso a) {
	
	}
	
	public void delAviso(Object int id) {
	
	}
         */



         
        public static void main(String args[]) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
           

            Administracion a = new Administracion();
            a.addUsuario("niii","peipa","secretarioXD",0,1);
            //a.setUsuario("Narciso", "good", "Dueño De La Clinica",1, 1);
            int size =  a.getUsuarios(5).size();
            for(int i=0;i<size;i++){
                System.out.println(a.getUsuarios(5).get(i));
               
            }

         }
}
