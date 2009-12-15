//=======================================================================
// FECHA CREACIÓN: Nicolas Delgado 
// AUTOR: 20/09/09
// Comentario: Este action Script contempla la validacion de rut chileno, 
// desarrollado de una forma facil de entender e implementar.
// 
//=======================================================================

package services
{
	import mx.controls.Alert;
	import mx.messaging.ChannelSet;
	import mx.messaging.channels.AMFChannel;
	import mx.rpc.events.FaultEvent;
	import mx.rpc.remoting.mxml.RemoteObject;
	import mx.validators.ValidationResult;
	import mx.validators.Validator; 
	import mx.controls.Text;
	import flash.trace.Trace;
	import mx.messaging.AbstractConsumer;
	
	public class validarRut extends RemoteObject
    {
    	
			/**
			* Esta clase le entregamos como parametro el rut sin digito identificador y
			* Luego se inserta el codigo identificador que nos sirve para corroborar que el 
			* Rut sea el correcto.
			*
			* @author  "Nicolas Delgado"
			*
			* @param Numero numero.
			*
			* @param Numero identificador. 
			*
			* @example Valida_Rut("16789076", "5");
			*/
			public function Valida_Rut(Numero:String,Dv:String):String{
									
			var suma:int = 0;
			var rut:String = Numero;
			var NumMag:int = 2;
			var Resto:int = 0;
			
			var j:int ;
			var i:int;
			
			var DigVer:Array = new Array("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "K", "0");
			var ParteNumerica:Array = new Array();
			
			if (rut.length == 0) { 
				
				//return false; 
				
				}
			
			for ( j =0, i =0; j < rut.length; j++){
				if (rut.charAt(j) != ' ' && rut.charAt(j) != '.' && rut.charAt(j) != '-')
				{
					ParteNumerica[i] = rut.charAt(i);
					++i;
				}
			}
			
			for (i=ParteNumerica.length-1; i>=0; i--, NumMag++)
			{
				suma += ParteNumerica[i] * NumMag;
				trace(suma +' '+ ParteNumerica[i] +' '+ NumMag);
				if (NumMag>6){
					NumMag =1;	
				}	
			}
			
			Resto = 11-(suma%11);
			if(DigVer[Resto] != Dv.toUpperCase()){
				//Alert.show('Rut falso');
				return "Rut Incorrecto ingreselo otra vez";
			}else{
				//Alert.show('Rut valido');
				return "TRUE";
			}
			}	
    }
}
