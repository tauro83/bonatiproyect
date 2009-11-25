// FECHA CREACIÓN: 22/11/09
// AUTOR: Raul Lopez  
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================
package petshop
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Raul Lopez  
	 */
	public class EliminarProductoService extends RemoteObject
	{
		public function EliminarProductoService()
		{
			
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EliminarProductoService";
			this.source="Petshop.EliminarProductoService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 * @autor Raul Lopez
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EliminarProductoService, Detalle: "+event.fault.message);
		}
		
		/**
		 * @param codigo String que se envia a la clase java, en la cual se elimina el producto que
		 * corresponda al su codigo id correspondiente
		 * @autor Raul Lopez
		 */ 
		public function eliminarProducto(codigo:String):void
		{
			this.getOperation("eliminarProducto").send(codigo);
		}
		
		/**
		 * Se obtienen todos los productos disponibles que están registrados en la base de datos
		 * @autor Raul Lopez
		 */ 
		public function getProductosActivos():void
		{
			this.getOperation("getProductosActivos").send();
		}

	}
}