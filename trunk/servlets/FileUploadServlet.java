package servlets;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DBConnectionManager;
import dao.postgres.FileDB;

import TransferObjects.File;

/**
 * Servlet implementation class FileUpload
 */
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String pathFileUploads = "c:/fileUploaded";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		    int fileId = Integer.parseInt(request.getParameter("fileId"));
		   // FileInputStream input= new FileInputStream(pathFileUploads+"/"+fileName);
		  //  OutputStream output= response.getOutputStream();
		 //   byte buffer[]= new byte[1024];
		  //  while (input.read(buffer)!=-1) 
		  //  {
			//    output.write(buffer);
			//}
		    OutputStream output= response.getOutputStream();
		    Connection conn = DBConnectionManager.getConnection();
			FileDB fileDB= new FileDB(conn);
			File file =fileDB.getFile(fileId);
			conn.close();
		    output.write(file.getBytes());
		    output.flush();
		    output.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contentType = request.getContentType();
		if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) 
		{		
			/*obtenemos el string delimitador de las partes contenidas en el stream*/
			int lastIndex = contentType.lastIndexOf("=");
			String boundary = contentType.substring(lastIndex + 1,contentType.length());
			
			
			/*leo los bytes contenidos en el stream*/
			byte dataBytes[]= readInputStream(request);	
			
			PrintWriter writer= response.getWriter(); 
			

			System.out.println("Identifier:"+getParameter("Identifier",dataBytes, boundary));
			
			/*guardo los archivos recibidos*/
			//String result=saveFileContent(dataBytes,boundary);	
			String fileIds="";
			List<File> files = readFileContent(dataBytes, boundary);
			Iterator<File> i= files.iterator();
			while(i.hasNext())
			{
				fileIds=saveFileOnDB(i.next())+";";
			}
			//System.out.println(result);
			
			/*envio el esultado de la operacion*/
			writer.write(fileIds);
			writer.flush();
			writer.close();
		}
	}

	private List<File> readFileContent(byte dataBytes[],String boundary) 
	{ 
		//String result="";
		List<File> files=new ArrayList<File>();
		try
		{
			String dataString = new String(dataBytes);			
			/*obtengo cada parte del stream que viene delimitado por boundary*/
			String subDataString[]= dataString.split(boundary);
			
			int pos=0;
			String fileName;
			for(int i=0;i<subDataString.length;i++)
			{
				if(isContentFile(subDataString[i]))
				{
					/*obtengo el nombre del archivo*/
					fileName = subDataString[i].substring(subDataString[i].indexOf("filename=\"") + 10);
					fileName = fileName.substring(0, fileName.indexOf("\n"));
					fileName = fileName.substring(fileName.lastIndexOf("\\") + 1,fileName.indexOf("\""));
			
					/*obtengo el posicion donde comienza el i-ésimo archivo en dataStream*/					
					pos = dataString.indexOf("filename=\"",pos);			
					pos = dataString.indexOf("\n", pos) + 1;			
					pos = dataString.indexOf("\n", pos) + 1;			
					pos = dataString.indexOf("\n", pos) + 1;
			
					/*obtengo la posición inicial y la final del i-ésimo archivo en el stream*/
					int boundaryLocation = dataString.indexOf(boundary, pos) - 4;
					int startPos = ((dataString.substring(0, pos)).getBytes()).length;
					int endPos = ((dataString.substring(0, boundaryLocation)).getBytes()).length;
					
					File file= new File();
					file.setName(fileName);
					file.setBytes(getSubBytes(dataBytes, startPos, (endPos- startPos)));
					files.add(file);
					/*escribo el contenido del archivo en FileOutputStream*/
					
					//FileOutputStream fileOut = new FileOutputStream(pathFileUploads+"/"+fileName);			
					//fileOut.write(dataBytes, startPos, (endPos- startPos));
					//fileOut.flush();
					//fileOut.close();
			
					//result +="File saved as :" +pathFileUploads+"/"+fileName+"\n";
				}
			}	
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			//result=e.getMessage();
		}
		return files;
	}
	private byte[] getSubBytes(byte[] dataBytes, int startPos, int lenght) 
	{
		 byte[] bytes=new byte[lenght];
		 for(int i=0;i<lenght;++i)
		 {
			 bytes[i]=dataBytes[startPos+i];
		 }
		 return bytes;
	}
	/**
	 * @param file Es el archivo que contiene los bytes necesarios para guardar la imagen
	 * @return
	 */
	private int saveFileOnDB(File file)
	{
		int id=-1;
		try
		{
			Connection conn = DBConnectionManager.getConnection();
			FileDB fileDB= new FileDB(conn);
			id=fileDB.getNextVal();
			file.setFileId(id);
			fileDB.insertFile(file);
			conn.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return id;
	}
	private String saveFileOnPath(byte[] dataBytes,String fileName)
	{
		String result="";
		try
		{
			/*escribo el contenido del archivo en FileOutputStream*/
			FileOutputStream fileOut = new FileOutputStream(pathFileUploads+"/"+fileName);			
			fileOut.write(dataBytes, 0, dataBytes.length);
			fileOut.flush();
			fileOut.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			result=e.getMessage();
		}
		return result;
	}
    private String getParameter(String parameterName,byte dataBytes[],String boundary)
    {
		String value=null;
		try
		{
			String dataString = new String(dataBytes);			
			/*obtengo cada parte del stream que viene delimitado por boundary*/
			String subDataString[]= dataString.split(boundary);
			
			int pos=0;
			String name;
			String aux;
			for(int i=0;i<subDataString.length;i++)
			{
				if(isContentParameter(subDataString[i]))
				{
					/*obtengo el nombre del parametro*/
					aux = subDataString[i].substring(subDataString[i].indexOf("name=\"") + 6);
					name = aux.substring(0, aux.indexOf("\""));

					//System.out.println("name:"+name);
					if(name.equals(parameterName))
					{
						/*obtengo el nombre del valor*/
						aux = aux.substring(aux.indexOf("\n")+1);
						//System.out.println("["+aux+"]");
						aux = aux.substring(aux.indexOf("\n")+1);
						//System.out.println("["+aux+"]");
						value = aux.substring(0,aux.indexOf("\n")-1);
						//System.out.println("value:"+value);
						return value;
					}
				}
			}	
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return value;
    }
	private boolean isContentFile(String dataString) {
		if(dataString!=null && dataString.indexOf("filename=\"")>0)
			return true;
		return false;
	}
	private boolean isContentParameter(String dataString) {
		if(dataString!=null && dataString.indexOf("name=\"")>0&& dataString.indexOf("filename=\"")==-1)
			return true;
		return false;
	}

	private byte[] readInputStream(HttpServletRequest request) {
		
		byte dataBytes[] =new byte[0];
		try 
		{
			DataInputStream in = new DataInputStream(request.getInputStream());
			int formDataLength = request.getContentLength();
	
			dataBytes = new byte[formDataLength];
			int byteRead = 0;
			int totalBytesRead = 0;
			while (totalBytesRead < formDataLength) 
			{
				byteRead = in.read(dataBytes, totalBytesRead, formDataLength);				
				totalBytesRead += byteRead;
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return dataBytes;
	}

}
