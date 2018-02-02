
import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
	 static Node root;
	 static Node current;
	 static  Node node ; 
	 static String codedString = "";
	 static ArrayList<String> stringcode =new<String>ArrayList() ;
	
	 ///////////////////////////////////
	
	 public static void tree(Node start , Node end)
		{
			

/////////////////////////////////////////
			while(start.linker!=end)
			{
				//built tree
			node=new Node(end.linkerback.value+end.value,end.linkerback.count+ end.count);
				node.left=end.linkerback;
				node.right=end;
				//INSERT INO LINKED LIEST AND DELET LAST TOW
				end.linkerback.linkerback.linker = node;
				node.linkerback = end.linkerback.linkerback;
				end = node;
				end.linker = null;
				//end=end.linkerback.linkerback;
				//insertIntoList(node, start, end);
			}
				    node=new Node(start.value+end.value,start.count+end.count);
					node.left=start;
					node.right=end;
					node.linker=null;
					node.linkerback=null;
					root=node;
			}
			
		
	 
	 ////////////////////////////////////
	 public static void PreorderTraversal()
	  {
	  PreorderHelper( root );
	  }
	 private static void PreorderHelper( Node node )
	  {
	  if ( node == null )
	  return;
		
	  
	  System.out.println( node.value + " " );
	  PreorderHelper( node.left );

	
	PreorderHelper( node.right );
	}
	 public static void insertIntoList(Node node ,Node start ,Node end)
	 {
		 Node q=start;
		 while(start!=end)
		 {
			 if(q==end)
			 {
				 if(end.count>node.count)
				 {
					 end.linker=node;
					 node.linkerback=end;
					 end=node;
					 end.linker=null;
					
				 }
				 else
				 {
					 node.linker=end;
					 node.linkerback=end.linkerback;
					 end.linkerback.linker=node;
					 end.linkerback=node;
					 end.linker=null;
					
				 }
				 return;
			 }
			 if(node.count>q.count)
			 {
				 if(q==start)
				 {
					 Node temp=start;
					 start=node;
					 node.linker=temp;
					 temp.linkerback=start;
					 
					
					 
				 }
				 else
				 {
					 node.linker=q;
					 node.linkerback=q.linkerback;
					 q.linkerback.linker=node;
					 q.linkerback=node;
					 
				 }
				 return;
				 
				 
			 }
			
			
			 q=q.linker;
		 }
		if(start.count>node.count)
		{
			end=node;
			start.linker=node;
			node.linkerback=start;
			
		}
		else
		{
			Node temp=start;
			start=node;
			start.linker=temp;
			end=temp;
			end.linkerback=node;
			end.linker=null;
			
		}
		 
	 }
	 public static void code(String message,ArrayList<Character>characters,int[]countOfChar) {
		 char[] messageArray = message.toCharArray();
			char checker;
            
			for (int i = 0; i < messageArray.length; i++) {
				current = node;
				checker = messageArray[i];
				
				String code = "";
				while (true) {
					if (current.left.value.toCharArray()[0] == checker) {
						
						
						code += "0";
						break;
					} else {
						code += "1";
						if (current.right != null) {
							if (current.right.value.toCharArray()[0] == characters
									.get(countOfChar.length - 1)) {
								break;
							}
							current = current.right;
						} else {
							break;
						}
					}
				}
				if(!stringcode.contains(code))
				{
				stringcode.add(checker+code);
				
				}
				codedString += code;
				
			}
			System.out.println();
		}
public static String returncode()
{
	return codedString;
	}
	}
	 
		
	

