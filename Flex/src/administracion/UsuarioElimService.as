//=======================================================================
// FECHA CREACIÓN: 20/09/09
// AUTOR: Erwin Díaz 
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package administracion
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import transferObjects.UsuarioElim;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Erwin Díaz
	 */
	public class UsuarioElimService extends RemoteObject
	{
		public function UsuarioElimService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PersonService";
			this.source="Administracion.PersonService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en PersonService, Detalle: "+event.fault.message);
		}
		/**
		 * @param clave String que se le entrega a la acapa lógica para eliminar un usuario
		 */ 
		public function deleteUser(clave:String):void
		{
			this.getOperation("deleteUser").send(clave);
			
		}
		/**
		 * Se obtienen todos los usuarios que están registrados en la base de datos
		 */ 
		public function getAllUsuarios():void
		{
			this.getOperation("getAllUsers").send();
		}
		
	}
}