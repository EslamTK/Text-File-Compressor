


import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class Extract implements ExtractInterface 
{
    String Decomp;
    public BinaryTree buildTree(HashMap<Character, String> frec) {
        BinaryTree tree = new BinaryTree();
        int j = 0;
        /*for (Map.Entry<Character, String> entry : frec.entrySet()) {
            //if(j == 1 || j == 2)
               // continue;
            char key = entry.getKey();
            String code = entry.getValue();
            System.out.println(key + " " + code);
        }*/
        
        for (Map.Entry<Character, String> entry : frec.entrySet()) {
            
            char key = entry.getKey();
            
            String code = entry.getValue();
            //System.out.println(key + " " + code);
            BinaryTreeNode node = tree.root;
            for (int i = 0; i < code.length(); i++) {
                
                
                 
                /*
                 building the tree by the code of the chracters that we got from the file
                 "the hashMap"
                 */
                if (code.charAt(i) == '1') {
                    if (node.right == null) {
                        node.right = new BinaryTreeNode();
                        node = node.right;
                    } else {
                        node = node.right;
                    }
                } else if(code.charAt(i) == '0') {
                    if (node.left == null) {
                        node.left = new BinaryTreeNode();
                        node = node.left;
                    } else {
                        node = node.left;
                    }
                }
                if (i == code.length()-1) {
                    node.key = key;
                    //System.out.println(key+" "+code);
                    node.code = code;
                    node = tree.root;
                }
            }
            //System.out.println("--***---"+code);
        }
       //tree.print(tree.root);
        return tree;
    }

    @Override
    public void extractFile(String file, HashMap<Character, String> frequencyTable) {
        //System.out.println(file);
        BinaryTree charTree = buildTree(frequencyTable);  // building the huffman tree
        Decomp = "";
        BinaryTreeNode node = charTree.root;

        for (int i = 0; i < file.length(); i++) {
            if (file.charAt(i) == '0') {
                node = node.left;
            } else {
                node = node.right;
            }
            
            if (node.IsLeaf()) {
                //System.out.println(" ----- "+node.key+" --------");
                Decomp += Character.toString(node.key);                      // adding the actual value to the string
                node = charTree.root;
            }
        }
        //System.out.println(Decomp);
    }

    @Override
    public String getExtractedFile() 
    {
        return Decomp;
    }
}
