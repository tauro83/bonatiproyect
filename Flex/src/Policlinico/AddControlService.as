//=======================================================================
// FECHA CREACIÓN:  27/10/2009
// AUTOR: Sebastian Arancibia
// …. Clase que conecta con capa 2
//=======================================================================

package Policlinico
{
	import mx.collections.ArrayCollection;
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;

	public class AddControlService extends RemoteObject
	{
		public function AddControlService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddControlService";
			this.source="Policlinico.AddControlService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 	 * 	@author  "Sebastian Arancibia"
			 * 	@Fecha  27 octubre
			 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.		 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en AddControlService, Detalle: "+event.fault.message);
		}
		
		
		/**
		 	 * 	@author  "Sebastian Arancibia"
			 * 	@Fecha  27 Octubre
			 *  @Descripcion Metodo que envia a la capa 2, el control que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Control, para enviarlo a la capa2. 		
			 * */
		public function addControl(control:Control):void
		{
			this.getOperation("addControl").send(control);
		}
	}
}