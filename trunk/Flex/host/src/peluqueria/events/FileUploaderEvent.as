package peluqueria.events
{ 
	import flash.events.Event;

	public class FileUploaderEvent extends Event
	{
		public static const UPLOADED:String="uploaded";
		private var _fileIdUploaded:String="";
		public function FileUploaderEvent(type:String,_fileIdUploaded:String)
		{
			super(type);
			this._fileIdUploaded=_fileIdUploaded;
		}
		public function get fileIdUploaded():String
		{
			return _fileIdUploaded;
		}
	}
}