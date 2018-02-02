

import java.util.HashMap;

public interface CompressInterface 
{
    public void compressFile(String File);
	public String getCompressedFile();
	public HashMap<Character,String> getEncodedTable();
}
