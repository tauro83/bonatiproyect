//=======================================================================
// FECHA CREACIÓN: 20/09/09 
// AUTOR: Nicolas Delgado
// Comentario: En este action scripts se encarga de hacer la conexion entre 
//             la capa 1 y 2 y poder lograr la insercion de los datos.
// 
//=======================================================================

package services
{
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	import transferObjects.Cliente;
	
	import util.host;
	
	
	/** 
	* Este metodo Clase se encarga de hacer la conexion xon la capa dos del sistema para poder hacer 
	* la insercion de los datos a la base de datos.  
	* 
	* @author  "Nicolas Delgado"
	*
	*/	 
	public class ClienteService extends RemoteObject
	{
		public function ClienteService(destination:String=null)
		{
			super(destination);
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddCliente";
			this.source="Administracion.AddCliente";	
			
			
			
		}
		
		/** 
		* Este metodo se encarga de de recibir los valores obtenidos en la interfaz del programa y pasarselos
		* a traves de un objeto a la capa 2 para que esta sea finalice pasandoselo a la capa 3 para que el cliente 
		* sea registrado en la base de datos.  
		* 
		* @author  "Nicolas Delgado"
		*
		*/	 		
		public function regCliente(user:Cliente, usuario:String):void{
			
		    this.getOperation("AddCliente").send(user, usuario);
		
		}
		
		public function consultarCli(user:Cliente):void
		{
			this.getOperation("ConsultarCli").send(user);
		}
		
	}
}
