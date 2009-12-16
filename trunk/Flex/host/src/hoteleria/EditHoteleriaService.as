//=======================================================================
// FECHA CREACIÓN:  09/11/2009
// AUTOR: Sebastian Arancibia
// …. Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
// Y la direccion en la cual esta levantado la capa 2.
//=======================================================================

package hoteleria
{

	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Hoteleria;
		

	public class EditHoteleriaService extends RemoteObject
	{
		/**
		 * @author Sebastian Arancibia
		 * @version 10/09/2009
		 * Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
		 * Y la direccion en la cual esta levantado la capa 2.
		 * @langversion ActionScript 3.0
		*/
		public function EditHoteleriaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditHoteleriaService";
			this.source="Hoteleria.EditHoteleriaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		/**
		 *	@author  "Sebastian Arancibia"
		 * 	@version  09 Noviembre 2009
		 *	Metodo que en caso de error, muestra en a traves de 
		 *  un popup, esto se debe a que estos son errores de sistema, por lo 
		 *  tanto es necesario informarlo de otra forma.
		 *  @param event Evento producido por el error en la conexion	 		
		 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditHoteleriaService, Detalle: "+event.fault.message);
		}
		/**
	 	 * 	@author  "Sebastian Arancibia"
		 * 	@Fecha  09 Noviembre 2009
		 *  @Descripcion Metodo que envia a la capa 2, el registro de hoteleria que fue editado, 
		 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
		 * 	@Param hoteleria Recibe como parametro un objeto de la clase Hoteleria, para enviarlo a la capa2. 		
		 * */
		public function editarHoteleria(h:Hoteleria, fea:Date, fsa:Date, ca:int):void
		{
			this.getOperation("editarHoteleria").send(h, fea, fsa, ca);
		}

	}
}