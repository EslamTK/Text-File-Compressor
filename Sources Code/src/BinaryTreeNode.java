/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author mohamed
 */
public class BinaryTreeNode {
   public Character key = null; 
   public String code = "";
   public BinaryTreeNode right;
   public BinaryTreeNode left ;
   public BinaryTreeNode(){
    
   }
   public BinaryTreeNode(Character key){
    this.key = key;
   }
   
   public boolean IsLeaf()
   {
       return left==null && right == null;
   }
}
