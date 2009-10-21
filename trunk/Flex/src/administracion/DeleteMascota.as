//=======================================================================
// FECHA CREACIÓN:  19/10/2009
// AUTOR: Andres Garrido
// Clase que conecta con capa 2
//=======================================================================

package administracion{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	public class DeleteMascota extends RemoteObject{
		
	
		public function DeleteMascota(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="DelMascota";
			this.source="Administracion.DelMascota";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
			
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DeleteMascota, Detalle: "+event.fault.message);
		}
		public function deleteMascota(rutCliente:String,nombre:String):void{
			this.getOperation("delMascota").send(rutCliente,nombre);
		}

	}
}