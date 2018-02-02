
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
public class Compress implements CompressInterface {
  
  static String stringcode;
  static  HashMap<Character, String> hash;
  static Node [] arrlist ;
  static Node start=null;
  static Node end=null;
  
	@Override
	public  void compressFile(String File) {
		// TODO Auto-generated method stub
		
		String s =File;
		System.out.println(s);
		char[] arrs=s.toCharArray();//devided string to charachters
		ArrayList<Character> chars=new<Character> ArrayList();//characters without Repetition
		ArrayList<Character> charss=new<Character> ArrayList();//characters without Repetition

		for (int x=0; x<s.length();x++)
		{
			if(!chars.contains(arrs[x]))
			{
				chars.add(arrs[x]);
				charss.add(arrs[x]);

			}
		}
		int [] count = new int [chars.size()];// number of characters repetition
		for (int x=0 ; x<chars.size();x++)
		{
			for ( int i =0 ; i <arrs.length ;i++)
			{
				char test = chars.get(x);
				if(test == arrs[i])
				{
					count[x]=count[x]+1;
				}
			}
		}
		
		
		
		//sorting for count  and chars
		
		for(int x=0;x<(count.length)-1;x++)
		{
			for(int y =x+1;y<count.length;y++)
			{
				if(count[x]<count[y])
				{
					int a=count[x];
					count[x]=count[y];
					count[y]=a;
					char b=chars.get(x);
					chars.set(x, chars.get(y));
					chars.set(y, b);
					
					
					
				}
				
					}
			
		}
		System.out.println("******************");
		for(int x= chars.size()-1 ;x>=0;x--)
		{
		System.out.println(chars.get(x)+"= "+count[x]);
		}
		System.out.println("******************");
		
			//built linked list with array
			start =null;
			end=null;
			arrlist = new Node[chars.size()];
			for (int x =0 ; x < chars.size();x++)
			{
				Node node=new Node(chars.get(x).toString(), count[x]);
				if(start==null)
				{
					arrlist[x]=node;
					start=arrlist[x];
				}
				else
				{
					arrlist[x]=node;
					
					
				}
				end=arrlist[x];
				
			}
			
			System.out.println("linked list with array is : ");			
			for(int x=0;  x<arrlist.length;x++)
			{
				
				System.out.println(arrlist[x].value + "= "+arrlist[x].count);
			
			}
			//built tree
			CreateTree tree=new CreateTree();
			tree.creatTree(arrlist, start, end);
			System.out.println("******************\n"+"tree is :");
			tree.PreorderTraversal();
			tree.code(s);
			System.out.println("codedstring is \n"+tree.codedString );
			///insert into hashmap
			
			hash=new HashMap<Character,String>();
			
			for(int x=0;x<chars.size();x++)
			{
				String input = "";
				char checker1 = chars.get(x);
				for(int y=0;y<tree.stringcode.size();y++)
				{
					
					char checker2=tree.stringcode.get(y).toCharArray()[0];
					if(checker1==checker2)
					{
						input=tree.stringcode.get(y);
						break;
					}
					
				}
				String input2  ="";
				char [] i=input.toCharArray();
				for(int y=1;y<i.length;y++)
				{
					input2+=i[y];
				}
				System.out.println(checker1+"="+input2);
				hash.put(chars.get(x),input2);
			}
			
			System.out.println("hashmap is : "+hash);
			stringcode = tree.codedString;


	}

	@Override
	public String getCompressedFile() {
		// TODO Auto-generated method stub
		return stringcode;
	}

	@Override
	public HashMap<Character, String> getEncodedTable() {
		// TODO Auto-generated method stub
		return hash;
	}
	// display linked list
	
	}

