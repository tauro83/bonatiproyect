//=======================================================================
// Fecha Creaccion: 22/11/09
// AUTOR: Erwin Díaz
// Descripcion: Transfiere datos del tipo pago entre la capa lógica 
//				y la base de datos.
//=======================================================================

package TransferObjects;

import java.sql.Date;
import java.util.List;

public class Pago {
	
	public String fecha; //No deberia ir este atributo porque debe ser en tipo de dato Date
	public String hora;
	public int total;
	public Date fechaPago;
	public List detalle;
	
}
