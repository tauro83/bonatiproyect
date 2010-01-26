//=======================================================================
// FECHA CREACIÓN:  23/11/2009
// AUTOR: Raul Lopez
// Clase que conecta con capa 2
//=======================================================================

package peluqueria
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Peluqueria;


	public class EditarPeluService extends RemoteObject
	{
		public function EditarPeluService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditarPeluService";
			this.source="Peluqueria.EditarPeluService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 	 * 	Metodo que en caso de error, muestra en a traves de 
			 * un popup, esto se debe a que estos son errores de sistema, por lo 
			 * tanto es necesario informarlo de otra forma.
			 * @author  "Raul Lopez"		 		
			 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditarPeluService, Detalle: "+event.fault.message);
		}
		
		public function getServiciosAnteriores(responsable:String, fecha:Date,hora:String):void
		{
			this.getOperation("getServiciosAnteriores").send(responsable,fecha,hora);
		}
		
		/**
		 	 * Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * @author  "Raúl López"
			 * 	@Param Recibe como parametro un objeto de la clase Preoperatorio, para enviarlo a la capa2. 		
			 * */

		public function getAllPeluquerias(nombreMascota:String,rutillo:String):void
		{
			this.getOperation("getAllPeluquerias").send(nombreMascota, rutillo);
		}
		
		/**
		 	 * Metodo que envia a la capa 2, el usuario que fue editado, 
			 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
			 * @author  "Raúl López"
			 * 	@Param Recibe como parametro un objeto de la clase Preoperatorio, para enviarlo a la capa2. 		
			 * */

		public function editarPeluqueria(pelu:Peluqueria):void
		{
			this.getOperation("editarPeluqueria").send(pelu);
		}
        
	}
}