package pabellon
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	
	import transferObjects.Preoperatorio;
	
	
	public class EditarPreOperatorioService extends RemoteObject
	{
			public function EditarPreOperatorioService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarPreOperatorioService";
			this.source="Pabellon.EditarPreOperatorioService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
			private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditarPreOperatorioService, Detalle: "+event.fault.message);
		}
		
			public function cargarPreOperatorios(rut:String):void
		{
			this.getOperation("cargarPreO").send(rut);
		}
		
		public function editarPreOperatorio(preoEdit:Preoperatorio, rut:String, fAntigua:String, hAntigua:String):void{
			this.getOperation("editarPreOperatorio").send(preoEdit, rut, fAntigua, hAntigua);
		}
	}
	
		
}