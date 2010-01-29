package dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import TransferObjects.File;

public class FileDB 
{
	PreparedStatement insert;
	PreparedStatement select;
	PreparedStatement nextval;
	
	public FileDB(Connection connection)
	{
		try 
		{
			String query="";			
			query = "INSERT INTO \"Files\"(\"FileId\", filename, size, bytes, mimetype) "+
					"VALUES (?, ?, ?, ?, ?);";			
			insert = connection.prepareStatement(query);
			
			query = "SELECT filename, size, bytes, mimetype "+
			"FROM \"Files\" "+
			"WHERE \"FileId\"=?";			
			select = connection.prepareStatement(query);
			
			query = "SELECT nextval('\"Files_FileId_seq\"');";			
			nextval = connection.prepareStatement(query);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	
    public int insertFile(File file)
    {
    	int result=0;
    	try 
    	{
			insert.setInt(1, file.getFileId());
			insert.setString(2, file.getName());
			insert.setInt(3, file.getSize());
			insert.setBytes(4, file.getBytes());
			insert.setString(5, file.getMimeType());
			result= insert.executeUpdate();
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return result;
    }
    public File getFile(int fileId)
    {
    	File file=new File();
    	try 
    	{
    		select.setInt(1, fileId);
    		ResultSet result = select.executeQuery();
    		if(result.next())
    		{
    			file.setFileId(fileId);
    			file.setName(result.getString(1));
    			file.setSize(result.getInt(2));
    			file.setBytes(result.getBytes(3));
    			file.setMimeType(result.getString(4));
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return file;
    }
    public int getNextVal()
    {
    	try 
    	{
    		ResultSet result = nextval.executeQuery();
    		if(result.next())
    		{
    			return result.getInt(1);
    		}
		} 
    	catch (SQLException e) 
    	{
			e.printStackTrace();
		}
    	return -1;
    }
}
