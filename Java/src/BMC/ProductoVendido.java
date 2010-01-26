package BMC;



import java.sql.Date;

public class ProductoVendido {
    public String codigo;
    public int unidades;
    public int precio;
    public Date fecha;

    public ProductoVendido()
    {
        
    }

    public String toString()
    {
        return "Cod:"+codigo+" Unid:"+unidades+" Precio:"+precio;
    }
}
