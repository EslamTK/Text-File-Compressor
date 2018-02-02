
import java.sql.Ref;
import java.util.ArrayList;
import java.util.Stack;

public class CreateTree {
	static Node root = null;
	 static String codedString = "";
	
	 static Node current;
	 static ArrayList<String> stringcode =new<String>ArrayList() ;

	public static void creatTree(Node []list,Node start ,Node end)
	{
		int x= list.length-1;
		while(x>0)
		{
			Node node = new Node(list[x-1].value+list[x].value, list[x-1].count+list[x].count);
			//ass node into tree
			node.right=list[x];
			node.left=list[x-1];
			list[x-1]=node;//add node to linked list
			end=list[x-1];//delete last two  nodes
			x--;
			//sort array linked list 
			
			for (int i = 0 ; i <x;i++)
			{
				for (int j =i+1;j<=x;j++)
				{
					if (list[j].count>list[i].count)
					{
						Node temp=list[i];
						list[i]=list[j];
						list[j]=temp;
					}
				}
			}
			end=list[x];
           
			
			
			
		}
		root=list[x];
		
		
	}
	 public static void PreorderTraversal()
	  {
	  PreorderHelper( root );
	  }
	 private static void PreorderHelper( Node node)
	  {
		
	  if ( node != null )
	  {
	 
	  System.out.println( node.value + " " );
	  
	  PreorderHelper( node.left );
	  
	PreorderHelper( node.right );
	  }
       
	}
 public static void code(String message) {
		 char[] messageArray = message.toCharArray();
		
			char checker;
		Node	node=root;
			
			for ( int x=0 ;x <messageArray.length;x++)
			{
				node=root;
				checker=messageArray[x];
				String code="";
				while(true)
				{
					String strlf = node.left.value;
					char []strlfarr=strlf.toCharArray();
					
					String res = "right";
					for(int i=0;i<strlfarr.length;i++ )
					{
						if(checker==strlfarr[i])
						{
							
							res="left";
							
                              
							break;

						}
					}
					

					if(res=="left")
					{
						node=node.left;
						if(node.left==null&&node.right==null)
						{
							code+='0';
							break;
						}
						code+='0';
						

					}
					else
					{
						node=node.right;
						if(node.left==null&&node.right==null)
						{
							code+='1';
							break;
						}
						code+='1';
						
					}
					
					
				}
				if(!stringcode.contains(code))
				{
				stringcode.add(checker+code);
				
				}

				codedString+=code;
			}
			}
	 
	
}
	



			