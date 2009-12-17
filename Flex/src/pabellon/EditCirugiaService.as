package pabellon
{
	
	//=======================================================================
	// FECHA CREACIÓN: 11 Octubre de 2009
	// AUTOR: Sebastian Arancibia
	// …. Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
	// Y la direccion en la cual esta levantado la capa 2.
	//=======================================================================

	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Cirugia;
	import transferObjects.Diagnostico;

	/**
	 * Clase Declara el canal, y los servicios a los cuales se estan enviando los datos.
	 * Y la direccion en la cual esta levantado la capa 2.
	 * @author Sebastian Arancibia
	 * @version 11/10/2009
	 * @langversion ActionScript 3.0
	*/

	public class EditCirugiaService extends RemoteObject
	{
		/**
		 *  Metodo Declara el canal, y los servicios a los cuales se estan enviando los datos.
		 *  Y la direccion en la cual esta levantado la capa 2.
	 	 * 	@author  Sebastian Arancibia	 		
		 * */
		public function EditCirugiaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="EditCirugiaService";
			this.source="Pabellon.EditCirugiaService";
			
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 *   Metodo que en caso de error, muestra en a traves de 
		 *  un popup, esto se debe a que estos son errores de sistema, por lo 
		 *  tanto es necesario informarlo de otra forma.
	 	 * 	@author  Sebastian Arancibia
	 	 * 	@param event Evento de posible error en comunicacion con capa 2	 		
		 * */
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en EditCirugiaService, Detalle: "+event.fault.message);
		}
		
		
		/**
		 * Metodo que envia a la capa 2, la cirugia que fue editada, 
		 * para almacenarlo en la base de datos. Llamando al metodo correspondiente.
	 	 * 	@author  Sebastian Arancibia
		 * 	@param cirugia Recibe como parametro un objeto de la clase Cirugia, para enviarlo a la capa 2. 		
		 * */
		public function updateCirugia(cirugia:Cirugia):void
		{
			this.getOperation("updateCirugia").send(cirugia);
		}
		
		/**
		 *  Metodo que solicita a la capa 2 los datos de todos las cirugias del sistema que
		 *  compartan los atributos enviados en el objeto, si tiene mas de un atributo, entonces 
		 *  las objetos retornados deben compartir ambos y asi sucesivamente.
	 	 * 	@author  Sebastian Arancibia
	 	 *  @param rutCliente Rut del cliente de las cirugias que se quiere retornar
	 	 *  @param nombreMascotas Nombre de la mascota de las cirgias que se quiere retornar
	 	 *  @param responsable Responsable de las cirugias que se quiere retornar
	 	 *  @param fecha Fecha de las cirugias que se quieren retornar
		 * */
		public function getCirugias(rutCliente:String, nombreMascota:String, responsable:String, fecha:String):void
		{
			this.getOperation("getCirugias").send(rutCliente, nombreMascota, responsable, fecha);
		}
		
		/**
		 * Metodo que solicita a la capa 2 los datos de todos los diagnosticos del sistema que
		 * compartan los atributos enviados  
		 * @author  "Sebastian Arancibia"
		 * @param rutCliente Rut del cliente de los diagnosticos que se quiere retornar
	 	 * @param nombreMascotas Nombre de la mascota de los diagnosticos que se quiere retornar
	 	 * @param hora Hora de los diagnosticos que se quiere retornar
	 	 * @param fecha Fecha de los diagnosticos que se quieren retornar
		 **/
		public function getDiagnosticos(rutCliente:String, nombreMascota:String, fecha:String, hora:String):void
		{
			this.getOperation("getDiagnosticos").send(rutCliente, nombreMascota, fecha, hora);
		}
		
		/**
		 *  Metodo que solicita a la capa 2 los datos de todos las cirugias del sistema que
		 *  compartan los atributos enviados en el objeto.	
	 	 * 	@author  Sebastian Arancibia
	 	 *  @param diagnostico Objeto de diagnosticos que se quiere agregar a la base de datos
		 * */
		public function addDiagnostico(diagnostico:Diagnostico):void
		{
			this.getOperation("addDiagnostico").send(diagnostico);
		}
		
	}
}