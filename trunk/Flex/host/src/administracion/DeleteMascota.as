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
	import util.host;
	
	public class DeleteMascota extends RemoteObject{
		
	
		public function DeleteMascota(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="DelMascota";
			this.source="Administracion.DelMascota";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
			
		}
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en DeleteMascota, Detalle: "+event.fault.message);
		}
		public function deleteMascota(rutCliente:String,nombre:String,status:Boolean):void{
			this.getOperation("delMascota").send(rutCliente,nombre, status);
		}

	}
}