package BMC;



public class ProductoNuevo {

    public String codigo;
    public String nombre;
    public int precio;
    public int departamento;

    
    public ProductoNuevo(){

    }

    @Override
    public String toString(){
        return "cod:"+codigo+" nom:"+nombre+" prec:"+precio+" dept:"+departamento;
    }
}
