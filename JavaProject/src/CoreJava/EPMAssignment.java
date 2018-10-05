package CoreJava;

import java.util.ArrayList;
import java.util.HashSet;

public class EPMAssignment {

	public static void main(String[] args) 
	{
		ArrayList<String> mylist=new ArrayList<String>();
		mylist.add("vipul");
		mylist.add("Rahul");
		mylist.add("vikas");
		mylist.add("amol");
		mylist.add("vipul");
		mylist.add("amol");
/*		
		HashSet<String> myset=new HashSet<String>();
		for(String myelement:mylist )
		{
			
			myset.add(myelement);
			
		}

        if(mylist.size()==myset.size())
        {
        	System.out.println("list does not contain duplicate element");
        }
        else
        {
        	System.out.println("list does contained duplicate element");
        	
        }
 */    
		ArrayList<String> mylisttemp=new ArrayList<String>();
		mylisttemp.addAll(mylist);
		System.out.println(mylisttemp);
	

	
      for(int i=0; i<mylist.size(); i++)
      {
    	  int count=0;
    	  for(int j=0; j<mylisttemp.size();j++)
    	  {
    		  if( mylist.get(i).equals(mylisttemp.get(j)) )
    		{
    			  count=count+1;
    		}
    	  }
    	  
    	  if(count>1)
    	  {
    		  System.out.println(mylist.get(i)+" is duplicate element");
    		  
    	  }
    	  
    	  
      }

		
	}

}
