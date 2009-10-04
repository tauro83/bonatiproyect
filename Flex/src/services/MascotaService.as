//=======================================================================
// FECHA CREACIÓN:  10/09/2009
// AUTOR: Sebastian Arancibia
// …. Clase que conecta con capa 2
//=======================================================================


package services{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import transferObjects.Mascota;

	public class MascotaService extends RemoteObject{
		public function MascotaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/DBConnectionServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddMascota";
			this.source="MantenerMascota.AddMascota";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en AddMascota, Detalle: "+event.fault.message);
		}
		
		public function addMascota(mascota:Mascota):void{
			this.getOperation("addMascota").send(mascota);
		}
		
		public function getAllMascotas():void{
			this.getOperation("getAllMascotas").send();
		}
		
		public function getMascotas(rutCliente:String):void{
			this.getOperation("getMascotas").send(rutCliente);
		}
	}
}