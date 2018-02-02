

import java.io.DataOutputStream;
import java.io.*;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class FileWriter {

    public void write(String encodedFile, HashMap<Character, String> encodedTable, String path, String password) throws IOException {
        File file = new File(path + ".comp");
        file.createNewFile();
        ObjectOutputStream objectOutput = new ObjectOutputStream( new FileOutputStream(file));
        
        if (password.isEmpty()) {
            objectOutput.writeBoolean(false);
        } else {
            objectOutput.writeBoolean(true);
            int hash = 0;
            for (int i = 0, j = 3; i < password.length(); i++, j += j - 2) {
                hash += (int) password.charAt(i) + j;
            }
            hash %= 99993;
            objectOutput.writeShort(hash);
        }
        objectOutput.writeObject(convertToBitSet(encodedFile));
        int i = 0;
        objectOutput.writeShort(encodedTable.size());
        for (Map.Entry<Character, String> entry : encodedTable.entrySet()) {
            Character character = entry.getKey();
            String string = entry.getValue();
            if(!password.isEmpty())
            {
            if (i >= password.length()) {
                i = 0;
            }
            objectOutput.writeShort(((int) character + (int) password.charAt(i)) + 13);
            }
            else objectOutput.writeShort(((int) character ) + 13);
            objectOutput.writeObject(convertToBitSet(string));
        }
        objectOutput.close();
    }
    private BitSet convertToBitSet(String str)
    {
        BitSet bitSet = new BitSet(str.length()+1);
        for(int i=0;i<str.length();++i)
        {
            if(str.charAt(i)=='1') bitSet.set(i);
            else bitSet.clear(i);
        }
        bitSet.set(str.length());
        return bitSet;
    }
}
