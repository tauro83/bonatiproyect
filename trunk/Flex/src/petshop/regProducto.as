//=======================================================================
// FECHA: CREACIÓN: 23/11/09
// AUTOR: Camilo Verdugo
// Comentarios: Clase que establece la conexion con la capa logica y
//				realiza la accion de registrar un usuario
//=======================================================================

package petshop
{
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.remoting.mxml.RemoteObject;
	import transferObjects.Producto;
	import mx.rpc.events.FaultEvent;
	import mx.controls.Alert;
	
	/** 
	 *  Clase que gesitiona la conexion. Mediante el constructor
	 *  Se instancia la conexion con la capa logica , indicando los datos del servidor. 
	 * 	@author  "Camilo Verdugo"
	*/
	public class regProducto extends RemoteObject
	{
		/**
		 * Constructor de la clase
		 * @param amfChannel Indica la ruta del servidor Jboss
		 * @param destination indica el package el nombre del package en la capa logica.
		 * @param source indica el nombre de la clase de la capa logica seguida por el package
		 * */
		public function regProducto()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddProducto";
			this.source="Petshop.AddProducto";
			this.addEventListener(FaultEvent.FAULT,error);
		}
		
		private function error(event:FaultEvent):void{
			Alert.show("Error en AddProducto, Detalle: "+event.fault.message);
		}
		
		/**
		 * Envia un objeto un producto a la capa 2
		 * @param prod es una instancia del transferObject Producto, instanciado en la capa logica.
		 * */
		public function registrarProducto(prod:Producto):void
		{
			//this.getOperation("...").send(prod);
		}
	}
}