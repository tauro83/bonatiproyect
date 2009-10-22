//=======================================================================
// FECHA CREACIÓN:  19/10/2009
// AUTOR: Andres Garrido
// Clase que conecta con capa 2
//======================================================================
package administracion{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	
	public class PurgMascota extends RemoteObject{
		
		public function PurgMascota(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PurgarMascota";
			this.source="Administracion.PurgarMascota";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
			
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en PurgarMascota, Detalle: "+event.fault.message);
		}
		public function purgMascota(rutCliente:String,nombre:String):void{
			this.getOperation("purgarMascota").send(rutCliente,nombre);
		}
	}
	
}