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

	public class AddMascotaService extends RemoteObject{
		public function AddMascotaService(){
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf","http://localhost:8080/BonatiServer/messagebroker/amf");
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			
			this.destination="AddMascotaService";
			this.source="Administracion.AddMascotaService";	
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		private function faultHandler(event:FaultEvent):void{
			Alert.show("Error en AddMascotaService, Detalle: "+event.fault.message);
		}
		
		public function getCliente(rutCliente:String):void{
			this.getOperation("getCliente").send(rutCliente);
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