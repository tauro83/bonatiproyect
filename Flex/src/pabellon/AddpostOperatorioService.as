//=======================================================================
// FECHA CREACIÓN:  14/10/2009
// AUTOR: Cristian BRavo
// …. Clase que conecta con capa 2
//=======================================================================

package pabellon
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.PostOperatorio;


	public class AddpostOperatorioService extends RemoteObject
	{
		public function AddpostOperatorioService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="PostOperatorioService";
			this.source="Pabellon.PostOperatorioService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 	 * 	@author  "Raúl López"
			 * 	@Fecha  28 Septiembre
			 *  @Descripcion Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.		 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en AddPostOperatorioService, Detalle: "+event.fault.message);
		}
		
		public function AddPostOpe(postope:PostOperatorio):void
		{
			this.getOperation("AddPostOpe").send(postope);
		}
	

	}
}