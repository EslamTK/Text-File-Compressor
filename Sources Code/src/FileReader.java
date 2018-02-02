

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.BitSet;
import java.util.HashMap;

public class FileReader {

    String EncodedFile = "";
    HashMap<Character, String> encodedTable = new HashMap<>();

    public boolean isPasswordProtected(File file) throws Exception {
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file));
        return objectInput.readBoolean();
    }

    public boolean isPasswordCorrect(File file, String password) throws Exception {
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file));
        objectInput.readBoolean();
        int hash = 0;
        for (int i = 0, j = 3; i < password.length(); i++, j += j - 2) {
            hash += (int) password.charAt(i) + j;
        }
        hash %= 99993;
        return hash == Integer.valueOf(objectInput.readShort());
    }

    public void read(File file, String password) throws Exception {
        ObjectInputStream objectInput = new ObjectInputStream(new FileInputStream(file));
        if(objectInput.readBoolean()) objectInput.readShort();
        
        EncodedFile = convertToString((BitSet)objectInput.readObject());
        
        int i = 0;
        int size = objectInput.readShort();
        while (size > 0) 
        {
            char c;
            if (!password.isEmpty()) {
                if (i >= password.length()) {
                    i = 0;
                }
                c = (char) (objectInput.readShort() - (int) password.charAt(i) - 13);
            } else {
                c = (char) (objectInput.readShort() - 13);
            }
            encodedTable.put(c, convertToString((BitSet)objectInput.readObject()));
            --size;
        }
    }

    public String getEncodedFile() {
        return EncodedFile;
    }

    public HashMap<Character, String> getEncodedTable() {
        return encodedTable;
    }
    
    private String convertToString(BitSet bitSet)
    {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<bitSet.length()-1;++i)
        {
            str.append((bitSet.get(i)==true?'1':'0'));
        }
        return str.toString();
    }
}
