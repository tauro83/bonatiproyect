package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;	
	import transferObjects.Usuario;	
	import util.host;
	
	public class getUsuarioActualService extends RemoteObject
	{
		public function getUsuarioActualService() 
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf", host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="LoginService";
			this.source="Administracion.LoginService";
		}
		
		public function getUsuario(usuario:String, contrasena:String):void
	 	{
	 		this.getOperation("getUsuario").send(usuario,contrasena);
	 	} 

	}
	
}