//=======================================================================
// FECHA: CREACIÓN: 26 Octubre
// AUTOR: Nicolas Delgado
// Comentarios: Clase que establece la conexion con la capa logica y
//				realiza la accion de registrar una Consulta.
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import util.host;
	import transferObjects.Consulta;
	
	public class AddConsultaService extends RemoteObject
	{
		
		/**
		 *Corresponde al constructor de la componente registrar una consulta que se encarga de pasar los objetos
		 *obtenido en ella componente y se encarga de pasarle estos objetos a la capa 2. 
		 **/
		public function AddConsultaService()
		{
			super();
			var channel:ChannelSet=new ChannelSet();http:
			var amfChannel:AMFChannel=new AMFChannel("my-amf",host.getUrl());
			channel.addChannel(amfChannel);
			this.channelSet=channel;
			this.destination="AddConsultaService";
			this.source="Administracion.AddConsultaService";	
			this.addEventListener(FaultEvent.FAULT,faultHandler);
		}
		
		/**
		 *Este metodo se encarga de mencionar los posibles errores que podrian ocurrir en el sistema a 
		 *causa de esta componente y se encarga de mostrarselo al usuario atraves de pop up para que sea 
		 *visible para el usuario. 
		 **/
		private function faultHandler(event:FaultEvent):void
		{
			Alert.show("Error en consultaService, Detalle: "+event.fault.message);
		}
		
		/**
		 *Este metodo se encarga de enviar los datos de un registro de una atencion de consulta a 
		 *la capa logica para que esta se encargue de ingresarla a la base de datos. 
		 **/
		
		public function AddConsulta(consulta:Consulta):void
		{
			this.getOperation("addConsulta").send(consulta);
		}
		
		/**
		 *Este metodo se encarga de obtener un arreglo con todos los clientes que se encuentran en base 
		 *de datos con el rut ingresado en la componente registrar consulta y deacuerdo a este realiza un 
		 *filtro hasta encontrar al cliente buscado. 
		 **/
		 		
		public function getCliente(rutCliente:String):void
		{
			this.getOperation("getCliente").send(rutCliente);
		}
		
		/**
		 *Este metodo se encarga de obtener un arreglo con todas las mascotas del cliente asociado anteriormente
		 *para luego ser seleccionada y poder pasar al registro de una consulta. 
		 **/	

		public function getMascotas(rutCliente:String):void{
			this.getOperation("getMascotas").send(rutCliente);
		}
		

	}
}