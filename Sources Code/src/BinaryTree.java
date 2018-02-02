/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mohamed
 */

public class BinaryTree {
    BinaryTreeNode root = null;
    BinaryTree(){
        // default
        root = new BinaryTreeNode();
    }
    public BinaryTree(Character key){
        root = new BinaryTreeNode(key);
    }
    public boolean IsEmpty(){
        return root == null;
    }
    public void print(BinaryTreeNode node)
    {
        inOrder(node);
    }
    public void inOrder(BinaryTreeNode root) { 
        if(root != null) { 
            inOrder(root.left);
            //Visit the node by Printing the node data 
            System.out.println(root.key+"\t"+root.code); 
            inOrder(root.right); 
        } 
    }
}

