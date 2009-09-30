//=======================================================================
// FECHA CREACIÓN: Nicolas Delgado 
// AUTOR: 20/09/09
// Comentario: Este action Script contempla todos los paso para la creación 
//  de un cliente y poder ingresar los datos a la base de datos.
// 
//=======================================================================

package transferObjects
{
	
	[Bindable]
    [RemoteClass(alias="transferObjects.ClienteTO")]
 
 /**
* En esta clase van incorporados cada uno de los datos que posee el cliente 
* para hacer la transformacion a un objeto sin problemas. 
*
* @langversion ActionScript 3.0
*
* @author "Nicolas Delgado"
*/

	public class ClienteTO
	{
			 public var nombre:String;
			 public	var apellido:String;
			 public	var apellido2:String;
			 public	var rut:String;
			 public	var rut2:String;
			 public	var telefono:String;
			 public	var telefono2:String
			 public	var celular:String;
			 public	var celular2:String;
			 public	var direccion:String;
			 public	var region:String;
			 public	var comuna:String;
			 public	var email:String;
			 public	var email2:String;  
				
	}
}