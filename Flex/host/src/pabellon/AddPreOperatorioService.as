//=======================================================================
// FECHA CREACIÓN:  14/10/2009
// AUTOR: Raúl López
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
	import transferObjects.Preoperatorio;


	public class AddPreOperatorioService extends RemoteObject
	{
		public function AddPreOperatorioService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddPreOperatorioService";
			this.source="Pabellon.AddPreOperatorioService";
			
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
			Alert.show("Error en AddPreOperatorioService, Detalle: "+event.fault.message);
		}
		
		
		/**
		 	 * 	@author  "Raúl López"
			 * 	@Fecha  14 Octubre
			 *  @Descripcion Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * 	@Param Recibe como parametro un objeto de la clase Preoperatorio, para enviarlo a la capa2. 		
			 * */
		public function AddPreOpe(preope:Preoperatorio):void
		{
			this.getOperation("addPreoperatorio").send(preope);
		}
	

	}
}