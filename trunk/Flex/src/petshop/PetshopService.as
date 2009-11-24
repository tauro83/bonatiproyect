//=======================================================================
// FECHA CREACIÓN: 08/11/09
// AUTOR: Erwin Díaz 
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
	 * @autor Erwin Díaz
	 */
	public class PetshopService extends RemoteObject
	{
		public function PetshopService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PetshopService";
			this.source="Petshop.PetshopService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 * @autor Erwin Díaz
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en PetshopService, Detalle: "+event.fault.message);
		}
		/**
		 * Se registra un producto en la base de datos, especificamente el 
		 * la tabla producto
		 * @autor Erwin Díaz
		 */ 
		public function regProducto(prod:Producto):void
		{
			this.getOperation("regProducto").send(prod);
		}
		
	}
}