package BMC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author andres
 */
public class BD {

    /**
     * @param args the command line arguments
     */
    static String query;
    static PreparedStatement statement;

    public static ArrayList<ProductoVendido> getProductosVendidos() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection connection = DBConnectionManager.getConnection();
        ArrayList l = new ArrayList();
        ProductoVendido p;
        query= "SELECT * "+
        "FROM productoVendido;";
        statement = connection.prepareStatement(query);
        try{
            ResultSet result = statement.executeQuery();
            while(result.next()){
                p = new ProductoVendido();
                p.codigo = result.getString("codigo").trim();
                p.precio = Integer.parseInt(result.getString("precio").trim());
                p.unidades = Integer.parseInt(result.getString("unidades").trim());
                l.add(p);
            }
        }
    	catch (SQLException e){
            e.printStackTrace();
        }
        connection.close();
        return l;
    }

    public static boolean setProductosVendidos(ArrayList<ProductoVendido> lista) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection connection = DBConnectionManager.getConnection();
        boolean valor=true;
        int temp=0;
        query= "INSERT INTO productovendido(codigo, unidades, precio) VALUES (?, ?, ?);";
        


        statement = connection.prepareStatement(query);
        for(int i=0;i<lista.size();i++){
            ProductoVendido p = lista.get(i);
            statement.setString(1, p.codigo);
            statement.setInt(3, p.precio);
            statement.setInt(2, p.unidades);
            temp=statement.executeUpdate();
            //se asegura que todas las inserciones sean correctas
            if(temp==1 && valor)
                valor=true;
            else
                valor=false;
        }
        connection.close();
        return valor;
    }
    public static ArrayList<ProductoNuevo> getProductosNuevos() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection connection = DBConnectionManager.getConnection();
        ArrayList l = new ArrayList();
        ProductoNuevo p;
        query= "SELECT * "+
        "FROM producto;";
        statement = connection.prepareStatement(query);
        try{
            ResultSet result = statement.executeQuery();
            while(result.next()){
                p = new ProductoNuevo();
                p.codigo = result.getString("codigo").trim();
                //falta el campo departamento
                p.nombre = result.getString("nombre").trim();
                p.precio = Integer.parseInt(result.getString("precio").trim());
                l.add(p);
            }
        }
    	catch (SQLException e){
            e.printStackTrace();
        }
        connection.close();
        return l;
    }

    public static boolean setProductosNuevos(ArrayList<ProductoNuevo> lista) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection connection = DBConnectionManager.getConnection();
        boolean valor=true;
        int temp=0;
        query= "INSERT INTO producto(" +
                "nombre, precio,codigo)" +
                " VALUES (?,?,?);";

        statement = connection.prepareStatement(query);
        for(int i=0;i<lista.size();i++){
            ProductoNuevo p = lista.get(i);
            statement.setString(1, p.nombre);
            statement.setString(2, Integer.toString(p.precio));
            statement.setString(3, p.codigo);
            temp=statement.executeUpdate();
            if(temp==1 && valor)
                valor=true;
            else
                valor=false;
        }
        connection.close();
        return valor;
    }

    public static boolean existeProducto(ProductoNuevo pn) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection connection = DBConnectionManager.getConnection();
        ResultSet result = null;
        query= "SELECT *"+
        "FROM producto WHERE codigo=?;";

        statement = connection.prepareStatement(query);
        statement.setString(1, pn.codigo);
        try{
            result = statement.executeQuery();
	}
        catch (SQLException e){
            e.printStackTrace();

        }
        connection.close();
        if (result.next())
            return true;
        else
            return false;
    }
     
    public static boolean existeProductoVendido(ProductoVendido pv) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        Connection connection = DBConnectionManager.getConnection();
        ResultSet result = null;
        query= "SELECT *"+
        "FROM productoVendido WHERE codigo=? AND fecha=?;";

        statement = connection.prepareStatement(query);
        statement.setString(1, pv.codigo);
        statement.setDate(2, pv.fecha);
        try{
            result = statement.executeQuery();
	}
        catch (SQLException e){
            e.printStackTrace();

        }
        connection.close();
        if (result.next())
            return true;
        else
            return false;
    }
    
    public static boolean updateStock(ArrayList<ProductoStock> ps) throws InstantiationException, ClassNotFoundException, IllegalAccessException, SQLException{
        int result=0;
        boolean valor = true;
        Connection connection = DBConnectionManager.getConnection();
        for(int i=0;i<ps.size();i++){
            ProductoStock product = ps.get(i);
            query= "UPDATE producto "+
                "SET stock = ? " +
                "WHERE codigo = ?";

            statement = connection.prepareStatement(query);
            statement.setInt(1, product.stock);
            statement.setString(2, product.codigo.trim());
            try{
                result = statement.executeUpdate();
            }
            catch (SQLException e){
                //e.printStackTrace();
                return false;
            }
            //se asegura que la actualizacion es correcta;
            if(result==1 && valor)
                valor=true;
            else
                valor=false;
            
        }
        connection.close();
        return valor;
    }

    public static boolean logIn(String name, String pass) throws ClassNotFoundException, InstantiationException, InstantiationException, IllegalAccessException, SQLException{
        Connection connection = DBConnectionManager.getConnection();
        ResultSet result = null;
        query= "SELECT * "+
        "FROM usuario WHERE usuario=? AND contrasena=? AND (cargo='Cajero' OR cargo='Cajera');";

        statement = connection.prepareStatement(query);
        statement.setString(1, name);
        statement.setString(2, pass);
        try{
            result = statement.executeQuery();
	}
        catch (SQLException e){
            e.printStackTrace();

        }
        connection.close();
        if (result.next()){
            return true;
        }
        else{
            return false;
        }
    }
    public  void test() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // TODO code application logic here

        ArrayList<ProductoNuevo> prodNuevos = new ArrayList();
        ProductoNuevo pn = new ProductoNuevo();
        pn.codigo="000012";
        pn.nombre="collar pa perro2";
        pn.precio=3000;

        prodNuevos.add(pn);
        pn = new ProductoNuevo();
        pn.codigo="0000112";
        pn.nombre="alimento de loro xD";
        pn.precio=3000;
        boolean value=true;
        //value =setProductosNuevos(prodNuevos);
        if(value)
            System.out.println("OK");
        else
            System.out.println("WRONG");
        ProductoNuevo pn2 = new ProductoNuevo();
        pn2.codigo="000012";
        if(existeProducto(pn2))
            System.out.println("existe producto");
        else
            System.out.println("no existe producto");
        
        ArrayList<ProductoNuevo> lista = getProductosNuevos();
        for(int i=0;i<lista.size();i++){
            System.out.println(lista.get(i).codigo);
        }
        ArrayList<ProductoStock> lista2 = new ArrayList();
        ProductoStock ps = new ProductoStock();
        ps.codigo = "000012";
        ps.stock = 50;
        lista2.add(ps);
        ps = new ProductoStock();
        ps.codigo = "000012";
        ps.stock = 55;
        lista2.add(ps);
        boolean value2  = updateStock(lista2);

        if(value2){
            System.out.println("OK UPDATE");
        }
        else{
            System.out.println("WRONG UPDATE");
        }
    }
}
