//=======================================================================
// FECHA CREACIÓN: 10-11-09
// AUTOR: Esteban Cruz 
// Comentario: Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import transferObjects.CatPeluqueria;
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor "Esteban Cruz"
	 */
	public class CatalogoService extends RemoteObject
	{
		public function CatalogoService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AECatPeluqueriaService";
			this.source="Peluqueria.AECatPeluqueriaService";
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 * Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 * @autor "Esteban Cruz"
		 */ 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en CatPeluqueriaService, Detalle: "+event.fault.message);
		}
		/**
		 * Se anula un catalogo, cambiandole el estado a 2
		 * @autor "Esteban Cruz"
		 */ 
		public function anular(cata:CatPeluqueria):void
		{
			this.getOperation("anular").send(cata);
		}
		
		/**
		 * Se elimina un catalogo, cambiandole el estado a 1
		 * @autor "Esteban Cruz"
		 */ 
		public function eliminar(cata:CatPeluqueria):void
		{
			this.getOperation("eliminar").send(cata);
		}
		
		/**
		 * Se obtienen todos los catalogos que están registradas en la base de datos
		 * @autor "Esteban Cruz"
		 */ 
		public function getAllCatalogos():void
		{
			this.getOperation("getAllCatalogos").send();
		}
	}
}