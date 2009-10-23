package services
{
	
	import mx.rpc.remoting.mxml.RemoteObject;
		
	public class Validaremail extends RemoteObject{	
		
		public function isEmail(string:String):Boolean{
 			
 			var regExp:RegExp = /^([\w\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			var result:Array = regExp.exec(string);

 			//Compruebo que exista una direccón de mail correcta en @string
 			if(!regExp.test(string))
  				return false;

 			//Compruebo que en el resultado no haya delante otros carácteres
 			if(result.index != 0)
  				return false;

 			//Compruebo que la dirección de mail encontrada sea igual a @string
 			if( ( String(result[0]).length != string.length ) )
  				return false;
 
 		return true;
}

}
}
