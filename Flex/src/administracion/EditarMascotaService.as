//=======================================================================
// FECHA CREACIÓN: 12/09/2009
// AUTOR: Cristian Bravo 
// Clase que se encarga de realizar la conexion entre la capa
// lógica y la interfaz
//=======================================================================


package administracion
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	
	import transferObjects.Mascota;
	
	/**
	 * Clase encargada de realizar la conexión entre la capa
	 * lógica y la interfaz gráfica
	 * @autor Cristian Bravo
	 */
	 
	public class EditarMascotaService extends RemoteObject
	{
		public function EditarMascotaService()
		{
		
		    super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarMascotaService";
			this.source="Administracion.EditarMascotaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		
		}
		
		/**
		 * @param event Evento recogido en caso de una falla en la llamada hacia la capa lógica
		 */
		 
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditarMascotaService, Detalle: "+event.fault.message);
		}
		
			
		/**
		 * Se inserta un nuevo objeto de mascota en la base de datos
		 */ 
		
		public function insertMascotaE(person:Mascota, usuario:String):void
		{
			this.getOperation("insertMascotaE").send(person, usuario);
		}

			
		/**
		 * Se obtienen todos las mascotas que están registrados en la base de datos
		 */ 
		
		public function getAllMascotasE():void
		{
			this.getOperation("getAllMascotasE").send();
		}
			
		/**
		 * Se obtienen todos las mascotas asociadas a un cliente que están registrados en la base de datos
		 */ 
		
		public function getMascota(rut:String):void
		{
			this.getOperation("getMascota").send(rut);
		}

	}
}