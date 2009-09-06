package Bonati;

import java.sql.SQLException;
import java.util.ArrayList;


public class GestionarDatos {
    int i, num;
    String nombre;
    
    public GestionarDatos(){
        num=0;
        //      0 Administracion
	//	1 Agenda
	//	2 Pabellon
	//	3 Policlinico
	//	4 PetShop
	//	5 Peluqueria
	//	6 Hoteleria
	//	7 Buscar
	//	8 Usuario
    }
    public String seleccionServicio(String idBot, String idServ, String idPane, String inform) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException{
        int var = (int)Integer.parseInt(idServ);
        String infoReturn = "";

        System.out.println(inform);
        
        switch ( var ) {
            case 0:
                

//                Administracion a = new Administracion();
//                a.addUsuario("nico","peipa","secretarioXD",0,1);
                break;
           /* case 1:
                Agenda ag = new Agenda();
                infoReturn = ag.getInfo(String idBot, String idServ, String idPane, String inform);
                break;
            case 2:
                Pabellon pab = new Pabellon();
                infoReturn = pab.getInfo(String idBot, String idServ, String idPane, String inform);
                break;
            case 3:
                Policlinico pol = new Policlinico();
                infoReturn = pol.getInfo();
                break;
            case 4:
                PetShop ps = new PetShop();
                infoReturn = ps.getInfo(String idBot, String idServ, String idPane, String inform);
                break;
            case 5:
                Peluqueria pel = new Peluqueria();
                infoReturn = pel.getInfo(String idBot, String idServ, String idPane, String inform);
                break;
            case 6:
                Hoteleria hot = new Hotleria();
                infoReturn = hot.getInfo(String idBot, String idServ, String idPane, String inform);
                break;
            case 7:
                Buscar busca = new Buscar();
                infoReturn = busca.getInfo(String idBot, String idServ, String idPane, String inform);
                break;
            case 8:
                Usuario us = new Usuario();
                infoReturn = us.getInfo(String idBot, String idServ, String idPane, String inform);
                break;*/
            default:
                return "";
        }


        return infoReturn;
    }

    public String pruebaMetodo(String idBot, String idServ, String idPane, String inform) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        String infoRet="";
        String s[];
        int idServ2 = Integer.parseInt(idServ);


        if(idBot.equals("regRegUsu")){
            System.out.println("inform:"+inform);
            s = inform.split("&");
            Administracion a = new Administracion();
            a.addUsuario(s[0],s[1],s[2],Integer.parseInt(s[3]),Integer.parseInt(s[4]));


            
        }
        if(idServ2==0){
            // System.out.println("inform:"+inform);
            // System.out.println("hola mundo cruel");
        }
//        if(idServ2==0){
////            infoRet = inform;
//               /* Administracion a = new Administracion();
//                a.addUsuario("nico","peipa","secretarioXD",0,1);
//                * */
//             System.out.println("hola mundo cruel");
//        }
//        else{
//            if(idServ2==2){
//
//                System.out.println("hola mundo ql");
////
//                Administracion a = new Administracion();
//                a.addUsuario("nico233232","peipa","secretarioXD",0,1);
////                s = inform.split("&");
////                Administracion a = new Administracion();
////                a.addUsuario("nico","peipa","secretarioXD",0,1);
//
//
//            }
//            else{
//                return "no funcionooooo";
//            }
//        }

        return infoRet;
    }



}
